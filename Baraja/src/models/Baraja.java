package models;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
	// Propiedades
	protected ArrayList<Carta> lista_cartas;

	// Constructores
	public Baraja() {
		lista_cartas = new ArrayList<Carta>();
	}

	public Baraja(int tipobaraja) {
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

	public Baraja(int tipobaraja, boolean barajar) {
		this(tipobaraja);
		barajar();
	}

	// Metodos
	public void barajar() {
		/*ArrayList<Carta> aux = new ArrayList<Carta>();
		int con = this.lista_cartas.size();
		while (!this.lista_cartas.isEmpty()) {
			int random = (int) (Math.random() * con);
			aux.add(this.lista_cartas.get(random));
			this.lista_cartas.remove(random);
			con--;
		}
		for (int i = 0; i < aux.size(); i++) {
			this.lista_cartas.add(aux.get(i));
		}*/
		Collections.shuffle(lista_cartas);
	}

	public void cortar(int posicion) {
		ArrayList<Carta> aux = new ArrayList<Carta>();
		for (int i = 0; i < posicion; i++) {
			aux.add(this.lista_cartas.get(0));
			this.lista_cartas.remove(0);
		}
		for (int i = 0; i < posicion; i++) {
			this.lista_cartas.add(aux.get(i));
		}
	}

	public Carta robar() {
		return this.lista_cartas.remove(0);
	}

	public void insertaCartaFinal(int id_carta) {
		int aux = id_carta;
		this.lista_cartas.add(new Carta(aux));
	}

	public void insertaCartaPrincipio(int id_carta) {
		int aux = id_carta;
		this.lista_cartas.add(0, new Carta(aux));
	}

	public void insertaCartaFinal(Carta c) {
		this.lista_cartas.add(c);
	}

	public void insertaCartaPrincipio(Carta c) {
		this.lista_cartas.add(0, c);
	}

	public int getNumeroCartas() {
		return this.lista_cartas.size();
	}

	public boolean isVacia() {		
		return this.lista_cartas.isEmpty();
	}
}
