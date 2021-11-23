package personajes;

import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;
import gui.Ventana;

/**
 * Class Inky - Representa el Enemigo Inky del Juego.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public class Inky extends Enemigo {
	
	private static final Posicion posicionScatter = new Posicion(700, 800);
	private static final Posicion spawnInky = new Posicion(350, 325);
	
	/**
	 * Crea un nuevo Inky.
	 * @param miJuego Juego asociado a Inky.
	 * @param imagenes Skins de Inky.
	 */
	public Inky(Juego miJuego, String[] imagenes) {
		setVelocidadPredeterminada(miJuego.getNivel().getVelocidadEnemigos());
		velocidadActual = velocidadPredeterminada;
		super.crearEnemigo(miJuego, spawnInky, imagenes);
	}
	
	/**
	 * Setea la velocidad predeterminada del movimiento de Inky.
	 */
	public void setVelocidadPredeterminada(int velocidad) {
		velocidadPredeterminada = velocidad - 8;
	}
	
	@Override
	public void entrarALaCasa() {	
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque, miPosicion.getX() / Ventana.pixelesBloque).borrarDeListaDeEntidades(this);
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

	@Override
	public Posicion getPosicionScatter() {
		return posicionScatter;
	}

	@Override
	public ChaseIA crearChaseIA() {
		return new ChaseInky(this, miJuego.getPrincipal(), miJuego.getEnemigos().get(0));
	}
	
}
