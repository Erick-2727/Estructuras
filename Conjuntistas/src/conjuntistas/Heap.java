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
public class Heap {

    private static final int tam = 20;
    private Comparable heap[];
    private int ultimo;

    public Heap() {
        this.heap = new Comparable[tam];
        ultimo = 0;
    }

    public boolean insertar(Comparable n) {
        boolean resultado = false;
        if (ultimo + 1 < tam - 1) {
            //verifica que el arreglo no este lleno
            heap[ultimo + 1] = n;
            ultimo = ultimo + 1;
            resultado = true;
            if (ultimo != 1) {
                subir();
            }
        }
        return resultado;
    }

    private void subir() {
        Comparable temp;
        boolean res = true;
        int aux = ultimo;
        while (res) {
            //verifica que no se este en la raiz, y compara al padre con el hiji, si el hijo es menor los intercambia
            if (aux != 1 && heap[aux].compareTo(heap[aux / 2]) < 0) {
                temp = heap[aux];
                heap[aux] = heap[aux / 2];
                heap[aux / 2] = temp;
                aux = aux / 2;
            } else {
                //si el hijo no es menor o se lleo a la raiz frena
                res = false;
            }
        }
    }

    public boolean eliminarCima() {
        boolean exito;
        if (this.ultimo == 0) {
            exito = false;
        } else {
            //Poner en la raíz el valor de la hoja más a la derecha del último nivel y eliminar dicha hoja.
            heap[1] = heap[ultimo];
            heap[ultimo] = null;
            ultimo = ultimo - 1;
            hacerBajar();
            exito = true;
        }
        return exito;
    }

    private void hacerBajar() {
        Comparable temp;
        boolean res = true;
        int posP = 1, posH;
        while (res) {
            posH = posP * 2;
            //Verifica que la posicion del padre sea menor a ultimo y que el hijo izquierdo sea diferente de null
            if (posP <= ultimo && heap[posH] != null) {
                //verifica que el hijo derecho sea diferente de null
                if (heap[posH + 1] != null) {
                    //compara hijoD con hijoI, si hijo derecho es menor, cambia posH a posH+1
                    if (heap[posH + 1].compareTo(heap[posH]) < 0) {
                        posH = posH + 1;
                    }
                }
                //compara al padre con el hijo menor, si padre es mayor intercambia lugares
                if (heap[posH].compareTo(heap[posP]) < 0) {
                    temp = heap[posH];
                    heap[posH] = heap[posP];
                    heap[posP] = temp;
                    posP = posH;
                } else {
                    //si el hijo no es menor termina el bucle
                    res = false;
                }
            } else {
                //si posP no es menor a ultimo o si el hijo izquierdo de posP es null termina el bucle
                res = false;
            }
        }
    }

    public boolean esVacio() {
        return (ultimo == 0);
    }

    public void vaciar() {
        for (int i = 1; i <= ultimo; i++) {
            heap[i] = null;
        }
        ultimo = 0;
    }

    public Heap clone() {
        Heap clon = new Heap();
        clon.heap = this.heap.clone();
        clon.ultimo = this.ultimo;
        return clon;
    }

    public Comparable recuperarCima() {
        return this.heap[1];
    }

    public String toString() {
        String res = "";
        if (!esVacio()) {
            for (int i = 1; i <= ultimo; i++) {
                res += "\n" + heap[i] + "\t";
                if (i * 2 <= ultimo) {
                    res += "HI: " + ((heap[i * 2] != null) ? heap[i * 2] : "-") + "\t"
                            + "HD: " + ((heap[(i * 2) + 1] != null) ? heap[(i * 2) + 1] : "-");
                } else {
                    res += "HI: - \t HD:-";
                }
            }
        } else {
            res = "Arbol vacio";
        }
        return res;
    }
}
