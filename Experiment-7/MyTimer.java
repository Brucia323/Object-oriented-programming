import java.applet.Applet;
import java.awt.*;
import java.util.TimerTask;
import java.util.*;
import java.awt.event.*;

public class MyTimer extends Applet implements ActionListener {
    private Label time;
    private Button pause, resume;
    private Timer timer;
    private String text;
    private int days, hours, minutes, seconds;

    @Override
    public void init() {
        days = hours = minutes = seconds = 0;
        text = "您已使用本系统" + days + "天" + hours + "小时" + minutes + "分钟" + seconds + "秒";
        time = new Label(text);
        pause = new Button("pause");
        resume = new Button("resume");
        timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                seconds += 1;
                if (seconds == 60) {
                    minutes += 1;
                    seconds = 0;
                    if (minutes == 60) {
                        hours += 1;
                        minutes = 0;
                        if (hours == 24) {
                            days += 1;
                            hours = 0;
                        }
                    }
                }
                repaint();
            }
        }, 0, 1000);
        add(time);
        add(pause);
        add(resume);
        pause.addActionListener(this);
        resume.addActionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        text = "您已使用本系统" + days + "天" + hours + "小时" + minutes + "分钟" + seconds + "秒";
        time.setText(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pause) {
            if (pause.getLabel() == "pause") {
                timer.cancel();
                pause.setLabel("continue");
            } else {
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    public void run() {
                        seconds += 1;
                        if (seconds == 60) {
                            minutes += 1;
                            seconds = 0;
                            if (minutes == 60) {
                                hours += 1;
                                minutes = 0;
                                if (hours == 24) {
                                    days += 1;
                                    hours = 0;
                                }
                            }
                        }
                        repaint();
                    }
                }, 0, 1000);
                pause.setLabel("pause");
            }
        }
        if (e.getSource() == resume) {
            days = hours = minutes = seconds = 0;
        }
    }
}
