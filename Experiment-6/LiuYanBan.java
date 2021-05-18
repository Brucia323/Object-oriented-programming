import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class LiuYanBan extends Applet implements ActionListener {
    private Label L_head, L_author, L_title, L_content;
    private TextField T_author, T_title;
    private TextArea A_content;
    private Button submit, reset, display;
    private Panel p12, p21, p22, p31, p32, p41, p42, p43;

    @Override
    public void init() {
        setLayout(new GridLayout(5, 3));

        L_head = new Label("留言板");
        L_author = new Label("作者:");
        L_title = new Label("标题:");
        L_content = new Label("内容:");

        T_author = new TextField(30);
        T_title = new TextField(30);

        A_content = new TextArea(4, 10);

        submit = new Button("submit");
        reset = new Button("reset");
        display = new Button("display");

        p12 = new Panel();
        p12.setFont(new Font("宋体",Font.BOLD,28));
        p12.setForeground(Color.red);
        p12.setLayout(new GridLayout(1, 3));
        p12.add(new Label(""));
        p12.add(L_head);
        p12.add(new Label(""));

        p21 = new Panel();
        p21.setFont(new Font("宋体",Font.BOLD,20));
        p21.setLayout(new GridLayout(1, 3));
        p21.add(new Label(""));
        p21.add(new Label(""));
        p21.add(L_author);

        p22 = new Panel();
        p22.setFont(new Font("宋体",Font.BOLD,20));
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
        p31.setFont(new Font("宋体",Font.BOLD,20));
        p31.setLayout(new GridLayout(1, 3));
        p31.add(new Label(""));
        p31.add(new Label(""));
        p31.add(L_title);

        p32 = new Panel();
        p32.setFont(new Font("宋体",Font.BOLD,20));
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
        p41.setFont(new Font("宋体",Font.BOLD,20));
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
        p42.setFont(new Font("宋体",Font.BOLD,20));
        p42.setLayout(new GridLayout(1, 2));
        p42.add(A_content);
        p42.add(new Label(""));

        p43 = new Panel();
        p43.setFont(new Font("宋体",Font.BOLD,20));
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

        submit.addActionListener(this);
        reset.addActionListener(this);
        display.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == submit) {
            MessageSet messageSet = new MessageSet(T_author.getText(), T_title.getText(), A_content.getText());
            try {
                messageSet.messageSet();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            T_author.setText(" ");
            T_title.setText(" ");
            A_content.setText(" ");
            T_author.setText("");
            T_title.setText("");
            A_content.setText("");

        }
        if (e.getSource() == reset) {
            T_author.setText(" ");
            T_title.setText(" ");
            A_content.setText(" ");
            T_author.setText("");
            T_title.setText("");
            A_content.setText("");
        }
        repaint();
    }
}