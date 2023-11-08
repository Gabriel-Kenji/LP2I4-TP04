package view;

import Model.ConexaoDAO;
import Model.FuncDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class form {
    private JPanel panel1;
    private JTextField txt_Nome;
    private JButton button1;
    private JTextField txt_resultName;
    private JTextField txt_ResultSal;
    private JTextField txt_ResultCargo;
    private JButton button2;
    private JButton button3;

    Connection conn;
    ConexaoDAO dao = new ConexaoDAO();
    FuncDAO func = new FuncDAO();

    private ResultSet resultSet;

    public Void resul(String nome){
        resultSet = func.getFunc(nome);
        return null;
    }


    public form() {

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   String nome = txt_Nome.getText();
                   resul(nome);
                   if (resultSet.next()){
                        txt_resultName.setText(resultSet.getString("nome_func"));
                       txt_ResultSal.setText(resultSet.getString("sal_func"));
                       txt_ResultCargo.setText(resultSet.getString("ds_cargo"));
                    }else {
                       JOptionPane.showMessageDialog(null, "SEM RESULTADOS");
                    }
                } catch (Exception erro){
                    JOptionPane.showMessageDialog(null, erro);
                }

            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (resultSet.previous()){
                        txt_resultName.setText(resultSet.getString("nome_func"));
                        txt_ResultSal.setText(resultSet.getString("sal_func"));
                        txt_ResultCargo.setText(resultSet.getString("ds_cargo"));
                    }else {
                        JOptionPane.showMessageDialog(null, "SEM RESULTADOS");
                    }
                } catch (Exception erro){
                    JOptionPane.showMessageDialog(null, erro);
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (resultSet.next()){
                        txt_resultName.setText(resultSet.getString("nome_func"));
                        txt_ResultSal.setText(resultSet.getString("sal_func"));
                        txt_ResultCargo.setText(resultSet.getString("ds_cargo"));
                    }else {
                        JOptionPane.showMessageDialog(null, "SEM RESULTADOS");
                    }
                } catch (Exception erro){
                    JOptionPane.showMessageDialog(null, erro);
                }
            }
        });

    }

    public static void main(String[] args){
        JFrame frame = new JFrame("form");
        frame.setContentPane(new form().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
