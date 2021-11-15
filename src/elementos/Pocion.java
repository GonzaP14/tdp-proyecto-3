package elementos;

public abstract class Pocion extends Elemento {
	protected int velocidadOtorgada;
	@Override
	protected void iniciarTimer(HiloElemento timer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public abstract void afectar();
		
}
