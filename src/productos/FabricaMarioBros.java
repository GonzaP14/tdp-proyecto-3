package productos;

import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;
import personajes.*;
import elementos.*;

public class FabricaMarioBros extends FabricaEntidades {
	public FabricaMarioBros(Juego miJuego) {
		this.miJuego = miJuego;
	}
	
	@Override
	public Principal getPrincipal() {
		String[] imagenes = new String[5];
		imagenes[0] = "/recursosMarioBros/MarioArriba.gif";
		imagenes[1] = "/recursosMarioBros/MarioAbajo.gif";
		imagenes[2] = "/recursosMarioBros/MarioIzquierda.gif";
		imagenes[3] = "/recursosMarioBros/MarioDerecha.gif";
		imagenes[4] = "/recursosMarioBros/MarioDerecha.gif";
		
		return Principal.getPrincipal(miJuego, imagenes);
	}
	
	@Override
	public Enemigo getBlinky() {
		String[] imagenes = new String[9];
		
		imagenes[0] = ("/recursosMarioBros/GoompaArriba.gif");
		imagenes[1] = ("/recursosMarioBros/GoompaAbajo.gif");
		imagenes[2] = ("/recursosMarioBros/GoompaDerecha.gif");
		imagenes[3] = ("/recursosMarioBros/GoompaIzquierda.gif");
		imagenes[4] = ("/recursosMarioBros/GoompaMuerto.gif");
		imagenes[5] = ("/recursosMarioBros/GoompaArribaEscapando.gif");
		imagenes[6] = ("/recursosMarioBros/GoompaAbajoEscapando.gif");
		imagenes[7] = ("/recursosMarioBros/GoompaDerechaEscapando.gif");
		imagenes[8] = ("/recursosMarioBros/GoompaIzquierdaEscapando.gif");

		return new Blinky(miJuego, imagenes);
	}
	
	@Override
	public Enemigo getPinky() {
		String[] imagenes = new String[9];
		imagenes[0] = ("/recursosMarioBros/BooArriba.gif");
		imagenes[1] = ("/recursosMarioBros/BooAbajo.gif");
		imagenes[2] = ("/recursosMarioBros/BooDerecha.gif");
		imagenes[3] = ("/recursosMarioBros/BooIzquierda.gif"); 
		imagenes[4] = ("/recursosMarioBros/BooMuerto.gif"); 
		imagenes[5] = ("/recursosMarioBros/BooArribaEscapando.gif");
		imagenes[6] = ("/recursosMarioBros/BooAbajoEscapando.gif");
		imagenes[7] = ("/recursosMarioBros/BooDerechaEscapando.gif");
		imagenes[8] = ("/recursosMarioBros/BooIzquierdaEscapando.gif");
		
		return new Pinky(miJuego, imagenes);
	}	

	@Override
	public Enemigo getInky() {
		String[] imagenes = new String[9];
		imagenes[0] = ("/recursosMarioBros/BowserArriba.gif");
		imagenes[1] = ("/recursosMarioBros/BowserAbajo.gif");
		imagenes[2] = ("/recursosMarioBros/BowserDerecha.gif");
		imagenes[3] = ("/recursosMarioBros/BowserIzquierda.gif"); 
		imagenes[4] = ("/recursosMarioBros/BowserMuerto.gif"); 
		imagenes[5] = ("/recursosMarioBros/BowserArribaEscapando.gif");
		imagenes[6] = ("/recursosMarioBros/BowserAbajoEscapando.gif");
		imagenes[7] = ("/recursosMarioBros/BowserDerechaEscapando.gif");
		imagenes[8] = ("/recursosMarioBros/BowserIzquierdaEscapando.gif");
		
		return new Inky(miJuego, imagenes);
	}

	@Override
	public Enemigo getClyde() {
		String[] imagenes = new String[9];
		imagenes[0] = ("/recursosMarioBros/KoopaTroopaArriba.gif");
		imagenes[1] = ("/recursosMarioBros/KoopaTroopaAbajo.gif");
		imagenes[2] = ("/recursosMarioBros/KoopaTroopaDerecha.gif");
		imagenes[3] = ("/recursosMarioBros/KoopaTroopaIzquierda.gif"); 
		imagenes[4] = ("/recursosMarioBros/KoopaTroopaMuerto.gif"); 
		imagenes[5] = ("/recursosMarioBros/KoopaTroopaArribaEscapando.gif");
		imagenes[6] = ("/recursosMarioBros/KoopaTroopaAbajoEscapando.gif");
		imagenes[7] = ("/recursosMarioBros/KoopaTroopaDerechaEscapando.gif");
		imagenes[8] = ("/recursosMarioBros/KoopaTroopaIzquierdaEscapando.gif");
		
		return new Clyde(miJuego, imagenes);
	}

	@Override
	public Elemento getFruta() {
		String imagen = ("/recursosMarioBros/Flor.png");
		
		return new Fruta(miJuego, imagen);
	}
	
	public Pocion getPocionVelocidad() {
		String imagen = ("/recursosMarioBros/HongoVerde.png");
		
		return new PocionVelocidad(miJuego, imagen);
	}
	
	@Override
	public Pocion getPocionCongelacion() {
		String imagen = ("/recursosMarioBros/HongoRojo.png");
		
		return new PocionCongelacion(miJuego, imagen);
	}

	@Override
	public Elemento getPowerPellet(Posicion posicion) {
		String imagen = ("/recursosMarioBros/Estrella.png");
		
		return new PowerPellet(miJuego, imagen , posicion);
	}

	@Override
	public Elemento getPacDot(Posicion posicion) {
		String imagen = ("/recursosMarioBros/Moneda.png");
		
		return new PacDot(miJuego, imagen , posicion);
	}

}
