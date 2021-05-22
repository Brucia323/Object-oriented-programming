import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * ���԰�
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

        L_head = new Label("��¼");
        L_author = new Label("�û�����");
        L_title = new Label("���룺");
        L_content = new Label("����:");

        T_author = new TextField(30);
        T_title = new TextField(30);

        A_content = new TextArea("", 4, 10, 1);

        submit = new Button("��¼");
        reset = new Button("�ο͵�¼");
        display = new Button("ע��");

        label = new Label();
        button = new Button("ȷ��");

        days = hours = minutes = seconds = 0;
        text = "����ʹ�ñ�ϵͳ" + days + "��" + hours + "Сʱ" + minutes + "����" + seconds + "��";
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

        dialog = new Dialog(LiuYanBan, "��ʾ", true);
        dialog.setSize(300, 200);
        dialog.setLocation(760, 300);
        panel = new Panel();
        panel.setFont(new Font("����", Font.BOLD, 20));
        panel.setLayout(new GridLayout(2, 1));
        panel.add(label);
        panel.add(button);
        dialog.add(panel);
        button.addActionListener(this);

        p12 = new Panel();
        p12.setFont(new Font("����", Font.BOLD, 28));
        p12.setForeground(Color.red);
        p12.setLayout(new GridLayout(1, 3));
        p12.add(new Label(""));
        p12.add(L_head);
        p12.add(new Label(""));

        p21 = new Panel();
        p21.setFont(new Font("����", Font.BOLD, 20));
        p21.setLayout(new GridLayout(1, 3));
        p21.add(new Label(""));
        p21.add(new Label(""));
        p21.add(L_author);

        p22 = new Panel();
        p22.setFont(new Font("����", Font.BOLD, 20));
        p22.setLayout(new GridLayout(3, 2));
        p22.add(new Label(""));
        p22.add(new Label(""));
        p22.add(T_author);
        p22.add(new Label(""));
        p22.add(new Label(""));
        p22.add(new Label(""));

        p31 = new Panel();
        p31.setFont(new Font("����", Font.BOLD, 20));
        p31.setLayout(new GridLayout(1, 3));
        p31.add(new Label(""));
        p31.add(new Label(""));
        p31.add(L_title);

        p32 = new Panel();
        p32.setFont(new Font("����", Font.BOLD, 20));
        p32.setLayout(new GridLayout(3, 2));
        p32.add(new Label(""));
        p32.add(new Label(""));
        p32.add(T_title);
        p32.add(new Label(""));
        p32.add(new Label(""));
        p32.add(new Label(""));

        p41 = new Panel();
        p41.setFont(new Font("����", Font.BOLD, 20));
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
        p42.setFont(new Font("����", Font.BOLD, 20));
        p42.setLayout(new GridLayout(1, 2));
        p42.add(A_content);
        p42.add(new Label(""));

        p43 = new Panel();
        p43.setFont(new Font("����", Font.BOLD, 20));
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
        p51.setFont(new Font("����", Font.BOLD, 20));
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
        text = "����ʹ�ñ�ϵͳ" + days + "��" + hours + "Сʱ" + minutes + "����" + seconds + "��";
        time.setText(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            if (submit.getLabel().equals("��¼")) {
                login = new User(T_author.getText(), T_title.getText());
                if (T_author.getText().isEmpty() || T_title.getText().isEmpty()) {
                    label.setText("�������û���������");
                    dialog.setVisible(true);
                } else
                    try {
                        if (!login.verify()) {
                            label.setText("�û������������");
                            dialog.setVisible(true);
                        } else {
                            L_content.setVisible(true);
                            A_content.setVisible(true);
                            display.setVisible(true);
                            L_head.setText("���԰�");
                            L_author.setText("���ߣ�");
                            L_title.setText("���⣺");
                            submit.setLabel("�ύ");
                            reset.setLabel("����");
                            display.setLabel("��ʾ");
                            T_author.setEditable(false);
                            T_title.setEchoChar((char) 0);
                            T_title.setText(" ");
                            T_title.setText("");
                            userString = T_author.getText();
                        }
                    } catch (IOException e1) {
                        label.setText("��֤ʧ��");
                        dialog.setVisible(true);
                    }
            } else if (submit.getLabel().equals("�ύ")) {
                if (T_title.getText().isEmpty()) {
                    label.setText("���������");
                    dialog.setVisible(true);
                } else if (A_content.getText().isEmpty()) {
                    label.setText("����������");
                    dialog.setVisible(true);
                } else if (T_title.getText().indexOf("&") != -1 || A_content.getText().indexOf("&") != -1) {
                    label.setText("����������&����");
                    dialog.setVisible(true);
                } else if (A_content.getText().indexOf("\n") != -1) {
                    label.setText("������������");
                    dialog.setVisible(true);
                } else {
                    message.setAuthor(T_author.getText());
                    message.setTitle(T_title.getText());
                    message.setContent(A_content.getText());
                    try {
                        message.write();
                        label.setText("���Գɹ�");
                        dialog.setVisible(true);
                        T_title.setText(" ");
                        A_content.setText(" ");
                        T_title.setText("");
                        A_content.setText("");
                        message = new Message();
                        display.setLabel("��ʾ");
                    } catch (IOException e1) {
                        label.setText("����ʧ��");
                        dialog.setVisible(true);
                    }
                }
            } else if (submit.getLabel().equals("��һ��")) {
                try {
                    message = new Message();
                    message.read();
                    T_author.setText(message.getAuthor());
                    T_title.setText(message.getTitle());
                    A_content.setText(message.getContent());
                    reset.setLabel("��һ��");
                } catch (IOException e1) {
                    label.setText("��ȡʧ��");
                    dialog.setVisible(true);
                }
            } else if (submit.getLabel().equals("ע��")){
                if (T_title.getText().length() < 6) {
                    label.setText("��������6λ");
                    dialog.setVisible(true);
                } else {
                    enroll = new User(T_author.getText(), T_title.getText());
                    try {
                        if (enroll.enroll()) {
                            label.setText("ע��ɹ�");
                            dialog.setVisible(true);
                            L_head.setText("��¼");
                            submit.setLabel("��¼");
                            display.setLabel("ע��");
                            reset.setVisible(true);
                        } else {
                            label.setText("���˻��Ѵ���");
                            dialog.setVisible(true);
                        }
                    } catch (IOException e1) {
                        label.setText("ע��ʧ��");
                        dialog.setVisible(true);
                    }
                }
            }
        }
        if (e.getSource() == reset) {
            if (reset.getLabel().equals("�ο͵�¼")) {
                T_author.setText("�ο�" + System.currentTimeMillis());
                L_content.setVisible(true);
                A_content.setVisible(true);
                display.setVisible(true);
                L_head.setText("���԰�");
                L_author.setText("���ߣ�");
                L_title.setText("���⣺");
                submit.setLabel("�ύ");
                reset.setLabel("����");
                display.setLabel("��ʾ");
                T_author.setEditable(false);
                T_title.setEchoChar((char) 0);
                T_title.setText(" ");
                T_title.setText("");
                userString = T_author.getText();
            } else if (reset.getLabel().equals("����")) {
                T_title.setText(" ");
                A_content.setText(" ");
                T_title.setText("");
                A_content.setText("");
                titleString = "";
                contentString = "";
            } else if (reset.getLabel().equals("��һ��")) {
                try {
                    message.read();
                    T_author.setText(message.getAuthor());
                    T_title.setText(message.getTitle());
                    A_content.setText(message.getContent());
                } catch (Exception e1) {
                    reset.setLabel("���һ��");
                }
            }
        }
        if (e.getSource() == display) {
            if (display.getLabel().equals("��ʾ")) {
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
                    display.setLabel("����");
                    submit.setLabel("��һ��");
                    reset.setLabel("��һ��");
                } catch (IOException e1) {
                    label.setText("��ȡʧ��");
                    dialog.setVisible(true);
                }
            } else if (display.getLabel().equals("����")) {
                if (L_head.getText().equals("���԰�")) {
                    T_title.setText(" ");
                    A_content.setText(" ");
                    T_title.setText("");
                    A_content.setText("");
                    T_author.setText(userString);
                    T_title.setText(titleString);
                    A_content.setText(contentString);
                    T_title.setEditable(true);
                    A_content.setEditable(true);
                    submit.setLabel("�ύ");
                    reset.setLabel("����");
                    display.setLabel("��ʾ");
                } else if (L_head.getText().equals("ע��")) {
                    L_head.setText("��¼");
                    submit.setLabel("��¼");
                    reset.setVisible(true);
                    display.setLabel("ע��");
                }
            } else if (display.getLabel().equals("ע��")) {
                L_head.setText("ע��");
                submit.setLabel("ע��");
                display.setLabel("����");
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
            if (L_author.getText().equals("�û�����")) {
                T_author.setText(" ");
                T_author.setText("");
            }
        }
        if (e.getSource() == T_title) {
            if (L_title.getText().equals("���룺")) {
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