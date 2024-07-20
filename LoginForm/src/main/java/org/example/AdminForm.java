package org.example;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdminForm extends JFrame implements ActionListener {
    JPanel mainPanel;
    JLabel nameLabel, userId, adminlogo;
    JTextField nameTextField, idtextfield;
    JButton deleteAccount, searchInfo, searchID,deleteData;
    JButton resetButton, update;

    DefaultTableModel defaultTableModel;
    JTable table;
    int flag = 0;
    JScrollPane pane = new JScrollPane();


    AdminForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(1900, 1000);
        setLocationRelativeTo(null);
        setTitle("Search data");
        setResizable(false);
        mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(mainPanel);
        mainPanel.setLayout(null);


        //Setting the property of JLabel and adding it to the first JFrame
        adminlogo = new JLabel("Admin");
        adminlogo.setFont(new Font("Segoe Print", Font.BOLD, 50));
        adminlogo.setForeground(Color.MAGENTA);
        adminlogo.setSize(200, 50);
        adminlogo.setLocation(700, 2);
        mainPanel.add(adminlogo);

        nameLabel = new JLabel("Enter Username");
        nameLabel.setFont(new Font("Segoe Print", Font.BOLD, 20));
        nameLabel.setForeground(Color.RED);
        nameLabel.setSize(200, 30);
        nameLabel.setLocation(20, 180);
        mainPanel.add(nameLabel);

        //Setting the property of JTextfield and adding it to the first JFrame
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Segoe Print", Font.BOLD, 20));
        nameTextField.setForeground(Color.MAGENTA);
        nameTextField.setSize(200, 30);
        nameTextField.setLocation(200, 180);
        mainPanel.add(nameTextField);

        searchID = new JButton("Search Id");
        searchID.setFont(new Font("Segoe Print", Font.BOLD, 20));
        searchID.setForeground(Color.PINK);
        searchID.setSize(150, 30);
        searchID.setLocation(400, 180);
        mainPanel.add(searchID);


        userId = new JLabel("UserId");
        userId.setFont(new Font("Segoe Print", Font.BOLD, 20));
        userId.setForeground(Color.red);
        userId.setSize(120, 30);
        userId.setLocation(50, 220);
        mainPanel.add(userId);

        idtextfield = new JTextField();
        idtextfield.setFont(new Font("Segoe Print", Font.BOLD, 20));
        idtextfield.setForeground(Color.MAGENTA);
        idtextfield.setSize(50, 30);
        idtextfield.setLocation(200, 220);
        mainPanel.add(idtextfield);

        searchInfo = new JButton("Search");
        searchInfo.setFont(new Font("Segoe Print", Font.BOLD, 20));
        searchInfo.setForeground(Color.green);
        searchInfo.setSize(150, 30);
        searchInfo.setLocation(400, 220);
        mainPanel.add(searchInfo);

        //Setting the property of JButton(Fetch Data) and adding it to the first JFrame
        deleteAccount = new JButton("Delete Account");
        deleteAccount.setFont(new Font("Segoe Print", Font.BOLD, 25));
        deleteAccount.setForeground(Color.gray);
        deleteAccount.setSize(200, 30);
        deleteAccount.setLocation(30, 280);
        mainPanel.add(deleteAccount);

        //Setting the property of JButton(Reset Data) and adding it to the second JFrame
        resetButton = new JButton("Reset Data");
        resetButton.setFont(new Font("Segoe Print", Font.BOLD, 25));
        resetButton.setForeground(Color.blue);
        resetButton.setSize(200, 30);
        resetButton.setLocation(300, 280);
        mainPanel.add(resetButton);

        update = new JButton("UpdateRow");
        update.setFont(new Font("Segoe Print", Font.BOLD, 25));
        update.setForeground(Color.orange);
        update.setSize(200, 30);
        update.setLocation(300, 350);
        mainPanel.add(update);

        deleteData = new JButton("Delete Data");
        deleteData.setFont(new Font("Segoe Print", Font.BOLD, 25));
        deleteData.setForeground(Color.gray);
        deleteData.setSize(200, 30);
        deleteData.setLocation(30, 350);
        mainPanel.add(deleteData);


        //adding ActionListener to both buttons
        deleteAccount.addActionListener(this);
        resetButton.addActionListener(this);
        searchInfo.addActionListener(this);
        searchID.addActionListener(this);
        deleteData.addActionListener(this);


        String id[] = {"Id"};
        String emailorphone[] = {"EmailOrphone"};
        String password[] = {"Password"};
        String idd[] = {"Order Number"};
        String numberuser[] = {"Number_of_users"};
        String tent[] = {"Tent"};
        String food[] = {"Food"};
        String date[] = {"Date"};
        String dateTime[] = {"Date_time"};
        String nes[] = {"necessary_supplies"};
        String feeback[] = {"feedBack"};
        String totalPrice[] = {"Total Price"};
        String userid[] = {"userId"};


        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);

        table.setSize(960, 700);
        table.setLocation(550, 140);
