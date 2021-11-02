package personajes;

import entidadesGraficas.PrincipalGrafico;
import entidadesLogicas.Posicion;

public class Principal extends Personaje {
	
	protected static Principal original;
	protected static final int Vivo = 1;
	protected static final int Muerto = 2;
	
	protected PrincipalGrafico miRepresentacionGrafica;
	protected int estadoActual;
	
	public Principal() {
		estadoActual = Vivo;
		miRepresentacionGrafica = new PrincipalGrafico();
		miPosicion = new Posicion(150,150);
	}
	
	@Override
	public void recibirEfecto() {
		// TODO Auto-generated method stub
		
	}
	
	public Principal getPrincipal() {
		return original;
	}

	@Override
	public void afectar() {
		// TODO Auto-generated method stub
		
	}
	
}
