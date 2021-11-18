package entidadesLogicas;

public class DominioSonic implements DominioJuego {

	@Override
	public String[] getSkinsPrincipal() {
		String[] imagenes = new String[5];
        
		imagenes[0] = "/recursosSonic/sonicArriba.gif";
        imagenes[1] = "/recursosSonic/sonicAbajo.gif";
        imagenes[2] = "/recursosSonic/sonicIzquierda.gif";
        imagenes[3] = "/recursosSonic/sonicDerecha.gif";
        imagenes[4] = "/recursosSonic/sonicDerecha.gif";
        
        return imagenes;
	}

	@Override
	public String[] getSkinsBlinky() {
		String[] imagenes = new String[9];
		
		imagenes[0] = ("/recursosSonic/cangrejo1.gif");
		imagenes[1] = ("/recursosSonic/cangrejo1.gif");
		imagenes[2] = ("/recursosSonic/cangrejo1.gif");
		imagenes[3] = ("/recursosSonic/cangrejo1.gif");
		imagenes[4] = ("/recursosSonic/fantasmaMuerto.gif");
		imagenes[5] = ("/recursosSonic/cangrejo1Escapando.gif");
		imagenes[6] = ("/recursosSonic/cangrejo1Escapando.gif");
		imagenes[7] = ("/recursosSonic/cangrejo1Escapando.gif");
		imagenes[8] = ("/recursosSonic/cangrejo1Escapando.gif");
		
		return imagenes;
	}

	@Override
	public String[] getSkinsPinky() {
		String[] imagenes = new String[9];
		
		imagenes[0] = ("/recursosSonic/cangrejo2.gif");
		imagenes[1] = ("/recursosSonic/cangrejo2.gif");
		imagenes[2] = ("/recursosSonic/cangrejo2.gif");
		imagenes[3] = ("/recursosSonic/cangrejo2.gif");
		imagenes[4] = ("/recursosSonic/fantasmaMuerto.gif");
		imagenes[5] = ("/recursosSonic/cangrejo2Escapando.gif");
		imagenes[6] = ("/recursosSonic/cangrejo2Escapando.gif");
		imagenes[7] = ("/recursosSonic/cangrejo2Escapando.gif");
		imagenes[8] = ("/recursosSonic/cangrejo2Escapando.gif");
		
		return imagenes;
	}

	@Override
	public String[] getSkinsInky() {
		String[] imagenes = new String[9];
		
		imagenes[0] = ("/recursosSonic/shadowArriba.gif");
		imagenes[1] = ("/recursosSonic/shadowAbajo.gif");
		imagenes[2] = ("/recursosSonic/shadowDerecha.gif");
		imagenes[3] = ("/recursosSonic/shadowIzquierda.gif"); 
		imagenes[4] = ("/recursosSonic/fantasmaMuerto.gif"); 
		imagenes[5] = ("/recursosSonic/shadowArribaEscapando.gif");
		imagenes[6] = ("/recursosSonic/shadowAbajoEscapando.gif");
		imagenes[7] = ("/recursosSonic/shadowDerechaEscapando.gif");
		imagenes[8] = ("/recursosSonic/shadowIzquierdaEscapando.gif");
		
		return imagenes;
	}

	@Override
	public String[] getSkinsClyde() {
		String[] imagenes = new String[9];
		
		imagenes[0] = ("/recursosSonic/eggManArriba.gif");
		imagenes[1] = ("/recursosSonic/eggManAbajo.gif");
		imagenes[2] = ("/recursosSonic/eggManDerecha.gif");
		imagenes[3] = ("/recursosSonic/eggManIzquierda.gif"); 
		imagenes[4] = ("/recursosSonic/fantasmaMuerto.gif"); 
		imagenes[5] = ("/recursosSonic/eggManArribaEscapando.gif");
		imagenes[6] = ("/recursosSonic/eggManAbajoEscapando.gif");
		imagenes[7] = ("/recursosSonic/eggManDerechaEscapando.gif");
		imagenes[8] = ("/recursosSonic/eggManIzquierdaEscapando.gif");
		
		return imagenes;
	}

	@Override
	public String getFruta() {
		return new String("/recursosSonic/gemaAzul.png");	
	}

	@Override
	public String getPocionVelocidad() {
		return new String("/recursosSonic/gemaVerde.png");
	}

	@Override
	public String getPocionCongelacion() {
		return new String("/recursosSonic/gemaRoja.png");
	}

	@Override
	public String getPowerPellet() {
		return new String("/recursosSonic/estrellasSonic.png");
	}

	@Override
	public String getPacDot() {
		return new String("/recursosSonic/Anillo.png");
	}

	@Override
	public String getMusica() {
		return new String("/recursosAudio/musicaSonic.wav");
	}

	@Override
	public String getSonidoGameOver() {
		return new String("/recursosAudio/gameOverSonic.wav");
	}

	@Override
	public String getParedNivel1() {
		return new String("/recursosSonic/paredLvl1Sonic.png");
	}

	@Override
	public String getParedNivel2() {
		return new String("/recursosSonic/paredLvl2Sonic.png");
	}

	@Override
	public String getParedNivel3() {
		return new String("/recursosSonic/paredLvl3Sonic.png");
	}

	@Override
	public String getPuerta() {
		return new String("/recursosSonic/puertaSonic.png");
	}

	@Override
	public String getImagenVidas() {
		return new String("/recursosSonic/Sonic.png");
	}

}
