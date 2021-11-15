package entidadesLogicas;

import entidadesGraficas.Laberinto;

public class Nivel {
	
	private static final Object pared = new Object();
    private static final Object puerta = new Object();
    private static final Object casaFantasma = new Object();
	protected static Object[][] mapa;
	
	private Grilla miGrilla;
	private Laberinto miLaberinto;
	private DominioJuego dominio;
	private int nivelActual;
	private int duracionPowerPellet;
	private int duracionPociones;
	private int duracionFrutas;
	private int velocidadEnemigos;
	
    public Nivel () {
    	mapa = new Object [Grilla.Filas][Grilla.Columnas];
    	iniciarMapa();
    }

	private void iniciarMapa() {
		for (int i = 0; i < Grilla.Filas; i ++) {
			inicializarFila(i);
		}
	}

	private void inicializarFila(int i) {
		if (i == 0) {
			inicializarFila0();
		} else if (i == 1) {
			inicializarFila1();
		} else if (i == 2) {
			inicializarFila2();
		} else if (i == 3) {
			inicializarFila3();
		} else if (i == 4) {
			inicializarFila4();
		} else if (i == 5) {
			inicializarFila5();
		} else if (i == 6) {
			inicializarFila6();
		} else if (i == 7) {
			inicializarFila7();
		} else if (i == 8) {
			inicializarFila8();
		} else if (i == 9) {
			inicializarFila9();
		} else if (i == 10) {
			inicializarFila10();
		} else if (i == 11) {
			inicializarFila11();
		} else if (i == 12) {
			inicializarFila12();
		} else if (i == 13) {
			inicializarFila13();
		} else if (i == 14) {
			inicializarFila14();
		} else if (i == 15) {
			inicializarFila15();
		} else if (i == 16) {
			inicializarFila16();
		} else if (i == 17) {
			inicializarFila17();
		} else if (i == 18) {
			inicializarFila18();
		} else if (i == 19) {
			inicializarFila19();
		} else if (i == 20) {
			inicializarFila20();
		} else if (i == 21) {
			inicializarFila21();
		} else if (i == 22) {
			inicializarFila22();
		} else if (i == 23) {
			inicializarFila23();
		} else if (i == 24) {
			inicializarFila24();
		} else if (i == 25) {
			inicializarFila25();
		} else if (i == 26) {
			inicializarFila26();
		} else if (i == 27) {
			inicializarFila27();
		} else if (i == 28) {
			inicializarFila28();
		} else if (i == 29) {
			inicializarFila29();
		} else if (i == 30) {
			inicializarFila30();
		}
	}
	
	private void inicializarFila0() {
		for(int j = 0; j < Grilla.Columnas; j++) {
			mapa[0][j] = pared;
		}		
	}
	
	private void inicializarFila1() {
		mapa[1][0] = pared;
   		mapa[1][13] = pared;
   		mapa[1][14] = pared;
   		mapa[1][27] = pared;
	}
    
	private void inicializarFila2() {
		mapa[2][0] = pared;
   		
   		for(int j = 2; j < 6; j ++) {
   			mapa[2][j] = pared;
   		}	
   		
   		for(int j = 7; j < 12; j ++) {
   			mapa[2][j] = pared;
   		}	 
   		
   		mapa[2][13] = pared;
   		mapa[2][14] = pared;
   		
   		for(int j = 16; j < 21; j ++) {
   			mapa[2][j] = pared;
   		}	
   		
   		for(int j = 22; j <26; j ++) {
   			mapa[2][j] = pared;
   		}	
   		
   		mapa[2][27] = pared;
	}
	
	private void inicializarFila3() {
		mapa[3][0] = pared;
   		
   		for(int j = 2; j < 6; j++) {
   			mapa[3][j] = pared;
   		}	
   		
   		for(int j = 7; j < 12; j ++) {
   			mapa[3][j] = pared;
   		}	 
   		
   		mapa[3][13] = pared;
   		mapa[3][14] = pared;
   		
   		for(int j = 16; j < 21; j ++) {
   			mapa[3][j] = pared;
   		}	 
   		
   		for(int j = 22; j < 26; j ++) {
   			mapa[3][j] = pared;
   		}	
   		
   		mapa[3][27] = pared;
	}
	
	private void inicializarFila4() {
   		mapa[4][0] = pared;
   		
   		for(int j = 2; j < 6; j ++) {
   			mapa[4][j] = pared;
   		}	
   		
   		for(int j = 7; j < 12; j ++) {
   			mapa[4][j] = pared;
   		}
   		
   		mapa[4][13] = pared;
   		mapa[4][14] = pared;
   		
   		for(int j = 16; j < 21; j ++) {
   			mapa[4][j] = pared;
   		}
   		
   		for(int j = 22; j < 26; j ++) {
   			mapa[4][j] = pared;
   		}
   		
   		mapa[4][27] = pared;
	}
	
