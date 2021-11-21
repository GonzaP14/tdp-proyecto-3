package elementos;

import entidadesLogicas.Juego;

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
					Thread.sleep(50);
					if(cantidadTicks == ticks) {
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

	public void setRomper(boolean romper) {
		this.romper = romper;
	}
	
	
	
}
