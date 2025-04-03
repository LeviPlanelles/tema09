package com.leviplanelles.Ejercicio4;

import java.util.ArrayList;

public class Cola<T> implements ICola{

    private final static float GROW_FACTOR = 2f;
    private ArrayList<T> data;
    private int size;

    public Cola() {
        this.data = new ArrayList<>();
        this.size = 0;
    }

    /**
     * Metodo que añade un valor a la cola
     * @param e Es el objeto que queremos meter a la cola
     * @return Devuelve true si se ha metido en la cola
     */
    @Override
    public boolean add(Object e) {
        data.add((T) e);
        size++;
        return true;
    }

    /**
     * Elimina/Quita el primer valor de la cola (index 0)
     * @return Devuelve el valor que ha quitado
     */
    @Override
    public Object remove() {
        if (isEmpty())
            return null;
        else {
            T e = data.remove(0);
            size--;
            return e;
        }
    }

    /**
     * Metodo para saber el tamaño de la cola
     * @return Devuelve el tamaño de la cola
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * Metodo para ver el primer valor de la cola
     * @return Devuelve el primer valor de la cola
     */
    @Override
    public Object peek() {
        if (isEmpty()){
            return null;
        }
        return data.get(0);
    }

    /**
     * Booleano que indica si la cola esta vacia o no
     * @return Devuelve true si la cola esta vacia y false si tiene contenido
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Metodo que indica si la cola esta llena o no
     * @return Devuelve true si la cola esta llena y false si no
     */
    private boolean isFull(){
        return size== data.size();
    }

    /**
     * Mueve todos los valores del array 1 hacia la izquierda
     */
    private void moveToLeft(){
        for (int i = 0; i < data.size()-1; i++) {
            data.add(data.get(i+1));
        }
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
