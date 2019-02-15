package programmers.level1;
import java.util.Arrays;

// 프로그래머스 - 나누어 떨어지는 숫자 배열(완료) / 블로그 작성(X)
public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = new int[]{5, 9, 7, 10};
		int[] c = new int[]{3,6,7};
		int[] d = new int[]{2,36,1,3};
		Test4 test4 =new Test4();
		String b= test4.solution(d, 1);
		System.out.println(b);
	}

		// 리턴타입 String 직관적으로 보여지기 위한 코드
	  public String solution(int[] arr, int divisor) {
	      int[] answer = new int[arr.length];
	      int n = 0;
	      int n2 = 0;
	      for(int i=0;i<arr.length;i++){
	          if(arr[i]%divisor==0){
	        	  answer[n] = arr[i];
	        	  n++;
	          }
	      }
	      if(n==0){
	    	  n++;
	      }
	    	  int[] answer2 = new int[n];

	      for(int i=0;i<answer.length;i++){
	    	  if(answer[i]!=0){
	    		  answer2[n2]=answer[i];
	    		n2++;
	    	  }
	      }
	      if(answer2[0]==0){
	    	  answer2[0] = -1;
	      }
	      Arrays.sort(answer2);
	      
	     String answer3 = Arrays.toString(answer2);
	     
	      return answer3;
	  }
	  
	  
	  //프로그래머스 전용
	  public int[] solution2(int[] arr, int divisor) {
	      int[] answer = new int[arr.length];
	      int n = 0;
	      int n2 = 0;
	      for(int i=0;i<arr.length;i++){
	          if(arr[i]%divisor==0){
	        	  answer[n] = arr[i];
	        	  n++;
	          }
	      }
	      if(n==0){
	    	  n++;
	      }
	    	  int[] answer2 = new int[n];

	      for(int i=0;i<answer.length;i++){
	    	  if(answer[i]!=0){
	    		  answer2[n2]=answer[i];
	    		n2++;
	    	  }
	      }
	      if(answer2[0]==0){
	    	  answer2[0] = -1;
	      }
              
	     Arrays.sort(answer2);
	     
	      return answer2;
	  }
}
