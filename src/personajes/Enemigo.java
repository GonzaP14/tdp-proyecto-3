package personajes;

public abstract class Enemigo extends Personaje {
	
	protected EstadoEnemigo estadoActual; 
	protected EstadoEnemigo [] estados;
	protected int indiceEstado;
	protected int tiempoEstado;
	protected int velocidad;
	private static final int puntajeOtorgado = 200;
	
	public static final int Frightened = 1;
	public static final int Chase = 2;
	public static final int Eaten = 3;
	public static final int Scatter = 4;
	
	@Override
	public void afectar() {
		if(indiceEstado == Frightened) {
			
		}
		else {
			
		}
	}
	
	@Override
	public void recibirEfecto() {
		
	}
	
	public void cambiarEstado (int estado) {
		
	}
	
	public void recuperarse () {
		
	}
	
	public boolean estaAterrado() {
		return false;
	}
	
	public boolean estaPersiguiendo() {
		return false;
	}
	
	public boolean estaComido() {
		return false;
	}
	
	public boolean estaDisperso() {
		return false;
	}
	
	public double distanciaConPrincipal() {
		return 0;
	}
	
}
