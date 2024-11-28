
/*
    설치 할 때 중복되는 것은 없음, 삭제할 때 없는걸 삭제하도록 요청 X
    
    build_frame의 원소는 [x, y, a, b]형태
    x, y는 가로 좌표, 세로 좌표
    a는 구조물의 종류 0은 기둥, 1은 보
    b는  0은 삭제, 1은 설치
    설치 및 삭제할 때는 해당 작업 후 조건에 맞는지 확인 후 조건에 맞지 않으면 무시됨
    
    조건 : 
    기둥:  바닥 위, 보의 한쪽 끝 부분 위, 다른 기둥 위
    보 :  한쪽 끝 부분이 기둥 위, 양쪽 끝 부분이 다른 보와 동시에 연결
    기둥, 보는 교차점 좌표를 기준으로 오른쪽, 또는 위쪽 방향으로 설치되어 있음
    
    return 하는 배열의 원소는 [x, y, a] 형식
    
    
    문제 풀 때 확인할 점 
    순서도 중요하고 삭제도 있기 때문에 고민해야함 순서가 있는 ArrayList 로 해볼까
    
*/

import java.util.*;

class Solution {
    
    public static boolean isValid(ArrayList<Node> list, int n) {
        
        for(Node node : list) {
            
            // 기둥 바닥 위, 보의 한쪽 끝 부분 위, 다른 기둥 위
            if(node.a == 0) {
                boolean check = false;
                if(node.y == 0) check = true;
                else {
                    for(Node temp : list) {
                        if(temp.a == 0 && temp.x == node.x && temp.y == node.y - 1)  check = true; // 기둥 위
                        else if(temp.a == 1 &&  temp.x == node.x && temp.y == node.y) check = true;// 보 왼쪽 
                        else if(temp.a == 1 &&  temp.x + 1 == node.x && temp.y == node.y) check = true;// 보 오른쪽
                    }
                }
                if(!check) return false;
            } 
            
            // 보 한쪽 끝 부분이 기둥 위, 양쪽 끝 부분이 다른 보와 동시에 연결
            else {
                boolean check = false;
                boolean left = false;
                boolean right = false;
                
                for(Node temp : list) {
                    if(temp.a == 0 && temp.x == node.x && temp.y == node.y -1)  check = true; // 기둥 위 왼쪽 보
                    if(temp.a == 0 &&  temp.x == node.x + 1 && temp.y == node.y -1) check = true;// 기둥 위 오른쪽 보
                    if(temp.a == 1 &&  temp.x + 1 == node.x && temp.y == node.y) left = true;// 보 왼쪽 연결
                    if(temp.a == 1 &&  temp.x == node.x + 1 && temp.y == node.y) right = true;// 보 오른쪽 연결
                                
                }
                
                if(left && right) check = true;
                
                if(!check) return false;
                
            }   
        }
        
        return true;
    }
    
    public int[][] solution(int n, int[][] build_frame) {
            
        ArrayList<Node> list = new ArrayList<>();
        for(int[] node : build_frame) {
            
            int x = node[0];
            int y = node[1];
            int a = node[2];
            int b = node[3];
            
            // 삭제
            if(b == 0) {
                ArrayList<Node> temp = new ArrayList<>();
                // 삭제 후 확인을 위한 list
                for (Node tempNode : list) {
                    temp.add(new Node(tempNode.x, tempNode.y, tempNode.a)); // 깊은 복사
                }
                
                for(int i = 0; i < temp.size(); i++) {
                    Node tempNode = temp.get(i);
                    if(tempNode.x == x && tempNode.y == y && tempNode.a == a) {
                        temp.remove(i);
                    }
                        
                }
                if(isValid(temp, n)) list = temp; // 삭제후에도 구조가 유지된다면
                
            }
            
            // 설치
            else {
                list.add(new Node(x, y, a));
                if(!isValid(list, n)) list.remove(list.size()-1);
            }
            
        }
        
        Collections.sort(list);
        
        int[][] result = new int[list.size()][3];
		for(int i = 0; i < list.size(); i ++){
			result[i][0] = list.get(i).x;
			result[i][1] = list.get(i).y;
			result[i][2] = list.get(i).a;
		}
        
        return result;
    }
    
    public class Node implements Comparable<Node>{
        int x, y, a;
        
        public Node(int x, int y, int a) {
            this.x = x;
            this.y = y;
            this.a = a;
        }
        
        @Override
        public int compareTo(Node other) {
            if(this.x == other.x) {
                if(this.y == other.y) {
                    return Integer.compare(this.a, other.a);
                }
                return Integer.compare(this.y, other.y);
            }
            return Integer.compare(this.x, other.x);
        }
    } 
}