package niveles;

import dominios.DominioJuego;

public class BuilderNivel implements Builder {
	
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

	public Nivel getProduct() {
		return nivel;
	}
	
}
