package model;

import java.util.Arrays;
import java.util.Random;

public class Jugador {
	private String nombre;
	private String[] cartas;
	private Ciudad[] ciudades;
	private int punto;
	
	public Jugador(String nombre) {
		Random rand = new Random();
		this.nombre = nombre;
		this.cartas = new String[7];
		Arrays.fill(this.cartas, "-");
		this.ciudades = new Ciudad[10];
		this.punto = 0;
		
		this.ciudades[0] = new Ciudad("madera", rand.nextInt(11)+2);
		this.ciudades[1] = new Ciudad("piedra", rand.nextInt(11)+2);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String[] getCartas() {
		return this.cartas;
	}

	public void checkDados(int random) {
		for (Ciudad ciudad : this.ciudades) {
			if (ciudad != null && ciudad.getNumero() == random) {
				generateCard(ciudad.getRecursos());
			}
		}
	}
	
	private boolean generateCard(String recurso) {
		for (int i = 0; i < cartas.length; i++) {
			if (cartas[i].equals("-")) {
				cartas[i] = recurso;
				return true;
			}
		}
		return false;
	}

	public boolean checkRecursos() {
		int madera, piedra;
		madera = piedra = 0;
		for (String carta : this.cartas) {
			if (carta.equalsIgnoreCase("madera")) madera++;
			if (carta.equalsIgnoreCase("piedra")) piedra++;
		}
		if (madera >= 2 && piedra >= 2) return true;
		return false;
	}

	public boolean createCity() {
		for (int i = 0; i < ciudades.length; i++) {
			if (ciudades[i] != null) {
				ciudades[i] = new Ciudad();
				return true;
			}
		}
		return false;
	}
	
}
