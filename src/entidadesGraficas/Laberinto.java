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
    public JLabel getBloqueGrafico(int f,int c) {
    	 return misLabels.get(c * 10 + f);
    }
    
    public void ConstructorNivel(int i) {
    	/*if(i==1) {
    		
    		getBloqueGrafico(0,0).setBloqueEsquinaArribaIzquierda();  	
    		
    		for(int columnas=1;columnas<12;columnas++) {
    			getBloqueGrafico(0,columnas).setBloqueParedHorizontal();
    		}
    		
    		getBloqueGrafico(0,13).setBloqueEsquinaArribaDerecha(); 
    		getBloqueGrafico(0,14).setBloqueEsquinaArribaIzquierda();  	
    		
    		for(int columnas=15;columnas<26;columnas++) {
    			getBloqueGrafico(0,columnas).setBloqueParedHorizontal();
    		}
    		getBloqueGrafico(0,27).setBloqueEsquinaArribaDerecha();  	
    		
    		getBloqueGrafico(1,0).setBloqueParedVertical();  	
    		getBloqueGrafico(1,13).setBloqueParedVertical();  	
    		getBloqueGrafico(1,14).setBloqueParedVertical();  	
    		getBloqueGrafico(1,27).setBloqueParedVertical();  	
    		
    		getBloqueGrafico(2,0).setBloqueParedVertical();  
    		getBloqueGrafico(2,2).setBloqueEsquinaArribaIzquierda();  
    		getBloqueGrafico(2,3).setBloqueParedHorizontal();  
    		getBloqueGrafico(2,4).setBloqueParedHorizontal();  
    		getBloqueGrafico(2,5).setBloqueEsquinaArribaDerecha();
    		getBloqueGrafico(2,7).setBloqueEsquinaArribaIzquierda();
    		getBloqueGrafico(2,8).setBloqueParedHorizontal();  
    		getBloqueGrafico(2,9).setBloqueParedHorizontal();  
    		getBloqueGrafico(2,10).setBloqueParedHorizontal();  
    		getBloqueGrafico(2,11).setBloqueEsquinaArribaDerecha();  
    		getBloqueGrafico(2,13).setBloqueParedVertical();
    		getBloqueGrafico(2,14).setBloqueParedVertical();
    		getBloqueGrafico(2,16).setBloqueEsquinaArribaIzquierda();
    		getBloqueGrafico(2,17).setBloqueParedHorizontal();  
    		getBloqueGrafico(2,18).setBloqueParedHorizontal();  
    		getBloqueGrafico(2,19).setBloqueParedHorizontal();  
    		getBloqueGrafico(2,20).setBloqueEsquinaArribaDerecha();
    		getBloqueGrafico(2,22).setBloqueEsquinaArribaIzquierda();  
    		getBloqueGrafico(2,23).setBloqueParedHorizontal();  
    		getBloqueGrafico(2,24).setBloqueParedHorizontal();  
    		getBloqueGrafico(2,25).setBloqueEsquinaArribaDerecha();
    		getBloqueGrafico(2,27).setBloqueParedVertical(); 
    		
    		getBloqueGrafico(3,0).setBloqueParedVertical();  
    		getBloqueGrafico(3,2).setBloqueParedVertical();
    		getBloqueGrafico(3,5).setBloqueParedVertical();  
    		getBloqueGrafico(3,7).setBloqueParedVertical();  
    		getBloqueGrafico(3,11).setBloqueParedVertical();  
    		getBloqueGrafico(3,16).setBloqueParedVertical();  
    		getBloqueGrafico(3,20).setBloqueParedVertical();  
    		getBloqueGrafico(3,22).setBloqueParedVertical();  
    		getBloqueGrafico(3,25).setBloqueParedVertical();  
    		getBloqueGrafico(3,27).setBloqueParedVertical();  
    		
    		getBloqueGrafico(4,0).setBloqueParedVertical();  
    		getBloqueGrafico(4,2).setBloqueEsquinaAbajoIzquierda();  
    		getBloqueGrafico(4,3).setBloqueParedHorizontal();  
    		getBloqueGrafico(4,4).setBloqueParedHorizontal();  
    		getBloqueGrafico(4,5).setBloqueEsquinaAbajoDerecha();
    		getBloqueGrafico(4,7).setBloqueEsquinaAbajoIzquierda();
    		getBloqueGrafico(4,8).setBloqueParedHorizontal();  
    		getBloqueGrafico(4,9).setBloqueParedHorizontal();  
    		getBloqueGrafico(4,10).setBloqueParedHorizontal();  
    		getBloqueGrafico(4,11).setBloqueEsquinaAbajoDerecha();  
    		getBloqueGrafico(4,13).setBloqueEsquinaAbajoIzquierda();
    		getBloqueGrafico(4,14).setBloqueEsquinaAbajoDerecha();
    		getBloqueGrafico(4,16).setBloqueEsquinaAbajoIzquierda();
    		getBloqueGrafico(4,17).setBloqueParedHorizontal();  
    		getBloqueGrafico(4,18).setBloqueParedHorizontal();  
    		getBloqueGrafico(4,19).setBloqueParedHorizontal();  
    		getBloqueGrafico(4,20).setBloqueEsquinaAbajoDerecha();
    		getBloqueGrafico(4,22).setBloqueEsquinaAbajoIzquierda();  
    		getBloqueGrafico(4,23).setBloqueParedHorizontal();  
    		getBloqueGrafico(4,24).setBloqueParedHorizontal();  
    		getBloqueGrafico(4,25).setBloqueEsquinaAbajoDerecha();
    		getBloqueGrafico(4,27).setBloqueParedVertical(); 
    		
    		getBloqueGrafico(5,0).setBloqueParedVertical(); 
    		getBloqueGrafico(5,27).setBloqueParedVertical();   	
  	
    		getBloqueGrafico(6,0).setBloqueParedVertical(); 
    		getBloqueGrafico(6,2).setBloqueEsquinaArribaIzquierda();
    		getBloqueGrafico(6,3).setBloqueParedHorizontal();
    		getBloqueGrafico(6,4).setBloqueParedHorizontal();
    		getBloqueGrafico(6,5).setBloqueEsquinaArribaDerecha();
    		getBloqueGrafico(6,7).setBloqueEsquinaArribaIzquierda();
    		getBloqueGrafico(6,8).setBloqueEsquinaArribaDerecha();
    		getBloqueGrafico(6,10).setBloqueEsquinaArribaIzquierda();
    		for(int columnas=11;columnas<16;columnas++) {
    			getBloqueGrafico(6,columnas).setBloqueParedHorizontal();
    		}
    		getBloqueGrafico(6,17).setBloqueEsquinaArribaDerecha();
    		getBloqueGrafico(6,19).setBloqueEsquinaArribaIzquierda();
    		getBloqueGrafico(6,20).setBloqueEsquinaArribaDerecha();
    		getBloqueGrafico(6,22).setBloqueEsquinaArribaIzquierda();
    		getBloqueGrafico(6,23).setBloqueParedHorizontal();
    		getBloqueGrafico(6,24).setBloqueParedHorizontal();
    		getBloqueGrafico(6,25).setBloqueEsquinaArribaDerecha();
    		getBloqueGrafico(6,27).setBloqueParedVertical(); 
    	
    		getBloqueGrafico(7,0).setBloqueParedVertical(); 
    		getBloqueGrafico(7,2).setBloqueEsquinaAbajoIzquierda();
    		getBloqueGrafico(7,3).setBloqueParedHorizontal();
    		getBloqueGrafico(7,4).setBloqueParedHorizontal();
    		getBloqueGrafico(7,5).setBloqueEsquinaAbajoDerecha();
    		getBloqueGrafico(7,7).setBloqueParedVertical();
    		getBloqueGrafico(7,8).setBloqueParedVertical();
    		getBloqueGrafico(7,10).setBloqueEsquinaAbajoIzquierda();
    		getBloqueGrafico(7,11).setBloqueParedHorizontal();
    		getBloqueGrafico(7,12).setBloqueParedHorizontal();
    		getBloqueGrafico(7,13).setBloqueEsquinaArribaDerecha();
    		getBloqueGrafico(7,14).setBloqueEsquinaArribaIzquierda();
    		getBloqueGrafico(7,15).setBloqueParedHorizontal();
    		getBloqueGrafico(7,16).setBloqueParedHorizontal();
    		getBloqueGrafico(7,17).setBloqueEsquinaAbajoDerecha();
    		getBloqueGrafico(7,19).setBloqueParedVertical();
    		getBloqueGrafico(7,20).setBloqueParedVertical();
    		getBloqueGrafico(7,22).setBloqueEsquinaAbajoIzquierda();
    		getBloqueGrafico(7,23).setBloqueParedHorizontal();
    		getBloqueGrafico(7,24).setBloqueParedHorizontal();
    		getBloqueGrafico(7,25).setBloqueEsquinaAbajoDerecha();
    		getBloqueGrafico(7,27).setBloqueParedVertical(); 
    		
    		getBloqueGrafico(8,0).setBloqueParedVertical();
    		getBloqueGrafico(8,7).setBloqueParedVertical();
    		getBloqueGrafico(8,8).setBloqueParedVertical();
    		getBloqueGrafico(8,13).setBloqueParedVertical();
    		getBloqueGrafico(8,14).setBloqueParedVertical();
    		getBloqueGrafico(8,19).setBloqueParedVertical();
    		getBloqueGrafico(8,20).setBloqueParedVertical();  		
    		getBloqueGrafico(8,27).setBloqueParedVertical();
    		
    		getBloqueGrafico(9,0).setBloqueEsquinaAbajoIzquierda();
    		getBloqueGrafico(9,1).setBloqueParedHorizontal();
    		getBloqueGrafico(9,2).setBloqueParedHorizontal();
    		getBloqueGrafico(9,3).setBloqueParedHorizontal();
    		getBloqueGrafico(9,4).setBloqueParedHorizontal();
    		getBloqueGrafico(9,5).setBloqueEsquinaArribaDerecha();
    		getBloqueGrafico(9,7).setBloqueParedVertical();
    		getBloqueGrafico(9,8).setBloqueEsquinaAbajoIzquierda();
    		getBloqueGrafico(9,9).setBloqueParedHorizontal();
    		getBloqueGrafico(9,10).setBloqueParedHorizontal();
    		getBloqueGrafico(9,11).setBloqueEsquinaArribaDerecha();
    		getBloqueGrafico(9,13).setBloqueParedVertical();
    		getBloqueGrafico(9,14).setBloqueParedVertical();
    		getBloqueGrafico(9,16).setBloqueEsquinaArribaIzquierda();
    		getBloqueGrafico(9,17).setBloqueParedHorizontal();
    		getBloqueGrafico(9,18).setBloqueParedHorizontal();
    		getBloqueGrafico(9,19).setBloqueEsquinaAbajoDerecha();
    		
    		getBloqueGrafico(9,27).setBloqueEsquinaAbajoDerecha();
    		
    	}*/
    }
}