//        mainPanel.add(new JScrollPane(table));
//        table.setBounds(200,200,200,200);
        JScrollPane sp = new JScrollPane(table);
        mainPanel.add(sp);
        mainPanel.add(table);

        DefaultTableModel model = (DefaultTableModel)table.getModel();

        defaultTableModel.addColumn(1, id);
        defaultTableModel.addColumn(2, emailorphone);
        defaultTableModel.addColumn(3, password);
        defaultTableModel.addColumn(4, idd);
        defaultTableModel.addColumn(5, numberuser);
        defaultTableModel.addColumn(6, tent);
        defaultTableModel.addColumn(7, food);
        defaultTableModel.addColumn(8, date);
        defaultTableModel.addColumn(9, dateTime);
        defaultTableModel.addColumn(10, nes);
        defaultTableModel.addColumn(11, feeback);
        defaultTableModel.addColumn(12, totalPrice);
        defaultTableModel.addColumn(13, userid);
        mainPanel.setVisible(true);

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id;
                String emailorphone;
                String password;
                String idd;
                String number_of_users;
                String tent;
                String food;
                String date;
                String date_time;
                String necessary_supplies;
                String feedBack;
                String total_price;
                String userId;

                //get values from yours showInputDialog
                id = JOptionPane.showInputDialog("Nhap id");
                emailorphone = JOptionPane.showInputDialog("Enter Your Emailotphone");
                password = JOptionPane.showInputDialog("Enter Your password");
                idd = JOptionPane.showInputDialog("id update");
                number_of_users = JOptionPane.showInputDialog("Enter Your Number Of User");
                tent = JOptionPane.showInputDialog("Enter Your tent");
                food = JOptionPane.showInputDialog("Enter Your food");
                date = JOptionPane.showInputDialog("Enter Your date");
                date_time = JOptionPane.showInputDialog("Enter Your date time");
                necessary_supplies = JOptionPane.showInputDialog("Enter Your Ness");
                feedBack = JOptionPane.showInputDialog("Enter Your feedBack");
                total_price = JOptionPane.showInputDialog("Enter Your total Price");
//                userId = JOptionPane.showInputDialog("Enter Your userId");

                //get the selected row index
                int i = table.getSelectedRow();

                //set values to the specific place in jtable
                model.setValueAt(id, i, 0);
                model.setValueAt(emailorphone, i, 1);
                model.setValueAt(password, i, 2);
                model.setValueAt(idd, i, 3);
                model.setValueAt(number_of_users, i, 4);
                model.setValueAt(tent, i, 5);
                model.setValueAt(food, i, 6);
                model.setValueAt(date, i, 7);
                model.setValueAt(date_time, i,8);
                model.setValueAt(necessary_supplies, i, 9);
                model.setValueAt(feedBack, i, 10);
                model.setValueAt(total_price, i, 11);
