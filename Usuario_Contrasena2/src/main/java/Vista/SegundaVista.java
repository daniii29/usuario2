package Vista;

import javax.swing.*;

public class SegundaVista {
    private JFrame frame;

    /**
     * Vista de la ventana que se enciende si el login es correcto
     */
    public SegundaVista() {
        frame = new JFrame("Segunda Vista");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JLabel label = new JLabel("Usuario y contraseña correctos");

        frame.getContentPane().add(label);
    }

    /**
     * Muestra la vista
     */
    public void mostrar() {
        frame.setVisible(true);
        
    }

    /**
     * Oculta la vista
     */
    public void ocultar() {
        frame.setVisible(false);
    }
}