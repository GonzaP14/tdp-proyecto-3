package entidadesGraficas;

import java.util.ArrayList;

import javax.swing.*;
import entidadesLogicas.Entidad;

public class BloqueGrafico extends JPanel{
	
	private EntidadGrafica miEntidadGrafica;
	private JLabel fondoBloque;
	
	public BloqueGrafico(boolean puedeVisitarse , ArrayList<Entidad> listaEntidades) {
		if(puedeVisitarse) {
			fondoBloque = bloqueNegro;
		}
		else {
			fondoBloque = pared;
		}
		actualizar(listaEntidades);	
	}
	
	public BloqueGrafico(boolean puedeVisitarse ) {
		if(puedeVisitarse) {
			fondoBloque = bloqueNegro;
		}
		else {
			fondoBloque = pared;
		}
		miEntidadGrafica = null;
	}
	
	public void actualizar(ArrayList<Entidad> listaEntidades ) {
		for(Entidad entidad : listaEntidades ) {
			if(entidad.getMiRepresentacion().getMiPrioridad() > miEntidadGrafica.getMiPrioridad() ) {
				//Ver si deberiamos usar clone aca
				miEntidadGrafica = entidad.getMiRepresentacion();
			}
		}
	}
}
