package com.leviplanelles.Ejercicio4;

public class Ejercicio4 {
    public static void main(String[] args) {
        Cola cola = new Cola();
        System.out.println("IsEpmty: "+ cola.isEmpty());
        cola.add(1);
        cola.add(2);
        cola.add(4);
        cola.add(2);
        System.out.println("IsEmpry despues de meter: "+ cola.isEmpty());
        System.out.println(cola.toString());
        System.out.println("Size: "+cola.size());
        System.out.println("Peek: "+ cola.peek());
        System.out.println("Remove: "+ cola.remove());
        System.out.println("Size: "+ cola.size());
        System.out.println(cola.toString());
        System.out.println("Peek: "+ cola.peek());
    }
}
