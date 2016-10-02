package modelo;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import conexiones.Conexion;

public class ModeloModificarCursos {


	Conexion conx;
	
	public  ModeloModificarCursos() throws IOException, SQLException{
		
		conx = new Conexion();
		
	}
	
	public boolean ModificarModificarCurso(String cod_curso,String nombreCurso, String nombredeporte, String hora_inicio, String fecha_inicio, String nivel, String dnimonitor, String plazas) throws SQLException, IOException {
	
		try{
		String sql="UPDATE cursos SET nombrecurso='"+nombreCurso+"', nombredeporte='"+nombredeporte+"', hora_inicio='"+hora_inicio+"', fecha_inicio='"+fecha_inicio+"', nivel='"+nivel+"', dnimonitor='"+dnimonitor+"', plazas='"+plazas+"'  where cod_curso='"+cod_curso+"'";
	
		Statement st=(Statement) conx.getConectado().createStatement();
		st.executeUpdate(sql);
		
		
		return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
			
}

	
}

	
	

	
