package Vista;

import javax.swing.*;

public class TerceraVista {
    private JFrame frame;

    /**
     * Método que contiene la label que muestra cuando se vuelve true la visibilidad de la vista
     */
    public TerceraVista() {
        frame = new JFrame("Tercera Vista");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JLabel label = new JLabel("Usuario y/o contraseña INCORRECTOS. Para mas detalles mirar CONSOLA");

        frame.getContentPane().add(label);
    }

    public void mostrar() {
        frame.setVisible(true);
        
    }

    public void ocultar() {
        frame.setVisible(false);
    }
}