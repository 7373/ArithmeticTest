/*下面是<<小学生四则运算练习软件第七版>>。.
 *by Mr.Ran;
 *每次运行程序时要求先输入用户名；
 **/
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

import javax.swing.*;
@SuppressWarnings("unused")
abstract class Operation {   // //////抽象类

	protected int numberOfDigit; // 定义操作数位数；
	protected int operandNumber1;// 定义操作数1；
	protected int operandNumber2;// 定义操作数2；
	protected int userAnswer; // 定义用户答案；
	protected int setAnswer; // 定义正确答案；

	public Operation(int numberOfDigit) {// Operation 父类构造方法；

		this.numberOfDigit = numberOfDigit;
		operandNumber1 = (int) (Math.random() * Math.pow(10, numberOfDigit));
		operandNumber2 = (int) (Math.random() * Math.pow(10, numberOfDigit));
		setAnswer();
	}

	abstract void setAnswer();

	{
	} // 定义正确答案抽象方法；

	public boolean judge() { // 判断方法；
		return (setAnswer == userAnswer) ? true : false;
	}

	

}

// //////////////Addition继承类：

class Addition extends Operation {

	public Addition(int numberOfDigit) { // 构造方法；
		super(numberOfDigit);

	}

	public void setAnswer() {
		setAnswer = operandNumber1 + operandNumber2;

	}

	/*public void doExercise() throws NumberTooBigException {// 输入用户答案方法；
		int test = 0;
		int max = 2 * (int) Math.pow(10, numberOfDigit);
		while (true) {
			test = 0;
			try {

				BufferedReader keyboardIn = new BufferedReader(
						new InputStreamReader(System.in));
				userAnswer = Integer.parseInt(keyboardIn.readLine());

			}

			catch (Exception dataFalse) {
				System.out.println("输入数据类型错误！你必须输入数值数据！");
				test++;
			} finally {
				if (test == 0)
					break;
			}
		}

		if (userAnswer > max) {
			System.out.println("你输入的答案超出了可能的范围！，答案应该小于" + max);

			try {
				BufferedReader keyboardIn = new BufferedReader(
						new InputStreamReader(System.in));
				userAnswer = Integer.parseInt(keyboardIn.readLine());
			}

			catch (Exception e) {
			}

		}}
		*/
	

	public String titlesDisplay() { // 题目打印方法；
		String s=operandNumber1 + "+" + operandNumber2
				+ "=? " ;
		return s;
	}

	/*public void answersDisplay() { // 答案打印方法；
		System.out.printf("%2d +%2d=？%4d %3d\n", operandNumber1,
				operandNumber2, setAnswer, userAnswer);

	}*/

	public String getFile() {
		String f = "题目、标准答案、用户答案:" + operandNumber1 + "+" + operandNumber2
				+ "=? " + setAnswer + " " + userAnswer + "\n";

		return f;
	}
}

// /减法Subtraction继承类

class Subtraction extends Operation {
	public Subtraction(int numberOfDigit) {
		super(numberOfDigit);

		if (operandNumber1 < operandNumber2) // 排除被减数小于减数情况；
		{
			int temp = operandNumber1;
			operandNumber1 = operandNumber2;
			operandNumber2 = temp;
		}

	}

	public void setAnswer() {
		setAnswer = operandNumber1 - operandNumber2;

	}

	/*public void doExercise() throws NumberTooBigException {// 输入用户答案方法；
		int test = 0;
		int max = (int) Math.pow(10, numberOfDigit);
		while (true) {
			test = 0;
			try {

				BufferedReader keyboardIn = new BufferedReader(
						new InputStreamReader(System.in));
				userAnswer = Integer.parseInt(keyboardIn.readLine());

			}

			catch (Exception dataFalse) {
				System.out.println("输入数据类型错误！你必须输入数值数据！");
				test++;
			} finally {
				if (test == 0)
					break;
			}
		}
		// if(userAnswer<10)
		if (userAnswer > max) {
			System.out.println("你输入的答案超出了可能的范围！，答案应该小于" + max);

			try {
				BufferedReader keyboardIn = new BufferedReader(
						new InputStreamReader(System.in));
				userAnswer = Integer.parseInt(keyboardIn.readLine());
			}

			catch (Exception e) {
			}

		}
	}
*/
	public String titlesDisplay() {
		String s=operandNumber1 + "-" + operandNumber2
				+ "=? " ;
		return s;
	}

/*	public void answersDisplay() {
		System.out.printf("%2d -%2d=？%4d %3d\n", operandNumber1,
				operandNumber2, setAnswer, userAnswer);
	}
*/
	public String getFile() {
		String f = "题目、标准答案、用户答案:" + operandNumber1 + "-" + operandNumber2
				+ "=? " + setAnswer + " " + userAnswer + "\n";

		return f;
	}

}

