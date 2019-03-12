import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Vlez:
 * 2 4 1 0 6 5 3 9 2 
 * Izlez:
 * 2 2 4 9 1 3 0 5 6 */

public class Kolokviumska2017 {
	
	public static SLLNode<Integer> getLast(SLL<Integer> lista){
		SLLNode<Integer> node = lista.getFirst();
		while(node.succ != null) {
			node = node.succ;
		}
		
		return node;
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());
		String []s = input.readLine().split(" ");
		SLL<Integer> lista = new SLL<Integer>();
		for(int i = 0; i<N; i++) {
			lista.insertLast(Integer.parseInt(s[i]));
		}
		
		SLLNode<Integer> node = lista.getFirst();
		SLLNode<Integer> last = null;
		
		while(node.succ != null) {
			last = getLast(lista);
			lista.insertAfter(last.element, node);
			lista.delete(last);
			
			if(node.succ.succ != null) {
				node = node.succ.succ;
			}else {
				node = node.succ;
			}

		}
		
		System.out.println(lista.toString());
	}

}
