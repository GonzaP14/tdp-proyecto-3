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
					miJuego.operar();
					Thread.sleep(velocidadTickeo * 50); // 1s
					ticks++;
					if (ticks == 50) {
						miJuego.spawnearFruta();
					}
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
}
