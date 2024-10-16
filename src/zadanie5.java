import java.util.Scanner;

public class zadanie5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            showMainMenu();
            int choice = getMenuChoice(scanner);

            switch (choice) {
                case 1:
                    calculateDiscriminant(scanner);
                    break;
                case 2:
                    showProgramInfo();
                    break;
                case 3:
                    showDeveloperInfo();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Выход из программы...");
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте еще раз.");
            }
        }
        scanner.close();
    }

    private static void showMainMenu() {
        System.out.println("\nГлавное меню:");
        System.out.println("1. Выполнить расчет дискриминанта");
        System.out.println("2. Информация о программе");
        System.out.println("3. Информация о разработчике");
        System.out.println("4. Выход из программы");
        System.out.print("Выберите пункт меню: ");
    }

    private static int getMenuChoice(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.print("Некорректный ввод. Пожалуйста, введите номер пункта: ");
                scanner.next();
            }
        }
    }

    private static void calculateDiscriminant(Scanner scanner) {
        System.out.println("Эта программа вычисляет дискриминант квадратного уравнения ax^2 + bx + c = 0.");
        double[] coefficients = new double[3];

        coefficients[0] = getValidInput(scanner, true, "Введите коэффициент a (не должен быть равен 0): ");
        coefficients[1] = getValidInput(scanner, false, "Введите коэффициент b: ");
        coefficients[2] = getValidInput(scanner, false, "Введите коэффициент c: ");

        double discriminant = calculateDiscriminant(coefficients);
        System.out.println("Дискриминант D = " + discriminant);

        if (discriminant > 0) {
            System.out.println("Уравнение имеет два различных корня.");
        } else if (discriminant == 0) {
            System.out.println("Уравнение имеет один корень.");
        } else {
            System.out.println("Уравнение не имеет действительных корней.");
        }
    }

    private static double calculateDiscriminant(double[] coefficients) {
        double b = coefficients[1];
        double a = coefficients[0];
        double c = coefficients[2];
        return b * b - 4 * a * c;
    }

    private static double getValidInput(Scanner scanner, boolean isA, String prompt) {
        while (true) {
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                if (!isA || value != 0) {
                    return value;
                } else {
                    System.out.print("Коэффициент a не может быть равен 0. Попробуйте еще раз: ");
                }
            } else {
                System.out.print("Некорректный ввод. Пожалуйста, введите число: ");
                scanner.next();
            }
        }
    }

    private static void showProgramInfo() {
        System.out.println("Эта программа вычисляет дискриминант квадратного уравнения.");
    }

    private static void showDeveloperInfo() {
        System.out.println("Разработчик: Пименов Александр Алексеевич, РИМ-140970");
    }
}
