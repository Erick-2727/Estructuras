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
        Lista a = new Lista();
        Lista b = new Lista();
        
        a.insertar('a',1);
        a.insertar('b',2);
        a.insertar('c',3);
        a.insertar('d',4);
        a.insertar('*',5);
        a.insertar('f',6);
        a.insertar('g',7);
        a.insertar('h',8);
        a.insertar('*',9);
        a.insertar('i',10);
        
        b = generarLista2(a);
        System.out.println(b.toString());

    }
    //primer parcial
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
            ext++;
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
            
        }
        return lista;
    }
    //reentrega de lineales version con un solo while interno
    public static Lista generarLista(Lista q) {
        Cola cola = new Cola();
        Pila pila = new Pila();
        Lista lista = new Lista();
        Lista li=q.clone();
        Object elemento;
        int r = 1,x,l=q.longitud();
        li.insertar('*', l+1);
        while (!li.esVacia()) {
            //recupero el primer elemento de la lista y lo inserto en las 3 estructuras
            elemento = li.recuperar(1);
            lista.insertar(elemento, r);
            pila.apilar(elemento);
            cola.poner(elemento);
            //r es el contador de la pos actual del ultimo elemento de la lista a devolver
            r = r + 1;
            //elimino el primer elemento de la lista
            li.eliminar(1);
            //pregunto si el primer elemento de la lista es '*'
            if ( !li.esVacia()) {
                if (( li.recuperar(1)).equals('*')) {
                    x = r + 1;
                    li.eliminar(1);
                    while (!cola.esVacia()|| !pila.esVacia() ) {
                        elemento = pila.obtenerTope();
                        lista.insertar(elemento, r);
                        elemento = cola.obtenerFrente();
                        lista.insertar(elemento, x);
                        //saco de cola el primer elemento y de pila el ultimo
                        cola.sacar();
                        pila.desapilar();
                        //aumento r en 1 para seguir insertando
                        r = r + 1;
                        //aumento x en 2 para que siempre inserte al final
                        x = x + 2;
                    }
                    //asigno a r x para que r este actualizado al nuevo final despues de la repetitiva
                   lista.insertar('*', x-1);
                    r = x;
                }
               
            }
        }
        lista.eliminar(r-1);
        return lista;
    }
    //reentrega de lineales version con dos while interno
    public static Lista generarLista2(Lista q) {
        Cola cola = new Cola();
        Pila pila = new Pila();
        Lista lista = new Lista();
        Lista li=q.clone();
        Object elemento;
        int r = 1,l=q.longitud();
        
        li.insertar('*', l+1);
        
        while (!li.esVacia()) {
            //recupero el primer elemento de la lista y lo inserto en las 3 estructuras
            elemento = li.recuperar(1);
            lista.insertar(elemento, r);
            pila.apilar(elemento);
            cola.poner(elemento);
            //r es el contador de la pos actual del ultimo elemento de la lista a devolver
            r = r + 1;
            //elimino el primer elemento de la lista
            li.eliminar(1);
            //pregunto si el primer elemento de la lista es '*'
            if (!li.esVacia()) {
                if (( li.recuperar(1)).equals('*')) {
                    li.eliminar(1);
                    while (!pila.esVacia()) {
                        elemento = pila.obtenerTope();
                        lista.insertar(elemento, r);
                        //saco de  pila el ultimo
                        pila.desapilar();
                        //aumento r en 1 para seguir insertando
                        r = r + 1;
                    }
                    while (!cola.esVacia()) {
                        elemento = cola.obtenerFrente();
                        lista.insertar(elemento, r);
                        //saco de cola el primer elemento y de pila el ultimo
                        cola.sacar();
                        //aumento r en 1 para seguir insertando
                        r = r + 1;
                    }
                    //esta parte  aun no se si es nesecesario
                    lista.insertar('*', r );
                    //asigno a r x+2 (o x+1, aun no se si esta bien) para que r este actualizado al nuevo final despues de la repetitiva
                    r = r + 1;
                }
               
            }
        }
        lista.eliminar(r-1);
        return lista;
    }
    
}
