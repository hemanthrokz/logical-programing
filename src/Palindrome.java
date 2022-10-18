

public class Palindrome {
    public static void main(String[] args) {
        int c = 0;
        System.out.println("palindrome numbers present in given limit are :");

        for (int n = 100; n <= 300; n++) {
            int a, i = 0, j = 0;
            a = n;
            while (a > 0) {
                i = a % 10;
                j = (j * 10) + i;
                a = a / 10;
            }
            if (n == j) {
                System.out.println(n);
                c++;
            } }
        System.out.println("Number of palindrome numbers present in given limit = "+c);
    } }