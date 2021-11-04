package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class PacDot extends Elemento {
	private static final Posicion[] misSpawns = 
	{ 
			new Posicion(625,725), new Posicion(600,725), new Posicion(575,725), new Posicion(550,725),
			new Posicion(525,725), new Posicion(500,725), new Posicion(475,725), new Posicion(450,725), 
			new Posicion(425,725), new Posicion(400,725), new Posicion(375,725), new Posicion(350,725),
			new Posicion(325,725), new Posicion(400, 575), new Posicion(425, 575), new Posicion(625,725),
			new Posicion(650,700), new Posicion(650,725), new Posicion(650,650), new Posicion(650,675),
			new Posicion(625,650), new Posicion(600,650), new Posicion(575,650), new Posicion(550,650),
			new Posicion(525,650), new Posicion(525,625), new Posicion(525,600), new Posicion(525,575),
			new Posicion(500,575), new Posicion(475,575), new Posicion(450,575), new Posicion(425,575),
			new Posicion(400,575), new Posicion(375,575), new Posicion(375,700), new Posicion(375,675),
			new Posicion(375,650), new Posicion(400,650), new Posicion(425,650), new Posicion(450,650),
			new Posicion(450,625), new Posicion(450,600), new Posicion(600,575), new Posicion(600,625),
			new Posicion(600,600), new Posicion(650,550), new Posicion(650,525), new Posicion(525,350),
			new Posicion(650,500), new Posicion(625,575), new Posicion(625,500), new Posicion(600,500),
			new Posicion(575,500), new Posicion(550,500), new Posicion(525,500), new Posicion(500,500), 
			new Posicion(475,500), new Posicion(450,500), new Posicion(425,500), new Posicion(400,500),
			new Posicion(375,500), new Posicion(525,525), new Posicion(525,550), new Posicion(375,500), 
			new Posicion(375,525), new Posicion(375,550), new Posicion(525,475), new Posicion(525,450),  
			new Posicion(525,425), new Posicion(525,400), new Posicion(525,375),
			new Posicion(25,725) , new Posicion(50,725) , new Posicion(75,725) , new Posicion(100,725) , new Posicion(125,725) , new Posicion(150,725) , new Posicion(175,725) , new Posicion(200,725),new Posicion(225,725) , new Posicion(250,725) , new Posicion(275,725) , new Posicion(300,725),
            new Posicion(25,700) , new Posicion(25,675) , new Posicion(25,650) , new Posicion(50,650) , new Posicion(75,650) , new Posicion(100,650) , new Posicion(125,650) , new Posicion(150,650) , new Posicion(75,575) , new Posicion(75,600) , new Posicion(75,625) , new Posicion(150,625)  ,
            new Posicion(150,600) , new Posicion(150,575) , new Posicion(150,550) , new Posicion(150,525) , new Posicion(150,500) , new Posicion(150,475) , new Posicion(150,450) , new Posicion(150,425) , new Posicion(150,400) , new Posicion(150,375) , new Posicion(150,350),
            new Posicion(25,500), new Posicion(50,500), new Posicion(75,500) , new Posicion(100,500) , new Posicion(125,500), new Posicion(150,500), new Posicion(175,500) ,  new Posicion(200,500), new Posicion(225,500), new Posicion(250,500) ,new Posicion(275,500), new Posicion(300,500), 
            new Posicion(25,525) , new Posicion(25,550), new Posicion(50 , 575) , new Posicion(175,575) , new Posicion(200,575) ,  new Posicion(225,575) , new Posicion(250,575) ,  new Posicion(275,575) , new Posicion(300,575) ,  new Posicion(325,575) ,
            new Posicion(200,575) ,  new Posicion(225,575) , new Posicion(300,525), new Posicion(300,550), new Posicion(300,700) , new Posicion(300,675), new Posicion(300,650), new Posicion(275,650) , new Posicion(250,650) , new Posicion(225,650) , new Posicion(275,650) , new Posicion(275,650) , new Posicion(225,600) , new Posicion(225,625),
            new Posicion(375,25), new Posicion(375,50),
            new Posicion(375,75), new Posicion(375, 100),
            new Posicion(375,125), new Posicion(400,125),
            new Posicion(425,125), new Posicion(450,125),
            new Posicion(475,125), new Posicion(500,125),
            new Posicion(400,25), new Posicion(425, 25),
            new Posicion(450,25), new Posicion(475,25),
            new Posicion(500,25), new Posicion(525,25),
            new Posicion(550,25), new Posicion(575,25),
            new Posicion(600,25), new Posicion(625,25),
            new Posicion(650,25), new Posicion(650,50),
            new Posicion(650,100), new Posicion(650,125),
            new Posicion(525,50), new Posicion(525,75),
            new Posicion(525,100), new Posicion(525,125),
            new Posicion(550,125), new Posicion(575,125),
            new Posicion(600,125), new Posicion(625,125),
            new Posicion(650,150), new Posicion(650,175),
            new Posicion(650,200), new Posicion(525,150),
            new Posicion(525,175), new Posicion(525,200),
            new Posicion(525,225), new Posicion(525,250),
            new Posicion(525,275), new Posicion(525,300),
            new Posicion(525,325), new Posicion(550,200),
            new Posicion(575,200), new Posicion(600,200),
            new Posicion(625,200), new Posicion(450,150),
            new Posicion(450,175), new Posicion(450,200),
            new Posicion(375,200), new Posicion(375,225),
            new Posicion(375,250), new Posicion(400,200),
            new Posicion(425,200), new Posicion(50,25 ),new Posicion(75,25 ),new Posicion(100,25 ),new Posicion(125,25 ),new Posicion(150,25 ),new Posicion(175,25 ),new Posicion(200,25 ),new Posicion(225,25 ),new Posicion(250,25 ),new Posicion(275,25 ),new Posicion(300,25 ),
            new Posicion(25,50 ),new Posicion(150,50 ),new Posicion(300,50 ),
            new Posicion(25,25 ),new Posicion(150,75 ),new Posicion(300,75 ),
            new Posicion(25,100 ),new Posicion(150,100 ),new Posicion(300,100 ),
            new Posicion(25,125 ),new Posicion(50,125 ),new Posicion(75,125 ),new Posicion(100,125 ),new Posicion(125,125 ),new Posicion(150,125 ),new Posicion(175,125 ),new Posicion(200,125 ),new Posicion(225,125 ),new Posicion(250,125 ),new Posicion(275,125 ),new Posicion(300,125 ),new Posicion(325,125 ),new Posicion(350,125),
            new Posicion(25,150 ),new Posicion(150,150 ),new Posicion(225,150 ),
            new Posicion(25,175 ),new Posicion(150,175 ),new Posicion(225,175 ),
            new Posicion(25,200 ),new Posicion(50,200 ),new Posicion(75,200 ),new Posicion(100,200 ),new Posicion(125,200 ),new Posicion(150,200 ),new Posicion(225,200 ),new Posicion(250,200 ),new Posicion(275,200 ),new Posicion(300,200 ),
            new Posicion(150,225 ),new Posicion(300,225 ),
            new Posicion(150,250 ),new Posicion(300,250),
            new Posicion(150,275 ),
            new Posicion(150,300 ),
            new Posicion(150,325 )
	};
	public PacDot(Juego miJuego, String imagen) {
		this.miJuego = miJuego;
		miRepresentacion = new ElementoGrafico(imagen);
		puntajeOtorgado = 10;
	}

	
	@Override
	public void iniciarTimer(HiloElemento timer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar() {
		// TODO Auto-generated method stub
		
	}

	public static Posicion[] getMisSpawns() {
		return misSpawns;
	}

}
