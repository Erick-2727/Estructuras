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
//Metodo que dado un elemento, intenta insertarlo en el arbol, si ese elemento ya esta en el abrol retorna false.
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
        //compara elemNuevo con el elemento del nodo actual, si es igual entonces ya esta en el arbol y retorna false.
        if (n.getElemento().equals(elemNuevo)) {
            resultado = false;
        } else {
            if (n.getElemento().compareTo(elemNuevo) > 0) {
                //si es menor y tiene hijo izquierdo null, lo setea como hijo izquierdo.
                if (n.getIzquierdo() == null) {
                    n.setIzquierdo(new NodoABB(elemNuevo, null, null));
                    resultado = true;
                } else {
                    //si el hijo izquierdo es diferente de null, llama al metodo con el hijo izquierdo.
                    resultado = insertarAux(n.getIzquierdo(), elemNuevo);
                }
            } else {
                //si es mayor y tiene hijo derecho null, lo setea como hijo derecho.
                if (n.getDerecho() == null) {
                    n.setDerecho(new NodoABB(elemNuevo, null, null));
                    resultado = true;
                } else {
                    //si el hijo derecho es diferente de null, llama al metodo con el hijo derecho.
                    resultado = insertarAux(n.getDerecho(), elemNuevo);
                }
            }
        }
        return resultado;
    }
    //Metodo que dado un elemento, verifica que dicho elemento se encuentra dentro del arbol, si lo esta retorna true.
    public boolean pertenece(Comparable elemBusc) {
        boolean pertenece = false;

        if (this.raiz != null && elemBusc != null) {
            pertenece = perteneceAux(this.raiz, elemBusc);
        }
        return pertenece;
    }

    private boolean perteneceAux(NodoABB n, Comparable elemBusc) {
        boolean resultado = false;
        //compara elemNuevo con el elemento del nodo actual,si es igual retorna true. 
        if (n.getElemento().equals(elemBusc)) {
            resultado = true;
        } else {
            if (n.getElemento().compareTo(elemBusc) > 0) {
                //si es menor y tiene hijo izquierdo null, retorna false ya quese llego a una hoja y no se encontro.
                if (n.getIzquierdo() == null) {
                    resultado = false;
                } else {
                    //si el hijo izquierdo es diferente de null, llama al metodo con el hijo izquierdo.
                    resultado = perteneceAux(n.getIzquierdo(), elemBusc);
                }
            } else {
                //si es mayor y tiene hijo derecho null, retorna false ya quese llego a una hoja y no se encontro.
                if (n.getDerecho() == null) {
                    resultado = false;
                } else {
                    //si el hijo derecho es diferente de null, llama al metodo con el hijo derecho.
                    resultado = perteneceAux(n.getDerecho(), elemBusc);
                }
            }
        }
        return resultado;
    }
    //Metodo que dado un elemento, verifica que dicho elemento se encuentra dentro del arbol, si lo esta lo elimina.
    public boolean eliminar(Comparable elemBusc) {
        boolean pertenece = false;
        if (this.raiz != null) {
            pertenece = eliminarAux(null, this.raiz, elemBusc, 1);
        }
        return pertenece;
    }

    private boolean eliminarAux(NodoABB padre, NodoABB hijo, Comparable elemBusc, int pos) {
        boolean resultado = false;
        //compara elemNuevo con el elemento del nodo actual,si es igual retorna true. 
        if (hijo.getElemento().equals(elemBusc)) {
            eliminarNodo(padre, hijo, pos);
            resultado = true;
        } else {
            if (hijo.getElemento().compareTo(elemBusc) > 0) {
                //si es menor y tiene hijo izquierdo null, retorna false ya quese llego a una hoja y no se encontro.
                if (hijo.getIzquierdo() == null) {
                    resultado = false;
                } else {
                    //si el hijo izquierdo es diferente de null, llama al metodo con el hijo izquierdo.
                    resultado = eliminarAux(hijo, hijo.getIzquierdo(), elemBusc, 0);
                }
            } else {
                //si es mayor y tiene hijo derecho null, retorna false ya quese llego a una hoja y no se encontro.
                if (hijo.getDerecho() == null) {
                    resultado = false;
                } else {
                    //si el hijo derecho es diferente de null, llama al metodo con el hijo derecho.
                    resultado = eliminarAux(hijo, hijo.getDerecho(), elemBusc, 1);
                }
            }
        }
        return resultado;
    }

    private void eliminarNodo(NodoABB padre, NodoABB hijo, int pos) {
        //si hijo no tiene hijos lo envia al caso 1.
        if (hijo.getIzquierdo() == null && hijo.getDerecho() == null) {
            eliminarSinHijo(padre, pos);
        } else {
            //si solo tiene un hijo lo envia al caso 2.
            if (hijo.getIzquierdo() == null || hijo.getDerecho() == null) {
                eliminarConUnHijo(padre, hijo, pos);
            } else {
                //si no, significa que tiene 2 hijos y lo envia al caso 3.
                eliminarConDosHijos(hijo);
            }
        }

    }
