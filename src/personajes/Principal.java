package personajes;

import elementos.PocionVelocidad;
import entidadesGraficas.PrincipalGrafico;
import entidadesLogicas.Entidad;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;
import gui.Ventana;

public class Principal extends Personaje {
	
	protected static Principal original;
	protected static final int Vivo = 1;
	protected static final int Muerto = 2;
	
	protected int estadoActual;
	
	private Principal(Juego miJuego, String[] imagenes) { // singleton principle
		miRepresentacion = new PrincipalGrafico(imagenes);
		estadoActual = Vivo;
		this.miJuego = miJuego;
		miSpawn = new Posicion(350, 575);
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());
		this.miRepresentacion.aparecer(miPosicion);
		sentidoActual = Entidad.sentidoFijo;
		sentidoSiguiente = Entidad.sentidoFijo;
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaEntidades(this);
		velocidadActual = 10;
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
		reaparecer();
	}

	public void recibirEfecto(PocionVelocidad p) {
		velocidadActual = p.getVelocidadOtorgada();
		miJuego.getMiReloj().setVelocidadTickeo(p.getVelocidadOtorgada());
	}

	public void reaparecer() {
		super.reaparecer();
		miJuego.respawnearEnemigos();
		
		sentidoActual = Entidad.sentidoFijo;
		sentidoSiguiente = Entidad.sentidoFijo;
	}
	
}
