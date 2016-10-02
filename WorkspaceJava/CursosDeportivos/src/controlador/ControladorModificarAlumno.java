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

import modelo.ModeloCrearAlumnos;
import modelo.ModeloCrearCurso;
import modelo.ModeloCursosyDeportes;
import modelo.ModeloModificarAlumnos;

import VistasFinales.*;

public class ControladorModificarAlumno implements ActionListener{

	
	ModificarAlumno modifialum;
	ModeloModificarAlumnos modelomodificaralumnos;
	
	
	public ControladorModificarAlumno(ModificarAlumno modificaralumnos) throws IOException, SQLException{
		modifialum=modificaralumnos;
		modelomodificaralumnos = new ModeloModificarAlumnos();
	}
	
	public void iniciar(){
		modifialum.setVisible(true);
		modifialum.btnGuardarCambios.setActionCommand("Guardar Cambios");
		modifialum.btnGuardarCambios.addActionListener(this);
		//---------------------------------------------------
		modifialum.btnCancelar.setActionCommand("Salir");
		modifialum.btnCancelar.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	String comando=e.getActionCommand();
	

	if (comando.equals("Guardar Cambios")) {
	
	

	if (comando.equals("Salir")) {
		this.modifialum.dispose();
	}
	
	
	
	}
	

	}
	
}

