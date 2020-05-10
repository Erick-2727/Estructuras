package arboles;

/**
 *
 * @author Erick
 */
public class Nodo {

    private Object elemento;
    private Nodo enlace;

    //constructor
    public Nodo(Object elemento, Nodo enlace) {
        this.elemento = elemento;
        this.enlace = enlace;
    }

    //modificadores
    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }

    //observadores
    public Object getElemento() {
        return this.elemento;
    }

    public Nodo getEnlace() {
        return this.enlace;
    }

    public boolean equals(Nodo comparar) {
        return this.toString().equals(comparar.toString());
    }

    public String toString() {
        return this.elemento.toString();
    }
}
