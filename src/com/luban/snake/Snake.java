package com.luban.snake;

import javax.swing.JFrame;

public class Snake {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setBounds(400, 200, 900, 700+20);
		frame.setResizable(false); //������ܵ����j�p
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //��X=����
		
		//�صe��
		SnakePanel panel = new SnakePanel();
		frame.add(panel); // �K�[�e��
		
		frame.setVisible(true);
		

	}

}
