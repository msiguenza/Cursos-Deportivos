package modelo;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import conexiones.Conexion;

public class ModeloCrearCurso {


	Conexion conx;
	
	public  ModeloCrearCurso() throws IOException, SQLException{
		
		conx = new Conexion();
		
	}
	public ResultSet CrearCurso(String cod_curso,String nombrecurso, String nombredeporte,String hora_inicio,String fecha_inicio,String nivel, String dnimonitor,String plazas) throws SQLException, IOException{
	
		
		String sql="INSERT INTO cursos (cod_curso,nombrecurso,nombredeporte,hora_inicio,fecha_inicio,nivel,dnimonitor,plazas) VALUES" + "(?,?,?,?,?,?,?,?)";//Consulta preparada para introducir los valores posteriormente
		
		
		PreparedStatement prest=(PreparedStatement) conx.getConectado().prepareStatement(sql);
		
		prest.setString(1, cod_curso);
		prest.setString(2, nombrecurso);
		prest.setString(3, nombredeporte);
		prest.setString(4, hora_inicio);
		prest.setString(5, fecha_inicio);
		prest.setString(6, nivel);
		prest.setString(7, dnimonitor);
		prest.setString(8, plazas);
		
		prest.execute();
		
		return null;
	}
	
}


	
