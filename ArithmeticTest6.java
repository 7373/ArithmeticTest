

/*下面是<<小学生四则运算练习软件第六版>>。
 *每次运行程序时计算机随机生成题目，程序每次显示一道题目，要求用户输入答案，之后询问用户是否要继续。
 *如果用户选择不继续(N)，则程序再显示全部题目，标准答案和用户的答案，并给出得分（每道题目的分值为100.0/题目数）。
 *运算类型以及参与运算的数据位数由命令行参数指定，运算类型用“+，-，X，/”分别表示“加减乘除”。
 *例如：  用下述命令运行程序，则表示做乘法
 Java  ArithmeticTest1  X 1
 *运算类型为“r”则随机生成运算符。
 *满分100分【每题100.0/(题目数)分】.
 *by Mr.Ran;
 *每次运行程序时要求先输入用户名；
 **/
import java.io.*;
import java.util.*;

abstract class Operation { // //////抽象类

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

	public boolean judgeGo() throws Exception {
		System.out.println("请问是否继续作答？（请输入\"Y或N\"");

		BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(
				System.in));
		String temps = (keyboardIn.readLine());
		return "Y".equals(temps);
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

	public void doExercise() throws NumberTooBigException {// 输入用户答案方法；
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

		}
	}

	public void titlesDisplay() { // 题目打印方法；
		System.out.printf("%d+%d=？", operandNumber1, operandNumber2);
	}

	public void answersDisplay() { // 答案打印方法；
		System.out.printf("%2d +%2d=？%4d %3d\n", operandNumber1,
				operandNumber2, setAnswer, userAnswer);

	}

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

	public void doExercise() throws NumberTooBigException {// 输入用户答案方法；
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

	public void titlesDisplay() {
		System.out.printf("%d-%d=？", operandNumber1, operandNumber2);
	}

	public void answersDisplay() {
		System.out.printf("%2d -%2d=？%4d %3d\n", operandNumber1,
				operandNumber2, setAnswer, userAnswer);
	}

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

	public void doExercise() throws NumberTooBigException {// 输入用户答案方法；
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

	public void titlesDisplay() {
		System.out.printf("%dX%d=？", operandNumber1, operandNumber2);
	}

	public void answersDisplay() {
		System.out.printf("%2d X%2d=？%4d %3d\n", operandNumber1,
				operandNumber2, setAnswer, userAnswer);

	}

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

	public void doExercise() throws NumberTooBigException {// 输入用户答案方法；
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

	public boolean judge() {

		return (setAnswer == userAnswer && setAnswer2 == userAnswer2) ? true
				: false;
	}

	public void titlesDisplay() {
		System.out.printf("%d÷%d=？(请先输入商）", operandNumber1, operandNumber2);
	}

	public void titlesDisplay2() {
		System.out.printf("请输入余数:");
	}

	public void doExercise2() throws Exception { // 输入余数方法；

		BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(
				System.in));
		userAnswer2 = Integer.parseInt(keyboardIn.readLine()); // 输入用户答案；
	}

	public void answersDisplay() {
		System.out.printf("%2d ÷%2d=？%2d %2d %2d %d\n", operandNumber1,
				operandNumber2, setAnswer, setAnswer2, userAnswer, userAnswer2);

	}

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

public class ArithmeticTest6 { // 定义主类；
	

	public static void main(String[] args) throws Exception {

		String userName;
		String fileName;
		int test2=1;
		int scores = 0;
		int numberOfDigit = 1;
		int randomNumber = (int) (Math.random() * 4);
		try {
			numberOfDigit = Integer.parseInt(args[1]);

		} catch (ArrayIndexOutOfBoundsException index) {
			System.out.println("请输入命令参数！(没有指定或者参数不足)");
			test2=0;
		}
		if (!("+".equals(args[0]) || "-".equals(args[0]) || "X".equals(args[0])
				|| "/".equals(args[0]) || "r".equals(args[0]))) {
			System.out.println("运算类型错误!");
			test2=0;

		}
		if(test2==1){
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
			while (true) {
				System.out.println("现在是第" + (i + 1) + "道题");
				operation.add(new Addition(numberOfDigit));
				operation.elementAt(i).titlesDisplay();
				operation.elementAt(i).setAnswer();
				operation.elementAt(i).doExercise();
				/*
				 * try{ operation.elementAt(i).doExercise(); } catch ()
				 */
				if (operation.elementAt(i).judge()) // 计算分数方法；
					scores++;
				if (!operation.elementAt(i).judgeGo())
					break;
				i++;
			}

			System.out.println("题目、标准答案及您的答案:");
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

		// //////////////////////////【减法练习】//////////////////////////////////////////////
		else if ("-".equals(args[0])
				|| ("r".equals(args[0]) && randomNumber == 2)) {
			Vector<Subtraction> operation = new Vector<Subtraction>();// //定义题目对象；
			int i = 0;
			while (true) {
				System.out.println("现在是第" + (i + 1) + "道题");
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
			System.out.println("题目、标准答案及您的答案:");
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

		}
		// /////////////////////////【乘法练习】//////////////////////////////////////////////
		else if ("X".equals(args[0])
				|| ("r".equals(args[0]) && randomNumber == 3)) {

			Vector<Multiplication> operation = new Vector<Multiplication>();// //定义题目对象；
			int i = 0;
			while (true) {
				System.out.println("现在是第" + (i + 1) + "道题");
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
			System.out.println("题目、标准答案及您的答案:");

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

		}

		// ///////////////////////////【除法练习】/////////////////////////////////////////////
		else if ("/".equals(args[0])
				|| ("r".equals(args[0]) && randomNumber == 0)) {
			Vector<Division> operation = new Vector<Division>();// //定义题目对象；
			int i = 0;
			while (true) {
				System.out.println("现在是第" + (i + 1) + "道题");
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
			System.out.println("题目、标准答案(包含余数）及您的答案:");

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

		}

	}

}