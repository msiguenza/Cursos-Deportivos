package modelo;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import conexiones.Conexion;

public class ModeloCrearMonitores {


	Conexion conx;
	
	public  ModeloCrearMonitores() throws IOException, SQLException{
		
		conx = new Conexion();
		
	}
	
	public ResultSet CrearMonitor(String dnimonitor, String nombre, String apellidos, int telefono, int nomina) throws SQLException, IOException {
		
		
						
						String sql="INSERT INTO monitores (dnimonitor,nombre,apellidos,telefono,nomina) VALUES" + "(?,?,?,?,?)";//Consulta preparada para introducir los valores posteriormente
						
						
						PreparedStatement prest=(PreparedStatement) conx.getConectado().prepareStatement(sql);
						
						prest.setString(1, dnimonitor);
						prest.setString(2, nombre);
						prest.setString(3, apellidos);
						prest.setInt(4, telefono);
						prest.setInt(5, nomina);
						
						
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
	
