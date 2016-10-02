package modelo;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import conexiones.Conexion;

public class ModeloModificarMonitores {


	Conexion conx;
	
	public  ModeloModificarMonitores() throws IOException, SQLException{
		
		conx = new Conexion();
		
	}
	
	public ResultSet ModificarMonitores(String nombre, String apellidos, String telefono, String nomina, String dnimonitor) throws SQLException, IOException {
			 
				String sql="UPDATE monitores SET nombre=?, apellidos=?,telefono=?,nomina=? where dnimonitor=?";
				PreparedStatement prest=(PreparedStatement) conx.getConectado().prepareStatement(sql);
				
			
				
				
		
				//prest.setString(1, dnimonitor);
				prest.setString(1, nombre);
				prest.setString(2, apellidos);
				prest.setString(3, telefono);
				prest.setString(4, nomina);
				prest.setString(5, dnimonitor);//Le asignamos el valor del array y no el de textfieldDni para poder cambiar el dni sin perder la referencia del dni al que le va a afectar


				prest.executeUpdate();	
	
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
	
