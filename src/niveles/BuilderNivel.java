package niveles;

import dominios.DominioJuego;
import entidadesLogicas.Grilla;

public class BuilderNivel implements Builder {
	
	// Atributos de instancia
	private Nivel nivel;
	
	public BuilderNivel() {
		this.reset();
	}
	
	@Override
	public void reset() {
		nivel = new Nivel();
	}
	
	@Override
	public void setGrilla(Grilla g) {
		nivel.setGrilla(g);
	}
	
	@Override
	public void setDominio(DominioJuego d) {
		nivel.setDominio(d);
	}
	
	@Override
	public void setNivelActual(int n) {
		nivel.setNivelActual(n);
		
	}
	
	@Override
	public void setDuracionPowerPellet(int d) {
		nivel.setDuracionPowerPellet(d);
	}

	@Override
	public void setDuracionPociones(int d) {
		nivel.setDuracionPociones(d);
	}

	@Override
	public void setDuracionFrutas(int d) {
		nivel.setDuracionFrutas(d);
	}

	@Override
	public void setVelocidadEnemigos(int v) {
		nivel.setVelocidadEnemigos(v);
	}

	/**
	 * @return Devuelve un producto (nivel), luego de que la construccion del mismo finaliza.
	 */
	public Nivel getProduct() {
		return nivel;
	}
	
}
