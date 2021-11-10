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
	public boolean buscarColisiones(Entidad entidad, Posicion proximaPos, Par offsetBloqueSiguiente) {
		boolean collisionFound = false;

		System.out.println("Proxima Pos: (" + proximaPos.getX() + ", " + proximaPos.getY() + ")\n");
		if (
				grilla[(int) Math.floor((proximaPos.getY() + 12.5 + offsetBloqueSiguiente.getY()) / 25)][(int) Math.floor((proximaPos.getX() + 12.5 + offsetBloqueSiguiente.getX()) / 25)].isPuedeVisitarse() == false )
			collisionFound = true;
		
		
		return collisionFound;
	}
	
	public void resetear() {
	
	}
	
	public Bloque getBloque(int x, int y) {
		return grilla[x][y];
	}
	
}
