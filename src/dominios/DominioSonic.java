package dominios;

public class DominioSonic implements DominioJuego {

	@Override
	public String[] getSkinsPrincipal() {
		String[] imagenes = new String[13];
        
		imagenes[0] = "/recursosSonic/sonicArriba.gif";
        imagenes[1] = "/recursosSonic/sonicAbajo.gif";
        imagenes[2] = "/recursosSonic/sonicIzquierda.gif";
        imagenes[3] = "/recursosSonic/sonicDerecha.gif";
        imagenes[4] = "/recursosSonic/sonicDerecha.gif";
        
        imagenes[5] = "/recursosMarioBros/MarioArriba.gif";
		imagenes[6] = "/recursosMarioBros/MarioAbajo.gif";
		imagenes[7] = "/recursosMarioBros/MarioIzquierda.gif";
		imagenes[8] = "/recursosMarioBros/MarioDerecha.gif";
		
		imagenes[9] = "/recursosSonic/shadowArribaEscapando.gif";
		imagenes[10] = "/recursosSonic/shadowAbajoEscapando.gif";
		imagenes[11] = "/recursosSonic/shadowIzquierdaEscapando.gif";
		imagenes[12] = "/recursosSonic/shadowDerechaEscapando.gif";
        
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
		imagenes[2] = ("/recursosSonic/shadowIzquierda.gif");
		imagenes[3] = ("/recursosSonic/shadowDerecha.gif"); 
		imagenes[4] = ("/recursosSonic/fantasmaMuerto.gif"); 
		imagenes[5] = ("/recursosSonic/shadowArribaEscapando.gif");
		imagenes[6] = ("/recursosSonic/shadowAbajoEscapando.gif");
		imagenes[7] = ("/recursosSonic/shadowIzquierdaEscapando.gif");
		imagenes[8] = ("/recursosSonic/shadowDerechaEscapando.gif");
		
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
		imagenes[7] = ("/recursosSonic/eggManIzquierdaEscapando.gif");
		imagenes[8] = ("/recursosSonic/eggManDerechaEscapando.gif");
		
		return imagenes;
	}

	@Override
	public String[] getFruta() {
		String[] imagenes = new String[3];

		imagenes[0] = ("/recursosSonic/gemaAzul.png");
		imagenes[1] = ("/recursosSonic/gemaAzul.png");
		imagenes[2] = ("/recursosSonic/gemaAzul.png");

		return imagenes;
	}

	@Override
	public String[] getPocionVelocidad() {
		String[] imagenes = new String[1];

		imagenes[0] = ("/recursosSonic/gemaVerde.png");

		return imagenes;
	}

	@Override
	public String[] getPocionBomba() {
		String[] imagenes = new String[2];

		imagenes[0] = ("/recursosSonic/bomba.png");
		imagenes[1] = ("/recursosSonic/bomba.gif");
		
		
		return imagenes;
	}

	@Override
	public String[] getPowerPellet() {
		String[] imagenes = new String[1];

		imagenes[0] = ("/recursosSonic/estrellasSonic.png");

		return imagenes;
	}

	@Override
	public String[] getPacDot() {
		String[] imagenes = new String[1];

		imagenes[0] = ("/recursosSonic/Anillo.png");

		return imagenes;
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

	@Override
	public String getSonidoWin() {
		return new String("/recursosAudio/winSonic.wav");
	}

	

}
