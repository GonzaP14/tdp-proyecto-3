package entidadesLogicas;

public class Grilla {
	
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
	}
}
