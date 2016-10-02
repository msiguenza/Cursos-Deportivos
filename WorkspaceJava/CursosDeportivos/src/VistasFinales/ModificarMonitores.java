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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import modelo.ModeloModificarMonitores;

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


public class ModificarMonitores extends JDialog {

	public final JPanel contentPanel = new JPanel();
	public JTextField textFieldDNI;
	public JTextField textFieldnombre;
	public JTextField textFieldapellidos;
	public String datosFila[];
	
	public JTextField textFieldTLF;
	public JTextField textFieldNomina;
	
	public JButton btnGuardarCambios;
	public JButton btnCancelar;
	
	public ModeloModificarMonitores modifimoni;
	
	JTable tableCursos;
	
	Conexion conx = new Conexion(); 
	private JTextField textFieldCod_Curso;
	
	public ModificarMonitores(String fila[]) throws IOException, SQLException {
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
		
		
		modifimoni= new ModeloModificarMonitores();
		
	//	JOptionPane.showMessageDialog(null, "\n0: "+datosFila[0]+" \n1: "+datosFila[1]+" \n2: "+datosFila[2]+" \n3: "+datosFila[3]+" \n4: "+datosFila[4]+" \n5: "+datosFila[5]+" \n6: "+datosFila[6]);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setForeground(Color.BLACK);
		lblDNI.setBounds(24, 40, 78, 14);
		lblDNI.setFont(new Font("Comic Sans MS", Font.ITALIC, 13));
		contentPanel.add(lblDNI);
			
		textFieldDNI = new JTextField();
		textFieldDNI.setEnabled(false);
		textFieldDNI.setEditable(false);
		textFieldDNI.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDNI.setBounds(112, 39, 140, 20);
		textFieldDNI.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		textFieldDNI.setColumns(10);
		textFieldDNI.setText(fila[0]);
		contentPanel.add(textFieldDNI);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setBounds(24, 71, 78, 14);
		lblNombre.setFont(new Font("Comic Sans MS", Font.ITALIC, 13));
		contentPanel.add(lblNombre);
		
		textFieldnombre = new JTextField();
		textFieldnombre.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldnombre.setBounds(112, 70, 140, 20);
		textFieldnombre.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		textFieldnombre.setColumns(10);
		textFieldnombre.setText(fila[1]);
		contentPanel.add(textFieldnombre);
		
		JLabel lblapellidos = new JLabel("Apellidos:");
		lblapellidos.setBounds(24, 102, 78, 14);
		lblapellidos.setFont(new Font("Comic Sans MS", Font.ITALIC, 13));
		contentPanel.add(lblapellidos);
		
		textFieldapellidos = new JTextField();
		textFieldapellidos.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldapellidos.setBounds(112, 101, 140, 20);
		textFieldapellidos.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		textFieldapellidos.setColumns(10);
		textFieldapellidos.setText(fila[2]);
		contentPanel.add(textFieldapellidos);
		
		JLabel labelTLF = new JLabel("* Telefono:");
		labelTLF.setForeground(Color.RED);
		labelTLF.setFont(new Font("Comic Sans MS", Font.ITALIC, 13));
		labelTLF.setBounds(24, 147, 78, 14);
		contentPanel.add(labelTLF);
		
		textFieldTLF = new JTextField();
		textFieldTLF.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTLF.setText((String) null);
		textFieldTLF.setColumns(10);
		textFieldTLF.setText(fila[3]);
		textFieldTLF.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		textFieldTLF.setBounds(112, 146, 140, 20);
		contentPanel.add(textFieldTLF);
		
		
		//-------- Botones ---------
		btnGuardarCambios = new JButton("Guardar");
		btnGuardarCambios.setMnemonic('g');
		btnGuardarCambios.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnGuardarCambios.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGuardarCambios.setBounds(21, 280, 112, 31);
		btnGuardarCambios.setIcon(new ImageIcon("src/images/save.png"));
		contentPanel.add(btnGuardarCambios);
		
		//LLAMADA AL CONTROLADOR GUARDAR CAMBIOS MONITORES
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
		
		
		JTextField txtCamposObligatorios = new JTextField();
		txtCamposObligatorios.setOpaque(false);
		txtCamposObligatorios.setForeground(Color.RED);
		txtCamposObligatorios.setText("*  Campos obligatorios");
		txtCamposObligatorios.setBounds(45, 328, 188, 20);
		contentPanel.add(txtCamposObligatorios);
		txtCamposObligatorios.setEditable(false);
		txtCamposObligatorios.setColumns(10);
		
		JLabel labelNomina = new JLabel("* N\u00F3mina:");
		labelNomina.setForeground(Color.RED);
		labelNomina.setFont(new Font("Comic Sans MS", Font.ITALIC, 13));
		labelNomina.setBounds(24, 195, 78, 14);
		contentPanel.add(labelNomina);
		
		textFieldNomina = new JTextField();
		textFieldNomina.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNomina.setText((String) null);
		textFieldNomina.setColumns(10);
		textFieldNomina.setText(fila[4]);
		textFieldNomina.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		textFieldNomina.setBounds(112, 194, 140, 20);
		contentPanel.add(textFieldNomina);
		
		JLabel labelcodcurso = new JLabel("Cod_Curso:");
		labelcodcurso.setFont(new Font("Comic Sans MS", Font.ITALIC, 13));
		labelcodcurso.setBounds(24, 241, 78, 14);
		contentPanel.add(labelcodcurso);
		
		textFieldCod_Curso = new JTextField();
		textFieldCod_Curso.setText((String) null);
		textFieldCod_Curso.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCod_Curso.setColumns(10);
		textFieldCod_Curso.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 1, true));
		textFieldCod_Curso.setBounds(112, 240, 140, 20);
		contentPanel.add(textFieldCod_Curso);
		
		// Labels y textfields
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 250, 205));
		scrollPane.setBounds(262, 35, 239, 220);
		contentPanel.add(scrollPane);
		
		tableCursos = new JTable(){
			public boolean isCellEditable(int rowIndex, int vColIndex) {
	            return false; //Deshabilitaci�n de Celdas
		}};
		
		tableCursos.setBackground(new Color(255, 250, 205));
		scrollPane.setViewportView(tableCursos);
		//LLAMADA AL CONTROLADOR PREPARARTABLACURSOS
		preparartablaCursos();
		
		
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
				//ACCION DE CANCELAR MODIFICAR MONITOR
				dispose();
			}
		});
		
		datosFila=fila;//Inicializamos el atributo de la clase datos Fila con el array de string fila que pasamos por parametros en el constructor de la clase 
	
	}
	//CONTROLADOR GUARDAR CAMBIOS MODIFICAR MONITORES
	protected void btnGurdarCambiosActionPerformed (ActionEvent o){
		 try{
				String dnimonitor, nombre, apellidos,telefono,nomina,cod_curso;
				
				dnimonitor=textFieldDNI.getText();
				nombre=textFieldnombre.getText();
				apellidos=textFieldapellidos.getText();
				telefono=textFieldTLF.getText();
				nomina=textFieldNomina.getText();
				cod_curso=textFieldCod_Curso.getText();
				
				if(textFieldNomina.getText().equals("0")){
						
						cod_curso = ""; 
						
						if (textFieldCod_Curso.getText().equals("")){
						 	JOptionPane.showMessageDialog(null,"El campo cod_ curso esta vacio, debe rellenarlo obligatoriamente");
						 } else {
							 
							 Statement prest1=(Statement) conx.getConectado().createStatement();
							 ResultSet rs = prest1.executeQuery("SELECT * FROM cursos WHERE cod_curso = '"+textFieldCod_Curso.getText()+"'");
							 
							 
							 
							 if (rs.first()) {
								 
								modifimoni.ModificarMonitores(nombre, apellidos, telefono, nomina, dnimonitor);
								 
								
									JOptionPane.showMessageDialog(null, "Monitor modificado con �xito");
									dispose();
									
							 } else {
								 JOptionPane.showInternalMessageDialog(null, "No existe el curso");
							 }
						 }
					}else if (textFieldNomina.getText().equals("1")){
						

						if (textFieldCod_Curso.getText().equals("")) {
							modifimoni.ModificarMonitores(nombre, apellidos, telefono, nomina, dnimonitor);
							JOptionPane.showMessageDialog(null, "Monitor modificado con �xito");
							dispose();
						} else {
							 Statement prest1=(Statement) conx.getConectado().createStatement();
							 ResultSet rs = prest1.executeQuery("SELECT * FROM cursos WHERE cod_curso = '"+textFieldCod_Curso.getText()+"'");
							 
							 if (rs.first()) {
								 
								modifimoni.ModificarMonitores(nombre, apellidos, telefono, nomina, dnimonitor);
								
									JOptionPane.showMessageDialog(null, "Monitor creado con �xito");
									dispose();
									
							 } else {
								 JOptionPane.showInternalMessageDialog(null, "No existe el curso");
							 }
						}
							
				if(dnimonitor.length()<=0){
					JOptionPane.showMessageDialog(null, "El DNI del monitor es obligatorio");
				}else{
					modifimoni.ModificarMonitores(nombre, apellidos, telefono, nomina, dnimonitor);
					
					dispose();
				}	
					} else {
						JOptionPane.showMessageDialog(null, "El valor de la nomina es 0 (Sin nomina) o valor 1 (En nomina)");
					}
				
		 }catch(SQLException exSql){
				JOptionPane.showMessageDialog(null, exSql.getMessage());
			}catch(Exception e){
				e.printStackTrace();
			    JOptionPane.showMessageDialog(null, "Error en la conexi�n con la base de datos","Error",JOptionPane.ERROR_MESSAGE);
		}		 
		 
	}
	
	
	//CONTROLADOR PREPARARTABLACURSOS
	public void preparartablaCursos() {
		try{
			
			DefaultTableModel m;
			
			String titulos[] = {"Id","Nombre","Plazas Restantes"};
			m = new DefaultTableModel(null,titulos);
			
			TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(m);
			tableCursos.setRowSorter(sorter);
	     	
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.CENTER);
		
			String fila[]=new String[titulos.length];
			tableCursos.setModel(m);
			
			ResultSet resultSql = modifimoni.prepararTablaCursos();
			
			while(resultSql.next()){
					fila[0]=resultSql.getString("cod_curso");
					fila[1]=resultSql.getString("nombrecurso");
					fila[2]=resultSql.getString("Plazas_Libres");
					
					
					m.addRow(fila);
			}
			modifimoni.prepararTablaCursos();
			int i;
			i=0;
			while(i<titulos.length){
				tableCursos.getColumnModel().getColumn(i).setCellRenderer(tcr);
				i++;
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error al extraer los datos de la tabla");
		}
		
	}
	
}
