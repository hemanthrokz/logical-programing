public class ArmstrongNumbers {
    public static void main(String[] args) {
        System.out.println("ArmstrongNumbers  present in given limit are :");

        for (int n = 1; n <= 1000; n++) {
            int a, i = 0, j = 0;
            a = n;
            while (a > 0) {
                i = a % 10;
                j = j + (i * i * i);
                a = a / 10;
            }
            if (n == j) {
                System.out.println(n);
            } }
    }}