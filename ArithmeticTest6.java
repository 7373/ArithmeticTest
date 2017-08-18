

/*������<<Сѧ������������ϰ���������>>��
 *ÿ�����г���ʱ��������������Ŀ������ÿ����ʾһ����Ŀ��Ҫ���û�����𰸣�֮��ѯ���û��Ƿ�Ҫ������
 *����û�ѡ�񲻼���(N)�����������ʾȫ����Ŀ����׼�𰸺��û��Ĵ𰸣��������÷֣�ÿ����Ŀ�ķ�ֵΪ100.0/��Ŀ������
 *���������Լ��������������λ���������в���ָ�������������á�+��-��X��/���ֱ��ʾ���Ӽ��˳�����
 *���磺  �������������г������ʾ���˷�
 Java  ArithmeticTest1  X 1
 *��������Ϊ��r������������������
 *����100�֡�ÿ��100.0/(��Ŀ��)�֡�.
 *by Mr.Ran;
 *ÿ�����г���ʱҪ���������û�����
 **/
import java.io.*;
import java.util.*;

abstract class Operation { // //////������

	protected int numberOfDigit; // ���������λ����
	protected int operandNumber1;// ���������1��
	protected int operandNumber2;// ���������2��
	protected int userAnswer; // �����û��𰸣�
	protected int setAnswer; // ������ȷ�𰸣�

	public Operation(int numberOfDigit) {// Operation ���๹�췽����

		this.numberOfDigit = numberOfDigit;
		operandNumber1 = (int) (Math.random() * Math.pow(10, numberOfDigit));
		operandNumber2 = (int) (Math.random() * Math.pow(10, numberOfDigit));
		setAnswer();
	}

	abstract void setAnswer();

	{
	} // ������ȷ�𰸳��󷽷���

	public boolean judge() { // �жϷ�����
		return (setAnswer == userAnswer) ? true : false;
	}

	public boolean judgeGo() throws Exception {
		System.out.println("�����Ƿ�������𣿣�������\"Y��N\"");

		BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(
				System.in));
		String temps = (keyboardIn.readLine());
		return "Y".equals(temps);
	}

}

// //////////////Addition�̳��ࣺ

class Addition extends Operation {

	public Addition(int numberOfDigit) { // ���췽����
		super(numberOfDigit);

	}

	public void setAnswer() {
		setAnswer = operandNumber1 + operandNumber2;

	}

	public void doExercise() throws NumberTooBigException {// �����û��𰸷�����
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
				System.out.println("�����������ʹ��������������ֵ���ݣ�");
				test++;
			} finally {
				if (test == 0)
					break;
			}
		}

		if (userAnswer > max) {
			System.out.println("������Ĵ𰸳����˿��ܵķ�Χ������Ӧ��С��" + max);

			try {
				BufferedReader keyboardIn = new BufferedReader(
						new InputStreamReader(System.in));
				userAnswer = Integer.parseInt(keyboardIn.readLine());
			}

			catch (Exception e) {
			}

		}
	}

	public void titlesDisplay() { // ��Ŀ��ӡ������
		System.out.printf("%d+%d=��", operandNumber1, operandNumber2);
	}

	public void answersDisplay() { // �𰸴�ӡ������
		System.out.printf("%2d +%2d=��%4d %3d\n", operandNumber1,
				operandNumber2, setAnswer, userAnswer);

	}

	public String getFile() {
		String f = "��Ŀ����׼�𰸡��û���:" + operandNumber1 + "+" + operandNumber2
				+ "=? " + setAnswer + " " + userAnswer + "\n";

		return f;
	}
}

// /����Subtraction�̳���

class Subtraction extends Operation {
	public Subtraction(int numberOfDigit) {
		super(numberOfDigit);

		if (operandNumber1 < operandNumber2) // �ų�������С�ڼ��������
		{
			int temp = operandNumber1;
			operandNumber1 = operandNumber2;
			operandNumber2 = temp;
		}

	}

	public void setAnswer() {
		setAnswer = operandNumber1 - operandNumber2;

	}

	public void doExercise() throws NumberTooBigException {// �����û��𰸷�����
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
				System.out.println("�����������ʹ��������������ֵ���ݣ�");
				test++;
			} finally {
				if (test == 0)
					break;
			}
		}
		// if(userAnswer<10)
		if (userAnswer > max) {
			System.out.println("������Ĵ𰸳����˿��ܵķ�Χ������Ӧ��С��" + max);

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
		System.out.printf("%d-%d=��", operandNumber1, operandNumber2);
	}

	public void answersDisplay() {
		System.out.printf("%2d -%2d=��%4d %3d\n", operandNumber1,
				operandNumber2, setAnswer, userAnswer);
	}

	public String getFile() {
		String f = "��Ŀ����׼�𰸡��û���:" + operandNumber1 + "-" + operandNumber2
				+ "=? " + setAnswer + " " + userAnswer + "\n";

		return f;
	}

}

