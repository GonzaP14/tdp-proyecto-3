package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Posicion;

public class PocionCongelacion extends Pocion {
	
	public PocionCongelacion(ElementoGrafico miRepresentacionGrafica) {
		this.miRepresentacionGrafica = miRepresentacionGrafica;
		miSpawn = new Posicion(300,300);
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());
		this.miRepresentacionGrafica.aparecer(miPosicion);
	}

	@Override
	public void afectar() {
		// TODO Auto-generated method stub
		
	}
	
}
