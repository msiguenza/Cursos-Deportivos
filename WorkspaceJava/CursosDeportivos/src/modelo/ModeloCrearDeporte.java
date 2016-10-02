package modelo;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import conexiones.*;

public class ModeloCrearDeporte {


	Conexion conx;
	
	public  ModeloCrearDeporte() throws IOException, SQLException{
		
		conx = new Conexion();
		
	}
	
	public void CrearDeporte(String nombredeporte,String instalacion,String riesgo) throws SQLException, IOException {
		
		
		String sql="INSERT INTO deportes (nombredeporte,instalacion,riesgo) VALUES" + "(?,?,?)";
		
		PreparedStatement prest=(PreparedStatement) conx.getConectado().prepareStatement(sql);
		
		prest.setString(1, nombredeporte);
		prest.setString(2, instalacion);
		prest.setString(3, riesgo);
		
		prest.execute();
		
	
		JOptionPane.showMessageDialog(null, "Deporte creado con éxito");


}
}
	