//                model.setValueAt(userId, i, 11);

               int cf = JOptionPane.showConfirmDialog(null, "Xac nhan");
               if (cf==JOptionPane.YES_OPTION){
                   try {
                       Connection connection = ConnectDB.getConnection();
//                        String sqll = "insert into oder(userId) values(?)";
                        String sql = "update orderrr set Number_of_users=?,Tent=?,Food=?,Date=?,Date_time=?,necessary_supplies=?,feedBack=?,total_price=? where id=?";
//                       String sql = "insert into orderrr(Number_of_users,Tent,Food,Date,Date_time,necessary_supplies,feedBack,total_price,userId) values(?,?,?,?,?,?,?,?,?)";
                       String update = "update userr set emailorphone=?,password=? where id=?";
//                        String sql = "insert into admin(numberOfUsers,Tent,Date,necessarySupplie,Food,feedBack) values(?,?,?,?,?,?) where usernames = kk";
//                        String sqll = "select * from user where id =44";
                       PreparedStatement ps = connection.prepareStatement(sql);
                       PreparedStatement psss = connection.prepareStatement(update);
//                        PreparedStatement pss = connection.prepareStatement(sqll);

//                        pss.setInt(1, Global.loggedInUser.getId());
//                        pss.executeUpdate();

                       psss.setString(1, emailorphone);
                       psss.setString(2, password);
                       psss.setInt(3, Integer.parseInt(id));


                       ps.setInt(1, Integer.parseInt(number_of_users));
                       ps.setInt(2, Integer.parseInt(tent));
                       ps.setInt(3, Integer.parseInt(food));
                       ps.setInt(4, Integer.parseInt(date));
                       ps.setString(5, date_time);
                       ps.setInt(6, Integer.parseInt(necessary_supplies));
                       ps.setString(7, feedBack);
                       ps.setInt(8, Integer.parseInt(total_price));
                       ps.setInt(9, Integer.parseInt(idd));


                       ps.executeUpdate();
                       psss.executeUpdate();

                       JOptionPane.showMessageDialog(null, "Update don hang thanh cong!!");


                   }catch (SQLException e2){
                       System.out.printf("Loi insert");
                       e2.printStackTrace();
                       e2.getErrorCode();

                   }




                   JOptionPane.showMessageDialog(null, "oke");
               }

            }

        });


    }




    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==deleteData){
//            try {
//                Connection connection2 = ConnectDB.getConnection();
//                String sqlll = "delete from orderrr where emailorphone = ?;";
//                PreparedStatement statement1 = connection2.prepareStatement(sqlll);
//                statement1.setString(1, x);
//                statement1.executeUpdate();
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "Error");
//                ex.printStackTrace();
//            }
        }


        if (e.getSource()== deleteAccount){
          String x = JOptionPane.showInputDialog(null,"Nhap id hoac emailorphone");

            try{
                Connection connection = ConnectDB.getConnection();

                String sql = "Select * from userr";
                String sqll = "delete from userr where id = ?;";
//                String sqlll = "delete from userr where emailorphone = ?;";
//                String sqllll = "delete from orderrr where userId=?";

                PreparedStatement statement = connection.prepareStatement(sql);
//                PreparedStatement statement1 = connection.prepareStatement(sqlll);
//                PreparedStatement statement2 = connection.prepareStatement(sqll);
//                PreparedStatement statement3 = connection.prepareStatement(sqllll);


                ResultSet resultSet = statement.executeQuery(sql);

//                statement2.setString(1, x);
//
//                statement2.executeUpdate();


                while (resultSet.next()) {
                    String username = resultSet.getString("emailorphone");
                    String id = resultSet.getString("id");


                    if (x.equalsIgnoreCase(username)) {
                        try {
                            Connection connection2 = ConnectDB.getConnection();
                            String callid = "select * from userr";

                            PreparedStatement statement2 = connection.prepareStatement(callid);

                            ResultSet resultSet1 =   statement2.executeQuery(callid);

                            while (resultSet1.next()){
                                String idd = resultSet1.getString("id");
                                String usernamee = resultSet1.getString("emailorphone");
                                if (x.equalsIgnoreCase(usernamee)){
                                    System.out.printf(idd);
                                    x=idd;
                                }

                            }



                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Error");
                            ex.printStackTrace();
                        }
                    }

                    if (x.equalsIgnoreCase(id)){
                        System.out.printf("x3 " + x);
                        try{
                            Connection connection2 = ConnectDB.getConnection();
                            String sqllll = "delete from orderrr where userId=?";
                            String deleteaccount = "delete from userr where id = ?;";
                            PreparedStatement statement3 = connection2.prepareStatement(sqllll);
                            PreparedStatement statement1 = connection2.prepareStatement(deleteaccount);

                            statement1.setString(1, x);

                            statement3.setString(1, x);
                            statement3.executeUpdate();
                            statement1.executeUpdate();

                        }catch (SQLException ex1) {
                            JOptionPane.showMessageDialog(null, "Error id");
                            ex1.printStackTrace();
                        }
                        break;
                    }
                }
                JOptionPane.showMessageDialog(null, "Delete Account successfull");

            }catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error");
                ex.printStackTrace();
            }
        }
        if(e.getSource() == searchID) {
            String useName1 = nameTextField.getText();
            try {
                Connection connection = ConnectDB.getConnection();
                String sqll = "select * from userr";
                PreparedStatement statement2 = connection.prepareStatement(sqll);

                ResultSet resultSet2 = statement2.executeQuery(sqll);

                while (resultSet2.next()) {
                    String username = resultSet2.getString("emailorphone");
                    String id = resultSet2.getString("id");
                    if (useName1.equalsIgnoreCase(username)) {
                        idtextfield.setText(id);
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (e.getSource() == resetButton) {
            nameTextField.setText("");
            idtextfield.setText("");
            table.removeAll();

        }

        if (e.getSource() == searchInfo) {
            if (nameTextField.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Khong duoc bo trong");
            }

            String useName = nameTextField.getText();
            String idtext = idtextfield.getText();
            System.out.printf(idtext);
            try {
            Connection connection = ConnectDB.getConnection();
                String sql = "Select * from orderrr";
//                String sqll = "select * from userr";
                String callname = "Select * from userr where id =?";

                PreparedStatement statement = connection.prepareStatement(sql);
//                PreparedStatement statement2 = connection.prepareStatement(sqll);
                PreparedStatement statement3 = connection.prepareStatement(callname);

                statement3.setString(1,idtext);


                ResultSet resultSet = statement.executeQuery(sql);
                ResultSet resultSet1 = statement3.executeQuery();
                    while (resultSet1.next()) {
                        while (resultSet.next()){
                            String id = resultSet1.getString("id");
                        String emailorphone = resultSet1.getString("emailorphone");
                        String password = resultSet1.getString("password");
                        String idd = resultSet.getString("id");
                        String number_of_users = resultSet.getString("Number_of_users");
                        String tent = resultSet.getString("Tent");
                        String food = resultSet.getString("Food");
                        String date = resultSet.getString("Date");
                        String date_time = resultSet.getString("Date_time");
                        String necessarySupplies = resultSet.getString("necessary_supplies");
                        String feedBack = resultSet.getString("feedBack");
                        String total_price = resultSet.getString("total_price");
                        String userId = resultSet.getString("userId");
                        if (idtext.equalsIgnoreCase(userId)) {
                            flag = 1;
                            defaultTableModel.addRow(new Object[]{id,emailorphone, password, idd, number_of_users, tent, food, date, date_time, necessarySupplies, feedBack, total_price, userId});
                        }
                    }
                    }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        }

    }
}



