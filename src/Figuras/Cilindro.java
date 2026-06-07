package Figuras;

public class Cilindro extends FiguraGeometrica {
    private double radio;
    private double altura;

    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
        setVolumen(Math.PI * altura * Math.pow(radio, 2.0));
        setSuperficie((2.0 * Math.PI * radio * altura) + (2.0 * Math.PI * Math.pow(radio, 2.0)));
    }
}
