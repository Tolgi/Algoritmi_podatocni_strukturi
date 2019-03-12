import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Даден е некој модифициран XML код. Модифицираниот XML код ги користи симболите '[' и ']', за отварање и 
 *затворање на таг, соодветно, наместо стандардните '' и '>'. Треба да се провери дали сите тагови во кодот 
 *се правилно вгнездени (дали кодот е валиден) т.е. дали секој отворен таг има соодветен затворен таг со истото 
 *име на соодветното место во кодот. За поедноставување, дадено е дека секој отворен таг мора да има свој 
 *затворен таг и дека таговите немаат атрибути.
 *На влез е даден бројот на редови во кодот и самиот XML со секој таг во посебен ред, а на излез треба 
 *да се испечати 1 или 0 за валиден или невалиден код, соодветно.
Објаснување: Во модифицираниот XML код секој отворен таг е во облик [imeNaTag], а соодветниот затворен таг е 
             во облик [/imeNaTag].

Пример за правилно вгнездени тагови во XML e:
[tag1]
[tag2] 
Podatok
[/tag2] 
[/tag1] 
*/

public class ModificiranXMLkod {

	public static void main(String[] args)throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());
		String [] s = new String[N];
		ArrayStack<String> stek = new ArrayStack<String>(100);
		ArrayStack<String> tmp = new ArrayStack<String>(100);
		
		for(int i=0; i<N; i++) {
			s[i] = input.readLine();
		}
		
		for(int i=0; i<s.length; i++) {
			if(s[i].charAt(0) == '[') {
				String tag = s[i].substring(1, s[i].length()-1);
				stek.push(tag);
			}
		}
		
		/*while(!stek.isEmpty()) {
			System.out.println(stek.pop());
		}*/
		
		while(!stek.isEmpty()) {
			String t = stek.pop();
			
			if(!tmp.isEmpty()) {
				String tmpTag = tmp.peek();
				if(tmpTag.contains("/")) {
					String cistTag = tmpTag.substring(1);
					if(cistTag.equals(t)) {
						tmp.pop();
					}else {
						tmp.push(t);
					}
				}else {
					String cistTag = t.substring(1);
					if(cistTag.equals(t)) {
						tmp.pop();
					}else {
						tmp.push(t);
					}
				}
			}else {
				tmp.push(t);
			}
		}
		
		
		
		
		if(tmp.isEmpty()) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}

	}

}
