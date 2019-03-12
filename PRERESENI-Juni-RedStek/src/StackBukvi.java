/*Дадена е низа од големи букви, во која буквата S се појавува парен број пати. 
 *После секоја буква S буквата Т се појавува еднаш или повеќе пати.
 *Користејќи стек да се одреди дали после секоја буква S (до следната буква S), 
 *буквата Т се појавува ист број на пати. На првиот ред од влезот се чита низа од карактери (стринг),
 * на излез се печати 1 доколку буквата Т се појавува ист број на пати после секоја S,
 * и нула доколку овој услов не е исполнет.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class StackBukvi {

	public static void main(String[] args) throws IOException{
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String s = input.readLine();
		char [] bukvi = s.toCharArray();
		Stack<Character> stek = new Stack<Character>();
		
		
		boolean isInterval = false;
		boolean isFirstInterval = true;
		int brojT = 0;
		int brojac = 0;
		int rezultat = 1;
		for(int i=0; i<bukvi.length; i++) {
			
			brojac = 0;
			if(bukvi[i] == 'S' || i == bukvi.length) {
				if(isInterval) {
					
					while(!stek.isEmpty()) {
						stek.pop();
						brojac++;
					}
					
					if(isFirstInterval) {
						brojT = brojac;
						isFirstInterval = false;
					}
					
					if(brojT != brojac) {
						rezultat = 0;
						break;
					}
					
				}else {
					isInterval = true;
				}
			}
			
			if(isInterval && bukvi[i] == 'T') {
				stek.push(bukvi[i]);
			}
		}
		
		if(stek.size() != brojT) {
			rezultat = 0;
		}
		
		System.out.println(rezultat);
		

	}

}
