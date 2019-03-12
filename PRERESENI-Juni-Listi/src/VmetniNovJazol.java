import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Дадена е линеарно поврзана листа. Да се напише функција која пред секој елемент кој
во info полето има вредност x ќе вметне нов јазел со информација y. Како резултат
функцијата да врати колку нови јазли биле вметнати.
Пр. →3→4→7→6→4→7→3→2; 3; 1
→1→3→4→7→6→4→7→1→3→2; вметнати 2 нови јазли*/

public class VmetniNovJazol {

	public static void main(String[] args) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());
		String []s = input.readLine().split(" ");
		SLL<Integer>lista = new SLL<Integer>();
		
		for(int i=0; i<N; i++) {
			lista.insertLast(Integer.parseInt(s[i]));
		}
		
		System.out.println("Vnesi vrednost x: ");
		int x = Integer.parseInt(input.readLine());
		
		System.out.println("Vnesi vrednost y: ");
		int y = Integer.parseInt(input.readLine());
		
		
		SLLNode<Integer> node = lista.getFirst();
		while(node != null) {
			if(node.element.equals(x)) {
				lista.insertBefore(y, node);
			}
			
			node = node.succ;
		}
		
		System.out.println(lista.toString());
	}

}
