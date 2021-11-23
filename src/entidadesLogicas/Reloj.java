package entidadesLogicas;

public class Reloj extends Thread{
	
	private int velocidadTickeo, cantidadTicks;
	private Juego miJuego;
	
	public Reloj(int velocidadPrincipal, Juego miJuego) {
		this.miJuego = miJuego;
		velocidadTickeo = velocidadPrincipal;
		cantidadTicks = 0;
	}
	
	public void run() {
		while (!miJuego.isGameOver()) {
	        if(!miJuego.estaPausado()) {
	        	try {
					miJuego.operar(miJuego.getPrincipal());
					Thread.sleep(5000 / velocidadTickeo); // 1s
					cantidadTicks++;
					if (cantidadTicks == 200) {
						miJuego.aparecerFruta();
					}
					if(cantidadTicks == ( 200 + miJuego.getNivel().getDuracionFrutas() ) )
						miJuego.despawnearFruta();
					if(cantidadTicks == 400) {
						miJuego.aparecerPocionBomba();
					}
					if(cantidadTicks == 400 + miJuego.getNivel().getDuracionPociones())
						miJuego.despawnearPocionBomba();
					if(cantidadTicks == 600) {
						miJuego.aparecerPocionVelocidad();
					}
					if(cantidadTicks == 600 + miJuego.getNivel().getDuracionPociones())
						miJuego.despawnearPocionVelocidad();
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
	 * Seteo la velocidad con la que tickea el reloj
	 * @param velocidadTickeo con la que va a tickear el reloj
	 */
	public void setVelocidadTickeo(int velocidadTickeo) {
		this.velocidadTickeo = velocidadTickeo;
	}
	/**
	 * Seteo la cantidad de ticks que hizo el reloj
	 * @param cantidadTicks que hizo el reloj
	 */
	public void setCantidadTicks(int cantidadTicks) {
		this.cantidadTicks = cantidadTicks;
	}
	
	

}
