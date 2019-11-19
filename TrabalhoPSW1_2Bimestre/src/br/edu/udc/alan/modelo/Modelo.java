package br.edu.udc.alan.modelo;

public class Modelo {
    public static Class<?> PONTO = Ponto2D.class;
    public static Class<?> LINHA = Linha.class;
    public static Class<?> TRIANGULO = Triangulo.class;
    public static Class<?> RETANGULO = Retangulo.class;
    public static Class<?> POLIGONO = Poligono.class;
   

   public static Modelo novoModelo(Class<?> modeloClass) {
    	if(modeloClass.asSubclass(Modelo.class) == null)
    		throw new IllegalArgumentException("Classe desconhecida: " + modeloClass.getSimpleName());
    	
        try {
            Modelo modelo = (Modelo) modeloClass.newInstance();
            return modelo;
        }
        catch (Exception ex) {
            throw new RuntimeException("Nao pode instanciar o Modelo: " + modeloClass, ex);
        }
    }

}