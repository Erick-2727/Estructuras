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
public class TestABB {

    public static void main(String args[]) {
        ArbolBB a = new ArbolBB();
        
        System.out.println("Trato de insertar 20 como raiz true---> " + a.insertar(20));
        System.out.println("Trato de insertar 10 true ---> " + a.insertar(10));
        System.out.println("Trato de insertar 26 true ---> " + a.insertar(26));
        System.out.println("Trato de insertar 15 true ---> " + a.insertar(15));
        System.out.println("Trato de insertar 12 true ---> " + a.insertar(12));
        System.out.println("Trato de insertar 22 true ---> " + a.insertar(22));
        System.out.println("Trato de insertar 27 true ---> " + a.insertar(27));
        System.out.println("Trato de insertar 28 true ---> " + a.insertar(28));
        System.out.println("Trato de insertar 8 true ---> " + a.insertar(8));
        System.out.println("Trato de insertar 10 repetido debe dar false --->" + a.insertar(10));
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("            ┌───[20]────┐             ");
        System.out.println("       ┌─[10]──┐       ┌─[26]─┐         ");
        System.out.println("      [8]   ┌─[15]    [22]       [27]─┐     ");
        System.out.println("           [12]                        [28]    ");
        System.out.println("toString devuelve -->" + "\n" + a.toString());
        
        System.out.println(a.amplitudArbol(20));
        
    }

}
