package entidadesLogicas;

public class Par {
	
	private int x;
	private int y;
	
	public Par(int x , int y ) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Obtengo la coordenada x de un Par
	 * @return coordenada x
	 */
	public int getX() {
		return x;
	}
	/**
	 * Modifico la coordenada x de un Par
	 * @param x coordenada x que voy a darle al Par
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * Obtengo la coordenada Y de un Par
	 * @return coordenada Y
	 */
	public int getY() {
		return y;
	}
	/**
	 * Modifico la coordenada y de un Par
	 * @param y coordenada y que voy a darle al Par
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * Clono un par 
	 */
	public Par clone() {
		return new Par (x, y);
	}
	
	public int distanciaEntreParesPitagoras(Par parActual , Par parAlQueQuieroIr ) {
		double distanciaX = parActual.getX() - parAlQueQuieroIr.getX();
		double distanciaY = parActual.getY() - parAlQueQuieroIr.getY();
		double cuadrado = 2;
		int distanciaPitagoras = (int) (Math.pow(distanciaX, cuadrado) + Math.pow(distanciaY, cuadrado));
		
		return distanciaPitagoras;
	}
	
	public Par distanciaEntrePares(Par parActual , Par parAlQueQuieroIr) {
		Par parARetornar; 		
		int distanciaX = parActual.getX() - parAlQueQuieroIr.getX();
		int distanciaY = parActual.getY() - parAlQueQuieroIr.getY();
		
		parARetornar = new Par(distanciaX , distanciaY);
		
		return parARetornar;
	}
}
