/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

/**
 *
 * @author Erick
 */
public class ArbolHeap {

    private static final int tam = 20;
    private Comparable heap[];
    private int ultimo;

    public ArbolHeap() {
        this.heap = new Comparable[tam];
        ultimo = 0;
    }

    public boolean insertar(Comparable n) {
        boolean resultado = false;
        if (ultimo + 1 < tam - 1) {
            heap[ultimo + 1] = n;
            ultimo = ultimo + 1;
            resultado = true;
            if (ultimo != 1) {
                subir();
            }
        }
        return resultado;
    }

    public void subir() {
        Comparable temp;
        boolean res = true;
        int aux = ultimo;
        while (res) {
            if (aux != 1 && heap[aux].compareTo(heap[aux / 2]) < 0) {
                temp = heap[aux];
                heap[aux] = heap[aux / 2];
                heap[aux / 2] = temp;
                aux = aux / 2;
            } else {
                res = false;
            }
        }
    }
    public boolean eliminar() {
        boolean exito;
        if (this.ultimo == 0) {
            exito = false;
        } else {
            heap[1] = heap[ultimo];
            ultimo = ultimo - 1;
            hacerBajar();
            exito = true;
        }
        return exito;
    }
    public void hacerBajar() {
        Comparable temp;
        //Poner en la raíz el valor de la hoja más a la derecha del último nivel y eliminar dicha hoja.
        boolean res = true;
        int posP = 1,posH;
        while (res) {
            posH=posP*2;
            //Verifica que la posicion del padre sea menor a ultimo y que el hijo izquierdo sea diferente de null
            if (posP < ultimo && heap[posH] != null ) {
                //verifica que el hijo derecho sea diferente de null
                if (heap[posH + 1] != null) {
                    //compara hijoD con hijoI, si hijo derecho es menor, cambia posH a posH+1
                    if (heap[posH+1].compareTo(heap[posH]) < 0) {
                        posH = posH+1;
                    }
                } 
                //compara al padre con el hijo menor, si padre es mayor intercambia lugares
                if (heap[posH].compareTo(heap[posP]) < 0) {
                    temp = heap[posH];
                    heap[posH] = heap[posP];
                    heap[posP] = temp;
                    posP =posH;
                }else{
                    //si el hijo no es menor termina el bucle
                res = false;
                }
            } else {
                res = false;
            }
        }
    }

    public void tostring() {
        for (int i = 1; i <= ultimo; i++) {
            System.out.print(heap[i] + ", ");
        }
        System.out.println("");
    }
}
