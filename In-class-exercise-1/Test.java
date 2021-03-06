/* 课内练习1：
编写水仙花数类，要求如下:
1. 设计该类的构造方法；
2. 设计方法来存取类中的属性；
3. 设计方法以判断是否水仙花数。
注：将main函数写在另外的Test类中实例化水仙花数类，并通过调用对象的方法来输出水仙花数。
 */
public class Test {
    public static void main(String[] args) {
        int number = 100;
        while (number < 1000) {
            DaffodilCount daffodilCount = new DaffodilCount(number);
            if (daffodilCount.Calculation()) {
                System.out.println(number);
            }
            number++;
        }
    }
}

class DaffodilCount {
    private int number;

    public DaffodilCount(int num) {
        number = num;
    }

    public Boolean Calculation() {
        int a, b, c;
        a = number / 100;
        b = (number % 100) / 10;
        c = number % 10;
        if (power(a) + power(b) + power(c) == number) {
            return true;
        } else {
            return false;
        }
    }

    public static int power(int a) {
        return a * a * a;
    }

}