	private void inicializarFila5() {
		mapa[5][0] = pared;
   		mapa[5][27] = pared;
	}

	private void inicializarFila6() {
   		mapa[6][0] = pared;
   		
   		for(int j = 2; j < 6; j ++) {
   			mapa[6][j] = pared;
   		}
   		
   		mapa[6][7] = pared;
   		mapa[6][8] = pared;
   		
   		for(int j = 10; j < 18; j ++) {
   			mapa[6][j] = pared;
   		}
   		
   		mapa[6][19] = pared;
   		mapa[6][20] = pared;
   		
   		for(int j = 22; j < 26; j ++) {
   			mapa[6][j] = pared;
   		}
   		
   		mapa[6][27] = pared;	
	}
	
	private void inicializarFila7() {
   		mapa[7][0] = pared;
   		
   		for(int j = 2; j < 6; j ++) {
   			mapa[7][j] = pared;
   		}
   		
   		mapa[7][7] = pared;  
   		mapa[7][8] = pared;
   		
   		for(int j = 10; j < 18; j ++) {
   			mapa[7][j] = pared;
   		}		
   		
   		mapa[7][19] = pared;
   		mapa[7][20] = pared;
   		
   		for(int j = 22; j < 26; j ++) {
   			mapa[7][j] = pared;
   		}	
   		
   		mapa[7][27] = pared;
	}
	
	private void inicializarFila8() {
   		mapa[8][0] = pared;
   		mapa[8][7] = pared;
   		mapa[8][8] = pared;
   		mapa[8][13] = pared;
   		mapa[8][14] = pared;
   		mapa[8][19] = pared;
   		mapa[8][20] = pared;
   		mapa[8][27] = pared;
	}

	private void inicializarFila9() {
   		for(int j = 0; j < 6; j ++) {
   			mapa[9][j] = pared;
   		}	
   		
   		for(int j = 7; j < 12; j ++) {
   			mapa[9][j] = pared;
   		}
   		
   		mapa[9][13] = pared;
   		mapa[9][14] = pared;
   		
   		for(int j = 16; j < 21; j ++) {
   			mapa[9][j] = pared;
   		}
   		
   		for(int j = 22; j < Grilla.Columnas; j ++) {
   			mapa[9][j] = pared;
   		}		   
	}
	
	private void inicializarFila10() {
   		for(int j = 0; j < 6; j ++) {
   			mapa[10][j] = pared;
   		}
   		
   		for(int j = 7; j < 12; j ++) {
   			mapa[10][j] = pared;
   		}
   		
   		mapa[10][13] = pared;
   		mapa[10][14] = pared;
   		
   		for(int j = 16; j < 21; j ++) {
   			mapa[10][j] = pared;
   		}	
   		
   		for(int j = 22; j < Grilla.Columnas; j ++) {
   			mapa[10][j] =pared;
   		}	
	}
	
	private void inicializarFila11() {
   		for(int j = 0; j < 6; j ++) {
   			mapa[11][j] = pared;
   		}	
   		mapa[11][7] = pared;
   		mapa[11][8] = pared;
   		mapa[11][19] = pared;
   		mapa[11][20] = pared;
   		
   		for(int j = 22; j < Grilla.Columnas; j ++) {
   			mapa[11][j] = pared;
   		}
	}
	
	private void inicializarFila12() {
   		for(int j = 0; j < 6; j ++) {
   			mapa[12][j] = pared;
   		}	
   		mapa[12][7] = pared;
   		mapa[12][8] = pared;
   		
   		for(int j =10; j < 13; j ++) {
   			mapa[12][j] = pared;
   		}
   		
   		mapa[12][13] = puerta;
   		mapa[12][14] = puerta;   		
   		
   		for(int j = 15; j < 18; j ++) {
   			mapa[12][j] = pared;
   		}
   		
   		mapa[12][19] = pared;
   		mapa[12][20] = pared;

   		for(int j = 22; j < Grilla.Columnas; j ++) {
   			mapa[12][j] = pared;
   		}
	}
	
	private void inicializarFila13() {
   		for(int j = 0; j < 6; j ++) {
   			mapa[13][j] = pared;
   		}
   		
   		mapa[13][7] = pared;
   		mapa[13][8] = pared;
   		mapa[13][10] = pared;
   		
   		for(int j = 11; j < 17; j ++) {
   			mapa[13][j] = casaFantasma;
   		}	
   		mapa[13][17] = pared;
   		mapa[13][19] = pared;
   		mapa[13][20] = pared;

   		for(int j = 22; j < Grilla.Columnas; j ++) {
   			mapa[13][j] = pared;
   		}
	}
	
