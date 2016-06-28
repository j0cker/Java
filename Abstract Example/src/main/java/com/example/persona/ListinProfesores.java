package com.example.persona;

import java.util.ArrayList;
import java.util.Iterator;

public class ListinProfesores {
	private ArrayList<Profesor> listinProfesores; // Campo de la clase

	public ListinProfesores() {
		listinProfesores = new ArrayList<Profesor>();
	} // Constructor

	public void addProfesor(Profesor profesor) {
		listinProfesores.add(profesor);
	} // M�todo

	public void imprimirListin() { // M�todo
		String tmpStr1 = ""; // String temporal que usamos como auxiliar
		System.out
				.println("Se procede a mostrar los datos de los profesores existentes en el list�n \n");
		for (Profesor tmp : listinProfesores) {
			System.out.println(tmp.toString());
			if (tmp instanceof ProfesorInterino) {
				tmpStr1 = "Interino";
			} else {
				tmpStr1 = "Titular";
			}
			System.out.println("-Tipo de este profesor:" + tmpStr1
					+ " -N�mina de este profesor: " + (tmp.importeNomina())
					+ "\n");
		}
	} // Cierre m�todo imprimirListin

	public float importeTotalNominaProfesorado() {
		float importeTotal = 0f; // Variable temporal que usamos como auxiliar
		Iterator<Profesor> it = listinProfesores.iterator();
		while (it.hasNext()) {
			importeTotal = importeTotal + it.next().importeNomina();
		}
		return importeTotal;
	} // Cierre del m�todo importeTotalNominaProfesorado
} // Cierre de la clase ejemplo aprenderaprogramar.com
