/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estatica;

/**
 *
 * @author Erick
 */
public class MixLineales {

    public static void main(String[] args) {
        Lista a = new Lista();
        Lista b = new Lista();
        Lista c = new Lista();
        Lista d = new Lista();
        System.out.println("inserto A: " + a.insertar('A', 1));
        System.out.println("inserto B: " + a.insertar('B', 2));
        System.out.println("inserto C: " + a.insertar('C', 3));
        System.out.println("inserto D: " + a.insertar('D', 4));
        System.out.println("inserto *: " + a.insertar('*', 5));
        System.out.println("inserto F: " + a.insertar('F', 6));
        System.out.println("inserto G: " + a.insertar('G', 7));
        System.out.println("inserto H: " + a.insertar('H', 8));
        System.out.println("inserto *: " + a.insertar('*', 9));
        System.out.println("inserto I: " + a.insertar('I', 10));

        System.out.println(generarLista(a).toString());

        System.out.println("inserto A: " + b.insertar('A', 1));
        System.out.println("inserto *: " + b.insertar('*', 2));
        System.out.println("inserto B: " + b.insertar('B', 3));
        System.out.println("inserto *: " + b.insertar('*', 4));
        System.out.println("inserto C: " + b.insertar('C', 5));
        System.out.println("inserto *: " + b.insertar('*', 6));
        System.out.println("inserto D: " + b.insertar('D', 7));
        System.out.println("inserto *: " + b.insertar('*', 8));
        System.out.println("inserto F: " + b.insertar('F', 9));
        System.out.println("inserto G: " + b.insertar('G', 10));
        System.out.println("inserto H: " + b.insertar('H', 11));
        System.out.println("inserto *: " + b.insertar('*', 12));
        System.out.println("inserto *: " + b.insertar('*', 13));
        System.out.println("inserto I: " + b.insertar('I', 14));

        System.out.println(generarLista(b).toString());
        System.out.println("inserto A: " + c.insertar('A', 1));
        System.out.println("inserto B: " + c.insertar('B', 2));
        System.out.println("inserto C: " + c.insertar('C', 3));
        System.out.println("inserto D: " + c.insertar('D', 4));
        System.out.println("inserto *: " + c.insertar('*', 5));
        System.out.println(generarLista(c).toString());

        System.out.println("inserto *: " + d.insertar('*', 1));
        System.out.println("inserto A: " + d.insertar('A', 2));
        System.out.println("inserto B: " + d.insertar('B', 3));
        System.out.println("inserto C: " + d.insertar('C', 4));
        System.out.println("inserto D: " + d.insertar('D', 5));
        System.out.println("inserto *: " + d.insertar('*', 6));
        System.out.println("inserto *: " + d.insertar('*', 7));
        System.out.println(generarLista(d).toString());

    }

    //reentrega de lineales version con dos while interno
    public static Lista generarLista(Lista q) {
        Cola cola = new Cola();
        Pila pila = new Pila();
        Lista lista = new Lista();
        Lista li = q.clone();
        Object elemento;
        int r = 1, l = q.longitud();

        li.insertar('*', l + 1);

        while (!li.esVacia()) {
            if ((li.recuperar(1)).equals('*') && cola.esVacia()) {
                li.eliminar(1);
            } else {
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
                    if ((li.recuperar(1)).equals('*')) {
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
                        lista.insertar('*', r);
                        //asigno a r x+2 (o x+1, aun no se si esta bien) para que r este actualizado al nuevo final despues de la repetitiva
                        r = r + 1;
                    }

                }
            }
        }
        lista.eliminar(r - 1);
        return lista;
    }

}
