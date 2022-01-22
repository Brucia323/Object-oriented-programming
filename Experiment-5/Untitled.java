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
            str = "您按下了left按钮，标签上的文字的对齐方式将修改为靠左对齐";
            firstLabel.setAlignment(Label.LEFT);
            secondLabel.setAlignment(Label.LEFT);
            thirdLabel.setAlignment(Label.LEFT);
        }
        if (e.getSource() == centerButton) {
            str = "您按下了center按钮，标签上的文字的对齐方式将修改为居中对齐";
            firstLabel.setAlignment(Label.CENTER);
            secondLabel.setAlignment(Label.CENTER);
            thirdLabel.setAlignment(Label.CENTER);
        }
        if (e.getSource() == rightButton) {
            str = "您按下了right按钮，标签上的文字的对齐方式将修改为靠右对齐";
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
