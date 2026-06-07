package Figuras;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JButton cilindro, esfera, piramide;
    private JLabel titulo;

    public VentanaPrincipal() {
        contenedor = getContentPane();
        contenedor.setLayout(null);
        contenedor.setBackground(new Color(245, 245, 250));
        
        setTitle("Figuras Geométricas");
        setSize(350, 160);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Font fuenteBtn = new Font("Tahoma", Font.BOLD, 12);

        titulo = new JLabel("Cálculo de Volumen y Superficie");
        titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
        titulo.setForeground(new Color(50, 50, 100));
        titulo.setBounds(80, 15, 250, 25);

        cilindro = new JButton("Cilindro"); 
        cilindro.setBounds(20, 60, 100, 35);
        cilindro.setBackground(new Color(150, 200, 200));
        cilindro.setFont(fuenteBtn);
        cilindro.addActionListener(this);

        esfera = new JButton("Esfera"); 
        esfera.setBounds(140, 60, 100, 35);
        esfera.setBackground(new Color(200, 150, 200));
        esfera.setFont(fuenteBtn);
        esfera.addActionListener(this);

        piramide = new JButton("Pirámide"); 
        piramide.setBounds(260, 60, 100, 35);
        piramide.setBackground(new Color(200, 200, 150));
        piramide.setFont(fuenteBtn);
        piramide.addActionListener(this);

        contenedor.add(titulo);
        contenedor.add(cilindro); 
        contenedor.add(esfera); 
        contenedor.add(piramide);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == esfera) {
            new VentanaEsfera().setVisible(true);
        }
        if (evento.getSource() == cilindro) {
            new VentanaCilindro().setVisible(true);
        }
        if (evento.getSource() == piramide) {
            new VentanaPiramide().setVisible(true);
        }
    }
}
