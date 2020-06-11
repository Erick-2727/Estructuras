/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

/**
 *
 * @author Erick
 */
public class NewClass {
  public static void main(String args[]){
  ArbolBin a= new ArbolBin();
  a.insertar(1, 1,'I');
  a.insertar(3, 1,'I');
  a.insertar(4, 1,'D');
  a.insertar(7, 3,'I');
  a.insertar(9, 4,'I');
  a.insertar(2, 9,'I');
  
      System.out.println(a.ancestros(2));
  
  
  
  
  }
  
    
    
    
}
