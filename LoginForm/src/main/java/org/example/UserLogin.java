package org.example;

import org.example.models.Admin;
import org.example.models.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UserLogin extends JFrame{
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label,oklb;
    private JPanel contentPane;
    private JCheckBox checkBox;

    public String username;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
//                UserHome frame = new UserHome();

              //  FetchData ok  = new FetchData();
//                ShoppCart ok = new ShoppCart("ok");

//Woirk frame = new Woirk();
               UserLogin frame = new UserLogin();
//              Homapage frame = new Homapage();
//                FormHome frame = new FormHome();
//                FromTest frame = new FromTest();

                frame.setVisible(true);

                try {
//                    FormHome frame = new FormHome();


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     * Create the frame.
     */

    public UserLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(450, 190, 1014, 597);
        setSize(900,600);
        setLocationRelativeTo(null);
        setTitle("LoginForm");
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
//        UserLogin s = new UserLogin();
//        URL url = UserLogin.class.getResource("Tent-icon.png");
//        Image img = Toolkit.getDefaultToolkit().createImage(url);
//        this.setIconImage(img);
        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setForeground(Color.GREEN);
        lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD, 60));
//        lblNewLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(UserLogin.class.getResource("Tent-icon.png"))));
        lblNewLabel.setBounds(400, 13, 273, 93);

        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Segoe Print", Font.PLAIN, 32));
        textField.setBounds(500, 170, 281, 68);
        contentPane.add(textField);


        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Segoe Print", Font.PLAIN, 32));
        passwordField.setBounds(500, 286, 281, 68);
        contentPane.add(passwordField);

        JLabel lblUsername = new JLabel("USERNAME/EMAIL");
        lblUsername.setBackground(Color.CYAN);
        lblUsername.setForeground(Color.MAGENTA);
        lblUsername.setFont(new Font("Segoe Print", Font.PLAIN, 31));
        lblUsername.setBounds(80, 166, 400, 52);

        contentPane.add(lblUsername);
        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setForeground(Color.MAGENTA);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Segoe Print", Font.PLAIN, 31));
        lblPassword.setBounds(80, 286, 193, 52);

        contentPane.add(lblPassword);



        JButton btnNewbutton1 = new JButton("Register");
        btnNewbutton1.setForeground(Color.RED);
        btnNewbutton1.setFont(new Font("Segoe Print", Font.BOLD, 30));

        btnNewbutton1.setBounds(500, 392, 162, 73);

        checkBox  = new JCheckBox("Log in as admin");
        checkBox.setFont(new Font("Segoe Print", Font.BOLD, 10));
        checkBox.setBounds(500,350,200,50);
        contentPane.add(checkBox);

//
//        checkBox.addItemListener(s);
//        oklb = new JLabel("hahaha");

//        contentPane.add(checkBox);
//        contentPane.add(oklb);
        //fake data


        /*
        ALTER TABLE user
        ADD CONSTRAINT UC_user UNIQUE (emailorphone);

        * */



        btnNewbutton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (textField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Ten tai khan khong duoc de trong");
                    return;
                }
                if (passwordField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Password khong duoc de trong");
                    return;
                }
                try {

                    Connection connection = ConnectDB.getConnection();
                    String sql = "insert into userr(emailorphone,password) values(?,?)";
//                    String sqll = "insert into oder(userId) values(?)";
//                    String sqll = "select * from user where mailorphone=?";

                    PreparedStatement ps = connection.prepareStatement(sql);



//                    pss.setString(1, textField.getText());
                    ps.setString(1, textField.getText());
                    ps.setString(2, passwordField.getText());

                    ps.executeUpdate();
//

//                    ResultSet check = pss.executeQuery();
                    textField.setText("");
                    passwordField.setText("");
//                    System.out.printf(String.valueOf(Global.loggedInUser.getId()));
                    JOptionPane.showMessageDialog(null,"Đăng kí thành công");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    System.out.printf("loi databasae");
                    if(e1.getErrorCode() == 1062) {
                        JOptionPane.showMessageDialog(null,"Email hoặc tài khoản đã tồn tại trên hệ thống!");
                    }
                   //e1.printStackTrace();
                }
            }
        });

        contentPane.add(btnNewbutton1);


        btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 26));
        btnNewButton.setBounds(100, 392, 162, 73);


        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = textField.getText();
                String password = passwordField.getText();
                try {
                    Connection connection = ConnectDB.getConnection();
                    PreparedStatement st = connection.prepareStatement("Select * from user_admin where username=? and password=?");
                    PreparedStatement stt = connection.prepareStatement("Select * from userr where emailorphone=? and password=?");
//                    PreparedStatement pss = connection.prepareStatement("insert into oder(userId) values(?)");
                    stt.setString(1,userName);
                    stt.setString(2, password);

                    st.setString(1, userName);
                    st.setString(2, password);

//                    pss.setInt(1, Global.loggedInUser.getId());

                    ResultSet rs = st.executeQuery();
                    ResultSet rss = stt.executeQuery();
//                    pss.executeUpdate();
                    if (checkBox.isSelected()){

                        if (rs.next()) {
                            Global.loggedInAdmin = new Admin(
                                    rs.getInt("id"),
                                    rs.getString("username"),
                                    rs.getString("password")
                            );

                            AdminForm frame = new AdminForm();
                            frame.setVisible(true);
                            JOptionPane.showMessageDialog(null, "Ban da dang nhap thanh cong trang admin");
                            AdminForm adminForm = new AdminForm();

                            dispose();

                        }else {
                            JOptionPane.showMessageDialog(btnNewButton, "User hoac password sai!");
                        }
                    }else {
                        if (rss.next()){
                            Global.loggedInUser = new User(
                                    rss.getInt("id"),
                                    rss.getString("emailorphone"),
                                    rss.getString("password")
                            );

                            System.out.printf(String.valueOf(Global.loggedInUser.getId()));
                            Homapage ah = new Homapage();
//                        ah.setTitle("AdminUser");
                            ah.setVisible(true);
                            //save user
                            dispose();

                        }
                        else {
                            JOptionPane.showMessageDialog(null, "User hoac password sai!");
                        }
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });
        contentPane.add(btnNewButton);
    }
}
