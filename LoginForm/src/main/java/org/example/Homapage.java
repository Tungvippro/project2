package org.example;



// a Simple Registration Form
// using Java Swing

import org.example.models.Price;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Arrays;

public class Homapage extends JFrame implements ActionListener {



        private static final long serialVersionUID = 1L;
        // Components of the Form
        private JPanel contenPane;
        private JLabel title;
        private JLabel name;
        private JTextField tname;
        private JLabel food;
        private JTextField tfood;

        private JLabel nou;
        private JTextField tnou;
        private JLabel tent,checkord;
        private JTextField ttent;
        private ButtonGroup gengp;
        private JLabel daten;
        private JTextField tdaten,day,month,year;

        private JLabel Orderdate;

        private JLabel fb,res;
        private JTextArea tfb;
        private JCheckBox term;
        private JButton sub, formAi, back;
        private JButton reset,insert;

        private JTextArea tout, textArea2;
        private JButton  changerPass, history;
        private JTextArea resadd;

        public void AI(int x){
            tname.setText(String.valueOf(x));
            int tent = 0;
            tent = x % 2;

            if (x == 1){
                 tent = 1;
            }
            if(tent ==1){
                tent= (x /2)+1;
            }else {
                tent = x/2;
            }
            ttent.setText(String.valueOf(tent));
            tfood.setText(String.valueOf(tname.getText()));
            tnou.setText(String.valueOf(x/3));
}

        // constructor, to initialize the components
        // with default values.
        public Homapage()
        {


            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(450, 190, 1014, 597);
            setSize(1900,1000);
            setLocationRelativeTo(null);

            setTitle("Order Form");
            setResizable(false);
            contenPane = new JPanel();
            contenPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contenPane);
            contenPane.setLayout(null);


//            setTitle("Registration Form");
//            setBounds(300, 90, 900, 600);
//            setDefaultCloseOperation(EXIT_ON_CLOSE);
//            setResizable(false);




            title = new JLabel("Order Form");
            title.setFont(new Font("Segoe Print", Font.BOLD, 60));
            title.setForeground(Color.ORANGE);
            title.setSize(500, 200);
            title.setLocation(650, 1);
            contenPane.add(title);

            name = new JLabel("Number of Users:");
            name.setFont(new Font("Segoe Print", Font.BOLD, 30));
            name.setForeground(Color.red);
            name.setSize(300, 30);
            name.setLocation(125, 200);
            contenPane.add(name);

            tname = new JTextField();
            tname.setFont(new Font("Segoe Print", Font.BOLD, 30));
            tname.setForeground(Color.GREEN);
            tname.setSize(250, 30);
            tname.setLocation(440, 200);
            contenPane.add(tname);

            formAi = new JButton("FormAI?");
            formAi.setFont(new Font("Segoe Print", Font.BOLD, 20));
            formAi.setForeground(Color.pink);
            formAi.setSize(150, 30);
            formAi.setLocation(700, 200);
            contenPane.add(formAi);

            food = new JLabel("Allowances:");
            food.setFont(new Font("Segoe Print", Font.BOLD, 30));
            food.setForeground(Color.red);
            food.setSize(250, 30);
            food.setLocation(125, 250);
            contenPane.add(food);

            tfood = new JTextField();
            tfood.setFont(new Font("Segoe Print", Font.BOLD, 30));
            tfood.setForeground(Color.GREEN);
            tfood.setSize(250, 30);
            tfood.setLocation(440, 250);
            contenPane.add(tfood);




            nou = new JLabel("Necessary Supplies:");
            nou.setFont(new Font("Segoe Print", Font.BOLD, 30));
            nou.setForeground(Color.gray);
            nou.setSize(300, 30);
            nou.setLocation(125, 300);
            contenPane.add(nou);

            tnou = new JTextField();
            tnou.setFont(new Font("Segoe Print", Font.BOLD, 30));
            tnou.setForeground(Color.GREEN);
            tnou.setSize(250, 30);
            tnou.setLocation(440, 300);
            contenPane.add(tnou);

            tent = new JLabel("Tents:");
            tent.setFont(new Font("Segoe Print", Font.BOLD, 30));
            tent.setForeground(Color.gray);
            tent.setSize(250, 30);
            tent.setLocation(125, 350);
            contenPane.add(tent);

            ttent = new JTextField();
            ttent.setFont(new Font("Segoe Print", Font.BOLD, 30));
            ttent.setForeground(Color.GREEN);
            ttent.setSize(250, 30);
            ttent.setLocation(440, 350);
            contenPane.add(ttent);

            daten = new JLabel("Date:");
            daten.setFont(new Font("Segoe Print", Font.BOLD, 30));
            daten.setForeground(Color.orange);
            daten.setSize(250, 30);
            daten.setLocation(125, 400);
            contenPane.add(daten);

            tdaten = new JTextField();
            tdaten.setFont(new Font("Segoe Print", Font.BOLD, 30));
            tdaten.setForeground(Color.BLACK);
            tdaten.setSize(250, 30);
            tdaten.setLocation(440, 400);
            contenPane.add(tdaten);

