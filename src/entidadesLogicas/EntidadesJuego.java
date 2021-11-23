package entidadesLogicas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dominios.DominioJuego;
import elementos.Elemento;
import elementos.PacDot;
import elementos.PowerPellet;
import factories.FabricaEntidades;
import factories.FabricaGeneral;
import gui.Ventana;
import personajes.Enemigo;
import personajes.Principal;

public class EntidadesJuego {
	// Atributos de instancia
	private Juego miJuego;
	private DominioJuego miDominio;
	private FabricaEntidades miFabricaEntidades;
	private List<Enemigo>  misEnemigos;
	private Principal miPersonajePrincipal;	
	private List<Elemento> misPociones, misPacDots, misPowerPellets;
	private Elemento miFruta;
	
	/**
	 * Crea un Facade (design-pattern) para encapsular comportamiento
	 * relacionado al spawneo, reseteo de las entidades del juego.
	 * @param juego El juego para el cual se aplica el Facade.
	 * @param dominio El dominio relacionado al juego.
	 */
	public EntidadesJuego(Juego juego, DominioJuego dominio) {
		miJuego = juego;
		miDominio = dominio;
	}
	
	
	// ------------------------------------------------------------------------------    COMANDOS    ------------------------------------------------------------------
	
	// ------------------------------------------------------------------------------ CREATE METHODS ------------------------------------------------------------------
	
	/**
	 * Encapsula la creacion de todas las entidades del juego.
	 */
	public void crearEntidades() {
		miFabricaEntidades = new FabricaGeneral(miJuego, miDominio);
		crearPersonajePrincipal();
		crearEnemigos();
		crearPociones();
		crearPacDots();
		crearPowerPellets();
		crearFrutas();
	}	

	/**
	 * Encapsula la creacion del personaje principal.
	 */
	private void crearPersonajePrincipal() {
		miPersonajePrincipal = miFabricaEntidades.getPrincipal();
	}
	
	/**
	 * Encapsula la creacion de los enemigos.
	 */
	private void crearEnemigos() {
		misEnemigos = Collections.synchronizedList(new ArrayList<Enemigo>());
		misEnemigos.add(miFabricaEntidades.getBlinky());
		misEnemigos.add(miFabricaEntidades.getInky());
		misEnemigos.add(miFabricaEntidades.getPinky());
		misEnemigos.add(miFabricaEntidades.getClyde());
	}
	
	/**
	 * Encapsula la creacion de las pociones.
	 */
	private void crearPociones() {
		misPociones = Collections.synchronizedList(new ArrayList<Elemento>());
		misPociones.add(0, miFabricaEntidades.getPocionBomba());
		misPociones.add(1, miFabricaEntidades.getPocionVelocidad());
	}
	
	/**
	 * Encapsula la creacion de los pacdots.
	 */
	private void crearPacDots() {
		misPacDots = Collections.synchronizedList(new ArrayList<Elemento>());
		Elemento actual;
		
		for (Posicion p: PacDot.getMisSpawns()) {
			actual = miFabricaEntidades.getPacDot();
			actual.setSpawneo(p);
			misPacDots.add(actual);
		}
	}
	
	/**
	 * Encapsula la creacion del personaje principal
	 */
	private void crearPowerPellets() {
		misPowerPellets = Collections.synchronizedList(new ArrayList<Elemento>());
		Elemento actual;
		
		for (Posicion p: PowerPellet.getMisSpawns()) {
			actual = miFabricaEntidades.getPowerPellet();
			actual.setSpawneo(p);
			misPowerPellets.add(actual);
		}
		
	}
	/**
	 * Encapsula la creacion de una fruta.
	 */
	private void crearFrutas() {
		miFruta = miFabricaEntidades.getFruta();
	}
	
	// ------------------------------------------------------------------------------ SPAWNING && DESPAWNING METHODS ------------------------------------------------------------------
	
		/**
		 * Aparece por pantalla (graficamente) las entidades necesarias para el comienzo de un nivel.
		 */
		public void aparecerEntidadesGenerales() {
			aparecerPrinicpal();
			aparecerEnemigos();
			aparecerPacDots();
			aparecerPowerPellets();
		}
		
		/**
		 * Aparece por pantalla (graficamente) el personaje principal.
		 */
	    private void aparecerPrinicpal() {
			miJuego.getVentana().aparecerEntidad(miPersonajePrincipal.getMiRepresentacion());
		}
	    
	    /**
		 * Aparece por pantalla (graficamente) los enemigos.
		 */
	    private void aparecerEnemigos() {
			for(Enemigo fantasma: misEnemigos) {
				miJuego.getVentana().aparecerEntidad(fantasma.getMiRepresentacion());
			}
		}
		
	    /**
		 * Aparece por pantalla (graficamente)  la pocion de tipo bomba.
		 */
		public void aparecerPocionBomba() {
			misPociones.get(0).reset();
		}

		/**
		 * Aparece por pantalla (graficamente) la pocion de tipo velocidad.
		 */
		public void aparecerPocionVelocidad() {
			misPociones.get(1).reset();

		}
		
		/**
		 * Aparece por pantalla (graficamente) la fruta.
		 */
		public void aparecerFruta() {
			miFruta.reset();
		}
		
