/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

/**
 *
 * @author Erick
 */

public class Cola{

    private Nodo fin, frente;

    public Cola() {
        fin = null;
        frente = null;
    }

    public boolean poner(Object aux) {
        Nodo nuevo = new Nodo(aux, null);
        if (this.frente == null) {
            this.fin = nuevo;
            this.frente = nuevo;
        } else {
            this.fin.setEnlace(nuevo);
            this.fin = nuevo;
        }
        return true;
    }

    public boolean sacar() {
        boolean exito = true;
        if (frente==null) {
            exito = false;
        } else {
            this.frente = this.frente.getEnlace();

            if (this.frente == null) {
                this.fin = null;
            }

        }

        return exito;

    }

    public boolean esVacia() {
        return this.frente == null;
    }

    public Cola clone() {
        Cola clon = new Cola();
        this.clonarRecursivoPaso(clon, this.frente);
        return clon;
    }

    private void clonarRecursivoPaso(Cola colaClon, Nodo actual) {

        if (actual != null) {
            Nodo nuevo = new Nodo(actual.getElemento(), null);
            colaClon.fin.setEnlace(nuevo);
            this.fin = nuevo;
            clonarRecursivoPaso(colaClon, actual.getEnlace());

        }

    }

    public String toString() {
        String contenido = "Cola vacia";

        if (!this.esVacia()) {
            contenido = "";
            //recorremos los enlaces de forma recursiva
            contenido = "["+toStringRecursivoPaso(this.frente)+"]";
        }
        return contenido;
    }

    private String toStringRecursivoPaso(Nodo actual) {
        String contenido = "";
        if (actual != null) {
            contenido = actual.getElemento() + " " + toStringRecursivoPaso(actual.getEnlace());
        }
        return contenido;
    }

    public Object obtenerFrente() {
        Object resultado=null ;
        if (frente!=null) {
            resultado=this.frente.getElemento();
        }
        return resultado ;
    }

    public void vaciar() {
        this.fin = null;
        this.frente = null;
    }
}
