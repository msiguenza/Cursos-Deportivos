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

import com.mysql.jdbc.PreparedStatement;

import conexiones.*;
import modelo.ModeloCrearAlumnos;
import modelo.ModeloCrearCurso;
import modelo.ModeloCursosyDeportes;
import modelo.ModeloModificarDeportes;

import VistasFinales.*;

public class ControladorModificarDeportes implements ActionListener{

	
	ModificarDeporte modifideport;
	ModeloModificarDeportes modelomodifideport;
	
	
	public ControladorModificarDeportes(ModificarDeporte modificardeporte) throws IOException, SQLException{
		modifideport=modificardeporte;
		modelomodifideport = new ModeloModificarDeportes();
		iniciar();
	}
	
	public void iniciar(){
		//modifideport.setVisible(true);
		modifideport.btnGuardarCambios.setActionCommand("Guardar Cambios");
		modifideport.btnGuardarCambios.addActionListener(this);
		//---------------------------------------------------
		modifideport.btnCancelar.setActionCommand("Salir");
		modifideport.btnCancelar.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
	String comando=e.getActionCommand();
	

	if (comando.equals("Guardar Cambios")) {
		
		
			try{
				
					
					String nombredeporte, instalacion, riesgo;
					
					nombredeporte=this.modifideport.textFieldnombredeporte.getText();
					instalacion=this.modifideport.textFieldInstalacion.getText();
					riesgo=this.modifideport.textFieldRiesgo.getText();
			
					
					if(nombredeporte.length()<=0){
						JOptionPane.showMessageDialog(null, "El nombre del deporte es obligatorio");
					}else{
						modelomodifideport.btnGurdarCambios(nombredeporte, instalacion, riesgo);
						JOptionPane.showMessageDialog(null, "Deporte modificado con éxito");
						this.modifideport.dispose();
					}
					
				}catch(Exception p){
				    JOptionPane.showMessageDialog(null, "Error en la conexión con la base de datos","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
	
	

	if (comando.equals("Salir")) {
		this.modifideport.dispose();
	}
	
	
	}
	
	
}

