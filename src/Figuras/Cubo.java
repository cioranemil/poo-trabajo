package Figuras;

public class Cubo extends FiguraGeometrica {
    private double lado;

    public Cubo(double lado) {
        this.lado = lado;
        setVolumen(Math.pow(lado, 3.0));
        setSuperficie(6.0 * Math.pow(lado, 2.0));
    }
}
