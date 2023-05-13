package Main;

import Controlador.*;

/**
 * Main que incia toda la App
 *
 */
public class App {
	public static void main( String[] args ){
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				//Creamos un objeto del controlador que será el encargado de gestionar las vistas
				Controlador controlador = new Controlador();
		        controlador.mostrarVistaLogin();
				
			}
		});

        
    
	
		}
}

