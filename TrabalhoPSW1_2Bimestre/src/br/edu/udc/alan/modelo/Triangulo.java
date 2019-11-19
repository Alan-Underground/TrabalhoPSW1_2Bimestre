package br.edu.udc.alan.modelo;

import java.awt.Graphics;

import br.edu.udc.alan.modelo.manipulador.ManipuladorFormaGeometrica;
import br.edu.udc.alan.modelo.manipulador.ManipuladorTriangulo;

public class Triangulo implements FormaGeometrica{
	
	protected Ponto2D a;
	protected Ponto2D b;
	protected Ponto2D c;
	
		
	public Triangulo() {
		a = new Ponto2D(0, 0);
		b = new Ponto2D(0, 0);
		c = new Ponto2D(0, 0);
		
	}

	public Triangulo(Ponto2D A, Ponto2D B, Ponto2D C) {
		this.setA(A);
		this.setB(B);
		this.setC(C);
		
	}
	
	public void setA(Ponto2D a) {
		this.a = a;
	}

	
	public Ponto2D getA() {
		return a;
	}

	public void setB(Ponto2D b) {
		this.b = b;
		
	}

	public Ponto2D getB() {
		return b;
	}

	public void setC(Ponto2D c) {
		this.c = c;
		
	}
	
	public Ponto2D getC() {
		return c;
	}
	
	
	@Override
	public Ponto2D centro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double area() {
		return Math.abs(
				((a.getX() - c.getX()) * (b.getY() - c.getY()) - (a.getY() - c.getY()) * (b.getX() - c.getX())) / 2);
	}

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return 0;
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
		return new ManipuladorTriangulo();
	}
	
	public void paint(Graphics g) {
				
		
	}
}
