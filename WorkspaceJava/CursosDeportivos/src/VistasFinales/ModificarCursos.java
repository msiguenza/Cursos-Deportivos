package VistasFinales;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.border.LineBorder;

import modelo.ModeloModificarCursos;

import conexiones.*;

import com.mysql.jdbc.PreparedStatement;


import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.io.IOException;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;


public class ModificarCursos extends JDialog {

	public final JPanel contentPanel = new JPanel();
	public JTextField textFieldcod_curso;
	public JTextField textFieldDeporte;
	public String datosFila[];
	public JButton btnGuardarCambios;
	public JButton btnCancelar;

	Conexion conx = new Conexion();
	public JTextField textFieldHoraInicio;
	public JTextField textFieldFechaInicio;
	public JTextField textFieldNivel;
	public JTextField textFieldPlaza;
	public JTextField textFieldDNIMON;
	
	public ModeloModificarCursos modificursos;
	public JTextField textFieldNombreCurso;
	
	
	public ModificarCursos(String fila[]) throws IOException, SQLException {
		datosFila=fila;
		setTitle("Modificar Usuario");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/Images/admin.png"));
		setUndecorated(true);
		setModal(true);
		setBounds(100, 100, 511, 382);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		
		modificursos = new ModeloModificarCursos();
		
	//	JOptionPane.showMessageDialog(null, "\n0: "+datosFila[0]+" \n1: "+datosFila[1]+" \n2: "+datosFila[2]+" \n3: "+datosFila[3]+" \n4: "+datosFila[4]+" \n5: "+datosFila[5]+" \n6: "+datosFila[6]);
		
		JLabel lblnombredeporte = new JLabel("* COD_CURSO");
		lblnombredeporte.setForeground(Color.RED);
		lblnombredeporte.setBounds(24, 40, 106, 14);
		lblnombredeporte.setFont(new Font("Comic Sans MS", Font.ITALIC, 11));
		contentPanel.add(lblnombredeporte);
			
		textFieldcod_curso = new JTextField();
		textFieldcod_curso.setEnabled(false);
		textFieldcod_curso.setEditable(false);
		textFieldcod_curso.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldcod_curso.setBounds(140, 40, 140, 20);
		textFieldcod_curso.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		textFieldcod_curso.setColumns(10);
		textFieldcod_curso.setText(fila[0]);
		contentPanel.add(textFieldcod_curso);
		
		
		JLabel labelNombreCurso = new JLabel(" Nombre  Curso");
		labelNombreCurso.setFont(new Font("Comic Sans MS", Font.ITALIC, 11));
		labelNombreCurso.setBounds(24, 72, 106, 14);
		contentPanel.add(labelNombreCurso);
		
		textFieldNombreCurso = new JTextField();
		textFieldNombreCurso.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNombreCurso.setText((String) null);
		textFieldNombreCurso.setColumns(10);
		textFieldNombreCurso.setText(fila[1]);
		textFieldNombreCurso.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		textFieldNombreCurso.setBounds(140, 72, 140, 20);
		contentPanel.add(textFieldNombreCurso);
		
		
		JLabel lbldeporte = new JLabel("*Nombre Deporte");
		lbldeporte.setForeground(Color.RED);
		lbldeporte.setBounds(24, 102, 106, 14);
		lbldeporte.setFont(new Font("Comic Sans MS", Font.ITALIC, 11));
		contentPanel.add(lbldeporte);
		
		textFieldDeporte = new JTextField();
		textFieldDeporte.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDeporte.setBounds(140, 102, 140, 20);
		textFieldDeporte.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		textFieldDeporte.setColumns(10);
		textFieldDeporte.setText(fila[2]);
		contentPanel.add(textFieldDeporte);
		
		
		//-------- Botones ---------
		btnGuardarCambios = new JButton("Guardar");
		btnGuardarCambios.setMnemonic('g');
		btnGuardarCambios.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnGuardarCambios.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGuardarCambios.setBounds(21, 280, 112, 31);
		btnGuardarCambios.setIcon(new ImageIcon("src/images/save.png"));
		contentPanel.add(btnGuardarCambios);
		
		//LLAMADA AL CONTROLADOR GUARDAR CAMBIOS MODIFICAR CURSO
		btnGuardarCambios.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent o){
				btnGurdarCambiosActionPerformed(o);
			}
		});
		
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setMnemonic('c');
		btnCancelar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnCancelar.setBounds(160, 280, 112, 31);
		btnCancelar.setIcon(new ImageIcon("src/images/adiooos.png"));
		contentPanel.add(btnCancelar);
		
		JLabel labelhorainicio = new JLabel("Hora_Inicio");
		labelhorainicio.setFont(new Font("Comic Sans MS", Font.ITALIC, 11));
		labelhorainicio.setBounds(24, 150, 106, 14);
		contentPanel.add(labelhorainicio);
		
		textFieldHoraInicio = new JTextField();
		textFieldHoraInicio.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldHoraInicio.setText((String) null);
		textFieldHoraInicio.setColumns(10);
		textFieldHoraInicio.setText(fila[3]);		
		textFieldHoraInicio.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		textFieldHoraInicio.setBounds(140, 150, 140, 20);
		contentPanel.add(textFieldHoraInicio);
		
		
		JTextField txtCamposObligatorios = new JTextField();
		txtCamposObligatorios.setOpaque(false);
		txtCamposObligatorios.setForeground(Color.RED);
		txtCamposObligatorios.setText("*  Campos obligatorios");
		txtCamposObligatorios.setBounds(45, 328, 188, 20);
		contentPanel.add(txtCamposObligatorios);
		txtCamposObligatorios.setEditable(false);
		txtCamposObligatorios.setColumns(10);
		
		JLabel labelFechaInicio = new JLabel("Fecha_Inicio");
		labelFechaInicio.setFont(new Font("Comic Sans MS", Font.ITALIC, 11));
		labelFechaInicio.setBounds(24, 194, 106, 14);
		contentPanel.add(labelFechaInicio);
		
		textFieldFechaInicio = new JTextField();
		textFieldFechaInicio.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldFechaInicio.setText((String) null);
		textFieldFechaInicio.setColumns(10);
		textFieldFechaInicio.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		textFieldFechaInicio.setBounds(140, 194, 140, 20);
		textFieldFechaInicio.setText(fila[4]);		
		contentPanel.add(textFieldFechaInicio);
		
		JLabel labelNivel = new JLabel("Nivel");
		labelNivel.setFont(new Font("Comic Sans MS", Font.ITALIC, 11));
		labelNivel.setBounds(24, 239, 106, 14);
		contentPanel.add(labelNivel);
		
		textFieldNivel = new JTextField();
		textFieldNivel.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNivel.setText((String) null);
		textFieldNivel.setColumns(10);
		textFieldNivel.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		textFieldNivel.setBounds(140, 238, 140, 20);
		textFieldNivel.setText(fila[5]);		
		contentPanel.add(textFieldNivel);
		
		JLabel labeldnimonitor = new JLabel("* DNI Monitor");
		labeldnimonitor.setHorizontalAlignment(SwingConstants.CENTER);
		labeldnimonitor.setForeground(Color.RED);
		labeldnimonitor.setFont(new Font("Comic Sans MS", Font.ITALIC, 11));
		labeldnimonitor.setBounds(361, 29, 140, 14);
		contentPanel.add(labeldnimonitor);
		
		JLabel labelPlazas = new JLabel("Plazas");
		labelPlazas.setHorizontalAlignment(SwingConstants.CENTER);
		labelPlazas.setFont(new Font("Comic Sans MS", Font.ITALIC, 11));
		labelPlazas.setBounds(361, 102, 140, 14);
		contentPanel.add(labelPlazas);
		
		textFieldDNIMON = new JTextField();
		textFieldDNIMON.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDNIMON.setText((String) null);
		textFieldDNIMON.setColumns(10);
		textFieldDNIMON.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		textFieldDNIMON.setBounds(361, 54, 140, 20);
		textFieldDNIMON.setText(fila[6]);		
		contentPanel.add(textFieldDNIMON);
		
		textFieldPlaza = new JTextField();
		textFieldPlaza.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPlaza.setText((String) null);
		textFieldPlaza.setColumns(10);
		textFieldPlaza.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		textFieldPlaza.setBounds(361, 116, 140, 20);
		textFieldPlaza.setText(fila[7]);		
		contentPanel.add(textFieldPlaza);
		
		JTextArea txtrElNombreDel = new JTextArea();
		txtrElNombreDel.setBorder(new LineBorder(Color.ORANGE));
		txtrElNombreDel.setFont(new Font("Nightclub BTN", Font.BOLD | Font.ITALIC, 10));
		txtrElNombreDel.setText("El nombre del deporte\r\n\r\ny el dni del monitor\r\n\r\nTienen que existir \r\n\r\nen la Base de Datos.");
		txtrElNombreDel.setBounds(364, 179, 137, 108);
		contentPanel.add(txtrElNombreDel);
		
		
		
		// Labels y textfields
		
		
		JLabel lblImagenFondo = new JLabel("");
		lblImagenFondo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblImagenFondo.setBounds(0, 0, 539, 389);
		lblImagenFondo.setIcon(new ImageIcon("src/images/fondito5.jpg"));
		contentPanel.add(lblImagenFondo);
		
		JLabel labelImagen = new JLabel("");
		labelImagen.setBounds(218, 0, 321, 389);
		labelImagen.setIcon(new ImageIcon("src/images/createuserr.png"));
		contentPanel.add(labelImagen);
		
		
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent o){
				btnCancelarPerformed(o);
			}
			private void btnCancelarPerformed(ActionEvent o) {
				//ACCION DE CANCELAR VISTA
				dispose();
			}
		});
		
		datosFila=fila;//Inicializamos el atributo de la clase datos Fila con el array de string fila que pasamos por parametros en el constructor de la clase 
		// para poder cambiar el dni tambi�n al hacer el Update de la consulta al guardar los cambios . Si no se hace este cambio podr�amos cambiar cualquier
		// valor de los atributos menos el dni 
		
	}
	
	//CONTROLADOR GUARDAR CAMBIOS MODIFICAR CURSO
	protected void btnGurdarCambiosActionPerformed (ActionEvent o){
		try{
		String cod_curso,  nombredeporte,  hora_inicio,  fecha_inicio,  nivel,  dnimonitor;
		String plazas,nombreCurso;

		cod_curso=textFieldcod_curso.getText();
		nombreCurso=textFieldNombreCurso.getText();
		nombredeporte=textFieldDeporte.getText();
		hora_inicio=textFieldHoraInicio.getText();
		fecha_inicio=textFieldFechaInicio.getText();
		nivel=textFieldNivel.getText();
		dnimonitor=textFieldDNIMON.getText();
		
		if(dnimonitor.length()==0){
			
			dnimonitor=null;
			
		}
		
		plazas=textFieldPlaza.getText();
			
		 Statement prest1=(Statement) conx.getConectado().createStatement();
		 ResultSet rs = prest1.executeQuery("SELECT * FROM deportes WHERE nombredeporte = '"+textFieldDeporte.getText()+"'");
		 
		 Statement prest2=(Statement) conx.getConectado().createStatement();
		 ResultSet rs2 = prest2.executeQuery("SELECT * FROM monitores WHERE dnimonitor = '"+textFieldDNIMON.getText()+"'");	 
		 
		 if (rs.first() || rs2.first()) {
		 
			 boolean validar=modificursos.ModificarModificarCurso(cod_curso,nombreCurso,nombredeporte, hora_inicio, fecha_inicio, nivel, dnimonitor, plazas);
				
				if(validar==true){
					JOptionPane.showMessageDialog(null, "Curso modificado con �xito");
					dispose();
				}else{
					JOptionPane.showMessageDialog(null,"Deporte o Dni de monitor no existentes, por favor introduzca uno valido");
				}
		 }
		 
	}catch(SQLException exSql){
		exSql.printStackTrace();
		JOptionPane.showMessageDialog(null, exSql.getMessage());
	}catch(Exception e){
		e.printStackTrace();
	    JOptionPane.showMessageDialog(null, "Error en la conexi�n con la base de datos","Error",JOptionPane.ERROR_MESSAGE);
}
	}
}
