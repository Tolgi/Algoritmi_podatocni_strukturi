import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*Даден ви е речник на зборови на кумановски дијалект и како тие се пишуваат на македонски јазик.
 *Потоа даден ви е текст којшто е напишан на кумановски дијалект. Потребно е да ги замените сите појавувања на зборовите
 *на кумановскиот дијалект кои се дадени во речникот со соодветни зборови на македонски јазик.

Забелешка: Треба да се игнорираат интерпункциските знаци точка (.) , запирка (,), извичник(!) и прашалник (?). 
   Исто така зборовите во текстот можат да се појават и со прва голема буква и во тој случај неговиот синоним на
   македонски јазик исто така треба да се отпечати со прва голема буква.
   Име на класата (Java): KumanovskiDijalekt.*/

public class KumanovskiDijalekt {

	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,String> map = new HashMap<String,String>();
		
		int N = Integer.parseInt(input.readLine());
		for(int i=0; i<N; i++) {
			String [] s = input.readLine().split(" ");
			map.put(s[0], s[1]);
		}
		
		String [] tekst = input.readLine().split(" ");

		boolean golemaBukva = false;
		for(int i=0; i<tekst.length; i++) {
			String zbor;
			char znak=' ';
			
			if(Character.isUpperCase(tekst[i].charAt(0))) {
				golemaBukva = true;
			}else {
				golemaBukva = false;
			}
			
			if(!Character.isLetter(tekst[i].charAt(tekst[i].length()-1))) {
                
                znak = tekst[i].charAt(tekst[i].length()-1);
				zbor = tekst[i].substring(0, tekst[i].length()-1).toLowerCase();
                
				if(map.containsKey(zbor)) {
					String novZbor = map.get(zbor);
                    
					if(golemaBukva) {
						tekst[i] = Character.toUpperCase(novZbor.charAt(0)) + novZbor.substring(1) + znak ;
					}else {
						tekst[i] = novZbor + znak;
					}
				}
			}else {
				zbor = tekst[i].toLowerCase();
                
				if(map.containsKey(zbor)) {
					String novZbor = map.get(zbor);
					if(golemaBukva) {
						tekst[i] = Character.toUpperCase(novZbor.charAt(0)) + novZbor.substring(1);
					}else {
						tekst[i] = novZbor;
					}
				}
			}
		}
		
		for(int i=0; i<tekst.length; i++) {
			if(i == tekst.length-1) {
				System.out.print(tekst[i]);
			}else {
				System.out.print(tekst[i]+" ");
			}
		}
		
		
	}
		
	}


