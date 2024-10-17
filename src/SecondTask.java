import java.util.Scanner;

class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calculateDiscriminant() {
        return b * b - 4 * a * c;
    }

    public String getRoots() {
        double discriminant = calculateDiscriminant();
        if (discriminant > 0) {
            return "Уравнение имеет два различных корня.";
        } else if (discriminant == 0) {
            return "Уравнение имеет один корень.";
        } else {
            return "Уравнение не имеет действительных корней.";
        }
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}

class Menu {
    private Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showMainMenu() {
        System.out.println("\nГлавное меню:");
        System.out.println("1. Выполнить расчет дискриминанта");
        System.out.println("2. Информация о программе");
        System.out.println("3. Информация о разработчике");
        System.out.println("4. Выход из программы");
        System.out.print("Выберите пункт меню: ");
    }

    public int getMenuChoice() {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.print("Некорректный ввод. Пожалуйста, введите номер пункта: ");
                scanner.next();
            }
        }
    }

    public void showProgramInfo() {
        System.out.println("Эта программа вычисляет дискриминант квадратного уравнения.");
    }

    public void showDeveloperInfo() {
        System.out.println("Разработчик: Пименов Александр Алексеевич, РИМ-140970");
    }
}

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
                    calculateDiscriminant(scanner);
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
        scanner.close();
    }

    private static void calculateDiscriminant(Scanner scanner) {
        System.out.println("Эта программа вычисляет дискриминант квадратного уравнения ax^2 + bx + c = 0.");

        double a = getValidInput(scanner, true, "Введите коэффициент a (не должен быть равен 0): ");
        double b = getValidInput(scanner, false, "Введите коэффициент b: ");
        double c = getValidInput(scanner, false, "Введите коэффициент c: ");

        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        double discriminant = equation.calculateDiscriminant();
        System.out.println("Дискриминант D = " + discriminant);
        System.out.println(equation.getRoots());
    }

    private static double getValidInput(Scanner scanner, boolean isA, String prompt) {
        while (true) {
            System.out.print(prompt);
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
}
