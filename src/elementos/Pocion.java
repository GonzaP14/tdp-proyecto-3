package elementos;

public abstract class Pocion extends Elemento {
	protected int velocidadOtorgada, puntajeOtorgado;
	@Override
	protected void iniciarTimer(HiloElemento timer) {
		timer.start();
	}

	@Override
	public abstract void afectar();
	
	public void despawnear() {
		miJuego.getGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaRemovidos(this);
		miRepresentacion.desaparecer();
	}

	public int getVelocidadOtorgada() {
		return velocidadOtorgada;
	}
	
	public int getPuntajeOtorgado() {
		return puntajeOtorgado;
	}
	
	
}
