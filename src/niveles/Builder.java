package niveles;

import dominios.DominioJuego;

public interface Builder {
	
	public void reset();
	
	public void setGrilla(Grilla g);
	
	public void setNivelActual(int n);
	
	public void setDominio(DominioJuego d);
	
	public void setDuracionPowerPellet(int d);
	
	public void setDuracionPociones(int d);
	
	public void setDuracionFrutas(int d);
	
	public void setVelocidadEnemigos(int v);
	
}