	private void inicializarFila14() {
   		mapa[14][10] = pared;
   		
   		for(int columnas = 11; columnas < 17;columnas++) {
   			mapa[14][columnas] = casaFantasma;
   		}
   		
   		mapa[14][17] = pared;
	}
	
	private void inicializarFila15() {
   		for(int j = 0; j < 6; j ++) {
   			mapa[15][j] = pared;
   		}	
   		
   		mapa[15][7] = pared;
   		mapa[15][8] = pared;
   		mapa[15][10] = pared;
   		
   		for(int j = 11; j < 17; j ++) {
   			mapa[15][j] = casaFantasma;
   		}	
   		
   		mapa[15][17] = pared;
   		mapa[15][19] = pared;
   		mapa[15][20] = pared;
   		
   		for(int j = 22; j < Grilla.Columnas; j ++) {
   			mapa[15][j] = pared;
   		}
	}
	
	private void inicializarFila16() {
   		for(int j = 0; j < 6; j ++) {
   			mapa[16][j] = pared;
   		}	
   		
   		mapa[16][7] = pared;
   		mapa[16][8] = pared;
   		
   		for(int j = 10; j < 18; j ++) {
   			mapa[16][j] = pared;
   		}
   		
   		mapa[16][19] = pared;
   		mapa[16][20] = pared;
   		
   		for(int j = 22; j < Grilla.Columnas; j++) {
   			mapa[16][j] = pared;
   		}
	}
	
	private void inicializarFila17() {
   		for(int j = 0; j < 6; j ++) {
   			mapa[17][j] = pared;
   		}
   		
   		mapa[17][7] = pared;
   		mapa[17][8] = pared;
   		mapa[17][19] = pared;
   		mapa[17][20] = pared;
   		
   		for(int j = 22; j < Grilla.Columnas; j ++) {
   			mapa[17][j] = pared;
   		}
	}
	
	private void inicializarFila18() {
   		for(int j = 0; j < 6; j ++) {
   			mapa[18][j] = pared;
   		}	
   		
   		mapa[18][7] = pared;
   		mapa[18][8] = pared;
   		
   		for(int j = 10; j < 18; j ++) {
   			mapa[18][j] = pared;
   		}
   		
   		mapa[18][19] = pared;
   		mapa[18][20] = pared;
   		
   		for(int j = 22; j < Grilla.Columnas; j ++) {
   			mapa[18][j] = pared;
   		}
	}
	
	private void inicializarFila19() {
   		for(int j = 0; j < 6; j ++) {
   			mapa[19][j] = pared;
   		}
   		
   		mapa[19][7] = pared;
   		mapa[19][8] = pared;
   		
   		for(int j = 10; j < 18; j ++) {
   			mapa[19][j] = pared;
   		}
   		
   		mapa[19][19] = pared;
   		mapa[19][20] = pared;
   		
   		for(int j = 22; j < Grilla.Columnas; j ++) {
   			mapa[19][j] = pared;
   		}
	}
	
	private void inicializarFila20() {
   		mapa[20][0] = pared;
   		mapa[20][13] = pared;
   		mapa[20][14] = pared;
   		mapa[20][27] = pared;
	}
	
	private void inicializarFila21() {
   		mapa[21][0] = pared;
   		
   		for(int j = 2; j < 6; j ++) {
   			mapa[21][j] = pared;
   		}
   		
   		for(int j = 7; j < 12; j ++) {
   			mapa[21][j] = pared;
   		}
   		
   		mapa[21][13] = pared;
   		mapa[21][14] = pared;
   		mapa[21][27] = pared;
   		
   		for(int j = 16; j < 21; j ++) {
   			mapa[21][j] = pared;
   		}
   		for(int j = 22; j < 26; j ++) {
   			mapa[21][j] = pared;
   		}
	}
	
	private void inicializarFila22() {
   		mapa[22][0] = pared;
   		
   		for(int j = 2; j < 6; j ++) {
   			mapa[22][j] = pared;
   		}
   		
   		for(int j = 7; j < 12; j ++) {
   			mapa[22][j] = pared;
   		}
   		
   		mapa[22][13] = pared;
   		mapa[22][14] = pared;
   		mapa[22][27] = pared;
   		
   		for(int j = 16; j < 21; j ++) {
   			mapa[22][j] = pared;
   		}
   		
   		for(int j = 22; j < 26; j ++) {
   			mapa[22][j] = pared;
   		}
	}
	
	private void inicializarFila23() {
   		mapa[23][0] = pared;
   		mapa[23][4] = pared;
   		mapa[23][5] = pared;
   		mapa[23][22] = pared;
   		mapa[23][23] = pared;
   		mapa[23][27] = pared;
	}
	
