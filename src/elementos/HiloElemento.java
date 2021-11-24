package elementos;

import entidadesLogicas.Juego;

/**
 * Class HiloElemento - Representa el hilo asociado a un elemento (Pocion, PowePellet).
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public class HiloElemento extends Thread {
	
	private Juego miJuego;
	private Elemento miElemento;
	private int ticksALlegar;
	private int cantidadTicks;
	private boolean romper;
	
	/**
	 * Crea un nuevo HiloElemento.
	 * @param miJuego Juego asociado al Hilo.
	 * @param ticks Ticks actuales del Hilo.
	 * @param e Elemento asociado.
	 */
	public HiloElemento(Juego miJuego, int ticks, Elemento e ) {
		this.miJuego = miJuego;
		this.ticksALlegar = ticks;
		cantidadTicks = 0;
		romper = false;
		miElemento = e;
	}
	
	public void run() {
		while (!miJuego.isGameOver() && !romper) {
	        if(!miJuego.estaPausado()) {
	        	try {
					Thread.sleep(50);
					if(cantidadTicks == ticksALlegar) {
						miElemento.finPocion();
						romper = true;
					}
					else
						cantidadTicks++;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	        }
	        else {
	        	synchronized(miJuego.getObjetoReloj()) {
                    while (miJuego.estaPausado()) {
                    	try {
                    		miJuego.getObjetoReloj().wait();
                        }
                    	catch(InterruptedException e) {
                    		e.printStackTrace();
                    	}
                    }
                }
	        }
		}
	}
	/**
	 * Seteo el romper por si quiero romper el hilo de elemento
	 * @param romper 
	 */
	public void setRomper(boolean romper) {
		this.romper = romper;
	}
	
	/**
	 * Seteo la cantidad de ticks que tiene el hilo
	 * @param ticks la cantidad de ticks que tiene el hilo
	 */
	public void setCantidadTicks(int ticks) {
		cantidadTicks = ticks;
	}
	
}
