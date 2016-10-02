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

import modelo.ModeloCrearMonitores;
import modelo.ModeloCursosyDeportes;

import VistasFinales.*;

public class ControladorCrearMonitores implements ActionListener{

	
	CrearMonitores crearmonit;
	ModeloCrearMonitores modelocrearmonitores;
	
	Conexion conx= new Conexion();
	
	public ControladorCrearMonitores(CrearMonitores crearmonitores) throws IOException, SQLException{
		crearmonit=crearmonitores;
		modelocrearmonitores = new ModeloCrearMonitores();
	}
	
	public void iniciar(){
		crearmonit.setVisible(true);
		crearmonit.btnCrearMonitores.setActionCommand("Crear Monitores");
		crearmonit.btnCrearMonitores.addActionListener(this);
		//---------------------------------------------------
		crearmonit.Salir.setActionCommand("Salir");
		crearmonit.Salir.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	String comando=e.getActionCommand();
	

	if (comando.equals("Crear Monitores")) {
	
try{
			
			String dnimonitor, nombre, apellidos;
			int nomina;
			int telefono;
			String cod_curso;
			dnimonitor=this.crearmonit.textFieldDni.getText();
			nombre=this.crearmonit.textFieldNombre.getText();
			apellidos=this.crearmonit.textFieldApellidos.getText();
			telefono=Integer.parseInt(this.crearmonit.textFieldTeleefono.getText());
			cod_curso=this.crearmonit.textFieldCodCurso.getText();
			
		if(this.crearmonit.comboBoxTipo.getSelectedItem().toString().equalsIgnoreCase("No")){
				nomina=0;
				cod_curso = ""; 
				
				if (this.crearmonit.textFieldCodCurso.getText().equals("")){
				 	JOptionPane.showMessageDialog(null,"El campo cod_ curso esta vacio, debe rellenarlo obligatoriamente");
				 } else {
					 
					 Statement prest1=(Statement) conx.getConectado().createStatement();
					 ResultSet rs = prest1.executeQuery("SELECT * FROM cursos WHERE cod_curso = '"+this.crearmonit.textFieldCodCurso.getText()+"'");
					 
					 
					 
					 if (rs.first()) {
						 
						 modelocrearmonitores.CrearMonitor(dnimonitor, nombre, apellidos, telefono, nomina);
						 
						
						}
							JOptionPane.showMessageDialog(null, "Monitor creado con éxito");
							this.crearmonit.dispose();
							
					
				 }
			}else{
				

				nomina=1;

				
				if (this.crearmonit.textFieldCodCurso.getText().equals("")) {
					modelocrearmonitores.CrearMonitor(dnimonitor, nombre, apellidos, telefono, nomina);
					JOptionPane.showMessageDialog(null, "Monitor creado con éxito");
					this.crearmonit.dispose();
				} else {
					 Statement prest1=(Statement) conx.getConectado().createStatement();
					 ResultSet rs = prest1.executeQuery("SELECT * FROM cursos WHERE cod_curso = '"+this.crearmonit.textFieldCodCurso.getText()+"'");
					 
					 if (rs.first()) {
						 
						modelocrearmonitores.CrearMonitor(dnimonitor, nombre, apellidos, telefono, nomina);
							JOptionPane.showMessageDialog(null, "Monitor creado con éxito");
							this.crearmonit.dispose();
							
					 } else {
						 JOptionPane.showInternalMessageDialog(null, "No existe el curso");
					 }
				}
				
			
			}
			
			if(dnimonitor.length()<=0 || telefono<=0) {
				JOptionPane.showMessageDialog(null, "El dni del monitor, la nomina y el telefono, son campos obligatorios");
			}else{
				
			}
			
			}catch(SQLException exSql){
				JOptionPane.showMessageDialog(null, "Error, posibles causas: \n- Ya existe un Monitor con ese Dni \n- Asegúrese de tener el host activo");
			}catch(Exception e1){
				e1.printStackTrace();
			    JOptionPane.showMessageDialog(null, "Tiene que rellenar todos los campos obligatorios","Error",JOptionPane.ERROR_MESSAGE);
		}
		
		
		
		
		
		
		
		
	}
	

	if (comando.equals("Salir")) {
		this.crearmonit.dispose();
	}
	
	
	}
	
	
}

