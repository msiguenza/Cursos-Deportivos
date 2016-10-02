package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.mysql.jdbc.Statement;

import conexiones.*;
import modelo.ModeloCrearAlumnos;
import modelo.ModeloCrearCurso;
import modelo.ModeloCursosyDeportes;
import modelo.ModeloModificarCursos;

import VistasFinales.*;

public class ControladorModificarCursos implements ActionListener{

	
	ModificarCursos modificursos;
	ModeloModificarCursos modelomodificarcursos;
	Conexion conx = new Conexion();
	
	public ControladorModificarCursos(ModificarCursos modificarcursos) throws IOException, SQLException{
		modificursos=modificarcursos;
		modelomodificarcursos = new ModeloModificarCursos();
	}
	
	public void iniciar(){
		modificursos.setVisible(true);
		modificursos.btnGuardarCambios.setActionCommand("Guardar Cambios");
		modificursos.btnGuardarCambios.addActionListener(this);
		//---------------------------------------------------
		modificursos.btnCancelar.setActionCommand("Salir");
		modificursos.btnCancelar.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	String comando=e.getActionCommand();
	

	if (comando.equals("Guardar Cambios")) {
		
		this.modificursos.dispose();
		
		
		try{
			String cod_curso,  nombredeporte,  hora_inicio,  fecha_inicio,  nivel,  dnimonitor;
			String plazas,nombreCurso;

			cod_curso=this.modificursos.textFieldcod_curso.getText();
			nombreCurso=this.modificursos.textFieldNombreCurso.getText();
			nombredeporte=this.modificursos.textFieldDeporte.getText();
			hora_inicio=this.modificursos.textFieldHoraInicio.getText();
			fecha_inicio=this.modificursos.textFieldFechaInicio.getText();
			nivel=this.modificursos.textFieldNivel.getText();
			dnimonitor=this.modificursos.textFieldDNIMON.getText();
			
			if(dnimonitor.length()==0){
				
				dnimonitor=null;
				
			}
			
			plazas=this.modificursos.textFieldPlaza.getText();
				
			 Statement prest1=(Statement) conx.getConectado().createStatement();
			 ResultSet rs = prest1.executeQuery("SELECT * FROM deportes WHERE nombredeporte = '"+this.modificursos.textFieldDeporte.getText()+"'");
			 
			 Statement prest2=(Statement) conx.getConectado().createStatement();
			 ResultSet rs2 = prest2.executeQuery("SELECT * FROM monitores WHERE dnimonitor = '"+this.modificursos.textFieldDNIMON.getText()+"'");	 
			 
			 if (rs.first() || rs2.first()) {
			 
				 boolean validar=modelomodificarcursos.ModificarModificarCurso(cod_curso,nombreCurso,nombredeporte, hora_inicio, fecha_inicio, nivel, dnimonitor, plazas);
					
					if(validar==true){
						JOptionPane.showMessageDialog(null, "Curso modificado con éxito");
						this.modificursos.dispose();
					}else{
						JOptionPane.showMessageDialog(null,"Deporte o Dni de monitor no existentes, por favor introduzca uno valido");
					}
			 }
			 
		}catch(SQLException exSql){
			exSql.printStackTrace();
			JOptionPane.showMessageDialog(null, exSql.getMessage());
		}catch(Exception e1){
			e1.printStackTrace();
		    JOptionPane.showMessageDialog(null, "Error en la conexión con la base de datos","Error",JOptionPane.ERROR_MESSAGE);
	}
		
		
	}
	

	if (comando.equals("Salir")) {
		this.modificursos.dispose();
	}
	
	
	}
	
	
}

