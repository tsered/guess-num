package cute.shiyiyi.guessnum;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class GuessNumFrameRunner {

	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame = new GuessNumFrame();
			frame.setTitle("小谢的猜数字游戏哦(*^▽^*)");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(400, 300);
			frame.setVisible(true);
		});

	}

}
