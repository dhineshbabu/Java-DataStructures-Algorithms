package gfgalgo.strings;



public class Prob_LeftMostNonRepeatingChar {
    /*
    same as leftmost repeating character
    with modified sections
     */


    static final int CHAR = 256;
    static int leftMost(String str) {

        boolean[] visited = new boolean[CHAR];

        char res = ' ';

        for(int i=str.length()-1; i>=0; i--) {
            if(visited[str.charAt(i)] || str.charAt(i)==res){
                if(str.charAt(i)==res) res = ' ';
                continue;
            } else {
                visited[str.charAt(i)] = true;
                res = str.charAt(i);
            }
        }

        return str.indexOf(res);
    }

    public static void main(String[] args) {
        String str = "cabba"; // index of a should be the answer
        System.out.println(leftMost(str));
    }
}
