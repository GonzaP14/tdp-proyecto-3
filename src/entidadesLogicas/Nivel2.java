package entidadesLogicas;

import entidadesGraficas.Laberinto;

public class Nivel2 implements BuilderNivel {
	

	public Object[][] paredes;
	public static final int Filas = 31;
    public static final int Columnas = 28;
    public static final Object pared =1;
    public static final Object puerta =2;
    public static final Object casaFantasma =3;
	public Nivel2() {
		paredes=new Object[Filas][Columnas];
	}
	@Override
	public Laberinto getLaberinto(Grilla miGrillaLogica, int dominio) {
		Laberinto laberinto = new Laberinto(miGrillaLogica);
		 //fila 0		
   		for(int columnas=0;columnas<28;columnas++) {
   			paredes[0][columnas]=1;
   		}	
   		//fila 1
   		paredes[1][0]=pared;
   		paredes[1][13]=pared;
   		paredes[1][14]=pared;
   		paredes[1][27]=pared;
   			
   		//fila 2
   		paredes[2][0]=pared;
   		for(int columnas=2;columnas<6;columnas++) {
   			paredes[2][columnas]=pared;
   		}	
   		for(int columnas=7;columnas<12;columnas++) {
   			paredes[2][columnas]=pared;
   		}	 
   		paredes[2][13]=pared;
   		paredes[2][14]=pared;
   		for(int columnas=16;columnas<21;columnas++) {
   			paredes[2][columnas]=pared;
   		}	
   		for(int columnas=22;columnas<26;columnas++) {
   			paredes[2][columnas]=pared;
   		}	
   		paredes[2][27]=pared;
   		
   		//fila 3
   		paredes[3][0]=pared;
   		for(int columnas=2;columnas<6;columnas++) {
   			paredes[3][columnas]=pared;
   		}	
   		for(int columnas=7;columnas<12;columnas++) {
   			paredes[3][columnas]=pared;
   		}	 
   		paredes[3][13]=pared;
   		paredes[3][14]=pared;
   		for(int columnas=16;columnas<21;columnas++) {
   			paredes[3][columnas]=pared;
   		}	
   		for(int columnas=22;columnas<26;columnas++) {
   			paredes[3][columnas]=pared;
   		}	
   		paredes[3][27]=pared;
   		
   		//fila4
   		paredes[4][0]=pared;
   		for(int columnas=2;columnas<6;columnas++) {
   			paredes[4][columnas]=pared;
   		}	
   		for(int columnas=7;columnas<12;columnas++) {
   			paredes[4][columnas]=pared;
   		}	 
   		paredes[4][13]=pared;
   		paredes[4][14]=pared;
   		for(int columnas=16;columnas<21;columnas++) {
   			paredes[4][columnas]=pared;
   		}	
   		for(int columnas=22;columnas<26;columnas++) {
   			paredes[4][columnas]=pared;
   		}	
   		paredes[4][27]=pared;
   		
   		//fila5
   		paredes[5][0]=pared;
   		paredes[5][27]=pared;
   		
   		//fila6
   		paredes[6][0]=pared;
   		for(int columnas=2;columnas<6;columnas++) {
   			paredes[6][columnas]=pared;
   		}	
   		paredes[6][7]=pared;
   		paredes[6][8]=pared;
   		
   		for(int columnas=10;columnas<18;columnas++) {
   			paredes[6][columnas]=pared;
   		}
   		
   		paredes[6][19]=pared;
   		paredes[6][20]=pared;
   		for(int columnas=22;columnas<26;columnas++) {
   			paredes[6][columnas]=pared;
   		}	
   		paredes[6][27]=pared;
   		
   		//fila7
   		paredes[7][0]=pared;
   		for(int columnas=2;columnas<6;columnas++) {
   			paredes[7][columnas]=pared;
   		}	
   		paredes[7][7]=pared;  
   		paredes[7][8]=pared;
   		for(int columnas=10;columnas<18;columnas++) {
   			paredes[7][columnas]=pared;
   		}		
   		paredes[7][19]=pared;
   		paredes[7][20]=pared;
   		for(int columnas=22;columnas<26;columnas++) {
   			paredes[7][columnas]=pared;
   		}	
   		paredes[7][27]=pared;
   		
   		//fila8
   		paredes[8][0]=pared;
   		paredes[8][7]=pared;
   		paredes[8][8]=pared;
   		paredes[8][13]=pared;
   		paredes[8][14]=pared;
   		paredes[8][19]=pared;
   		paredes[8][20]=pared;
   		paredes[8][27]=pared;
   		
   		
   		//fila 9
   		for(int columnas=0;columnas<6;columnas++) {
   			paredes[9][columnas]=pared;
   		}	
   		for(int columnas=7;columnas<12;columnas++) {
   			paredes[9][columnas]=pared;
   		}	
   		paredes[9][13]=1;
   		paredes[9][14]=1;
   		for(int columnas=16;columnas<21;columnas++) {
   			paredes[9][columnas]=pared;
   		}	
   		for(int columnas=22;columnas<28;columnas++) {
   			paredes[9][columnas]=pared;
   		}		   
   		
   		//fila 10
   		for(int columnas=0;columnas<6;columnas++) {
   			paredes[10][columnas]=pared;
   		}	
   		for(int columnas=7;columnas<12;columnas++) {
   			paredes[10][columnas]=pared;
   		}	
   		paredes[10][13]=pared;
   		paredes[10][14]=pared;
   		for(int columnas=16;columnas<21;columnas++) {
   			paredes[10][columnas]=1;
   		}	
   		for(int columnas=22;columnas<28;columnas++) {
   			paredes[10][columnas]=pared;
   		}		
   		
   		//fila 11
   		for(int columnas=0;columnas<6;columnas++) {
   			paredes[11][columnas]=pared;
   		}	
   		paredes[11][7]=pared;
   		paredes[11][8]=pared;
   		paredes[11][19]=pared;
   		paredes[11][20]=pared;
   		
   		for(int columnas=22;columnas<28;columnas++) {
   			paredes[11][columnas]=pared;
   		}
   		//fila12
   		for(int columnas=0;columnas<6;columnas++) {
   			paredes[12][columnas]=pared;
   		}	
   		paredes[12][7]=pared;
   		paredes[12][8]=pared;
   		
   		for(int columnas=10;columnas<13;columnas++) {
   			paredes[12][columnas]=pared;
   		}
   		paredes[12][13]=puerta;
   		paredes[12][14]=puerta;   		
   		for(int columnas=15;columnas<18;columnas++) {
   			paredes[12][columnas]=pared;
   		}
   		paredes[12][19]=pared;
   		paredes[12][20]=pared;

   		for(int columnas=22;columnas<28;columnas++) {
   			paredes[12][columnas]=pared;
   		}
   		
   		//fila13
   		for(int columnas=0;columnas<6;columnas++) {
   			paredes[13][columnas]=pared;
   		}	
   		paredes[13][7]=pared;
   		paredes[13][8]=pared;
   		paredes[13][10]=pared;
   		for(int columnas=11;columnas<17;columnas++) {
   			paredes[13][columnas]=casaFantasma;
   		}	
   		paredes[13][17]=pared;
   		paredes[13][19]=pared;
   		paredes[13][20]=pared;

   		for(int columnas=22;columnas<28;columnas++) {
   			paredes[13][columnas]=pared;
   		}
   		//fila 14
   		paredes[14][10]=pared;
   		for(int columnas=11;columnas<17;columnas++) {
   			paredes[14][columnas]=casaFantasma;
   		}	
   		paredes[14][17]=pared;
   		//fila15
   		for(int columnas=0;columnas<6;columnas++) {
   			paredes[15][columnas]=pared;
   		}	
   		paredes[15][7]=pared;
   		paredes[15][8]=pared;
   		paredes[15][10]=pared;
   		for(int columnas=11;columnas<17;columnas++) {
   			paredes[15][columnas]=casaFantasma;
   		}	
   		paredes[15][17]=pared;
   		paredes[15][19]=pared;
   		paredes[15][20]=pared;
   		
   		for(int columnas=22;columnas<28;columnas++) {
   			paredes[15][columnas]=pared;
   		}
   		//fila16
   		for(int columnas=0;columnas<6;columnas++) {
   			paredes[16][columnas]=pared;
   		}	
   		paredes[16][7]=pared;
   		paredes[16][8]=pared;
   		for(int columnas=10;columnas<18;columnas++) {
   			paredes[16][columnas]=pared;
   		}
   		paredes[16][19]=pared;
   		paredes[16][20]=pared;
   		for(int columnas=22;columnas<28;columnas++) {
   			paredes[16][columnas]=pared;
   		}
   		
   		//fila17
   		for(int columnas=0;columnas<6;columnas++) {
   			paredes[17][columnas]=pared;
   		}	
   		paredes[17][7]=pared;
   		paredes[17][8]=pared;
   		paredes[17][19]=pared;
   		paredes[17][20]=pared;
   		for(int columnas=22;columnas<28;columnas++) {
   			paredes[17][columnas]=pared;
   		}
   		
   		//fila18
   		for(int columnas=0;columnas<6;columnas++) {
   			paredes[18][columnas]=pared;
   		}	
   		paredes[18][7]=pared;
   		paredes[18][8]=pared;
   		for(int columnas=10;columnas<18;columnas++) {
   			paredes[18][columnas]=pared;
   		}
   		paredes[18][19]=pared;
   		paredes[18][20]=pared;
   		for(int columnas=22;columnas<28;columnas++) {
   			paredes[18][columnas]=pared;
   		}   		
   		//fila 19
   		for(int columnas=0;columnas<6;columnas++) {
   			paredes[19][columnas]=pared;
   		}	
   		paredes[19][7]=pared;
   		paredes[19][8]=pared;
   		for(int columnas=10;columnas<18;columnas++) {
   			paredes[19][columnas]=pared;
   		}
   		paredes[19][19]=pared;
   		paredes[19][20]=pared;
   		for(int columnas=22;columnas<28;columnas++) {
   			paredes[19][columnas]=pared;
   		}
   		
   		//fila 20
   		paredes[20][0]=pared;
   		paredes[20][13]=pared;
   		paredes[20][14]=pared;
   		paredes[20][27]=pared;
   		
   		
   		//fila 21
   		paredes[21][0]=pared;
   		for(int columnas=2;columnas<6;columnas++) {
   			paredes[21][columnas]=pared;
   		}
   		for(int columnas=7;columnas<12;columnas++) {
   			paredes[21][columnas]=pared;
   		}
   		paredes[21][13]=pared;
   		paredes[21][14]=pared;
   		paredes[21][27]=pared;
   		for(int columnas=16;columnas<21;columnas++) {
   			paredes[21][columnas]=pared;
   		}
   		for(int columnas=22;columnas<26;columnas++) {
   			paredes[21][columnas]=pared;
   		}
   		
   		//fila 22
   		paredes[22][0]=pared;
   		for(int columnas=2;columnas<6;columnas++) {
   			paredes[22][columnas]=pared;
   		}
   		for(int columnas=7;columnas<12;columnas++) {
   			paredes[22][columnas]=pared;
   		}
   		paredes[22][13]=pared;
   		paredes[22][14]=pared;
   		paredes[22][27]=pared;
   		for(int columnas=16;columnas<21;columnas++) {
   			paredes[22][columnas]=pared;
   		}
   		for(int columnas=22;columnas<26;columnas++) {
   			paredes[22][columnas]=pared;
   		}
   		
   		//fila 23
   		paredes[23][0]=pared;
   		paredes[23][4]=pared;
   		paredes[23][5]=pared;
   		paredes[23][22]=pared;
   		paredes[23][23]=pared;
   		paredes[23][27]=pared;

   		
   		//fila24
   		for(int columnas=0;columnas<3;columnas++) {
   			paredes[24][columnas]=pared;
   		}
   		paredes[24][4]=pared;
   		paredes[24][5]=pared;
   		paredes[24][7]=pared;
   		paredes[24][8]=pared;
   		
   		for(int columnas=10;columnas<18;columnas++) {
   			paredes[24][columnas]=pared;
   		}
   		paredes[24][19]=pared;
   		paredes[24][20]=pared;
   		paredes[24][22]=pared;
   		paredes[24][23]=pared;
   		for(int columnas=25;columnas<28;columnas++) {
   			paredes[24][columnas]=pared;
   		}
   		
   		//fila25
   		for(int columnas=0;columnas<3;columnas++) {
   			paredes[25][columnas]=pared;
   		}
   		paredes[25][4]=pared;
   		paredes[25][5]=pared;
   		paredes[25][7]=pared;
   		paredes[25][8]=pared;
   		for(int columnas=10;columnas<18;columnas++) {
   			paredes[25][columnas]=pared;
   		}
   		paredes[25][19]=pared;
   		paredes[25][20]=pared;
   		paredes[25][22]=pared;
   		paredes[25][23]=pared;

   		for(int columnas=25;columnas<28;columnas++) {
   			paredes[25][columnas]=pared;
   		}
   		
   		//fila 26
   		paredes[26][0]=pared;
   		paredes[26][7]=pared;
   		paredes[26][8]=pared;
   		paredes[26][13]=pared;
   		paredes[26][14]=pared;
   		paredes[26][19]=pared;
   		paredes[26][20]=pared;
   		paredes[26][27]=pared;
   		
   		//fila27
   		paredes[27][0]=pared;
   		for(int columnas=2;columnas<12;columnas++) {
   			paredes[27][columnas]=pared;
   		}
   		paredes[27][13]=pared;
   		paredes[27][14]=pared;
   		for(int columnas=16;columnas<26;columnas++) {
   			paredes[27][columnas]=pared;
   		}
   		paredes[27][27]=pared;
   		
   		//fila28
   		paredes[28][0]=pared;
   		for(int columnas=2;columnas<12;columnas++) {
   			paredes[28][columnas]=pared;
   		}
   		paredes[28][13]=pared;
   		paredes[28][14]=pared;
   		for(int columnas=16;columnas<26;columnas++) {
   			paredes[28][columnas]=pared;
   		}
   		paredes[28][27]=pared;
   		//fila 29
   		paredes[29][0]=pared;
   		paredes[29][27]=pared;
   		//fila 30
   		for(int columnas=0;columnas<28;columnas++) {
   			paredes[30][columnas]=pared;
   		}
   		for(int i=0;i<31;i++) {
   			for(int j=0;j<28;j++) {
   				if(paredes[i][j]==pared) {
   					miGrillaLogica.getBloque(i,j).getMiRepresentacion().setBloqueParedLvl2(dominio);
   		   			miGrillaLogica.getBloque(i,j).setPuedeVisitarse(false);
   				}
   				else if(paredes[i][j]==puerta){
   					miGrillaLogica.getBloque(i,j).getMiRepresentacion().setPuerta(dominio);
   		   			miGrillaLogica.getBloque(i,j).setPuedeVisitarse(false);
   				}
   				else if(paredes[i][j]==casaFantasma) {
   					miGrillaLogica.getBloque(i,j).setPuedeVisitarse(false);
   				}
   			}
   		}
		return laberinto;	
	}

	@Override
	public int getIncrementoVelocidadEnemigos() {
		return 1;
	}

	@Override
	public int getDuracionPowerPellet() {
		return 60000;
	}

	@Override
	public int getDuracionPociones() {
		return 6000;
	}

	@Override
	public int getDuracionFrutas() {
		// TODO Auto-generated method stub
		return 10000;
	}

}
