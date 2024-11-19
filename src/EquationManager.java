import java.util.ArrayList;
import java.util.List;

class EquationManager<T extends Equation> {
    private final List<T> equations;

    public EquationManager() {
        equations = new ArrayList<>();
    }

    public void addEquation(T equation) {
        equations.add(equation);
    }

    public void solveAll() {
        for (T equation : equations) {
            System.out.println(equation.toString());
        }
    }
}