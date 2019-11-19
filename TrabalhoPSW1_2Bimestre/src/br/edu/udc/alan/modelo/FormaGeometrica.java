package br.edu.udc.alan.modelo;

import br.edu.udc.alan.modelo.manipulador.ManipuladorFormaGeometrica;

public interface FormaGeometrica {
	
	public Ponto2D centro();
	public double area();
	public double perimetro();
	public double base();
	public double altura();
	
	public ManipuladorFormaGeometrica getManipulador();
	
	public FormaGeometrica clone();

}
