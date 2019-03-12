import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Листа од листи Problem 3 (1 / 2)
 * Дадена е двојно поврзана листа од двојно поврзани листи. Да се најде сума на секоја од подлистите, а потоа
 * производ на овие суми
 * Влез: Број N кој кажува колку листи има Број М кој кажува колку елементи има во секоја листа 
 * Во следните М линии се податоците 1<=A<=1000за секоја од листите
 * Излез: Еден број што е производот на сумите од низите. Со седум децимали.
 
Пример влез: 3 4 1 2 3 4 2 3 4 5 6 7 8 9
Излез: 1400

vlez:
4
4
6 13 16 7 
7 23 9 11 
8 0 8 19 
6 6 9 11
izlez:
2352000
*/
public class ListaOdListi {
	
	public static void pecati(DLL<DLL<Integer>> lista) {
		DLLNode<DLL<Integer>> node = lista.getFirst();
		while(node != null) {
			DLLNode<Integer> snode = node.element.getFirst();
			while(snode != null) {
				System.out.print(snode.element+" ");
				snode = snode.succ;
			}
			System.out.print("  ");
			node = node.succ;
		}
	}
	
	public static int sumaIproizvod(DLL<DLL<Integer>> lista) {
		DLLNode<DLL<Integer>> node = lista.getFirst();
		int suma = 0;
		int proizvod = 1;
		while(node != null) {
			DLLNode<Integer> snode = node.element.getFirst();
			suma = 0;
			while(snode != null) {
				suma += snode.element;
				snode = snode.succ;
			}
			proizvod *= suma;
			node = node.succ;
		}
		
		return proizvod;
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());
		int M = Integer.parseInt(input.readLine());
		
		DLL<DLL<Integer>> lista = new DLL<DLL<Integer>>();
		DLL<Integer> tmp = new DLL<Integer>();
		
		
		for(int i=0; i<N; i++) {
			String [] s = input.readLine().split(" ");
			tmp = new DLL<Integer>();
			for(int j=0; j<M; j++) {
				tmp.insertLast(Integer.parseInt(s[j]));
			}
			
			lista.insertLast(tmp);
		}
		
		//pecati(lista);
		
		System.out.println(sumaIproizvod(lista));
		

	}

}
