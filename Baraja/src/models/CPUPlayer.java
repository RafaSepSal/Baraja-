package models;

public class CPUPlayer extends AbstractPlayer {

	public CPUPlayer(Mesa mesa, String nombre) {
		super(mesa, nombre);
		
	}

	@Override
	public
	void jugarTurno(double puntosRival) {
		System.out.println();
		System.out.println(" - - - - - - - - - - - - - - - - - - - ");
		System.out.println("Turno de la CPU");
		System.out.println(" - - - - - - - - - - - - - - - - - - - ");
		
		do {
			robarCarta();
		}while(this.puntos < puntosRival); {
		System.out.println("  - -  Se ha plantado con: "+this.puntos);
		}
	}
	
	public void robarCarta() {
		Carta c = this.mesa.robarCartaDeBaraja();
		System.out.println("\n  - -  La CPU ha robado la carta: "+ c.getNombreCarta());
		this.puntos += c.getValor7ymedia();
		System.out.println("  - -  Su puntuación actual es: "+this.puntos+" puntos");
		}

}
