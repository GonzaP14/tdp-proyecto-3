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
					Thread.sleep(500/velocidadTickeo);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			} else {
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

	public void setVelocidadTickeo(int velocidadTickeo) {
		this.velocidadTickeo = velocidadTickeo;
	}
	
}