	private void inicializarFila24() {
   		for(int j = 0; j < 3; j ++) {
   			mapa[24][j] = pared;
   		}
   		
   		mapa[24][4] = pared;
   		mapa[24][5] = pared;
   		mapa[24][7] = pared;
   		mapa[24][8] = pared;
   		
   		for(int j = 10; j < 18; j ++) {
   			mapa[24][j] = pared;
   		}
   		mapa[24][19] = pared;
   		mapa[24][20] = pared;
   		mapa[24][22] = pared;
   		mapa[24][23] = pared;
   		
   		for(int j = 25; j < Grilla.Columnas; j ++) {
   			mapa[24][j] = pared;
   		}
	}
	
	private void inicializarFila25() {
   		for(int j = 0; j < 3; j ++) {
   			mapa[25][j] = pared;
   		}
   		
   		mapa[25][4] = pared;
   		mapa[25][5] = pared;
   		mapa[25][7] = pared;
   		mapa[25][8] = pared;
   		
   		for(int j = 10; j < 18; j ++) {
   			mapa[25][j] = pared;
   		}
   		
   		mapa[25][19] = pared;
   		mapa[25][20] = pared;
   		mapa[25][22] = pared;
   		mapa[25][23] = pared;

   		for(int j = 25; j < Grilla.Columnas; j ++) {
   			mapa[25][j] = pared;
   		}
	}
	
	private void inicializarFila26() {
   		mapa[26][0] = pared;
   		mapa[26][7] = pared;
   		mapa[26][8] = pared;
   		mapa[26][13] = pared;
   		mapa[26][14] = pared;
   		mapa[26][19] = pared;
   		mapa[26][20] = pared;
   		mapa[26][27] = pared;	
	}
	
	private void inicializarFila27() {
   		mapa[27][0] = pared;
   		
   		for(int j = 2; j < 12; j ++) {
   			mapa[27][j] = pared;
   		}
   		
   		mapa[27][13] = pared;
   		mapa[27][14] = pared;
   		
   		for(int j = 16; j < 26; j++) {
   			mapa[27][j] = pared;
   		}
   		
   		mapa[27][27] = pared;
	}
	
	private void inicializarFila28() {
   		mapa[28][0] = pared;
   		
   		for(int j = 2; j < 12; j ++) {
   			mapa[28][j] = pared;
   		}
   		
   		mapa[28][13] = pared;
   		mapa[28][14] = pared;
   		
   		for(int j = 16; j < 26; j ++) {
   			mapa[28][j] = pared;
   		}
   		
   		mapa[28][27] = pared;
	}
	
	private void inicializarFila29() {
   		mapa[29][0] = pared;
   		mapa[29][27] = pared;
	}
	
	private void inicializarFila30() {
   		for(int j = 0; j < Grilla.Columnas; j++) {
   			mapa[30][j] = pared;
   		}
	}

	
	public void setGrilla(Grilla g) {
		miGrilla = g;
	}
	
	public void setDominio(DominioJuego d) {
		dominio = d;
	}
	
	public void setNivelActual(int n) {
		this.nivelActual = n;
	}

	
	public void setDuracionPowerPellet(int d) {
		this.duracionPowerPellet = d;
	}
	
	public void setDuracionPociones(int d) {
		this.duracionPociones = d;
	}
	
	public void setDuracionFrutas(int d) {
		this.duracionFrutas = d;
	}
	
	public void setVelocidadEnemigos(int v) {
		this.velocidadEnemigos = v;
	}
	
	public int getDuracionPowerPellet() {
		return duracionPowerPellet;
	}
	
	public int getDuracionPociones() {
		return duracionPociones;
	}
	
	public int getDuracionFrutas() {
		return duracionFrutas;
	}
	
	public int getVelocidadEnemigos() {
		return velocidadEnemigos;
	}
	
	public Laberinto getLaberinto() {
		miLaberinto = new Laberinto(miGrilla);
		constuirBloques();
		
		return miLaberinto;
	}
	
	private void constuirBloques() {
		
		for (int i = 0; i < Grilla.Filas; i ++) {
			for (int j = 0; j < Grilla.Columnas; j ++) {
				
				if(mapa[i][j] == pared) {
   					miGrilla.getBloque(i,j).getRepresentacionGrafica().setPared(nivelActual, dominio.getDominioJuego());
   					miGrilla.getBloque(i,j).setVisitable(false);
   				}
   				else if(mapa[i][j] == puerta){
   					miGrilla.getBloque(i,j).getRepresentacionGrafica().setPuerta(dominio.getDominioJuego());
   					miGrilla.getBloque(i,j).setVisitable(false);
   				}
   				else if(mapa[i][j] == casaFantasma) {
   					miGrilla.getBloque(i,j).setVisitable(false);
   				}				
			}
		}
	}
	
	
}
