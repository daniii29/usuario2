package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controlador.*;

public class LoginVista {
    private JFrame frame;
    private JTextField usuarioTextField;
    private JPasswordField contrasenaTextField;

    /**
     * Vista del Login
     */
    public LoginVista() {
        frame = new JFrame("Inicio de sesión");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JLabel usuarioLabel = new JLabel("Usuario:");
        usuarioLabel.setBounds(19, 0, 64, 57);
        usuarioTextField = new JTextField();
        usuarioTextField.setBackground(new Color(255, 255, 255));
        usuarioTextField.setBounds(95, 6, 150, 44);


        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaLabel.setBounds(2, 57, 81, 57);
        contrasenaTextField = new JPasswordField();
        contrasenaTextField.setBounds(101, 63, 150, 44);

        JButton loginButton = new JButton("Iniciar sesión");
        loginButton.setBounds(182, 116, 112, 37);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = usuarioTextField.getText();
                String contrasena = new String(contrasenaTextField.getPassword());

                // Llamamos al controlador para verificar los datos
                Controlador controlador = new Controlador();
                boolean autenticado = controlador.verificarBBDD(nombreUsuario, contrasena);

                //Si autenticado es true, se enciende una vista y se oculta la principal, en caso contrario se incia la 3º vista y se oculta la principal
                if (autenticado) {
                    controlador.mostrarSegundaVista();
                    ocultar();
                } else {
                	
                	controlador.mostrarTerceraVista();
                    ocultar();
                    
                }
            }
        });
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(usuarioLabel);
        frame.getContentPane().add(usuarioTextField);
        frame.getContentPane().add(contrasenaLabel);
        frame.getContentPane().add(contrasenaTextField);
        frame.getContentPane().add(loginButton);
    }

    /**
     * Hace el login visible
     */
    public void mostrar() {
        frame.setVisible(true);
    }

    /**
     * Oculta el login
     */
    public void ocultar() {
        frame.setVisible(false);
    }
}