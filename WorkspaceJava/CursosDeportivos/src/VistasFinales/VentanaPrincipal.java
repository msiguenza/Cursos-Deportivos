package VistasFinales;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import controlador.ControladorVentanaPrinci;

import conexiones.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.SwingConstants;


public class VentanaPrincipal extends JFrame {
	

	public JPanel contentPane;
	public JButton btnGestionMonitoresyAlumnos;
	
	public JButton btnCursosyDeportes;
	public JButton btnConexion;
	
	public ControladorVentanaPrinci princi;

	public VentanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/Images/admin.png"));
		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		
		
//--------- zona menu Men�.
		JMenuBar barra = new JMenuBar();
		JMenu menu1 = new JMenu("Men�");
		
		JMenuItem menuitemSalir = new JMenuItem("Salir aplicaci�n");
		menuitemSalir.setMnemonic('S');
		
		
		
		//acciones de items
	
		
		menuitemSalir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				System.exit(0);
			}
		});
	//---------
		
	
		btnConexion = new JButton("Establecer Conexion Manualmente");
		btnConexion.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnConexion.setBounds(98, 344, 327, 39);
		btnConexion.setIcon(new ImageIcon("src/images/connect.png"));
		contentPane.add(btnConexion);
		
		btnGestionMonitoresyAlumnos = new JButton("Gesti�n de Monitores y Alumnos");
		btnGestionMonitoresyAlumnos.setMnemonic('g');
		btnGestionMonitoresyAlumnos.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnGestionMonitoresyAlumnos.setIcon(new ImageIcon("src/images/usuariosvarios.png"));
		btnGestionMonitoresyAlumnos.setBounds(98, 58, 327, 39);
		contentPane.add(btnGestionMonitoresyAlumnos);
		btnGestionMonitoresyAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		
		btnCursosyDeportes = new JButton("Gesti�n de Cursos y Deportes");
		btnCursosyDeportes.setMnemonic('n');
		btnCursosyDeportes.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnCursosyDeportes.setIcon(new ImageIcon("src/images/Notas.png"));
		btnCursosyDeportes.setBounds(98, 191, 327, 39);
		contentPane.add(btnCursosyDeportes);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("src\\images\\Base de datos 001.jpg"));
		label.setBounds(0, 0, 527, 402);
		contentPane.add(label);
		btnCursosyDeportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	
		menu1.add(menuitemSalir);
		barra.add(menu1);
		
		this.setJMenuBar(barra);
		
		princi=new ControladorVentanaPrinci(this);
	}	
	
}
