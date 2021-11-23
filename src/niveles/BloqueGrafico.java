package niveles;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;

import dominios.DominioJuego;

public class BloqueGrafico extends JLabel{
	
	// Atributos de clase
	private static final long serialVersionUID = 1L;
	
	// Atributos de instancia
	protected final ImageIcon bloquePasillo = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/bloqueNegro.png")));
	/**
	 * Crea un BloqueGrafico por defecto
	 */
	public BloqueGrafico() {
		this.setBounds (0,0,25,25);
		ImageIcon bloquePasilloEscalado = new ImageIcon(bloquePasillo.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		this.setIcon(bloquePasilloEscalado);
	}
	
	/**
	 * Otorga imagen grafica al bloque grafico, dependiendo del nivel y dominio actual.
	 * @param nivelActual el nivel actual del juego.
	 * @param dominio el dominio seleccionado para el juego.
	 */
	public void setPared (int nivelActual, DominioJuego dominio) {
		ImageIcon pared = null;
		ImageIcon paredEscalada = null;
		
		if (nivelActual == 1) {
			pared = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(dominio.getParedNivel1())));
		} else if (nivelActual == 2) {
			pared = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(dominio.getParedNivel2())));
		} else if (nivelActual == 3) {
			pared = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(dominio.getParedNivel3())));
		}
		
		paredEscalada = new ImageIcon(pared.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)); 
		
		this.setIcon(paredEscalada);
	}
	
	/**
	 * Otorga al bloque grafico la imagen de una puerta, la cual depende del dominio actual.
	 * @param dominio el dominio seleccionado para el juego.
	 */
	public void setPuerta(DominioJuego dominio) {
		ImageIcon puerta = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(dominio.getPuerta())));
		ImageIcon puertaEscalada = new ImageIcon(puerta.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)); 
		
		this.setIcon(puertaEscalada);
	}
	
}