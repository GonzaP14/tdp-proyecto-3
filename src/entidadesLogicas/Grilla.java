package entidadesLogicas;

public class Grilla {
	
	protected Bloque grilla[][];
	public static final int Filas = 31;
    public static final int Columnas = 28;
	
	// ------------------------------------ Constructor ------------------------------------------
	
	public Grilla() {
		grilla = new Bloque [Filas][Columnas];
		
		for (int i = 0; i < Filas; i ++) {
			for (int j = 0; j < Columnas; j ++) {
				grilla[i][j] = new Bloque(i,j,true);
			}
		}
	}
	
	// ------------------------------------   Metodos   ------------------------------------------
	public boolean buscarColisiones(Posicion posiciones) {
		Posicion izquierdaArriba = new Posicion(posiciones.getX() / 10 , posiciones.getY() / 10);
		
		if(grilla[izquierdaArriba.getX()][izquierdaArriba.getY()].isPuedeVisitarse() == false )
			return true;
		else
			return false;
	}
	
	public void resetear() {
	
	}
	
	public Bloque getBloque(int x, int y) {
		return grilla[x][y];
	}
	
}
