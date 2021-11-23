package dominios;

public class DominioMarioBros implements DominioJuego {

	@Override
	public String[] getSkinsPrincipal() {
		String[] imagenes = new String[13];
		
		imagenes[0] = "/recursosMarioBros/MarioArriba.gif";
		imagenes[1] = "/recursosMarioBros/MarioAbajo.gif";
		imagenes[2] = "/recursosMarioBros/MarioIzquierda.gif";
		imagenes[3] = "/recursosMarioBros/MarioDerecha.gif";
		imagenes[4] = "/recursosMarioBros/MarioDerecha.gif";
		
		imagenes[5] = "/recursosMarioBros/MarioArribaAfectado.gif";
		imagenes[6] = "/recursosMarioBros/MarioAbajoAfectado.gif";
		imagenes[7] = "/recursosMarioBros/MarioIzquierdaAfectado.gif";
		imagenes[8] = "/recursosMarioBros/MarioDerechaAfectado.gif";
		
		imagenes[9] = "/recursosMarioBros/MarioArribaAfectado2.gif";
		imagenes[10] = "/recursosMarioBros/MarioAbajoAfectado2.gif";
		imagenes[11] = "/recursosMarioBros/MarioIzquierdaAfectado2.gif";
		imagenes[12] = "/recursosMarioBros/MarioDerechaAfectado2.gif";
		
		return imagenes;
	}

	@Override
	public String[] getSkinsBlinky() {
		String[] imagenes = new String[9];

		imagenes[0] = ("/recursosMarioBros/Goompa.gif");
		imagenes[1] = ("/recursosMarioBros/Goompa.gif");
		imagenes[2] = ("/recursosMarioBros/Goompa.gif");
		imagenes[3] = ("/recursosMarioBros/Goompa.gif");
		imagenes[4] = ("/recursosMarioBros/muerto.gif");
		imagenes[5] = ("/recursosMarioBros/GoompaEscapando.gif");
		imagenes[6] = ("/recursosMarioBros/GoompaEscapando.gif");
		imagenes[7] = ("/recursosMarioBros/GoompaEscapando.gif");
		imagenes[8] = ("/recursosMarioBros/GoompaEscapando.gif");
		
		return imagenes;
	}

	@Override
	public String[] getSkinsPinky() {
		String[] imagenes = new String[9];
		
		imagenes[0] = ("/recursosMarioBros/BooArriba.gif");
		imagenes[1] = ("/recursosMarioBros/BooAbajo.gif");
		imagenes[2] = ("/recursosMarioBros/BooIzquierda.gif");
		imagenes[3] = ("/recursosMarioBros/BooDerecha.gif"); 
		imagenes[4] = ("/recursosMarioBros/muerto.gif"); 
		imagenes[5] = ("/recursosMarioBros/BooArribaEscapando.gif");
		imagenes[6] = ("/recursosMarioBros/BooAbajoEscapando.gif");
		imagenes[7] = ("/recursosMarioBros/BooIzquierdaEscapando.gif");
		imagenes[8] = ("/recursosMarioBros/BooDerechaEscapando.gif");
	
		return imagenes;
	}

	@Override
	public String[] getSkinsInky() {
		String[] imagenes = new String[9];
		
		imagenes[0] = ("/recursosMarioBros/BowserArriba.gif");
		imagenes[1] = ("/recursosMarioBros/BowserAbajo.gif");
		imagenes[2] = ("/recursosMarioBros/BowserIzquierda.gif");
		imagenes[3] = ("/recursosMarioBros/BowserDerecha.gif"); 
		imagenes[4] = ("/recursosMarioBros/muerto.gif"); 
		imagenes[5] = ("/recursosMarioBros/BowserArribaEscapando.gif");
		imagenes[6] = ("/recursosMarioBros/BowserAbajoEscapando.gif");
		imagenes[7] = ("/recursosMarioBros/BowserIzquierdaEscapando.gif");
		imagenes[8] = ("/recursosMarioBros/BowserDerechaEscapando.gif");

		return imagenes;
	}

	@Override
	public String[] getSkinsClyde() {
		String[] imagenes = new String[9];
		
		imagenes[0] = ("/recursosMarioBros/KoopaTroopaArriba.gif");
		imagenes[1] = ("/recursosMarioBros/KoopaTroopaAbajo.gif");
		imagenes[2] = ("/recursosMarioBros/KoopaTroopaIzquierda.gif");
		imagenes[3] = ("/recursosMarioBros/KoopaTroopaDerecha.gif"); 
		imagenes[4] = ("/recursosMarioBros/muerto.gif"); 
		imagenes[5] = ("/recursosMarioBros/KoopaTroopaArribaEscapando.gif");
		imagenes[6] = ("/recursosMarioBros/KoopaTroopaAbajoEscapando.gif");
		imagenes[7] = ("/recursosMarioBros/KoopaTroopaIzquierdaEscapando.gif");
		imagenes[8] = ("/recursosMarioBros/KoopaTroopaDerechaEscapando.gif");
	
		return imagenes;
	}

	@Override
	public String[] getFruta() {
		String[] imagenes = new String[3];

		imagenes[0] = ("/recursosMarioBros/Flor.png");
		imagenes[1] = ("/recursosMarioBros/FlorNivel2.png");
		imagenes[2] = ("/recursosMarioBros/FlorNivel3.png");
		return imagenes;
	}

	@Override
	public String[] getPocionVelocidad() {
		String[] imagenes = new String[1];

		imagenes[0] = ("/recursosMarioBros/HongoVerde.png");

		return imagenes;
	}

	@Override
	public String[] getPocionBomba() {
		String[] imagenes = new String[2];
		
		imagenes[0] = ("/recursosMarioBros/bomba.png");
		imagenes[1] = ("/recursosMarioBros/bomba.gif");
		
		
		return imagenes;
	}

	@Override
	public String[] getPowerPellet() {
		String[] imagenes = new String[1];

		imagenes[0] = ("/recursosMarioBros/Estrella.png");

		return imagenes;
	}

	@Override
	public String[] getPacDot() {
		String[] imagenes = new String[1];

		imagenes[0] = ("/recursosMarioBros/Moneda.png");

		return imagenes;
	}

	@Override
	public String getMusica() {
		return new String("/recursosAudio/musicaMarioBros.wav");
	}

	@Override
	public String getSonidoGameOver() {
		return new String("/recursosAudio/gameOverMarioBros.wav");
	}

	@Override
	public String getParedNivel1() {
		return new String("/recursosMarioBros/paredLvl1Mario.png");
	}

	@Override
	public String getParedNivel2() {
		return new String("/recursosMarioBros/paredLvl2Mario.png");
	}

	@Override
	public String getParedNivel3() {
		return new String("/recursosMarioBros/paredLvl3Mario.png");
	}

	@Override
	public String getPuerta() {
		return new String("/recursosMarioBros/puertaMario.png");
	}

	@Override
	public String getImagenVidas() {
		return new String("/recursosMarioBros/Mario.png");
	}

	@Override
	public String getSonidoWin() {
		return new String("/recursosAudio/winMarioBros.wav");
	}

}
