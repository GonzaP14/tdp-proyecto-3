package entidadesLogicas;

public class Reloj extends Thread{
	
	int velocidadTickeo, ticks;
	Juego miJuego;
	
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
					Thread.sleep(500 / velocidadTickeo); // 1s
					ticks++;
					if (ticks == 200) 
						miJuego.spawnearFruta();
					if(ticks == ( 200 + miJuego.getNivel().getDuracionFrutas() ) )
						miJuego.despawnearFruta();
					if(ticks == 1) {
						miJuego.spawnearPocionCongelacion();
					}
					if(ticks == 400 + miJuego.getNivel().getDuracionPociones())
						miJuego.despawnearPocionCongelacion();
					if(ticks == 1) {
						miJuego.spawnearPocionVelocidad();
					}
					if(ticks == 600 + miJuego.getNivel().getDuracionPociones())
						miJuego.despawnearPocionVelocidad();
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

	public void setVelocidadTickeo(int velocidadTickeo) {
		this.velocidadTickeo = velocidadTickeo;
	}

}