            Orderdate = new JLabel("Datetime(D/M/Y):");
            Orderdate.setFont(new Font("Segoe Print", Font.BOLD, 30));
            Orderdate.setForeground(Color.orange);
            Orderdate.setSize(300, 30);
            Orderdate.setLocation(125, 450);
            contenPane.add(Orderdate);

            day = new JTextField();
            day.setFont(new Font("Segoe Print", Font.BOLD, 30));
            day.setForeground(Color.BLACK);
            day.setSize(250, 30);
            day.setLocation(440, 450);
            contenPane.add(day);


            fb = new JLabel("Feedback:");
            fb.setFont(new Font("Segoe Print", Font.BOLD, 30));
            fb.setForeground(Color.GREEN);
            fb.setSize(250, 30);
            fb.setLocation(125, 500);
            contenPane.add(fb);

            tfb = new JTextArea();
            tfb.setFont(new Font("Segoe Print", Font.BOLD, 15));
            tfb.setForeground(Color.GREEN);
            tfb.setSize(250, 100);
            tfb.setLocation(440, 500);
            tfb.setLineWrap(true);
            contenPane.add(tfb);

            back = new JButton("<= Log out");
            back.setFont(new Font("Segoe Print", Font.BOLD, 20));
            back.setSize(150, 30);
            back.setForeground(Color.gray);
            back.setLocation(60, 670);
            back.addActionListener(this);
            contenPane.add(back);



            sub = new JButton("Check");
            sub.setFont(new Font("Segoe Print", Font.BOLD, 20));
            sub.setSize(100, 30);
            sub.setForeground(Color.red);
            sub.setLocation(250, 670);
            sub.addActionListener(this);
            contenPane.add(sub);

            reset = new JButton("Reset");
            reset.setFont(new Font("Segoe Print", Font.BOLD, 20));
            reset.setSize(100, 30);
            reset.setForeground(Color.blue);
            reset.setLocation(370, 670);
            reset.addActionListener(this);
            contenPane.add(reset);

            insert = new JButton("Order");
            insert.setFont(new Font("Segoe Print", Font.BOLD, 20));
            insert.setSize(100, 30);
            insert.setForeground(Color.GREEN);
            insert.setLocation(500, 670);
            contenPane.add(insert);

            changerPass = new JButton("Changer Password");
            changerPass.setFont(new Font("Segoe Print", Font.BOLD, 20));
            changerPass.setSize(280, 30);
            changerPass.setForeground(Color.MAGENTA);
            changerPass.setLocation(100, 770);
            contenPane.add(changerPass);

            history = new JButton("Purchase history");
            history.setFont(new Font("Segoe Print", Font.BOLD, 20));
            history.setSize(280, 30);
            history.setForeground(Color.BLUE);
            history.setLocation(600, 770);
            contenPane.add(history);

            checkord = new JLabel("Check Orders");
            checkord.setFont(new Font("Segoe Print", Font.BOLD, 25));
            checkord.setForeground(Color.MAGENTA);
            checkord.setSize(200, 30);
            checkord.setLocation(1100, 140);
            contenPane.add(checkord);


            tout = new JTextArea();
            tout.setFont(new Font("Segoe Print", Font.PLAIN, 20));
            tout.setSize(420, 400);
            tout.setLocation(1000, 190);
            tout.setLineWrap(true);
            tout.setEditable(false);
            contenPane.add(tout);

            textArea2 = new JTextArea();
            textArea2.setFont(new Font("Segoe Print", Font.PLAIN, 20));
            textArea2.setForeground(Color.red);
            textArea2.setSize(420, 200);
            textArea2.setLocation(1000, 600);
            textArea2.setLineWrap(true);
            textArea2.setEditable(false);
            contenPane.add(textArea2);

