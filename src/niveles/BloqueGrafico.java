package niveles;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;

import dominios.DominioJuego;

public class BloqueGrafico extends JLabel{
	
	private static final long serialVersionUID = 1L;
	
	protected final ImageIcon bloquePasillo = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/bloqueNegro.png")));
	
	public BloqueGrafico() {
		this.setBounds (0,0,25,25);
		ImageIcon bloquePasilloEscalado = new ImageIcon(bloquePasillo.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		this.setIcon(bloquePasilloEscalado);
	}
	
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
	
	public void setPuerta(DominioJuego dominio) {
		ImageIcon puerta = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(dominio.getPuerta())));
		ImageIcon puertaEscalada = new ImageIcon(puerta.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)); 
		
		this.setIcon(puertaEscalada);
	}
	
}