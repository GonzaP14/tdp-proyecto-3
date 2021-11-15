package entidadesLogicas;

public class DominioJuego {
	
	public static final int dominioMarioBros = 0;
	public static final int dominioMemoji = 1;
	private int dominio;

	public DominioJuego() {
		dominio = 99;
	}
	
	public int getDominioJuego() {
		return dominio;
	}

	public void setDominioJuego(int dominioJuego) {
		this.dominio = dominioJuego;
	}
	
}
