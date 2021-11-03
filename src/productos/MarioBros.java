package productos;

import javax.swing.ImageIcon;
import entidadesGraficas.ElementoGrafico;
import entidadesGraficas.EnemigoGrafico;
import entidadesGraficas.PrincipalGrafico;
import entidadesLogicas.Juego;
import personajes.*;
import elementos.*;

public class MarioBros extends FabricaEntidades {
	private Juego miJuego;
	public MarioBros(Juego miJuego) {
		this.miJuego = miJuego;
	}
	
	@Override
	public Principal getPrincipal() {
		String[] imagenes = new String[5];
		imagenes[0] = "/recursosMarioBros/MarioArriba.gif";
		imagenes[1] = "/recursosMarioBros/MarioAbajo.gif";
		imagenes[2] = "/recursosMarioBros/MarioDerecha.gif";
		imagenes[3] = "/recursosMarioBros/MarioIzquierda.gif";
		imagenes[4] = "/recursosMarioBros/MarioMuerto.gif";
		
		return Principal.getPrincipal(miJuego, imagenes);
	}
	
	@Override
	public Enemigo getBlinky() {
		String[] imagenes = new String[6];
		
		imagenes[0] = ("/recursosMarioBros/GoompaArriba.gif");
		imagenes[1] = ("/recursosMarioBros/GoompaAbajo.gif");
		imagenes[2] = ("/recursosMarioBros/GoompaDerecha.gif");
		imagenes[3] = ("/recursosMarioBros/GoompaIzquierda.gif");
		imagenes[4] = ("/recursosMarioBros/GoompaMuerto.gif");
		imagenes[5] = ("/recursosMarioBros/GoompaEscapando.gif");

		return new Blinky(miJuego, imagenes);
	}
	
	@Override
	public Enemigo getPinky() {
		ImageIcon[] imagenes = new ImageIcon[6];
		imagenes[0] = new ImageIcon(this.getClass().getResource("/recursosMarioBros/BooArriba.gif"));
		imagenes[1] = new ImageIcon(this.getClass().getResource("/recursosMarioBros/BooAbajo.gif"));
		imagenes[2] = new ImageIcon(this.getClass().getResource("/recursosMarioBros/BooDerecha.gif"));
		imagenes[3] = new ImageIcon(this.getClass().getResource("/recursosMarioBros/BooIzquierda.gif")); 
		imagenes[4] = new ImageIcon(this.getClass().getResource("/recursosMarioBros/BooMuerto.gif")); 
		imagenes[5] = new ImageIcon(this.getClass().getResource("/recursosMarioBros/BooEscapando.gif")); 
		
		EnemigoGrafico miRepresentacionGrafica = new EnemigoGrafico(imagenes);
		
		return new Pinky(miRepresentacionGrafica);
	}	

	@Override
	public Enemigo getInky() {
		ImageIcon[] imagenes = new ImageIcon[6];
		imagenes[0] = new ImageIcon(this.getClass().getResource("/recursosMarioBros/BowserArriba.gif"));
		imagenes[1] = new ImageIcon(this.getClass().getResource("/recursosMarioBros/BowserAbajo.gif"));
		imagenes[2] = new ImageIcon(this.getClass().getResource("/recursosMarioBros/BowserDerecha.gif"));
		imagenes[3] = new ImageIcon(this.getClass().getResource("/recursosMarioBros/BowserIzquierda.gif")); 
		imagenes[4] = new ImageIcon(this.getClass().getResource("/recursosMarioBros/BowserMuerto.gif")); 
		imagenes[5] = new ImageIcon(this.getClass().getResource("/recursosMarioBros/BowserEscapando.gif")); 
		
		EnemigoGrafico miRepresentacionGrafica = new EnemigoGrafico(imagenes);
		
		return new Inky(miRepresentacionGrafica);
	}

	@Override
	public Enemigo getClyde() {
		ImageIcon[] imagenes = new ImageIcon[6];
		imagenes[0] = new ImageIcon(this.getClass().getResource("/recursosMarioBros/KoopaTroopaArriba.gif"));
		imagenes[1] = new ImageIcon(this.getClass().getResource("/recursosMarioBros/KoopaTroopaAbajo.gif"));
		imagenes[2] = new ImageIcon(this.getClass().getResource("/recursosMarioBros/KoopaTroopaDerecha.gif"));
		imagenes[3] = new ImageIcon(this.getClass().getResource("/recursosMarioBros/KoopaTroopaIzquierda.gif")); 
		imagenes[4] = new ImageIcon(this.getClass().getResource("/recursosMarioBros/KoopaTroopaMuerto.gif")); 
		imagenes[5] = new ImageIcon(this.getClass().getResource("/recursosMarioBros/KoopaTroopaEscapando.gif")); 
		
		EnemigoGrafico miRepresentacionGrafica = new EnemigoGrafico(imagenes);
		return new Clyde(miRepresentacionGrafica);
	}

	@Override
	public Elemento getFruta() {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/recursosMarioBros/Flor.png"));
		ElementoGrafico miRepresentacionGrafica = new ElementoGrafico(imagen);
		
		return new Fruta(miRepresentacionGrafica);
	}
	
	public Pocion getPocionVelocidad() {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/recursosMarioBros/HongoVerde.png"));
		ElementoGrafico miRepresentacionGrafica = new ElementoGrafico(imagen);
		
		return new PocionVelocidad(miRepresentacionGrafica);
	}
	
	@Override
	public Pocion getPocionCongelacion() {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/recursosMarioBros/HongoRojo.png"));
		ElementoGrafico miRepresentacionGrafica = new ElementoGrafico(imagen);
		
		return new PocionCongelacion(miRepresentacionGrafica);
	}

	@Override
	public Elemento getPowerPellet() {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/recursosMarioBros/Estrella.png"));
		ElementoGrafico miRepresentacionGrafica = new ElementoGrafico(imagen);
		
		return new PowerPellet(miRepresentacionGrafica);
	}

	@Override
	public Elemento getPacDot() {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/recursosMarioBros/Moneda.png"));
		ElementoGrafico miRepresentacionGrafica = new ElementoGrafico(imagen);
		
		return new PacDot(miRepresentacionGrafica);
	}

}
