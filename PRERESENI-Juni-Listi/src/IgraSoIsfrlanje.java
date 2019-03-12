import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * N deca sedat vo krug i se igra slednava igra. Se pocnuva od deteto X i se
 * brojat deca vo nasoka na casovnikot, koga kje se dojde do brojot M, deteto
 * kaj koe sto zastanalo broenjeto ispagja od igra. Slednata runda se pocnuva
 * od deteto koe bi bilo broj M+1, megjutoa se menja nasokata na broenje.
 * Se igra N-1 rundi, se dodeka ne ostane samo edno dete. Na vlez se vnesuvaat:
 * iminjata na decata, imeto na deteto od koe pocnuva igrata vo prvata runda
 * i broevite N i M. Da se odredi koe dete pobeduva vo igrata.
 */


public class IgraSoIsfrlanje {

	public static void main(String[] args) throws IOException{
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());
		DLL<String> lista = new DLL<String>();
		for(int i=0; i<N; i++) {
			lista.insertLast(input.readLine());
		}
		
		int M = Integer.parseInt(input.readLine());
		String prv = input.readLine();
		
		DLLNode<String> node = lista.getFirst();
		int brojac = -1;
		boolean isPlay = false;
		boolean nasokaCasovnik = true;
		while(node != null) {
			
			if(lista.length() == 1) {
				break;
			}
			
			if(node.element.equals(prv)) {
				isPlay = true;
			}
			
			if(isPlay) {
				brojac++;
			}
			
			if(brojac == M) {
				lista.delete(node);
			}
			
	
			if(nasokaCasovnik) {
				if(node.succ == null) {
					node = lista.getFirst();
				}else {
					node = node.succ;
				}
			}else {
				if(node.pred == null) {
					node = lista.getLast();
				}else {
					node = node.pred;
				}
			}
			
			if(brojac == M) {
				brojac = -1;
				nasokaCasovnik = !nasokaCasovnik;
			}
			
		}
		
		
		System.out.println(lista.toString());
	}

}
