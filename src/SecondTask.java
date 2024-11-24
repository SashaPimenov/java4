import java.util.InputMismatchException;
import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        boolean exit = false;

        while (!exit) {
            menu.showMainMenu();
            int choice = menu.getMenuChoice();

            switch (choice) {
                case 1:
                    try {
                        calculateSolution(scanner);
                    } catch (InvalidCoefficientException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 2:
                    menu.showProgramInfo();
                    break;
                case 3:
                    menu.showDeveloperInfo();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Выход из программы...");
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте еще раз.");
            }
        }
    }

    private static void calculateSolution(Scanner scanner) throws InvalidCoefficientException {
        EquationManager<Equation> manager = new EquationManager<>();
        String input;
        while (true) {
            scanner.nextLine();
            System.out.println("Выберите пункт меню уравнений: ");
            System.out.println("1 - ввести уравнения,");
            System.out.println("2 - рассчитать уравнения,");
            System.out.println("3 - завершение");

            input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    System.out.println("Квадратное уравнение ax^2 + bx + c = 0.");
                    double a = getValidInput(scanner, true, "Введите коэффициент a (не должен быть равен 0): ");
                    double b = getValidInput(scanner, false, "Введите коэффициент b: ");
                    double c = getValidInput(scanner, false, "Введите коэффициент c: ");
                    manager.addEquation(new QuadraticEquation(a, b, c));

                    System.out.println("Линейное уравнение ax + b = 0.");
                    double aLinear = getValidInput(scanner, true, "Введите коэффициент a (не должен быть равен 0): ");
                    double bLinear = getValidInput(scanner, false, "Введите коэффициент b: ");
                    manager.addEquation(new LinearEquation(aLinear, bLinear));
                    break;
                case "2":
                    if (manager.getEquationCount() > 0) {
                        manager.solveAll();
                    } else {
                        System.out.println("Нет введенных уравнений для расчета.");
                        break;
                    }
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Некорректный ввод. Пожалуйста, введите 1, 2 или 3.");
            }
        }
    }

    private static int getValidInput(Scanner scanner, boolean isA, String prompt) throws InvalidCoefficientException {
        System.out.println(prompt);
        while (true) {
            try {
                int value = scanner.nextInt();
                if (!isA || value != 0) {
                    return value;
                } else {
                    throw new InvalidCoefficientException("Коэффициент a не может быть равен 0.");
                }
            } catch (InputMismatchException e) {
                System.out.print("Некорректный ввод. Пожалуйста, введите целое число: ");
                scanner.next();
            }
        }
    }
}
