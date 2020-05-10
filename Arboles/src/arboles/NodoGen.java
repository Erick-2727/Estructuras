package jerarquica.arbolgen;

/**
 *
 * @author Erick
 */

public class NodoGen {

    private Object elemeto;
    private NodoGen hermanoDerecho;
    private NodoGen hijoIzquierdo;

    //constructor
    public NodoGen(Object elemento, NodoGen hermDerecho, NodoGen hijIzquierdo) {
        this.elemeto = elemento;
        this.hermanoDerecho = hermDerecho;
        this.hijoIzquierdo = hijIzquierdo;
    }

    //modificadores
    public void setElemento(Object elemento) {
        this.elemeto = elemento;
    }

    //observadores
    public Object getElemento() {
        return this.elemeto;
    }

    public NodoGen getHermanoDerecho() {
        return this.hermanoDerecho;
    }

    public NodoGen getHijoIzquierdo() {
        return this.hijoIzquierdo;
    }

    public void setHermanoDerecho(NodoGen derech) {
        this.hermanoDerecho = derech;
    }

    public void setHijoIzquierdo(NodoGen izq) {
        this.hijoIzquierdo = izq;
    }

    public String toString() {
        return this.elemeto.toString();
    }

}
