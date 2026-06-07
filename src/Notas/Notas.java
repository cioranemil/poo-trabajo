package Notas;

public class Notas {
    double[] listaNotas;

    // Constructor: Instancia un arreglo para almacenar exactamente 5 notas
    public Notas() {
        listaNotas = new double[5];
    }

    // Calcula el promedio aritmético de las notas ingresadas
    double calcularPromedio() {
        double suma = 0;
        for (int i = 0; i < listaNotas.length; i++) {
            suma += listaNotas[i];
        }
        return suma / listaNotas.length;
    }

    // Calcula la desviación estándar poblacional de las notas
    double calcularDesviacion() {
        double prom = calcularPromedio();
        double suma = 0;
        for (int i = 0; i < listaNotas.length; i++) {
            suma += Math.pow(listaNotas[i] - prom, 2);
        }
        return Math.sqrt(suma / listaNotas.length);
    }

    // Determina la menor nota dentro del arreglo
    double calcularMenor() {
        double menor = listaNotas[0];
        for (int i = 1; i < listaNotas.length; i++) {
            if (listaNotas[i] < menor) {
                menor = listaNotas[i];
            }
        }
        return menor;
    }

    // Determina la mayor nota dentro del arreglo
    double calcularMayor() {
        double mayor = listaNotas[0];
        for (int i = 1; i < listaNotas.length; i++) {
            if (listaNotas[i] > mayor) {
                mayor = listaNotas[i];
            }
        }
        return mayor;
    }
}
