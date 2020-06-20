package conjuntistas;

import conjuntistas.ArbolBB;

public class TestABBJessi {
	static String sOk = "[ OK! ]", sErr = "[ ERROR ]";
	public static void main(String[] args) {
		ArbolBB a = new ArbolBB();
		ArbolBB b = new ArbolBB();
		System.out.println(
				"**********************************\n  PRUEBO METODOS CON ARBOL VACIO\n**********************************");
		System.out.println("toString: " + a.toString());
		System.out.println(
				"Verifico si 9 pertenece en arbol vacio: " + "\tSE ESPERA "
						+ sErr + " --->  " + (a.pertenece(9) ? sOk : sErr));
		System.out.println("Listar de menor a mayor: " + a.listar());
		System.out
				.println("listar por rango de 0, 81: " + a.listarRango(0, 81));
		System.out.println("Elemento MINIMO: " + a.minimoElem());
		System.out.println("Elemento MAXIMO: " + a.maximoElem());
		System.out
				.println("Verifico si el arbol esta vacio: " + "\t\tSE ESPERA "
						+ sOk + " --->  " + (a.esVacio() ? sOk : sErr));
		System.out.println("Elimino 15 en arbol vacio: " + "\t\t\tSE ESPERA "
				+ sErr + " --->  " + (a.eliminar(15) ? sOk : sErr));
		System.out.println("Eliminar minimo:  " + "\t\t\t\tSE ESPERA " + sErr
				+ " --->  " + (a.eliminarMin() ? sOk : sErr));
		System.out.println("Eliminar maximo:  " + "\t\t\t\tSE ESPERA " + sErr
				+ " --->  " + (a.eliminarMax() ? sOk : sErr));
		System.out.println("Intento vaciar arbol vacio");
		a.vaciar();
		System.out.println("toString: " + a.toString());
		System.out.println(
				"\n**********************************\n\tINSERSION \n**********************************");
		System.out.println("Insertar 32: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (a.insertar(32) ? sOk : sErr));
		System.out.println("Insertar 9:  " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (a.insertar(9) ? sOk : sErr));
		System.out.println("Insertar 5:  " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (a.insertar(5) ? sOk : sErr));
		System.out.println("Insertar 19: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (a.insertar(19) ? sOk : sErr));
		System.out.println("Insertar 8:  " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (a.insertar(8) ? sOk : sErr));
		System.out.println("Insertar 17: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (a.insertar(17) ? sOk : sErr));
		System.out.println("Insertar 23: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (a.insertar(23) ? sOk : sErr));
		System.out.println("Insertar 56: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (a.insertar(56) ? sOk : sErr));
		System.out.println("Insertar 43: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (a.insertar(43) ? sOk : sErr));
		System.out.println("Insertar 41: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (a.insertar(41) ? sOk : sErr));
		System.out.println("Insertar 53: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (a.insertar(53) ? sOk : sErr));
		System.out.println("Insertar 72: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (a.insertar(72) ? sOk : sErr));
		System.out.println("Insertar 64: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (a.insertar(64) ? sOk : sErr));
		System.out.println("Inserto elemento minimo 1:  " + "\t\tSE ESPERA "
				+ sOk + " --->  " + (a.insertar(1) ? sOk : sErr));
		System.out.println("Inserto elemento maximo 80: " + "\t\tSE ESPERA "
				+ sOk + " --->  " + (a.insertar(80) ? sOk : sErr));
		System.out.println("Inserto elemento repetido 80: " + "\t\tSE ESPERA "
				+ sErr + " --->  " + (a.insertar(80) ? sOk : sErr));
		System.out.println("\nTiene que mostrar:\n");
		System.out.println("            +------------(32)------------+");
		System.out.println("     +-----(9)-----+             +-----(56)-----+");
		System.out.println(
				" +--(5)--+    +--(19)--+     +--(43)--+     +--(72)--+");
		System.out.println(
				"(1)     (8) (17)      (23) (41)      (53) (64)      (80)");
		System.out.println("\nMuestra: ");
		System.out.println(a.toString());
		System.out.println("\nListar de menor a mayor:   " + a.listar());
		System.out.println("Elemento MINIMO: " + a.minimoElem());
		System.out.println("Elemento MAXIMO: " + a.maximoElem());
		System.out
				.println("Verifico si el arbol esta vacio: " + "\t\tSE ESPERA "
						+ sErr + " --->  " + (a.esVacio() ? sOk : sErr));
		System.out.println(
				"\n**********************************\n\tPERTENECE\n**********************************");
		System.out.println("Verifico si raiz 32 pertenece: " + "\t\tSE ESPERA "
				+ sOk + " --->  " + (a.pertenece(32) ? sOk : sErr));
		System.out
				.println("Verifico si el minimo 1 pertenece: " + "\tSE ESPERA "
						+ sOk + " --->  " + (a.pertenece(1) ? sOk : sErr));
		System.out.println("Verifico si maximo 80 pertenece: " + "\tSE ESPERA "
				+ sOk + " --->  " + (a.pertenece(80) ? sOk : sErr));
		System.out.println("Verifico si 9  pertenece: " + "\t\tSE ESPERA " + sOk
				+ " --->  " + (a.pertenece(9) ? sOk : sErr));
		System.out.println("Verifico si 56 pertenece: " + "\t\tSE ESPERA " + sOk
				+ " --->  " + (a.pertenece(56) ? sOk : sErr));
		System.out.println("Verifico si 5  pertenece: " + "\t\tSE ESPERA " + sOk
				+ " --->  " + (a.pertenece(5) ? sOk : sErr));
		System.out.println("Verifico si 19 pertenece: " + "\t\tSE ESPERA " + sOk
				+ " --->  " + (a.pertenece(19) ? sOk : sErr));
		System.out.println("Verifico si 8  pertenece: " + "\t\tSE ESPERA " + sOk
				+ " --->  " + (a.pertenece(8) ? sOk : sErr));
		System.out.println("Verifico si 17 pertenece: " + "\t\tSE ESPERA " + sOk
				+ " --->  " + (a.pertenece(17) ? sOk : sErr));
		System.out.println("Verifico si 23 pertenece: " + "\t\tSE ESPERA " + sOk
				+ " --->  " + (a.pertenece(23) ? sOk : sErr));
		System.out.println("Verifico si 41 pertenece: " + "\t\tSE ESPERA " + sOk
				+ " --->  " + (a.pertenece(41) ? sOk : sErr));
		System.out.println("Verifico si 43 pertenece: " + "\t\tSE ESPERA " + sOk
				+ " --->  " + (a.pertenece(43) ? sOk : sErr));
		System.out.println("Verifico si 53 pertenece: " + "\t\tSE ESPERA " + sOk
				+ " --->  " + (a.pertenece(53) ? sOk : sErr));
		System.out.println("Verifico si 72 pertenece: " + "\t\tSE ESPERA " + sOk
				+ " --->  " + (a.pertenece(72) ? sOk : sErr));
		System.out.println("Verifico si 64 pertenece: " + "\t\tSE ESPERA " + sOk
				+ " --->  " + (a.pertenece(64) ? sOk : sErr));
		System.out.println("Verifico si elemento inexistente 15 pertenece: "
				+ "\t\tSE ESPERA " + sErr + " --->  "
				+ (a.pertenece(15) ? sOk : sErr));
		System.out.println(
				"\n**********************************\n\tLISTAR POR RANGO\n**********************************");
		System.out
				.println("listar por rango de 0, 81: " + a.listarRango(0, 81));
		System.out
				.println("listar por rango de 1, 80: " + a.listarRango(1, 80));
		System.out
				.println("listar por rango de 80, 1: " + a.listarRango(80, 1));

		System.out
				.println("listar por rango de 1, 32: " + a.listarRango(1, 32));
		System.out
				.println("listar por rango de 32,80: " + a.listarRango(32, 80));
		System.out
				.println("listar por rango de 17,72: " + a.listarRango(17, 72));
		System.out
				.println("listar por rango de 5, 43: " + a.listarRango(5, 43));
		System.out.println(
				"\n**********************************\n\t\tCLON\n**********************************");
		b = a.clone();
		System.out.println("Insertar 3:  " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (b.insertar(3) ? sOk : sErr));
		System.out.println("Insertar 0:  " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (b.insertar(0) ? sOk : sErr));
		System.out.println("Insertar 81: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (b.insertar(81) ? sOk : sErr));
		System.out.println("Insertar 31: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (b.insertar(31) ? sOk : sErr));
		System.out.println("~~~~~~~~~~\nClon:\n~~~~~~~~~~");
		System.out.println(
				"                +---------------(32)---------------+");
		System.out.println(
				"         +-----(9)-----+                   +-----(56)-----+");
		System.out.println(
				"    +--(5)--+    +--(19)--+            +--(43)--+     +--(72)--+");
		System.out.println(
				" +-(1)-+   (8) (17)      (23)-+      (41)      (53) (64)      (80)-+");
		System.out.println(
				"(0)   (3)                     (31)                                (81)");
		System.out.println("\nClon: " + b.toString());
		System.out.println("\n~~~~~~~~~~\nOriginal: \n~~~~~~~~~~");
		System.out.println("            +------------(32)------------+");
		System.out.println("     +-----(9)-----+             +-----(56)-----+");
		System.out.println(
				" +--(5)--+    +--(19)--+     +--(43)--+     +--(72)--+");
		System.out.println(
				"(1)     (8) (17)      (23) (41)      (53) (64)      (80)");
		System.out.println("\nOriginal: " + a.toString());
		System.out.println(
				"\nVerifico si 31 pertenece al clon: " + "\t\tSE ESPERA " + sOk
						+ " --->  " + (b.pertenece(31) ? sOk : sErr));
		System.out.println("Listar de menor a mayor: " + b.listar());
		System.out.println(
				"listar por rango de -1, 82: " + b.listarRango(-1, 82));
		System.out.println("Elemento MINIMO: " + b.minimoElem());
		System.out.println("Elemento MAXIMO: " + b.maximoElem());
		System.out.println("Verifico si el clon esta vacio: " + "\t\tSE ESPERA "
				+ sErr + " --->  " + (b.esVacio() ? sOk : sErr));
		System.out.println("Intento vaciar arbol original");
		a.vaciar();
		System.out.println("\nClon: " + b.toString());
		System.out.println("\nOriginal: " + a.toString());
		a = b.clone();
		System.out.println(
				"\n**********************************\n\tELIMINAR\n**********************************");
		System.out
				.println("\n~~~~~~~~~~~~~~~\nClon original: \n~~~~~~~~~~~~~~~");
		System.out.println(
				"                +---------------(32)---------------+");
		System.out.println(
				"         +-----(9)-----+                   +-----(56)-----+");
		System.out.println(
				"    +--(5)--+    +--(19)--+            +--(43)--+     +--(72)--+");
		System.out.println(
				" +-(1)-+   (8) (17)      (23)-+      (41)      (53) (64)      (80)-+");
		System.out.println(
				"(0)   (3)                     (31)                                (81)");
		System.out.println(
				"\nElimino elemento inexistente 15:  " + "\t\tSE ESPERA " + sErr
						+ " --->  " + (b.eliminar(15) ? sOk : sErr));
		System.out
				.println("\n~~~~~~~~~~~~~~~\nElimino hojas: \n~~~~~~~~~~~~~~~");
		System.out.println("Eliminar 3:  " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (b.eliminar(3) ? sOk : sErr));
		System.out.println("Eliminar 0:  " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (b.eliminar(0) ? sOk : sErr));
		System.out.println("Eliminar 81: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (b.eliminar(81) ? sOk : sErr));
		System.out.println("Eliminar 31: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (b.eliminar(31) ? sOk : sErr));
		System.out.println("Eliminar 8:  " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (b.eliminar(8) ? sOk : sErr));
		System.out.println("Eliminar 17: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (b.eliminar(17) ? sOk : sErr));
		System.out.println("Eliminar 41: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (b.eliminar(41) ? sOk : sErr));
		System.out.println("Eliminar 53: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (b.eliminar(53) ? sOk : sErr));
		System.out.println("Eliminar 64: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (b.eliminar(64) ? sOk : sErr));
		System.out.println(
				"                +---------------(32)---------------+");
		System.out.println(
				"         +-----(9)-----+                   +-----(56)-----+");
		System.out.println(
				"    +--(5)          (19)--+               (43)           (72)--+");
		System.out.println(
				"   (1)                   (23)                                 (80)");
		System.out.println("\ntoString: " + b.toString());
		System.out.println(
				"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nElimino los que tengan un hijo: \n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Inserto 41:  " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (b.insertar(41) ? sOk : sErr));
		System.out.println("Eliminar 5:  " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (b.eliminar(5) ? sOk : sErr));
		System.out.println("Eliminar 19: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (b.eliminar(19) ? sOk : sErr));
		System.out.println("Eliminar 72: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (b.eliminar(72) ? sOk : sErr));
		System.out.println("Eliminar 43: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (b.eliminar(43) ? sOk : sErr));
		System.out.println(
				"                +---------------(32)---------------+");
		System.out.println(
				"         +-----(9)-----+                   +-----(56)-----+");
		System.out.println(
				"       (1)          (23)                  (41)           (80)");
		System.out.println("\ntoString: " + b.toString());
		System.out.println(
				"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nElimino los que tengan dos hijo: \n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\n~~~~~~~~~~~~~~~\nOriginal: \n~~~~~~~~~~~~~~~");
		System.out.println(
				"                +---------------(32)---------------+");
		System.out.println(
				"         +-----(9)-----+                   +-----(56)-----+");
		System.out.println(
				"    +--(5)--+    +--(19)--+            +--(43)--+     +--(72)--+");
		System.out.println(
				" +-(1)-+   (8) (17)      (23)-+      (41)      (53) (64)      (80)-+");
		System.out.println(
				"(0)   (3)                     (31)                                (81)");
		System.out.println("\nEliminar 1: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (a.eliminar(1) ? sOk : sErr) + "\n");
		System.out.println(
				"                +---------------(32)---------------+");
		System.out.println(
				"         +-----(9)-----+                   +-----(56)-----+");
		System.out.println(
				"    +--(5)--+    +--(19)--+            +--(43)--+     +--(72)--+");
		System.out.println(
				" +-(3)     (8) (17)      (23)-+      (41)      (53) (64)      (80)-+");
		System.out.println(
				"(0)                           (31)                                (81)");
		System.out.println("\ntoString: " + a.toString());
		System.out.println("\nElimino 5:  " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (a.eliminar(5) ? sOk : sErr));
		System.out.println("Elimino 19: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (a.eliminar(19) ? sOk : sErr));
		System.out.println("Elimino 43: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (a.eliminar(43) ? sOk : sErr));
		System.out.println("Elimino 72: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (a.eliminar(72) ? sOk : sErr) + "\n");
		System.out.println(
				"                +---------------(32)---------------+");
		System.out.println(
				"         +-----(9)-----+                   +-----(56)-----+");
		System.out.println(
				"    +--(8)       +--(23)--+            +--(53)        +--(80)--+");
		System.out.println(
				" +-(3)         (17)      (31)        (41)           (64)      (81)");
		System.out.println("(0)");
		System.out.println("\ntoString: " + a.toString());
		System.out.println("\nElimino 80: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (a.eliminar(80) ? sOk : sErr));
		System.out.println("Elimino 23: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (a.eliminar(23) ? sOk : sErr) + "\n");
		System.out.println(
				"                +---------------(32)---------------+");
		System.out.println(
				"         +-----(9)-----+                   +-----(56)-----+");
		System.out.println(
				"    +--(8)       +--(31)               +--(53)        +--(81)");
		System.out.println(
				" +-(3)         (17)                  (41)           (64)");
		System.out.println("(0)");
		System.out.println("\ntoString: " + a.toString());
		System.out.println("\nElimino  9: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (a.eliminar(9) ? sOk : sErr));
		System.out.println("Elimino 56: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (a.eliminar(56) ? sOk : sErr) + "\n");
		System.out.println(
				"                +---------------(32)---------------+");
		System.out.println(
				"         +-----(17)-----+                   +-----(64)-----+");
		System.out.println(
				"    +--(8)          (31)               +--(53)           (81)");
		System.out.println(" +-(3)                               (41)");
		System.out.println("(0)");
		System.out.println("\ntoString: " + a.toString());
		System.out.println("\nElimino 32: " + "\t\tSE ESPERA " + sOk + " --->  "
				+ (a.eliminar(32) ? sOk : sErr) + "\n");
		System.out.println(
				"                +---------------(41)---------------+");
		System.out.println(
				"         +-----(17)-----+                   +-----(64)-----+");
		System.out.println(
				"    +--(8)          (31)                  (53)           (81)");
		System.out.println(" +-(3)");
		System.out.println("(0)");
		System.out.println("\ntoString: " + a.toString());
		System.out.println(
				"\n**********************************\nELIMINAR MINIMO Y MAXIMO\n**********************************");
		System.out.println(
				"                +---------------(41)---------------+");
		System.out.println(
				"         +-----(17)-----+                   +-----(64)-----+");
		System.out.println(
				"    +--(8)          (31)                  (53)           (81)");
		System.out.println(" +-(3)");
		System.out.println("(0)");
		System.out.println(a.listar());
		System.out.println("\nEliminar minimo:  " + "\t\tSE ESPERA " + sOk
				+ " --->  " + (a.eliminarMin() ? sOk : sErr));
		System.out.println(a.listar());
		System.out.println("\nEliminar maximo:  " + "\t\tSE ESPERA " + sOk
				+ " --->  " + (a.eliminarMax() ? sOk : sErr));
		System.out.println(a.listar());
		System.out.println("\nEliminar minimo:  " + "\t\tSE ESPERA " + sOk
				+ " --->  " + (a.eliminarMin() ? sOk : sErr));
		System.out.println(a.listar());
		System.out.println("\nEliminar maximo:  " + "\t\tSE ESPERA " + sOk
				+ " --->  " + (a.eliminarMax() ? sOk : sErr));
		System.out.println(a.listar());
		System.out.println("\nEliminar maximo:  " + "\t\tSE ESPERA " + sOk
				+ " --->  " + (a.eliminarMax() ? sOk : sErr));
		System.out.println(a.listar());
		System.out.println("\nEliminar minimo:  " + "\t\tSE ESPERA " + sOk
				+ " --->  " + (a.eliminarMin() ? sOk : sErr));
		System.out.println("Eliminar minimo:  " + "\t\tSE ESPERA " + sOk
				+ " --->  " + (a.eliminarMin() ? sOk : sErr));
		System.out.println("Eliminar maximo:  " + "\t\tSE ESPERA " + sOk
				+ " --->  " + (a.eliminarMax() ? sOk : sErr));
		System.out.println(a.listar());
		System.out.println("\nEliminar minimo:  " + "\t\tSE ESPERA " + sOk
				+ " --->  " + (a.eliminarMin() ? sOk : sErr));
		System.out.println("Eliminar maximo:  " + "\t\tSE ESPERA " + sErr
				+ " --->  " + (a.eliminarMax() ? sOk : sErr));
		System.out.println(a.listar());
		System.out.println(
				"\n**********************************\nPRUEBO METODOS CON ELEMENTOS NULOS\n**********************************");
		System.out.println("toString: " + b.toString());
		System.out.println("Verifico si null pertenece: " + "\t\tSE ESPERA "
				+ sErr + " --->  " + (b.pertenece(null) ? sOk : sErr));
		System.out.println(
				"listar por rango de null, 80: " + b.listarRango(null, 80));
		System.out.println(
				"listar por rango de 1, null: " + b.listarRango(1, null));
		System.out.println(
				"listar por rango de null, null: " + b.listarRango(null, null));
		System.out.println("Elimino null: " + "\t\t\t\tSE ESPERA " + sErr
				+ " --->  " + (b.eliminar(100) ? sOk : sErr));
	}

}
