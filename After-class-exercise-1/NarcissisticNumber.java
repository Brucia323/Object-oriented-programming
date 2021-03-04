/* 1. 水仙花数（ narcissistic number ）是指一个 n 位数 ( n≥3 )，它的每个位上的数字的 n 次幂之和等于它本身。
例如：1^3 + 5^3 + 3^3 = 153

编写相应的Java程序，获取所有的三位水仙花数。
 */
public class NarcissisticNumber {

    public static void main(String[] args) {
        int number = 100, a, b, c;
        while (number < 1000) {
            a = number / 100;
            b = (number % 100) / 10;
            c = number % 10;
            if (power(a) + power(b) + power(c) == number) {
                System.out.println(number);
            }
            number++;
        }
    }

    public static int power(int a) {
        return a * a * a;
    }
}
