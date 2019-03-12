import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Vojska {
	
	public static void pecati(SLL<Integer> lista) {
		SLLNode<Integer> node = lista.getFirst();
		while(node != null) {
			if(node.succ == null) {
				System.out.println(node.element+" ");
			}else {
				System.out.println(node.element+" ");
			}
			node = node.succ;
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());
		String[]s = input.readLine().split(" ");
		DLL<Integer>lista = new DLL<Integer>();
		for(int i=0; i<N; i++) {
			lista.insertLast(Integer.parseInt(s[i]));
		}
		String[] s1 = input.readLine().split(" ");
		int a1 = Integer.parseInt(s1[0]);
		int a2 = Integer.parseInt(s1[1]);
		
		String[] s2 = input.readLine().split(" ");
		int b1 = Integer.parseInt(s2[0]);
		int b2 = Integer.parseInt(s2[1]);
		
		DLLNode<Integer> node = lista.getFirst();
		DLL<Integer> rezultat = new DLL<Integer>();
		DLL<Integer> prv = new DLL<Integer>();
		DLL<Integer> vtor = new DLL<Integer>();
		boolean isIn = false;
		while(node != null) {
			if(isIn) {
				prv.insertLast(node.element);
			}
			if(node.element == a1) {
				prv.insertLast(node.element);
				isIn = true;
			}
			if(node.element == a2) {
				isIn = false;
			}
			node = node.succ;
		}
		
		isIn = false;
		node = lista.getFirst();
		while(node != null) {
			if(isIn) {
				vtor.insertLast(node.element);
			}
			if(node.element == b1) {
				vtor.insertLast(node.element);
				isIn = true;
			}
			if(node.element == b2) {
				isIn = false;
			}
			node = node.succ;
		}
		
		node = lista.getFirst();
		DLLNode<Integer> vnode = vtor.getFirst();
		DLLNode<Integer> pnode = prv.getFirst();
		while(node != null) {
			if(node.element == a1) {
				while(vnode != null) {
					rezultat.insertLast(vnode.element);
					vnode = vnode.succ;
					//node = node.succ;
				}
				
				while(node.element != a2) {
					node = node.succ;
				}
				node = node.succ;
			}else if(node.element == b1) {
				while(pnode != null) {
					rezultat.insertLast(pnode.element);
					pnode = pnode.succ;
					//node = node.succ;
				}
				
				while(node.element != b2) {
					node = node.succ;
				}
				node = node.succ;
				
			}
			else {
				rezultat.insertLast(node.element);
				node = node.succ;
			}
		}
		
		//System.out.println(prv.toString());
		//System.out.println(vtor.toString());
		System.out.println(rezultat.toString());
		
	}

}