// ////�˷�Multiplication��

class Multiplication extends Operation {
	public Multiplication(int numberOfDigit) {
		super(numberOfDigit);

	}

	public void setAnswer() {
		setAnswer = operandNumber1 * operandNumber2;

	}

	public void doExercise() throws NumberTooBigException {// �����û��𰸷�����
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
				System.out.println("�����������ʹ��������������ֵ���ݣ�");
				test++;
			} finally {
				if (test == 0)
					break;
			}
		}

		if (userAnswer > max) {
			System.out.println("������Ĵ𰸳����˿��ܵķ�Χ������Ӧ��С��" + max);

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
		System.out.printf("%dX%d=��", operandNumber1, operandNumber2);
	}

	public void answersDisplay() {
		System.out.printf("%2d X%2d=��%4d %3d\n", operandNumber1,
				operandNumber2, setAnswer, userAnswer);

	}

	public String getFile() {
		String f = "��Ŀ����׼�𰸡��û���:" + operandNumber1 + "X" + operandNumber2
				+ "=? " + setAnswer + " " + userAnswer + "\n";

		return f;
	}
}

// /�ͳ���Division

class Division extends Operation {
	public int setAnswer2, userAnswer2;// ������ȷ���������û�������

	public Division(int numberOfDigit) {
		super(numberOfDigit);
		if (operandNumber2 == 0)// /�ų�����Ϊ0�������
			operandNumber2++;
	}

	public void setAnswer() {

		setAnswer = operandNumber1 / operandNumber2;
		setAnswer2 = operandNumber1 % operandNumber2;
	}

