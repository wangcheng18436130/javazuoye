package com.yychat.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.*;

public class Friendchat extends JFrame implements ActionListener{
	
	JScrollPane jsp;
	JTextArea jta;
	
	
	JPanel jp;
	JTextField jtf;
	JButton jb;
	private EventObject arg0;
	
	public Friendchat(String sender,String receiver){
		
		jsp=new JScrollPane();
		jta=new JTextArea();
		jta.setEditable(false);
		jta.setForeground(Color.red);
		this.add(jsp,"Center");
		
		
		jp=new JPanel();
		jtf=new JTextField(15);
		jb=new JButton("发送");
		jb.addActionListener(this);
				jp.add(jtf);jp.add(jb);
				this.add(jp,"South");
				
				this.setSize(350,240);
				this.setTitle(sender+"正在和"+receiver+"聊天");
				this.setLocationRelativeTo(null);
				//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	}

	public static void main(String[] args) {
		//Friendchat friendChat=new Friendchat();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(arg0.getSource()==jb)
			jta.append(jtf.getText()+"\r\n");
		// TODO Auto-generated method stub
		
	}

}
