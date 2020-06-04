/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamica;

/**
 *
 * @author Erick
 */
public class NewClass1 {

    public static void main(String[] args) {
        Cola a = new Cola();
        Lista b = new Lista();
        Pila c = new Pila();
        a.poner('A');
        a.poner('B');
        a.poner('C');
        a.poner('D');
        a.poner('F');
        a.poner('G');
        a.poner('H');
        a.poner('I');
        a.poner('J');

        b = colaToLista(a, 3);
        System.out.println(b.toString());

    }

    public static Lista colaToLista(Cola q, int t) {
        Cola cola = q;
        Pila pila = new Pila();
        Lista lista = new Lista();
        Object elemento;
        int ext = 1, r = 1, x = 0;
        while (!cola.esVacia()) {
            x = x + 2;
            elemento = cola.obtenerFrente();
            lista.insertar(elemento, r);
            lista.insertar(elemento, x);
            pila.apilar(elemento);
            r = r + 1;
            cola.sacar();
            if (ext % t == 0) {
                while (!pila.esVacia()) {
                    x = x + 1;
                    elemento = pila.obtenerTope();
                    lista.insertar(elemento, x);
                    pila.desapilar();
                }
                lista.insertar('$', x + 1);
                lista.insertar('$', x + 1);

                x = x + 2;
                r = x + 1;
            }
            ext++;
        }
        return lista;
    }
    
}
