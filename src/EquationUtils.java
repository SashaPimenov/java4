import java.util.List;

class EquationUtils {
    public static <T extends Equation> void printSolutions(List<T> equations) {
        for (T equation : equations) {
            System.out.println(equation.toString());
        }
    }
}