package personajes;

import entidadesLogicas.Posicion;

public class Chase implements EstadoEnemigo {
	
	protected ChaseIA miInteligencia;
	protected Enemigo miEnemigo;
	protected Principal miDestino;
	protected Posicion posicionPrincipal;
	
	public Chase(ChaseIA miInteligencia) {
		this.miInteligencia = miInteligencia;
	}
	
	@Override
	public Posicion siguientePosicion() {
		return miInteligencia.calcularSiguientePosicion(miEnemigo, miDestino);
	}
	
	@Override
	public void setPosicionObjetivo(Posicion posicionObjetivo) {
		this.posicionPrincipal = posicionObjetivo;
	}

	@Override
	public void setEnemigo(Enemigo e) {
		this.miEnemigo = e;
	}

	@Override
	public void setPrincipal(Principal p) {
		miDestino = p;	
	}

}
