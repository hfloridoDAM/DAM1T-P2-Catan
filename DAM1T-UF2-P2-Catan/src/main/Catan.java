package main;

import java.util.Random;
import java.util.Scanner;
import model.Jugador;

public class Catan {
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		Jugador[] jugadores = new Jugador[4];
		inicializarJugadores(jugadores);
		nuevaPartida(jugadores);
	}
	
	private static void nuevaPartida(Jugador[] jugadores) {
		System.out.println("Nueva partida");
		while(true) {
			for (Jugador jugador : jugadores) {
				turnoJugador(jugador);
			}
		}
		
	}

	private static void inicializarJugadores(Jugador[] jugadores) {
		for (int i = 0; i < jugadores.length; i++) {
			System.out.print("Nombre: ");
			jugadores[i] = new Jugador(scanner.next());
			System.out.println();
		}
	}
	
	private static void turnoJugador(Jugador jugador) {
		System.out.println("jugador: " + jugador.getNombre());
		boolean finTurno = false;
		while (!finTurno) {
			System.out.println("1- mostrar cartas \n2- comprar ciudad\n3- tirar dados");
			switch(scanner.nextInt()) {
				case 1:
					mostrarCartas(jugador);
					break;
				case 2:
					comprarCiudad(jugador);
					break;
				case 3:
					tirarDados(jugador);
					finTurno = true;
					break;
				default:
					System.out.println("ERROR");
			}
		}
	}

	private static void tirarDados(Jugador jugador) {
		Random rand = new Random();
		int random = rand.nextInt(11)+2;
		jugador.checkDados(random);
		
	}

	private static void comprarCiudad(Jugador jugador) {
		if(jugador.checkRecursos()) {
			jugador.createCity();
		}
		System.out.println("Faltan recursos");
	}

	private static void mostrarCartas(Jugador jugador) {
		for (String carta : jugador.getCartas()) {
			System.out.print(carta + " ");
		}
		System.out.println();
	}

}
