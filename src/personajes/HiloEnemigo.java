package personajes;

import entidadesLogicas.Juego;

public class HiloEnemigo extends Thread {
	
	private int velocidadTickeo;
	private Juego miJuego;
	private Enemigo miEnemigo;
	private int cantidadTicks;
	
	public HiloEnemigo(int velocidadEnemigo, Juego miJuego, Enemigo miEnemigo) {
		this.miJuego = miJuego;
		velocidadTickeo = velocidadEnemigo;
		this.miEnemigo = miEnemigo;
		cantidadTicks = 0;
	}
	
	public void run() {
		while (!miJuego.isGameOver()) {	
			if (!miJuego.estaPausado()) {			
				try {
					cantidadTicks++;
					if(cantidadTicks == 200) {
						if(miEnemigo.getIndiceEstado() == Enemigo.Scatter)
							miEnemigo.cambiarEstado(Enemigo.Chase);
					}
					miJuego.operar(miEnemigo);
					Thread.sleep(5000/velocidadTickeo);
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
	
	public void setCantidadTicks(int ticks) {
		cantidadTicks = ticks;
	}
}
