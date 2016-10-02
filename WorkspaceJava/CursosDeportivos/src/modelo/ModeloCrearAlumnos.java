package modelo;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import conexiones.Conexion;

public class ModeloCrearAlumnos {


	Conexion conx;
	
	public  ModeloCrearAlumnos() throws IOException, SQLException{
		
		conx = new Conexion();
		
	}
	
	public ResultSet CrearAlumnos(String dni,String nombre, String apellido, String direccion, String edad, String cod_curso) throws SQLException, IOException {
		
	
	
		
		String sql="INSERT INTO alumnos (dni,nombre,apellido,direccion,edad,cod_curso) VALUES" + " (?,?,?,?,?,?)";//Consulta preparada para introducir los valores posteriormente
		
		
		PreparedStatement prest=(PreparedStatement) conx.getConectado().prepareStatement(sql);
		
		
		
		prest.setString(1, dni);
		prest.setString(2, nombre);
		prest.setString(3, apellido);
		prest.setString(4, direccion);
		prest.setString(5, edad);
		prest.setString(6, cod_curso);
		
		prest.execute();
		
	return null;
	
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
	
