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
public class Conjuntistas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArbolHeap a = new ArbolHeap();

        a.insertar(2);
        a.insertar(10);
        a.insertar(3);
        a.insertar(7);
        a.insertar(11);
        a.insertar(5);
        a.insertar(9);
        a.tostring();
        System.out.println("ingreso 3,6,1");
        a.insertar(3);
        a.insertar(6);
        a.insertar(1);
        a.tostring();
        a.eliminar();
        a.tostring();
    }

}
