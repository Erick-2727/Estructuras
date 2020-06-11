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
public class ABB {

    private NodoABB raiz;

    public void ABB() {
        this.raiz = null;
    }

    public boolean insertar(Comparable elemNuevo) {
        boolean exito;
        if (this.raiz == null) {
            this.raiz = new NodoABB(elemNuevo, null, null);
            exito = true;
        } else {
            exito = insertarAux(this.raiz, elemNuevo);
        }
        return exito;
    }

    private boolean insertarAux(NodoABB n, Comparable elemNuevo) {
        boolean resultado = false;
        //compara elemNuevo con el elemento del nodo actual, si es igual entonces ya esta en el arbol y retorna false
        if (n.getElemento().compareTo(elemNuevo) == 0) {
            resultado = false;
        } else {
            if (n.getElemento().compareTo(elemNuevo) > 0) {
                //si es menor y tiene hijo izquierdo null, lo setea como hijo izquierdo
                if (n.getIzquierdo() == null) {
                    n.setIzquierdo(new NodoABB(elemNuevo, null, null));
                    resultado = true;
                } else {
                    //si el hijo izquierdo es diferente de null, llama al metodo con el hijo izquierdo
                    resultado = insertarAux(n.getIzquierdo(), elemNuevo);
                }
            } else {
                //si es mayor y tiene hijo derecho null, lo setea como hijo derecho
                if (n.getDerecho() == null) {
                    n.setDerecho(new NodoABB(elemNuevo, null, null));
                    resultado = true;
                } else {
                    //si el hijo derecho es diferente de null, llama al metodo con el hijo derecho
                    resultado = insertarAux(n.getDerecho(), elemNuevo);
                }
            }
        }
        return resultado;
    }
    public boolean pertenece(Comparable elemNuevo) {
        boolean pertenece;
        if (this.raiz == null) {
            pertenece = false;
        } else {
            pertenece = pertenceAux(this.raiz, elemNuevo);
        }
        return pertenece;
    }

    private boolean pertenceAux(NodoABB n, Comparable elemNuevo) {
        boolean resultado = false;
        //compara elemNuevo con el elemento del nodo actual,si es igual retorna true 
        if (n.getElemento().compareTo(elemNuevo) == 0) {
            resultado = true;
        } else {
            if (n.getElemento().compareTo(elemNuevo) > 0) {
                //si es menor y tiene hijo izquierdo null, retorna false ya quese llego a una hoja y no se encontro
                if (n.getIzquierdo() == null) {
                    resultado = false;
                } else {
                    //si el hijo izquierdo es diferente de null, llama al metodo con el hijo izquierdo
                    resultado =pertenceAux(n.getIzquierdo(), elemNuevo);
                }
            } else {
                //si es mayor y tiene hijo derecho null, retorna false ya quese llego a una hoja y no se encontro
                if (n.getDerecho() == null) {
                    resultado = false;
                } else {
                    //si el hijo derecho es diferente de null, llama al metodo con el hijo derecho
                    resultado = pertenceAux(n.getDerecho(), elemNuevo);
                }
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
    public int altura() {
        int altura;
        if (!this.esVacio()) {
            altura = alturaAux(this.raiz);
        } else {
            altura = -1;
        }
        return altura;
    }

    private int alturaAux(NodoABB aux) {
        int altD = 0, altIzq = 0, altMayor = 0;
        if (aux.getDerecho() != null) {
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

    private int nivelRecursivo(NodoABB raiz, Object elemento) {

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

    public ABB clone() {
        ABB clon = new ABB();
        if (this.raiz != null) {
            {
                clon.raiz = new NodoABB(this.raiz.getElemento(), null, null);
                clonePaso(this.raiz, clon.raiz);
            }
        }
        return clon;
    }

    private void clonePaso(NodoABB aux, NodoABB clon) {
        if (aux.getIzquierdo() != null) {
            NodoABB clonIzq = new NodoABB(aux.getIzquierdo().getElemento(), null, null);
            clon.setIzquierdo(clonIzq);
            clonePaso(aux.getIzquierdo(), clon.getIzquierdo());
        }
        if (aux.getDerecho() != null) {
            NodoABB clonDer = new NodoABB(aux.getDerecho().getElemento(), null, null);
            clon.setDerecho(clonDer);
            clonePaso(aux.getDerecho(), clon.getDerecho());

        }
    }

    public Lista listarInorden() {
        Lista inorden = new Lista();
        inordenAux(this.raiz, inorden);
        return inorden;
    }

    private void inordenAux(NodoABB raiz, Lista inorden) {
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

    private String toStringAux(NodoABB nodo, String s) {
        if (nodo != null) {
            s += "\n" + nodo.getElemento() + "\t";
            NodoABB izq = nodo.getIzquierdo();
            NodoABB der = nodo.getDerecho();
            s += "HI: " + ((izq != null) ? izq.getElemento() : "-") + "\t"
                    + "HD: " + ((der != null) ? der.getElemento() : "-");
            s = toStringAux(nodo.getIzquierdo(), s);
            s = toStringAux(nodo.getDerecho(), s);
        }
        return s;
    }

}
