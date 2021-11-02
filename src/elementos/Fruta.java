package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Posicion;

public class Fruta extends Elemento {
	
	protected ElementoGrafico miRepresentacionGrafica;
	
	public Fruta(ElementoGrafico miRepresentacionGrafica) {
		this.miRepresentacionGrafica = miRepresentacionGrafica;
		miSpawn = new Posicion(300,300);
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());
	}
	
	@Override
	public void afectar() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void iniciarTimer(HiloElemento timer) {
		// TODO Auto-generated method stub
		
	}
	
}
