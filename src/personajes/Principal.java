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
	
	public Principal(PrincipalGrafico miRepresentacionGrafica , Juego miJuego ) { // singleton principle
		estadoActual = Vivo;
		this.miRepresentacionGrafica = miRepresentacionGrafica;
		this.miJuego = miJuego;
		miSpawn = new Posicion(100,100);
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());
		this.miRepresentacionGrafica.aparecer(miPosicion);
	}
	
	@Override
	public void recibirEfecto() {
		// TODO Auto-generated method stub
		
	}
	
	/*public static Principal getPrincipal(PrincipalGrafico miRepresentacionGrafica) {
		if (original == null) {
			original = new Principal(miRepresentacionGrafica);
		}
		return original;
	}*/

	@Override
	public void afectar() {
		// TODO Auto-generated method stub
		
	}
	
}
