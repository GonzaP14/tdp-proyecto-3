package visitadores;

import personajes.Principal;
import elementos.Fruta;
import elementos.PacDot;
import elementos.PocionBomba;
import elementos.PocionVelocidad;
import elementos.PowerPellet;
import entidadesLogicas.Bloque;
import personajes.Enemigo;

public interface Visitor {
	
	public boolean visit (Bloque b);
	
	public boolean visit (Principal p);
	
	public boolean visit (Enemigo e); 

	public boolean visit (PacDot p);
	
	public boolean visit (PocionBomba p);
	
	public boolean visit (PocionVelocidad p);
	
	public boolean visit (Fruta f);
	
	public boolean visit (PowerPellet p);
	
}
