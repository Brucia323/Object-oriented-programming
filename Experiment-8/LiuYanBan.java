import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 留言板
 *
 * @version 4.1
 */
public class LiuYanBan extends Applet implements ActionListener, MouseListener {
    private static final Frame LiuYanBan = null;
    private Label L_head, L_author, L_title, L_content, label;
    private TextField T_author, T_title;
    private TextArea A_content;
    private Button submit, reset, display, button;
    private Panel p12, p21, p22, p31, p32, p41, p42, p43, p51, panel;
    private String userString,titleString,contentString;
    private Message message;
    private Label time;
    private Timer timer;
    private String text;
    private int days, hours, minutes, seconds;
    private Dialog dialog;
    private User login,enroll;

    @Override
    public void init() {
        setLayout(new GridLayout(5, 3));

        L_head = new Label("登录");
        L_author = new Label("用户名：");
        L_title = new Label("密码：");
        L_content = new Label("内容:");

        T_author = new TextField(30);
        T_title = new TextField(30);

        A_content = new TextArea("", 4, 10, 1);

        submit = new Button("登录");
        reset = new Button("游客登录");
        display = new Button("注册");

        label = new Label();
        button = new Button("确定");

        days = hours = minutes = seconds = 0;
        text = "您已使用本系统" + days + "天" + hours + "小时" + minutes + "分钟" + seconds + "秒";
        time = new Label(text);
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

        dialog = new Dialog(LiuYanBan, "提示", true);
        dialog.setSize(300, 200);
        dialog.setLocation(760, 300);
        panel = new Panel();
        panel.setFont(new Font("宋体", Font.BOLD, 20));
        panel.setLayout(new GridLayout(2, 1));
        panel.add(label);
        panel.add(button);
        dialog.add(panel);
        button.addActionListener(this);

        p12 = new Panel();
        p12.setFont(new Font("宋体", Font.BOLD, 28));
        p12.setForeground(Color.red);
        p12.setLayout(new GridLayout(1, 3));
        p12.add(new Label(""));
        p12.add(L_head);
        p12.add(new Label(""));

        p21 = new Panel();
        p21.setFont(new Font("宋体", Font.BOLD, 20));
        p21.setLayout(new GridLayout(1, 3));
        p21.add(new Label(""));
        p21.add(new Label(""));
        p21.add(L_author);

        p22 = new Panel();
        p22.setFont(new Font("宋体", Font.BOLD, 20));
        p22.setLayout(new GridLayout(3, 2));
        p22.add(new Label(""));
        p22.add(new Label(""));
        p22.add(T_author);
        p22.add(new Label(""));
        p22.add(new Label(""));
        p22.add(new Label(""));

        p31 = new Panel();
        p31.setFont(new Font("宋体", Font.BOLD, 20));
        p31.setLayout(new GridLayout(1, 3));
        p31.add(new Label(""));
        p31.add(new Label(""));
        p31.add(L_title);

        p32 = new Panel();
        p32.setFont(new Font("宋体", Font.BOLD, 20));
        p32.setLayout(new GridLayout(3, 2));
        p32.add(new Label(""));
        p32.add(new Label(""));
        p32.add(T_title);
        p32.add(new Label(""));
        p32.add(new Label(""));
        p32.add(new Label(""));

        p41 = new Panel();
        p41.setFont(new Font("宋体", Font.BOLD, 20));
        p41.setLayout(new GridLayout(3, 3));
        p41.add(new Label(""));
        p41.add(new Label(""));
        p41.add(L_content);
        p41.add(new Label(""));
        p41.add(new Label(""));
        p41.add(new Label(""));
        p41.add(new Label(""));
        p41.add(new Label(""));
        p41.add(new Label(""));

        p42 = new Panel();
        p42.setFont(new Font("宋体", Font.BOLD, 20));
        p42.setLayout(new GridLayout(1, 2));
        p42.add(A_content);
        p42.add(new Label(""));

        p43 = new Panel();
        p43.setFont(new Font("宋体", Font.BOLD, 20));
        p43.setLayout(new GridLayout(3, 3));
        p43.add(submit);
        p43.add(new Label(""));
        p43.add(new Label(""));
        p43.add(reset);
        p43.add(new Label(""));
        p43.add(new Label(""));
        p43.add(display);
        p43.add(new Label(""));
        p43.add(new Label(""));

        p51 = new Panel();
        p51.setFont(new Font("宋体", Font.BOLD, 20));
        p51.setLayout(new GridLayout(3, 1));
        p51.add(new Label(""));
        p51.add(new Label(""));
        p51.add(time);

        add(new Label(""));
        add(p12);
        add(new Label(""));

        add(p21);
        add(p22);
        add(new Label(""));

        add(p31);
        add(p32);
        add(new Label(""));

        add(p41);
        add(p42);
        add(p43);

        add(p51);

        L_content.setVisible(false);
        A_content.setVisible(false);
        T_title.setEchoChar('*');

        submit.addActionListener(this);
        reset.addActionListener(this);
        display.addActionListener(this);
        T_author.addMouseListener(this);
        T_title.addMouseListener(this);

        message = new Message();
    }

