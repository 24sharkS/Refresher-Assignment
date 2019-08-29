import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import java.util.*;
class Runner{
	
	static class Node{
		String Name;
		int Time;
		String Category;
		Node nxt;
		
		Node(String a,int b,String c){
			Name=a;
			Time=b;
			Category=c;
		}
		Node(){}

	}

	static class Linkedlist{
		Node head;
		int size;
		Linkedlist(){
			head = new Node();
		}

		public void addInto(String a,int b,String c){
			Node x = new Node(a,b,c);
			Node cur = head;
			while(cur.nxt!=null){
				cur=cur.nxt;
			}
			size++;
			cur.nxt = x;
		}

		public String[] display(String s){

			String[] N ={"Null","Null"}; 
			int min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
			String first="",second="";
			Node cur = head;

			if(size!=0){
				cur=cur.nxt;
				while(cur!=null){
					if(cur.Category.equals(s)){
						if(cur.Time<min1){
							min2=min1;
							second=first;
							min1=cur.Time;
							first=cur.Name;
						}
					}
					cur=cur.nxt;
				}
			}
			
			if(min1==Integer.MAX_VALUE && min2==Integer.MAX_VALUE){
				return N;
			}
			else{
				N[0]=first;
				N[1]=second;
				return N;
			}
		}
	}
	
}


class input implements ActionListener{
	JFrame fr;
	JLabel l1,l2,l3,l4;
	JTextField t1,t2;
	JRadioButton r1,r2,r3;
	ButtonGroup bg = new ButtonGroup();
	JButton b1,b2,b3;
	Boolean s1=false,s2=false,s3=false;
	int i=1;
	
	Runner.Linkedlist ll = new Runner.Linkedlist();


	public input(){
		fr = new JFrame("Champion");
		fr.setBounds(300,100,800,650);
		fr.setLayout(null);
		
		
		l4 = new JLabel("Enter Details for Runner "+i);
		l4.setBounds(30,10,300,100);
		l4.setFont(new Font("arial",Font.PLAIN,18));
		fr.add(l4);

		l1 = new JLabel("Name");
		l1.setBounds(50,50,100,100);
		l1.setFont(new Font("Verdana",Font.PLAIN,18));
		fr.add(l1);



		l2 = new JLabel("Time");
		l2.setBounds(160,50,100,100);
		l2.setFont(new Font("Verdana",Font.PLAIN,18));
		fr.add(l2);

		l3 = new JLabel("Category");
		l3.setBounds(270,50,150,100);
		l3.setFont(new Font("Verdana",Font.PLAIN,18));
		fr.add(l3);

		t1 = new JTextField("");
		t2 = new JTextField(""); 
		t1.setBounds(50,160,100,30);
		t2.setBounds(160,160,100,30);
		t1.setFont(new Font("verdana",Font.BOLD,12));
		t2.setFont(new Font("verdana",Font.BOLD,14));
		fr.add(t1);fr.add(t2);


		r1 = new JRadioButton("Half Marathon");    
		r2	= new JRadioButton("Open 10K Run");
		r3	= new JRadioButton("Great Delhi Run");
		r1.setBounds(280,150,200,30);    
		r2.setBounds(280,190,200,30);
		r3.setBounds(280,230,200,30);
		r1.addActionListener(this);
		r2.addActionListener(this);
		r3.addActionListener(this);
		fr.add(r1);
		fr.add(r2);
		fr.add(r3);

		b1 = new JButton("NEXT");
		b2 = new JButton("WINNERS");
		b3 = new JButton("CANCEL");
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		b1.setBounds(50,320,110,30);
		b2.setBounds(170,320,110,30);
		b3.setBounds(290,320,110,30);
		b1.setFont(new Font("verdana",Font.BOLD,12));
		b2.setFont(new Font("verdana",Font.BOLD,12));
		b3.setFont(new Font("verdana",Font.BOLD,12));
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		fr.add(b1);
		fr.add(b2);
		fr.add(b3);

		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}
	
	public static void main(String[] args) {
		new input();	
	}

	
	public void clear(){
		t1.setText("");
		t2.setText("");
		bg.clearSelection();
		s1=false;
		s2=false;
		s3=false;
	}

	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==r1){
			s1=true;
			s2=false;
			s3=false;
		}
		else if(ae.getSource()==r2){
			s2=true;
			s1=false;
			s3=false;
		}
		else if(ae.getSource()==r3){
			s3=true;
			s1=false;
			s2=false;
		}
		
		if(ae.getSource()==b3){
			fr.dispose();
		}
		

		if(ae.getSource()==b2){
			String[] a = ll.display("Half Marathon");
			String[] b = ll.display("Open 10K Run");
			String[] c = ll.display("Great Delhi Run");
			JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;	
			JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;			
			fr.setVisible(false);
			JFrame f = new JFrame("WINNERS!!");
			f.setBounds(300,100,800,650);
			f.setLayout(null);
			
			if(a[0]!="Null" && a[1]!="Null")
			{

			l1 = new JLabel("Half Marathon");
			l1.setBounds(10,10,150,50);
			l1.setFont(new Font("Verdana",Font.BOLD,15));
			f.add(l1);

			if(a[0]!="Null"){
			
			l2 = new JLabel("First");
			l2.setBounds(20,70,100,50);
			l2.setFont(new Font("Verdana",Font.PLAIN,12));
			f.add(l2);
			
			t1 = new JTextField("");
			t1.setText(a[0]+""); 
			t1.setBounds(130,80,100,30);
			t1.setFont(new Font("verdana",Font.BOLD,12));
			t1.setEditable(false);
			f.add(t1);

			t2 = new JTextField(""); 
			t2.setText("2,80,000 Rs");
			t2.setBounds(240,80,100,30);
			t2.setFont(new Font("verdana",Font.BOLD,12));
			t2.setEditable(false);
			f.add(t2);

		}

			if(a[1]!="Null"){

			l3 = new JLabel("Second");
			l3.setBounds(20,130,100,50);
			l3.setFont(new Font("Verdana",Font.PLAIN,12));
			f.add(l3);

			t3 = new JTextField(""); 
			t3.setText(a[1]+"");
			t3.setBounds(130,140,100,30);
			t3.setFont(new Font("verdana",Font.BOLD,12));
			t3.setEditable(false);
			f.add(t3);

			t4 = new JTextField(""); 
			t4.setText("2,10,000 Rs");
			t4.setBounds(240,140,100,30);
			t4.setFont(new Font("verdana",Font.BOLD,12));
			t4.setEditable(false);
			f.add(t4);
			}
			

			}


			f.setVisible(true);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		if(ae.getSource()==b1){
			if(t1.getText().length()==0){
				JOptionPane.showMessageDialog(fr,"Please Enter Name!");
			}
			else if(t2.getText().length()==0){
				JOptionPane.showMessageDialog(fr,"Please Enter Time!");
			}
			else if(!(s1||s2||s3)){
				JOptionPane.showMessageDialog(fr,"Choose a Category!");
			}
			else{
				i++;
				l4.setText("Enter Details for Runner "+i);
				String c=null;
				if(s1){
					c = r1.getText();

				}
				else if(s2){
					c = r2.getText();
				}
				else if(s3){
					c = r3.getText();
				}


				ll.addInto(t1.getText(),Integer.parseInt(t2.getText()),c);
				clear();
				// ll.display();
			}
			
		}

	}
}

