package com.example.persona;

public class ProfesorTitular extends Profesor {
	// Constructor ejemplo aprenderaprogramar.com
	public ProfesorTitular(String nombre, String apellidos, int edad, String id) {
		super(nombre, apellidos, edad, id);
	}

	public float importeNomina() {
		return 30f * 43.20f;
	} // M�todo abstracto sobreescrito en esta clase
} // Cierre de la clase