    @Override
    public void paint(Graphics g) {
        text = "您已使用本系统" + days + "天" + hours + "小时" + minutes + "分钟" + seconds + "秒";
        time.setText(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            if (submit.getLabel().equals("登录")) {
                login = new User(T_author.getText(), T_title.getText());
                if (T_author.getText().isEmpty() || T_title.getText().isEmpty()) {
                    label.setText("请输入用户名或密码");
                    dialog.setVisible(true);
                } else
                    try {
                        if (!login.verify()) {
                            label.setText("用户名或密码错误");
                            dialog.setVisible(true);
                        } else {
                            L_content.setVisible(true);
                            A_content.setVisible(true);
                            display.setVisible(true);
                            L_head.setText("留言板");
                            L_author.setText("作者：");
                            L_title.setText("标题：");
                            submit.setLabel("提交");
                            reset.setLabel("重置");
                            display.setLabel("显示");
                            T_author.setEditable(false);
                            T_title.setEchoChar((char) 0);
                            T_title.setText(" ");
                            T_title.setText("");
                            userString = T_author.getText();
                        }
                    } catch (IOException e1) {
                        label.setText("验证失败");
                        dialog.setVisible(true);
                    }
            } else if (submit.getLabel().equals("提交")) {
                if (T_title.getText().isEmpty()) {
                    label.setText("请输入标题");
                    dialog.setVisible(true);
                } else if (A_content.getText().isEmpty()) {
                    label.setText("请输入内容");
                    dialog.setVisible(true);
                } else if (T_title.getText().indexOf("&") != -1 || A_content.getText().indexOf("&") != -1) {
                    label.setText("不允许输入&符号");
                    dialog.setVisible(true);
                } else if (A_content.getText().indexOf("\n") != -1) {
                    label.setText("不允许换行输入");
                    dialog.setVisible(true);
                } else {
                    message.setAuthor(T_author.getText());
                    message.setTitle(T_title.getText());
                    message.setContent(A_content.getText());
                    try {
                        message.write();
                        label.setText("留言成功");
                        dialog.setVisible(true);
                        T_title.setText(" ");
                        A_content.setText(" ");
                        T_title.setText("");
                        A_content.setText("");
                        message = new Message();
                        display.setLabel("显示");
                    } catch (IOException e1) {
                        label.setText("留言失败");
                        dialog.setVisible(true);
                    }
                }
            } else if (submit.getLabel().equals("第一条")) {
                try {
                    message = new Message();
                    message.read();
                    T_author.setText(message.getAuthor());
                    T_title.setText(message.getTitle());
                    A_content.setText(message.getContent());
                    reset.setLabel("下一条");
                } catch (IOException e1) {
                    label.setText("读取失败");
                    dialog.setVisible(true);
                }
            } else if (submit.getLabel().equals("注册")){
                if (T_title.getText().length() < 6) {
                    label.setText("密码至少6位");
                    dialog.setVisible(true);
                } else {
                    enroll = new User(T_author.getText(), T_title.getText());
                    try {
                        if (enroll.enroll()) {
                            label.setText("注册成功");
                            dialog.setVisible(true);
                            L_head.setText("登录");
                            submit.setLabel("登录");
                            display.setLabel("注册");
                            reset.setVisible(true);
                        } else {
                            label.setText("该账户已存在");
                            dialog.setVisible(true);
                        }
                    } catch (IOException e1) {
                        label.setText("注册失败");
                        dialog.setVisible(true);
                    }
                }
            }
        }
        if (e.getSource() == reset) {
            if (reset.getLabel().equals("游客登录")) {
                T_author.setText("游客" + System.currentTimeMillis());
                L_content.setVisible(true);
                A_content.setVisible(true);
                display.setVisible(true);
                L_head.setText("留言板");
                L_author.setText("作者：");
                L_title.setText("标题：");
                submit.setLabel("提交");
                reset.setLabel("重置");
                display.setLabel("显示");
                T_author.setEditable(false);
                T_title.setEchoChar((char) 0);
                T_title.setText(" ");
                T_title.setText("");
                userString = T_author.getText();
            } else if (reset.getLabel().equals("重置")) {
                T_title.setText(" ");
                A_content.setText(" ");
                T_title.setText("");
                A_content.setText("");
                titleString = "";
                contentString = "";
            } else if (reset.getLabel().equals("下一条")) {
                try {
                    message.read();
                    T_author.setText(message.getAuthor());
                    T_title.setText(message.getTitle());
                    A_content.setText(message.getContent());
                } catch (Exception e1) {
                    reset.setLabel("最后一个");
                }
            }
        }
        if (e.getSource() == display) {
            if (display.getLabel().equals("显示")) {
                try {
                    titleString = T_title.getText();
                    contentString = A_content.getText();
                    message.clickDisplay();
                    message.read();
                    T_author.setText(message.getAuthor());
                    T_title.setText(message.getTitle());
                    A_content.setText(message.getContent());
                    T_title.setEditable(false);
                    A_content.setEditable(false);
                    display.setLabel("返回");
                    submit.setLabel("第一条");
                    reset.setLabel("下一条");
                } catch (IOException e1) {
                    label.setText("读取失败");
                    dialog.setVisible(true);
                }
            } else if (display.getLabel().equals("返回")) {
                if (L_head.getText().equals("留言板")) {
                    T_title.setText(" ");
                    A_content.setText(" ");
                    T_title.setText("");
                    A_content.setText("");
                    T_author.setText(userString);
                    T_title.setText(titleString);
                    A_content.setText(contentString);
                    T_title.setEditable(true);
                    A_content.setEditable(true);
                    submit.setLabel("提交");
                    reset.setLabel("重置");
                    display.setLabel("显示");
                } else if (L_head.getText().equals("注册")) {
                    L_head.setText("登录");
                    submit.setLabel("登录");
                    reset.setVisible(true);
                    display.setLabel("注册");
                }
            } else if (display.getLabel().equals("注册")) {
                L_head.setText("注册");
                submit.setLabel("注册");
                display.setLabel("返回");
                T_author.setText(" ");
                T_title.setText(" ");
                T_author.setText("");
                T_title.setText("");
                reset.setVisible(false);
            }
        }
        if (e.getSource() == button) {
            dialog.setVisible(false);
        }

        repaint();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == T_author) {
            if (L_author.getText().equals("用户名：")) {
                T_author.setText(" ");
                T_author.setText("");
            }
        }
        if (e.getSource() == T_title) {
            if (L_title.getText().equals("密码：")) {
                T_title.setText(" ");
                T_title.setText("");
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}