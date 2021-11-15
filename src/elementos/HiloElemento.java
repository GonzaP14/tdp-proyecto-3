package elementos;

import entidadesLogicas.Juego;
import personajes.Enemigo;

public class HiloElemento extends Thread {
	private int ticks;
	private Juego miJuego;
	private int cantidadTicks;
	private boolean romper;
	private Elemento miElemento;
	public HiloElemento(Juego miJuego , int ticks , Elemento e ) {
		this.miJuego = miJuego;
		this.ticks = ticks;
		cantidadTicks = 0;
		romper = false;
		miElemento = e;
	}
	
	public void run() {
		while (!miJuego.isGameOver() && !romper) {
	        if(!miJuego.estaPausado()) {
	        	try {
					Thread.sleep(50); // 1s
					if(cantidadTicks == ticks) {
						miElemento.operacionEnHilo();
						romper = true;
					}
					else
						cantidadTicks++;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	        }
	        else {
	        	synchronized(miJuego.getObjetoPausa()) {
                    while (miJuego.estaPausado()) {
                    	try {
                    		miJuego.getObjetoPausa().wait();
                        }
                    	catch(InterruptedException e) {
                    		e.printStackTrace();
                    	}
                    }
                }
	        }
		}
	}

	public void setRomper(boolean romper) {
		this.romper = romper;
	}
	
	
	
}
