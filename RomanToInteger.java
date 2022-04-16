import java.util.HashMap;
import java.util.Scanner;

/*Question : Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
        For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

        Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

        I can be placed before V (5) and X (10) to make 4 and 9.
        X can be placed before L (50) and C (100) to make 40 and 90.
        C can be placed before D (500) and M (1000) to make 400 and 900.*/
        
        
public class RomanToInteger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int result = romanToInt(s);
        System.out.println("result : "+result);
    }

    public static int romanToInt(String s){
        int n = 0;
        char[] romanChar = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] number = {1, 5, 10, 50, 100, 500, 1000};
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        n = map.get(s.charAt(0));
        for(byte i=1; i<s.length(); i++){
            int priv = map.get(s.charAt(i-1));
            int current = map.get(s.charAt(i));
            if (priv >= current) n = n+map.get(s.charAt(i));
            else n = n-priv+current-priv;
        }
        return n;
    }

}
