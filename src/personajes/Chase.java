package personajes;

import entidadesLogicas.Posicion;

public class Chase implements EstadoEnemigo {
	
	protected ChaseIA miInteligencia;
	protected Posicion posicionEnemigo;
	protected Posicion posicionPrincipal;
	
	public Chase(ChaseIA miInteligencia) {
		this.miInteligencia = miInteligencia;
	}
	
	@Override
	public Posicion siguientePosicion() {
		return miInteligencia.calcularSiguientePosicion(posicionEnemigo, posicionPrincipal);
	}

	@Override
	public void setPosicionEnemigo(Posicion posicionEnemigo) {
		this.posicionEnemigo = posicionEnemigo;
	}

	@Override
	public void setPosicionObjetivo(Posicion posicionObjetivo) {
		this.posicionPrincipal = posicionObjetivo;
	}

}
