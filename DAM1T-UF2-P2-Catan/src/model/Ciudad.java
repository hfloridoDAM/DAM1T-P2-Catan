package model;

import java.util.Scanner;

public class Ciudad {
	private String recurso;
	private int numero;
	private Scanner scanner;

	public Ciudad(String recurso, int numero) {
		this.scanner = new Scanner(System.in);
		this.recurso = recurso;
		this.numero = numero;
	}
	
	public Ciudad() {
		this.scanner = new Scanner(System.in);
		this.recurso = generarRecurso();
		this.numero = generarNumero();
	}

	private int generarNumero() {
		System.out.println("dame un num del 2 al 12");
		return this.scanner.nextInt();
	}

	private String generarRecurso() {
		System.out.println("Madera o piedra?");
		return this.scanner.next();
	}

	public String getRecursos() {
		return this.recurso;
	}
	
	public int getNumero() {
		return this.numero;
	}

}
