package entidadesLogicas;

import entidadesGraficas.Laberinto;

public interface BuilderNivel {
	public Laberinto getLaberinto(Grilla grilla, int dominio);
	public int getIncrementoVelocidadEnemigos();
	public int getDuracionPowerPellet();
	public int getDuracionPociones();
	public int getDuracionFrutas();
}
