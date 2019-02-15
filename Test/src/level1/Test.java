package level1;
// 프로그래머스 - 시저 암호(완료) / 블로그 작성(완료)
public class Test {
    
    public static void main(String args[])  {
    	
    	Test test = new Test();
    	String b = test.solution("Z", 1);
    	System.out.println(b);
    }
    public String solution(String s, int n) {
	      String answer = "";
	      String[] small = new String[] {"a", "b", "c", "d", "e", "f", "g", "h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	      String[] large = new String[] {"A", "B", "C", "D", "E", "F", "G", "H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	      for (int i=0;i<s.length();i++){
	    	  char ch = s.charAt(i);
	    	  if(Character.isLowerCase(ch)){
	    		  for(int k=0;k<small.length;k++){
	    			  if(small[k].equals(s.substring(i, i+1))){
	    				  int end = k+n;
	    				  if(end>25){
	    					  end = end-26;
	    				  }
	    				  answer = answer+small[end];
	    			  }
	    		  }
	    	  }
	    	  else if(Character.isUpperCase(ch)){
	    		  for(int k=0;k<large.length;k++){
	    			  if(large[k].equals(s.substring(i, i+1))){
	    				  int end = k+n;
	    				  if(end>25){
	    					  end = end-26;
	    				  }
	    				  answer = answer+large[end];
	    			  }
	    		  }
	    	  }
	    	  else{
	    		  answer = answer+" "; 
	    	  }
	      }
	      
	      return answer;
	  }
}


