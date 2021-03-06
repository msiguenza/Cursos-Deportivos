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

import conexiones.*;
import controlador.ControladorCrearDeportes;
import controlador.ControladorModificarDeportes;

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


public class ModificarDeporte extends JDialog {

	public final JPanel contentPanel = new JPanel();
	public JTextField textFieldnombredeporte;
	public JTextField textFieldInstalacion;
	public JTextField textFieldRiesgo;
	public String datosFila[];

	public JButton btnGuardarCambios;
	public JButton btnCancelar;
	
	public ControladorModificarDeportes modifideportes;
	
	public ModificarDeporte(String fila[]) throws IOException, SQLException {
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
		
		
	//	JOptionPane.showMessageDialog(null, "\n0: "+datosFila[0]+" \n1: "+datosFila[1]+" \n2: "+datosFila[2]+" \n3: "+datosFila[3]+" \n4: "+datosFila[4]+" \n5: "+datosFila[5]+" \n6: "+datosFila[6]);
		
		JLabel lblnombredeporte = new JLabel("Nombre: ");
		lblnombredeporte.setForeground(Color.BLACK);
		lblnombredeporte.setBounds(24, 40, 78, 14);
		lblnombredeporte.setFont(new Font("Comic Sans MS", Font.ITALIC, 13));
		contentPanel.add(lblnombredeporte);
			
		textFieldnombredeporte = new JTextField();
		textFieldnombredeporte.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldnombredeporte.setEnabled(false);
		textFieldnombredeporte.setEditable(false);
		textFieldnombredeporte.setBounds(112, 39, 140, 20);
		textFieldnombredeporte.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		textFieldnombredeporte.setColumns(10);
		textFieldnombredeporte.setText(fila[0]);
		contentPanel.add(textFieldnombredeporte);
		
		JLabel lblInstalacion = new JLabel("Instalaci\u00F3n:");
		lblInstalacion.setForeground(Color.BLACK);
		lblInstalacion.setBounds(24, 71, 78, 14);
		lblInstalacion.setFont(new Font("Comic Sans MS", Font.ITALIC, 13));
		contentPanel.add(lblInstalacion);
		
		textFieldInstalacion = new JTextField();
		textFieldInstalacion.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldInstalacion.setBounds(112, 70, 140, 20);
		textFieldInstalacion.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		textFieldInstalacion.setColumns(10);
		textFieldInstalacion.setText(fila[1]);
		contentPanel.add(textFieldInstalacion);
		
		JLabel lblRiesgo = new JLabel("Riesgo:");
		lblRiesgo.setBounds(24, 102, 78, 14);
		lblRiesgo.setFont(new Font("Comic Sans MS", Font.ITALIC, 13));
		contentPanel.add(lblRiesgo);
		
		textFieldRiesgo = new JTextField();
		textFieldRiesgo.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldRiesgo.setBounds(112, 101, 140, 20);
		textFieldRiesgo.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		textFieldRiesgo.setColumns(10);
		textFieldRiesgo.setText(fila[2]);
		contentPanel.add(textFieldRiesgo);
		
		
		//-------- Botones ---------
		btnGuardarCambios = new JButton("Guardar");
		btnGuardarCambios.setMnemonic('g');
		btnGuardarCambios.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnGuardarCambios.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGuardarCambios.setBounds(21, 280, 112, 31);
		btnGuardarCambios.setIcon(new ImageIcon("src/images/save.png"));
		contentPanel.add(btnGuardarCambios);
		
	
		
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setMnemonic('c');
		btnCancelar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnCancelar.setBounds(160, 280, 112, 31);
		btnCancelar.setIcon(new ImageIcon("src/images/adiooos.png"));
		contentPanel.add(btnCancelar);
		
		
		JTextField txtCamposObligatorios = new JTextField();
		txtCamposObligatorios.setOpaque(false);
		txtCamposObligatorios.setForeground(Color.RED);
		txtCamposObligatorios.setText("*  Campos obligatorios");
		txtCamposObligatorios.setBounds(45, 328, 188, 20);
		contentPanel.add(txtCamposObligatorios);
		txtCamposObligatorios.setEditable(false);
		txtCamposObligatorios.setColumns(10);
		
		JLabel labelimagen = new JLabel("");
		labelimagen.setIcon(new ImageIcon("src\\images\\deportes.jpg"));
		labelimagen.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		labelimagen.setBounds(294, 24, 207, 315);
		contentPanel.add(labelimagen);
		
		// Labels y textfields
		
		
		JLabel lblImagenFondo = new JLabel("");
		lblImagenFondo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblImagenFondo.setBounds(0, 0, 539, 389);
		lblImagenFondo.setIcon(new ImageIcon("src/images/fondito5.jpg"));
		contentPanel.add(lblImagenFondo);
		
		
		
		datosFila=fila;//Inicializamos el atributo de la clase datos Fila con el array de string fila que pasamos por parametros en el constructor de la clase 
		// para poder cambiar el dni tambi�n al hacer el Update de la consulta al guardar los cambios . Si no se hace este cambio podr�amos cambiar cualquier
		// valor de los atributos menos el dni 
		modifideportes=new ControladorModificarDeportes(this);
	}
	
	
	
}
