import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Дадена е двојно поврзана листа со N јазли каде секој јазел содржи по еден карактер (буква). 
 * Да се провери дали двојно поврзаната листа е палиндром: односно ако ја изминете од почеток до крај 
 * и од крај до почеток, дали ќе добиете ист збор. Во првиот ред од влезот даден е бројот на јазли во
 * листата N, а во вториот ред се дадени броевите. На излез треба да се испечати 1 ако листата е палиндром,
 * -1 ако не е.*/
/*vlez:  
 * 5 
 * 1 2 3 1 2
 * izlez: -1 */
public class Palindorm {

	public static void main(String[] args) throws IOException{
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());
		
		String[]s = input.readLine().split(" ");
		DLL<String> lista = new DLL<String>();
		
		for(int i=0; i<N; i++) {
			lista.insertLast(s[i]);
		}
		
		DLLNode<String> node1 = lista.getFirst();
		DLLNode<String> node2 = lista.getLast();
		int isPalindrom = 1;
		while(node1 != null && node2 != null) {
			if(node1.element.compareTo(node2.element) != 0) {
				isPalindrom = -1;
				break;
			}
			
			node1 = node1.succ;
			node2 = node2.pred;
		}
		
		System.out.println(isPalindrom);
		
		
		

	}

}
