package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Posicion;

public class PocionVelocidad extends Pocion {
	
	protected ElementoGrafico miRepresentacionGrafica;
	
	public PocionVelocidad (ElementoGrafico miRepresentacionGrafica) {
		this.miRepresentacionGrafica = miRepresentacionGrafica;
		miSpawn = new Posicion(300,300);
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());
	}

	@Override
	public void afectar() {
		// TODO Auto-generated method stub
		
	}
	
}
