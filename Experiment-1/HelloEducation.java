
//这是我们的第一个java.applet，该程序保存在文件HelloEducation.java中
import java.awt.Graphics;//在进行显示输出时，需要用到类Graphics的对象；
import java.applet.Applet;//Applet类是所有的java.applet的父类;

public class HelloEducation extends Applet {
    // 程序员给这个类取名为HelloEducation
    // 所有的applet程序都是Applet类的子类
    public String s;

    public void init() {
        s = new String("Welcome to Java World!");// 生成一个字符串对象
    }

    public void paint(Graphics graphics) {
        graphics.drawString(s, 25, 25);// 在浏览器中坐标为(25,25)的位置显示字符串s
    }

}