// ////乘法Multiplication、

class Multiplication extends Operation {
	public Multiplication(int numberOfDigit) {
		super(numberOfDigit);

	}

	public void setAnswer() {
		setAnswer = operandNumber1 * operandNumber2;

	}

	/*public void doExercise() throws NumberTooBigException {// 输入用户答案方法；
		int test = 0;
		int max = (int) Math.pow(10, numberOfDigit)
				* (int) Math.pow(10, numberOfDigit);
		while (true) {
			test = 0;
			try {

				BufferedReader keyboardIn = new BufferedReader(
						new InputStreamReader(System.in));
				userAnswer = Integer.parseInt(keyboardIn.readLine());

			}

			catch (Exception dataFalse) {
				System.out.println("输入数据类型错误！你必须输入数值数据！");
				test++;
			} finally {
				if (test == 0)
					break;
			}
		}

		if (userAnswer > max) {
			System.out.println("你输入的答案超出了可能的范围！，答案应该小于" + max);

			try {
				BufferedReader keyboardIn = new BufferedReader(
						new InputStreamReader(System.in));
				userAnswer = Integer.parseInt(keyboardIn.readLine());
			}

			catch (Exception e) {
			}

		}
	}
*/
	public String titlesDisplay() {
		String s=operandNumber1 + "X" + operandNumber2
				+ "=? " ;
		return s;
	}

/*	public void answersDisplay() {
		System.out.printf("%2d X%2d=？%4d %3d\n", operandNumber1,
				operandNumber2, setAnswer, userAnswer);

	}
*/
	public String getFile() {
		String f = "题目、标准答案、用户答案:" + operandNumber1 + "X" + operandNumber2
				+ "=? " + setAnswer + " " + userAnswer + "\n";

		return f;
	}
}

// /和除法Division

class Division extends Operation {
	public int setAnswer2, userAnswer2;// 定义正确余数，及用户余数；

	public Division(int numberOfDigit) {
		super(numberOfDigit);
		if (operandNumber2 == 0)// /排除除数为0的情况；
			operandNumber2++;
	}

	public void setAnswer() {

		setAnswer = operandNumber1 / operandNumber2;
		setAnswer2 = operandNumber1 % operandNumber2;
	}

	/*public void doExercise() throws NumberTooBigException {// 输入用户答案方法；
		int test = 0;
		int max = (int) Math.pow(10, numberOfDigit);
		while (true) {
			test = 0;
			try {

				BufferedReader keyboardIn = new BufferedReader(
						new InputStreamReader(System.in));
				userAnswer = Integer.parseInt(keyboardIn.readLine());

			}

			catch (Exception dataFalse) {
				System.out.println("输入数据类型错误！你必须输入数值数据！");
				test++;
			} finally {
				if (test == 0)
					break;
			}
		}

		if (userAnswer > max) {
			System.out.println("你输入的答案超出了可能的范围！，答案应该小于" + max);

			try {
				BufferedReader keyboardIn = new BufferedReader(
						new InputStreamReader(System.in));
				userAnswer = Integer.parseInt(keyboardIn.readLine());
			}

			catch (Exception e) {
			}

		}
	}

*/	public boolean judge() {

		return (setAnswer == userAnswer && setAnswer2 == userAnswer2) ? true
				: false;
	}

	public String titlesDisplay() {
		String s=operandNumber1 + "÷" + operandNumber2
				+ "=? "+"请输入商及余数";
		return s;
	}

	/*public void titlesDisplay2() {
		System.out.printf("请输入余数:");
	}
	*/

	/*public void doExercise2() throws Exception { // 输入余数方法；

		BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(
				System.in));
		userAnswer2 = Integer.parseInt(keyboardIn.readLine()); // 输入用户答案；
	}
*/
	/*public void answersDisplay() {
		System.out.printf("%2d ÷%2d=？%2d %2d %2d %d\n", operandNumber1,
				operandNumber2, setAnswer, setAnswer2, userAnswer, userAnswer2);

	}*/

