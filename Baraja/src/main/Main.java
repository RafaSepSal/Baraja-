package main;

import java.util.ArrayList;
import java.util.Scanner;
import enums.ModoDeJuego;
import models.AbstractGame;
import models.AbstractPlayer;
import models.Baraja;
import models.CPUPlayer;
import models.Carta;
import models.HumanPlayer;
import models.Mesa;
import models.SieteYMedia;

public class Main {
	
	public static void main(String[] args) {
		
		start();
	}

	// / / / / / /START
		public static void start() {
			bienvenida();
		}
		
		// / / / / / / / BIENVENIDA
		public static void bienvenida() {
			System.out.println("�Bienvenido al siete y media!");
			System.out.println();
			System.out.println("Este es un simulador del juego de cartas, que consiste en ir robando cartas");
			System.out.println("de la baraja y vas sumando a tu puntuaci�n el valor espec�fico de cada");
			System.out.println("carta. El objetivo es acercarse lo m�ximo posible a 7 puntos y medio y puedes");
			System.out.println("plantarte cuando quieras pero, ojo, porque nunca puedes pasarte de esa puntuaci�n,");
			System.out.println("sino perder�s.");
			System.out.println();
			int respuesta;
			do {
				System.out.print("Escribe <1> para continuar: ");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner (System.in);
				respuesta = sc.nextInt();
				if (respuesta == 1) {
					menuPrincipal();
				}else {
					System.out.println("Error, escr�belo correctamente.");
				}
			}while(respuesta != 1);
		}
	
		// / / / / / / / MEN�
				public static void menuPrincipal() {
					System.out.println();
					System.out.println();
					System.out.println("Elige <1> para: Jugar una nueva partida (Uno vs CPU): ");
					@SuppressWarnings("resource")
					Scanner sc = new Scanner (System.in);
					int respuesta = sc.nextInt();
					do {
					if (respuesta == 1) {
						SieteYMedia sieteYMedia = new SieteYMedia(new Mesa(), new ArrayList<AbstractPlayer>(), false, ModoDeJuego.UnovsCPU, 1);
						sieteYMedia.unoVsCPU();
					}else {
						System.out.println("Error, escr�belo de nuevo.");
					}
					
					}while (respuesta != 1);
				}
				
				
	
}
