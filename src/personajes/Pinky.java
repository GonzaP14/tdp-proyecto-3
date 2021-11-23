package personajes;

import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;
import gui.Ventana;

/**
 * Class Pinky - Representa el Enemigo Pinky del Juego.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public class Pinky extends Enemigo {
	
	private static final Posicion posicionScatter = new Posicion(25, -75);
	private static final Posicion spawnPinky = new Posicion(300, 325);
	
	/**
	 * Crea un nuevo Pinky.
	 * @param miJuego Juego asociado a Pinky.
	 * @param imagenes Skins de Pinky.
	 */
	public Pinky(Juego miJuego, String[] imagenes) {
		arribaDeLaCasa =  new Posicion(325, 275);
		setVelocidadPredeterminada(miJuego.getNivel().getVelocidadEnemigos());
		velocidadActual = velocidadPredeterminada;
		super.crearEnemigo(miJuego, spawnPinky, imagenes);
	}
	
	@Override
	public void entrarALaCasaEnX() {
		if(miPosicion.getX() != miSpawn.getX() ) {
			miPosicion.setX(miPosicion.getX() - 5);
			miRepresentacion.setLocation(miPosicion.getX(), miPosicion.getY());
		}
		else {
			setVelocidadActual(velocidadPredeterminada);
			miRepresentacion.perseguir(sentidoActual);
			tieneQueSalirDeLaCasaX = true;
			tieneQueSalirDeLaCasaY = true;
			tieneQueEntrarALaCasaX=false;
		}
	}

	@Override
	public void entrarALaCasaEnY() {
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque, miPosicion.getX() / Ventana.pixelesBloque).borrarDeListaDeEntidades(this);
		if(miPosicion.getY() != miSpawn.getY()) {
			miPosicion.setY(miPosicion.getY() + 5);
			miRepresentacion.setLocation(miPosicion.getX(), miPosicion.getY());
		}
		else {
			tieneQueEntrarALaCasaY = false;
		}
	}

	@Override
	public void salirDeLaCasaEnX() {
		if(miPosicion.getX() != arribaDeLaCasa.getX()) {
			miPosicion.setX(miPosicion.getX() + 5);
			miRepresentacion.setLocation(miPosicion.getX(), miPosicion.getY());
		}
		else {
			tieneQueSalirDeLaCasaX = false;
		}
	}

	@Override
	public void salirDeLaCasaEnY() {		
		if(miPosicion.getY() != arribaDeLaCasa.getY()) {			
			miPosicion.setY(miPosicion.getY() - 5);
			miRepresentacion.setLocation(miPosicion.getX(), miPosicion.getY());
		}
		else {
			miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque, miPosicion.getX() / Ventana.pixelesBloque).agregarAListaEntidades(this);
			miHilo.setCantidadTicks(0);
			cambiarEstado(Scatter);
			tieneQueSalirDeLaCasaY = false;	
		}
	}

	@Override
	public Posicion getPosicionScatter() {
		return posicionScatter;
	}


	@Override
	public ChaseIA crearChaseIA() {
		return new ChasePinky(this, miJuego.getPrincipal());
	}

	
}
