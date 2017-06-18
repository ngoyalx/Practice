package Xebia.SampleMavenProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Practice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Practice practice = new Practice();
		practice.reverseString("this is my pet");
	}
	
	public void charactercount(){
		String sample = "this is";
		char[] array = sample.toCharArray();
		System.out.println(array.length);
	}
	
	public void anagram(){
		String s1="nitesh";
		String s2="inesht";
			    
			    char[] s1chars = s1.toCharArray();
			    char[] s2chars = s2.toCharArray();
			    
			    List<Character> list = new ArrayList<Character>();
			    
			    for(int j=0;j<s1chars.length;j++){
			     list.add(s1chars[j]); 
			    }
			    
			    if(s1.length()==s2.length()){
			    for(int i=0;i<s2chars.length;i++){
			      if(list.contains(s2chars[i])){   
			      }else{
			      System.out.println("string is not anagram");
			        break;
			      }
			         
			    }
			    System.out.println("string is anagram");
			    }
	}
	
	public void majority(){
		
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
         
         int[] array = {3,3,4,2,4,4,4,4,4,4,4,5,8,7,7};
         int length= array.length;
         
         for(int j=0;j<length;j++){
           if(hm.containsKey(array[j])){
             hm.put(array[j],hm.get(array[j])+1);
           }else{
           hm.put(array[j],1);
           }
         }
         
         Set<Integer> keys = hm.keySet();
         for(int key: keys){
           if(hm.get(key)>length/2){
           System.out.println(key);
           }
         }
        
	}
	
	
	public void countcharacters(){
		String sample = "Started a little late than planned since my grandmother was also travelling with us. Left at 8:20 AM from the hotel after breakfast and drove non stop till Srikakulam. Stopped for a cup of tea at 11:30AM. Reached the AP-OD border famous for its long traffic jam. Initially I stuck to my side and it was not moving for about 10 minutes. Then a kind trucker showed us a point where the median had been broken. Crossed over and drove into Odisha in 10 minutes flat. The Odisha stretch of the Golden quadrilateral is mostly concrete, tyre noise was high. Be extremely cautious while driving in Odisha, bikers have the right of way and theres no two ways about that. They cut in suddenly, drive slowly on the left, right, center and the median and do not give a damn. Plus I found the dogs in Odisha to be suicidal , they are worse than the bikers. Stopped for lunch at the famous Chilika Dhaba, ambience is not all that great for families but the food more than made up for it.Reached Bhubaneswar at 3:45PM and crossing it was a piece of cake. Beautiful bypass right through the heart of Bhubaneswar. Reached Cuttack in 30 minutes and then proceeded onwards to Kolkata. Not traffic jam at Odisha - West Bengal border. All trucks were parked to the side leaving the fast lane free for cars to go through. Reached Kharagpur around 10:15PM and stopped for Dinner at Ashiana Dhaba on the Kolkata - Kharagpur highway. Post dinner got royally stuck at the next toll gate for 35 mins and finally reached our place of stay at 12:50AM in New Town, Kolkata. Room was good but hosts were bad. The day started with my dad at the wheel at 7:45AM. I had driven 762 kms the previous day towards the end and wanted to rest for some more time. Exited Kolkata in 25 minutes and immediately my 18-55mm lens packed up . Switched between 55-250mm and a prime lens and managed for the rest of the trip. Reached Azad Hind dhaba at 9:00AM on the highway to Burdwan. Spent a good one hour and had awesome Aloo parathas. There was an unruly biker gang doing stunts on the highway and generally causing chaos, riding liter bikes without even a helmet. Anyways crossed Khargram by 11:00AM and then the road till Morgram was very bad till we hit NH12. Reached Farakka at 2:30PM had lunch at Hotel Meera right before the barrage starts. Proceeded at 3:30PM with my brother at the wheel and crossed Farakka barrage in a jiffy. The road on the barrage was so bad, the front tow hooks hit in a particularly short and deep pothole. Reached Raiganj at around 6:15 PM and I took over. As per the suggestion from the chai wallah took the Botolbari - Dhantola road. He assured us that it is safe, so took a chance plus had 3 more cars following me. The road is extremely well maintained but quite narrow, The last 1km before Dhantola is just a nightmare. I can only imagine the number of hits Samba da's Etios would have taken. Time was 9:45PM when I stopped at City center Siliguri for a bite. After dinner started at 10:30PM from Siliguri and took the Rohini road to Darjeeling. Was quite scary initially since there were no other cars on the road. The climb was fun and steep. Reached Darjeeling at 12:10AM and got lost trying to find our stay. Finally reached Rodhi resort at 12:40AM. Crashed immediately as we had booked for a 10:30AM Steam engine Toy train ride. Darjeeling was freezing at around 4 degree Celsius. The place we stayed at is recommended since you get a superb view of the entire city and the mighty Kanchenjunga peak in the morning. The joy ride is 14 km long from Darjeeling station to Batasia loop, where it stops for 10 minutes and then onwards to Ghum station. It stops for 30 minutes at Ghum station so that you can visit the museum. After that it is the same rout back. In Case of steam engine they stop twice to fill water. Overall it was very enjoyable. But ticket cost per person is 1100/-. The ride took almost 3 hours and once you complete there are cabs available right outside the station for a ride back.Do";
		
		char[] chars = sample.toCharArray();
		System.out.println(chars.length);
	}
	
	
	public void reverseofarray(){
		String[] array = {"nitin","shefali","Aaru"};
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
		System.out.println("Print reverse of array");
		String[] newarray=new String[array.length];
		for(int i=array.length-1,j=0;i>=0;i--,j++){		
				newarray[j]=array[i];
				System.out.println(newarray[j]);
			}
	}
	
	public void stringreverse(){
		String a="aaru";
		
		char ry[] = a.toCharArray();
		for(int i=ry.length-1;i>=0;i--){
			System.out.println(ry[i]);
		}
	}
	
		 
	    
	     
	    public String reverseString(String str){
	    	String reverse = "";     
	        if(str.length() == 1){
	            return str;
	        } else {
	            reverse += str.charAt(str.length()-1)
	                    +reverseString(str.substring(0,str.length()-1));
	            return reverse;
	        }
	    }
	
	public void stringbuilderreverse(){
		String input="nitin";
		StringBuilder input1 = new StringBuilder();
		input1.append(input);
		input1 = input1.reverse();
		System.out.println(input1);
		if(input.equals(input1.toString())){
			System.out.println("String is a pallindrome");
		}else{
			System.out.println("String is not a pallindrome");
		}
	}
	
	public void pallindromnumber(){
		int n=454;
		int r,temp,sum=0;
		temp=n;
		while(n>0){
			r= n%10;
			sum = (sum*10)+r;
			n=n/10;
		}
		if(temp==sum){
			System.out.println("Pallindrome no");
		}
	}
	
	public void replacesubstring(){
		String input="my name is nitin and my wife name is shefali";
		input = input.replaceAll("my", "this");
		System.out.println(input);
		
	}
	
	public void findduplicate(){
		String input="this is my pet, this is my boy";
		HashMap<String,Integer> wordscount = new HashMap<>();
		String[] words = input.split(" ");
		
		for(String word: words){
			if(wordscount.containsKey(word)){
				wordscount.put(word, wordscount.get(word)+1);
			}else{
				wordscount.put(word, 1);
			}
		}
		Set<String> keys = wordscount.keySet();
		for(String key: keys){
			if(wordscount.get(key)>1){
				System.out.println("The occurrence of " + key + " is "  + wordscount.get(key));	
			}
			
		}
	}
	
		public void mergetwoarrays(){
		int[] array1= {1,2,3,4};
		int[] array2 = {5,6,7,8};
		
		int size1 = array1.length;
		int size2 =array2.length;
		int size = size1+size2;
		
		int[] array = new int[size];
		
		for(int i=0;i<size1;i++){
			array[i] = array1[i];
		}
		for(int j=0,k=size1;j<size2 && k<size;j++,k++){
			array[k] = array2[j];
		}
		for(int m=0;m<size;m++){
			System.out.println(array[m]);
		}
	}
	
	public void fizzbuzz(){
		int n=100;
		for(int i=1;i<n;i++){
			if(i%3==0 && i%5==0){
				System.out.println("FizzBuzz" + "no is" + i);
			}else if(i%3==0){
				System.out.println("Fizz" + "no is" + i);
			}else if(i%5==0){
				System.out.println("Buzz" + "no is" + i);
			}
		}
	}
	
	public void fibonacci(){
		int[] array = new int[15];
		array[0] = 0;
		array[1] = 1;
		for(int i=2;i<array.length;i++){
			array[i] = array[i-1]+array[i-2];
		}
		for(int k=2;k<array.length;k++){
			System.out.println(array[k]);
		}
	}
	
	
	
	public void findsmallestfromarray(){
		int[] array = {105,8,2,58,15,23,55,11};
		int biggest=array[0];
		
		
		for(int i=0;i<array.length;i++){
			if(array[i]>biggest){
				biggest=array[i];
			}
		}
		System.out.println("The biggest no is" + biggest);
	}
	
	public void william(){
		String[] william =  {"coke","pepsi","limca"};
		String[] newwiliam = new String[william.length];
		for(int i=william.length-1,j=0;i>=0;i--,j++){
			newwiliam[j]=reverse(william[i]);
		}
	}
	
	public String reverse(String sample){
		String reverse="";
		char[] chars = sample.toCharArray();
		for(int i=chars.length-1;i>=0;i--){
			 reverse = reverse + chars[i];
		}
		return reverse;
	}
	
	public void printtraingle(){
		int i,j,k;
		for(i=1;i<=5;i++){
			for(j=4;j>=i;j--){
				System.out.print(" ");
			}
			for(k=1;k<=i;k++){
				System.out.print("*");
			}
			System.out.println("");
			}
		}
		
		
		
		
	/***
	 * convert 1d to 2d array
	 * convert 2d to 1d array
	 * convert array to list
	 * convert list to array
	 * reverse of a string
	 * reverse of a strings within the array
	 * iterate through HASHMAP
	 * collections
	 ****
	 * 
	 */
}
