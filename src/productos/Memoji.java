package productos;

import elementos.Elemento;
import elementos.Pocion;
import entidadesLogicas.Juego;
import personajes.Enemigo;
import personajes.Principal;

public class Memoji extends FabricaEntidades {
	private Juego miJuego;
	public Memoji(Juego miJuego) {
		this.miJuego = miJuego;
	}
	
	@Override
	public Principal getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enemigo getBlinky() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enemigo getPinky() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enemigo getInky() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enemigo getClyde() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Elemento getFruta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Elemento getPacDot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pocion getPocionCongelacion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pocion getPocionVelocidad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Elemento getPowerPellet() {
		// TODO Auto-generated method stub
		return null;
	}

}
