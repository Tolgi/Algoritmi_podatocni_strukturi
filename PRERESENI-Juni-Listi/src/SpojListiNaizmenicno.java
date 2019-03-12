import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Дадени се две еднострано поврзани листи чии што јазли содржат по еден природен број. 
 * Треба да се спојат двете листи во една резултантна на тој начин што наизменично прво ќе се додаваат
 * првите два јазли од првата листа во резултантната, па првите два од втората листа, па следните два
 * од првата, па следните два од втората итн. Јазлите што ќе останат треба да се додадат на крај во 
 * резултантната листа, прво оние што останале од првата листа, потоа оние што останале од втората листа.
 * Во првиот ред од влезот се дадени броевите од кои се составени јазлите по редослед во првата листа, 
 * а во вториот ред броевите од кои се составени јазлите по редослед во втората листа. На излез треба да
 * се испечатат јазлите по редослед во резултантната споена листа.
 * Забелешка: Да се креира податочна структура еднострано поврзана листа и истата да се искористи во задачата.*/

public class SpojListiNaizmenicno {
	
	public static void main(String [] args) throws IOException{
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N1 = Integer.parseInt(input.readLine());
		String[] s = input.readLine().split(" ");
		SLL<Integer>lista1 = new SLL<Integer>();
		
		for(int i=0; i<N1; i++) {
			lista1.insertLast(Integer.parseInt(s[i]));
		}
		
		
		int N2 = Integer.parseInt(input.readLine());
		String[] s2 = input.readLine().split(" ");
		SLL<Integer>lista2 = new SLL<Integer>();
		
		for(int i=0; i<N2; i++) {
			lista2.insertLast(Integer.parseInt(s2[i]));
		}
		
		SLLNode<Integer> node1 = lista1.getFirst();
		SLLNode<Integer> node2 = lista2.getFirst();
		SLL<Integer> result = new SLL<Integer>();
		
		
		while((node1.succ!= null) && (node2.succ != null)) {
				result.insertLast(node1.element);
				result.insertLast(node1.succ.element);
				result.insertLast(node2.element);
				result.insertLast(node2.succ.element);

				if(node1.succ.succ != null) {
					node1 = node1.succ.succ;
				}else {
					node1 = null;
				}
				
				if(node2.succ.succ != null) {
					node2 = node2.succ.succ;
				}else {
					node2 = null;
				}
				
				if(node1 == null || node1 == null) {
					break;
				}
				
		
		}
		

			while(node1 != null) {
				result.insertLast(node1.element);
				node1 = node1.succ;
			}
		
		
		
			while(node2 != null) {
				result.insertLast(node2.element);
				node2 = node2.succ;
			}
		
		
		System.out.println(result.toString());
		
	}

}