            res = new JLabel("");
            res.setFont(new Font("Arial", Font.PLAIN, 20));
            res.setSize(500, 25);
            res.setLocation(100, 500);
            contenPane.add(res);

//            resadd = new JTextArea();
//            resadd.setFont(new Font("Arial", Font.PLAIN, 15));
//            resadd.setSize(200, 75);
//            resadd.setLocation(580, 220);
//            resadd.setLineWrap(true);
//            contenPane.add(resadd);
//            setVisible(true);

            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   int logout =  JOptionPane.showConfirmDialog(null,"Quay lai trang login?");
                    if (logout == JOptionPane.YES_OPTION){
                        UserLogin userLogin = new UserLogin();
                        userLogin.setVisible(true);
                        dispose();
                    }
                }
            });





           formAi.addActionListener(new ActionListener() {
               int tent = 0;

               @Override
               public void actionPerformed(ActionEvent e) {
                   String count =  JOptionPane.showInputDialog(null,"nhap so luong nguoi");
                  AI(Integer.parseInt(count));

               }
           });

            insert.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    int continuee = JOptionPane.showConfirmDialog(null, "xac nhan don hang?");
                    if (day.getText().equals("") || tdaten.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Không xác định rõ thời gian đặt hàng hoặc số ngày mua hàng!!");
                    }
                    if (continuee==JOptionPane.YES_OPTION){

                        try {
                            Connection connection = ConnectDB.getConnection();
//                        String sqll = "insert into oder(userId) values(?)";
//                        String sql = "update oder set Number_of_users=?,Tent=?,Food=?,Date=?,necessary_supplies=?,feedBack=? where userId=?";
                            String sql = "insert into orderrr(Number_of_users,Tent,Food,Date,Date_time,necessary_supplies,feedBack,total_price,userId) values(?,?,?,?,?,?,?,?,?)";
//                        String sql = "insert into admin(numberOfUsers,Tent,Date,necessarySupplie,Food,feedBack) values(?,?,?,?,?,?) where usernames = kk";
//                        String sqll = "select * from user where id =44";
                            PreparedStatement ps = connection.prepareStatement(sql);
//                        PreparedStatement pss = connection.prepareStatement(sqll);

//                        pss.setInt(1, Global.loggedInUser.getId());
//                        pss.executeUpdate();

                            ps.setInt(1, Integer.parseInt(tname.getText()));
                            ps.setInt(2, Integer.parseInt(ttent.getText()));
                            ps.setInt(3, Integer.parseInt(tfood.getText()));
                            ps.setInt(4, Integer.parseInt(tdaten.getText()));

                            ps.setString(5, day.getText());

                            ps.setInt(6, Integer.parseInt(tnou.getText()));

                            ps.setString(7, tfb.getText());
                            System.out.printf(String.valueOf(Global.loggedInUser.getId()));
                            ps.setInt(8, Global.price.getSumprice());
                            ps.setInt(9, Global.loggedInUser.getId());

                            int n = ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Tao don hang thanh cong!!");


                        }catch (SQLException e2){
                       System.out.printf("Loi insert");
                            e2.printStackTrace();
                            e2.getErrorCode();
                        }
                    }
                }
            });
            String dataa = "Price Tent/day(10$): "
                    + "\n" + "Price Food(5$/user): "
                    + "\n" + "Price Ness(5$/user): ";
            textArea2.setText(dataa);
        }



        // method actionPerformed()
        // to get the action performed
        // by the user and act accordingly

        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == sub) {
//                if (tdaten.getText().equals("") | ttent.getText().equals("") | tfood.getText().equals("") | tnou.getText().equals("")) {
//                    JOptionPane.showMessageDialog(null, "Không thấy dữ liệu cần để tính toán");
//                }
                if (ttent.getText().equals("")){
                    ttent.setText("0");
                }
                if (tfood.getText().equals("")){
                    tfood.setText("0");
                }
                if (tnou.getText().equals("")){
                    tnou.setText("0");
                }
                if (tdaten.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Không xác định đươcj ngày thuê!");
                    tdaten.setText("0");
                }
                double cten = Integer.parseInt(ttent.getText());
                double cfood = Integer.parseInt(tfood.getText());
                double cness = Integer.parseInt(tnou.getText());
                int cday = Integer.parseInt(tdaten.getText());
                Global.price = new Price(cten * (cday * 10), cfood * 5, cness *5);
              double sum = (Global.price.getPriceFood() + Global.price.getPriceNess() + Global.price.getPriceTentHour());
                Global.price.Price2(sum);


                textArea2.setText("");
                String dataaa = "Price Tent/day(10$): " + Global.price.getPriceTentHour() + "$"
                        + "\n" + "Price Food(5$/user): " + Global.price.getPriceFood() + "$"
                        + "\n" + "Price Ness(5$/set): " + Global.price.getPriceNess() + "$"
                        + "\n" + "Total Price: " + Global.price.getSumprice() + "$";
                textArea2.setText(dataaa);


                if (tdaten.getText().equals("0")){
                    JOptionPane.showMessageDialog(null, "Không xác định được số ngày thuê!");
                }
                if (day.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Không xác định được ngày bắt đầu!");
                }

                    String data= "Number of users: "
                            + tname.getText() + "\n"
                            + "Allowance: "
                            + tfood.getText() + "(price:" +Global.price.getPriceTentHour() + ")" + "\n"
                            + "Necessary Supplie: "
                            + tnou.getText() + "\n"
                            + "Number of tents:"
                            + ttent.getText()+ "\n"
                            +"Number date order: "
                            + tdaten.getText()+ "\n"
                            + "From  date time: "
                            + day.getText() + "\n"
                            + "Feed back: "
                            + tfb.getText()+ "\n";

                    tout.setText(data);
                    tout.setEditable(false);
            }

            else if (e.getSource() == reset) {
                String def = "";
                tname.setText(def);
                tnou.setText(def);
                ttent.setText(def);
                res.setText(def);
                tout.setText(def);
                day.setText(def);
                tfb.setText(def);
                tdaten.setText("");
                tfood.setText("");
                String dataa = "Price Tent/day(10$): "
                        + "\n" + "Price Food(5$/user): "
                        + "\n" + "Price Ness(5$/user): ";
                textArea2.setText(dataa);
            }
        }
    }



