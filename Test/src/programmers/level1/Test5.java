package programmers.level1;
// 프로그래머스   수박수박수박수박수박수? (완료) / 블로그 작성(완료)
public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int n2 = 4;
		Test5 test5 =new Test5();
		String answer = test5.solution(n2);
		System.out.println(answer);
	} 

	
	  public String solution(int n) {
	      String answer = "";
	      
	      if(n%2==0){
	          for(int i=0;i<(n/2);i++){
	            answer += "수박";    
	          }
	      }
	      else if (n%2==1){
	          for(int i=0;i<(n/2);i++){
	              answer += "수박";    
	          }
	          answer += "수";
	      }
	      
	      return answer;
	  }
}
