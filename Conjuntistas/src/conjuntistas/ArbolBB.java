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
public class ArbolBB {

    private NodoABB raiz;

    public void ArbolABB() {
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
        if (n.getElemento().equals(elemNuevo)) {
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

    public boolean pertenece(Comparable elemBusc) {
        boolean pertenece=false;
        
        if (this.raiz != null && elemBusc!=null) {
            pertenece = perteneceAux(this.raiz, elemBusc);
        }
        return pertenece;
    }

    private boolean perteneceAux(NodoABB n, Comparable elemBusc) {
        boolean resultado = false;
        //compara elemNuevo con el elemento del nodo actual,si es igual retorna true 
        if (n.getElemento().equals(elemBusc)) {
            resultado = true;
        } else {
            if (n.getElemento().compareTo(elemBusc) > 0) {
                //si es menor y tiene hijo izquierdo null, retorna false ya quese llego a una hoja y no se encontro
                if (n.getIzquierdo() == null) {
                    resultado = false;
                } else {
                    //si el hijo izquierdo es diferente de null, llama al metodo con el hijo izquierdo
                    resultado = perteneceAux(n.getIzquierdo(), elemBusc);
                }
            } else {
                //si es mayor y tiene hijo derecho null, retorna false ya quese llego a una hoja y no se encontro
                if (n.getDerecho() == null) {
                    resultado = false;
                } else {
                    //si el hijo derecho es diferente de null, llama al metodo con el hijo derecho
                    resultado = perteneceAux(n.getDerecho(), elemBusc);
                }
            }
        }
        return resultado;
    }

    public boolean eliminar(Comparable elemBusc) {
        boolean pertenece;
        if (this.raiz == null) {
            pertenece = false;
        } else {
            if (this.raiz.getElemento().equals(elemBusc)) {

            }
            pertenece = eliminarAux(null, this.raiz, elemBusc, 1);
        }
        return pertenece;
    }

    private boolean eliminarAux(NodoABB padre, NodoABB hijo, Comparable elemBusc, int pos) {
        boolean resultado = false;
        //compara elemNuevo con el elemento del nodo actual,si es igual retorna true 
        if (hijo.getElemento().equals(elemBusc)) {
            eliminarNodo(padre, hijo, pos);
            resultado = true;
        } else {
            if (hijo.getElemento().compareTo(elemBusc) > 0) {
                //si es menor y tiene hijo izquierdo null, retorna false ya quese llego a una hoja y no se encontro
                if (hijo.getIzquierdo() == null) {
                    resultado = false;
                } else {
                    //si el hijo izquierdo es diferente de null, llama al metodo con el hijo izquierdo
                    resultado = eliminarAux(hijo, hijo.getIzquierdo(), elemBusc, 0);
                }
            } else {
                //si es mayor y tiene hijo derecho null, retorna false ya quese llego a una hoja y no se encontro
                if (hijo.getDerecho() == null) {
                    resultado = false;
                } else {
                    //si el hijo derecho es diferente de null, llama al metodo con el hijo derecho
                    resultado = eliminarAux(hijo, hijo.getDerecho(), elemBusc, 1);
                }
            }
        }
        return resultado;
    }

    private void eliminarNodo(NodoABB padre, NodoABB hijo, int pos) {
        //si hijo no tiene hijos lo setea directamente en null
        if (hijo.getIzquierdo() == null && hijo.getDerecho() == null) {
            eliminarSinHijo(padre,pos);
        } else {
            //si solo tiene un hijo lo envia al caso 2
            if (hijo.getIzquierdo() == null || hijo.getDerecho() == null) {
                eliminarConUnHijo(padre, hijo, pos);
            } else {
                //si no, significa que tiene 2 hijos y lo envia al caso 3
                eliminarConDosHijos(hijo);
            }
        }

    }

    private void eliminarSinHijo(NodoABB padre, int pos) {
        if (padre == null) {
            this.raiz = null;
        } else {
            if (pos == 1) {
                padre.setDerecho(null);
            } else {
                padre.setIzquierdo(null);
            }
        }
    }

    private void eliminarConUnHijo(NodoABB padre, NodoABB hijo, int pos) {
        NodoABB reemplazo;
        if (hijo.getDerecho() != null) {
            reemplazo = hijo.getDerecho();
        } else {
            reemplazo = hijo.getIzquierdo();
        }
        if (padre == null) {
            this.raiz = reemplazo;
        } else {
            if (pos == 0) {
                padre.setIzquierdo(reemplazo);
            } else {
                padre.setDerecho(reemplazo);
            }
        }
    }

    private void eliminarConDosHijos(NodoABB hijo) {
        if (hijo.getDerecho().getIzquierdo() == null) {
            hijo.setElemento(hijo.getDerecho().getElemento());
            hijo.setDerecho(hijo.getDerecho().getDerecho());
        } else {
            Comparable resp = encontrarMinAux(hijo, hijo.getDerecho());
            hijo.setElemento(resp);
        }

    }

    private Comparable encontrarMinAux(NodoABB padre, NodoABB hijo) {
        //compara elemNuevo con el elemento del nodo actual,si es igual retorna true
        Comparable resp = null;
        if (hijo.getIzquierdo() == null) {
            resp = hijo.getElemento();
            padre.setIzquierdo(hijo.getDerecho());

        } else {
            resp = encontrarMinAux(hijo, hijo.getIzquierdo());
        }
        return resp;
    }

    public boolean eliminarMin() {
        boolean resultado = false;
        if (this.raiz != null) {
            if (this.raiz.getIzquierdo() == null) {
                this.raiz = this.raiz.getDerecho();
            } else {
                eliminarMinAux(this.raiz, this.raiz.getIzquierdo());
            }
            resultado = true;
        }
        return resultado;
    }

    private void eliminarMinAux(NodoABB padre, NodoABB hijo) {
        //compara elemNuevo con el elemento del nodo actual,si es igual retorna true 
        if (hijo.getIzquierdo() == null) {
            padre.setIzquierdo(hijo.getDerecho());
        } else {
            eliminarMinAux(hijo, hijo.getIzquierdo());
        }
    }

    public Comparable minimoElem() {
        Comparable resultado = null;
        if (this.raiz != null) {
            if (this.raiz.getIzquierdo() == null) {
                resultado = this.raiz.getElemento();
            } else {
                resultado = minimoElemAux(this.raiz, this.raiz.getIzquierdo());
            }
        }
        return resultado;
    }

    private Comparable minimoElemAux(NodoABB padre, NodoABB hijo) {
        //compara elemNuevo con el elemento del nodo actual,si es igual retorna true 
        Comparable resultado;
        if (hijo.getIzquierdo() == null) {
            resultado = hijo.getElemento();
        } else {
            resultado = minimoElemAux(hijo, hijo.getIzquierdo());
        }
        return resultado;
    }

    public Comparable maximoElem() {
        Comparable resultado = null;
        if (this.raiz != null) {
            if (this.raiz.getDerecho() == null) {
                resultado = this.raiz.getElemento();
            } else {
                resultado = maximoElemAux(this.raiz, this.raiz.getDerecho());
            }
        }
        return resultado;
    }

    private Comparable maximoElemAux(NodoABB padre, NodoABB hijo) {
        //compara elemNuevo con el elemento del nodo actual,si es igual retorna true 
        Comparable resultado;
        if (hijo.getDerecho() == null) {
            resultado = hijo.getElemento();
        } else {
            resultado = maximoElemAux(hijo, hijo.getDerecho());
        }
        return resultado;
    }

    public boolean eliminarMax() {
        boolean resultado = false;
        if (this.raiz != null) {
            if (this.raiz.getDerecho() == null) {
                this.raiz = this.raiz.getIzquierdo();
            } else {
                eliminarMaxAux(this.raiz, this.raiz.getDerecho());
            }
            resultado = true;
        }
        return resultado;
    }

    private void eliminarMaxAux(NodoABB padre, NodoABB hijo) {
        //compara elemNuevo con el elemento del nodo actual,si es igual retorna true 
        if (hijo.getDerecho() == null) {
            padre.setDerecho(hijo.getIzquierdo());
        } else {
            eliminarMaxAux(hijo, hijo.getDerecho());
        }
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

    public ArbolBB clone() {
        ArbolBB clon = new ArbolBB();
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

    public Lista listar() {
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

    public Lista listarRango(Comparable min, Comparable max) {
        Lista list = new Lista();
        if (min != null && max!= null) {
        listarRangoAux(this.raiz, list, min, max);
        }
        return list;
    }

    private void listarRangoAux(NodoABB n, Lista list, Comparable min, Comparable max) {
        if (n != null) {
            Comparable elem = n.getElemento();
            if (elem.compareTo(max) < 0) {
                listarRangoAux(n.getDerecho(), list, min, max);
            }
            if (elem.compareTo(min) >= 0 && elem.compareTo(max) <= 0) {
                list.insertar(elem, 1);
            }
            if (elem.compareTo(min) > 0) {
                listarRangoAux(n.getIzquierdo(), list, min, max);
            }
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
