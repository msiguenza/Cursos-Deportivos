package principal;



import controlador.ControladorVentanaPrinci;
import VistasFinales.*;

public class Princi {

	public static void main(String[] args) {
		VentanaPrincipal vp=new VentanaPrincipal();
		new ControladorVentanaPrinci(vp).iniciar();
	}
}
