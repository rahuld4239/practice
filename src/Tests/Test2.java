package Tests;

public class Test2 {

    public static String test(String str) {

        int i = 0;
        int size = 0;
        int temp = -1;
        while(i<str.length()) {

            if(temp != (str.charAt(i) - '0')) {
                temp = str.charAt(i) - '0';
                size = 1;
            }
            else size++;

            i++;
            if(temp == size) return "true";

        }

        return "false";
    }

    public static void main(String[] args) {

        System.out.println(test("56799653338"));
    }
}
