package personajes;

import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;
import gui.Ventana;

/**
 * Class Clyde - Representa el Enemigo Clyde del Juego.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public class Clyde extends Enemigo {
	
	private static final Posicion posicionScatter = new Posicion(25, 750);
	private static final Posicion spawnClyde = new Posicion(375, 325);
	
	/**
	 * Crea un nuevo Clyde.
	 * @param miJuego Juego asociado a Clyde.
	 * @param imagenes Skins de Clyde.
	 */
	public Clyde(Juego miJuego, String[] imagenes) {
		setVelocidadPredeterminada(miJuego.getNivel().getVelocidadEnemigos());
		velocidadActual = velocidadPredeterminada;
		super.crearEnemigo(miJuego, spawnClyde, imagenes);
	}

	@Override
	public ChaseIA crearChaseIA() {
		return new ChaseClyde(this, miJuego.getPrincipal());
	}

	@Override
	public Posicion getPosicionScatter() {
		return posicionScatter;
	}

	public void entrarALaCasa() {
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque, miPosicion.getX() / Ventana.pixelesBloque).borrarDeListaDeEntidades(this);
		if(miPosicion.getX() != miSpawn.getX()) {
			miPosicion.setX(miPosicion.getX() + 5);
			miRepresentacion.setLocation(miPosicion.getX(), miPosicion.getY());
		}
		if(miPosicion.getY() != miSpawn.getY()) {
			miPosicion.setY(miPosicion.getY() + 5);
			miRepresentacion.setLocation(miPosicion.getX(), miPosicion.getY());
		}
		if(miPosicion.getY() == miSpawn.getY() && miPosicion.getX() == miSpawn.getX()) {
			setVelocidadActual(velocidadPredeterminada);
			miRepresentacion.perseguir(sentidoActual);
			tieneQueSalirDeLaCasa = true;
			salirDeLaCasa();
			tieneQueEntrarALaCasa=false;
		}
	}

	@Override
	public void salirDeLaCasa() {
		if(!miPosicion.equals(arribaDeLaCasa)) {
			if(miPosicion.getX() != arribaDeLaCasa.getX()) {
				miPosicion.setX(miPosicion.getX() - 5);
				miRepresentacion.setLocation(miPosicion.getX(), miPosicion.getY());
			}
			if(miPosicion.getY() != arribaDeLaCasa.getY()) {
				miPosicion.setY(miPosicion.getY() - 5);
				miRepresentacion.setLocation(miPosicion.getX(), miPosicion.getY());
			}
		}
		else {
			miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque, miPosicion.getX() / Ventana.pixelesBloque).agregarAListaEntidades(this);
			miHilo.setCantidadTicks(0);
			cambiarEstado(Scatter);
			tieneQueSalirDeLaCasa = false;
		}
	}
	
}
