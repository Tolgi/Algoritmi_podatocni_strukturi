import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*Дедо Мраз преку целата година води список од деца кои биле добри и нивните адреси за да им достави подароци. 
 *Така е и со децата од Скопје, арно ама градот Скопје решил да менува називи на улици и Дедо Мраз во последен 
 *момент добива листа од изменети називи на улици за Скопје, Македонија. Проверете за дадено дете дали Дедо Мраз 
 *треба да му достави подарок (дали го има детето во списокот на добри деца) и ако треба на која адреса ќе му го 
 *достави. Дополнително за децата од Скопје да се испечати новата адреса доколку името на улицата е променето.

Влез: Во првата линија е даден број N на деца кои биле добри. Во наредните N линии се дадени името на детете и 
	  неговата адреса во посебни редови (Адресата е во формат ИмеНаУлица Број Град Држава).
	  Потоа е даден број M на улици од Скопје кои го промениле своите име. Во наредните M линии дадени прво
	  старите па новите имиња на улици разделени со празно место. Во последниот ред е дадено името на детете кое 
	  треба да се провери.
	  
Излез: Ако даденото дете не било добро (т.е. го нема во списокот на добри деца) да се испечати Nema poklon,
       а ако било добро да се испечати валидната адреса на која ќе се достави поклонот (т.е. ако името на 
       улицата е од Скопје, Македонија и се променило, да се испечати адресата со новиот назив на улицата).

Забелешка: При реализација на задачите МОРА да се користат дадените структури, а не да користат помошни 
           структури како низи или сл.*/
/*Пример влез
5
JohnDoe
DriveAvenue 231 NewYork USA
JaneDoe
GreenStreet 821 Chicago USA
PecePecevski
Vodnjanska 30 Skopje Macedonia
MartaMartevska
Vostanichka 81 Prilep Macedonia
EstebanPerez
InsurgentesSur 7325 MexicoCity Mexico
5
MarshalTito Makedonija
Vodnjanska MajkaTereza
Leninova Aminta3
MajkaTereza AdolfCiborovski
Vojvodina KiroGligorov
PecePecevski
Пример излез
MajkaTereza 30 Skopje Macedonia*/

class Ulica{
	public String ime;
	public int broj;
	public String grad;
	public String drzava;
	
	Ulica(){}
	Ulica(String i, int b, String g, String d){
		ime = i; 
		broj = b;
		grad = g;
		drzava = d;
	}
	
}
public class PodarociNaDedoMraz {

	public static void main(String[] args) throws IOException{
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());
		HashMap<String, Ulica> map = new HashMap<String, Ulica>();
		
		for(int i=0; i<N; i++) {
			String ime = input.readLine();
			String [] s = input.readLine().split(" ");
			Ulica ulica = new Ulica(s[0], Integer.parseInt(s[1]), s[2], s[3]);
			map.put(ime, ulica);
		}
		
		int M = Integer.parseInt(input.readLine());
		HashMap<String,String> novi = new HashMap<String,String>();
		for(int i=0; i<M; i++) {
			String [] s = input.readLine().split(" ");
			novi.put(s[0], s[1]);
		}
		
		String dete = input.readLine();
		StringBuilder sb = new StringBuilder();
		boolean mirnoDete = false;
		if(map.containsKey(dete)) {
			Ulica u = map.get(dete);
			mirnoDete = true;
			if(novi.containsKey(u.ime)) {
				sb = new StringBuilder();
				sb.append(novi.get(u.ime)+" "+u.broj+" "+u.grad+" "+u.drzava);
			}else {
				sb = new StringBuilder();
				sb.append(u.ime+" "+u.broj+" "+u.grad+" "+u.drzava);
			}
		}else {
			System.out.println("Nema poklon");
		}
		
		
		if(mirnoDete) {
			System.out.println(sb.toString());
		}
	}

}
