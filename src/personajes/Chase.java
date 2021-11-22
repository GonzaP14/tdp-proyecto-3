package personajes;

import entidadesLogicas.Posicion;

public class Chase implements EstadoEnemigo {
	
	protected ChaseIA miInteligencia;
	protected Enemigo miEnemigo;
	protected Principal miDestino;
	protected Posicion posicionPrincipal;
	
	public Chase(ChaseIA miInteligencia , Enemigo miEnemigo , Principal miPrincipal) {
		this.miInteligencia = miInteligencia;
		this.miEnemigo = miEnemigo;
		this.miDestino = miPrincipal;
	}
	
	@Override
	public Posicion siguientePosicion() {
		return miInteligencia.siguientePosicion();
	}
}
