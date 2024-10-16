import java.util.Scanner;

public class zadanie4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк: ");
        int M = scanner.nextInt();
        System.out.print("Введите количество столбцов: ");
        int N = scanner.nextInt();

        int[][] matrix = new int[M][N];

        for (int j = 0; j < N; j++) {
            int value = 5 * (j + 1);
            for (int i = 0; i < M; i++) {
                matrix[i][j] = value;
            }
        }

        System.out.println("Сформированная матрица:");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        scanner.close();
    }
}