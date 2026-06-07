package Notas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel nota1, nota2, nota3, nota4, nota5, promedio, desviacion, mayor, menor;
    private JTextField campoNota1, campoNota2, campoNota3, campoNota4, campoNota5;
    private JButton calcular, limpiar;

    public VentanaPrincipal() {
        inicio();
        setTitle("Notas - Actividad 3");
        setSize(320, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);
        contenedor.setBackground(new Color(250, 250, 255));

        Font fuenteBase = new Font("SansSerif", Font.PLAIN, 13);
        Font fuenteRes = new Font("SansSerif", Font.BOLD, 13);

        nota1 = new JLabel("Nota 1:"); nota1.setFont(fuenteBase); nota1.setBounds(30, 30, 135, 23);
        campoNota1 = new JTextField(); campoNota1.setBounds(120, 30, 135, 23);

        nota2 = new JLabel("Nota 2:"); nota2.setFont(fuenteBase); nota2.setBounds(30, 60, 135, 23);
        campoNota2 = new JTextField(); campoNota2.setBounds(120, 60, 135, 23);

        nota3 = new JLabel("Nota 3:"); nota3.setFont(fuenteBase); nota3.setBounds(30, 90, 135, 23);
        campoNota3 = new JTextField(); campoNota3.setBounds(120, 90, 135, 23);

        nota4 = new JLabel("Nota 4:"); nota4.setFont(fuenteBase); nota4.setBounds(30, 120, 135, 23);
        campoNota4 = new JTextField(); campoNota4.setBounds(120, 120, 135, 23);

        nota5 = new JLabel("Nota 5:"); nota5.setFont(fuenteBase); nota5.setBounds(30, 150, 135, 23);
        campoNota5 = new JTextField(); campoNota5.setBounds(120, 150, 135, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(30, 190, 110, 30);
        calcular.setBackground(new Color(70, 130, 180));
        calcular.setForeground(Color.WHITE);
        calcular.setFont(fuenteRes);
        calcular.setFocusPainted(false);
        calcular.addActionListener(this);

        limpiar = new JButton("Limpiar");
        limpiar.setBounds(150, 190, 105, 30);
        limpiar.setBackground(new Color(200, 70, 70));
        limpiar.setForeground(Color.WHITE);
        limpiar.setFont(fuenteRes);
        limpiar.setFocusPainted(false);
        limpiar.addActionListener(this);

        promedio = new JLabel("Promedio = "); 
        promedio.setFont(fuenteRes); promedio.setForeground(new Color(0, 100, 0));
        promedio.setBounds(30, 240, 250, 23);
        
        desviacion = new JLabel("Desviación estándar = "); 
        desviacion.setFont(fuenteRes);
        desviacion.setBounds(30, 270, 250, 23);
        
        mayor = new JLabel("Valor mayor = "); 
        mayor.setFont(fuenteRes); mayor.setForeground(new Color(0, 0, 150));
        mayor.setBounds(30, 300, 250, 23);
        
        menor = new JLabel("Valor menor = "); 
        menor.setFont(fuenteRes); menor.setForeground(new Color(150, 0, 0));
        menor.setBounds(30, 330, 250, 23);

        contenedor.add(nota1); contenedor.add(campoNota1);
        contenedor.add(nota2); contenedor.add(campoNota2);
        contenedor.add(nota3); contenedor.add(campoNota3);
        contenedor.add(nota4); contenedor.add(campoNota4);
        contenedor.add(nota5); contenedor.add(campoNota5);
        contenedor.add(calcular); contenedor.add(limpiar);
        contenedor.add(promedio); contenedor.add(desviacion);
        contenedor.add(mayor); contenedor.add(menor);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) {
            if (campoNota1.getText().trim().isEmpty() ||
                campoNota2.getText().trim().isEmpty() ||
                campoNota3.getText().trim().isEmpty() ||
                campoNota4.getText().trim().isEmpty() ||
                campoNota5.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe rellenar las 5 notas obligatoriamente.",
                                              "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                Notas notas = new Notas();
                notas.listaNotas[0] = Double.parseDouble(campoNota1.getText());
                notas.listaNotas[1] = Double.parseDouble(campoNota2.getText());
                notas.listaNotas[2] = Double.parseDouble(campoNota3.getText());
                notas.listaNotas[3] = Double.parseDouble(campoNota4.getText());
                notas.listaNotas[4] = Double.parseDouble(campoNota5.getText());

                promedio.setText("Promedio = " + String.format("%.2f", notas.calcularPromedio()));
                desviacion.setText("Desviación estándar = " + String.format("%.2f", notas.calcularDesviacion()));
                mayor.setText("Valor mayor = " + notas.calcularMayor());
                menor.setText("Valor menor = " + notas.calcularMenor());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: Ingrese valores numéricos válidos.",
                                              "Error de Formato", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (evento.getSource() == limpiar) {
            campoNota1.setText(""); campoNota2.setText("");
            campoNota3.setText(""); campoNota4.setText("");
            campoNota5.setText("");
            promedio.setText("Promedio = ");
            desviacion.setText("Desviación estándar = ");
            mayor.setText("Valor mayor = ");
            menor.setText("Valor menor = ");
        }
    }
}
