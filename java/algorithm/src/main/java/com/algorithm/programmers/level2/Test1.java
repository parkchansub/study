package com.algorithm.programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 프로그래머스  - 스킬 트리(진행중) / 
public class Test1 {

	public static void main(String[] args) {
		String  a ="CBD";
		String[] skill = new String[]{"BACDE","CBADF","AECB","BDA"};
		Test1 test1 = new Test1();
		test1.solution(a, skill);
	}

	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		int value = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0;i<skill.length();i++){
			map.put(skill.substring(i,i+1), i+1);
			System.out.println(skill.substring(i,i+1));
		}


		System.out.println("aaaaaa");
		
		for(int i=0;i<skill_trees.length;i++){
			
			for(int j=0;j<skill_trees[i].length();j++){
				if(map.containsKey(skill_trees[i].substring(j, j+1))){
					if(value < map.get(skill_trees[i].substring(j, j+1))){
						System.out.println("bbbbbbbbbb");
						System.out.println(skill_trees[i].substring(j, j+1));
						value = map.get(skill_trees[i].substring(j, j+1));
					}
					/*else{
						skill_trees[i] = "false";
					}*/
				}
			}
			
		}
		System.out.println("CCCCC");
		
		System.out.println(Arrays.toString(skill_trees));
		for(int i=0;i<skill_trees.length;i++){
			if(skill_trees[i]!="false"){
				answer++;
			}
		}
		
		return answer;
	}
}
