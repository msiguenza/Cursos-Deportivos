package modelo;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import conexiones.Conexion;

public class ModeloModificarDeportes {


	Conexion conx;
	
	public  ModeloModificarDeportes() throws IOException, SQLException{
		
		conx = new Conexion();
		
	}
	
	public void btnGurdarCambios(String nombredeporte,String instalacion, String riesgo){
		try{
				String sql="UPDATE deportes SET instalacion=?, riesgo=? where nombredeporte=?";
				PreparedStatement prest=(PreparedStatement) conx.getConectado().prepareStatement(sql);
				
				
				
				prest.setString(1, instalacion);
				prest.setString(2, riesgo);
				prest.setString(3, nombredeporte);
				
				if(nombredeporte.length()<=0){
					JOptionPane.showMessageDialog(null, "El nombre del deporte es obligatorio");
				}else{
					prest.executeUpdate();
					
					
				}
				
			}catch(SQLException exSql){
				JOptionPane.showMessageDialog(null, exSql.getMessage());
			}catch(Exception e){
			    JOptionPane.showMessageDialog(null, "Error en la conexión con la base de datos","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	}

	
