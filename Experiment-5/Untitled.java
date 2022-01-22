import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Untitled extends Applet implements ActionListener {
    Label firstLabel, secondLabel, thirdLabel;
    Button leftButton, centerButton, rightButton;
    int x1, y1, x2, y2, x, y;
    String str;

    @Override
    public void init() {
        firstLabel = new Label("first");
        secondLabel = new Label("second");
        thirdLabel = new Label("third");
        leftButton = new Button("left");
        centerButton = new Button("center");
        rightButton = new Button("right");
        add(firstLabel);
        add(secondLabel);
        add(thirdLabel);
        add(leftButton);
        add(centerButton);
        add(rightButton);
        leftButton.addActionListener(this);
        centerButton.addActionListener(this);
        rightButton.addActionListener(this);
        setForeground(Color.BLACK);
        setBackground(Color.cyan);
        x1 = y1 = x2 = y2 = x = y = 0;
        str = "";
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.drawLine(x1, y1, x2, y2);
        g.setColor(Color.yellow);
        g.drawString(str, x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == leftButton) {
            str = "��������left��ť����ǩ�ϵ����ֵĶ��뷽ʽ���޸�Ϊ�������";
            firstLabel.setAlignment(Label.LEFT);
            secondLabel.setAlignment(Label.LEFT);
            thirdLabel.setAlignment(Label.LEFT);
        }
        if (e.getSource() == centerButton) {
            str = "��������center��ť����ǩ�ϵ����ֵĶ��뷽ʽ���޸�Ϊ���ж���";
            firstLabel.setAlignment(Label.CENTER);
            secondLabel.setAlignment(Label.CENTER);
            thirdLabel.setAlignment(Label.CENTER);
        }
        if (e.getSource() == rightButton) {
            str = "��������right��ť����ǩ�ϵ����ֵĶ��뷽ʽ���޸�Ϊ���Ҷ���";
            firstLabel.setAlignment(Label.RIGHT);
            secondLabel.setAlignment(Label.RIGHT);
            thirdLabel.setAlignment(Label.RIGHT);
        }
        x2 = 10000;
        y1 = y2 = 30;
        y = 55;
        repaint();
    }

}