// Caso 1: eliminar un nodo sin hijos.

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
//Caso 2: eliminar un nodo que tiene 1 hijo.

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
    // Caso 3: eliminar un nodo que tiene 2 hijos.

    private void eliminarConDosHijos(NodoABB hijo) {
        //Si el HD del nodo a eliminar no tiene HI, significa que es el menor nodo en la rama derecha.
        if (hijo.getDerecho().getIzquierdo() == null) {
            hijo.setElemento(hijo.getDerecho().getElemento());
            hijo.setDerecho(hijo.getDerecho().getDerecho());
        } else {
            Comparable resp = encontrarMinAux(hijo, hijo.getDerecho());
            hijo.setElemento(resp);
        }

    }

    //Busca el menor elemento de un subArbol y retorna su elemento.
    private Comparable encontrarMinAux(NodoABB padre, NodoABB hijo) {
        Comparable resp = null;
        //Verifica si tiene hijo izquierdo, si no tiene.
        //significa que es el menor elemento del SubArbol y retorna su elemento, y luego lo elimina.
        if (hijo.getIzquierdo() == null) {
            resp = hijo.getElemento();
            padre.setIzquierdo(hijo.getDerecho());
        } else {
            //Si tiene hijo izquierdo entonces llama al Metodo recursivo.
            resp = encontrarMinAux(hijo, hijo.getIzquierdo());
        }
        return resp;
    }

    //Metodo que elimina al menor elemento del Arbol.
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
        if (hijo.getIzquierdo() == null) {
            padre.setIzquierdo(hijo.getDerecho());
        } else {
            eliminarMinAux(hijo, hijo.getIzquierdo());
        }
    }

    //Metodo que maximo al menor elemento del Arbol.
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
        if (hijo.getDerecho() == null) {
            padre.setDerecho(hijo.getIzquierdo());
        } else {
            eliminarMaxAux(hijo, hijo.getDerecho());
        }
    }
    //Metodo que devuelve el minimo elemento de un arbol.

    public Comparable minimoElem() {
        Comparable resultado = null;
        if (this.raiz != null) {
            if (this.raiz.getIzquierdo() == null) {
                resultado = this.raiz.getElemento();
            } else {
                resultado = minimoElemAux(this.raiz.getIzquierdo());
            }
        }
        return resultado;
    }

    private Comparable minimoElemAux(NodoABB hijo) { 
        Comparable resultado;
        if (hijo.getIzquierdo() == null) {
            resultado = hijo.getElemento();
        } else {
            resultado = minimoElemAux(hijo.getIzquierdo());
        }
        return resultado;
    }
//Metodo que devuelve el maximo elemento de un arbol.

    public Comparable maximoElem() {
        Comparable resultado = null;
        if (this.raiz != null) {
            if (this.raiz.getDerecho() == null) {
                resultado = this.raiz.getElemento();
            } else {
                resultado = maximoElemAux(this.raiz.getDerecho());
            }
        }
        return resultado;
    }

    private Comparable maximoElemAux(NodoABB hijo) { 
        Comparable resultado;
        if (hijo.getDerecho() == null) {
            resultado = hijo.getElemento();
        } else {
            resultado = maximoElemAux(hijo.getDerecho());
        }
        return resultado;
    }
//Metodo que verifica si un arbol es vacio, si lo es retorna true.

    public boolean esVacio() {
        boolean vacio = true;
        if (this.raiz != null) {
            vacio = false;
        }
        return vacio;
    }
//Metodo que calcula la altura de un Arbol.

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
//Metodo que dado un elemento retorna el nivel en el que se encuentra. 

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
//Metodo que vaica el Arbol.

    public void vaciar() {
        this.raiz = null;

    }
//Metodo que retorna un arbol clon con todos los elementos del arbol original.

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
//Lista todos los elementos de mayor a menor.

    public Lista listar() {
        Lista list = new Lista();
        ListarAux(this.raiz, list);
        return list;
    }

    private void ListarAux(NodoABB raiz, Lista list) {
        if (raiz != null) {
            ListarAux(raiz.getIzquierdo(), list);
            list.insertar(raiz.getElemento(), list.longitud() + 1);
            ListarAux(raiz.getDerecho(), list);
        }
    }
    public Lista listarPorNivel(int nivel){
        Lista res=new Lista();
        if (!this.esVacio()) {
            listarPorNivelAux(this.raiz, res,0,nivel);
        }
    return res;
    }
    private void listarPorNivelAux(NodoABB node, Lista list, int nivActual, int nivel) {
        if (nivel == nivActual) {
            if (node != null) {
                list.insertar(node.getElemento(), 1);
            }
        } else {
            if (node != null) {
                listarPorNivelAux(node.getIzquierdo(), list, nivActual + 1, nivel);
                listarPorNivelAux(node.getDerecho(), list, nivActual + 1, nivel);
            }
        }
    }
//Lista todos los elementos que se encuentran en un rango determinado.

    public Lista listarRango(Comparable min, Comparable max) {
        Lista list = new Lista();
        if (min != null && max != null) {
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
    //Metodo que devuelve un String que muestra a todos los nodos y quienes son sus hijos.
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
    //Metodo del parcial
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
                    min = obtenerMin(hI);
                }
                if (hD != null) {
                    may = obtenerMay(hD);
                }
                if (hD != null && hI != null) {
                    System.out.println(may+" - "+ min);
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
        if (hijo.getDerecho() == null) {
            resultado = (int) hijo.getElemento();
        } else {
            resultado = obtenerMay(hijo.getDerecho());
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
