
//�������ǵĵ�һ��java.applet���ó��򱣴����ļ�HelloEducation.java��
import java.awt.Graphics;//�ڽ�����ʾ���ʱ����Ҫ�õ���Graphics�Ķ���
import java.applet.Applet;//Applet�������е�java.applet�ĸ���;

public class HelloEducation extends Applet {
    // ����Ա�������ȡ��ΪHelloEducation
    // ���е�applet������Applet�������
    public String s;

    public void init() {
        s = new String("Welcome to Java World!");// ����һ���ַ�������
    }

    public void paint(Graphics graphics) {
        graphics.drawString(s, 25, 25);// �������������Ϊ(25,25)��λ����ʾ�ַ���s
    }

}
