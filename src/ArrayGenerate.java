import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayGenerate {
    public int[] generateRandomArray() {
        Scanner scanner = new Scanner(System.in);
        int size = 0;
        while (true) {
            System.out.print("Введите число от 1 до 30: ");
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                if (size >= 1 && size <= 30) {
                    break;
                } else {
                    System.out.println("Ошибка: число должно быть от 1 до 30.");
                }
            } else {
                System.out.println("Ошибка: введите целое число");
                scanner.next();
            }
        }
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(20);
        }
        System.out.println("Сгенерированный массив: " + Arrays.toString(array));
        return array;
    }
}