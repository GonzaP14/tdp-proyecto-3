package entidadesLogicas;

public interface EstrategiaNivel {
	public void construirGrilla(Bloque[][] grilla);
	public int getIncrementoVelocidadEnemigos();
	public int getDuracionPowerPellet();
	public int getDuracionPociones();
	public int getDuracionFrutas();
}
