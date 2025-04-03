package com.leviplanelles.Ejercicio3;

public class Ejercicio3 {
    public static void main(String[] args) {
        Pila pila = new Pila<>();
        System.out.println("IsEpmty: "+ pila.isEmpty());
        pila.push(1);
        pila.push(2);
        pila.push(4);
        pila.push(2);
        System.out.println("IsEmpry despues de meter: "+ pila.isEmpty());
        System.out.println(pila.toString());
        System.out.println("Size: "+pila.size());
        System.out.println("Top: "+ pila.top());
        System.out.println("Pop: "+ pila.pop());
        System.out.println("Size: "+ pila.size());
        System.out.println(pila.toString());
        System.out.println("Top: "+ pila.top());

    }
}
