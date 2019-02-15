import java.util.Arrays;
// 프로그래머스 -  예산
public class Test8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test8 test8 = new Test8();
		int[] a = new int[]{1,3,2,4,5};
		int b = test8.solution(a, 9);
		System.out.println(b);
	}
	
	  public int solution(int[] d, int budget) {
	      int answer = 0;
	      Arrays.sort(d);
	      
	      for(int i=0;i<d.length;i++){
	          if(d[i]<=budget){
	            budget = budget - d[i];      
	              answer++;
	          }
	          else{
	              break;
	          }
	      }
	      
	      
	      return answer;
	  }
	
}
