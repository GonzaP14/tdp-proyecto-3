package entidadesGraficas;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import entidadesLogicas.Grilla;

public class Laberinto extends JPanel{
		
	private static final long serialVersionUID = 1L;
	
    //atributos de instancia
    protected final List<JLabel> misLabels = new LinkedList<JLabel>();
    
    protected Grilla miGrillaLogica;
    
    public Laberinto(Grilla miGrillaLogica) {
    	this.miGrillaLogica = miGrillaLogica;
    	
    	setBackground(Color.BLACK);
        setBounds(100, 100, 1280, 720);
        setLayout(new GridLayout(Grilla.Filas, Grilla.Columnas, 0, 0));
        
		
        for (int i = 0; i < Grilla.Filas; i++) {
        	for (int j = 0; j < Grilla.Columnas; j ++) {
        	
        		JLabel auxiliar = miGrillaLogica.getBloque(i, j).getMiRepresentacion();
        		
        		misLabels.add(auxiliar);
        		this.add(auxiliar);
        	}
        }
    }
    public void ConstructorNivel(int i) {
    	if(i==1) {
    		
    		miGrillaLogica.getBloque(0,0).getMiRepresentacion().setBloquePared();  	
    		
    		for(int columnas=1;columnas<13;columnas++) {
    			miGrillaLogica.getBloque(0,columnas).getMiRepresentacion().setBloquePared();
    		}
    		
    		miGrillaLogica.getBloque(0,13).getMiRepresentacion().setBloquePared(); 
    		miGrillaLogica.getBloque(0,14).getMiRepresentacion().setBloquePared();  	
    		
    		for(int columnas=15;columnas<27;columnas++) {
    			miGrillaLogica.getBloque(0,columnas).getMiRepresentacion().setBloquePared();
    		}
    		miGrillaLogica.getBloque(0,27).getMiRepresentacion().setBloquePared();  	
    		
    		miGrillaLogica.getBloque(1,0).getMiRepresentacion().setBloquePared();  	
    		miGrillaLogica.getBloque(1,13).getMiRepresentacion().setBloquePared();  	
    		miGrillaLogica.getBloque(1,14).getMiRepresentacion().setBloquePared();  	
    		miGrillaLogica.getBloque(1,27).getMiRepresentacion().setBloquePared();  	
    		
    		miGrillaLogica.getBloque(2,0).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(2,2).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(2,3).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(2,4).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(2,5).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(2,7).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(2,8).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(2,9).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(2,10).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(2,11).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(2,13).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(2,14).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(2,16).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(2,17).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(2,18).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(2,19).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(2,20).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(2,22).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(2,23).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(2,24).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(2,25).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(2,27).getMiRepresentacion().setBloquePared(); 
    		
    		miGrillaLogica.getBloque(3,0).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(3,2).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(3,5).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(3,7).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(3,11).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(3,16).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(3,20).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(3,22).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(3,25).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(3,27).getMiRepresentacion().setBloquePared();  
    		
    		miGrillaLogica.getBloque(4,0).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(4,2).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(4,3).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(4,4).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(4,5).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(4,7).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(4,8).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(4,9).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(4,10).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(4,11).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(4,13).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(4,14).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(4,16).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(4,17).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(4,18).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(4,19).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(4,20).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(4,22).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(4,23).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(4,24).getMiRepresentacion().setBloquePared();  
    		miGrillaLogica.getBloque(4,25).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(4,27).getMiRepresentacion().setBloquePared(); 
    		
    		miGrillaLogica.getBloque(5,0).getMiRepresentacion().setBloquePared(); 
    		miGrillaLogica.getBloque(5,27).getMiRepresentacion().setBloquePared();   	
  	
    		miGrillaLogica.getBloque(6,0).getMiRepresentacion().setBloquePared(); 
    		miGrillaLogica.getBloque(6,2).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(6,3).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(6,4).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(6,5).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(6,7).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(6,8).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(6,10).getMiRepresentacion().setBloquePared();
    		for(int columnas=11;columnas<17;columnas++) {
    			miGrillaLogica.getBloque(6,columnas).getMiRepresentacion().setBloquePared();
    		}
    		miGrillaLogica.getBloque(6,17).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(6,19).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(6,20).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(6,22).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(6,23).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(6,24).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(6,25).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(6,27).getMiRepresentacion().setBloquePared(); 
    	
    		miGrillaLogica.getBloque(7,0).getMiRepresentacion().setBloquePared(); 
    		miGrillaLogica.getBloque(7,2).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(7,3).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(7,4).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(7,5).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(7,7).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(7,8).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(7,10).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(7,11).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(7,12).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(7,13).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(7,14).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(7,15).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(7,16).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(7,17).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(7,19).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(7,20).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(7,22).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(7,23).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(7,24).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(7,25).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(7,27).getMiRepresentacion().setBloquePared(); 
    		
    		miGrillaLogica.getBloque(8,0).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(8,7).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(8,8).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(8,13).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(8,14).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(8,19).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(8,20).getMiRepresentacion().setBloquePared();  		
    		miGrillaLogica.getBloque(8,27).getMiRepresentacion().setBloquePared();
    		
    		miGrillaLogica.getBloque(9,0).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(9,1).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(9,2).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(9,3).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(9,4).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(9,5).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(9,7).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(9,8).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(9,9).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(9,10).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(9,11).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(9,13).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(9,14).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(9,16).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(9,17).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(9,18).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(9,19).getMiRepresentacion().setBloquePared();
    		
    		miGrillaLogica.getBloque(9,27).getMiRepresentacion().setBloquePared();
    		
    	}
    }
}
