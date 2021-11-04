package entidadesLogicas;

import entidadesGraficas.Laberinto;

public class Nivel3 implements BuilderNivel {
	
	@Override
	public Laberinto getLaberinto(Grilla miGrillaLogica) {
		Laberinto laberinto = new Laberinto(miGrillaLogica);
		 //fila 0		
   		for(int columnas=0;columnas<28;columnas++) {
   			miGrillaLogica.getBloque(0,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(0,columnas).setPuedeVisitarse(false);
   		}	
   		//fila 1
   		miGrillaLogica.getBloque(1,0).getMiRepresentacion().setBloqueParedLvl3();  	
   		miGrillaLogica.getBloque(1,13).getMiRepresentacion().setBloqueParedLvl3();  	
   		miGrillaLogica.getBloque(1,14).getMiRepresentacion().setBloqueParedLvl3();  	
   		miGrillaLogica.getBloque(1,27).getMiRepresentacion().setBloqueParedLvl3();  	

   		miGrillaLogica.getBloque(1,0).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(1,13).setPuedeVisitarse(false); 	
   		miGrillaLogica.getBloque(1,14).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(1,27).setPuedeVisitarse(false);
   			
   		//fila 2
   		miGrillaLogica.getBloque(2,0).getMiRepresentacion().setBloqueParedLvl3();  
   		miGrillaLogica.getBloque(2,0).setPuedeVisitarse(false);
   		for(int columnas=2;columnas<6;columnas++) {
   			miGrillaLogica.getBloque(2,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(2,columnas).setPuedeVisitarse(false);
   		}	
   		for(int columnas=7;columnas<12;columnas++) {
   			miGrillaLogica.getBloque(2,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(2,columnas).setPuedeVisitarse(false);
   		}	 
   		miGrillaLogica.getBloque(2,13).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(2,14).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(2,13).setPuedeVisitarse(false);   		
   		miGrillaLogica.getBloque(2,14).setPuedeVisitarse(false);
   		for(int columnas=16;columnas<21;columnas++) {
   			miGrillaLogica.getBloque(2,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(2,columnas).setPuedeVisitarse(false);
   		}	
   		for(int columnas=22;columnas<26;columnas++) {
   			miGrillaLogica.getBloque(2,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(2,columnas).setPuedeVisitarse(false);
   		}	
   		miGrillaLogica.getBloque(2,27).getMiRepresentacion().setBloqueParedLvl3(); 
   		miGrillaLogica.getBloque(2,27).setPuedeVisitarse(false);
   		
   		//fila 3
   		miGrillaLogica.getBloque(3,0).getMiRepresentacion().setBloqueParedLvl3();  
   		miGrillaLogica.getBloque(3,0).setPuedeVisitarse(false);
   		for(int columnas=2;columnas<6;columnas++) {
   			miGrillaLogica.getBloque(3,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(3,columnas).setPuedeVisitarse(false);
   		}	
   		for(int columnas=7;columnas<12;columnas++) {
   			miGrillaLogica.getBloque(3,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(3,columnas).setPuedeVisitarse(false);
   		}	 
   		miGrillaLogica.getBloque(3,13).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(3,14).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(3,13).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(3,14).setPuedeVisitarse(false);
   		for(int columnas=16;columnas<21;columnas++) {
   			miGrillaLogica.getBloque(3,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(3,columnas).setPuedeVisitarse(false);
   		}	
   		for(int columnas=22;columnas<26;columnas++) {
   			miGrillaLogica.getBloque(3,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(3,columnas).setPuedeVisitarse(false);
   		}	
   		miGrillaLogica.getBloque(3,27).getMiRepresentacion().setBloqueParedLvl3(); 
   		miGrillaLogica.getBloque(3,27).setPuedeVisitarse(false);
   		
   		//fila4
   		miGrillaLogica.getBloque(4,0).getMiRepresentacion().setBloqueParedLvl3();  
   		miGrillaLogica.getBloque(4,0).setPuedeVisitarse(false);
   		for(int columnas=2;columnas<6;columnas++) {
   			miGrillaLogica.getBloque(4,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(4,columnas).setPuedeVisitarse(false);
   		}	
   		for(int columnas=7;columnas<12;columnas++) {
   			miGrillaLogica.getBloque(4,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(4,columnas).setPuedeVisitarse(false);
   		}	 
   		miGrillaLogica.getBloque(4,13).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(4,14).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(4,13).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(4,14).setPuedeVisitarse(false);
   		for(int columnas=16;columnas<21;columnas++) {
   			miGrillaLogica.getBloque(4,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(4,columnas).setPuedeVisitarse(false);
   		}	
   		for(int columnas=22;columnas<26;columnas++) {
   			miGrillaLogica.getBloque(4,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(4,columnas).setPuedeVisitarse(false);
   		}	
   		miGrillaLogica.getBloque(4,27).getMiRepresentacion().setBloqueParedLvl3(); 
   		miGrillaLogica.getBloque(4,27).setPuedeVisitarse(false);
   		
   		//fila5
   		miGrillaLogica.getBloque(5,0).getMiRepresentacion().setBloqueParedLvl3(); 
   		miGrillaLogica.getBloque(5,27).getMiRepresentacion().setBloqueParedLvl3();   
   		miGrillaLogica.getBloque(5,0).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(5,27).setPuedeVisitarse(false);
   		
   		//fila6
   		miGrillaLogica.getBloque(6,0).getMiRepresentacion().setBloqueParedLvl3(); 
   		miGrillaLogica.getBloque(6,0).setPuedeVisitarse(false);
   		for(int columnas=2;columnas<6;columnas++) {
   			miGrillaLogica.getBloque(6,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(6,columnas).setPuedeVisitarse(false);
   		}	
   		miGrillaLogica.getBloque(6,7).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(6,8).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(6,7).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(6,8).setPuedeVisitarse(false);
   		
   		for(int columnas=10;columnas<18;columnas++) {
   			miGrillaLogica.getBloque(6,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(6,columnas).setPuedeVisitarse(false);
   		}
   		
   		miGrillaLogica.getBloque(6,19).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(6,20).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(6,19).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(6,20).setPuedeVisitarse(false);
   		for(int columnas=22;columnas<26;columnas++) {
   			miGrillaLogica.getBloque(6,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(6,columnas).setPuedeVisitarse(false);
   		}	
   		miGrillaLogica.getBloque(6,27).getMiRepresentacion().setBloqueParedLvl3(); 
   		miGrillaLogica.getBloque(6,27).setPuedeVisitarse(false);
   		
   		//fila7
   		miGrillaLogica.getBloque(7,0).getMiRepresentacion().setBloqueParedLvl3(); 
   		miGrillaLogica.getBloque(7,0).setPuedeVisitarse(false);
   		for(int columnas=2;columnas<6;columnas++) {
   			miGrillaLogica.getBloque(7,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(7,columnas).setPuedeVisitarse(false);
   		}	
   		miGrillaLogica.getBloque(7,7).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(7,8).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(7,7).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(7,8).setPuedeVisitarse(false);    		
   		for(int columnas=10;columnas<18;columnas++) {
   			miGrillaLogica.getBloque(7,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(7,columnas).setPuedeVisitarse(false);
   		}		
   		miGrillaLogica.getBloque(7,19).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(7,20).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(7,19).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(7,20).setPuedeVisitarse(false);
   		for(int columnas=22;columnas<26;columnas++) {
   			miGrillaLogica.getBloque(7,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(7,columnas).setPuedeVisitarse(false);
   		}	
   		miGrillaLogica.getBloque(7,27).getMiRepresentacion().setBloqueParedLvl3(); 
   		miGrillaLogica.getBloque(7,27).setPuedeVisitarse(false);
   		
   		//fila8
   		miGrillaLogica.getBloque(8,0).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(8,7).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(8,8).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(8,13).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(8,14).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(8,19).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(8,20).getMiRepresentacion().setBloqueParedLvl3();  		
   		miGrillaLogica.getBloque(8,27).getMiRepresentacion().setBloqueParedLvl3();
   		
   		miGrillaLogica.getBloque(8,0).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(8,7).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(8,8).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(8,13).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(8,14).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(8,19).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(8,20).setPuedeVisitarse(false);  		
   		miGrillaLogica.getBloque(8,27).setPuedeVisitarse(false);
   		
   		//fila 9
   		for(int columnas=0;columnas<6;columnas++) {
   			miGrillaLogica.getBloque(9,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(9,columnas).setPuedeVisitarse(false);
   		}	
   		for(int columnas=7;columnas<12;columnas++) {
   			miGrillaLogica.getBloque(9,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(9,columnas).setPuedeVisitarse(false);
   		}	
   		miGrillaLogica.getBloque(9,13).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(9,14).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(9,13).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(9,14).setPuedeVisitarse(false);
   		for(int columnas=16;columnas<21;columnas++) {
   			miGrillaLogica.getBloque(9,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(9,columnas).setPuedeVisitarse(false);
   		}	
   		for(int columnas=22;columnas<28;columnas++) {
   			miGrillaLogica.getBloque(9,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(9,columnas).setPuedeVisitarse(false);
   		}		   	
   		
   		//fila 10
   		for(int columnas=0;columnas<6;columnas++) {
   			miGrillaLogica.getBloque(10,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(10,columnas).setPuedeVisitarse(false);
   		}	
   		for(int columnas=7;columnas<12;columnas++) {
   			miGrillaLogica.getBloque(10,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(10,columnas).setPuedeVisitarse(false);
   		}	
   		miGrillaLogica.getBloque(10,13).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(10,14).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(10,13).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(10,14).setPuedeVisitarse(false);
   		for(int columnas=16;columnas<21;columnas++) {
   			miGrillaLogica.getBloque(10,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(10,columnas).setPuedeVisitarse(false);
   		}	
   		for(int columnas=22;columnas<28;columnas++) {
   			miGrillaLogica.getBloque(10,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(10,columnas).setPuedeVisitarse(false);
   		}		
   		
   		//fila 11
   		for(int columnas=0;columnas<6;columnas++) {
   			miGrillaLogica.getBloque(11,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(11,columnas).setPuedeVisitarse(false);
   		}	
   		miGrillaLogica.getBloque(11,7).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(11,8).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(11,19).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(11,20).getMiRepresentacion().setBloqueParedLvl3();
   		
   		miGrillaLogica.getBloque(11,7).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(11,8).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(11,19).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(11,20).setPuedeVisitarse(false);
   		for(int columnas=22;columnas<28;columnas++) {
   			miGrillaLogica.getBloque(11,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(11,columnas).setPuedeVisitarse(false);
   		}
   		//fila12
   		for(int columnas=0;columnas<6;columnas++) {
   			miGrillaLogica.getBloque(12,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(12,columnas).setPuedeVisitarse(false);
   		}	
   		miGrillaLogica.getBloque(12,7).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(12,8).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(12,7).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(12,8).setPuedeVisitarse(false);
   		
   		for(int columnas=10;columnas<13;columnas++) {
   			miGrillaLogica.getBloque(12,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(12,columnas).setPuedeVisitarse(false);
   		}
   		miGrillaLogica.getBloque(12,13).getMiRepresentacion().setPuerta();
   		miGrillaLogica.getBloque(12,14).getMiRepresentacion().setPuerta();
   		miGrillaLogica.getBloque(12,13).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(12,14).setPuedeVisitarse(false);
   		
   		for(int columnas=15;columnas<18;columnas++) {
   			miGrillaLogica.getBloque(12,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(12,columnas).setPuedeVisitarse(false);
   		}
   		miGrillaLogica.getBloque(12,19).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(12,20).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(12,19).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(12,20).setPuedeVisitarse(false);
   		for(int columnas=22;columnas<28;columnas++) {
   			miGrillaLogica.getBloque(12,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(12,columnas).setPuedeVisitarse(false);
   		}
   		
   		//fila13
   		for(int columnas=0;columnas<6;columnas++) {
   			miGrillaLogica.getBloque(13,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(13,columnas).setPuedeVisitarse(false);
   		}	
   		miGrillaLogica.getBloque(13,7).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(13,8).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(13,10).getMiRepresentacion().setBloqueParedLvl3();
   		for(int columnas=11;columnas<17;columnas++) {
   			miGrillaLogica.getBloque(13,columnas).setPuedeVisitarse(false);
   		}	
   		miGrillaLogica.getBloque(13,17).getMiRepresentacion().setBloqueParedLvl3();    		
   		miGrillaLogica.getBloque(13,19).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(13,20).getMiRepresentacion().setBloqueParedLvl3();
   		
   		miGrillaLogica.getBloque(13,7).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(13,8).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(13,10).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(13,17).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(13,19).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(13,20).setPuedeVisitarse(false);
   		for(int columnas=22;columnas<28;columnas++) {
   			miGrillaLogica.getBloque(13,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(13,columnas).setPuedeVisitarse(false);
   		}
   		//fila 14
   		miGrillaLogica.getBloque(14,10).getMiRepresentacion().setBloqueParedLvl3();
   		for(int columnas=11;columnas<17;columnas++) {
   			miGrillaLogica.getBloque(14,columnas).setPuedeVisitarse(false);
   		}	
   		miGrillaLogica.getBloque(14,17).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(14,10).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(14,17).setPuedeVisitarse(false);
   		//fila15
   		for(int columnas=0;columnas<6;columnas++) {
   			miGrillaLogica.getBloque(15,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(15,columnas).setPuedeVisitarse(false);
   		}	
   		miGrillaLogica.getBloque(15,7).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(15,8).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(15,10).getMiRepresentacion().setBloqueParedLvl3();
   		for(int columnas=11;columnas<17;columnas++) {
   			miGrillaLogica.getBloque(15,columnas).setPuedeVisitarse(false);
   		}	
   		miGrillaLogica.getBloque(15,17).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(15,19).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(15,20).getMiRepresentacion().setBloqueParedLvl3();
   		
   		miGrillaLogica.getBloque(15,7).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(15,8).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(15,10).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(15,17).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(15,19).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(15,20).setPuedeVisitarse(false);
   		for(int columnas=22;columnas<28;columnas++) {
   			miGrillaLogica.getBloque(15,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(15,columnas).setPuedeVisitarse(false);
   		}
   		//fila16
   		for(int columnas=0;columnas<6;columnas++) {
   			miGrillaLogica.getBloque(16,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(16,columnas).setPuedeVisitarse(false);
   		}	
   		miGrillaLogica.getBloque(16,7).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(16,8).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(16,7).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(16,8).setPuedeVisitarse(false);
   		for(int columnas=10;columnas<18;columnas++) {
   			miGrillaLogica.getBloque(16,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(16,columnas).setPuedeVisitarse(false);
   		}
   		miGrillaLogica.getBloque(16,19).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(16,20).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(16,19).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(16,20).setPuedeVisitarse(false);
   		for(int columnas=22;columnas<28;columnas++) {
   			miGrillaLogica.getBloque(16,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(16,columnas).setPuedeVisitarse(false);
   		}
   		
   		//fila17
   		for(int columnas=0;columnas<6;columnas++) {
   			miGrillaLogica.getBloque(17,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(17,columnas).setPuedeVisitarse(false);
   		}	
   		miGrillaLogica.getBloque(17,7).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(17,8).getMiRepresentacion().setBloqueParedLvl3();   		
   		miGrillaLogica.getBloque(17,19).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(17,20).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(17,7).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(17,8).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(17,19).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(17,20).setPuedeVisitarse(false);
   		for(int columnas=22;columnas<28;columnas++) {
   			miGrillaLogica.getBloque(17,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(17,columnas).setPuedeVisitarse(false);
   		}
   		
   		//fila18
   		for(int columnas=0;columnas<6;columnas++) {
   			miGrillaLogica.getBloque(18,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(18,columnas).setPuedeVisitarse(false);
   		}	
   		miGrillaLogica.getBloque(18,7).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(18,8).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(18,7).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(18,8).setPuedeVisitarse(false);
   		for(int columnas=10;columnas<18;columnas++) {
   			miGrillaLogica.getBloque(18,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(18,columnas).setPuedeVisitarse(false);
   		}
   		miGrillaLogica.getBloque(18,19).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(18,20).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(18,19).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(18,20).setPuedeVisitarse(false);
   		for(int columnas=22;columnas<28;columnas++) {
   			miGrillaLogica.getBloque(18,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(18,columnas).setPuedeVisitarse(false);
   		}
   		
   		//fila 19
   		for(int columnas=0;columnas<6;columnas++) {
   			miGrillaLogica.getBloque(19,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(19,columnas).setPuedeVisitarse(false);
   		}	
   		miGrillaLogica.getBloque(19,7).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(19,8).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(19,7).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(19,8).setPuedeVisitarse(false);
   		for(int columnas=10;columnas<18;columnas++) {
   			miGrillaLogica.getBloque(19,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(19,columnas).setPuedeVisitarse(false);
   		}
   		miGrillaLogica.getBloque(19,19).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(19,20).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(19,19).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(19,20).setPuedeVisitarse(false);
   		for(int columnas=22;columnas<28;columnas++) {
   			miGrillaLogica.getBloque(19,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(19,columnas).setPuedeVisitarse(false);
   		}
   		
   		//fila 20
   		miGrillaLogica.getBloque(20,0).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(20,13).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(20,14).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(20,27).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(20,0).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(20,13).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(20,14).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(20,27).setPuedeVisitarse(false);
   		
   		//fila 21
   		miGrillaLogica.getBloque(21,0).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(21,0).setPuedeVisitarse(false);
   		for(int columnas=2;columnas<6;columnas++) {
   			miGrillaLogica.getBloque(21,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(21,columnas).setPuedeVisitarse(false);
   		}
   		for(int columnas=7;columnas<12;columnas++) {
   			miGrillaLogica.getBloque(21,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(21,columnas).setPuedeVisitarse(false);
   		}
   		miGrillaLogica.getBloque(21,13).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(21,14).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(21,27).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(21,13).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(21,14).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(21,27).setPuedeVisitarse(false);
   		for(int columnas=16;columnas<21;columnas++) {
   			miGrillaLogica.getBloque(21,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(21,columnas).setPuedeVisitarse(false);
   		}
   		for(int columnas=22;columnas<26;columnas++) {
   			miGrillaLogica.getBloque(21,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(21,columnas).setPuedeVisitarse(false);
   		}
   		
   		//fila 22
   		miGrillaLogica.getBloque(22,0).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(22,0).setPuedeVisitarse(false);
   		for(int columnas=2;columnas<6;columnas++) {
   			miGrillaLogica.getBloque(22,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(22,columnas).setPuedeVisitarse(false);
   		}
   		for(int columnas=7;columnas<12;columnas++) {
   			miGrillaLogica.getBloque(22,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(22,columnas).setPuedeVisitarse(false);
   		}
   		miGrillaLogica.getBloque(22,13).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(22,14).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(22,27).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(22,13).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(22,14).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(22,27).setPuedeVisitarse(false);
   		for(int columnas=16;columnas<21;columnas++) {
   			miGrillaLogica.getBloque(22,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(22,columnas).setPuedeVisitarse(false);
   		}
   		for(int columnas=22;columnas<26;columnas++) {
   			miGrillaLogica.getBloque(22,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(22,columnas).setPuedeVisitarse(false);
   		}
   		
   		//fila 23
   		miGrillaLogica.getBloque(23,0).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(23,4).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(23,5).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(23,22).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(23,23).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(23,27).getMiRepresentacion().setBloqueParedLvl3();
   		
   		miGrillaLogica.getBloque(23,0).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(23,4).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(23,5).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(23,22).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(23,23).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(23,27).setPuedeVisitarse(false);
   		
   		//fila24
   		for(int columnas=0;columnas<3;columnas++) {
   			miGrillaLogica.getBloque(24,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(24,columnas).setPuedeVisitarse(false);
   		}
   		miGrillaLogica.getBloque(24,4).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(24,5).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(24,7).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(24,8).getMiRepresentacion().setBloqueParedLvl3();    		
   		miGrillaLogica.getBloque(24,4).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(24,5).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(24,7).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(24,8).setPuedeVisitarse(false);
   		for(int columnas=10;columnas<18;columnas++) {
   			miGrillaLogica.getBloque(24,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(24,columnas).setPuedeVisitarse(false);
   		}
   		miGrillaLogica.getBloque(24,19).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(24,20).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(24,22).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(24,23).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(24,19).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(24,20).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(24,22).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(24,23).setPuedeVisitarse(false);
   		for(int columnas=25;columnas<28;columnas++) {
   			miGrillaLogica.getBloque(24,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(24,columnas).setPuedeVisitarse(false);
   		}
   		
   		//fila25
   		for(int columnas=0;columnas<3;columnas++) {
   			miGrillaLogica.getBloque(25,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(25,columnas).setPuedeVisitarse(false);
   		}
   		miGrillaLogica.getBloque(25,4).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(25,5).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(25,7).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(25,8).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(25,4).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(25,5).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(25,7).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(25,8).setPuedeVisitarse(false);
   		for(int columnas=10;columnas<18;columnas++) {
   			miGrillaLogica.getBloque(25,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(25,columnas).setPuedeVisitarse(false);
   		}
   		miGrillaLogica.getBloque(25,19).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(25,20).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(25,22).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(25,23).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(25,19).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(25,20).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(25,22).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(25,23).setPuedeVisitarse(false);
   		for(int columnas=25;columnas<28;columnas++) {
   			miGrillaLogica.getBloque(25,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(25,columnas).setPuedeVisitarse(false);
   		}
   		
   		//fila 26
   		miGrillaLogica.getBloque(26,0).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(26,7).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(26,8).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(26,13).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(26,14).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(26,19).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(26,20).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(26,27).getMiRepresentacion().setBloqueParedLvl3();
   		
   		miGrillaLogica.getBloque(26,0).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(26,7).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(26,8).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(26,13).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(26,14).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(26,19).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(26,20).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(26,27).setPuedeVisitarse(false);
   		
   		//fila27
   		miGrillaLogica.getBloque(27,0).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(27,0).setPuedeVisitarse(false);
   		for(int columnas=2;columnas<12;columnas++) {
   			miGrillaLogica.getBloque(27,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(27,columnas).setPuedeVisitarse(false);
   		}
   		miGrillaLogica.getBloque(27,13).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(27,14).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(27,13).setPuedeVisitarse(false);
   		miGrillaLogica.getBloque(27,14).setPuedeVisitarse(false);
   		for(int columnas=16;columnas<26;columnas++) {
   			miGrillaLogica.getBloque(27,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(27,columnas).setPuedeVisitarse(false);
   		}
   		miGrillaLogica.getBloque(27,27).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(27,27).setPuedeVisitarse(false);
   		
   		//fila28
   		miGrillaLogica.getBloque(28,0).getMiRepresentacion().setBloqueParedLvl3();
   		for(int columnas=2;columnas<12;columnas++) {
   			miGrillaLogica.getBloque(28,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(28,columnas).setPuedeVisitarse(false);
   		}
   		miGrillaLogica.getBloque(28,13).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(28,14).getMiRepresentacion().setBloqueParedLvl3();
			miGrillaLogica.getBloque(28,13).setPuedeVisitarse(false);
			miGrillaLogica.getBloque(28,14).setPuedeVisitarse(false);
   		for(int columnas=16;columnas<26;columnas++) {
   			miGrillaLogica.getBloque(28,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(28,columnas).setPuedeVisitarse(false);
   		}
   		miGrillaLogica.getBloque(28,27).getMiRepresentacion().setBloqueParedLvl3();
			miGrillaLogica.getBloque(28,27).setPuedeVisitarse(false);
   		//fila 29
   		miGrillaLogica.getBloque(29,0).getMiRepresentacion().setBloqueParedLvl3();
   		miGrillaLogica.getBloque(29,27).getMiRepresentacion().setBloqueParedLvl3();
			miGrillaLogica.getBloque(29,0).setPuedeVisitarse(false);
			miGrillaLogica.getBloque(29,27).setPuedeVisitarse(false);
   		//fila 30
   		for(int columnas=0;columnas<28;columnas++) {
   			miGrillaLogica.getBloque(30,columnas).getMiRepresentacion().setBloqueParedLvl3();
   			miGrillaLogica.getBloque(30,columnas).setPuedeVisitarse(false);
   		}
		return laberinto;
	}

	@Override
	public int getIncrementoVelocidadEnemigos() {
		return 2;
	}

	@Override
	public int getDuracionPowerPellet() {
		return 30000;
	}

	@Override
	public int getDuracionPociones() {
		return 4000;
	}

	@Override
	public int getDuracionFrutas() {
		return 5000;
	}

}
