package personajes;

import elementos.PocionVelocidad;
import entidadesGraficas.PrincipalGrafico;
import entidadesLogicas.Entidad;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class Principal extends Personaje {
	
	protected static Principal original;
	protected static final int Vivo = 1;
	protected static final int Muerto = 2;
	private static final Posicion miSpawn = new Posicion(350, 575);
	
	protected int estadoActual;
	
	private Principal(Juego miJuego, String[] imagenes) { // singleton principle
		miRepresentacion = new PrincipalGrafico(imagenes);
		estadoActual = Vivo;
		this.miJuego = miJuego;
		miPosicion = new Posicion((int) miSpawn.getX(), (int) miSpawn.getY());
		this.miRepresentacion.aparecer(miPosicion);
		sentidoActual = Entidad.sentidoFijo;
		sentidoSiguiente = Entidad.sentidoFijo;
		miJuego.getGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaEntidades(this);
	}
	
	
	public static Principal getPrincipal(Juego miJuego, String[] imagenes) {
		if (original == null) {
			original = new Principal(miJuego, imagenes);
		}
		
		return original;
	}

	@Override
	public void afectar() {

	}

	public int getEstadoActual() {
		return estadoActual;
	}

	@Override
	public void checkeoColisionesPersonaje() {
		miJuego.getGrilla().buscarColisionesEntidades(this);
	}

	public void recibirEfecto(Enemigo e) {
		miJuego.perderVida();
		miJuego.getGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaRemovidos(this);
		reaparecer();
	}

	public void recibirEfecto(PocionVelocidad p) {

	}
	
	private void reaparecer() {
		miPosicion = new Posicion((int) miSpawn.getX(), (int) miSpawn.getY());
		this.miRepresentacion.aparecer(miPosicion);
		sentidoActual = Entidad.sentidoFijo;
		sentidoSiguiente = Entidad.sentidoFijo;
		miJuego.getGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaEntidades(this);
	}
	
	
}
