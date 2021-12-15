package models;

import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer {

	public HumanPlayer(Mesa mesa, String nombre) {
		super(mesa, nombre);
		
	}

	@Override
	public
	void jugarTurno(double puntosRival) {
		boolean finished = false;
		String resp = "";
		System.out.println(" - - - - - - - - - - - - - - - - - - - - ");
		System.out.println();
		System.out.println("Es tu turno, " + this.nombre.toUpperCase());
		System.out.println();
		System.out.println(" - - - - - - - - - - - - - - - - - - - - ");

		do {
			System.out.println(" - - - - - - - - - - - - - - - - - - - - ");
			System.out.println("1 - Robar Carta | 2 - Plantarse");
			System.out.println(" - - - - - - - - - - - - - - - - - - - - ");
			
			do {
				System.out.print("Respuesta: ");
				Scanner sc = new Scanner (System.in);
				resp = sc.next();
				
				if (resp.equals("2") && this.puntos == 0) {
					System.out.println(" - - - - - - - - - - - - - - - - - - - - ");
					System.out.println("No puedes plantarte, todavía no has robado ninguna carta.");
					System.out.println(" - - - - - - - - - - - - - - - - - - - - ");
				}
			
			} while(resp.equals("2") && this.puntos == 0);
			
			switch(resp) {
			
			case "1":
				robarCarta();
				break;
				
			case "2":
				finished = true;
				System.out.println(" Te has plantado con: " + this.puntos + " puntos.");
				break;
				
			default:
				System.out.println(" - - - - - - - - - - - - - - - - - - - - ");
				System.out.println("Valor introducido incorrecto, vuelve a intentarlo.");
				System.out.println(" - - - - - - - - - - - - - - - - - - - - ");
			}
			
			if(this.puntos >= 7.5) {
				finished = true;
				System.out.println("¡Felicidades, has conseguido exactamente " + this.puntos + " puntos!");

			}
			
		} while (!finished);
	}
	
	public void robarCarta() {
		Carta c = this.mesa.robarCartaDeBaraja();
		System.out.println(" Has robado la carta: " + c.getNombreCarta());
		this.puntos += c.getValor7ymedia();
		System.out.println(" Tu puntuación actual es: " + this.puntos + " puntos.");
	}

}
