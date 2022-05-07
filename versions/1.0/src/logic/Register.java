package logic;

public class Register {
	
	private String horaInicio;
	private String horaFin;
	private Activity actividad;
	
	public Register(String pHoraInicio, String pHoraFin, Activity pActividad) 
	{
		this.horaInicio=pHoraInicio;
		this.horaFin=pHoraFin;
		this.actividad=pActividad;
	}
	
	public String actualizarRegistro() 
	{
		return "";
	}
	
	public String mostrarRegistro() 
	{
		return actividad+" hecha desde: "+ horaInicio+" hasta "+ horaFin;
	}
}