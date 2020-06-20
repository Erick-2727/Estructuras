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
        System.out.println("Trato de obtener el minimo elemento de un arbol vacio debe dar false---> " + (a.minimoElem() != null));
        System.out.println("Trato de obtener el maximo elemento de un arbol vacio debe dar false---> " + (a.maximoElem() != null));
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
        System.out.println("Listar con 3 y 6  con Arbol vacio debe dar Lista vacia ---> " + a.listarRango(3, 6).toString());
        System.out.println("!!!!!Buscar!!!!!");
        System.out.println("Busco elemento 10  con Arbol vacio debe dar false---> " + a.pertenece(10));
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
        System.out.println("Elimino 8  caso 2 debe dar  true---> " + a.eliminar(8));
        System.out.println("Arbol resultante debe dar  Arbol vacio ---> " + a.toString());
        System.out.println("");
        System.out.println("Verifico clone debe dar :");
        System.out.println("");
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("            ┌───[20]────┐             ");
        System.out.println("       ┌─[10]──┐       ┌─[26]─┐         ");
        System.out.println("      [8]   ┌─[15]    [22]       [27]─┐     ");
        System.out.println("           [12]                        [28]    ");
        System.out.println("toString devuelve -->" + "\n" + b.toString());
        System.out.println("Elimino elemento minimo  debe dar  true---> " + b.eliminarMin());
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("            ┌───[20]────┐                ");
        System.out.println("            [10]──┐       ┌─[26]─┐        ");
        System.out.println("                ┌─[15]    [22]     [27]─┐    ");
        System.out.println("               [12]                      [28]    ");
        System.out.println("toString devuelve -->" + "\n" + b.toString());
        System.out.println("Elimino elemento maximo  debe dar  true---> " + b.eliminarMax());
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("            ┌───[20]────┐            ");
        System.out.println("            [10]──┐       ┌─[26]─┐    ");
        System.out.println("                ┌─[15]    [22]     [27]  ");
        System.out.println("               [12]                       ");
        System.out.println("toString devuelve -->" + "\n" + b.toString());
        System.out.println("Elimino elemento minimo  debe dar  true---> " + b.eliminarMin());
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("            ┌───[20]────┐            ");
        System.out.println("       ┌─[15]           ┌─[26]─┐    ");
        System.out.println("      [12]              [22]     [27]  ");
        System.out.println("toString devuelve -->" + "\n" + b.toString());
        System.out.println("Elimino elemento minimo  debe dar  true---> " + b.eliminarMin());
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("            ┌───[20]────┐            ");
        System.out.println("          [12]           ┌─[26]─┐    ");
        System.out.println("                        [22]     [27]  ");
        System.out.println("toString devuelve -->" + "\n" + b.toString());
        System.out.println("Elimino elemento minimo  debe dar  true---> " + b.eliminarMin());
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("             [20]────┐            ");
        System.out.println("                   ┌─[26]─┐        ");
        System.out.println("                 [22]      [27]       ");
        System.out.println("toString devuelve -->" + "\n" + b.toString());
        System.out.println("*       Metodos busqueda        *");
        System.out.println("Arbol de busquedas");
        System.out.println("             [20]────┐            ");
        System.out.println("                   ┌─[26]─┐        ");
        System.out.println("                 [22]      [27]       ");
        System.out.println("busco elemento maximo  debe dar 27 ---> " + (b.maximoElem().compareTo(27) == 0));
        System.out.println("busco elemento minimo  debe dar 20 ---> " + (b.minimoElem().compareTo(20) == 0));
        System.out.println("busco elemento 26 debe dar true ---> " + b.pertenece(26));
        System.out.println("busco elemento 22 debe dar true ---> " + b.pertenece(22));
        System.out.println("busco elemento 27 debe dar true ---> " + b.pertenece(27));
        System.out.println("busco null debe dar  false---> " + ((b.pertenece(null))));
        System.out.println("busco la raiz 20 debe dar true ---> " + b.pertenece(20));

        System.out.println("*       Metodos de lista        *");

        System.out.println("Arbol de prueba");
        System.out.println("            ┌───[20]────┐             ");
        System.out.println("       ┌─[10]──┐       ┌─[26]─┐         ");
        System.out.println("      [8]   ┌─[15]    [22]       [27]─┐     ");
        System.out.println("           [12]                        [28]    ");
        System.out.println("Metodo Listar debe dar [8,10,12,15,20,22,26,27,28] --->" + c.listar().toString());
        System.out.println("Metodo Listar Rango de [12,26] debe dar [12,15,20,22,26] --->" + c.listarRango(12, 26).toString());
        System.out.println("Metodo Listar Rango de [8,15] debe dar [8,10,12,15] --->" + c.listarRango(8, 15).toString());
        System.out.println("Metodo Listar Rango de [10,28] debe dar [10,12,15,20,22,26,27,28] --->" + c.listarRango(10, 28).toString());
        System.out.println("Metodo Listar Rango de [28,12] debe dar Lista vacia --->" + c.listarRango(6, 4).toString());
        System.out.println("Metodo Listar Rango de [30,110] debe dar Lista vacia --->" + c.listarRango(30, 110).toString());
        System.out.println("Metodo Listar Rango de [12,12] debe dar [12] --->" + c.listarRango(12, 12).toString());

    }

}
