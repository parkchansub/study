

// 프로그래머스   
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
	      System.out.println(answer[0]);
	      System.out.println(answer[1]);
	      return answer;
	  }
}
