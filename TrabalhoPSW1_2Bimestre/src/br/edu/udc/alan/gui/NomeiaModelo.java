package br.edu.udc.alan.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import br.edu.udc.alan.gui.Painel;
import br.edu.udc.alan.modelo.Modelo;

// Classe criada para nomear os modelos no arquivo

public class NomeiaModelo {
	
	private JButton btnPonto2D;
	private JButton btnLinha;
	private JButton btnRetangulo;
	private JButton btnTriangulo;
	private JButton btnPoligono;
	
	public NomeiaModelo(Painel painel) {
		
		btnPonto2D = new JButton("Ponto2D");
		btnPonto2D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Modelo m = Modelo.novoModelo(Modelo.PONTO);
			}
		});		

		btnLinha = new JButton("Linha");
		btnLinha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modelo m = Modelo.novoModelo(Modelo.LINHA);
			}
		});
		

		btnRetangulo = new JButton("Retangulo");
		btnRetangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modelo m = Modelo.novoModelo(Modelo.RETANGULO);
			}
		});
		

		btnTriangulo = new JButton("Triangulo");
		btnTriangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modelo m = Modelo.novoModelo(Modelo.TRIANGULO);
			}
		});
	
		btnPoligono = new JButton("Poligono");
		btnPoligono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modelo m = Modelo.novoModelo(Modelo.POLIGONO);
				
			}
		});
		
		
	}
}
