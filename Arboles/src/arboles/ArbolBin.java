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
public class ArbolBin {

    private NodoArbol raiz;

    public void ArbolBin() {
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar) {
        boolean exito = false;
        if (this.raiz == null) {
            this.raiz = new NodoArbol(elemNuevo, null, null);
            exito = true;
        } else {
            NodoArbol nodoPadre = obtenerNodo(this.raiz, elemPadre);
            if (nodoPadre != null) {
                if (lugar == 'I' && nodoPadre.getIzquierdo() == null) {
                    nodoPadre.setIzquierdo(new NodoArbol(elemNuevo, null, null));
                    exito = true;
                } else {
                    if (lugar == 'D' && nodoPadre.getDerecho() == null) {
                        nodoPadre.setDerecho(new NodoArbol(elemNuevo, null, null));
                        exito = true;
                    }
                }
            }
        }
        return exito;
    }

    private NodoArbol obtenerNodo(NodoArbol n, Object buscado) {
        NodoArbol resultado = null;
            if (n.getElemento().equals(buscado)) {
                resultado = n;
            } else {
                if (n.getIzquierdo()!=null) {
                  resultado = obtenerNodo(n.getIzquierdo(), buscado);  
                }
                if (resultado == null&&n.getDerecho()!=null) {
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        return resultado;
    }

    public boolean esVacio() {
        boolean vacio = true;
        if (this.raiz != null) {
            vacio = false;
        }
        return vacio;
    }

    public Object padre(Object hijo) {
        Object r = null;
        if (this.raiz != null) {
            if (this.raiz.getElemento() != hijo) {
                r = busPadre(this.raiz, hijo, this.raiz.getElemento());
            }
        }
        return r;
    }

    private Object busPadre(NodoArbol aux, Object hijo, Object padre) {
        Object r = null;
        if (aux != null) {
            if (aux.getElemento().equals(hijo)) {
                r = padre;
            } else {
                r = busPadre(aux.getIzquierdo(), hijo, aux.getElemento());
                if (r == null) {
                    r = busPadre(aux.getDerecho(), hijo, aux.getElemento());
                }
            }
        }
        return r;
    }

    public int altura() {
        int altura;
        if (!this.esVacio()) {
            altura = alturaAux(this.raiz);
        } else {
            altura = -1;
        }
        return altura;
    }

    private int alturaAux(NodoArbol aux) {
        int altD = 0, altIzq = 0, altMayor = 0;
        if (aux.getDerecho()!= null) {
            altD = +alturaAux(aux.getDerecho()) + 1;
        }
        if (aux.getIzquierdo() != null) {
            altIzq = altIzq + alturaAux(aux.getIzquierdo()) + 1;
        }
        if (altIzq > altD) {
            altMayor = altIzq;
        } else {
            altMayor = altD;
        }
        return altMayor;
    }

    public int nivel(Object elemento) {
        int retorno = -1;

        if (this.raiz != null) {
            retorno = retorno + nivelRecursivo(this.raiz, elemento);
        }
        return retorno;
    }
    
    private int nivelRecursivo(NodoArbol raiz, Object elemento) {
      
        int retorno = 1;
        boolean encontrado = false;

        if (raiz.getElemento().equals(elemento)) {
            retorno = 1;
        } else {
       
            if (raiz.getIzquierdo() != null) {
                int retornoIzquierda = nivelRecursivo(raiz.getIzquierdo(), elemento);
                if (retornoIzquierda > 0) {
                    retorno = 1 + retornoIzquierda;
                }
            } else {
                if (raiz.getDerecho() != null) {
                    int retornoDerecha = nivelRecursivo(raiz.getIzquierdo(), elemento);
                    if (retornoDerecha > 0 && !encontrado) {
                        retorno = 1 + retornoDerecha;
                    }
                }
            }
        }
        if (retorno == 0) {
            retorno = -1;
        }
        return retorno;
    }

    public void vaciar() {
        this.raiz = null;

    }

    public ArbolBin clone() {
        ArbolBin clon = new ArbolBin();
        if (this.raiz != null) {
            {
                clon.raiz = new NodoArbol(this.raiz.getElemento(), null, null);
                clonePaso(this.raiz, clon.raiz);
            }
        }
        return clon;
    }

    private void clonePaso(NodoArbol aux, NodoArbol clon) {
        if (aux.getIzquierdo() != null) {
            NodoArbol clonIzq = new NodoArbol(aux.getIzquierdo().getElemento(), null, null);
            clon.setIzquierdo(clonIzq);
            clonePaso(aux.getIzquierdo(), clon.getIzquierdo());
        }
        if (aux.getDerecho() != null) {
            NodoArbol clonDer = new NodoArbol(aux.getDerecho().getElemento(), null, null);
            clon.setDerecho(clonDer);
            clonePaso(aux.getDerecho(), clon.getDerecho());

        }
    }

    public Lista listarPreorden() {
        Lista preorden = new Lista();
        preordenAux(this.raiz, preorden);
        return preorden;
    }

    private void preordenAux(NodoArbol raiz, Lista preorden) {
        if (raiz != null) {
            preorden.insertar(raiz.getElemento(), preorden.longitud() + 1);
            preordenAux(raiz.getIzquierdo(), preorden);
            preordenAux(raiz.getDerecho(), preorden);
        }
    }

    public Lista listarPosorden() {
        Lista posorden = new Lista();
        posordenAux(this.raiz, posorden);
        return posorden;
    }

    private void posordenAux(NodoArbol raiz, Lista preorden) {
        if (raiz != null) {
            posordenAux(raiz.getIzquierdo(), preorden);
            posordenAux(raiz.getDerecho(), preorden);
            preorden.insertar(raiz.getElemento(), preorden.longitud() + 1);
        }
    }

    public Lista listarInorden() {
        Lista inorden = new Lista();
        inordenAux(this.raiz, inorden);
        return inorden;
    }

    private void inordenAux(NodoArbol raiz, Lista inorden) {
        if (raiz != null) {
            inordenAux(raiz.getIzquierdo(), inorden);
            inorden.insertar(raiz.getElemento(), inorden.longitud() + 1);
            inordenAux(raiz.getDerecho(), inorden);
        }
    }

    @Override
    public String toString() {
        return (this.raiz != null)
                ? toStringAux(this.raiz, "") : "Arbol Vacio";
    }

    private String toStringAux(NodoArbol nodo, String s) {
        if (nodo != null) {
            s += "\n" + nodo.getElemento() + "\t";
            NodoArbol izq = nodo.getIzquierdo();
            NodoArbol der = nodo.getDerecho();
            s += "HI: " + ((izq != null) ? izq.getElemento() : "-") + "\t"
                    + "HD: " + ((der != null) ? der.getElemento() : "-");
            s = toStringAux(nodo.getIzquierdo(), s);
            s = toStringAux(nodo.getDerecho(), s);
        }
        return s;
    }

}
