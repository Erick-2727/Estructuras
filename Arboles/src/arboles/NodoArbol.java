package arboles;

/**
 *
 * @author Erick
 */

public class NodoArbol {

    private Object elemeto;
    private NodoArbol derecho;
    private NodoArbol izquierdo;

    //constructor
    public NodoArbol(Object elemento, NodoArbol derecho, NodoArbol izquierdo) {
        this.elemeto = elemento;
        this.derecho = derecho;
        this.izquierdo = izquierdo;
    }

    //modificadores
    public void setElemento(Object elemento) {
        this.elemeto = elemento;
    }

    //observadores
    public Object getElemento() {
        return this.elemeto;
    }

    public NodoArbol getDerecho() {
        return this.derecho;
    }

    public NodoArbol getIzquierdo() {
        return this.izquierdo;
    }

    public void setDerecho(NodoArbol derech) {
        this.derecho = derech;
    }

    public void setIzquierdo(NodoArbol izq) {
        this.izquierdo = izq;
    }

    public String toString() {
        return this.elemeto.toString();
    }

}
