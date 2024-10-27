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
                    calculateSolution(scanner);
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

    private static void calculateSolution(Scanner scanner) {
        System.out.println("Выберите тип уравнения:");
        System.out.println("1 - квадратное уравнение");
        System.out.println("любое другое число - линейное уравнение");
        System.out.print("Введите номер: ");

        int type = getValidInput(scanner, false, "Введите номер типа уравнения: ");
        Equation[] equations = new Equation[2];

        if (type == 1) {
            System.out.println("Эта программа вычисляет решение квадратного уравнения ax^2 + bx + c = 0.");

            double a = getValidInput(scanner, true, "Введите коэффициент a (не должен быть равен 0): ");
            double b = getValidInput(scanner, false, "Введите коэффициент b: ");
            double c = getValidInput(scanner, false, "Введите коэффициент c: ");

            equations[0] = new QuadraticEquation(a, b, c);

        } else {
            System.out.println("Эта программа вычисляет решение линейного уравнения ax + b = 0.");

            double a = getValidInput(scanner, true, "Введите коэффициент a (не должен быть равен 0): ");
            double b = getValidInput(scanner, false, "Введите коэффициент b: ");

            equations[0] = new LinearEquation(a, b);
        }

        System.out.println(equations[0]);
    }

    private static int getValidInput(Scanner scanner, boolean isA, String prompt) {
        System.out.println(prompt);
        while (true) {
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (!isA || value != 0) {
                    return value;
                } else {
                    System.out.print("Коэффициент a не может быть равен 0. Попробуйте еще раз: ");
                }
            } else {
                System.out.print("Некорректный ввод. Пожалуйста, введите целое число: ");
                scanner.next();
            }
        }
    }
}