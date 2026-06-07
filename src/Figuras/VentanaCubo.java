package Figuras;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaCubo extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel lado, volumen, superficie;
    private JTextField campoLado;
    private JButton calcular;
    private PanelGrafico panelGrafico;

    public VentanaCubo() {
        contenedor = getContentPane();
        contenedor.setLayout(null);
        contenedor.setBackground(new Color(255, 250, 240));
        setTitle("Cubo");
        setSize(500, 240); 
        setLocationRelativeTo(null);
        setResizable(false);

        Font fuenteBase = new Font("Verdana", Font.PLAIN, 12);
        Font fuenteRes = new Font("Verdana", Font.BOLD, 12);

        lado = new JLabel("Lado (cms):"); lado.setFont(fuenteBase); lado.setBounds(20, 30, 135, 23);
        campoLado = new JTextField(); campoLado.setBounds(120, 30, 100, 23);

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

        contenedor.add(lado); contenedor.add(campoLado);
        contenedor.add(calcular); contenedor.add(volumen); contenedor.add(superficie);
        contenedor.add(panelGrafico);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        try {
            double l = Double.parseDouble(campoLado.getText());
            Cubo cubo = new Cubo(l);
            volumen.setText("Volumen (cm3): " + String.format("%.2f", cubo.getVolumen()));
            superficie.setText("Superficie (cm2): " + String.format("%.2f", cubo.getSuperficie()));
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

            GradientPaint gradFrontal = new GradientPaint(30, 50, new Color(180, 50, 255), 110, 130, new Color(100, 0, 180));
            GradientPaint gradSuperior = new GradientPaint(60, 20, new Color(220, 100, 255), 110, 50, new Color(150, 30, 220));
            GradientPaint gradDerecha = new GradientPaint(110, 50, new Color(120, 20, 200), 140, 130, new Color(60, 0, 120));

            // Caras rellenas para el cubo
            Polygon caraSuperior = new Polygon(new int[]{60, 140, 110, 30}, new int[]{20, 20, 50, 50}, 4);
            Polygon caraFrontal = new Polygon(new int[]{30, 110, 110, 30}, new int[]{50, 50, 130, 130}, 4);
            Polygon caraDerecha = new Polygon(new int[]{110, 140, 140, 110}, new int[]{50, 20, 100, 130}, 4);
            
            g2.setPaint(gradFrontal);
            g2.fillPolygon(caraFrontal);
            g2.setPaint(gradSuperior);
            g2.fillPolygon(caraSuperior);
            g2.setPaint(gradDerecha);
            g2.fillPolygon(caraDerecha);

            // Borde
            g2.setColor(new Color(40, 0, 80));
            g2.setStroke(new BasicStroke(2.5f));
            g2.drawPolygon(caraFrontal);
            g2.drawPolygon(caraSuperior);
            g2.drawPolygon(caraDerecha);
        }
    }
}
