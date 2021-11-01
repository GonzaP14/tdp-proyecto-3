package entidadesLogicas;
public class Grilla {
	// Atributos de instancia
	private int fila, columna;
	private Bloque grilla[][];
	// Atributos de clase
	public static Bloque spawnCasaFantasmas, spawnLibreFantasma, spawnPrincipal;
	
	// ------------------------------------ Constructor ------------------------------------------
	
	public Grilla() {
		for(int filas=0;filas<31;filas++) {
			for(int columnas=0;columnas<28;columnas++) {
				grilla[filas][columnas]=new Bloque(filas,columnas,true);
			}
		}
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
}
