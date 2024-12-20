class LinearEquation extends Equation implements Solvable, Comparable<LinearEquation>, Cloneable {
    private final double a;
    private final double b;

    public LinearEquation(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String getSolution() {
        if (a == 0 && b == 0) {
            return "Уравнение имеет бесконечное количество решений.";
        } else {
            return "Уравнение имеет одно решение: x = " + (b / a);
        }
    }

    @Override
    public String toString() {
        return String.format("Решение линейного уравнения %.1fx^2 + %.1f: %s", this.a, this.b, getSolution());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LinearEquation other = (LinearEquation) obj;
        return a == other.a && b == other.b;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.hashCode(a);
        result = 31 * result + Double.hashCode(b);
        return result;
    }



    @Override
    public int compareTo(LinearEquation other) {
        return Double.compare(this.a, other.a);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}