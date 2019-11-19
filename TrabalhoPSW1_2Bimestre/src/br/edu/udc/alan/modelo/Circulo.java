package br.edu.udc.alan.modelo;

import br.edu.udc.alan.modelo.manipulador.ManipuladorCirculo;
import br.edu.udc.alan.modelo.manipulador.ManipuladorFormaGeometrica;
import br.edu.udc.alan.modelo.manipulador.ManipuladorPonto2D;

public class Circulo implements FormaGeometrica {
	double raio, area, perimetro;
	
	@Override
	public Ponto2D centro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double area() {
		area = 3.141516*raio*raio;
        
        return area;
	}

	@Override
	public double perimetro() {
		 perimetro = 2*3.141516*raio;
	        
	        return perimetro;
	}

	@Override
	public double base() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double altura() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ManipuladorFormaGeometrica getManipulador() {
		return new ManipuladorCirculo();
	}

	@Override
	public FormaGeometrica clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
