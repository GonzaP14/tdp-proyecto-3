package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class PocionVelocidad extends Pocion {
	private static final Posicion miSpawn = new Posicion(375, 425);//Debe ser abajo de la casa de los fantasmas
	
	public PocionVelocidad(Juego miJuego, String imagen) {
		this.miJuego = miJuego;
		miPosicion = new Posicion((int) miSpawn.getX(), (int) miSpawn.getY());
		miRepresentacion = new ElementoGrafico(imagen);
		miRepresentacion.aparecer(miPosicion);
		velocidadOtorgada = 12;
		miJuego.getGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaEntidades(this);
	}

	@Override
	public void afectar() {
		iniciarTimer(new HiloElemento(miJuego, miJuego.getNivel().getDuracionPociones() , this) );
		miJuego.getMiPersonajePrincipal().recibirEfecto(this);
		miJuego.getGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaRemovidos(this);
		miRepresentacion.desaparecer();
	}

	@Override
	public void operacionEnHilo() {
		miJuego.getMiPersonajePrincipal().setVelocidadActual(10);
		miJuego.getMiReloj().setVelocidadTickeo(10);
	}

	public static Posicion getMispawn() {
		return miSpawn;
	}
	
	
	
}
