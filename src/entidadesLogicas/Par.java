package entidadesLogicas;
import java.awt.Point;

public class Par extends Point {
	
	public Par(int x , int y ) {
		this.x = x;
		this.y = y;
	}
	
	public double distanciaEntreParesPitagoras(Par parActual , Par parAlQueQuieroIr ) {
		double distanciaX = parActual.getX() - parAlQueQuieroIr.getX();
		double distanciaY = parActual.getY() - parAlQueQuieroIr.getY();
		double cuadrado = 2;
		double distanciaPitagoras = Math.pow(distanciaX, cuadrado) + Math.pow(distanciaY, cuadrado);
		
		return distanciaPitagoras;
	}
	
	public Par distanciaEntrePares(Par parActual , Par parAlQueQuieroIr) {
		Par parARetornar; 		
		int distanciaX = (int) (parActual.getX() - parAlQueQuieroIr.getX());
		int distanciaY = (int) (parActual.getY() - parAlQueQuieroIr.getY());
		
		parARetornar = new Par(distanciaX , distanciaY);
		
		return parARetornar;
	}
>>>>>>> d3705f23cb223d12c335daeaf705a0a9f52b56fe
}
