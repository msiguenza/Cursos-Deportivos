package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import conexiones.*;

import VistasFinales.*;

public class ControladorVentanaPrinci implements ActionListener{

	VentanaPrincipal princi;
	GestionMonitoresyAlumnos monalum;
	GestionCursosyDeportes curdep;
	
	
	
	public ControladorVentanaPrinci(VentanaPrincipal ac){
		princi=ac;
		
		
	}
	
	public void iniciar(){
		
		princi.setVisible(true);
		princi.btnGestionMonitoresyAlumnos.setActionCommand("Gestion alumno");
		princi.btnGestionMonitoresyAlumnos.addActionListener(this);
		//---------------------------------------------------
		princi.btnCursosyDeportes.setActionCommand("Gestion Cursos y Deportes");
		princi.btnCursosyDeportes.addActionListener(this);
		//...................................................
		
		princi.btnConexion.setActionCommand("Conexiones");
		princi.btnConexion.addActionListener(this);
	
	}

	
	public void actionPerformed(ActionEvent e) {
	String comando=e.getActionCommand();
	
	if(comando.equals("Gestion alumno")){
		GestionMonitoresyAlumnos monalum;
			try {
				monalum = new GestionMonitoresyAlumnos();
				monalum.setVisible(true);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			

		}	
	
		
		
	
	
	if(comando.equals("Gestion Cursos y Deportes")){
		GestionCursosyDeportes curdep;
		try {
			curdep = new GestionCursosyDeportes();
			curdep.setVisible(true);
		} catch (IOException e2) {
			
			e2.printStackTrace();
		} catch (SQLException e2) {
			
			e2.printStackTrace();
		}
		
		
	}
		
	
	if (comando.equals("Conexiones")){
		
		AdministrarConexiones adminconex=new AdministrarConexiones();
		adminconex.setVisible(true);
		
	}
	
	}
}
	
