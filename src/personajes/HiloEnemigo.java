package personajes;

import entidadesLogicas.Juego;

public class HiloEnemigo extends Thread {
	
	int velocidadTickeo;
	Juego miJuego;
	Enemigo miEnemigo;
	
	public HiloEnemigo(int velocidadEnemigo, Juego miJuego, Enemigo miEnemigo) {
		this.miJuego = miJuego;
		velocidadTickeo = velocidadEnemigo;
		this.miEnemigo = miEnemigo;
	}
	
	public void run() {
		while (!miJuego.isGameOver()) {
			
			if (!miJuego.estaPausado()) {
				
				try {
					miJuego.operar(miEnemigo);
					Thread.sleep(velocidadTickeo * 50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			} else {
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
	
}
