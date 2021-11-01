package entidadesLogicas;

import entidadesGraficas.GrillaGrafica;

public class Grilla {
	
	private Bloque grilla[][];
	
	public static Bloque spawnCasaFantasmas, spawnLibreFantasma, spawnPrincipal;
	public static final int Filas = 31;
    public static final int Columnas = 28;
    
	public GrillaGrafica miRepresentacionGrafica;
	
	// ------------------------------------ Constructor ------------------------------------------
	
	public Grilla() {
		grilla = new Bloque [Filas][Columnas];
		
		for (int filas = 0; filas < Filas; filas ++) {
			for (int columnas = 0;columnas < Columnas; columnas ++) {
				grilla[filas][columnas] = new Bloque(filas,columnas,true);
			}
		}
		
		miRepresentacionGrafica = new GrillaGrafica(this);
	}
	
	// ------------------------------------   Metodos   ------------------------------------------
	public boolean buscarColisiones(Par posiciones) {
		return false;
	}
	
	public void resetear() {
	
	}
	
	public Bloque getBloque(int x , int y) {
		return grilla[x][y];
	}
	
	public GrillaGrafica getRepresentacionGrafica() {
		return miRepresentacionGrafica;  
	}
	
}
