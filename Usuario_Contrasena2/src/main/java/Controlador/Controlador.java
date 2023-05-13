package Controlador;
import Main.*;
import Vista.*;



public class Controlador {
    private LoginVista loginVista;
    private SegundaVista segundaVista;
    private TerceraVista terceraVista;

    /**
     * Inicializa todas las vistas
     */
    public Controlador() {
        loginVista = new LoginVista();
        segundaVista = new SegundaVista();
        terceraVista = new TerceraVista();
    }

    /**
     * Muestra la vista principal del login
     */
    public void mostrarVistaLogin() {
        loginVista.mostrar();
    }

    /**
     * Muestra la vista cuando el login se hace correcto
     */
    public void mostrarSegundaVista() {
    	segundaVista.mostrar();
    }
    
    /**
     * Muestra la vista que hace el login si es incorrecto
     */
    public void mostrarTerceraVista() {
    	terceraVista.mostrar();
    }
    
    /**
     * Junto con el archivo AccesoBD, este medotodo inserta los parametros al acceso
     * @param nombreUsuario
     * @param contrasena
     * @return
     */
    public boolean verificarBBDD (String nombreUsuario, String contrasena){
    	
    	boolean resultado=true;
    	
    	AccesoBD accesoBD = new AccesoBD();
    	    	
    	if (accesoBD.getConnection(nombreUsuario, contrasena)) {
			
    		return true;
		}else {
			return false;
		}
    	
    	
    }

    
    
    
}
    