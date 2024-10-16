import java.util.Arrays;

public class zadanie2 {
    public static void main(String[] args) {
        ArrayGenerate arrayGenerator = new ArrayGenerate();
        int[] array = arrayGenerator.generateRandomArray();
        int maxCount = findMaxCount(array);
        System.out.println("Максимальное количество одинаковых элементов: " + maxCount);
    }

    public static int findMaxCount(int[] array) {
        Arrays.sort(array);
        int maxCount = 1;
        int currentCount = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
                currentCount = 1;
            }
        }
        if (currentCount > maxCount) {
            maxCount = currentCount;
        }
        return maxCount;
    }
}
