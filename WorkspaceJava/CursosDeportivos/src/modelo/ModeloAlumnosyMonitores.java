package modelo;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import conexiones.Conexion;

public class ModeloAlumnosyMonitores {

	Conexion conx;
	
	public  ModeloAlumnosyMonitores() throws IOException, SQLException{
		
		conx = new Conexion();
		
	}
	
	
	public ResultSet prepararTablaAlumnos() {
		try{
			Statement sql=(Statement) conx.getConectado().createStatement();
			ResultSet resulSql=sql.executeQuery("SELECT * FROM alumnos");
			
			
			return resulSql;
			
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al extraer los datos de la tabla");
		}
		return null;
	}
	
	
	public ResultSet prepararTablaMonitores() {
		try{
			Statement sql=(Statement) conx.getConectado().createStatement();
			ResultSet resulSql=sql.executeQuery("SELECT * FROM monitores");
			
			return resulSql;
			
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error al extraer los datos de la tabla");
		}
		return null;
		
	}
		
	public void EliminarMonitores(String dnimonitor) throws SQLException, IOException {
		
			String sql="DELETE FROM monitores WHERE dnimonitor=?";
			PreparedStatement prest=(PreparedStatement) conx.getConectado().prepareStatement(sql);
			
			
				
				prest.setString(1,dnimonitor);
				prest.executeUpdate();
				prepararTablaMonitores();
			
}

	
	
	public void EliminarAlumnos(String dni) throws SQLException, IOException{
		
		
		String sql="DELETE FROM alumnos WHERE dni=?";
		PreparedStatement prest=(PreparedStatement) conx.getConectado().prepareStatement(sql);
		
		
		prest.setString(1,dni);
		prest.executeUpdate();
		prepararTablaAlumnos();
		
	}
	
	
}
