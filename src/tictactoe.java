import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class tictactoe implements ActionListener{
	
	JFrame frame=new JFrame();
	JPanel button_panel=new JPanel();
	JPanel head_panel=new JPanel();
	JPanel foot_panel=new JPanel();
	JLabel text=new JLabel();
	JButton[] buttons=new JButton[9];
	JButton reset = new JButton("Reset");
	boolean p1_turn;
	Random random=new Random();
	boolean[] btn_clicked=new boolean[9];
	
	tictactoe(){
		
		frame.setTitle("TicTacToe");
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		ImageIcon image=new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\TicTacToe\\src\\logo.png");
		frame.setIconImage(image.getImage());
		
		text.setText("Tic Tac Toe!!");
		text.setBackground(Color.red);
		text.setForeground(Color.green);
		text.setFont(new Font("MV Boli",Font.PLAIN,50));
		
		head_panel.add(text);
		head_panel.setBackground(Color.black);
		head_panel.setPreferredSize(new Dimension(600,100));
		
		button_panel.setLayout(new GridLayout(3,3));
		for(int i=0;i<9;i++) {
			buttons[i]=new JButton();
			buttons[i].addActionListener(this);
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.PLAIN,100));
			buttons[i].setFocusable(false);
		}
		
		foot_panel.setLayout(new BorderLayout());
		reset.setPreferredSize(new Dimension(100,50));
		reset.setFocusable(false);
		reset.addActionListener(this);
		reset.setFont(new Font("Times New Roman",Font.BOLD,25));
		foot_panel.add(reset);
		
		frame.add(head_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		frame.add(foot_panel,BorderLayout.SOUTH);
		frame.setVisible(true);
		
		turn();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new tictactoe();

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		for(int i=0;i<9;i++) {
			if (!btn_clicked[i]) {
				if (e.getSource() == buttons[i]) {
					if (p1_turn) {
						buttons[i].setText("X");
						buttons[i].setForeground(Color.red);
						p1_turn = false;
						text.setText("O turn");
						check();
						btn_clicked[i]=true;
					} else {
						buttons[i].setText("O");
						buttons[i].setForeground(Color.blue);
						p1_turn = true;
						text.setText("X turn");
						check();
						btn_clicked[i]=true;
					}
				} 
			}
		}
		
		if(e.getSource()==reset) {
			for(int i=0;i<9;i++) {
				turn();
				buttons[i].setText("");
				buttons[i].setBackground(null);
				buttons[i].setEnabled(true);
				btn_clicked[i]=false;
			}
		}
	}
	
	public void turn(){
		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		if(random.nextInt(2)==1) {
			p1_turn=true;
			text.setText("X turn");
		}
		else {
			p1_turn=false;
			text.setText("O turn");
		}
	}
	
	public void check() {
		
		//X Winner
		if(
				buttons[0].getText()=="X" &&
				buttons[1].getText()=="X" &&
				buttons[2].getText()=="X") {
			xWins(0,1,2);
		}
		else if(
				buttons[3].getText()=="X" &&
				buttons[4].getText()=="X" &&
				buttons[5].getText()=="X") {
			xWins(3,4,5);
		}
		else if(
				buttons[6].getText()=="X" &&
				buttons[7].getText()=="X" &&
				buttons[8].getText()=="X") {
			xWins(6,7,8);
		}
		else if(
				buttons[0].getText()=="X" &&
				buttons[3].getText()=="X" &&
				buttons[6].getText()=="X") {
			xWins(0,3,6);
		}
		else if(
				buttons[1].getText()=="X" &&
				buttons[4].getText()=="X" &&
				buttons[7].getText()=="X") {
			xWins(1,4,7);
		}
		else if(
				buttons[2].getText()=="X" &&
				buttons[5].getText()=="X" &&
				buttons[8].getText()=="X") {
			xWins(2,5,8);
		}
		else if(
				buttons[0].getText()=="X" &&
				buttons[4].getText()=="X" &&
				buttons[8].getText()=="X") {
			xWins(0,4,8);
		}
		else if(
				buttons[2].getText()=="X" &&
				buttons[4].getText()=="X" &&
				buttons[6].getText()=="X") {
			xWins(2,4,6);
		}
		
		//Y Winner
		else if(
				buttons[0].getText()=="O" &&
				buttons[1].getText()=="O" &&
				buttons[2].getText()=="O") {
			yWins(0,1,2);
		}
		else if(
				buttons[3].getText()=="O" &&
				buttons[4].getText()=="O" &&
				buttons[5].getText()=="O") {
			yWins(3,4,5);
		}
		else if(
				buttons[6].getText()=="O" &&
				buttons[7].getText()=="O" &&
				buttons[8].getText()=="O") {
			yWins(6,7,8);
		}
		else if(
				buttons[0].getText()=="O" &&
				buttons[3].getText()=="O" &&
				buttons[6].getText()=="O") {
			yWins(0,3,6);
		}
		else if(
				buttons[1].getText()=="O" &&
				buttons[4].getText()=="O" &&
				buttons[7].getText()=="O") {
			yWins(1,4,7);
		}
		else if(
				buttons[2].getText()=="O" &&
				buttons[5].getText()=="O" &&
				buttons[8].getText()=="O") {
			yWins(2,5,8);
		}
		else if(
				buttons[0].getText()=="O" &&
				buttons[4].getText()=="O" &&
				buttons[8].getText()=="O") {
			yWins(0,4,8);
		}
		else if(
				buttons[2].getText()=="O" &&
				buttons[4].getText()=="O" &&
				buttons[6].getText()=="O") {
			yWins(2,4,6);
		}
		else {
			draw();
		}
	}
	
	public void xWins(int x, int y, int z) {
		buttons[x].setBackground(Color.green);
		buttons[y].setBackground(Color.green);
		buttons[z].setBackground(Color.green);
		text.setText("X wins!");
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
	}
	
	public void yWins(int x, int y, int z) {
		buttons[x].setBackground(Color.green);
		buttons[y].setBackground(Color.green);
		buttons[z].setBackground(Color.green);
		text.setText("O wins!");
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
	}
	
	public void draw() {
		int count=0;
		for(int i=0;i<9;i++) {
			if(buttons[i].getText()!="") {
				count++;
			}
			if(count==9) {
				text.setText("It's a draw!");
			}
		}
	}
}
