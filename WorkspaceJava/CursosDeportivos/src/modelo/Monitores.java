package modelo;

public class Monitores {
	private static String dnimonitor,nombre,apellidos;
	private static int nomina,telefono;
	public static String getDni() {
		return dnimonitor;
	}
	public static void setDni(String dnimonitor) {
		Monitores.dnimonitor = dnimonitor;
	}
	public static String getNombre() {
		return nombre;
	}
	public static void setNombre(String nombre) {
		Monitores.nombre = nombre;
	}
	public static String getApellido() {
		return apellidos;
	}
	public static void setApellido(String apellido) {
		Monitores.apellidos = apellido;
	}
	public static int getTelefono() {
		return telefono;
	}
	public static void setTelefono(String Telefono) {
		Monitores.telefono = telefono;
	}
	public static int getnomina() {
		return nomina;
	}
	public static void setEdad(int nomina) {
		Monitores.nomina = nomina;
	}

}
