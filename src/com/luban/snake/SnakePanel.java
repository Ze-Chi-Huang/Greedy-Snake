package com.luban.snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakePanel extends JPanel implements KeyListener,ActionListener {
	
	//�[���Ҧ��Ϥ�
	//ImageIcon up = new ImageIcon("up.png");
	ImageIcon body = new ImageIcon("body.png");
	//ImageIcon down = new ImageIcon("down.png");
	//ImageIcon left = new ImageIcon("left.png");
	//ImageIcon right = new ImageIcon("right.png");
	ImageIcon title = new ImageIcon("title.png");
	
	//�D���ƾ�-�y�СB���סB��V
	int[] snakeX = new int[750];
	int[] snakeY = new int[750];
	int len=3;
	String direction="R";
	
	//�����ƾ�
	Random r =new Random();
	int foodX = r.nextInt(34)*25 + 25; //����0~33����
	int foodY = r.nextInt(24)*25 + 75;
	
	
	
	//�C���O�_�}�l
	boolean isStarted = false;
	
	//�C���O�_����
	boolean isFailed = false;
	
	//�C�g�L150�@��h��actionPerformed ��ť���h���A�غc���P�ɵ��U��ť��
	Timer timer = new Timer(70,this);
	
	
	
	//�غc�l
	public SnakePanel() {
		this.setFocusable(true);//����J�I�A�~��ΤW�U���k����
		initSnake();
		
		//�K�[��ť��
		this.addKeyListener(this);
		
		timer.start();
	}
	
	//��l�ƳD
	public void initSnake() {
		len=3;
		direction="R";
		snakeX[0] = 100;
		snakeY[0] = 100;
		//����
		snakeX[1] = 75;
		snakeY[1] = 100;
		snakeX[2] = 50;
		snakeY[2] = 100;
		
		isFailed = false;
		isStarted  =false;
	}
	
	public void paint(Graphics g) {

		//�]�m�e���I����
		this.setBackground(Color.black);
		g.setColor(Color.white);
		g.fillRect(25, 75, 850, 600);
		
		title.paintIcon(this, g, 25, 11);
		
		//�e�D�Y
		switch(direction) {
			case "R":
				body.paintIcon(this, g, snakeX[0], snakeY[0]);
				break;
			case "L":
				body.paintIcon(this, g, snakeX[0], snakeY[0]);
				break;
			case "U":
				body.paintIcon(this, g, snakeX[0], snakeY[0]);
				break;
			case "D":
				body.paintIcon(this, g, snakeX[0], snakeY[0]);
				break;
			default:
				System.out.println("error");
					
		}
		
		//�e�D��
		for(int i=1;i<len;i++) {
			body.paintIcon(this, g, snakeX[i], snakeY[i]);
		}
		
		//�}�l���ܻy
		if(!isStarted) {
			g.setColor(Color.black);
			g.setFont(new Font("arial",Font.BOLD,30));
			g.drawString("Press Space to Start/Pause", 300, 300);
		}
		
		//�e����
		body.paintIcon(this, g, foodX, foodY);
		
		//�e���Ѵ��ܻy
		if(isFailed) {
			g.setColor(Color.black);
			g.setFont(new Font("arial",Font.BOLD,30));
			g.drawString("GameOver", 300, 300);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == com.sun.glass.events.KeyEvent.VK_SPACE) {
			
			if(isFailed) {
				initSnake();
				
			}else{
				isStarted = !isStarted;
			}
			
			//System.out.print("���F�ť�");
			//repaint(); //����
		}else if(keyCode == KeyEvent.VK_UP && !direction.equals("D")) {
			direction = "U";
		}else if(keyCode == KeyEvent.VK_DOWN && !direction.equals("U")) {
			direction = "D";
		}else if(keyCode == KeyEvent.VK_LEFT && !direction.equals("R")) {
			direction = "L";
		}else if(keyCode == KeyEvent.VK_RIGHT && !direction.equals("L")) {
			direction = "R";
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * 1.���s�w�@�Ӿx��
	 * 2.�D����
	 * 3.���e�e��
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(isStarted && !isFailed) {
			//���ʨ���(index 1~len)
			for(int i=len;i>0;i--) {
				snakeX[i] = snakeX[i-1];
				snakeY[i] = snakeY[i-1];
			}
			//���ʨ���
			if(direction.equals("R")) {
				//X�y��+25�AY����
				snakeX[0] = snakeX[0] + 25;
				//�^�Y��
				if(snakeX[0]>850) snakeX[0] = 25;

			}else if(direction.equals("L")) {
				
				snakeX[0] = snakeX[0] - 25;
				
				if(snakeX[0]<25) snakeX[0] = 850;
				
			}else if(direction.equals("U")) {
				
				snakeY[0] = snakeY[0] - 25;
				
				if(snakeY[0] <75) snakeY[0] = 650;
				
			}else if(direction.equals("D")) {
				
				snakeY[0] = snakeY[0] + 25;
				if(snakeY[0] >650) snakeY[0] = 75;
			}
			
			
			//�Y�����޿�
			if(snakeX[0]==foodX && snakeY[0] ==foodY) {
				len+=2;
				foodX = r.nextInt(34)*25 + 25; //����0~33����
				foodY = r.nextInt(24)*25 + 75;
			}
			
			//�D���`�޿�
			for(int i=1;i<len;i++) {
				if(snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
					isFailed = true;
				}
			}
			
		}
		repaint();
	}
	
}
