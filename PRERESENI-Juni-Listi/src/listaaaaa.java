import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class listaaaaa {

	public static void main(String[] args) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(input.readLine());
		String []s = input.readLine().split(" ");
		SLL<Integer> lista = new SLL<Integer>();
		for(int i = 0; i<N; i++) {
			lista.insertLast(Integer.parseInt(s[i]));
		}
		
		int MpatiZaBrisenje = Integer.parseInt(input.readLine());
		
		float brojac = 0;
		float dolzina = 0;
		SLLNode<Integer> node = lista.getFirst();
		for(int i=0; i<MpatiZaBrisenje; i++) {
			
			brojac = 0;
			node = lista.getFirst();
			while(node != null) {
				brojac ++;
				dolzina = (float) lista.length() / 2;
				if(dolzina == brojac) {
					if(node != null) {
						if(node.element < node.succ.element) {
							lista.delete(node);
						}else {
							lista.delete(node.succ);
						}
					}
					break;
				}
				
				dolzina = dolzina + (float)0.5;
				if(dolzina == brojac) {
						lista.delete(node);
						break;
				}
				
				node = node.succ;
				
			}
			
		}
		
		System.out.println(lista.toString());
		

	}

}
