package entidadesLogicas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dominios.DominioJuego;
import elementos.Elemento;
import elementos.PacDot;
import elementos.PowerPellet;
import gui.Ventana;
import personajes.Enemigo;
import personajes.Principal;
import productos.FabricaEntidades;
import productos.FabricaGeneral;

public class EntidadesJuego {
	
	private Juego miJuego;
	private DominioJuego miDominio;
	private FabricaEntidades miFabricaEntidades;
	private List<Enemigo>  misEnemigos;
	private Principal miPersonajePrincipal;	
	private List<Elemento> misPociones, misPacDots, misPowerPellets;
	private Elemento miFruta;
	
	public EntidadesJuego(Juego juego, DominioJuego dominio) {
		miJuego = juego;
		miDominio = dominio;
	}
	
	public void crearEntidades() {
		miFabricaEntidades = new FabricaGeneral(miJuego, miDominio);
		crearPersonajePrincipal();
		crearEnemigos();
		crearPociones();
		crearPacDots();
		crearPowerPellets();
		crearFrutas();
	}	

	public void crearPersonajePrincipal() {
		miPersonajePrincipal = miFabricaEntidades.getPrincipal();
	}
	
	private void crearEnemigos() {
		misEnemigos = Collections.synchronizedList(new ArrayList<Enemigo>());
		misEnemigos.add(miFabricaEntidades.getBlinky());
		misEnemigos.add(miFabricaEntidades.getInky());
		misEnemigos.add(miFabricaEntidades.getPinky());
		misEnemigos.add(miFabricaEntidades.getClyde());
	}
	
	private void crearPociones() {
		misPociones = Collections.synchronizedList(new ArrayList<Elemento>());
		misPociones.add(0, miFabricaEntidades.getPocionBomba());
		misPociones.add(1, miFabricaEntidades.getPocionVelocidad());
	}
	
	private void crearPacDots() {
		misPacDots = Collections.synchronizedList(new ArrayList<Elemento>());
		Elemento actual;
		
		for (Posicion p: PacDot.getMisSpawns()) {
			actual = miFabricaEntidades.getPacDot();
			actual.setSpawneo(p);
			misPacDots.add(actual);
		}
	}
	
	private void crearPowerPellets() {
		misPowerPellets = Collections.synchronizedList(new ArrayList<Elemento>());
		Elemento actual;
		
		for (Posicion p: PowerPellet.getMisSpawns()) {
			actual = miFabricaEntidades.getPowerPellet();
			actual.setSpawneo(p);
			misPowerPellets.add(actual);
		}
		
	}
	
	private void crearFrutas() {
		miFruta = miFabricaEntidades.getFruta();
	}
	
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
		
		miFruta.reset();
		
		for (Elemento e: misPociones) {
			e.reset();
		}
		
	}

	public Principal getPrincipal() {
		return miPersonajePrincipal;
	}

	public List<Enemigo> getEnemigos() {
		return misEnemigos;
	}
	
	public List<Elemento> getPacDots() {
		return misPacDots;
	}
	
	public List<Elemento> getPowerPellets() {
		return misPowerPellets;
	}
	
	public void cambiarSentidoPrincipal(int sentidoMovimiento) {
		if (!miJuego.isGameOver() && !miJuego.estaPausado()) {
    		if (miPersonajePrincipal.getSentidoActual() == Entidad.sentidoFijo) {
    			miPersonajePrincipal.setSentidoActual(sentidoMovimiento);
    		}
    		else {
    			miPersonajePrincipal.setSentidoSiguiente(sentidoMovimiento);
    		}
    	}
	}

	public void aparecerEntidadesGenerales() {
		aparecerPrinicpal();
		aparecerEnemigos();
		aparecerPacDots();
		aparecerPowerPellets();
	}
	
    private void aparecerPrinicpal() {
		miJuego.getVentana().aparecerEntidad(miPersonajePrincipal.getMiRepresentacion());
	}
    
    private void aparecerEnemigos() {
		for(Enemigo fantasma: misEnemigos) {
			miJuego.getVentana().aparecerEntidad(fantasma.getMiRepresentacion());
		}
	}
	
	public void aparecerPocionBomba() {
		miJuego.getVentana().aparecerEntidad(misPociones.get(0).getMiRepresentacion());
	}
	
	public void aparecerPocionVelocidad() {
		miJuego.getVentana().aparecerEntidad(misPociones.get(1).getMiRepresentacion());
	}
	
	public void aparecerFruta() {
		miJuego.getVentana().aparecerEntidad(miFruta.getMiRepresentacion());
	}
	
	private void aparecerPacDots() {
		for (Elemento e: misPacDots) {
			e.getMiRepresentacion().aparecer(e.getSpawn());
			miJuego.getVentana().aparecerEntidad(e.getMiRepresentacion());
		}
    }

    private void aparecerPowerPellets() {
    	for (Elemento e: misPowerPellets) {
			e.getMiRepresentacion().aparecer(e.getSpawn());
			miJuego.getVentana().aparecerEntidad(e.getMiRepresentacion());
		}
    }

	public void despawnearFruta() {
		miFruta.despawnear();
		miJuego.getGrilla().getBloque(miFruta.getPosicion().getY() / Ventana.pixelesBloque, miFruta.getPosicion().getX() / Ventana.pixelesBloque).agregarAListaRemovidos(miFruta);
		miJuego.getGrilla().getBloque(miFruta.getPosicion().getY() / Ventana.pixelesBloque, miFruta.getPosicion().getX() / Ventana.pixelesBloque).getListaEntidades().removeAll(miJuego.getGrilla().getBloque(miFruta.getPosicion().getY() / Ventana.pixelesBloque, miFruta.getPosicion().getX() / Ventana.pixelesBloque).getListaRemovidos());
		miJuego.getGrilla().getBloque(miFruta.getPosicion().getY() / Ventana.pixelesBloque, miFruta.getPosicion().getX() / Ventana.pixelesBloque).limpiarListaRemovidos();
	}

	public void despawnearPocionBomba() {
		misPociones.get(0).despawnear();
		miJuego.getGrilla().getBloque(misPociones.get(0).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(0).getPosicion().getX() / Ventana.pixelesBloque).agregarAListaRemovidos(misPociones.get(0));
		miJuego.getGrilla().getBloque(misPociones.get(0).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(0).getPosicion().getX() / Ventana.pixelesBloque).getListaEntidades().removeAll(miJuego.getGrilla().getBloque(misPociones.get(0).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(0).getPosicion().getX() / Ventana.pixelesBloque).getListaRemovidos());
		miJuego.getGrilla().getBloque(misPociones.get(0).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(0).getPosicion().getX() / Ventana.pixelesBloque).limpiarListaRemovidos();
	}

	public void despawnearPocionVelocidad() {
		misPociones.get(1).despawnear();
		miJuego.getGrilla().getBloque(misPociones.get(1).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(1).getPosicion().getX() / Ventana.pixelesBloque).agregarAListaRemovidos(misPociones.get(1));
		miJuego.getGrilla().getBloque(misPociones.get(1).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(1).getPosicion().getX() / Ventana.pixelesBloque).getListaEntidades().removeAll(miJuego.getGrilla().getBloque(misPociones.get(1).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(1).getPosicion().getX() / Ventana.pixelesBloque).getListaRemovidos());
		miJuego.getGrilla().getBloque(misPociones.get(1).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(1).getPosicion().getX() / Ventana.pixelesBloque).limpiarListaRemovidos();
	}
	
}
