package codigo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
	private int año = 0, mes= 0, dia = 0;  

	GregorianCalendar objFecha= new GregorianCalendar();    //	Creación del calendario mediante GregorianCalendar 

	//================================== Setters and Getters
	public int getAño() {              
		return año;
	}
	public void setAño(int año) {
		this.año += año;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		if (this.mes + mes > 12){
			this.año += 1;
			this.setMes( mes - 12 );		
		}
		else {this.mes += mes;}
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		if (this.dia + dia > 31){
			this.setMes( 1 );
			this.setDia( dia - 31);
		}
		else {this.dia += dia;}
	}
	
	public void iniciarFecha() {
		this.año = objFecha.get(Calendar.YEAR);
		this.mes = objFecha.get(Calendar.MONTH)+1;   //Gregorian calendar comienza en o por ello le agregamos 1
		this.dia = objFecha.get(Calendar.DAY_OF_MONTH);
	}
}


