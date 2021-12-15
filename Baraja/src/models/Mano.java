package models;

import java.util.List;
import java.util.Scanner;

public class Mano extends Baraja {

	// / / / / / / / / / / CONSTRUCTORES
		public Mano() {
			super();
		}

		public Mano(int tipobaraja) {
			this();
			if (tipobaraja == 1 || tipobaraja == 2) {
				for (int i = 1; i < (40 * tipobaraja) + 1; i++) {
					if (i < 41)
						this.lista_cartas.add(new Carta(i));
					else
						this.lista_cartas.add(new Carta(i - 40));
				}
			}
		}
		
		// / / / / / / / / / / / MÉTODOS
		public void listarCartas() {
			int i=0;
			for (Carta c : this.lista_cartas) {
				System.out.print(i + " >> " + c.getNombreCarta());
				i++;
			}
		}
		
		public Carta elegirCarta() {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			listarCartas();
			System.out.println("¿Qué carta quieres?");
			int i = sc.nextInt();
			
			return this.lista_cartas.get(i);
		}
		
		public void addCarta(Carta c) {
			this.lista_cartas.add(c);
		}
		
		public void addVariasCartas(List<Carta> lista) {
			for (int i = 0; i < lista.size(); i++) {
				Carta c = lista.get(i);
				this.lista_cartas.add(c);
			}
		}
		
		public void borrarMano() {
			this.lista_cartas.clear();
		}
		
}
