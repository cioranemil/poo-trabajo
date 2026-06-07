package MenuPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuActividad3 extends JFrame implements ActionListener {

    private JButton btnNotas;
    private JButton btnFiguras;

    public MenuActividad3() {
        setTitle("Menú Principal - Actividad 3");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        // Panel de Título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(45, 62, 80));
        panelTitulo.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        JLabel lblTitulo = new JLabel("Seleccione una Actividad");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        panelTitulo.add(lblTitulo);
        add(panelTitulo, BorderLayout.NORTH);

        // Panel de Botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(2, 1, 10, 15));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        panelBotones.setBackground(new Color(236, 240, 241));

        btnNotas = crearBoton("3.1: Sistema de Notas", new Color(41, 128, 185));
        btnFiguras = crearBoton("3.2: Sólidos Geométricos", new Color(39, 174, 96));

        panelBotones.add(btnNotas);
        panelBotones.add(btnFiguras);

        add(panelBotones, BorderLayout.CENTER);
    }

    private JButton crearBoton(String texto, Color colorFondo) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        boton.setBackground(colorFondo);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.addActionListener(this);
        return boton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNotas) {
            Notas.VentanaPrincipal ventanaNotas = new Notas.VentanaPrincipal();
            ventanaNotas.setVisible(true);
        } else if (e.getSource() == btnFiguras) {
            Figuras.VentanaPrincipal ventanaFiguras = new Figuras.VentanaPrincipal();
            ventanaFiguras.setVisible(true);
        }
    }

    public static void main(String[] args) {
        // Establecer un Look & Feel más moderno
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MenuActividad3 menu = new MenuActividad3();
                menu.setVisible(true);
            }
        });
    }
}
