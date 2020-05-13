/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

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

    public boolean pertenece(Object elemento) {
        boolean retorno = false;

        if (this.raiz != null) {
            retorno = pertenecePaso(this.raiz, elemento);
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
            r = busPadre(this.raiz, hijo, null);

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
            altura = alturaAux(this.raiz, -1);
        } else {
            altura = -1;
        }
        return altura;
    }

    private int alturaAux(NodoGen aux, int alt) {
        int altura, altMayor = 0;
        alt = alt + 1;
        if (aux.getHijoIzquierdo() != null) {
            NodoGen hijo = aux.getHijoIzquierdo();
            while (hijo != null) {
                altura = alturaAux(hijo, alt);
                if (altura > altMayor) {
                    altMayor = altura;
                }
                hijo = hijo.getHermanoDerecho();
            }
            alt = altMayor;
        }
        return alt;
    }

    public int nivel(Object elemento) {
        int retorno = -1;

        if (this.raiz != null) {
            retorno = retorno + nivelRecursivo(this.raiz, elemento);
        }
        return retorno;
    }

    private int nivelRecursivo(NodoGen nodo, Object elemento) {

        int resultado = 0;
        if (nodo.getElemento().equals(elemento)) {
            resultado = 1;
        } else {
            if (nodo.getHijoIzquierdo() != null) {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null && resultado <= 0) {
                    resultado = nivelRecursivo(hijo, elemento);

                    if (resultado > 0) {
                        resultado = resultado + 1;
                    }
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
        return resultado;
    }

    public Lista ancestros(Object elem) {
        Lista list = new Lista();
        this.ancestrosAux(this.raiz, elem, list);
        return list;
    }

    private boolean ancestrosAux(NodoGen actual, Object elem, Lista list) {
        boolean resp = false;
        if (actual != null) {
            if (actual.getElemento().equals(elem)) {
                resp = true;
            } else {
                NodoGen hijo = actual.getHijoIzquierdo();
                while (!resp && hijo != null) {
                    resp = this.ancestrosAux(hijo, elem, list);
                    hijo = hijo.getHermanoDerecho();
                }
                if (resp) {
                    list.insertar(actual.getElemento(), list.longitud()+1);
                }
            }
        }
        return resp;
    }

    public void vaciar() {
        this.raiz = null;

    }

    @Override
    public ArbolGen clone() {
        ArbolGen clon = new ArbolGen();
        if (this.raiz != null) {
            clon.raiz = new NodoGen(this.raiz.getElemento(), null, null);
            clonePaso(this.raiz, clon.raiz);
        }
        return clon;
    }

    private void clonePaso(NodoGen aux, NodoGen clon) {
        NodoGen hijoClon, hijoAux;
        if (aux.getHijoIzquierdo() != null) {
            hijoAux = aux.getHijoIzquierdo();
            hijoClon = new NodoGen(aux.getHijoIzquierdo().getElemento(), null, null);
            clon.setHijoIzquierdo(hijoClon);
            while (hijoAux != null) {
                if (hijoAux.getHermanoDerecho() != null) {
                    hijoClon.setHermanoDerecho(new NodoGen(hijoAux.getHermanoDerecho().getElemento(), null, null));
                }
                clonePaso(hijoAux, hijoClon);
                hijoClon = hijoClon.getHermanoDerecho();
                hijoAux = hijoAux.getHermanoDerecho();
            }
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
                preordenAux(n.getHijoIzquierdo(), list);
            }
            if (n.getHijoIzquierdo() != null) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    preordenAux(hijo, list);
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
                posordenAux(n.getHijoIzquierdo(), list);
            }
            if (n.getHijoIzquierdo() != null) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    posordenAux(hijo, list);
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
        String resultado = "Arbol vacio";
        if (this.raiz != null) {
            resultado = toStringAux(this.raiz);
        }

        return resultado;
    }

    private String toStringAux(NodoGen nodo) {
        String rssultado = "";
        if (nodo != null) {
            rssultado = nodo.getElemento().toString() + " -> ";
            NodoGen hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                rssultado += hijo.getElemento().toString() + ", ";
                hijo = hijo.getHermanoDerecho();
            }
            hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                rssultado += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return rssultado;
    }

}
