package com.dn.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dn.server.Check;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.awt.event.ActionEvent;

public class Client extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("班级");
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		label.setBounds(102, 88, 72, 32);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("应到人数");
		label_1.setFont(new Font("宋体", Font.PLAIN, 25));
		label_1.setBounds(55, 150, 127, 40);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("实到人数");
		label_2.setFont(new Font("宋体", Font.PLAIN, 25));
		label_2.setBounds(55, 214, 119, 47);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("日期");
		label_3.setFont(new Font("宋体", Font.PLAIN, 25));
		label_3.setBounds(102, 286, 72, 55);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("年");
		label_4.setFont(new Font("宋体", Font.PLAIN, 25));
		label_4.setBounds(249, 290, 54, 47);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("月");
		label_5.setFont(new Font("宋体", Font.PLAIN, 25));
		label_5.setBounds(335, 290, 54, 47);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("日");
		label_6.setFont(new Font("宋体", Font.PLAIN, 25));
		label_6.setBounds(423, 290, 72, 47);
		contentPane.add(label_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(184, 92, 44, 32);
		for(int i=1;i<=10;i++) {
			comboBox.addItem(i);;
		}
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(184, 301, 54, 32);
		for(int i=1970;i<=2030;i++) {
			comboBox_1.addItem(i);;
		}
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(281, 301, 44, 32);
		for(int i=1;i<=12;i++) {
			comboBox_2.addItem(i);;
		}
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(369, 301, 44, 32);
		for(int i=1;i<=31;i++) {
			comboBox_3.addItem(i);;
		}
		contentPane.add(comboBox_3);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(184, 150, 119, 40);
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(184, 214, 119, 40);
		contentPane.add(textPane_1);
		
		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Check check = (Check)Naming.lookup("check");
					check.checkNumber((int)comboBox.getSelectedItem(), textPane.getText(), 
							textPane_1.getText(), (int)comboBox_1.getSelectedItem(), 
							(int)comboBox_2.getSelectedItem(), (int)comboBox_3.getSelectedItem());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setBounds(184, 401, 133, 47);
		contentPane.add(button);
	}
}
