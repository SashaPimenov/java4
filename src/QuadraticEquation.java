class QuadraticEquation extends Equation implements Solvable, Comparable<QuadraticEquation>, Cloneable {
    private final double a;
    private final double b;
    private final double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String getSolution() {
        double discriminant = calculateDiscriminant();
        if (discriminant > 0) {
            return calculateTwoRoots(discriminant);
        } else if (discriminant == 0) {
            return calculateOneRoot();
        } else {
            return "Уравнение не имеет действительных корней";
        }
    }

    private double calculateDiscriminant() {
        return b * b - 4 * a * c;
    }

    private String calculateTwoRoots(double discriminant) {
        double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        return "Уравнение имеет два различных корня: " + root1 + " и " + root2;
    }

    private String calculateOneRoot() {
        double root = -b / (2 * a);
        return "Уравнение имеет один корень: " + root;
    }

    @Override
    public String toString() {
        return "Решение квадратного уравнения: " + getSolution();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuadraticEquation other = (QuadraticEquation) obj;
        return a == other.a && b == other.b && c == other.c;
    }

    @Override
    public int compareTo(QuadraticEquation other) {
        return Double.compare(this.a, other.a);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}