package com.luban.snake;

import javax.swing.JFrame;

public class Snake {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setBounds(400, 200, 900, 700+20);
		frame.setResizable(false); //不能改變視窗大小
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //打X=關閉
		
		//建畫布
		SnakePanel panel = new SnakePanel();
		frame.add(panel); // 添加畫布
		
		frame.setVisible(true);
		

	}

}
