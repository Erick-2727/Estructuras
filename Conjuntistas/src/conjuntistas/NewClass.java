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
public class NewClass {

    public static void main(String[] args) {
        ABB a = new ABB();

        a.insertar(15);
        a.insertar(11);
        a.insertar(5);
        a.insertar(25);
        a.insertar(27);
        a.insertar(8);
        a.insertar(14);
        System.out.println(a.toString());
        
        System.out.println(a.pertenece(65));
        System.out.println(a.pertenece(10));
    }

}
