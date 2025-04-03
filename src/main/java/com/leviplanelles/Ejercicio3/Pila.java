package com.leviplanelles.Ejercicio3;

import java.util.ArrayList;

public class Pila<T> implements IPila {
    private static final float GROW_FACTOR = 2f;
    private int size;
    private  ArrayList<T> data;


    public Pila() {
        data = new ArrayList<>();
        this.size = 0;
    }
    /**
     * Constructor para poder hacer la copia con un tamaño
     * @param size Es el tamaño de la Pila generica
     */
    public Pila(int size) {
        data = new ArrayList<>();
        this.size = size;
    }


    /**
     * Añade un elemento a la cima de la pila
     * @param e Elemento a añadir
     */
     @Override
     public Object push(Object e) {
        data.add((T) e);
        size++;
        return e;
     }

    /**
     * Determina si la pila está vacía
     * @return true si está vacía, false en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Obtiene el valor (sin extraer) del elemento que ocupa la cima de la pila
     * @return El elemento de la cima o Double.NEGATIVE_INFINITY si la pila está vacía
     */
    @Override
    public T top() {
        T e = null;
        if (!isEmpty()) {
            e = data.get(size - 1);
        }
        return e;
    }


    /**
     * Devuelve el número de elementos que hay en la pila
     * @return Número de elementos de la pila
     */
    @Override
    public int size() {
        return size;
    }


    /**
     * Extrae el elemento que ocupa la cima de la pila
     * @return El elemento de la cima
     */
    @Override
    public T pop() {
        T e = null;
        if (!isEmpty()) {
            e = data.remove(size - 1);
            size--;
        }
        return e;
    }


    /**
     * Expande el tamaño de la pila con el factor de crecimiento indicado por GROW_FACTOR
     */
    // Lo dejo comentado porque el ArrayList se expande de forma automatica, asi es que este metodo ya no sirve la verdad
    /*
    private void expand() {
        T[] aux = (T[]) new Object[Math.round(data.length * GROW_FACTOR)];
        for (int i = 0; i < data.length; i++) {
            aux[i] = data[i];
        }
        data = aux;
    }
    */


    /**
     * Determina si la pila está llena
     * Método de uso interno y por tanto privado ya que desde el punto de vista del
     * programador que utilice esta clase no tiene sentido, ya que la pila es dinámica,
     * es decir, crece automáticamente.
     * @return true si el array ha alcanzado su capacidad máxima o false en caso contrario
     */
    private boolean isFull() {
        return size == data.size();
    }


    public void clear(){
        size=0;
    }

    public Pila<T> clone(){
        Pila<T> copia = new Pila<>(data.size());
        copia.data = new ArrayList<>(data);
        copia.size = this.size;
        return copia;
    }

    public T[] peek(int n){
        if (n > size){
            return null;
        }
        T[] resultado = (T[]) new Object[n];
        for (int i = 0; i < n ; i++) {
            resultado[i] = data.get(size - n + i);
        }
        return resultado;
    }


    public int search(T element){
        if (isEmpty()){
            return -1;
        }
        for (int i = size-1; i >= 0 ; i--) {
            if (data.get(i).equals(element)){
                return size-i-1;
            }
        }
        return -1;
    }

    public void reverse(){
        ArrayList<T> aux = new ArrayList<>(size);
        for (int i = size-1; i >= 0 ; i--) {
            aux.add(data.get(i));
        }
        data = aux;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(data.get(i)).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }
}
