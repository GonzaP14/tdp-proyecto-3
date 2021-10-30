package entidadesLogicas;
public class Grilla {
<<<<<<< HEAD
	// Atributos de instancia
	private int fila, columna;
	// Atributos de clase
	public static Bloque spawnCasaFantasmas, spawnLibreFantasma, spawnPrincipal;
	
	// ------------------------------------ Constructor ------------------------------------------
	
	public Grilla() {
		
	}
	
	// ------------------------------------   Metodos   ------------------------------------------
	public boolean buscarColisiones(Par posiciones) {
		return false;
	}
	
	public void resetear() {
		
=======
	
	protected static final int cantidadDeFilas = 31;
	protected static final int cantidadDeColumnas = 28;
	
	private Bloque grilla[][];	
	
	public Grilla() {
		grilla = new Bloque[cantidadDeFilas][cantidadDeColumnas];
        
    	for (int filas = 0 ; filas < cantidadDeFilas ; filas ++ ) {
    		for (int columnas = 0 ; columnas < cantidadDeColumnas ; columnas++ ) {                    
    			grilla[filas][columnas] = new Bloque();     
            }
    	}
>>>>>>> d3705f23cb223d12c335daeaf705a0a9f52b56fe
	}
}
