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

import modelo.ModeloCrearCurso;

import conexiones.*;
import controlador.ControladorCrearCursos;

import com.mysql.jdbc.PreparedStatement;



import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import java.io.IOException;
import javax.swing.SwingConstants;


public class CrearCursos extends JDialog {

	public final JPanel contentPanel = new JPanel();
	public JTextField textFieldcodcurso;
	public JTextField textFieldDeporte;
	public JTextField textFieldhora_inicio;
	public JTextField textFieldNivel;
	public JTextField textFieldplazaas;
	
	public JTextField txtCamposObligatorios;
	public JTextField textFieldDNIMONITOR;
	
	public JButton btnCrearCurso;
	public JButton Salir;
	
	public ModeloCrearCurso crearcurso;
	public JTextField textFieldFecha;
	
	public Conexion conx= new Conexion();
	public JTextField textFieldNombreCurso;
	
	
	public CrearCursos() throws IOException, SQLException {
		setTitle("Crear Usuarios");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/Images/admin.png"));
		setModal(true);
		setUndecorated(true);
		setBounds(100, 100, 539, 389);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		JLabel lblcodcurso = new JLabel("*  Cod_Curso:");
		lblcodcurso.setForeground(Color.RED);
		lblcodcurso.setBounds(24, 40, 114, 14);
		lblcodcurso.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		contentPanel.add(lblcodcurso);
		
		crearcurso= new ModeloCrearCurso();
		
		
		textFieldcodcurso = new JTextField();
		textFieldcodcurso.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldcodcurso.setBounds(148, 40, 140, 20);
		textFieldcodcurso.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		contentPanel.add(textFieldcodcurso);
		textFieldcodcurso.setColumns(10);
		
		JLabel lblDeporte = new JLabel("* Deporte:");
		lblDeporte.setForeground(Color.RED);
		lblDeporte.setBounds(24, 107, 114, 14);
		lblDeporte.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		contentPanel.add(lblDeporte);
		
		
		textFieldDeporte = new JTextField();
		textFieldDeporte.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDeporte.setBounds(148, 107, 140, 20);
		textFieldDeporte.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		contentPanel.add(textFieldDeporte);
		textFieldDeporte.setColumns(10);
		
		JLabel lblHora = new JLabel("Hora Inicio:");
		lblHora.setForeground(Color.BLACK);
		lblHora.setBounds(24, 138, 114, 14);
		lblHora.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		contentPanel.add(lblHora);
		
		textFieldhora_inicio = new JTextField();
		textFieldhora_inicio.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldhora_inicio.setBounds(148, 138, 140, 20);
		textFieldhora_inicio.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		contentPanel.add(textFieldhora_inicio);
		textFieldhora_inicio.setColumns(10);
		
		JLabel lbldnimonitor = new JLabel("* Dni Monitor: ");
		lbldnimonitor.setForeground(Color.RED);
		lbldnimonitor.setBounds(24, 231, 114, 14);
		lbldnimonitor.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		contentPanel.add(lbldnimonitor);
		
		JLabel lblFecha = new JLabel("Fecha Inicio:");
		lblFecha.setForeground(Color.BLACK);
		lblFecha.setBounds(24, 169, 114, 14);
		lblFecha.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		contentPanel.add(lblFecha);
		
		JLabel lblNivel = new JLabel("Nivel:");
		lblNivel.setForeground(Color.BLACK);
		lblNivel.setBounds(24, 200, 114, 14);
		lblNivel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		contentPanel.add(lblNivel);
		
		textFieldNivel = new JTextField();
		textFieldNivel.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNivel.setBounds(148, 200, 140, 20);
		textFieldNivel.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		contentPanel.add(textFieldNivel);
		textFieldNivel.setColumns(10);
		
		btnCrearCurso = new JButton("A\u00F1adir");
		btnCrearCurso.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnCrearCurso.setMnemonic('a');
		btnCrearCurso.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCrearCurso.setBounds(24, 304, 120, 31);
		btnCrearCurso.setIcon(new ImageIcon("src/images/confirm.png"));
		contentPanel.add(btnCrearCurso);
		
		//LLAMADA AL CONSTRUCTOR  CREAR CURSO
		btnCrearCurso.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent o){
				btnCrearCursosActionPerformed(o);
			}
		});
		
		
		
		
		Salir = new JButton("Cancelar");
		Salir.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		Salir.setMnemonic('c');
		Salir.setBounds(168, 304, 120, 31);
		Salir.setIcon(new ImageIcon("src/images/adiooos.png"));
		contentPanel.add(Salir);
		//CONTROLADOR QUE REALIZA LA ACCION DE SALIDA
		Salir.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent o){
				
				dispose();
			}
		});
		
		
		JLabel labelCursos = new JLabel("");
		labelCursos.setIcon(new ImageIcon("src/images/users.png"));
		labelCursos.setBounds(282, 0, 257, 389);
		contentPanel.add(labelCursos);
		
		textFieldplazaas = new JTextField();
		textFieldplazaas.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldplazaas.setColumns(10);
		textFieldplazaas.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		textFieldplazaas.setBounds(148, 261, 140, 20);
		contentPanel.add(textFieldplazaas);
		
		
		txtCamposObligatorios = new JTextField();
		txtCamposObligatorios.setOpaque(false);
		txtCamposObligatorios.setForeground(Color.RED);
		txtCamposObligatorios.setText("*  Campos obligatorios");
		txtCamposObligatorios.setBounds(34, 346, 188, 20);
		contentPanel.add(txtCamposObligatorios);
		txtCamposObligatorios.setEditable(false);
		txtCamposObligatorios.setColumns(10);
		
		JLabel labelPlazas = new JLabel("* Plazas:");
		labelPlazas.setForeground(Color.RED);
		labelPlazas.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		labelPlazas.setBounds(24, 262, 114, 14);
		contentPanel.add(labelPlazas);
		
		textFieldDNIMONITOR = new JTextField();
		textFieldDNIMONITOR.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDNIMONITOR.setColumns(10);
		textFieldDNIMONITOR.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		textFieldDNIMONITOR.setBounds(148, 230, 140, 20);
		contentPanel.add(textFieldDNIMONITOR);
		
		JLabel labelNombrecurso = new JLabel("Nombre Curso:");
		labelNombrecurso.setForeground(Color.BLACK);
		labelNombrecurso.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		labelNombrecurso.setBounds(24, 71, 114, 14);
		contentPanel.add(labelNombrecurso);
		
		textFieldNombreCurso = new JTextField();
		textFieldNombreCurso.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNombreCurso.setColumns(10);
		textFieldNombreCurso.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		textFieldNombreCurso.setBounds(148, 71, 140, 20);
		contentPanel.add(textFieldNombreCurso);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldFecha.setText("D\u00EDa-Mes-A\u00F1o");
		textFieldFecha.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		textFieldFecha.setBounds(148, 168, 140, 20);
		contentPanel.add(textFieldFecha);
		textFieldFecha.setColumns(10);
		
		
		JLabel labelImagen = new JLabel("");
		labelImagen.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		labelImagen.setBounds(0, 0, 539, 389);
		labelImagen.setIcon(new ImageIcon("src/images/fondonotas.jpg"));
		contentPanel.add(labelImagen);
		
		
		
	}
	
	
	//CONTROLADOR CREAR CURSOS
	protected void btnCrearCursosActionPerformed (ActionEvent o){
		try{
			
				try{
					String   cod_curso, nombrecurso, nombredeporte, hora_inicio, nivel, dnimonitor;
					String plazas, fecha_inicio;
					cod_curso=textFieldcodcurso.getText();
					nombrecurso=textFieldNombreCurso.getText();
					nombredeporte=textFieldDeporte.getText();
					hora_inicio=textFieldhora_inicio.getText();
					fecha_inicio=textFieldFecha.getText();
					nivel=textFieldNivel.getText();
					dnimonitor=textFieldDNIMONITOR.getText();
					plazas=textFieldplazaas.getText();
					
					
					if(cod_curso.length()<=0 || plazas.length()<=0){
						JOptionPane.showMessageDialog(null, "El c�digo del curso, deporte, dni de monitor y las plazas son obligatorias");
					}else{
						crearcurso.CrearCurso(cod_curso,nombrecurso, nombredeporte, hora_inicio, fecha_inicio, nivel, dnimonitor, plazas);
						JOptionPane.showMessageDialog(null, "Curso creado con �xito");
						dispose();
					}
					
					}catch(SQLException exSql){
						exSql.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error, posibles causas:\n-Nombre de Curso introducido ya existente, cambielo. \n- Ya existe un mismo campo (obligatorio) \n- No ha insertado los campos obligatorios \n- DNI Monitor  y/o Nombre del deporte no existentes");
					}catch(Exception e){
						e.printStackTrace();
					    JOptionPane.showMessageDialog(null, "Error en la conexi�n con la base de datos","Error",JOptionPane.ERROR_MESSAGE);
				}
		
		}catch(Exception e){
			e.printStackTrace();
		    JOptionPane.showMessageDialog(null, "Error en la conexi�n con la base de datos","Error",JOptionPane.ERROR_MESSAGE);
	}
		
	}
}
