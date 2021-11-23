package personajes;

import elementos.PocionBomba;
import elementos.PocionVelocidad;
import entidadesGraficas.PrincipalGrafico;
import entidadesLogicas.Entidad;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;
import gui.Ventana;

/**
 * Class Principal - Representa el personaje principal del juego.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public class Principal extends Personaje {
	
	protected static Principal original;
	protected static final int Vivo = 1;
	protected static final int Muerto = 2;
	protected boolean yaMeMatoOtroFantasma;
	protected int estadoActual;
	
	/**
	 * Crea un nuevo Principal.
	 * @param miJuego Juego asociado.
	 * @param imagenes Skins del personaje principal.
	 */
	private Principal(Juego miJuego, String[] imagenes) {
		miRepresentacion = new PrincipalGrafico(imagenes);
		estadoActual = Vivo;
		this.miJuego = miJuego;
		miSpawn = new Posicion(350, 575);
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());
		this.miRepresentacion.crearGrafica(miPosicion);
		sentidoActual = Entidad.sentidoFijo;
		sentidoSiguiente = Entidad.sentidoFijo;
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaEntidades(this);
		velocidadActual = 100;
		yaMeMatoOtroFantasma = false;
	}
	
	/**
	 * Obtiene la representación unica del personaje principal.
	 * Si la representación no fue creada, la crea.
	 * De lo contrario retorna la original creada.
	 * @param miJuego Juego asociado al personaje.
	 * @param imagenes Skins del personaje principal.
	 * @return Pesonaje principal del juego.
	 */
	public static Principal getPrincipal(Juego miJuego, String[] imagenes) {
		if (original == null) {
			original = new Principal(miJuego, imagenes);
		}
		
		return original;
	}

	@Override
	public void afectar() {

	}

	@Override
	public void chequearColisionesEntidades() {
		miJuego.getGrilla().buscarColisionesEntidades(this);
	}

	/**
	 * Recibe el efecto de un enemigo.
	 * @param e Enemigo que realiza el efecto.
	 */
	public void recibirEfecto(Enemigo e) {
		if (!yaMeMatoOtroFantasma) {
			yaMeMatoOtroFantasma = true;
			miJuego.perderVida();
			reaparecer();
		}
	}
	
	/**
	 * Recibe el efecto de una pocion de velocidad.
	 * @param p PoscionVelocidad que realiza el efecto.
	 */
	public void recibirEfecto(PocionVelocidad p) {
		velocidadActual = p.getVelocidadOtorgada();
		miJuego.getMiReloj().setVelocidadTickeo(p.getVelocidadOtorgada());
		miRepresentacion.efectoPocionVelocidad(sentidoActual);
	}
	
	public void recibirEfecto(PocionBomba p) {
		miRepresentacion.efectoPocionBomba(sentidoActual);
	}

	public void reaparecer() {
		super.reaparecer();
		miJuego.respawnearEnemigos();
		
		sentidoActual = Entidad.sentidoFijo;
		sentidoSiguiente = Entidad.sentidoFijo;
	}

	@Override
	public void reset() {
		estadoActual = Vivo;
		miSpawn = new Posicion(350, 575);
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());
		this.miRepresentacion.crearGrafica(miPosicion);
		sentidoActual = Entidad.sentidoFijo;
		sentidoSiguiente = Entidad.sentidoFijo;
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaEntidades(this);
		velocidadActual = 100;
	}

	/**
	 * Establece si el personaje fue asesinado por un enemigo.
	 * @param b Parámetro a establecer.
	 */
	public void setYaMeMatoOtroFantasma(boolean b) {
		yaMeMatoOtroFantasma = b;
	}	

	/**
	 * Consulta el estado actual del personaje.
	 * @return estado actual.
	 */
	public int getEstadoActual() {
		return estadoActual;
	}
}
