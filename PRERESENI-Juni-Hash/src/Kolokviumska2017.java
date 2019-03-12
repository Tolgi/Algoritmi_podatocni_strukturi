import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/*2
root/a/ xy.txt (abv)
root/a/b/ cx.txt (xyz)
3
add root/a/c/ xy2.txt (abv)
delete root/a/ xy.txt (abv)
find root/a/ xy.txt (abv)
abv

Aj vaka ke probam da ja objasnam nekako. Prvata brojka kazuva kolku datoteki ima i koja im 
e patekata root/a/b e patekata kaj st ose naoga fajlot cx.txt a (xyz) ako dobro pamtam bese sodrzinata vo 
cx.txt. Sodrzinata vo primerov xyz treba da bide klucot.
Vtorata brojka (3) go oznacuva brojot na komandi.
Na raspolaganje bea add, delete i find. Add dodava fajl vo posocenata pateka, delete go brise fajlot vo
posocenata datoteka (dokolku postoi istiot), find vraka true ili false vo zavisnsot od toa dali pod odredeniot
kluc ima fajl so dadenoto ime vo posocenata pateka.
Na kraj abv treba da ispecati sto se cuva klucot (vo slucajov abv), vo slucajov ke ispecati
 root/a/c/ xy2.txt bidejki xy.txt koj go zadavam vo vtorata linija podocna se brise so delete opcijata. 
 Dokolku go imavme istiot primer samo bez delete abv ke ni vratese root/a/ xy.txt root/a/c/ xy2.txt*/
public class Kolokviumska2017 {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
		
		int N = Integer.parseInt(input.readLine());
		for(int i=0; i<N; i++) {
			
			String [] s = input.readLine().split(" ");
			String value = s[0]+" "+s[1];
			String kluc = s[2].substring(1, s[2].length()-1);
			
			if(map.containsKey(kluc)) {
				ArrayList<String> lista = map.get(kluc);
				lista.add(value);
				map.put(kluc, lista);
			}else {
				ArrayList<String> lista = new ArrayList<String>();
				lista.add(value);
				map.put(kluc, lista);
			}
		}
		
		int M = Integer.parseInt(input.readLine());
		boolean isFind = false;
		for(int i=0; i<M; i++) {
			String []s = input.readLine().split(" ");
			String kluc = s[3].substring(1, s[3].length()-1);
			String value = s[1]+" "+s[2];
			if(s[0].equals("add")) {
				if(map.containsKey(kluc)) {
					ArrayList<String> lista = map.get(kluc);
					lista.add(value);
					map.put(kluc, lista);
				}
			}
			
			if(s[0].equals("delete")) {
				if(map.containsKey(kluc)) {
					ArrayList<String> lista = map.get(kluc);
					for(int j=0; j<lista.size(); j++) {
						if(lista.get(j).equals(value)){
							map.get(kluc).remove(j);
						}
					}
				}
			}
			
			if(s[0].equals("find")) {
				if(map.containsKey(kluc)) {
					ArrayList<String> lista = map.get(kluc);
					for(int j=0; j<lista.size(); j++) {
						if(lista.get(j).equals(value)){
							isFind = true;
						}
					}
				}
			}
		}
		
		String file = input.readLine();
		if(map.containsKey(file)) {
			System.out.println(map.get(file));
		}
		System.out.println(isFind);
		

	}

}
