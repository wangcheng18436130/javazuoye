package com.yychat.view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FriendList extends JFrame implements ActionListener,MouseListener{//容器
    //成员变量
	CardLayout cardLayout;
	//第一张卡片
	JPanel myFriendPanel;
	
	JButton myFriendButton;//北部
	
	JScrollPane myFriendListJScrollPane;
	JPanel myFriendListJPanel;
	public static final int MYFRIENDCOUNT=51;
	JLabel[] myFriendJLabel=new JLabel[MYFRIENDCOUNT];//50好友数组，对象数组
	
	JPanel myStrangerBlackListPanel;
	JButton myStrangerButton;
	JButton blackListButton;
	
	//第二张卡片
	JPanel myStrangerPanel;
	//2.北部
	JPanel myFriendStrangerPanel;
	JButton myFriendButton1;
	JButton myStrangerButton1;
	//中部
	JScrollPane myStrangerListJScrollPane;
	JPanel myStrangerListJPanel;
	public static final int MYFRIENDCOUNT1=51;
	JLabel[] myStrangerJLabel=new JLabel[MYFRIENDCOUNT1];//50好友数组，对象数组
	//南部
	JButton blackListButton1;
	 /*
	//第三张卡片
	JPanel myblackPanel;
	
   //北部
	JPanel myFriendStrangerPanel2;
	JButton myFriendButton2;
	JButton myStrangerButton2;
	JButton blackListButton2;
	//中部
	JScrollPane myblackListJScrollPane;
	JPanel myblackListJPanel;
	public static final int MYFRIENDCOUNT2=51;
	JLabel[] myblackJLabel=new JLabel[MYFRIENDCOUNT2];//50好友数组，对象数组
	
	*/
	
	String userName;//成员变量
	public FriendList(String userName){//形参
		this.userName=userName;
		//创建第一张卡片
		myFriendPanel=new JPanel(new BorderLayout());//布局的问题，边界布局
		//System.out.println(myFriendPanel.getLayout());
		
		//北部
		myFriendButton=new JButton("我的好友");
		myFriendPanel.add(myFriendButton,"North");
		
		
		//中部
		myFriendListJPanel=new JPanel(new GridLayout(MYFRIENDCOUNT-1,1));//网格布局
		for(int i=1;i<MYFRIENDCOUNT;i++){
			myFriendJLabel[i]=new JLabel(i+"",new ImageIcon("images/yy0.gif"),JLabel.LEFT);
			myFriendJLabel[i].addMouseListener(this);
			myFriendListJPanel.add(myFriendJLabel[i]);
		}
		
		/*myFriendListJScrollPane=new JScrollPane();
		myFriendListJScrollPane.add(myFriendListJPanel);*/
		myFriendListJScrollPane=new JScrollPane(myFriendListJPanel);
		myFriendPanel.add(myFriendListJScrollPane);
		
		//南部
		myStrangerBlackListPanel=new JPanel(new GridLayout(2,1));
		//System.out.println(myStrangerBlackListPanel.getLayout());
		myStrangerButton=new JButton("我的陌生人");
		myStrangerButton.addActionListener(this);
		//blackListButton.addActionListener(this);
		blackListButton=new JButton("黑名单");
		myStrangerBlackListPanel.add(myStrangerButton);
		myStrangerBlackListPanel.add(blackListButton);
		myFriendPanel.add(myStrangerBlackListPanel,"South");
		
		//创建第二张卡片
		myStrangerPanel=new JPanel(new BorderLayout());//布局的问题，边界布局
		//北部
		myFriendStrangerPanel=new JPanel(new GridLayout(2,1));//网格布局
		myFriendButton1=new JButton("我的好友");
		myFriendButton1.addActionListener(this);//事件监听
		//blackListButton1.addActionListener(this);
		myStrangerButton1=new JButton("我的陌生人");
		myFriendStrangerPanel.add(myFriendButton1);
		myFriendStrangerPanel.add(myStrangerButton1);
		myStrangerPanel.add(myFriendStrangerPanel,"North");
		
		//中部
		myStrangerListJPanel=new JPanel(new GridLayout(MYFRIENDCOUNT1-1,1));//网格布局
		for(int i=1;i<MYFRIENDCOUNT1;i++){
			myStrangerJLabel[i]=new JLabel(i+"",new ImageIcon("images/yy4.gif"),JLabel.LEFT);
			myStrangerListJPanel.add(myStrangerJLabel[i]);
		}
		
		/*myFriendListJScrollPane=new JScrollPane();
		myFriendListJScrollPane.add(myFriendListJPanel);*/
		myStrangerListJScrollPane=new JScrollPane(myStrangerListJPanel);
		myStrangerPanel.add(myStrangerListJScrollPane);
		//南部
		blackListButton1=new JButton("黑名单");
		myStrangerPanel.add(blackListButton1,"South");
		
		/*//创建第三张卡片
		myblackPanel=new JPanel(new BorderLayout());//布局的问题，边界布局
		//北部
		myFriendStrangerPanel2=new JPanel(new GridLayout(3,1));//网格布局
		myFriendButton2=new JButton("我的好友");
		myFriendButton2.addActionListener(this);//事件监听
		//myStrangerButton2.addActionListener(this);
		myStrangerButton2=new JButton("我的陌生人");
		blackListButton2=new JButton("黑名单");
		myFriendStrangerPanel2.add(myFriendButton2);
		myFriendStrangerPanel2.add(myStrangerButton2);
		myFriendStrangerPanel2.add(blackListButton2);
		myblackPanel.add(myFriendStrangerPanel,"North");
		//中部
		myblackListJPanel=new JPanel(new GridLayout(MYFRIENDCOUNT2-1,1));//网格布局
		for(int i=1;i<MYFRIENDCOUNT2;i++){
			myblackJLabel[i]=new JLabel(i+"",new ImageIcon("images/.gif"),JLabel.LEFT);
			myblackListJPanel.add(myblackJLabel[i]);
		}
		
		myblackListJScrollPane=new JScrollPane(myblackListJPanel);
		myblackPanel.add(myblackListJScrollPane);*/
		
		//添加2个卡片
		cardLayout=new CardLayout();
		this.setLayout(cardLayout);
		this.add(myFriendPanel,"1");
		this.add(myStrangerPanel, "2");
		//this.add(myblackPanel,"3");
		this.setSize(200, 500);
		this.setTitle(userName+"的好友列表");
		this.setIconImage(new ImageIcon("images/yy3.gif").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    //FriendList friendList=new FriendList("pdh");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==myStrangerButton) cardLayout.show(this.getContentPane(),"2");
		if(e.getSource()==myFriendButton1) cardLayout.show(this.getContentPane(),"1");
		//if(e.getSource()==myblackPanel) cardLayout.show(this.getContentPane(),"3");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getClickCount()==2){
			JLabel jlbl=(JLabel)arg0.getSource();
			String receiver=jlbl.getText();
			new FriendChat(this.userName,receiver);
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		JLabel jlbl1=(JLabel)arg0.getSource();
		jlbl1.setForeground(Color.red);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		JLabel jlbl1=(JLabel)arg0.getSource();
		jlbl1.setForeground(Color.BLACK);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
