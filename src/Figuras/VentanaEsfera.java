package Figuras;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaEsfera extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radio, volumen, superficie;
    private JTextField campoRadio;
    private JButton calcular;
    private PanelGrafico panelGrafico; // Para dibujar la esfera

    public VentanaEsfera() {
        contenedor = getContentPane();
        contenedor.setLayout(null);
        contenedor.setBackground(new Color(245, 250, 255));
        setTitle("Esfera");
        setSize(500, 240); // Más ancha para gráfico
        setLocationRelativeTo(null);
        setResizable(false);

        Font fuenteBase = new Font("Verdana", Font.PLAIN, 12);
        Font fuenteRes = new Font("Verdana", Font.BOLD, 12);

        radio = new JLabel("Radio (cms):"); radio.setFont(fuenteBase); radio.setBounds(20, 30, 135, 23);
        campoRadio = new JTextField(); campoRadio.setBounds(120, 30, 100, 23);

        calcular = new JButton("Calcular"); 
        calcular.setBounds(120, 70, 100, 25);
        calcular.setBackground(new Color(70, 130, 180));
        calcular.setForeground(Color.WHITE);
        calcular.setFocusPainted(false);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm3):"); volumen.setFont(fuenteRes); volumen.setBounds(20, 130, 230, 23);
        superficie = new JLabel("Superficie (cm2):"); superficie.setFont(fuenteRes); superficie.setBounds(20, 160, 230, 23);

        panelGrafico = new PanelGrafico();
        panelGrafico.setBounds(250, 15, 200, 170);

        contenedor.add(radio); contenedor.add(campoRadio);
        contenedor.add(calcular); contenedor.add(volumen); contenedor.add(superficie);
        contenedor.add(panelGrafico);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        try {
            double r = Double.parseDouble(campoRadio.getText());
            Esfera esfera = new Esfera(r);
            volumen.setText("Volumen (cm3): " + String.format("%.2f", esfera.getVolumen()));
            superficie.setText("Superficie (cm2): " + String.format("%.2f", esfera.getSuperficie()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Campo nulo o error de formato",
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Clase interna para el dibujo con Graphics 2D
    private class PanelGrafico extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Sombreado radial para simular una esfera 3D
            RadialGradientPaint paint = new RadialGradientPaint(
                    new Point(80, 50), 70,
                    new float[]{0.0f, 1.0f},
                    new Color[]{new Color(250, 200, 250), new Color(150, 80, 150)}
            );
            
            g2.setPaint(paint);
            g2.fillOval(30, 20, 140, 140);
            
            // Borde
            g2.setColor(Color.DARK_GRAY);
            g2.setStroke(new BasicStroke(2));
            g2.drawOval(30, 20, 140, 140);
        }
    }
}
