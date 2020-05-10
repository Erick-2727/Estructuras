/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquica.arbolgen;

public class ArbolGen {

    private NodoGen raiz;

    public void ArbolGen() {
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre) {
        boolean exito = false;
        if (this.raiz == null) {
            this.raiz = new NodoGen(elemNuevo, null, null);
            exito = true;
        } else {
            NodoGen nodoPadre = obtenerNodo(this.raiz, elemPadre);
            if (nodoPadre != null) {
                if (nodoPadre.getHijoIzquierdo() == null) {
                    nodoPadre.setHijoIzquierdo(new NodoGen(elemNuevo, null, null));
                    exito = true;
                } else {
                    NodoGen hijo = nodoPadre.getHijoIzquierdo();
                    while (hijo != null && exito != true) {
                        if (hijo.getHermanoDerecho() == null) {
                            hijo.setHermanoDerecho(new NodoGen(elemNuevo, null, null));
                            exito = true;
                        } else {
                            hijo = hijo.getHermanoDerecho();

                        }
                    }
                }
            }
        }
        return exito;
    }
    
    private NodoGen obtenerNodo(NodoGen n, Object buscado) {
        NodoGen resultado = null;
        if (n.getElemento().equals(buscado)) {
            resultado = n;
        } else {
            if (n.getHijoIzquierdo() != null && resultado == null) {
                NodoGen hijo = n.getHijoIzquierdo();
                while (hijo != null && resultado == null) {
                    resultado = obtenerNodo(hijo, buscado);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
        return resultado;
    }
    public boolean pertenece(Object elemento){
        boolean retorno = false;
        
        if(this.raiz != null){
            retorno = pertenecePaso( this.raiz,elemento);
        }
        
        return retorno;
    }
    private boolean pertenecePaso(NodoGen n, Object buscado) {
        boolean resultado = false;
        if (n.getElemento().equals(buscado)) {
            resultado = true;
        } else {
            if (n.getHijoIzquierdo() != null && resultado == false) {
                NodoGen hijo = n.getHijoIzquierdo();
                while (hijo != null && resultado == false) {
                    resultado = pertenecePaso(hijo, buscado);
                    hijo = hijo.getHermanoDerecho();
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

    public Object padre(Object hijo) {
        Object r = null;
        if (this.raiz != null) {
                r = busPadre(this.raiz, hijo,null);
            
        }
        return r;
    }

    private Object busPadre(NodoGen aux, Object hijo, Object padre) {
        Object r = null;
        if (aux != null) {
            if (aux.getElemento().equals(hijo)) {
                r = padre;
            } else {
                if (aux.getHijoIzquierdo() != null && r == null) {
                    NodoGen hi = aux.getHijoIzquierdo();
                    while (hi != null && r == null) {
                        r = busPadre(hi, hijo, aux.getElemento());
                        hi = hi.getHermanoDerecho();
                    }
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

    private void preordenAux(NodoGen n, Lista list) {
       if (n != null) {
           list.insertar(n.getElemento(), list.longitud() + 1);
            if (n.getHijoIzquierdo() != null) {
                inordenAux(n.getHijoIzquierdo(), list);
            }
            list.insertar(n.getElemento(), list.longitud() + 1);
            if (n.getHijoIzquierdo() != null) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    inordenAux(hijo, list);
                    hijo = hijo.getHermanoDerecho();
                }
            }
            
        }
    }

    public Lista listarPosorden() {
        Lista posorden = new Lista();
        posordenAux(this.raiz, posorden);
        return posorden;
    }

    private void posordenAux(NodoGen n, Lista list) {
    if (n != null) {
            if (n.getHijoIzquierdo() != null) {
                inordenAux(n.getHijoIzquierdo(), list);
            }
            list.insertar(n.getElemento(), list.longitud() + 1);
            if (n.getHijoIzquierdo() != null) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    inordenAux(hijo, list);
                    hijo = hijo.getHermanoDerecho();
                }
            }
            list.insertar(n.getElemento(), list.longitud() + 1);
        }
    }

    public Lista listarInorden() {
        Lista inorden = new Lista();
        inordenAux(this.raiz, inorden);
        return inorden;
    }

    private void inordenAux(NodoGen n, Lista list) {
        if (n != null) {
            if (n.getHijoIzquierdo() != null) {
                inordenAux(n.getHijoIzquierdo(), list);
            }
            list.insertar(n.getElemento(), list.longitud() + 1);
            if (n.getHijoIzquierdo() != null) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    inordenAux(hijo, list);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    @Override
    public String toString() {
        String resultado="";
        if (this.raiz != null) {
            resultado=toStringAux(this.raiz, "");
        }else{
        resultado="Arbol vacio";}
        return resultado;
    }

    private String toStringAux(NodoGen nodo, String s) {
        if (nodo != null) {
            s += "\n" + nodo.getElemento() + "\t";
            NodoGen izq = nodo.getIzquierdo();
            NodoGen der = nodo.getDerecho();
            s += "HI: " + ((izq != null) ? izq.getElemento() : "-") + "\t"
                    + "HD: " + ((der != null) ? der.getElemento() : "-");
            s = toStringAux(nodo.getIzquierdo(), s);
            s = toStringAux(nodo.getDerecho(), s);
        }
        return s;
    }

}
