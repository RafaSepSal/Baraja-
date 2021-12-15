package models;

import java.util.ArrayList;
import java.util.Scanner;
import enums.ModoDeJuego;

public class SieteYMedia extends AbstractGame {

	// / / / / / / / / CONSTRUCTOR
	public SieteYMedia(Mesa mesa, ArrayList<AbstractPlayer> jugadores, boolean finished, ModoDeJuego modo, int ronda) {
		super(mesa, jugadores, finished, modo, ronda);
		
	}

	// / / / / / / / / MÉTODOS
	 public void unoVsCPU() {		
		Baraja baraja = new Baraja(1, true);
		setModoUnoVsCPU();
		
		this.jugadores.add(crearCPU());
		this.jugadores.add(crearJugador());
		AbstractPlayer cpu = this.jugadores.get(0);
		AbstractPlayer hm = this.jugadores.get(1);
		cpu.puntos = 0;
		hm.puntos = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		boolean terminar = false;
		do {
			if (hm.puntos < 7.5) {
				System.out.println("¿Qué desea hacer?   Su puntuación actual es: " + hm.puntos
						+ "\n1. Coger Carta\t2. Plantarse");
				int elegir = Integer.parseInt(sc.nextLine());
				switch (elegir) {
				case 1:
					Carta aux = new Carta(baraja.robar().getId());
					System.out.println("Has sacado el " + aux.getNombreCarta());
					hm.puntos += aux.getValor7ymedia();
					break;
				case 2:
					System.out.println("Se ha plantado con " + hm.puntos + " puntos");
					terminar = true;
					break;
				default:
					System.out.println("No se ha reconocido la opción");
					break;
				}
			} else {
				System.out.println("Se ha pasado");
				terminar = true;
			}
			
		}while (!terminar);
			
			do {
			
			if(hm.puntos <= 7.5) { 
				cpu.jugarTurno(hm.puntos);
				if(cpu.puntos <= 7.5) {
					if(hm.puntos > cpu.puntos) {
						winner();
					} else {
						loser();
					}
				} else {
					winner();
				}
				
				if(hm.puntos == cpu.puntos) {
					empate();
				}
				
			} else {
				loser();
			}
			
		} while (!terminar);
		sc.close();
	}
	
	public void setModoUnoVsCPU() {
		this.modo = ModoDeJuego.UnovsCPU;
	}
	
	public AbstractPlayer crearCPU() {
		AbstractPlayer cpu = new CPUPlayer(this.mesa, "CPU");
		return cpu;
	}
	
	public AbstractPlayer crearJugador() {
		System.out.println(" - - - - - - - - - - - - - - - - - - - - ");
		System.out.println("           Has seleccionado " + this.modo);
		System.out.println("           Indica tu nombre.           ");
		System.out.print(" Nombre: ");
		Scanner sc = new Scanner (System.in);
		String nombre = sc.next();
		
		AbstractPlayer j1 = new HumanPlayer(this.mesa, nombre);
		return j1;
		
	}
	
	public static void winner() {
		System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.println("     ¡Felicidades, has ganado!");
		System.out.println("     :D ");
		System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - ");
	}
	
	public static void loser() {
		System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.println("      ¡Has perdido! ");
		System.out.println("      La próxima será :( ");
		System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - ");
	}
	
	public static void empate() {
		System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.println("    ¡Hubo un empate! ");
		System.out.println();
		System.out.println("    Vuelve a intentarlo y trata de ganar a la próxima");
		System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
	}

	@Override
	void bienvenida() {
		
	}

	@Override
	AbstractPlayer nextTurno() {
		return null;
	}
	
}
