public class Vector {
    private final double startX;
    private final double startY;
    private final double endX;
    private final double endY;

    public Vector(double startX, double startY, double endX, double endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public double[] getCoordinates() {
        return new double[]{endX - startX, endY - startY};
    }

    public Vector add(Vector other) {
        double newEndX = this.endX + (other.endX - other.startX);
        double newEndY = this.endY + (other.endY - other.startY);
        return new Vector(this.startX, this.startY, newEndX, newEndY);
    }

    public double multiplyByVector(Vector other) {
        double[] thisCoords = this.getCoordinates();
        double[] otherCoords = other.getCoordinates();
        return thisCoords[0] * otherCoords[0] + thisCoords[1] * otherCoords[1];
    }

    public Vector multiplyByScalar(double scalar) {
        double[] coords = this.getCoordinates();
        return new Vector(this.startX, this.startY,
                this.startX + coords[0] * scalar,
                this.startY + coords[1] * scalar);
    }

    public double length() {
        double[] coords = this.getCoordinates();
        return Math.sqrt(coords[0] * coords[0] + coords[1] * coords[1]);
    }

    @Override
    public String toString() {
        return "(" + startX + ", " + startY + "), (" + endX + ", " + endY + ")";
    }

    public static void main(String[] args) {
        Vector vector1 = new Vector(0, 0, 3, 4);
        Vector vector2 = new Vector(1, 2, 4, 6);

        System.out.println("Вектор 1: " + vector1);
        System.out.println("Вектор 2: " + vector2);

        Vector sum = vector1.add(vector2);
        System.out.println("Сумма: " + sum);

        double dotProduct = vector1.multiplyByVector(vector2);
        System.out.println("Скалярное произведение двух векторов: " + dotProduct);

        Vector scaled = vector2.multiplyByScalar(2);
        System.out.println("Умножение вектора 2 на скаляр: " + scaled);

        double lengthV1 = vector1.length();
        System.out.println("Длина вектора 1: " + lengthV1);
    }
}