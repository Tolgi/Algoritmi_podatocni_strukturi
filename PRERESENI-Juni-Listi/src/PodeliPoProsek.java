import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Дадена е еднострано поврзана листа чии што јазли содржат по еден природен број.
 *  Листата треба да се подели на две резултантни листи, т.ш. во првата листа треба
 *   да се сместат сите јазли кои содржат броеви помали или еднакви на просекот на листата 
 *   (просек на листа претставува математички просек од сите природни броеви кои се јавуваат
 *    во листата), а во втората сите јазли кои содржат броеви поголеми од просекот на листата.
 *     Јазлите во резултантните листи се додаваат според редоследот по кој се појавуваат во
 *      дадената листа.
/*Во првиот ред од влезот е даден бројот на јазли во листата, а во вториот ред се дадени броевите
 *  од кои се составени јазлите по редослед во листата. Во првиот ред од излезот треба да се 
 *  испечатат јазлите по редослед од првата резултантна листа (броеви помали или еднакви на
 *   просекот на листата), во вториот ред од втората (броеви поголеми од просекот на листата) .
 */
/*Име на класа (за Java): PodeliSporedProsek
/*Делумно решение: Задачата се смета за делумно решена доколку се поминати 7 тест примери.
/*Забелешка: При реализација на задачите МОРА да се користат дадените структури, а не да користат 
 *помошни структури како низи или сл.*/

public class PodeliPoProsek {

	public static void main(String[] args) throws IOException{
		
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(input.readLine());
		String []s = input.readLine().split(" ");
		SLL<Integer> lista = new SLL<Integer>();
		
		for(int i=0; i<N; i++) {
			lista.insertLast(Integer.parseInt(s[i]));
		}
		
		SLLNode<Integer> node = lista.getFirst();
		int zbir = 0;
		double prosek = 0;
		while(node != null) {
			
			zbir += node.element;
			node = node.succ;
		}
		
		prosek = zbir*(1.0) / N;
		SLL<Integer> lpomali = new SLL<Integer>();
		SLL<Integer> lpogolemi = new SLL<Integer>();
		
		node = lista.getFirst();
		while(node != null) {
			if(node.element <= prosek) {
				lpomali.insertLast(node.element);
			}else {
				lpogolemi.insertLast(node.element);
			}
			
			node = node.succ;
		}
		
		System.out.println(lpomali.toString());
		System.out.println(lpogolemi.toString());

	}

}
