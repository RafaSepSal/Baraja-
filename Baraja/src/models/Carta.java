package models;

/**
 * Esta clase representa una carta de una baraja
 * 
 *
 */
public class Carta {
	/**
	 * Número entero que representa el número de la carta.
	 */
	private int numero;
	/**
	 * Número entero que representa el palo de la carta.
	 */
	private int palo;

	/**
	 * Constructor para crear una carta dados su número y su palo
	 * @param numero entero que representa el número de la carta
	 * @param palo entero del 0 al 3 que representa el número del palo.
	 */
	public Carta(int numero, int palo) {
		super();
		this.numero = numero;
		this.palo = palo;
	}

	/**
	 * Constructor que crea una carta a partir de su id [1-40]
	 * @param id de la carta
	 */
	public Carta(int id) {
		super();
		if (id != 10 && id != 20 && id != 30 && id != 40)
			this.numero = id % 10;
		else if (id == 10 || id == 20 || id == 30 || id == 40)
			this.numero = 10;
		else
			throw new IllegalArgumentException("La carta con el ID " + id + " no puede ser creada, Bob!");
		this.palo = (id - 1) / 10;
	}

	
	public int getId() {
		int id = (this.numero) + (this.palo * 10);
		return id;
	}

	public int getNumero() {
		return this.numero;
	}

	public int getPalo() {
		return this.palo;
	}

	public String getNombreNumero() {
		String nombreNumero;
		switch (this.numero) {
		case 1:
			nombreNumero = "As";
			break;
		case 2:
			nombreNumero = "Dos";
			break;
		case 3:
			nombreNumero = "Tres";
			break;
		case 4:
			nombreNumero = "Cuatro";
			break;
		case 5:
			nombreNumero = "Cinco";
			break;
		case 6:
			nombreNumero = "Seis";
			break;
		case 7:
			nombreNumero = "Siete";
			break;
		case 8:
			nombreNumero = "Sota";
			break;
		case 9:
			nombreNumero = "Caballo";
			break;
		case 10:
			nombreNumero = "Rey";
			break;
		default:
			nombreNumero = "No se ha podido reconocer el numero";
			break;
		}
		return nombreNumero;
	}

	public String getNombrePalo() {
		String nombrePalo;
		switch (this.palo) {
		case 0:
			nombrePalo = "Oros";
			break;
		case 1:
			nombrePalo = "Copas";
			break;
		case 2:
			nombrePalo = "Espadas";
			break;
		case 3:
			nombrePalo = "Bastos";
			break;
		default:
			nombrePalo = "No se ha podido reconocer el palo, asegurate de que el número introducido es entre 0 y 3";
			break;
		}
		return nombrePalo;
	}

	public String getNombreCarta() {
		return this.getNombreNumero() + " de " + this.getNombrePalo();
	}

	public int getValorTute() {
		int valorTute;
		if (this.numero == 1)
			valorTute = 11;
		else if (this.numero == 3)
			valorTute = 10;
		else if (this.numero == 8)
			valorTute = 2;
		else if (this.numero == 9)
			valorTute = 3;
		else if (this.numero == 10)
			valorTute = 4;
		else
			valorTute = this.numero;
		return valorTute;
	}

	public int getValorMus() {
		int valorMuse;
		if (this.numero == 1 || this.numero == 2)
			valorMuse = 1;
		else if (this.numero == 3 || this.numero == 8 || this.numero == 9 || this.numero == 10)
			valorMuse = 10;
		else
			valorMuse = this.numero;
		return valorMuse;
	}

	public double getValor7ymedia() {
		int num = 0;
		double valor = 0;
		
		try {
			num = getNumero();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		if (num == 8 || num == 9 || num == 10) {
			valor = 0.5;
		} else {
			valor = num;
		}
		
		return valor;
	}

}
