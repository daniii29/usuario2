package Controlador;

import Main.*;
import Vista.*;

import java.sql.*;
import java.util.Scanner;

/**
 * Método que controla todas las querys de la BD
 * @author daniel
 *
 */
public class AccesoBD {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/Tarea10";
	private String usuario = "root";
	private String pword = "29072002Dan";

	/**
	 * Le pasamos por parametro el usuario y la contraseña para las querys
	 * @param nombreUsuario
	 * @param contrasena
	 * @return
	 */
	public boolean getConnection(String nombreUsuario, String contrasena) {
		Connection con = null;
		boolean resultadoBoolean = false;

		//Try Catch para controlar las excepciones de la mala conexión con la BD
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, usuario, pword);
			System.out.println("Conexión establecida!");
			System.out.println(" ");

			// QUERY 1
			Statement statement = con.createStatement();
			String query = "SELECT * FROM USUARIOS WHERE USUARIO = '" + nombreUsuario + "'";
			query = "SELECT * FROM USUARIOS WHERE USUARIO = '" + nombreUsuario + "';";
			ResultSet resultados = statement.executeQuery(query);
			System.out.println(query);

			//En caso que la query tenga resultado, el usuario se ha encontrado
			if (resultados.next()) {
				System.out.println("El usuario está encontrado");

				// QUERY 2
				String consulta = "SELECT * FROM USUARIOS WHERE USUARIO = ? AND PWORD = ?";
				PreparedStatement prep = con.prepareStatement(consulta);
				prep.setString(1, nombreUsuario);
				prep.setString(2, contrasena);
				ResultSet resultado = prep.executeQuery();

				//En caso que tenga resultado la 2º query, existe un usuario con una contraseña
				if (resultado.next()) {

					System.out.println("Usuario y contraseña correctos");
					resultadoBoolean = true;

				} else {
					System.out.println("La contraseña es incorrecta");
					resultadoBoolean = false;

				}
				resultados.close();
				resultado.close();
				prep.close();
				con.close();

			} else {
				resultadoBoolean = false;

			}

		} catch (Exception e) {
			System.out.println("Algo ha fallado!");
			e.printStackTrace();
		}
		return resultadoBoolean;

	}

	}

