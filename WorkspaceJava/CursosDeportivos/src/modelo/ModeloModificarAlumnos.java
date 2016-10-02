package modelo;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import conexiones.Conexion;

public class ModeloModificarAlumnos {


	Conexion conx;
	
	public  ModeloModificarAlumnos() throws IOException, SQLException{
		
		conx = new Conexion();
		
	}
	
	public void ModificarAlumnos(String dni, String nombre, String apellido, String direccion, String edad, String cod_curso) throws SQLException, IOException {
		
		
			
					String sql="UPDATE alumnos SET nombre=?, apellido=?, direccion=?, edad=?, cod_curso=? where dni=?";
					PreparedStatement prest=(PreparedStatement) conx.getConectado().prepareStatement(sql);
					
					
					prest.setString(1, nombre);
					prest.setString(2, apellido);
					prest.setString(3, direccion);
					prest.setString(4, edad);
					prest.setString(5, cod_curso);
					prest.setString(6, dni);
					prest.executeUpdate();
						
	}
	

	public ResultSet prepararTablaCursos() {
		try{
			Statement sql=(Statement) conx.getConectado().createStatement();
			ResultSet resulSql=sql.executeQuery("SELECT cod_curso, nombrecurso, func1(cod_curso) AS Plazas_Libres FROM cursos");
			
			
			return resulSql;
			
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al extraer los datos de la tabla");
		}
		return null;
	}
	
			
}
	
