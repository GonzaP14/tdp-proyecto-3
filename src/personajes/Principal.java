package personajes;

import entidadesGraficas.PrincipalGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class Principal extends Personaje {
	
	protected static Principal original;
	protected static final int Vivo = 1;
	protected static final int Muerto = 2;
	
	protected PrincipalGrafico miRepresentacionGrafica;
	protected int estadoActual;
	
	private Principal(Juego miJuego, String[] imagenes) { // singleton principle
		System.out.println(imagenes[0]);
		miRepresentacionGrafica = new PrincipalGrafico(imagenes);
		estadoActual = Vivo;
		this.miJuego = miJuego;
		miSpawn = new Posicion(100,100);
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());
		this.miRepresentacionGrafica.aparecer(miPosicion);
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
	
	public PrincipalGrafico getMiRepresentacion() {
		return miRepresentacionGrafica;
	}
	
}
