/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author CASPER
 */
public class CFG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        		Scanner scanner = new Scanner(System.in);
	
		List<String> sonListe,Liste1,Liste2;
		String temp;
		char a,b;
		
		sonListe = new ArrayList();
		
		
	           System.out.println("CFG'YE GÖRE TOPLAM DİL AĞACI ÜRETEN ALGORİTMA");
                   System.out.println("'-->','|' KULLANMALISINIZ  :");
		System.out.println("S İLE BAŞLIYAN İLK DEĞERİ GİRİN");
		temp = scanner.nextLine();
		a = temp.charAt(0);
		Liste2 = new ArrayList(Arrays.asList(listedenStringAlma(temp.substring(temp.indexOf(">")+1,temp.length()))));
	
		          System.out.println("X İLE BAŞLIYAN İLK DEĞERİ GİRİN");
		temp = scanner.nextLine();
		b = temp.charAt(0);
		Liste1 = new ArrayList(Arrays.asList(listedenStringAlma(temp.substring(temp.indexOf(">")+1,temp.length()))));
		
		
		if(Liste1.contains(String.valueOf(b)) || Liste2.contains(String.valueOf(a))) {
			                 System.out.println("GİRDİĞİNİZ DEĞERLER DÖNGÜ OLACAK" + "\n"
					+ "BAŞKA BİR DEĞER GİRİNİZ");
		}else {
		
			sonListe = ListeCagırma(Liste2,Liste1,b);
		                  System.out.println("ÇIKTI : " + sonListe);
		}
		
		

	}
	
	
	

	
	
	
	private static List<Integer> Xbul(String current,char x) {
		List<Integer> list = new ArrayList();
		for(int i =0 ; i< current.length() ; i++) {
			if(current.charAt(i) == x) {
				list.add(i);
			}
		}
		return list;
	}

	

	
	
	private static String[] listedenStringAlma(String s) {
		return s.split("\\|");
	}


	
	private static List<String> ListeCagırma(List<String> Liste1,List<String> Liste2,char x){
		
		List<String> totalList = new ArrayList();
		String cur;
		totalList.addAll(Liste1);
		
		int index=0;
		
		while(index < totalList.size()) {
			cur = totalList.get(index);
			List<Integer>  xIndcies = Xbul(cur,x);
			for(int i =0 ; i<xIndcies.size() ; i++ ) {
				for(int j = 0 ; j<Liste2.size() ; j++) {
					String ekle = cur.substring(0, xIndcies.get(i)) + Liste2.get(j); 
					if(xIndcies.get(i) + 1 < cur.length()) {
						ekle = ekle + cur.substring( xIndcies.get(i)+1);
					}
					
					if(!totalList.contains(ekle))
						totalList.add(ekle);
				}
			}
			index++;
			
			
		}	
		
		List<String> finalList = new ArrayList();
		for(int i=0 ; i< totalList.size() ; i++) {
			if(!totalList.get(i).contains(String.valueOf(x))) {
				finalList.add(totalList.get(i));
			}
		}
		return finalList;
	}
	
}
    
    

