package personajes;

import entidadesGraficas.PrincipalGrafico;
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
	}
	
	@Override
	public void recibirEfecto() {
		// TODO Auto-generated method stub
		
	}
	
	public static Principal getPrincipal(Juego miJuego, String[] imagenes) {
		if (original == null) {
			original = new Principal(miJuego, imagenes);
		}
		
		return original;
	}

	@Override
	public void afectar() {
		// TODO Auto-generated method stub
		
	}
}
