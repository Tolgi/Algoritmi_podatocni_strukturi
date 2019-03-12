import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*На влез се прима листа и таа листа треба да се модифицира на начин што помеѓу секои 2 броја ќе се вметне
 *број што е аритметичка средина на тие 2 броја. Да не се користи помошна листа туку да се вметнат во веќе
 *дадената.*/
public class MeguSekoi2VmetniAritmetickaSredina {

	public static void main(String[] args)throws IOException {
		
		BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());
		String []s = input.readLine().split(" ");
		SLL<Double> lista = new SLL<Double>();
		
		for(int i=0; i<N; i++) {
			lista.insertLast(Double.parseDouble(s[i]));
		}
		
		SLLNode<Double> node = lista.getFirst();
		double as = 0;
		while(node.succ != null) {
			as = (node.element + node.succ.element) / 2;
			lista.insertAfter(as, node);
			
			if(node.succ.succ != null) {
				node = node.succ.succ;
			}else {
				break;
			}
			
		}
		
		System.out.println(lista.toString());
		
		

	}

}
