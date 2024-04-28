class Solution {
    public String solution(String new_id) {
        String answer = new_id;

        // 1단계 모든 대문자 -> 소문자
        answer = answer.toLowerCase();

        //2단계
        StringBuilder step2 = new StringBuilder();
        for (int i = 0; i < answer.length(); i++) {
            char compare = answer.charAt(i);
            if ((compare >= 'a' && compare <= 'z') || (compare >= '0' && compare <= '9') || (compare == '-') || (compare == '_') || (compare == '.')) {
                step2.append(compare);
            }
        }
        answer = step2.toString();

        //3단계
        while (answer.contains("..")) {
            answer = answer.replace("..", ".");
        }

        //4단계
        if(answer.length()>0){
            if (answer.charAt(0) == '.') {
                answer =answer.substring(1, answer.length());
            }

        }
        if(answer.length()>0) {
            if (answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, answer.length() - 1);
            }
        }

        //5단계
        if (answer.length() == 0) {
            answer = "a";
        }

        //6단계
        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
            if (answer.charAt(14) == '.') {
                answer = answer.substring(0, 14);
            }
        }

        //7단계
        StringBuilder step7 = new StringBuilder(answer);
        if(step7.length()<=2){
            char k=step7.charAt(answer.length()-1);

            while (step7.length() < 3) {
                step7.append(k);
            }
            answer=step7.toString();
        }

        return answer;
    }
}