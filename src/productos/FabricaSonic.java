package productos;

import elementos.Elemento;
import elementos.Fruta;
import elementos.PacDot;
import elementos.Pocion;
import elementos.PocionCongelacion;
import elementos.PocionVelocidad;
import elementos.PowerPellet;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;
import personajes.Blinky;
import personajes.Clyde;
import personajes.Enemigo;
import personajes.Inky;
import personajes.Pinky;
import personajes.Principal;

public class FabricaSonic extends FabricaEntidades {
	
	public FabricaSonic(Juego miJuego) {
		this.miJuego = miJuego;
	}
	
	@Override
	public Principal getPrincipal() {
		String[] imagenes = new String[5];
        imagenes[0] = "/recursosSonic/sonicArriba.gif";
        imagenes[1] = "/recursosSonic/sonicAbajo.gif";
        imagenes[2] = "/recursosSonic/sonicDerecha.gif";
        imagenes[3] = "/recursosSonic/sonicIzquierda.gif";
        imagenes[4] = "/recursosSonic/sonicDerecha.gif";
        
        return Principal.getPrincipal(miJuego, imagenes);
	}

	@Override
	public Enemigo getBlinky() {
		String[] imagenes = new String[9];
		
		imagenes[0] = ("/recursosSonic/cangrejo1.gif");
		imagenes[1] = ("/recursosSonic/cangrejo1.gif");
		imagenes[2] = ("/recursosSonic/cangrejo1.gif");
		imagenes[3] = ("/recursosSonic/cangrejo1.gif");
		imagenes[4] = ("/recursosSonic/cangrejo1.gif");
		imagenes[5] = ("/recursosSonic/cangrejo1Escapando.gif");
		imagenes[6] = ("/recursosSonic/cangrejo1Escapando.gif");
		imagenes[7] = ("/recursosSonic/cangrejo1Escapando.gif");
		imagenes[8] = ("/recursosSonic/cangrejo1Escapando.gif");

		return new Blinky(miJuego, imagenes);
	}

	@Override
	public Enemigo getPinky() {
		String[] imagenes = new String[9];
		imagenes[0] = ("/recursosSonic/cangrejo2.gif");
		imagenes[1] = ("/recursosSonic/cangrejo2.gif");
		imagenes[2] = ("/recursosSonic/cangrejo2.gif");
		imagenes[3] = ("/recursosSonic/cangrejo2.gif");
		imagenes[4] = ("/recursosSonic/cangrejo2.gif");
		imagenes[5] = ("/recursosSonic/cangrejo2Escapando.gif");
		imagenes[6] = ("/recursosSonic/cangrejo2Escapando.gif");
		imagenes[7] = ("/recursosSonic/cangrejo2Escapando.gif");
		imagenes[8] = ("/recursosSonic/cangrejo2Escapando.gif");
		
		return new Pinky(miJuego, imagenes);
	}

	@Override
	public Enemigo getInky() {
		String[] imagenes = new String[9];
		imagenes[0] = ("/recursosSonic/shadowArriba.gif");
		imagenes[1] = ("/recursosSonic/shadowAbajo.gif");
		imagenes[2] = ("/recursosSonic/shadowDerecha.gif");
		imagenes[3] = ("/recursosSonic/shadowIzquierda.gif"); 
		imagenes[4] = ("/recursosSonic/shadowDerecha.gif"); 
		imagenes[5] = ("/recursosSonic/shadowArribaEscapando.gif");
		imagenes[6] = ("/recursosSonic/shadowAbajoEscapando.gif");
		imagenes[7] = ("/recursosSonic/shadowDerechaEscapando.gif");
		imagenes[8] = ("/recursosSonic/shadowIzquierdaEscapando.gif");
		
		return new Inky(miJuego, imagenes);
	}

	@Override
	public Enemigo getClyde() {
		String[] imagenes = new String[9];
		imagenes[0] = ("/recursosSonic/eggManArriba.gif");
		imagenes[1] = ("/recursosSonic/eggManAbajo.gif");
		imagenes[2] = ("/recursosSonic/eggManDerecha.gif");
		imagenes[3] = ("/recursosSonic/eggManIzquierda.gif"); 
		imagenes[4] = ("/recursosSonic/eggManDerecha.gif"); 
		imagenes[5] = ("/recursosSonic/eggManArribaEscapando.gif");
		imagenes[6] = ("/recursosSonic/eggManAbajoEscapando.gif");
		imagenes[7] = ("/recursosSonic/eggManDerechaEscapando.gif");
		imagenes[8] = ("/recursosSonic/eggManIzquierdaEscapando.gif");
		
		return new Clyde(miJuego, imagenes);
	}

	@Override
	public Elemento getFruta() {
		String imagen = ("/recursosSonic/gemaAzul.png");		
		return new Fruta(miJuego, imagen);
	}

	@Override
	public Elemento getPacDot(Posicion posicion) {
		String imagen = ("/recursosSonic/Anillo.png");
		
		return new PacDot(miJuego, imagen , posicion);
	}

	@Override
	public Pocion getPocionCongelacion() {
		String imagen = ("/recursosSonic/gemaCeleste.png");
		
		return new PocionCongelacion(miJuego, imagen);
	}

	@Override
	public Pocion getPocionVelocidad() {
		String imagen = ("/recursoSonic/gemaVerde.png");
		
		return new PocionVelocidad(miJuego, imagen);
	}

	@Override
	public Elemento getPowerPellet(Posicion posicion) {
		String imagen = ("/recursosSonic/estrellasSonic.png");
		
		return new PowerPellet(miJuego, imagen , posicion);
	}

}
