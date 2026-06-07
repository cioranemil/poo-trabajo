package Figuras;

public class Piramide extends FiguraGeometrica {
    private double base;
    private double altura;
    private double apotema;

    public Piramide(double base, double altura, double apotema) {
        this.base = base;
        this.altura = altura;
        this.apotema = apotema;
        setVolumen((Math.pow(base, 2.0) * altura) / 3.0);
        setSuperficie(Math.pow(base, 2.0) + (2.0 * base * apotema));
    }
}
