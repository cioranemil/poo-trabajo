package Figuras;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrisma extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel base, altura, profundidad, volumen, superficie;
    private JTextField campoBase, campoAltura, campoProfundidad;
    private JButton calcular;
    private PanelGrafico panelGrafico;

    public VentanaPrisma() {
        contenedor = getContentPane();
        contenedor.setLayout(null);
        contenedor.setBackground(new Color(245, 255, 245));
        setTitle("Prisma Rectangular");
        setSize(520, 300); 
        setLocationRelativeTo(null);
        setResizable(false);

        Font fuenteBase = new Font("Verdana", Font.PLAIN, 12);
        Font fuenteRes = new Font("Verdana", Font.BOLD, 12);

        base = new JLabel("Base (cms):"); base.setFont(fuenteBase); base.setBounds(20, 30, 135, 23);
        campoBase = new JTextField(); campoBase.setBounds(150, 30, 100, 23);

        altura = new JLabel("Altura (cms):"); altura.setFont(fuenteBase); altura.setBounds(20, 60, 135, 23);
        campoAltura = new JTextField(); campoAltura.setBounds(150, 60, 100, 23);

        profundidad = new JLabel("Profundidad (cms):"); profundidad.setFont(fuenteBase); profundidad.setBounds(20, 90, 135, 23);
        campoProfundidad = new JTextField(); campoProfundidad.setBounds(150, 90, 100, 23);

        calcular = new JButton("Calcular"); 
        calcular.setBounds(150, 130, 100, 25);
        calcular.setBackground(new Color(60, 179, 113));
        calcular.setForeground(Color.WHITE);
        calcular.setFocusPainted(false);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm3):"); volumen.setFont(fuenteRes); volumen.setBounds(20, 180, 250, 23);
        superficie = new JLabel("Superficie (cm2):"); superficie.setFont(fuenteRes); superficie.setBounds(20, 210, 250, 23);

        panelGrafico = new PanelGrafico();
        panelGrafico.setBounds(280, 30, 200, 170);

        contenedor.add(base); contenedor.add(campoBase);
        contenedor.add(altura); contenedor.add(campoAltura);
        contenedor.add(profundidad); contenedor.add(campoProfundidad);
        contenedor.add(calcular); contenedor.add(volumen); contenedor.add(superficie);
        contenedor.add(panelGrafico);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        try {
            double b = Double.parseDouble(campoBase.getText());
            double h = Double.parseDouble(campoAltura.getText());
            double p = Double.parseDouble(campoProfundidad.getText());
            Prisma prisma = new Prisma(b, h, p);
            volumen.setText("Volumen (cm3): " + String.format("%.2f", prisma.getVolumen()));
            superficie.setText("Superficie (cm2): " + String.format("%.2f", prisma.getSuperficie()));
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

            GradientPaint gradFrontal = new GradientPaint(30, 40, new Color(0, 200, 150), 130, 130, new Color(0, 100, 80));
            GradientPaint gradSuperior = new GradientPaint(50, 20, new Color(50, 255, 180), 130, 40, new Color(0, 150, 120));
            GradientPaint gradDerecha = new GradientPaint(130, 40, new Color(0, 150, 100), 150, 130, new Color(0, 80, 50));

            // Caras rellenas para el prisma
            Polygon caraSuperior = new Polygon(new int[]{50, 150, 130, 30}, new int[]{20, 20, 40, 40}, 4);
            Polygon caraFrontal = new Polygon(new int[]{30, 130, 130, 30}, new int[]{40, 40, 130, 130}, 4);
            Polygon caraDerecha = new Polygon(new int[]{130, 150, 150, 130}, new int[]{40, 20, 110, 130}, 4);
            
            g2.setPaint(gradFrontal);
            g2.fillPolygon(caraFrontal);
            g2.setPaint(gradSuperior);
            g2.fillPolygon(caraSuperior);
            g2.setPaint(gradDerecha);
            g2.fillPolygon(caraDerecha);

            // Borde
            g2.setColor(new Color(0, 50, 30));
            g2.setStroke(new BasicStroke(2.5f));
            g2.drawPolygon(caraFrontal);
            g2.drawPolygon(caraSuperior);
            g2.drawPolygon(caraDerecha);
        }
    }
}
