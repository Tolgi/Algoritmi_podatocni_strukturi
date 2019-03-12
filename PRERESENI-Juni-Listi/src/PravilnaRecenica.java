import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Ddena e ednostrano povrzana lista cii sto jazli sodrzat po eden karakter
 *a site jazli zaedno formiraat recenica. Pri pisuvanjeto na recenicata
 *nastanala greska pri sto prvata bukva od sekoj zbor e stavena na kraj na zborot.
 *Vasa zadaca e da ja napisete recenicata pravilno, odnosno da ja 
 *postavite poslednata bukva od sekoj zbor na pocetok na zborot.
 *Zborovite se oddeleni so jazli cija vrednost e mrazno mesto.
 *Recenicata sekogas zavrsuva so "."
 *Vlez: na vlez e dadena pogresna recenica
 *Izlez: na izlez treba da se ispecatat jazlite na rezultantnata lista(transformiranata recenica)
 *Zabeleska: Dozvolena e samo EDNA ednostrano povrzana lista.
 *pr: "remetoV e oncevos."   na izlez:  "Vremeto e soncevo"*/
public class PravilnaRecenica {

	public static void main(String[] args) throws IOException{
		
		BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		
		String s = input.readLine();
		char [] r = s.toCharArray();
		SLL<Character> lista = new SLL<Character>();
		for(int i=0; i<r.length; i++) {
			lista.insertLast(r[i]);
		}
		
		SLLNode<Character> node = lista.getFirst();
		SLLNode<Character> prvaBukva = node;
		
		while(node.succ != null) {
			
			
			if(node.element.equals(' ') && Character.isAlphabetic(node.succ.element)){
				prvaBukva = node.succ;
				
			}
			
			if(node.succ.element.equals(' ') || node.succ.element.equals('.')) {
				lista.insertBefore(node.element, prvaBukva);;
				lista.delete(node);
			}
			
			node = node.succ;
		}
		
		
		System.out.println(lista.toString());

	}

}
