package modelo;

public class Alumnos {
	private static String dni,nombre,apellido,direccion,nombreC;
	public static String getNombreC() {
		return nombreC;
	}
	public static void setNombreC(String nombreC) {
		Alumnos.nombreC = nombreC;
	}
	private static int edad, cod_curso;
	public static String getDni() {
		return dni;
	}
	public static void setDni(String dni) {
		Alumnos.dni = dni;
	}
	public static String getNombre() {
		return nombre;
	}
	public static void setNombre(String nombre) {
		Alumnos.nombre = nombre;
	}
	public static String getApellido() {
		return apellido;
	}
	public static void setApellido(String apellido) {
		Alumnos.apellido = apellido;
	}
	public static String getDireccion() {
		return direccion;
	}
	public static void setDireccion(String direccion) {
		Alumnos.direccion = direccion;
	}
	public static int getEdad() {
		return edad;
	}
	public static void setEdad(int edad) {
		Alumnos.edad = edad;
	}
	public static int getCod_curso() {
		return cod_curso;
	}
	public static void setCod_curso(int cod_curso) {
		Alumnos.cod_curso = cod_curso;
	}
	
	


}
