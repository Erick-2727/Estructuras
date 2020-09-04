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
public class ArbolBB2 extends ArbolBB {

    private NodoABB raiz;

    public int amplitudArbol(Comparable elem) {
        int pertenece = -1;

        if (this.raiz != null) {
            pertenece = amplitudArbolAux(this.raiz, elem);
        }
        return pertenece;
    }

    private int amplitudArbolAux(NodoABB n, Comparable elemBusc) {
        int min = 0, may = 0, resultado = -1, valorNodo = (int) n.getElemento();
        NodoABB hI = n.getIzquierdo(), hD = n.getDerecho();
        //compara elemNuevo con el elemento del nodo actual,si es igual retorna true. 
        if (n.getElemento().equals(elemBusc)) {
            if (hI == null && hD == null) {
                resultado = 0;
            } else {
                if (hI != null) {
                    min = obtenerMay(hI);
                }
                if (hD != null) {
                    may = obtenerMin(hD);
                }
                if (hD != null && hI != null) {
                    resultado = may - min;
                } else {
                    if (hI == null) {
                        resultado = valorNodo - may;
                    } else {
                        resultado = valorNodo - min;
                    }
                }
            }
        } else {
            if (n.getElemento().compareTo(elemBusc) > 0) {
                //si es menor y tiene hijo izquierdo null, retorna false ya quese llego a una hoja y no se encontro.
                if (hI != null) {
                    //si el hijo izquierdo es diferente de null, llama al metodo con el hijo izquierdo.
                    resultado = amplitudArbolAux(hI, elemBusc);
                }
            } else {
                //si es mayor y tiene hijo derecho null, retorna false ya quese llego a una hoja y no se encontro.
                if (hD != null) {
                    //si el hijo derecho es diferente de null, llama al metodo con el hijo derecho.
                    resultado = amplitudArbolAux(hD, elemBusc);
                }
            }
        }
        return resultado;
    }

    private int obtenerMay(NodoABB hijo) {
        int resultado;
        if (hijo.getIzquierdo() == null) {
            resultado = (int) hijo.getElemento();
        } else {
            resultado = obtenerMay(hijo.getIzquierdo());
        }
        return resultado;
    }

    private int obtenerMin(NodoABB hijo) {
        int resultado;
        if (hijo.getIzquierdo() == null) {
            resultado = (int) hijo.getElemento();
        } else {
            resultado = obtenerMin(hijo.getIzquierdo());
        }
        return resultado;
    }

}
