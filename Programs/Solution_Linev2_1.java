package Programmers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static Backjoon.Main2251.input;

public class Solution_Linev2_1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("line", new String[]{"-s STRING", "-num NUMBER", "-e NULL", "-n ALIAS -num"},
                new String[]{"line -n 100 -s hi -e", "line -n 100 -e -num 150"})));
        System.out.println(Arrays.toString(solution("bank", new String[]{"-send STRING", "-a ALIAS -amount", "-amount NUMBERS"},
                new String[]{"bank -send abc -amount 500 200 -a 400", "bank -send abc -a hey"})));
    }

    public static boolean[] solution(String program, String[] flag_rules, String[] commands) {

        //프로그램 담기
        ProgramDTO programDto = new ProgramDTO(new HashMap<>());
        programDto.setCommand(input(program, flag_rules));


        // 해당 프로그램들 데이터에 대한 클래스 생성
        Map<String, ProgramDTO> programs = new HashMap<>();
        programs.put(program, programDto);

        //로직 처리
        boolean[] answer = solve(programs, commands);

        return answer;
    }

    private static boolean[] solve(Map<String, ProgramDTO> programs, String[] commands) {
        boolean[] answer = new boolean[commands.length];
        Arrays.fill(answer, true);

        //각 명령어 별로 체크해보기
        for (int command = 0; command < commands.length; command++) {
            String[] div_command = commands[command].split(" -");
            // 명령어 분리해서 몇 번쨰 단계인지 체크
            for (int idx_command = 1; idx_command < div_command.length; idx_command++) {
                String[] detail_command = div_command[idx_command].split(" ");

                //이름에 맞는 케이스 있는지 확인
                if (!programs.containsKey(div_command[0])) {
                    answer[command] = false;
                    break;
                } else {
                    ProgramDTO programDTO = programs.get(div_command[0]);

                    //false인 경우 볼 필요 X
                    if (answer[command]) {
                        //각 경우 맞는지 확인
                        ArrayList<String> Stringlist = new ArrayList<>();
                        for (int i = 1; i < detail_command.length; i++) {
                            Stringlist.add(detail_command[i]);
                        }
                            if (!programDTO.getCommand().containsKey('-' + detail_command[0])) {
                                answer[command] = false;
                                break;
                            } else {
                                boolean flag = programDTO.getCommand().get('-' + detail_command[0]).checkType(Stringlist);
                                if (!flag) {
                                    answer[command] = false;
                                    break;
                                } else {
                                    answer[command] = true;
                                }
                            }

                    }
                }

            }
        }

        return answer;
    }

    //데이터 만들기
    private static Map<String, Flag_argument_type> input(String program, String[] flag_rules) {
        Map<String, Flag_argument_type> inputMap = new HashMap<>();
        Map<String, String> AliasMap = new HashMap<>();

        for (int i = 0; i < flag_rules.length; i++) {
            String[] flag = flag_rules[i].split(" ");
            if (flag.length == 2) {
                switch (flag[1]) {
                    case "STRING":
                        inputMap.put(flag[0], new Strings());
                        break;
                    case "STRINGS":
                        inputMap.put(flag[0], new Mult_Strings());
                        break;
                    case "NUMBER":
                        inputMap.put(flag[0], new Numbers());
                        break;
                    case "NUMBERS":
                        inputMap.put(flag[0], new Mult_Numbers());
                        break;
                    case "NULL":
                        inputMap.put(flag[0], new Nulls());
                        break;
                }
            }else if(flag.length == 3){
                AliasMap.put(flag[0],flag[2]);
            }

            for(String key : AliasMap.keySet()){
                inputMap.put(key,inputMap.get(AliasMap.get(key)));
            }
        }
        return inputMap;
    }

    //프로그램을 담기 위한 클래스
    static class ProgramDTO {
        Map<String, Flag_argument_type> command;

        public Map<String, Flag_argument_type> getCommand() {
            return command;
        }

        public void setCommand(Map<String, Flag_argument_type> command) {
            this.command = command;
        }

        public ProgramDTO(Map<String, Flag_argument_type> command) {
            this.command = command;
        }
    }

    //공통적인 특징 인터페이스
    interface Flag_argument_type {
        boolean checkType(ArrayList<String> list);
    }

    //널인지 비교
    static class Nulls implements Flag_argument_type {

        @Override
        public boolean checkType(ArrayList<String> list) {
            if(list.size() !=0)return false;

            return true;
        }
    }

    //숫자인지 비교
    static class Numbers implements Flag_argument_type {

        @Override
        public boolean checkType(ArrayList<String> list) {
            if(list.size() !=1)return false;

            String input = list.get(0);
            for (int i = 0; i < input.length(); i++) {
                if (!(input.charAt(i) - '0' >= 0 && input.charAt(i) - '9' <= 0)) {
                    return false;
                }
            }
            return true;
        }
    }

    //여러 숫자인지 비교
    static class Mult_Numbers implements Flag_argument_type {

        @Override
        public boolean checkType(ArrayList<String> list) {
            for(String input : list) {
                for (int i = 0; i < input.length(); i++) {
                    if (!(input.charAt(i) - '0' >= 0 && input.charAt(i) - '9' <= 0)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    //알파벳인지 비교
    static class Strings implements Flag_argument_type {


        @Override
        public boolean checkType(ArrayList<String> list) {
            if(list.size() !=1)return false;

            String input = list.get(0);
            for (int i = 0; i < input.length(); i++) {
                if (!(input.charAt(i) - 'a' >= 0 && input.charAt(i) - 'z' <= 0)
                        && !(input.charAt(i) - 'A' >= 0 && input.charAt(i) - 'Z' <= 0)) {
                    return false;
                }
            }
            return true;
        }
    }

    //여러 알파벳인지 비교
    static class Mult_Strings implements Flag_argument_type {

        @Override
        public boolean checkType(ArrayList<String> list) {
            for(String input : list) {
                for (int i = 0; i < input.length(); i++) {
                    if (!(input.charAt(i) - 'a' >= 0 && input.charAt(i) - 'z' <= 0)
                            && !(input.charAt(i) - 'A' >= 0 && input.charAt(i) - 'Z' <= 0)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