		/**
		 * Aparece por pantalla (graficamente) los pacdots.
		 */
		private void aparecerPacDots() {
			for (Elemento e: misPacDots) {
				e.getMiRepresentacion().crearGrafica(e.getSpawn());
				miJuego.getVentana().aparecerEntidad(e.getMiRepresentacion());
			}
	    }

		/**
		 * Aparece por pantalla (graficamente) los powerpellets.
		 */
	    private void aparecerPowerPellets() {
	    	for (Elemento e: misPowerPellets) {
				e.getMiRepresentacion().crearGrafica(e.getSpawn());
				miJuego.getVentana().aparecerEntidad(e.getMiRepresentacion());
			}
	    }

	    /**
		 * Quita la fruta del juego como resultado del agotamiento del tiempo del cual se dispone, para recogerla. 
		 */
		public void despawnearFruta() {
			miFruta.despawnear();
			miJuego.getGrilla().getBloque(miFruta.getPosicion().getY() / Ventana.pixelesBloque, miFruta.getPosicion().getX() / Ventana.pixelesBloque).agregarAListaRemovidos(miFruta);
			miJuego.getGrilla().getBloque(miFruta.getPosicion().getY() / Ventana.pixelesBloque, miFruta.getPosicion().getX() / Ventana.pixelesBloque).getListaEntidades().removeAll(miJuego.getGrilla().getBloque(miFruta.getPosicion().getY() / Ventana.pixelesBloque, miFruta.getPosicion().getX() / Ventana.pixelesBloque).getListaRemovidos());
			miJuego.getGrilla().getBloque(miFruta.getPosicion().getY() / Ventana.pixelesBloque, miFruta.getPosicion().getX() / Ventana.pixelesBloque).limpiarListaRemovidos();
		}

		/**
		 * Quita la pocion de tipo bomba del juego como resultado del agotamiento del tiempo del cual se dispone, para recogerla. 
		 */
		public void despawnearPocionBomba() {
			misPociones.get(0).despawnear();
			miJuego.getGrilla().getBloque(misPociones.get(0).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(0).getPosicion().getX() / Ventana.pixelesBloque).agregarAListaRemovidos(misPociones.get(0));
			miJuego.getGrilla().getBloque(misPociones.get(0).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(0).getPosicion().getX() / Ventana.pixelesBloque).getListaEntidades().removeAll(miJuego.getGrilla().getBloque(misPociones.get(0).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(0).getPosicion().getX() / Ventana.pixelesBloque).getListaRemovidos());
			miJuego.getGrilla().getBloque(misPociones.get(0).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(0).getPosicion().getX() / Ventana.pixelesBloque).limpiarListaRemovidos();
		}

		/**
		 * Quita la pocion de tipo bomba del juego como resultado del agotamiento del tiempo del cual se dispone, para recogerla. 
		 */
		public void despawnearPocionVelocidad() {
			misPociones.get(1).despawnear();
			miJuego.getGrilla().getBloque(misPociones.get(1).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(1).getPosicion().getX() / Ventana.pixelesBloque).agregarAListaRemovidos(misPociones.get(1));
			miJuego.getGrilla().getBloque(misPociones.get(1).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(1).getPosicion().getX() / Ventana.pixelesBloque).getListaEntidades().removeAll(miJuego.getGrilla().getBloque(misPociones.get(1).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(1).getPosicion().getX() / Ventana.pixelesBloque).getListaRemovidos());
			miJuego.getGrilla().getBloque(misPociones.get(1).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(1).getPosicion().getX() / Ventana.pixelesBloque).limpiarListaRemovidos();
		}	
	
	// ------------------------------------------------------------------------------ RESET-RELATED METHODS ------------------------------------------------------------------
	/**
	 * Para el reinicio de un nivel, restablece las entidades que deben aparecer desde el comienzo del mismo.
	 */
	public void reset() {
		miPersonajePrincipal.reset();
		
		for (Enemigo e: misEnemigos) {
			e.reset();
		}
		
		for (Elemento e: misPacDots) {
			e.reset();
		}
		
		for (Elemento e: misPowerPellets) {
			e.reset();
		}	
	}
	// ------------------------------------------------------------------------------    CONSULTAS   ------------------------------------------------------------------
	
	// ------------------------------------------------------------------------------ ENTITY GETTERS ------------------------------------------------------------------
	
	/**
	 * 
	 * @return Devuelve el personaje principal del juego.
	 */
	public Principal getPrincipal() {
		return miPersonajePrincipal;
	}

	/**
	 * 
	 * @return Devuelve los enemigos del juego.
	 */
	public List<Enemigo> getEnemigos() {
		return misEnemigos;
	}
	
	/**
	 * 
	 * @return Devuelve los pacdots del juego.
	 */
	public List<Elemento> getPacDots() {
		return misPacDots;
	}
	
	/**
	 * 
	 * @return Devuelve los power pellets del juego.
	 */
	public List<Elemento> getPowerPellets() {
		return misPowerPellets;
	}
	
	/**
	 * 
	 * @return Devuelve la fruta del juego.
	 */
	public Elemento getFruta() {
		return miFruta;
	}
}
