import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 프로그래머스   나누어 떨어지는 숫자 배열
public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = new int[]{5, 9, 7, 10};
		Test4 test4 =new Test4();
		test4.solution(a, 5);
	}

	
	  public int[] solution(int[] arr, int divisor) {
	      int[] answer = new int[arr.length];
	      int n = 0;
	      for(int i=0;i<arr.length;i++){
	          if(arr[i]%divisor==0){
	        	  answer[n] = arr[i];
	        	  n++;
	          }
	      }
	      
	      int[] answer2 = new int[n];
	      
	      for(int i=0;i<answer.length;i++){
	    	  int n2 = 0;
	    	  if(answer[i]!=0){
	    		  answer2[n2]=answer[i];
	    		n2++;
	    	  }
	      }
	      if(answer2.length==0){
	    	  answer2[0] = -1;
	      }
	     System.out.println(Arrays.toString(answer2));
	      return answer2;
	  }
}
