package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cart extends JFrame{
    private JTable table1;
    private JPanel mainPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JFormattedTextField formattedTextField1;
    JFrame f;

    public Cart(){


        add(mainPanel);
        setTitle("TEst");
        setSize(1920, 1000);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(mainPanel);
        setVisible(true);
        f = new JFrame();

        try{


            String[] colum = {"id","username","password","Number of Users", "Tent", "Food","Do dung","Date"};


            Connection connection = ConnectDB.getConnection();
            Statement st = connection.createStatement();

            String sql = "select * from user";

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                String id = String.valueOf(rs.getInt("id"));
                String emailorphone = String.valueOf(rs.getInt("emailorphone"));
                String password = String.valueOf(rs.getInt("password"));
                String numberOfUsers = String.valueOf(rs.getInt("numberOfUsers"));
                String Tent = String.valueOf(rs.getInt("Tent"));
                String Date = String.valueOf(rs.getInt("Date"));
                String necessarySupplie = String.valueOf(rs.getInt("necessarySupplie"));
                String Food = String.valueOf(rs.getInt("Food"));
                String feedBack = rs.getString("feedBack");

                String[] tbData = {id,emailorphone,password,numberOfUsers,Tent,Date,necessarySupplie,Food,feedBack};
                DefaultTableModel tblModel = (DefaultTableModel)table1.getModel();
                tblModel.addRow(tbData);


//       table1 =new JTable(tbData,colum);
//        table1.setBounds(30,40,200,300);
//        JScrollPane sp=new JScrollPane(table1);
//        mainPanel.add(sp);
//        mainPanel.setSize(300,400);
//        mainPanel.setVisible(true);
    }
            connection.close();

}catch (SQLException ex){
        JOptionPane.showMessageDialog(null,"loi");
        } }


}
