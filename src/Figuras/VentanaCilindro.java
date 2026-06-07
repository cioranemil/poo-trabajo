package Figuras;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaCilindro extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radio, altura, volumen, superficie;
    private JTextField campoRadio, campoAltura;
    private JButton calcular;
    private PanelGrafico panelGrafico; // Instancia del JPanel para dibujar

    public VentanaCilindro() {
        contenedor = getContentPane();
        contenedor.setLayout(null);
        contenedor.setBackground(new Color(245, 250, 255));
        setTitle("Cilindro");
        setSize(500, 240); // Aumentado el tamaño para que quepa el dibujo
        setLocationRelativeTo(null);
        setResizable(false);

        Font fuenteBase = new Font("Verdana", Font.PLAIN, 12);
        Font fuenteRes = new Font("Verdana", Font.BOLD, 12);

        radio = new JLabel("Radio (cms):"); radio.setFont(fuenteBase); radio.setBounds(20, 20, 135, 23);
        campoRadio = new JTextField(); campoRadio.setBounds(120, 20, 100, 23);

        altura = new JLabel("Altura (cms):"); altura.setFont(fuenteBase); altura.setBounds(20, 50, 135, 23);
        campoAltura = new JTextField(); campoAltura.setBounds(120, 50, 100, 23);

        calcular = new JButton("Calcular"); 
        calcular.setBounds(120, 80, 100, 25);
        calcular.setBackground(new Color(70, 130, 180));
        calcular.setForeground(Color.WHITE);
        calcular.setFocusPainted(false);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm3):"); volumen.setFont(fuenteRes); volumen.setBounds(20, 130, 230, 23);
        superficie = new JLabel("Superficie (cm2):"); superficie.setFont(fuenteRes); superficie.setBounds(20, 160, 230, 23);

        // Incorporación de la clase Graphics dibujando en un JPanel
        panelGrafico = new PanelGrafico();
        panelGrafico.setBounds(250, 15, 200, 170);

        contenedor.add(radio); contenedor.add(campoRadio);
        contenedor.add(altura); contenedor.add(campoAltura);
        contenedor.add(calcular); contenedor.add(volumen); contenedor.add(superficie);
        contenedor.add(panelGrafico);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            double r = Double.parseDouble(campoRadio.getText());
            double a = Double.parseDouble(campoAltura.getText());
            Cilindro cilindro = new Cilindro(r, a);
            volumen.setText("Volumen (cm3): " + String.format("%.2f", cilindro.getVolumen()));
            superficie.setText("Superficie (cm2): " + String.format("%.2f", cilindro.getSuperficie()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Campo nulo o error de formato",
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Clase interna para manejar Graphics 2D (Requisito del libro)
    private class PanelGrafico extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(new Color(150, 200, 200));
            // Dibujar el cuerpo del cilindro (rectangulo central)
            g2.fillRect(50, 40, 100, 100);
            
            // Dibujar las tapas del cilindro (ovalos)
            g2.setColor(new Color(120, 180, 180));
            g2.fillOval(50, 20, 100, 40); // Tapa superior
            
            g2.setColor(new Color(150, 200, 200));
            g2.fillOval(50, 120, 100, 40); // Tapa inferior

            // Contornos negros
            g2.setColor(Color.DARK_GRAY);
            g2.setStroke(new BasicStroke(2));
            g2.drawOval(50, 20, 100, 40); // Tapa superior
            g2.drawArc(50, 120, 100, 40, 180, 180); // Solo la parte inferior de la base
            g2.drawLine(50, 40, 50, 140); // Lado izquierdo
            g2.drawLine(150, 40, 150, 140); // Lado derecho
        }
    }
}
