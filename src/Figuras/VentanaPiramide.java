package Figuras;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPiramide extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel base, altura, apotema, volumen, superficie;
    private JTextField campoBase, campoAltura, campoApotema;
    private JButton calcular;
    private PanelGrafico panelGrafico;

    public VentanaPiramide() {
        contenedor = getContentPane();
        contenedor.setLayout(null);
        contenedor.setBackground(new Color(245, 250, 255));
        setTitle("Piramide");
        setSize(500, 260); // Más ancho
        setLocationRelativeTo(null);
        setResizable(false);

        Font fuenteBase = new Font("Verdana", Font.PLAIN, 12);
        Font fuenteRes = new Font("Verdana", Font.BOLD, 12);

        base = new JLabel("Base (cms):"); base.setFont(fuenteBase); base.setBounds(20, 20, 135, 23);
        campoBase = new JTextField(); campoBase.setBounds(130, 20, 90, 23);

        altura = new JLabel("Altura (cms):"); altura.setFont(fuenteBase); altura.setBounds(20, 50, 135, 23);
        campoAltura = new JTextField(); campoAltura.setBounds(130, 50, 90, 23);

        apotema = new JLabel("Apotema (cms):"); apotema.setFont(fuenteBase); apotema.setBounds(20, 80, 135, 23);
        campoApotema = new JTextField(); campoApotema.setBounds(130, 80, 90, 23);

        calcular = new JButton("Calcular"); 
        calcular.setBounds(130, 110, 90, 25);
        calcular.setBackground(new Color(70, 130, 180));
        calcular.setForeground(Color.WHITE);
        calcular.setFocusPainted(false);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm3):"); volumen.setFont(fuenteRes); volumen.setBounds(20, 150, 230, 23);
        superficie = new JLabel("Superficie (cm2):"); superficie.setFont(fuenteRes); superficie.setBounds(20, 180, 230, 23);

        panelGrafico = new PanelGrafico();
        panelGrafico.setBounds(250, 15, 200, 190);

        contenedor.add(base); contenedor.add(campoBase);
        contenedor.add(altura); contenedor.add(campoAltura);
        contenedor.add(apotema); contenedor.add(campoApotema);
        contenedor.add(calcular); contenedor.add(volumen); contenedor.add(superficie);
        contenedor.add(panelGrafico);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            double b = Double.parseDouble(campoBase.getText());
            double a = Double.parseDouble(campoAltura.getText());
            double ap = Double.parseDouble(campoApotema.getText());
            Piramide piramide = new Piramide(b, a, ap);
            volumen.setText("Volumen (cm3): " + String.format("%.2f", piramide.getVolumen()));
            superficie.setText("Superficie (cm2): " + String.format("%.2f", piramide.getSuperficie()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Campo nulo o error de formato",
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private class PanelGrafico extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setStroke(new BasicStroke(2));
            
            // Dibujar la base de la pirámide (un romboide simulando perspectiva)
            int[] baseX = {50, 150, 120, 20};
            int[] baseY = {150, 150, 120, 120};
            
            g2.setColor(new Color(180, 180, 130));
            g2.fillPolygon(baseX, baseY, 4);
            g2.setColor(Color.DARK_GRAY);
            g2.drawPolygon(baseX, baseY, 4);

            // Dibujar las caras visibles
            int puntaX = 85;
            int puntaY = 20;

            // Cara frontal derecha
            int[] caraDX = {150, 50, puntaX};
            int[] caraDY = {150, 150, puntaY};
            g2.setColor(new Color(220, 220, 160));
            g2.fillPolygon(caraDX, caraDY, 3);
            g2.setColor(Color.DARK_GRAY);
            g2.drawPolygon(caraDX, caraDY, 3);

            // Cara frontal izquierda
            int[] caraIX = {50, 20, puntaX};
            int[] caraIY = {150, 120, puntaY};
            g2.setColor(new Color(200, 200, 140));
            g2.fillPolygon(caraIX, caraIY, 3);
            g2.setColor(Color.DARK_GRAY);
            g2.drawPolygon(caraIX, caraIY, 3);
        }
    }
}
