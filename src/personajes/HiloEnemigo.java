package personajes;

import entidadesLogicas.Juego;

/**
 * Class HiloEnemigo - Representa el hilo de un enemigo del juego.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public class HiloEnemigo extends Thread {
	
	private int velocidadTickeo;
	private Juego miJuego;
	private Enemigo miEnemigo;
	private int cantidadTicks;
	
	/**
	 * Crea un nuevo HiloEnemigo.
	 * @param velocidadEnemigo velocidad del enemigo asociado.
	 * @param miJuego Juego asociado.
	 * @param miEnemigo Enemigo asociado.
	 */
	public HiloEnemigo(int velocidadEnemigo, Juego miJuego, Enemigo miEnemigo) {
		this.miJuego = miJuego;
		velocidadTickeo = velocidadEnemigo;
		this.miEnemigo = miEnemigo;
		cantidadTicks = 0;
	}
	
	/**
	 * Establece la velocidad de tickeo del Hilo.
	 * @param velocidadTickeo velocidad de tickeo del enemigo.
	 */
	public void setVelocidadTickeo(int velocidadTickeo) {
		this.velocidadTickeo = velocidadTickeo;
	}
	
	/**
	 * Establece la cantidad de ticks del Hilo-
	 * @param ticks ticks del enemigo.
	 */
	public void setCantidadTicks(int ticks) {
		cantidadTicks = ticks;
	}
	
	/**
	 * Inicia la ejecución del Hilo.
	 */
	public void run() {
		while (!miJuego.isGameOver()) {	
			if (!miJuego.estaPausado()) {
				
				try {	
					cantidadTicks ++;
					if (cantidadTicks == 200 && miEnemigo.getIndiceEstado() == Enemigo.Scatter) {
							miEnemigo.cambiarEstado(Enemigo.Chase);
					}
					if( miEnemigo.getTieneQueSalirDeLaCasa()) {
						miEnemigo.salirDeLaCasa();
						Thread.sleep(5000/velocidadTickeo);
					}
					else if(miEnemigo.getTieneQueEntrarALaCasa()) {
						miEnemigo.entrarALaCasa();
						Thread.sleep(5000/velocidadTickeo);
					}
					else {
						miJuego.operar(miEnemigo);
						Thread.sleep(5000/velocidadTickeo);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			} else {
				
				synchronized(miJuego.getObjetoReloj()) {
					
                    while (miJuego.estaPausado()) {
                    	
                    	try {
                    		miJuego.getObjetoReloj().wait();
                        } catch (InterruptedException e) {
                    		e.printStackTrace();
                    	}
                    	
                    }
                }
			}
			
		}
	}

}
