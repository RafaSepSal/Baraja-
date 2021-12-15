package models;
import java.util.ArrayList;
import java.util.Scanner;

import enums.ModoDeJuego;
import main.Main;

public abstract class AbstractGame {
	protected Mesa mesa;
	protected ArrayList<AbstractPlayer> jugadores; 
	protected boolean finished;
	protected ModoDeJuego modo;
	protected int ronda;
	
	public AbstractGame(Mesa mesa, ArrayList<AbstractPlayer> jugadores, boolean finished, ModoDeJuego modo, int ronda) {
		super();
		this.mesa = mesa;
		this.jugadores = jugadores;
		this.finished = false;
		this.modo = modo;
		this.ronda = 1;
	}
	 
	
	// / / / / / / / / / / / MÉTODOS
	abstract void bienvenida();
	
	
	// / / / / / / / TURNOS
	abstract AbstractPlayer nextTurno();
	
	
	
	
	// / / / / / /START
	public void start() {
		bienvenida();
	}
	
	// / / / / / /BARAJAR
	public void barajar() {
		this.mesa.baraja.barajar();
	}
	
	// / / / / / / TERMINAR
	public void finish() {
		for(int i=0; i < this.jugadores.size(); i++) {
			(this.jugadores.get(i)).mano.borrarMano();
		}
	}
	
	
	
}
