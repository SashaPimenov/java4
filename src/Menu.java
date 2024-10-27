import java.util.Scanner;

class Menu {
    private final Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showMainMenu() {
        System.out.println("\nГлавное меню:");
        System.out.println("1. Выполнить расчет решения");
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
                System.out.print("Некорректный ввод, введите номер пункта: ");
                scanner.next();
            }
        }
    }

    public void showProgramInfo() {
        System.out.println("Эта программа вычисляет решение квадратного и линейного уравнений.");
    }

    public void showDeveloperInfo() {
        System.out.println("Разработчик: Пименов Александр Алексеевич, РИМ-140970");
    }
}