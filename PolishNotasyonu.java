/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polish.notasyonu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author CASPER
 */
public class PolishNotasyonu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		List<String> textlist;
		String tempText;
                
                
                System.out.println("Polish Notasyonu ile işlem yapacak alagoritmaya hoşgeldiniz");
                System.out.println("Uygulamadan önce değerler(+,/,*,-) arasında bir boşluk bırakınız");
		          System.out.println("PROGRAM GİRİŞİ° =");
                          
                          
		tempText = scanner.nextLine();
		textlist = new ArrayList(Arrays.asList(ListedenStringAlma(tempText)));
	
		int result = polishNotasyonu(textlist);
		          System.out.println("PROGRAM ÇIKTISI = " + result);

	}
	

	
	
	
	private static int HesaplamaFonksiyonu(Integer degerA, Integer degerB, char charAt) {
		
		
		switch(charAt) {
		
		
		case '*':{
			return degerA*degerB;
		}
                
                
                
                
		case '-':{
			return degerA-degerB;
		}
                
                
                
                
                case '+':{
			return degerA+degerB;
		}
                
                
                
                
      		case '/':{
			return degerA/degerB;
		}
                
                
                
                default :
			return -1;
		
		}
		
		
	}
        
        
        
        private static String[] ListedenStringAlma(String a) {
		return a.split("\\s+");
	}
	
        
        
	private static int polishNotasyonu(final List<String> Array) {
		int result = 0,index,i=0;
		
		do {
			
			i = 0;
			while(Array.size() > i+2) {
				
                            
                            
                            
				if(!Character.isDigit(Array.get(i).charAt(0))
						&& Character.isDigit(Array.get(i+1).charAt(0))
						&& Character.isDigit(Array.get(i+2).charAt(0))) {
					index = i;
					
                                        
                                        
                                        
                                        
					result = HesaplamaFonksiyonu(Integer.valueOf(Array.get(index+1)),
							Integer.valueOf(Array.get(index+2))
							,Array.get(index).charAt(0));
					
                                        
                                        
                                        
					if(result != -1) {
						Array.remove(index+1);
						Array.remove(index+1);
						Array.set(index, String.valueOf(result));
				
						
					}else {
		                  System.out.println("HATA");
						return -1;
					}
							
				}
				i++;
			}
			
			
		}while(Array.size() > 1);
		
		
		
		return Integer.valueOf(Array.get(0));
	}}
    
    

