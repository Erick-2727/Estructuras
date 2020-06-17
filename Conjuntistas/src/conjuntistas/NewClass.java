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

    public static void main(String args[]) {
        ArbolBB a = new ArbolBB();
        ArbolBB b = new ArbolBB();
        ArbolBB c = new ArbolBB();
        System.out.println("Checkeo si es vacio debe dar true---> " + a.esVacio());
        System.out.println("");
        System.out.println("Pruebas con el arbol vacio");
        System.out.println("");
        System.out.println("Obtener elementos minimos y maximos con arbol vacio");
        System.out.println("");
        System.out.println("Trato de obtener el minimo elemento de un arbol vacio debe dar false---> " + a.minimoElem() != null);
        System.out.println("Trato de obtener el maximo elemento de un arbol vacio debe dar false---> " + a.maximoElem() != null);
        System.out.println("");
        System.out.println("Tratar de eliminar en arbol vacio");
        System.out.println("");
        System.out.println("Trato de eliminar con arbol vacio debe dar false---> " + a.eliminar(12));
        System.out.println("Trato de eliminar  el maximo elemento de un arbol vacio debe dar false---> " + a.eliminarMax());
        System.out.println("Trato de eliminar  el minimo elemento de un arbol vacio debe dar false---> " + a.eliminarMax());
        System.out.println("Mostrar arbol vacio debe dar Arbol vacio---> " + a.toString());
        System.out.println("");
        System.out.println("Tratar de Listar en arbol vacio");
        System.out.println("");
        System.out.println("Listar con Arbol vacio debe dar Lista vacia ---> " + a.listar().toString());
        System.out.println("Listar con 3 y null  con Arbol vacio debe dar Lista vacia ---> " + a.listarRango(3, null).toString());
        System.out.println("Listar con null y 3  con Arbol vacio debe dar Lista vacia ---> " + a.listarRango(null, 3).toString());
        System.out.println("Listar con null y null  con Arbol vacio debe dar Lista vacia ---> " + a.listarRango(null, null).toString());
        System.out.println("Listar con 3 y 6  con Arbol vacio debe dar Lista vacia ---> " + a.listarRango(3, 6).toString());
        System.out.println("!!!!!Buscar!!!!!");
        System.out.println("Busco elemento 10  con Arbol vacio debe dar false---> " + a.pertenece(10));
        System.out.println("Busco null  con Arbol vacio debe dar false---> " + a.pertenece(null));
        System.out.println("\n");
        System.out.println("");
        System.out.println("Inserciones");
        System.out.println("");
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
        b = a.clone();
        c = b.clone();
        System.out.println("");
        System.out.println("Metodos eliminar");
        System.out.println("");
        System.out.println("Elimino 12 caso 1 debe dar true--->" + a.eliminar(12));
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("            ┌───[20]────┐             ");
        System.out.println("       ┌─[10]──┐       ┌─[26]─┐         ");
        System.out.println("      [8]       [15]    [22]     [27]─┐     ");
        System.out.println("                                     [28]    ");
        System.out.println("toString devuelve -->" + "\n" + a.toString());
        System.out.println("Elimino 27 caso 2 debe dar true--->" + a.eliminar(27));
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("            ┌───[20]────┐             ");
        System.out.println("       ┌─[10]──┐       ┌─[26]─┐         ");
        System.out.println("      [8]       [15]    [22]     [28]     ");
        System.out.println("toString devuelve -->" + "\n" + a.toString());
        System.out.println("Elimino 10 caso 3 debe dar true--->" + a.eliminar(10));
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("            ┌───[20]────┐             ");
        System.out.println("       ┌─[15]           ┌─[26]─┐         ");
        System.out.println("      [8]               [22]     [28]     ");
        System.out.println("toString devuelve -->" + "\n" + a.toString());
        System.out.println("Elimino 20 caso 3 debe dar true--->" + a.eliminar(20));
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("            ┌───[22]────┐           ");
        System.out.println("       ┌─[15]               [26]─┐     ");
        System.out.println("      [8]                         [28]    ");
        System.out.println("toString devuelve -->" + "\n" + a.toString());
        System.out.println("Elimino 26 caso 2 debe dar  true---> " + a.eliminar(26));
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("            ┌───[22]────┐        ");
        System.out.println("       ┌─[15]               [28]      ");
        System.out.println("      [8]                              ");
        System.out.println("toString devuelve -->" + "\n" + a.toString());
        System.out.println("Elimino 15  caso 2 debe dar  true---> " + a.eliminar(15));
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("            ┌───[22]────┐        ");
        System.out.println("           [8]               [28]      ");
        System.out.println("toString devuelve -->" + "\n" + a.toString());
        System.out.println("Elimino 22  caso 3 debe dar  true---> " + a.eliminar(22));
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("            ┌───[28]        ");
        System.out.println("           [8]                 ");
        System.out.println("toString devuelve -->" + "\n" + a.toString());
         System.out.println("Elimino 28  caso 2 debe dar  true---> " + a.eliminar(28));
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("            [8]        ");
        System.out.println("toString devuelve -->" + "\n" + a.toString());
        System.out.println("Verifico clone debe dar :");
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("            ┌───[5]────┐             ");
        System.out.println("           [2]──┐     ┌─[7]─┐         ");
        System.out.println("             ┌─[4]    [6]     [9]─┐     ");
        System.out.println("            [3]                    [10]    ");
        System.out.println("toString devuelve -->" + "\n" + b.toString());
        System.out.println("Elimino elemento minimo  debe dar  true--->" + b.eliminarMin());
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("           ┌───[5]────┐             ");
        System.out.println("       ┌─[4]          ┌─[7]─┐         ");
        System.out.println("      [3]             [6]      [9]─┐     ");
        System.out.println("                                  [10]    ");
        System.out.println("toString devuelve -->" + "\n" + b.toString());
        System.out.println("Elimino elemento maximo  debe dar  true--->" + b.eliminarMax());
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("           ┌───[5]────┐             ");
        System.out.println("       ┌─[4]          ┌─[7]─┐         ");
        System.out.println("      [3]             [6]      [9]        ");
        System.out.println("toString devuelve -->" + "\n" + b.toString());
        System.out.println("*       Metodos busqueda        *");
        System.out.println("Arbol de busquedas");
        System.out.println("           ┌───[5]────┐             ");
        System.out.println("       ┌─[4]          ┌─[7]─┐         ");
        System.out.println("      [3]             [6]      [9]        ");
        System.out.println("busco elemento maximo  debe dar 9 --->" + (b.maximoElem().compareTo(9) == 0));
        System.out.println("busco elemento minimo  debe dar 4 --->" + (b.minimoElem().compareTo(3) == 0));
        System.out.println("busco elemento 7 debe dar true --->" + b.pertenece(7));
        System.out.println("busco elemento 6 debe dar true --->" + b.pertenece(6));
        System.out.println("busco elemento 3 debe dar true --->" + b.pertenece(3));
        System.out.println("busco null debe dar  false--->" + ((b.pertenece(null))));
        System.out.println("busco raiz 5 debe dar true --->" + b.pertenece(5));

        System.out.println("*       Metodos de lista        *");

        System.out.println("Arbol de prueba");
        System.out.println("            ┌───[5]────┐             ");
        System.out.println("           [2]──┐     ┌─[7]─┐         ");
        System.out.println("             ┌─[4]    [6]     [9]─┐     ");
        System.out.println("            [3]                    [10]    ");
        System.out.println("Metodo Listar debe dar [2,3,4,5,6,7,9,10] --->" + c.listar().toString());
        System.out.println("Metodo Listar Rango de [2,9] debe dar [2,3,4,5,6,7,9] --->" + c.listarRango(2, 9).toString());
        System.out.println("Metodo Listar Rango de [4,6] debe dar [4,5,6] --->" + c.listarRango(4, 6).toString());
        System.out.println("Metodo Listar Rango de [3,10] debe dar [3,4,5,6,7,9,10] --->" + c.listarRango(3, 10).toString());
        System.out.println("Metodo Listar Rango de [6,4] debe dar Lista vacia --->" + c.listarRango(6, 4).toString());
        System.out.println("Metodo Listar Rango de [null,7] debe dar Lista vacia --->" + c.listarRango(null, 7).toString());
        System.out.println("Metodo Listar Rango de [2,null] debe dar Lista vacia --->" + c.listarRango(2, null).toString());
        System.out.println("Metodo Listar Rango de [null,null] debe dar Lista vacia --->" + c.listarRango(null, null).toString());
        System.out.println("Metodo Listar Rango de [30,110] debe dar Lista vacia --->" + c.listarRango(30, 110).toString());
        System.out.println("Metodo Listar Rango de [5,5] debe dar [5] --->" + c.listarRango(5, 5).toString());

    }

}
