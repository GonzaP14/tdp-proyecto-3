package niveles;

import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entidadesLogicas.Grilla;

public class Laberinto extends JPanel{
	
	// Atributos de clase
	private static final long serialVersionUID = 1L;
	
	// Atributos de instancia
    protected final List<JLabel> misLabels = new LinkedList<JLabel>();
    protected Grilla miGrillaLogica;
    
    /**
     * Crea un nuevo laberinto por defecto, para un mapa logico determinado.
     * @param miGrillaLogica el mapa logico asociado.
     */
    public Laberinto(Grilla miGrillaLogica) {
    	this.miGrillaLogica = miGrillaLogica;
    	
        setBounds(0, 0, 700, 775);
        setLayout(new GridLayout(Grilla.Filas, Grilla.Columnas, 0, 0));
        
		
        for (int i = 0; i < Grilla.Filas; i++) {
        	for (int j = 0; j < Grilla.Columnas; j ++) {
        	
        		JLabel auxiliar = miGrillaLogica.getBloque(i, j).getRepresentacionGrafica();    		
        		misLabels.add(auxiliar);
        		this.add(auxiliar);
        	}
        }
    }
}
