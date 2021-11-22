package entidadesLogicas;

public class Reloj extends Thread{
	
	private int velocidadTickeo, ticks;
	private Juego miJuego;
	
	public Reloj(int velocidadPrincipal, Juego miJuego) {
		this.miJuego = miJuego;
		velocidadTickeo = velocidadPrincipal;
		ticks = 0;
	}
	
	public void run() {
		while (!miJuego.isGameOver()) {
	        if(!miJuego.estaPausado()) {
	        	try {
					miJuego.operar(miJuego.getMiPersonajePrincipal());
					Thread.sleep(5000 / velocidadTickeo); // 1s
					ticks++;
					if (ticks == 200) 
						miJuego.spawnearFruta();
					if(ticks == ( 200 + miJuego.getNivel().getDuracionFrutas() ) )
						miJuego.despawnearFruta();
					if(ticks == 400) {
						miJuego.spawnearPocionBomba();
					}
					if(ticks == 400 + miJuego.getNivel().getDuracionPociones() * 4)
						miJuego.despawnearPocionBomba();
					if(ticks == 600) {
						miJuego.spawnearPocionVelocidad();
					}
					if(ticks == 600 + miJuego.getNivel().getDuracionPociones())
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

	public void setVelocidadTickeo(int velocidadTickeo) {
		this.velocidadTickeo = velocidadTickeo;
	}

}
