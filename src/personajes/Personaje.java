package personajes;

import entidadesLogicas.Entidad;

public abstract class Personaje extends Entidad {
	
	public abstract void recibirEfecto();
	
	public void mover(int movimiento) {
		
	}
	
	@SuppressWarnings("unused")
	private void moverLateralmente(int desplazamiento) {
	
	}
	
	@SuppressWarnings("unused")
	private void moverVerticalmente(int desplazamiento) {
		
	}
	
	public void morir() {
		
	}
	
}
