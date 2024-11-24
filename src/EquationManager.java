import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class EquationManager<T extends Equation> {
    private final List<T> equations;
    private final Set<T> uniqueEquations;
/* В данном случае я только добавляю два уравнения и не произвожу частых операций вставки/удаления,
поэтому использование ArrayList вполне оправдано. Даже если я расширю программу и добавлю возможность записи большого количества уравнений
использование LinkedList будет избыточным. Считаю, что лучше оставить ArrayList
*/
    public EquationManager() {
        equations = new ArrayList<>();
        uniqueEquations = new HashSet<>();
    }

    public void addEquation(T equation) {
        if (uniqueEquations.add(equation)) {
            equations.add(equation);
        } else {
            System.out.println("Уравнение уже существует: ");
        }
    }
    public int getEquationCount() {
        return equations.size();
    }

    public void solveAll() {
        for (T equation : equations) {
            System.out.println(equation.toString());
        }
    }
}