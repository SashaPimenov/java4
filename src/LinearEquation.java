class LinearEquation extends Equation {
    private final double a;
    private final double b;

    public LinearEquation(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    String getSolution() {
        if (a == 0 && b == 0) {
            return "Уравнение имеет бесконечное количество решений.";
        } else {
            return "Уравнение имеет одно решение: x = " + (b / a);
        }
    }

    @Override
    public String toString() {
        return "Решение линейного уравнения: " + getSolution();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LinearEquation other = (LinearEquation) obj;
        return a == other.a && b == other.b;
    }
}