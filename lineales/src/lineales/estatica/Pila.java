
package lineales.estatica;
// @author franco
public class Pila {
    private int TAMANIO=10;
    private Object array[];
    private int tope;
    
    //constructor

    public Pila() {
        //generamos el tamaño de la pila
        this.array = new Object[TAMANIO];
        this.tope = -1;
    }
    
    //apilar
    public boolean apilar(Object elemento){
        boolean retorno;
        
        if(this.tope+1 >= this.TAMANIO){
           retorno = false;
        }else{
         this.tope ++;
            this.array[this.tope] = elemento;
            retorno = true;}
        return retorno;
    }
    
    //desapilar
    public boolean desapilar(){
        boolean retorno = false;
        
        if(this.tope >= 0){
            this.array[this.tope] = null;
            this.tope --;
            retorno = true;
        }
        
        return retorno;
    }
    
    //obtener tope
    public Object obtenerTope(){
        Object retorno = null;
        if(this.tope >= 0){
            retorno = this.array[this.tope];
        }
        return retorno;
    }
    
    //es vacia
    public boolean esVacia(){
        boolean retorno = false;
        if(this.tope < 0){
            retorno = true;
        }
        return retorno;
    }
    
    //vaciar
    public void vaciar(){
        int i = 0;
        while(i <= this.tope){
            this.array[i] = null;
            i++;
        }
        this.tope=-1;
    }
    
    //clone 
    @Override
    public Pila clone(){
        Pila clon = new Pila();
        clon.array = this.array.clone();
        clon.tope = this.tope;
        return clon;
    }
    //to string
    @Override
    public String toString(){
        String cadena = "Pila vacia";
        int i = 0;
        if(this.tope != -1){
            cadena = "";
        while(i <= this.tope){
            cadena = cadena+ " " + this.array[i];
            i++;
        }}
        return cadena;
    }
}
