package productos;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import elementos.Elemento;
import entidadesGraficas.EnemigoGrafico;
import entidadesGraficas.PrincipalGrafico;
import entidadesLogicas.Grilla;
import personajes.*;
import elementos.*;

public class MarioBros extends FabricaEntidades {

	public MarioBros() {
		
	}
	
	@Override
	public Principal getPrincipal() {
		ImageIcon[] imagenes = new ImageIcon[4];
		imagenes[0] = new ImageIcon(this.getClass().getResource("/recursosImagenes/MarioArriba.gif"));
		imagenes[1] = new ImageIcon(this.getClass().getResource("/recursosImagenes/MarioAbajo.gif"));
		imagenes[2] = new ImageIcon(this.getClass().getResource("/recursosImagenes/MarioIzquierda.gif"));
		imagenes[3] = new ImageIcon(this.getClass().getResource("/recursosImagenes/MarioDerecha.gif")); 
		imagenes[4] = new ImageIcon(this.getClass().getResource("/recursosImagenes/MarioMuerto.gif")); 
		
		PrincipalGrafico entidadGrafica = new PrincipalGrafico(imagenes, Grilla.spawnPrincipal.getMiPosicion());
		return Principal.getPrincipal(entidadGrafica);
	}
	
	@Override
	public Enemigo getBlinky() {
		ImageIcon[] imagenes = new ImageIcon[4];
		imagenes[0] = new ImageIcon(this.getClass().getResource("/recursosImagenes/Goompa.gif"));
		imagenes[1] = new ImageIcon(this.getClass().getResource("/recursosImagenes/Goompa.gif"));
		imagenes[2] = new ImageIcon(this.getClass().getResource("/recursosImagenes/Goompa.gif"));
		imagenes[3] = new ImageIcon(this.getClass().getResource("/recursosImagenes/Goompa.gif")); 
		imagenes[4] = new ImageIcon(this.getClass().getResource("/recursosImagenes/Goompa.gif")); 
		imagenes[5] = new ImageIcon(this.getClass().getResource("/recursosImagenes/GoompaEscapando.gif")); 
		
		EnemigoGrafico entidadGrafica = new EnemigoGrafico(imagenes, Grilla.spawnBlinky.getMiPosicion());
		return new Blinky(entidadGrafica);
	}
	
	@Override
	public Enemigo getPinky() {
		ImageIcon[] imagenes = new ImageIcon[4];
		imagenes[0] = new ImageIcon(this.getClass().getResource("/recursosImagenes/BooArriba.gif"));
		imagenes[1] = new ImageIcon(this.getClass().getResource("/recursosImagenes/BooAbajo.gif"));
		imagenes[2] = new ImageIcon(this.getClass().getResource("/recursosImagenes/BooDerecha.gif"));
		imagenes[3] = new ImageIcon(this.getClass().getResource("/recursosImagenes/BooIzquierda.gif")); 
		imagenes[4] = new ImageIcon(this.getClass().getResource("/recursosImagenes/BooMuerto.gif")); 
		imagenes[5] = new ImageIcon(this.getClass().getResource("/recursosImagenes/BooEscapando.gif")); 
		
		EnemigoGrafico entidadGrafica = new EnemigoGrafico(imagenes, Grilla.spawnPinky.getMiPosicion());
		return new Pinky(entidadGrafica);
	}	

	@Override
	public Enemigo getInky() {
		ImageIcon[] imagenes = new ImageIcon[4];
		imagenes[0] = new ImageIcon(this.getClass().getResource("/recursosImagenes/BowserArriba.gif"));
		imagenes[1] = new ImageIcon(this.getClass().getResource("/recursosImagenes/BowserAbajo.gif"));
		imagenes[2] = new ImageIcon(this.getClass().getResource("/recursosImagenes/BowserDerecha.gif"));
		imagenes[3] = new ImageIcon(this.getClass().getResource("/recursosImagenes/BowserIzquierda.gif")); 
		imagenes[4] = new ImageIcon(this.getClass().getResource("/recursosImagenes/BowserMuerto.gif")); 
		imagenes[5] = new ImageIcon(this.getClass().getResource("/recursosImagenes/BowserEscapando.gif")); 
		
		EnemigoGrafico entidadGrafica = new EnemigoGrafico(imagenes, Grilla.spawnInky.getMiPosicion());
		return new Inky(entidadGrafica);
	}

	@Override
	public Enemigo getClyde() {
		ImageIcon[] imagenes = new ImageIcon[4];
		imagenes[0] = new ImageIcon(this.getClass().getResource("/recursosImagenes/KoopaTroopaArriba.gif"));
		imagenes[1] = new ImageIcon(this.getClass().getResource("/recursosImagenes/KoopaTroopaAbajo.gif"));
		imagenes[2] = new ImageIcon(this.getClass().getResource("/recursosImagenes/KoopaTroopaDerecha.gif"));
		imagenes[3] = new ImageIcon(this.getClass().getResource("/recursosImagenes/KoopaTroopaIzquierda.gif")); 
		imagenes[4] = new ImageIcon(this.getClass().getResource("/recursosImagenes/KoopaTroopaMuerto.gif")); 
		imagenes[5] = new ImageIcon(this.getClass().getResource("/recursosImagenes/KoopaTroopaEscapando.gif")); 
		
		EnemigoGrafico entidadGrafica = new EnemigoGrafico(imagenes, Grilla.spawnClyde.getMiPosicion());
		return new Clyde(entidadGrafica);
	}

	@Override
	public Elemento getFruta() {
		return new Fruta();
	}

	@Override
	public Elemento getPocion() {
		return new Pocion();
	}

	@Override
	public Elemento getPowerPellet() {
		return new PowerPellet();
	}

	@Override
	public Elemento getPacDot() {
		return new PacDot();
	}

}
