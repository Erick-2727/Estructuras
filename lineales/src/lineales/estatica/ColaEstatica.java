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
public class ColaEstatica {

    private static final int tamanio = 10;
    private Object array[];
    private int fin, frente;

    public ColaEstatica() {
        this.array = new Object[tamanio];
        fin = 0;
        frente = 0;
    }

    public boolean poner(Object aux) {
        boolean flag = false;
        if ((this.fin + 1) % tamanio != frente) {
            this.array[fin] = aux;
            this.fin = (this.fin + 1) % tamanio;
            flag = true;
        }
        return flag;
    }

    public boolean sacar() {
        boolean flag = false;
        if (this.fin != this.frente) {
            this.array[frente] = null;
            this.frente = (this.frente + 1) % tamanio;
            flag = true;
        }
        return flag;
    }

    public boolean esVacia() {
        return this.fin == this.frente;
    }

    public ColaEstatica clone() {
        ColaEstatica aux = new ColaEstatica();
        int der = this.frente;
        while (this.fin != der) {
            aux.array[der] = this.array[der];
            der = (der + 1) % tamanio;
        }
        aux.fin = this.fin;
        aux.frente = this.frente;
        return aux;
    }

    public String toString() {
        String aux = "Cola vacia";
        if (this.fin != this.frente) {
            aux = "[";
            for (int i = this.frente; i != this.fin; i = (i + 1) % tamanio) {
                aux += this.array[i].toString() + ",";
            }
            aux += "]";
        }
        return aux;

    }

    public Object obtenerFrente() {
        Object aux = null;
        if (this.fin != this.frente) {
            aux = this.array[frente];
        }
        return aux;
    }

    public void vaciar(){
        int i = this.frente;
        while(this.fin != i){
            this.array[i] = null;
            i=(i + 1) % tamanio;
        }
        this.fin = 0;
        this.frente = 0;
    }
}
