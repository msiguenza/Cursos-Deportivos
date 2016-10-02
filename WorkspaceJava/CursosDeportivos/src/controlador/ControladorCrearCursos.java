package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.mysql.jdbc.PreparedStatement;

import conexiones.*;

import modelo.ModeloCrearCurso;
import modelo.ModeloCursosyDeportes;

import VistasFinales.*;

public class ControladorCrearCursos implements ActionListener{

	
	CrearCursos crearcurs;
	ModeloCrearCurso modelocrearcursos;
	
	
	public ControladorCrearCursos(CrearCursos crearcursos) throws IOException, SQLException{
		crearcurs=crearcursos;
		modelocrearcursos = new ModeloCrearCurso();
		iniciar();
	}
	
	public void iniciar(){
		
		crearcurs.btnCrearCurso.setActionCommand("Crear Curso");
		crearcurs.btnCrearCurso.addActionListener(this);
		//---------------------------------------------------
		crearcurs.Salir.setActionCommand("Salir");
		crearcurs.Salir.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	String comando=e.getActionCommand();
	

	if (comando.equals("Crear Curso")) {
	
		try{
			
			try{
				String   cod_curso, nombrecurso, nombredeporte, hora_inicio, nivel, dnimonitor;
				String plazas, fecha_inicio;
				cod_curso=this.crearcurs.textFieldcodcurso.getText();
				nombrecurso=this.crearcurs.textFieldNombreCurso.getText();
				nombredeporte=this.crearcurs.textFieldDeporte.getText();
				hora_inicio=this.crearcurs.textFieldhora_inicio.getText();
				fecha_inicio=this.crearcurs.textFieldFecha.getText();
				nivel=this.crearcurs.textFieldNivel.getText();
				dnimonitor=this.crearcurs.textFieldDNIMONITOR.getText();
				plazas=this.crearcurs.textFieldplazaas.getText();
				
				
				if(cod_curso.length()<=0 || plazas.length()<=0){
					JOptionPane.showMessageDialog(null, "El código del curso  y las plazas son obligatorias");
				}else{
					modelocrearcursos.CrearCurso(cod_curso,nombrecurso, nombredeporte, hora_inicio, fecha_inicio, nivel, dnimonitor, plazas);
					JOptionPane.showMessageDialog(null, "Curso creado con éxito");
					this.crearcurs.dispose();
				}
				
				}catch(SQLException exSql){
					exSql.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error, posibles causas:\n-Nombre de Curso introducido ya existente, cambielo. \n- Ya existe un mismo campo (obligatorio) \n- No ha insertado los campos obligatorios \n- DNI Monitor  y/o Nombre del deporte no existentes");
				}
	
	}catch(Exception e1){
		e1.printStackTrace();
	    JOptionPane.showMessageDialog(null, "Error en la conexión con la base de datos","Error",JOptionPane.ERROR_MESSAGE);
}
		}
		
	
	

	if (comando.equals("Salir")) {
		this.crearcurs.dispose();
	}
	
	
	}
	
	
}

