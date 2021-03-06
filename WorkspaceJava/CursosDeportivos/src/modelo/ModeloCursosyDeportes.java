package modelo;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import conexiones.Conexion;

public class ModeloCursosyDeportes {

	Conexion conx;
	
	public  ModeloCursosyDeportes() throws IOException, SQLException{
		
		conx = new Conexion();
		
	}
	
	
	public ResultSet prepararTablaCursos() {
		try{
			Statement sql=(Statement) conx.getConectado().createStatement();
			ResultSet resulSql=sql.executeQuery("SELECT cod_curso,nombrecurso,nombredeporte,hora_inicio,fecha_inicio,nivel,dnimonitor,plazas,func1(cod_curso) AS Plazas_Libres FROM cursos");
			
			return resulSql;
			
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al extraer los datos de la tabla");
		}
		return null;
	}
	
	
	public ResultSet prepararTablaDeportes() {
		try{
			Statement sql=(Statement) conx.getConectado().createStatement();
			ResultSet resulSql=sql.executeQuery("SELECT * FROM deportes");
			
			return resulSql;
			
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error al extraer los datos de la tabla");
		}
		return null;

	}
	

		public void EliminarDeportes(String nombredeporte) throws SQLException, IOException {

				String sql="DELETE FROM deportes WHERE nombredeporte=?";
				PreparedStatement prest=(PreparedStatement) conx.getConectado().prepareStatement(sql);
				
				
							prest.setString(1,nombredeporte);
							prest.executeUpdate();
							prepararTablaDeportes();
	
	
}
		
		
		public void EliminarCursos(String cod_curso)  throws SQLException, IOException{
			
			String sql="DELETE FROM cursos WHERE cod_curso=?";
			PreparedStatement prest=(PreparedStatement) conx.getConectado().prepareStatement(sql);
			
		
					prest.setString(1,cod_curso);
					prest.executeUpdate();
					prepararTablaCursos();
		
	}
		
		
		}
		
		
	

