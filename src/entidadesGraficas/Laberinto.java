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
    		 //fila 0		
    		for(int columnas=0;columnas<28;columnas++) {
    			miGrillaLogica.getBloque(0,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		//fila 1
    		miGrillaLogica.getBloque(1,0).getMiRepresentacion().setBloquePared();  	
    		miGrillaLogica.getBloque(1,13).getMiRepresentacion().setBloquePared();  	
    		miGrillaLogica.getBloque(1,14).getMiRepresentacion().setBloquePared();  	
    		miGrillaLogica.getBloque(1,27).getMiRepresentacion().setBloquePared();  	
    		
    		//fila 2
    		miGrillaLogica.getBloque(2,0).getMiRepresentacion().setBloquePared();  
    		for(int columnas=2;columnas<6;columnas++) {
    			miGrillaLogica.getBloque(2,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		for(int columnas=7;columnas<12;columnas++) {
    			miGrillaLogica.getBloque(2,columnas).getMiRepresentacion().setBloquePared();
    		}	 
    		miGrillaLogica.getBloque(2,13).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(2,14).getMiRepresentacion().setBloquePared();
    		for(int columnas=16;columnas<21;columnas++) {
    			miGrillaLogica.getBloque(2,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		for(int columnas=22;columnas<26;columnas++) {
    			miGrillaLogica.getBloque(2,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		miGrillaLogica.getBloque(2,27).getMiRepresentacion().setBloquePared(); 
    		
    		//fila 3
    		miGrillaLogica.getBloque(3,0).getMiRepresentacion().setBloquePared();  
    		for(int columnas=2;columnas<6;columnas++) {
    			miGrillaLogica.getBloque(3,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		for(int columnas=7;columnas<12;columnas++) {
    			miGrillaLogica.getBloque(3,columnas).getMiRepresentacion().setBloquePared();
    		}	 
    		miGrillaLogica.getBloque(3,13).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(3,14).getMiRepresentacion().setBloquePared();
    		for(int columnas=16;columnas<21;columnas++) {
    			miGrillaLogica.getBloque(3,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		for(int columnas=22;columnas<26;columnas++) {
    			miGrillaLogica.getBloque(3,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		miGrillaLogica.getBloque(3,27).getMiRepresentacion().setBloquePared(); 
    		
    		//fila4
    		miGrillaLogica.getBloque(4,0).getMiRepresentacion().setBloquePared();  
    		for(int columnas=2;columnas<6;columnas++) {
    			miGrillaLogica.getBloque(4,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		for(int columnas=7;columnas<12;columnas++) {
    			miGrillaLogica.getBloque(4,columnas).getMiRepresentacion().setBloquePared();
    		}	 
    		miGrillaLogica.getBloque(4,13).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(4,14).getMiRepresentacion().setBloquePared();
    		for(int columnas=16;columnas<21;columnas++) {
    			miGrillaLogica.getBloque(4,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		for(int columnas=22;columnas<26;columnas++) {
    			miGrillaLogica.getBloque(4,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		miGrillaLogica.getBloque(4,27).getMiRepresentacion().setBloquePared(); 
    		
    		//fila5
    		miGrillaLogica.getBloque(5,0).getMiRepresentacion().setBloquePared(); 
    		miGrillaLogica.getBloque(5,27).getMiRepresentacion().setBloquePared();   	
    		
    		//fila6
    		miGrillaLogica.getBloque(6,0).getMiRepresentacion().setBloquePared(); 
    		for(int columnas=2;columnas<6;columnas++) {
    			miGrillaLogica.getBloque(6,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		miGrillaLogica.getBloque(6,7).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(6,8).getMiRepresentacion().setBloquePared();
    		
    		for(int columnas=10;columnas<18;columnas++) {
    			miGrillaLogica.getBloque(6,columnas).getMiRepresentacion().setBloquePared();
    		}
    		
    		miGrillaLogica.getBloque(6,19).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(6,20).getMiRepresentacion().setBloquePared();
    		for(int columnas=22;columnas<26;columnas++) {
    			miGrillaLogica.getBloque(6,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		miGrillaLogica.getBloque(6,27).getMiRepresentacion().setBloquePared(); 
    		
    		//fila7
    		miGrillaLogica.getBloque(7,0).getMiRepresentacion().setBloquePared(); 
    		for(int columnas=2;columnas<6;columnas++) {
    			miGrillaLogica.getBloque(7,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		miGrillaLogica.getBloque(7,7).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(7,8).getMiRepresentacion().setBloquePared();
    		
    		for(int columnas=10;columnas<18;columnas++) {
    			miGrillaLogica.getBloque(7,columnas).getMiRepresentacion().setBloquePared();
    		}
    		
    		miGrillaLogica.getBloque(7,19).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(7,20).getMiRepresentacion().setBloquePared();
    		for(int columnas=22;columnas<26;columnas++) {
    			miGrillaLogica.getBloque(7,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		miGrillaLogica.getBloque(7,27).getMiRepresentacion().setBloquePared(); 
    		
    		miGrillaLogica.getBloque(8,0).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(8,7).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(8,8).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(8,13).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(8,14).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(8,19).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(8,20).getMiRepresentacion().setBloquePared();  		
    		miGrillaLogica.getBloque(8,27).getMiRepresentacion().setBloquePared();
    		
    		//fila 9
    		for(int columnas=0;columnas<6;columnas++) {
    			miGrillaLogica.getBloque(9,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		for(int columnas=7;columnas<12;columnas++) {
    			miGrillaLogica.getBloque(9,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		miGrillaLogica.getBloque(9,13).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(9,14).getMiRepresentacion().setBloquePared();
    		for(int columnas=16;columnas<21;columnas++) {
    			miGrillaLogica.getBloque(9,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		for(int columnas=22;columnas<28;columnas++) {
    			miGrillaLogica.getBloque(9,columnas).getMiRepresentacion().setBloquePared();
    		}		
    	
    		
    		//fila 10
    		for(int columnas=0;columnas<6;columnas++) {
    			miGrillaLogica.getBloque(10,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		for(int columnas=7;columnas<12;columnas++) {
    			miGrillaLogica.getBloque(10,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		miGrillaLogica.getBloque(10,13).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(10,14).getMiRepresentacion().setBloquePared();
    		for(int columnas=16;columnas<21;columnas++) {
    			miGrillaLogica.getBloque(10,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		for(int columnas=22;columnas<28;columnas++) {
    			miGrillaLogica.getBloque(10,columnas).getMiRepresentacion().setBloquePared();
    		}		
    		
    		//fila 11
    		for(int columnas=0;columnas<6;columnas++) {
    			miGrillaLogica.getBloque(11,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		miGrillaLogica.getBloque(11,7).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(11,8).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(11,19).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(11,20).getMiRepresentacion().setBloquePared();
    		for(int columnas=22;columnas<28;columnas++) {
    			miGrillaLogica.getBloque(11,columnas).getMiRepresentacion().setBloquePared();
    		}
    		//fila12
    		for(int columnas=0;columnas<6;columnas++) {
    			miGrillaLogica.getBloque(12,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		miGrillaLogica.getBloque(12,7).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(12,8).getMiRepresentacion().setBloquePared();
    		
    		for(int columnas=10;columnas<18;columnas++) {
    			miGrillaLogica.getBloque(12,columnas).getMiRepresentacion().setBloquePared();
    		}
    		miGrillaLogica.getBloque(12,19).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(12,20).getMiRepresentacion().setBloquePared();
    		for(int columnas=22;columnas<28;columnas++) {
    			miGrillaLogica.getBloque(12,columnas).getMiRepresentacion().setBloquePared();
    		}
    		
    		//fila13
    		for(int columnas=0;columnas<6;columnas++) {
    			miGrillaLogica.getBloque(13,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		miGrillaLogica.getBloque(13,7).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(13,8).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(13,10).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(13,17).getMiRepresentacion().setBloquePared();
    		
    		miGrillaLogica.getBloque(13,19).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(13,20).getMiRepresentacion().setBloquePared();
    		for(int columnas=22;columnas<28;columnas++) {
    			miGrillaLogica.getBloque(13,columnas).getMiRepresentacion().setBloquePared();
    		}
    		//fila 14
    		miGrillaLogica.getBloque(14,10).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(14,17).getMiRepresentacion().setBloquePared();
    		//fila15
    		for(int columnas=0;columnas<6;columnas++) {
    			miGrillaLogica.getBloque(15,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		miGrillaLogica.getBloque(15,7).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(15,8).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(15,10).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(15,17).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(15,19).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(15,20).getMiRepresentacion().setBloquePared();
    		for(int columnas=22;columnas<28;columnas++) {
    			miGrillaLogica.getBloque(15,columnas).getMiRepresentacion().setBloquePared();
    		}
    		//fila16
    		for(int columnas=0;columnas<6;columnas++) {
    			miGrillaLogica.getBloque(16,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		miGrillaLogica.getBloque(16,7).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(16,8).getMiRepresentacion().setBloquePared();
    		for(int columnas=10;columnas<18;columnas++) {
    			miGrillaLogica.getBloque(16,columnas).getMiRepresentacion().setBloquePared();
    		}
    		miGrillaLogica.getBloque(16,19).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(16,20).getMiRepresentacion().setBloquePared();
    		for(int columnas=22;columnas<28;columnas++) {
    			miGrillaLogica.getBloque(16,columnas).getMiRepresentacion().setBloquePared();
    		}
    		
    		//fila17
    		for(int columnas=0;columnas<6;columnas++) {
    			miGrillaLogica.getBloque(17,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		miGrillaLogica.getBloque(17,7).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(17,8).getMiRepresentacion().setBloquePared();
    		
    		miGrillaLogica.getBloque(17,19).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(17,20).getMiRepresentacion().setBloquePared();
    		for(int columnas=22;columnas<28;columnas++) {
    			miGrillaLogica.getBloque(17,columnas).getMiRepresentacion().setBloquePared();
    		}
    		
    		//fila18
    		for(int columnas=0;columnas<6;columnas++) {
    			miGrillaLogica.getBloque(18,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		miGrillaLogica.getBloque(18,7).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(18,8).getMiRepresentacion().setBloquePared();
    		for(int columnas=10;columnas<18;columnas++) {
    			miGrillaLogica.getBloque(18,columnas).getMiRepresentacion().setBloquePared();
    		}
    		miGrillaLogica.getBloque(18,19).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(18,20).getMiRepresentacion().setBloquePared();
    		for(int columnas=22;columnas<28;columnas++) {
    			miGrillaLogica.getBloque(18,columnas).getMiRepresentacion().setBloquePared();
    		}
    		
    		//fila 19
    		for(int columnas=0;columnas<6;columnas++) {
    			miGrillaLogica.getBloque(19,columnas).getMiRepresentacion().setBloquePared();
    		}	
    		miGrillaLogica.getBloque(19,7).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(19,8).getMiRepresentacion().setBloquePared();
    		for(int columnas=10;columnas<18;columnas++) {
    			miGrillaLogica.getBloque(19,columnas).getMiRepresentacion().setBloquePared();
    		}
    		miGrillaLogica.getBloque(19,19).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(19,20).getMiRepresentacion().setBloquePared();
    		for(int columnas=22;columnas<28;columnas++) {
    			miGrillaLogica.getBloque(19,columnas).getMiRepresentacion().setBloquePared();
    		}
    		
    		//fila 20
    		miGrillaLogica.getBloque(20,0).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(20,13).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(20,14).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(20,27).getMiRepresentacion().setBloquePared();
    		
    		//fila 21
    		miGrillaLogica.getBloque(21,0).getMiRepresentacion().setBloquePared();
    		for(int columnas=2;columnas<6;columnas++) {
    			miGrillaLogica.getBloque(21,columnas).getMiRepresentacion().setBloquePared();
    		}
    		for(int columnas=7;columnas<12;columnas++) {
    			miGrillaLogica.getBloque(21,columnas).getMiRepresentacion().setBloquePared();
    		}
    		miGrillaLogica.getBloque(21,13).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(21,14).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(21,27).getMiRepresentacion().setBloquePared();
    		for(int columnas=16;columnas<21;columnas++) {
    			miGrillaLogica.getBloque(21,columnas).getMiRepresentacion().setBloquePared();
    		}
    		for(int columnas=22;columnas<26;columnas++) {
    			miGrillaLogica.getBloque(21,columnas).getMiRepresentacion().setBloquePared();
    		}
    		
    		//fila 22
    		miGrillaLogica.getBloque(22,0).getMiRepresentacion().setBloquePared();
    		for(int columnas=2;columnas<6;columnas++) {
    			miGrillaLogica.getBloque(22,columnas).getMiRepresentacion().setBloquePared();
    		}
    		for(int columnas=7;columnas<12;columnas++) {
    			miGrillaLogica.getBloque(22,columnas).getMiRepresentacion().setBloquePared();
    		}
    		miGrillaLogica.getBloque(22,13).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(22,14).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(22,27).getMiRepresentacion().setBloquePared();
    		for(int columnas=16;columnas<21;columnas++) {
    			miGrillaLogica.getBloque(22,columnas).getMiRepresentacion().setBloquePared();
    		}
    		for(int columnas=22;columnas<26;columnas++) {
    			miGrillaLogica.getBloque(22,columnas).getMiRepresentacion().setBloquePared();
    		}
    		
    		//fila 23
    		miGrillaLogica.getBloque(23,0).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(23,4).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(23,5).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(23,22).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(23,23).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(23,27).getMiRepresentacion().setBloquePared();
    		
    		//fila24
    		for(int columnas=0;columnas<3;columnas++) {
    			miGrillaLogica.getBloque(24,columnas).getMiRepresentacion().setBloquePared();
    		}
    		miGrillaLogica.getBloque(24,4).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(24,5).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(24,7).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(24,8).getMiRepresentacion().setBloquePared();
    		for(int columnas=10;columnas<18;columnas++) {
    			miGrillaLogica.getBloque(24,columnas).getMiRepresentacion().setBloquePared();
    		}
    		miGrillaLogica.getBloque(24,19).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(24,20).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(24,22).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(24,23).getMiRepresentacion().setBloquePared();
    		for(int columnas=25;columnas<28;columnas++) {
    			miGrillaLogica.getBloque(24,columnas).getMiRepresentacion().setBloquePared();
    		}
    		
    		//fila25
    		for(int columnas=0;columnas<3;columnas++) {
    			miGrillaLogica.getBloque(25,columnas).getMiRepresentacion().setBloquePared();
    		}
    		miGrillaLogica.getBloque(25,4).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(25,5).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(25,7).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(25,8).getMiRepresentacion().setBloquePared();
    		for(int columnas=10;columnas<18;columnas++) {
    			miGrillaLogica.getBloque(25,columnas).getMiRepresentacion().setBloquePared();
    		}
    		miGrillaLogica.getBloque(25,19).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(25,20).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(25,22).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(25,23).getMiRepresentacion().setBloquePared();
    		for(int columnas=25;columnas<28;columnas++) {
    			miGrillaLogica.getBloque(25,columnas).getMiRepresentacion().setBloquePared();
    		}
    		
    		//fila 26
    		miGrillaLogica.getBloque(26,0).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(26,7).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(26,8).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(26,13).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(26,14).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(26,19).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(26,20).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(26,27).getMiRepresentacion().setBloquePared();
    		
    		//fila27
    		miGrillaLogica.getBloque(27,0).getMiRepresentacion().setBloquePared();
    		for(int columnas=2;columnas<12;columnas++) {
    			miGrillaLogica.getBloque(27,columnas).getMiRepresentacion().setBloquePared();
    		}
    		miGrillaLogica.getBloque(27,13).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(27,14).getMiRepresentacion().setBloquePared();
    		for(int columnas=16;columnas<26;columnas++) {
    			miGrillaLogica.getBloque(27,columnas).getMiRepresentacion().setBloquePared();
    		}
    		miGrillaLogica.getBloque(27,27).getMiRepresentacion().setBloquePared();
    		
    		//fila28
    		miGrillaLogica.getBloque(28,0).getMiRepresentacion().setBloquePared();
    		for(int columnas=2;columnas<12;columnas++) {
    			miGrillaLogica.getBloque(28,columnas).getMiRepresentacion().setBloquePared();
    		}
    		miGrillaLogica.getBloque(28,13).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(28,14).getMiRepresentacion().setBloquePared();
    		for(int columnas=16;columnas<26;columnas++) {
    			miGrillaLogica.getBloque(28,columnas).getMiRepresentacion().setBloquePared();
    		}
    		miGrillaLogica.getBloque(28,27).getMiRepresentacion().setBloquePared();
    		//fila 29
    		miGrillaLogica.getBloque(29,0).getMiRepresentacion().setBloquePared();
    		miGrillaLogica.getBloque(29,27).getMiRepresentacion().setBloquePared();
    		//fila 30
    		for(int columnas=0;columnas<28;columnas++) {
    			miGrillaLogica.getBloque(30,columnas).getMiRepresentacion().setBloquePared();
    		}	
    	}
    }
}
