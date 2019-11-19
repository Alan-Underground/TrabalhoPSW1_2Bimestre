package br.edu.udc.alan.colecao;

public interface Iterador<T> {
	
	T getObjeto();
	T proximo();
	T anterior();

}