	public String getFile() {
		String f = "题目、标准答案、用户答案（包含余数）:" + operandNumber1 + "÷"
				+ operandNumber2 + "=? " + setAnswer + " " + setAnswer2 + " "
				+ userAnswer + " " + userAnswer2 + " " + "\n";

		return f;
	}

}

class NumberTooBigException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	public NumberTooBigException(String ErrorMessagr) {

		message = ErrorMessagr;
	}

	public String getMessage() {
		return message;
	}
}

public class ArithmeticTest7 extends JFrame implements ActionListener{ // 定义主类；

	public static void main(String[] args) throws Exception {
		JFrame frm=new JFrame("小学生四则运算练习软件 ");
		//Container c=getContentPane();
		
		frm.setLocationRelativeTo(null);
		frm.setSize(1000,1000);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel j1=new JPanel();
		JPanel j2=new JPanel();
		JPanel j3=new JPanel();
		JPanel j4=new JPanel();
		JPanel j10=new JPanel();
		JPanel j5=new JPanel();
		JPanel j6=new JPanel();
		JPanel j7=new JPanel();
		JPanel j8=new JPanel();
		JPanel j30=new JPanel();
		JPanel j20=new JPanel();
		JPanel j50=new JPanel();
		JPanel j40=new JPanel();
		JPanel j100=new JPanel();
		j1.add(new JLabel("用户名："));
		j2.add(new JTextField(4));
		j3.add(new JRadioButton("加法"));
		j3.add(new JRadioButton("减法"));
		j3.add(new JRadioButton("乘法"));
		j3.add(new JRadioButton("除法"));
		j3.add(new JRadioButton("混合"));
		j4.add(new JLabel("位数："));
		j5.add(new JTextField(2));
		j6.add(new JButton("开始"));
		//j30.setLayout(new BorderLayout());
		j30.add(j1);
		j30.add(j2);
		j30.add(j3);
		j30.add(j4);
		j30.add(j5);
		j30.add(j6);
		j30.setBorder(null);
		j100.setLayout(new BorderLayout());
		j100.add(j30,"North");
		j100.add(j10,"West");
		
		j100.add(j20,"Center");
		j100.add(j50,"East");
		
		j100.add(j40,"South");
		frm.add(j100);
		
		
		//TextField tf = new TextField();  //创建一个文本框
		//JFormattedTextField l = new JFormattedTextField("请输入用户名：");
		//l.setHorizontalAlignment(JTextField.CENTER);
		//l.getText();
		//l.setBounds(10,10,10,10);
		//Button btn = new Button("按钮");
		//向窗体添加3个组件
		//JButton jb=new JButton("按钮");
		//jb.setBounds(10, 10, 10, 10);
		//jb.setFont(new Font("黑体", Font.BOLD, 20));
		//frm.add(tf);
		//frm.add(jb);
		//frm.add(l);
		//frm.add(btn);  
		frm.setVisible(true);
		String userName;
		String fileName;
		/*int test2 = 1;
		int scores = 0;
		int numberOfDigit = 1;
		int randomNumber = (int) (Math.random() * 4);
		try {
			numberOfDigit = Integer.parseInt(args[1]);

		} catch (ArrayIndexOutOfBoundsException index) {
			System.out.println("请输入命令参数！(没有指定或者参数不足)");
			test2 = 0;
		}
		if (!("+".equals(args[0]) || "-".equals(args[0]) || "X".equals(args[0])
				|| "/".equals(args[0]) || "r".equals(args[0]))) {
			System.out.println("运算类型错误!");
			test2 = 0;

		}
		
		/*if (test2 == 1) {
			System.out.println("请输入用户名："); // 创建用户文件夹；
		}
		BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(
				System.in));
		userName = (keyboardIn.readLine());
		File folder = new File(userName);
		if (!folder.exists()) {
			folder.mkdirs();
		}

		fileName = "cj" + folder.lastModified() + ".his";
		File file = new File(folder, fileName);
		if (!file.exists()) {
			file.createNewFile();
		}
		

		// //////////////////////////【加法练习】//////////////////////////////////////////////
		if ("+".equals(args[0]) || ("r".equals(args[0]) && randomNumber == 1)) {
			Vector<Addition> operation = new Vector<Addition>();// //定义题目对象；
			int i = 0;
			while (i<10) {
			   
				operation.add(new Addition(numberOfDigit));
				operation.elementAt(i).titlesDisplay();
				operation.elementAt(i).setAnswer();
				operation.elementAt(i).doExercise();
				
				if (operation.elementAt(i).judge()) // 计算分数方法；
					scores++;
				if (!operation.elementAt(i).judgeGo())
					break;
				i++;
			}
	
			
			BufferedWriter file2 = new BufferedWriter(new FileWriter(file));
			for (Addition j : operation) { // 利用for循环的简化写法遍历、
				j.answersDisplay();
				file2.write(j.getFile());

			}
			String str = (int) ((scores * 100) / operation.size()) + "\n";
			file2.write("恭喜！您的分数是:");
			file2.write("\n");
			file2.write(str);
			file2.close();
			System.out.println("恭喜！您的分数是:");
			System.out.println((int) ((scores * 100) / operation.size()));
			

		}
*/


	

		// //////////////////////////【减法练习】//////////////////////////////////////////////
	/*else if ("-".equals(args[0])
				|| ("r".equals(args[0]) && randomNumber == 2)) {
			Vector<Subtraction> operation = new Vector<Subtraction>();// //定义题目对象；
			int i = 0;
			while (i<10) {
				
				operation.add(new Subtraction(numberOfDigit));
				operation.elementAt(i).titlesDisplay();
				operation.elementAt(i).setAnswer();
				operation.elementAt(i).doExercise();
				if (operation.elementAt(i).judge()) // 计算分数方法；
					scores++;
				if (!operation.elementAt(i).judgeGo())
					break;
				i++;
			}
			BufferedWriter file2 = new BufferedWriter(new FileWriter(file));
			
			for (Subtraction j : operation) { // 利用for循环的简化写法遍历、
				j.answersDisplay();
				file2.write(j.getFile());

			}
			String str = (int) ((scores * 100) / operation.size()) + "\n";
			file2.write("恭喜！您的分数是:");
			file2.write("\n");
			file2.write(str);
			file2.close();

			System.out.println("恭喜！您的分数是:");
			System.out.println((int) ((scores * 100) / operation.size()));

		}*/
		// /////////////////////////【乘法练习】//////////////////////////////////////////////
/*else if ("X".equals(args[0])
				|| ("r".equals(args[0]) && randomNumber == 3)) {

			Vector<Multiplication> operation = new Vector<Multiplication>();// //定义题目对象；
			int i = 0;
			while (i<10) {
				
				operation.add(new Multiplication(numberOfDigit));
				operation.elementAt(i).titlesDisplay();
				operation.elementAt(i).setAnswer();
				operation.elementAt(i).doExercise();
				if (operation.elementAt(i).judge()) // 计算分数方法；
					scores++;
				if (!operation.elementAt(i).judgeGo())
					break;
				i++;
			}
			BufferedWriter file2 = new BufferedWriter(new FileWriter(file));
			

			for (Multiplication j : operation) { // 利用for循环的简化写法遍历、
				j.answersDisplay();

				file2.write(j.getFile());

			}
			String str = (int) ((scores * 100) / operation.size()) + "\n";
			file2.write("恭喜！您的分数是:");
			file2.write("\n");
			file2.write(str);
			file2.close();
			System.out.println("恭喜！您的分数是:");
			System.out.println((int) ((scores * 100) / operation.size()));

		}*/

		// ///////////////////////////【除法练习】/////////////////////////////////////////////
		/*	else if ("/".equals(args[0])
				|| ("r".equals(args[0]) && randomNumber == 0)) {
			Vector<Division> operation = new Vector<Division>();// //定义题目对象；
			int i = 0;
			while (i<10) {
				
				operation.add(new Division(numberOfDigit));
				operation.elementAt(i).titlesDisplay();
				operation.elementAt(i).setAnswer();
				operation.elementAt(i).doExercise();
				operation.elementAt(i).titlesDisplay2();
				operation.elementAt(i).doExercise2();
				if (operation.elementAt(i).judge()) // 计算分数方法；
					scores++;
				if (!operation.elementAt(i).judgeGo())
					break;
				i++;
			}
			BufferedWriter file2 = new BufferedWriter(new FileWriter(file));
			

			for (Division j : operation) { // 利用for循环的简化写法遍历、
				j.answersDisplay();

				file2.write(j.getFile());

			}
			String str = (int) ((scores * 100) / operation.size()) + "\n";
			file2.write("恭喜！您的分数是:");
			file2.write("\n");
			file2.write(str);
			file2.close();
			System.out.println("恭喜！您的分数是:");
			System.out.println((int) ((scores * 100) / operation.size()));

		}*/

	}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}
