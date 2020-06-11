package conjuntistas;

/**
 *
 * @author Erick
 */

public class NodoABB {

    private Comparable elemeto;
    private NodoABB derecho;
    private NodoABB izquierdo;

    //constructor
    public NodoABB(Comparable elemento, NodoABB derecho, NodoABB izquierdo) {
        this.elemeto = elemento;
        this.derecho = derecho;
        this.izquierdo = izquierdo;
    }

    //modificadores
    public void setElemento(Comparable elemento) {
        this.elemeto = elemento;
    }

    //observadores
    public Comparable getElemento() {
        return this.elemeto;
    }

    public NodoABB getDerecho() {
        return this.derecho;
    }

    public NodoABB getIzquierdo() {
        return this.izquierdo;
    }

    public void setDerecho(NodoABB derech) {
        this.derecho = derech;
    }

    public void setIzquierdo(NodoABB izq) {
        this.izquierdo = izq;
    }
}
