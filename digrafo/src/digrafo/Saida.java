package digrafo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;


public class Saida {
		private static Saida instance;
		public static Saida getInstance() {
	        if (instance == null) {
	            instance = new Saida();
	        }
	        return instance;
	    }

		private static List<String> digrafo;
		static TreeMap<String,String> map = new TreeMap<>();
		static List<String> list_keys;

		public List<String> getDigrafo() {
			return digrafo;
		}

		public static void setDigrafo(List<String> listaPalavras) {
			Saida.digrafo = listaPalavras;
		}

		
		public static  String Split(String word){

			String[] array = word.split(",");
			word = array[0];
			//System.out.println("\n!!A palavra é:"+word);
			return word;
		}
		
		public static  String repeated_line(int index){
			String Line = new String();
			int j = index+1;		
	    	while(j<digrafo.size()-1){
	    		if((Split(digrafo.get(index))).equals(Split(digrafo.get(j)))){
	    				
	    				Line = Line+","+map.get(digrafo.get(j));
	    				map.put(digrafo.get(j), null);
		    	}else {
		    		break;
		    	 }
	    		 j++;
	    	}	    
	    	map.put(digrafo.get(index), null);
	    	Line = Remove_duplicate_in_line(Line);
	    	remove();
	    	
	    	return Line;
	    }
		
		private static String Remove_duplicate_in_line(String line) {
			String[] Array = line.split("\\s+");
	        
	        //convert String array to LinkedHashSet to remove duplicates
	        LinkedHashSet<String> lhSetWords 
	            = new LinkedHashSet<String>( Arrays.asList(Array) );
	        
	        //join the words again by space
	        StringBuilder sbTemp = new StringBuilder();
	        int index = 0;
	        
	        for(String s : lhSetWords){
	            
	            if(index > 0)
	                sbTemp.append(" ");
	        
	            sbTemp.append(s);
	            index++;
	        }
	        
	        line = sbTemp.toString();
		    System.out.println(line);
	
		        
			return line;
		}

		public static void remove() {
			for(int i = 0; i <digrafo.size()-1;i++){
				map.values().remove(null);
			}
			
			
		}

	   /* public static void index_next_position(int index) {
	    	
	    		  String word = Split(digrafo.get(index));
	    		  int new_index = index;
	    		  while(true){
	    			  if(word.equals(Split(digrafo.get(new_index)))) {
		    			  map.remove(digrafo.get(new_index));
		    			  digrafo.remove(new_index);  			  
		    			  new_index++;
	    			  }else {
	    				  break;
	    			  }
	    		  }	    		  
	  			//System.out.println(digrafo);

	    }*/
		public static void Write_csv_File(){
			try {
			      FileWriter myWriter = new FileWriter("Text1.csv");
			      int i = 0;
			      while(true){
			    	  if(i >=digrafo.size()-1){
			    		  break;
			    	  }
			    	  if((map.get(digrafo.get(i))) == null) {
			    		  i++;
			    		  continue;
			    	  }

			    	  myWriter.append(Split(digrafo.get(i)));
			    	  myWriter.append(",");
			    	  myWriter.append(map.get(digrafo.get(i)));
			    	  if((Split(digrafo.get(i))).equals(Split(digrafo.get(i+1)))) {

				    	  myWriter.append(repeated_line(i));
			          }
			    	  i++;
			    	  myWriter.append("\r\n"); 
				  }
			      myWriter.append(Split(map.lastKey()));
			      myWriter.append("," +map.get(map.lastKey()));

			      myWriter.flush();
		    	  myWriter.close();
		    	  System.out.println("Successfully wrote to the file.");
			} catch (IOException e) {
			      System.out.println("");
			      e.printStackTrace();
			  }	
		}
	
		public static void Treemaptreat() {
			for(int i = 0; i <digrafo.size()-1;i++){
				  if(map.containsKey(digrafo.get(i)) == true){
					  map.put((digrafo.get(i)+","+i),digrafo.get(i+1));	
					  
				  }else {
					  map.put(digrafo.get(i), digrafo.get(i+1));
				   }
			}
		}
		public static <T> List<T> convertSetToList(Set<T> set) 
	    { 
	        // create an empty list 
	        List<T> list = new ArrayList<>(); 
	  
	        // push each element in the set into the list 
	        for (T t : set) 
	            list.add(t); 
	  
	        // return the list 
	        return list; 
	    } 
		
		public static void order_graphi() {	
			digrafo.clear();
			digrafo = convertSetToList(map.keySet());
		}
}