public class zadanie1 {
    public static void main(String[] args) {
        ArrayGenerate arrayGenerator = new ArrayGenerate();
        int[] array = arrayGenerator.generateRandomArray();
        System.out.println("Четные числа в порядке возрастания индекса:");
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println("\nНечетные числа в порядке убывания индекса:");
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 != 0) {
                System.out.print(array[i] + " ");
            }
        }
    }
}