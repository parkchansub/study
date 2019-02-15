package programmers.level1;
import java.util.Arrays;
// 프로그래머스  문자열 내림 차순으로 배치하기(진행중)
public class Test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test7 test7 = new Test7();
		String b = test7.solution("asdfasd");
		System.out.println(b);
	}
	
	public String solution(String a){
		String answer = "";
		char[] ch = a.toCharArray();
		Arrays.sort(ch);
		return answer;
	}
}
