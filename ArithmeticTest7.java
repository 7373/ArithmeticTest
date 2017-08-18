/*������<<Сѧ������������ϰ������߰�>>��.
 *by Mr.Ran;
 *ÿ�����г���ʱҪ���������û�����
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
abstract class Operation {   // //////������

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

	

}

// //////////////Addition�̳��ࣺ

class Addition extends Operation {

	public Addition(int numberOfDigit) { // ���췽����
		super(numberOfDigit);

	}

	public void setAnswer() {
		setAnswer = operandNumber1 + operandNumber2;

	}

	/*public void doExercise() throws NumberTooBigException {// �����û��𰸷�����
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

		}}
		*/
	

	public String titlesDisplay() { // ��Ŀ��ӡ������
		String s=operandNumber1 + "+" + operandNumber2
				+ "=? " ;
		return s;
	}

	/*public void answersDisplay() { // �𰸴�ӡ������
		System.out.printf("%2d +%2d=��%4d %3d\n", operandNumber1,
				operandNumber2, setAnswer, userAnswer);

	}*/

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

	/*public void doExercise() throws NumberTooBigException {// �����û��𰸷�����
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
*/
	public String titlesDisplay() {
		String s=operandNumber1 + "-" + operandNumber2
				+ "=? " ;
		return s;
	}

/*	public void answersDisplay() {
		System.out.printf("%2d -%2d=��%4d %3d\n", operandNumber1,
				operandNumber2, setAnswer, userAnswer);
	}
*/
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

	/*public void doExercise() throws NumberTooBigException {// �����û��𰸷�����
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
*/
	public String titlesDisplay() {
		String s=operandNumber1 + "X" + operandNumber2
				+ "=? " ;
		return s;
	}

/*	public void answersDisplay() {
		System.out.printf("%2d X%2d=��%4d %3d\n", operandNumber1,
				operandNumber2, setAnswer, userAnswer);

	}
*/
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

	/*public void doExercise() throws NumberTooBigException {// �����û��𰸷�����
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

*/	public boolean judge() {

		return (setAnswer == userAnswer && setAnswer2 == userAnswer2) ? true
				: false;
	}

	public String titlesDisplay() {
		String s=operandNumber1 + "��" + operandNumber2
				+ "=? "+"�������̼�����";
		return s;
	}

	/*public void titlesDisplay2() {
		System.out.printf("����������:");
	}
	*/

	/*public void doExercise2() throws Exception { // ��������������

		BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(
				System.in));
		userAnswer2 = Integer.parseInt(keyboardIn.readLine()); // �����û��𰸣�
	}
*/
	/*public void answersDisplay() {
		System.out.printf("%2d ��%2d=��%2d %2d %2d %d\n", operandNumber1,
				operandNumber2, setAnswer, setAnswer2, userAnswer, userAnswer2);

	}*/

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

public class ArithmeticTest7 extends JFrame implements ActionListener{ // �������ࣻ

	public static void main(String[] args) throws Exception {
		JFrame frm=new JFrame("Сѧ������������ϰ��� ");
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
		j1.add(new JLabel("�û�����"));
		j2.add(new JTextField(4));
		j3.add(new JRadioButton("�ӷ�"));
		j3.add(new JRadioButton("����"));
		j3.add(new JRadioButton("�˷�"));
		j3.add(new JRadioButton("����"));
		j3.add(new JRadioButton("���"));
		j4.add(new JLabel("λ����"));
		j5.add(new JTextField(2));
		j6.add(new JButton("��ʼ"));
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
		
		
		//TextField tf = new TextField();  //����һ���ı���
		//JFormattedTextField l = new JFormattedTextField("�������û�����");
		//l.setHorizontalAlignment(JTextField.CENTER);
		//l.getText();
		//l.setBounds(10,10,10,10);
		//Button btn = new Button("��ť");
		//�������3�����
		//JButton jb=new JButton("��ť");
		//jb.setBounds(10, 10, 10, 10);
		//jb.setFont(new Font("����", Font.BOLD, 20));
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
			System.out.println("���������������(û��ָ�����߲�������)");
			test2 = 0;
		}
		if (!("+".equals(args[0]) || "-".equals(args[0]) || "X".equals(args[0])
				|| "/".equals(args[0]) || "r".equals(args[0]))) {
			System.out.println("�������ʹ���!");
			test2 = 0;

		}
		
		/*if (test2 == 1) {
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
			while (i<10) {
			   
				operation.add(new Addition(numberOfDigit));
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
*/


	

		// //////////////////////////��������ϰ��//////////////////////////////////////////////
	/*else if ("-".equals(args[0])
				|| ("r".equals(args[0]) && randomNumber == 2)) {
			Vector<Subtraction> operation = new Vector<Subtraction>();// //������Ŀ����
			int i = 0;
			while (i<10) {
				
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

		}*/
		// /////////////////////////���˷���ϰ��//////////////////////////////////////////////
/*else if ("X".equals(args[0])
				|| ("r".equals(args[0]) && randomNumber == 3)) {

			Vector<Multiplication> operation = new Vector<Multiplication>();// //������Ŀ����
			int i = 0;
			while (i<10) {
				
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

		}*/

		// ///////////////////////////��������ϰ��/////////////////////////////////////////////
		/*	else if ("/".equals(args[0])
				|| ("r".equals(args[0]) && randomNumber == 0)) {
			Vector<Division> operation = new Vector<Division>();// //������Ŀ����
			int i = 0;
			while (i<10) {
				
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

		}*/

	}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}
