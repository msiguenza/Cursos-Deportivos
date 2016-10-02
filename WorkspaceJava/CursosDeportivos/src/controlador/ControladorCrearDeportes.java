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

import conexiones.*;

import modelo.ModeloCrearDeporte;
import modelo.ModeloCursosyDeportes;

import VistasFinales.*;

	
	public class ControladorCrearDeportes implements ActionListener{

		
		CrearDeportes creardeport;
		ModeloCrearDeporte modelocreardeportes;
		
		
		public ControladorCrearDeportes(CrearDeportes creardeportes) throws IOException, SQLException{
			creardeport=creardeportes;
			modelocreardeportes = new ModeloCrearDeporte();
			iniciar();
		}
		
		public void iniciar(){
			
			//---------------------------------------------------
			creardeport.btnCrearDeportes.setActionCommand("Crear Deportes");
			creardeport.btnCrearDeportes.addActionListener(this);
			//---------------------------------------------------
			creardeport.Salir.setActionCommand("Salir");
			creardeport.Salir.addActionListener(this);
			
		}
		
		public void actionPerformed(ActionEvent e) {
		String comando=e.getActionCommand();
		

		
		
		if (comando.equals("Crear Deportes")) {
			
			
			String nombredeporte, instalacion, riesgo;
			nombredeporte=this.creardeport.textFieldNomDep.getText();
			instalacion=this.creardeport.textFieldInstalacion.getText();
			riesgo=this.creardeport.textFieldRiesgo.getText();
			
			if(nombredeporte.length()<=0){
				JOptionPane.showMessageDialog(null, "El nombre del deporte es obligatorio");
			}else{
				try {
					
					modelocreardeportes.CrearDeporte(nombredeporte, instalacion, riesgo);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error, posibles causas: \n- Ya existe un Deporte con ese nombre \n- Asegúrese de tener el host activo");
					e1.printStackTrace();
				} catch (IOException e1) {
					 JOptionPane.showMessageDialog(null, "Error en la conexión con la base de datos, as","Error",JOptionPane.ERROR_MESSAGE);				e1.printStackTrace();
				}
				
				this.creardeport.dispose();
			}
			
		}

		if (comando.equals("Salir")) {
			this.creardeport.dispose();
		}
		
		
		}
	
	
	}
	
	

