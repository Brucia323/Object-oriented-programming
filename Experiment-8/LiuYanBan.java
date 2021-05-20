import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

//TODO awt's dialog and timer
public class LiuYanBan extends Applet implements ActionListener, MouseListener {
    private Label L_head, L_author, L_title, L_content;
    private TextField T_author, T_title;
    private TextArea A_content;
    private Button submit, reset, display;
    private Panel p12, p21, p22, p31, p32, p41, p42, p43;
    private String userString;
    private Message message;

    @Override
    public void init() {
        setLayout(new GridLayout(5, 3));

        L_head = new Label("登录");
        L_author = new Label("用户名：");
        L_title = new Label("密码：");
        L_content = new Label("内容:");

        T_author = new TextField(30);
        T_title = new TextField(30);

        A_content = new TextArea(4, 10);

        submit = new Button("login");
        reset = new Button("guest");
        display = new Button("display");

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
        p22.setLayout(new GridLayout(3, 3));
        p22.add(new Label(""));
        p22.add(new Label(""));
        p22.add(new Label(""));
        p22.add(T_author);
        p22.add(new Label(""));
        p22.add(new Label(""));
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
        p32.setLayout(new GridLayout(3, 3));
        p32.add(new Label(""));
        p32.add(new Label(""));
        p32.add(new Label(""));
        p32.add(T_title);
        p32.add(new Label(""));
        p32.add(new Label(""));
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

        L_content.setVisible(false);
        A_content.setVisible(false);
        display.setVisible(false);
        T_title.setEchoChar('*');

        submit.addActionListener(this);
        reset.addActionListener(this);
        display.addActionListener(this);
        T_author.addMouseListener(this);
        T_title.addMouseListener(this);
        A_content.addMouseListener(this);

        try {
            message = new Message();
        } catch (IOException e) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            if (submit.getLabel().equals("login")) {
                if (T_author.getText().isEmpty()) {
                    T_author.setText("请输入用户名");
                } else if (T_title.getText().length() < 6) {
                    T_title.setEchoChar((char) 0);
                    T_title.setText("密码错误");
                } else {
                    L_content.setVisible(true);
                    A_content.setVisible(true);
                    display.setVisible(true);
                    L_head.setText("留言板");
                    L_author.setText("作者：");
                    L_title.setText("标题：");
                    submit.setLabel("submit");
                    reset.setLabel("reset");
                    T_author.setEditable(false);
                    T_title.setEchoChar((char) 0);
                    T_title.setText(" ");
                    T_title.setText("");
                    userString = T_author.getText();
                }
            } else if (submit.getLabel().equals("submit")) {
                if (T_title.getText().isEmpty() || A_content.getText().isEmpty()) {
                    reset.setLabel("留言失败");
                } else {
                    MessageSet messageSet = new MessageSet(T_author.getText(), T_title.getText(), A_content.getText());
                    try {
                        messageSet.messageSet();
                        reset.setLabel("留言成功");
                        T_title.setText(" ");
                        A_content.setText(" ");
                        T_title.setText("");
                        A_content.setText("");
                        message = new Message();
                        display.setLabel("display");
                    } catch (IOException e1) {
                        reset.setLabel("留言失败");
                    }
                }
            } else if (submit.getLabel().equals("first")) {
                try {
                    message = new Message();
                    message.message();
                    T_author.setText(message.getAuthor());
                    T_title.setText(message.getTitle());
                    A_content.setText(message.getContent());
                    reset.setLabel("next");
                } catch (IOException e1) {
                    submit.setLabel("读取失败");
                }
            }
        }
        if (e.getSource() == reset) {
            if (reset.getLabel().equals("guest")) {
                T_author.setText("游客" + System.currentTimeMillis());
                L_content.setVisible(true);
                A_content.setVisible(true);
                display.setVisible(true);
                L_author.setText("作者：");
                L_title.setText("标题：");
                submit.setLabel("submit");
                reset.setLabel("reset");
                T_author.setEditable(false);
                T_title.setEchoChar((char) 0);
                T_title.setText(" ");
                T_title.setText("");
                userString = T_author.getText();
            } else if (reset.getLabel().equals("reset")) {
                T_title.setText(" ");
                A_content.setText(" ");
                T_title.setText("");
                A_content.setText("");
            } else if (reset.getLabel().equals("next")) {
                try {
                    message.message();
                    T_author.setText(message.getAuthor());
                    T_title.setText(message.getTitle());
                    A_content.setText(message.getContent());
                } catch (Exception e1) {
                    reset.setLabel("at last");
                }
            }
        }
        if (e.getSource() == display) {
            if (display.getLabel().equals("display")) {
                try {
                    message.message();
                    T_author.setText(message.getAuthor());
                    T_title.setText(message.getTitle());
                    A_content.setText(message.getContent());
                    T_title.setEditable(false);
                    A_content.setEditable(false);
                    display.setLabel("close");
                    submit.setLabel("first");
                    reset.setLabel("next");
                } catch (IOException e1) {
                    display.setLabel("读取失败");
                } catch (Exception exception) {
                    try {
                        message = new Message();
                    } catch (IOException e1) {
                        display.setLabel("无留言");
                    }
                }
            } else if (display.getLabel().equals("close")) {
                T_author.setText(userString);
                T_title.setText(" ");
                A_content.setText(" ");
                T_title.setText("");
                A_content.setText("");
                T_title.setEditable(true);
                A_content.setEditable(true);
                submit.setLabel("submit");
                reset.setLabel("reset");
                display.setLabel("display");
            }
        }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == T_author) {
            if (L_author.getText().equals("用户名：")){
                T_author.setText(" ");
                T_author.setText("");
            }
        }
        if (e.getSource() == T_title) {
            if (L_title.getText().equals("密码：")){
                T_title.setText(" ");
                T_title.setText("");
                T_title.setEchoChar('*');
            }
            if (L_title.getText().equals("标题：")){
                reset.setLabel("reset");
            }
        }
        if (e.getSource() == A_content) {
            reset.setLabel("reset");
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