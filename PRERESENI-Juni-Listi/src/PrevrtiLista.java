import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Преврти ја листата Problem 1 (0 / 0)`
Дадена е двострано поврзана листа чии што јазли содржат по еден природен број. 
Листата треба да се преврти т.ш. прво се превртуваат јазлите
кои содржат парни броеви, а потоа јазлите со непарни броеви. Листата се разгледува од назад. 
Право на користење имате само една дополнителна помошна двострано поврзана листа.
 
Во првиот ред од влезот е даден бројот на јазли во листа, потоа во вториот ред се дадени броевите 
од кои се составени јазлите по редослед во листата. На излез треба да се испечатат јазлите по редослед во превртената листа.
 
Забелешка: При реализација на задачите МОРА да се користат дадените структури, а не да се користат 
помошни структури како низи или сл.
 
Делумно решение: Задачата се смета за делумно решена доколку се поминати 7 тест примери.*/

/*
20
2 2 4 6 2 4 6 8 0 1 1 1 1 3 1 1 3 5 7 9
 
0 8 6 4 2 6 4 2 2 9 7 5 3 1 1 3 1 1 1 1
*/

public class PrevrtiLista {

	public static void main(String[] args) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());
		String []s = input.readLine().split(" ");
		DLL<Integer> lista = new DLL<Integer>();
		
		for(int i=0; i<N; i++) {
			lista.insertLast(Integer.parseInt(s[i]));
		}
		
		DLLNode<Integer> node = lista.getLast();
		DLL<Integer> rezultat =  new DLL<Integer>();
		boolean prvN = true;
		DLLNode<Integer>negativen = null;

		
		while(node != null) {
			
			if(node.element % 2 == 0){
				if(prvN) {
					rezultat.insertLast(node.element);
				}else {
					rezultat.insertBefore(node.element, negativen);
				}
				
			}else {
				if(prvN) {
					prvN = false;
					rezultat.insertLast(node.element);
					negativen = rezultat.getLast();
				}else {
					rezultat.insertLast(node.element);
				}
			}
			
			node = node.pred;
			
		}
		
	//System.out.println(lista.toString());
		System.out.println(rezultat.toString());
		

	}

}
 