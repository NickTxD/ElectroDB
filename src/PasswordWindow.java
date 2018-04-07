import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

class PasswordWindow extends JFrame {

    private JTextField login_text_field;
    private JPasswordField password_text_field;
    PasswordWindow(){

        super("Вход в БД");
        setLocation(600,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Box box1 = Box.createHorizontalBox();
        JLabel lableLogin = new JLabel("Логин");
        login_text_field = new JTextField(20);
        box1.add(lableLogin);
        box1.add(Box.createHorizontalStrut(14));
        box1.add(login_text_field);

        Box box2 = Box.createHorizontalBox();
        JLabel passwLabel = new JLabel("Пароль");
        password_text_field = new JPasswordField (4);
        box2.add(Box.createHorizontalGlue());
        box2.add(passwLabel);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(password_text_field);

        Box box3 = Box.createHorizontalBox();
        JButton button_ok = new JButton("Вход");
        JButton button_cancel = new JButton("Отмена");
        box3.add(Box.createHorizontalGlue());
        box3.add(Box.createHorizontalStrut(12));
        box3.add(button_ok);
        box3.add(Box.createHorizontalStrut(12));
        box3.add(button_cancel);

        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12,12,12,12));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(box3);
        setContentPane(mainBox);
        pack();
        button_ok.addActionListener(e -> {
            tryLogin();
        });
        button_cancel.addActionListener(e -> System.exit(0));

        login_text_field.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n'){
                    tryLogin();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        password_text_field.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n'){
                    tryLogin();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    private void tryLogin(){
        if(!login_text_field.getText().isEmpty()){
            String login = login_text_field.getText();
            String password = String.valueOf(password_text_field.getPassword());
            if(login.equals("user")&&password.equals("user")){
                MainWindow r = new MainWindow(false);
                r.setVisible(true);
                dispose();
            } else if(login.equals("admin")&&password.equals("admin")){
                MainWindow r = new MainWindow(true);
                r.setVisible(true);
                dispose();
            } else
                JOptionPane.showMessageDialog(null,"Неверные логин или пароль");
        }else
            JOptionPane.showMessageDialog(null,"Введите логин");
    }
}


