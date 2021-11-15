package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;
import personajes.Enemigo;

public class PocionCongelacion extends Pocion {
	private static final Posicion miSpawn = new Posicion(325, 425);//Debe ser abajo de la casa de los fantasmas
	
	public PocionCongelacion(Juego miJuego, String imagen) {
		this.miJuego = miJuego;
		miPosicion = new Posicion((int) miSpawn.getX(), (int) miSpawn.getY());
		miRepresentacion = new ElementoGrafico(imagen);
		miRepresentacion.aparecer(miPosicion);
		velocidadOtorgada = 1;
		miJuego.getGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaEntidades(this);
	}

	@Override
	public void afectar() {
		iniciarTimer(new HiloElemento(miJuego, miJuego.getNivel().getDuracionPociones() , this) );
		for(Enemigo e : miJuego.getMisEnemigos())
			e.recibirEfecto(this);
		miJuego.getGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaRemovidos(this);
		miRepresentacion.desaparecer();
	}

	@Override
	public void operacionEnHilo() {
		for(Enemigo e : miJuego.getMisEnemigos()) {
			e.setVelocidadActual(miJuego.getNivel().getVelocidadEnemigos());
			e.getMiHilo().setVelocidadTickeo(miJuego.getNivel().getVelocidadEnemigos());
		}
	}

	public static Posicion getMispawn() {
		return miSpawn;
	}
	
	
}
