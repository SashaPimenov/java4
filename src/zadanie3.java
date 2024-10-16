import java.util.Arrays;
import java.util.Scanner;

public class zadanie3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива N: ");
        int N = scanner.nextInt();

        double[] A = new double[N];
        System.out.println("Введите элементы массива A:");
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextDouble();
        }

        double[] B = new double[N];

        for (int k = 0; k < N; k++) {
            if (A[k] < 5) {
                B[k] = 2 * A[k];
            } else {
                B[k] = A[k] / 2;
            }
        }

        System.out.println("Сгенерированный массив: " + Arrays.toString(B));
        scanner.close();
    }
}
