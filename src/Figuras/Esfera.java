package Figuras;

public class Esfera extends FiguraGeometrica {
    private double radio;

    public Esfera(double radio) {
        this.radio = radio;
        setVolumen((4.0 / 3.0) * Math.PI * Math.pow(radio, 3.0));
        setSuperficie(4.0 * Math.PI * Math.pow(radio, 2.0));
    }
}
