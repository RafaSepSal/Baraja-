package models;

public abstract class AbstractPlayer {
	Mano mano;
	protected Mesa mesa;
	protected String nombre;
	public int puntos;
	
	public AbstractPlayer(Mesa mesa, String nombre) {
		super();
		this.mano = new Mano();
		this.mesa = mesa;
		this.nombre = nombre;
		this.puntos = 0;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public abstract void jugarTurno(double puntosRival);
}
