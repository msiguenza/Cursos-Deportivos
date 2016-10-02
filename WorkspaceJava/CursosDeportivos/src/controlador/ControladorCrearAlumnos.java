package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.ModeloCrearAlumnos;
import VistasFinales.CrearAlumnos;

import com.mysql.jdbc.Statement;

import conexiones.Conexion;

public class ControladorCrearAlumnos implements ActionListener{

	
	CrearAlumnos crearalum;
	ModeloCrearAlumnos modelocrearalumnos;
		
	Conexion conx= new Conexion();
	
	public ControladorCrearAlumnos(CrearAlumnos crearalumnos) throws IOException, SQLException{
		crearalum=crearalumnos;
		modelocrearalumnos = new ModeloCrearAlumnos();
		iniciar();
	}
	
	public void iniciar(){
		crearalum.setVisible(true);
		crearalum.btnCrearAlumno.setActionCommand("Crear Alumno");
		crearalum.btnCrearAlumno.addActionListener(this);
		//---------------------------------------------------
		crearalum.Salir.setActionCommand("Salir");
		crearalum.Salir.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	String comando=e.getActionCommand();
	

	if (comando.equals("Crear Alumno")) {
		String dni, nombre, apellido, direccion, cod_curso;
		String edad;
		dni=this.crearalum.textFieldDni.getText();
		nombre=this.crearalum.textFieldNombre.getText();
		apellido=this.crearalum.textFieldApellidos.getText();
		direccion=this.crearalum.textFieldDir.getText();
		edad=this.crearalum.textFieldEdad.getText();
		cod_curso=this.crearalum.textFieldcod_curso.getText();
		 
		 Statement prest1;
		try {
			prest1 = (Statement) conx.getConectado().createStatement();
			
		} catch (SQLException e2) {
		
			e2.printStackTrace();
		} catch (IOException e2) {
			
			e2.printStackTrace();
		}
		
			
			 if(dni.length()<=0 || cod_curso.length()<=0 || edad.length()<=0 ){
					JOptionPane.showMessageDialog(null, "El dni, el nombre del curso y la edad son obligatorios");
				}else{
					
					try {
						modelocrearalumnos.CrearAlumnos(dni, nombre, apellido, direccion, edad, cod_curso);
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Alumno creado con �xito");
					this.crearalum.dispose();
				}
				
				
		 } else {
			 
				JOptionPane.showMessageDialog(null, "Nombre de curso  desconocido o no existente");

			 
		 }
		
	
	

	if (comando.equals("Salir")) {
		this.crearalum.dispose();
	}
	
	
	}
	
	
}

