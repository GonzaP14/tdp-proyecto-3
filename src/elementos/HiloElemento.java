package elementos;

import entidadesLogicas.Juego;

public class HiloElemento extends Thread {
	private int ticksALlegar;
	private Juego miJuego;
	private int cantidadTicks;
	private boolean romper;
	private Elemento miElemento;
	public HiloElemento(Juego miJuego , int ticks , Elemento e ) {
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
