package model;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class AccionProgramada extends TimerTask {

	protected String texto;
	protected int numacciones = 0;
	
	protected Timer timer;

	public AccionProgramada() {

	}

	public AccionProgramada(String texto, Timer timer) {

		this.texto = texto;
		this.timer = timer;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("El texto es: " + texto + " HORA: " + new Date());
		numacciones++;

		if (numacciones > 4) {

			System.out.println();
			System.out.println("------------------------------");
			System.out.println();
			System.out.println("FIN ************");

			timer.cancel();
			timer.purge();
			return;

		}
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
