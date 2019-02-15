package level1;
// 프로그래머스 가운데 글자 가져오기
public class Test6 {

	public static void main(String[] args) {

		String a= "sadfasdf";
		String b= "sasdf";
		Test6 test6 = new Test6();
		String answer = test6.solution(a);
		System.out.println(answer);
		String answer2 = test6.solution(b);
		System.out.println(answer2);
	}
	
	
	  public String solution(String s) {
	      String answer = "";
	      
	      if(s.length()%2==0){
	          int x = s.length()/2;
	          answer = s.substring(x-1,x+1);
	      }
	      else{
	          int x = s.length()/2;
	          answer = s.substring(x,x+1);
	      }
	      return answer;
	  }
}
