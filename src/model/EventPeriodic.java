package model;

import java.util.Calendar;
import java.util.Timer;

public class EventPeriodic {

	// Variables para decision de medida
	public static final int HORAS = 0;
	public static final int MINUTOS = 1;
	public static final int SEGUNDOS = 2;

	// Variables para tiempo en milisegundos
	private static long unaHora = 3600000;
	private static long unMinuto = 60000;
	private static long unSegundo = 1000;

	public static void ejecutaTareaCadaXTiempo(int cantidad, int medida) {

		// Primero calculo cada cuanto ha de lanzarse(una hora, dos minutos...)
		long periodo = 0;
		switch (medida) {
		case HORAS:
			periodo = cantidad * unaHora;
			break;
		case MINUTOS:
			periodo = cantidad * unMinuto;
			break;
		case SEGUNDOS:
			periodo = cantidad * unSegundo;
			break;
		default:
			periodo = -1;
		}

		// Si ya tenemos un intervalo, lo lanzamos
		if (periodo != -1) {
			Timer tareaEnIntervalo = new Timer();

			// Creamos la tarea
			AccionProgramada accionProgramada = new AccionProgramada("lanzaTareaCadaXTiempo - ",tareaEnIntervalo );

			// La programamos
			tareaEnIntervalo.scheduleAtFixedRate(accionProgramada, Calendar.getInstance().getTime(), periodo);
		} else {
			System.out.println("No se lanzará ninguna tarea.");
		}
		
		
	}
	
	
	
	

}
