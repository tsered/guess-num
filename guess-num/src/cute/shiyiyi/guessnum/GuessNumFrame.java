package cute.shiyiyi.guessnum;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuessNumFrame extends JFrame {
	private JLabel title; // 标题标签
	private JLabel textLbl; // 文本标签
	private JTextField numField; // 输入框
	private JButton button; // 按钮
	private JLabel messageLbl; // 游戏提示信息标签
	
	private int theNumber; // 答案
	
	/**
	 * 构造函数
	 */
	public GuessNumFrame() {
		// 向窗口布置组件
		addComponent();
		
		// 绑定事件
		addEvent();
		
		// 新开一个游戏
		newGame();
	}
	
	private void addComponent() {
		// 设置窗体是网络布局，4行1列
		GridLayout manager = new GridLayout(4,1);
		setLayout(manager);
		// 标题
		title = new JLabel("小谢的猜数字游戏哦(*^▽^*)",JLabel.CENTER);
		title.setFont(new Font("微软雅黑",Font.BOLD,24));
		add(title);
		// 标签和输入框
		textLbl = new JLabel("请输入一个数字：", JLabel.CENTER);
		numField = new JTextField(5);
		JPanel panel = new JPanel();
		panel.add(textLbl);
		panel.add(numField);
		add(panel);
		//按钮
		button = new JButton("猜一下");
		JPanel panel2 = new JPanel();
		panel2.add(button);
		add(panel2);
		// 提示信息
		messageLbl = new JLabel("点击开始进行游戏吧", JLabel.CENTER);
		messageLbl.setFont(new Font("微软雅黑",Font.PLAIN,16));
		add(messageLbl);
	}
	private void addEvent() {
		// 按钮点击事件
		button.addActionListener(event ->{
			checkGuess();
		});
	}
	private void checkGuess() {
		String txt = numField.getText();
		String message = "";
		try {
			int num = Integer.parseInt(txt);
			if (num < theNumber) {
				message = num + "太小了哦";
			}else if(num > theNumber) {
				message = num + "太大了哦";
			}else {
				message = num + "是正确的，您可以重新进行猜字游戏哦~";
				newGame();
			}
		}catch (NumberFormatException e){
			e.printStackTrace();
			message = "输入的值必须是数字，范围是1-100";
		}finally {
			messageLbl.setText(message);
			numField.requestFocus();
			numField.selectAll();
		}
		
	}

	private void newGame() {
		theNumber = 1 + (int)(Math.random() * 100);
	}
	
}
