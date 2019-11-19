package br.edu.udc.alan.gui;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import br.edu.udc.alan.colecao.Iterador;
import br.edu.udc.alan.colecao.ListaEncadeada;
import br.edu.udc.alan.modelo.Circulo;
import br.edu.udc.alan.modelo.FormaGeometrica;
import br.edu.udc.alan.modelo.Linha;
import br.edu.udc.alan.modelo.Retangulo;
import br.edu.udc.alan.modelo.Triangulo;
import br.edu.udc.alan.modelo.Ponto2D;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Janela extends JFrame {
	private static final long serialVersionUID = 1L;
	private Painel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Janela() {
		setTitle("Janela de desenho");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new Painel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFiguras = new JMenu("Figuras");
		menuBar.add(mnFiguras);
		
		JMenuItem mntmPonto = new JMenuItem("Ponto");
		mntmPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ponto2D ponto = new Ponto2D();
				
				contentPane.setFormaGeometrica(ponto);
			}
		});
		mnFiguras.add(mntmPonto);
		
		JMenuItem mntmLinha = new JMenuItem("Linha");
		mntmLinha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Linha linha = new Linha();
				
				contentPane.setFormaGeometrica(linha);
			}
		});
		mnFiguras.add(mntmLinha);
		
		JMenuItem mntmRetangulo = new JMenuItem("Retangulo");
		mntmRetangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Retangulo retangulo = new Retangulo();
				contentPane.setFormaGeometrica(retangulo);
			}
		});
		mnFiguras.add(mntmRetangulo);
		
		JMenuItem mntmCirculo = new JMenuItem("Circulo");
		mntmRetangulo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Circulo circulo = new Circulo();
			contentPane.setFormaGeometrica(circulo);
		}
	});
		mnFiguras.add(mntmCirculo);
		
		JMenuItem mntmTriangulo = new JMenuItem("Triangulo");
		mntmTriangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Triangulo triangulo = new Triangulo();
				contentPane.setFormaGeometrica(triangulo);
			}});
		mnFiguras.add(mntmTriangulo);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.addActionListener(new ActionListener() {
		
			@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int res = fc.showSaveDialog(null);
			if(res==JFileChooser.CANCEL_OPTION)
				return;
			
			File f = fc.getSelectedFile();
			
			if (!f.exists()) {
                try {
					f.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
			
			// Prepara para escrever no arquivo
            FileWriter fw = null;
			try {
				fw = new FileWriter(f.getAbsoluteFile());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            BufferedWriter bw = new BufferedWriter(fw);
            
            // Escreve e fecha arquivo
    		FormaGeometrica formaAux;   
    		Iterador<FormaGeometrica> it = contentPane.getlista().getInicio();
    		
    		formaAux = it.getObjeto();
    		while(formaAux != null) {
    			//formaAux.getManipulador().paint(g);
    			try {
					bw.write(formaAux.toString());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			formaAux = it.proximo();
    		}	

    		
            try {
				bw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}});
		mnArquivo.add(mntmSalvar);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir ");
		mntmAbrir.addActionListener(new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int res = fc.showSaveDialog(null);
			if(res==JFileChooser.CANCEL_OPTION)
				return;
			
		File f = fc.getSelectedFile();
		
		FileReader ler = null;
		try {
			ler = new FileReader(f);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        BufferedReader reader = new BufferedReader(ler);  
        String linha;
        try {
			while( (linha = reader.readLine()) != null ){
			    System.out.println(linha);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		mnArquivo.add(mntmAbrir);
		}});	
}
}		
