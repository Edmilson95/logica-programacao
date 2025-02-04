package org.example.estruturadados.base;

import java.lang.reflect.Array;

public class EstruturaEstatica<T> {
    protected T[] elementos;
    protected int tamanho;

    public EstruturaEstatica(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }
    public EstruturaEstatica(int capacidade, Class<T> tipoClasse) {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }
    public EstruturaEstatica(){
        this(10);
    }

    public boolean estaVazia(){
        return this.tamanho == 0;
    }

    public boolean adiciona(T elemento) {
        this.aumentaCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    protected boolean adiciona(int posicao, T elemento){
        if (posicao < 0 && posicao > tamanho){
            throw new IllegalArgumentException("Posicao Inválida.");
        }
        this.aumentaCapacidade();
        //mover todos os elementos
        for (int i = tamanho - 1; i >= posicao; i--){
            elementos[i+1] = elementos[i];
        }
        elementos[posicao] = elemento;
        tamanho++;

        return true;
    }

    private void aumentaCapacidade(){
        if (tamanho == elementos.length){
            T[] elementosNovos =(T[]) new Object[elementos.length * 2];
            for (int i = 0; i < elementos.length; i++){
                elementosNovos[i] = elementos[i];
            }
            elementos = elementosNovos;
        }
    }

    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < this.tamanho - 1; i++) {
            s.append(this.elementos[i]);
            s.append(", ");
        }
        if (this.tamanho > 0) {
            s.append(this.elementos[this.tamanho - 1]);
        }
        s.append("]");

        return s.toString();
    }
}
