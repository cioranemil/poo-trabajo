package Figuras;

public class Prisma extends FiguraGeometrica {
    private double base;
    private double altura;
    private double profundidad;

    public Prisma(double base, double altura, double profundidad) {
        this.base = base;
        this.altura = altura;
        this.profundidad = profundidad;
        setVolumen(base * altura * profundidad);
        setSuperficie(2.0 * (base * altura + base * profundidad + altura * profundidad));
    }
}
