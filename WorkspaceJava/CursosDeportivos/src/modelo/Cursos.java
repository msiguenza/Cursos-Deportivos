package modelo;

import java.sql.Date;

public class Cursos {
	private static String nombrecurso,nombredeporte,hora_inicio,nivel,dnimonitor;
	private static int cod_curso,plazas;
	private static Date fecha_inicio;
	public static String getNombrecurso() {
		return nombrecurso;
	}
	public static void setNombrecurso(String nombrecurso) {
		Cursos.nombrecurso = nombrecurso;
	}
	public static String getNombredeporte() {
		return nombredeporte;
	}
	public static void setNombredeporte(String nombredeporte) {
		Cursos.nombredeporte = nombredeporte;
	}
	public static String getHora_inicio() {
		return hora_inicio;
	}
	public static void setHora_inicio(String hora_inicio) {
		Cursos.hora_inicio = hora_inicio;
	}
	public static String getNivel() {
		return nivel;
	}
	public static void setNivel(String nivel) {
		Cursos.nivel = nivel;
	}
	public static String getDnimonitor() {
		return dnimonitor;
	}
	public static void setDnimonitor(String dnimonitor) {
		Cursos.dnimonitor = dnimonitor;
	}
	public static int getCod_curso() {
		return cod_curso;
	}
	public static void setCod_curso(int cod_curso) {
		Cursos.cod_curso = cod_curso;
	}
	public static int getPlazas() {
		return plazas;
	}
	public static void setPlazas(int plazas) {
		Cursos.plazas = plazas;
	}
	public static Date getFecha_inicio() {
		return fecha_inicio;
	}
	public static void setFecha_inicio(Date fecha_inicio) {
		Cursos.fecha_inicio = fecha_inicio;
	}
	
}