	public void doExercise() throws NumberTooBigException {// �����û��𰸷�����
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
				System.out.println("�����������ʹ��������������ֵ���ݣ�");
				test++;
			} finally {
				if (test == 0)
					break;
			}
		}

		if (userAnswer > max) {
			System.out.println("������Ĵ𰸳����˿��ܵķ�Χ������Ӧ��С��" + max);

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
		System.out.printf("%d��%d=��(���������̣�", operandNumber1, operandNumber2);
	}

	public void titlesDisplay2() {
		System.out.printf("����������:");
	}

	public void doExercise2() throws Exception { // ��������������

		BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(
				System.in));
		userAnswer2 = Integer.parseInt(keyboardIn.readLine()); // �����û��𰸣�
	}

	public void answersDisplay() {
		System.out.printf("%2d ��%2d=��%2d %2d %2d %d\n", operandNumber1,
				operandNumber2, setAnswer, setAnswer2, userAnswer, userAnswer2);

	}

	public String getFile() {
		String f = "��Ŀ����׼�𰸡��û��𰸣�����������:" + operandNumber1 + "��"
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

public class ArithmeticTest6 { // �������ࣻ
	

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
			System.out.println("���������������(û��ָ�����߲�������)");
			test2=0;
		}
		if (!("+".equals(args[0]) || "-".equals(args[0]) || "X".equals(args[0])
				|| "/".equals(args[0]) || "r".equals(args[0]))) {
			System.out.println("�������ʹ���!");
			test2=0;

		}
		if(test2==1){
			System.out.println("�������û�����"); // �����û��ļ��У�
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

		// //////////////////////////���ӷ���ϰ��//////////////////////////////////////////////
		if ("+".equals(args[0]) || ("r".equals(args[0]) && randomNumber == 1)) {
			Vector<Addition> operation = new Vector<Addition>();// //������Ŀ����
			int i = 0;
			while (true) {
				System.out.println("�����ǵ�" + (i + 1) + "����");
				operation.add(new Addition(numberOfDigit));
				operation.elementAt(i).titlesDisplay();
				operation.elementAt(i).setAnswer();
				operation.elementAt(i).doExercise();
				/*
				 * try{ operation.elementAt(i).doExercise(); } catch ()
				 */
				if (operation.elementAt(i).judge()) // �������������
					scores++;
				if (!operation.elementAt(i).judgeGo())
					break;
				i++;
			}

			System.out.println("��Ŀ����׼�𰸼����Ĵ�:");
			BufferedWriter file2 = new BufferedWriter(new FileWriter(file));
			for (Addition j : operation) { // ����forѭ���ļ�д��������
				j.answersDisplay();
				file2.write(j.getFile());

			}
			String str = (int) ((scores * 100) / operation.size()) + "\n";
			file2.write("��ϲ�����ķ�����:");
			file2.write("\n");
			file2.write(str);
			file2.close();
			System.out.println("��ϲ�����ķ�����:");
			System.out.println((int) ((scores * 100) / operation.size()));

		}

		// //////////////////////////��������ϰ��//////////////////////////////////////////////
		else if ("-".equals(args[0])
				|| ("r".equals(args[0]) && randomNumber == 2)) {
			Vector<Subtraction> operation = new Vector<Subtraction>();// //������Ŀ����
			int i = 0;
			while (true) {
				System.out.println("�����ǵ�" + (i + 1) + "����");
				operation.add(new Subtraction(numberOfDigit));
				operation.elementAt(i).titlesDisplay();
				operation.elementAt(i).setAnswer();
				operation.elementAt(i).doExercise();
				if (operation.elementAt(i).judge()) // �������������
					scores++;
				if (!operation.elementAt(i).judgeGo())
					break;
				i++;
			}
			BufferedWriter file2 = new BufferedWriter(new FileWriter(file));
			System.out.println("��Ŀ����׼�𰸼����Ĵ�:");
			for (Subtraction j : operation) { // ����forѭ���ļ�д��������
				j.answersDisplay();
				file2.write(j.getFile());

			}
			String str = (int) ((scores * 100) / operation.size()) + "\n";
			file2.write("��ϲ�����ķ�����:");
			file2.write("\n");
			file2.write(str);
			file2.close();

			System.out.println("��ϲ�����ķ�����:");
			System.out.println((int) ((scores * 100) / operation.size()));

		}
		// /////////////////////////���˷���ϰ��//////////////////////////////////////////////
		else if ("X".equals(args[0])
				|| ("r".equals(args[0]) && randomNumber == 3)) {

			Vector<Multiplication> operation = new Vector<Multiplication>();// //������Ŀ����
			int i = 0;
			while (true) {
				System.out.println("�����ǵ�" + (i + 1) + "����");
				operation.add(new Multiplication(numberOfDigit));
				operation.elementAt(i).titlesDisplay();
				operation.elementAt(i).setAnswer();
				operation.elementAt(i).doExercise();
				if (operation.elementAt(i).judge()) // �������������
					scores++;
				if (!operation.elementAt(i).judgeGo())
					break;
				i++;
			}
			BufferedWriter file2 = new BufferedWriter(new FileWriter(file));
			System.out.println("��Ŀ����׼�𰸼����Ĵ�:");

			for (Multiplication j : operation) { // ����forѭ���ļ�д��������
				j.answersDisplay();

				file2.write(j.getFile());

			}
			String str = (int) ((scores * 100) / operation.size()) + "\n";
			file2.write("��ϲ�����ķ�����:");
			file2.write("\n");
			file2.write(str);
			file2.close();
			System.out.println("��ϲ�����ķ�����:");
			System.out.println((int) ((scores * 100) / operation.size()));

		}

		// ///////////////////////////��������ϰ��/////////////////////////////////////////////
		else if ("/".equals(args[0])
				|| ("r".equals(args[0]) && randomNumber == 0)) {
			Vector<Division> operation = new Vector<Division>();// //������Ŀ����
			int i = 0;
			while (true) {
				System.out.println("�����ǵ�" + (i + 1) + "����");
				operation.add(new Division(numberOfDigit));
				operation.elementAt(i).titlesDisplay();
				operation.elementAt(i).setAnswer();
				operation.elementAt(i).doExercise();
				operation.elementAt(i).titlesDisplay2();
				operation.elementAt(i).doExercise2();
				if (operation.elementAt(i).judge()) // �������������
					scores++;
				if (!operation.elementAt(i).judgeGo())
					break;
				i++;
			}
			BufferedWriter file2 = new BufferedWriter(new FileWriter(file));
			System.out.println("��Ŀ����׼��(���������������Ĵ�:");

			for (Division j : operation) { // ����forѭ���ļ�д��������
				j.answersDisplay();

				file2.write(j.getFile());

			}
			String str = (int) ((scores * 100) / operation.size()) + "\n";
			file2.write("��ϲ�����ķ�����:");
			file2.write("\n");
			file2.write(str);
			file2.close();
			System.out.println("��ϲ�����ķ�����:");
			System.out.println((int) ((scores * 100) / operation.size()));

		}

	}

}