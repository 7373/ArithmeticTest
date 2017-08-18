import java.util.Random;
import java.util.Date;
import java.io.*;

public class ArithmeticTest2 
{
	public static void main(String[] args) throws Exception 
	{
		System.out.println ("�ӷ�������ϰ���");
    	//ʹ�÷�����ʾ
    	if (args.length<1)
    	{
    		System.out.println("ʹ�÷��� java ArithmeticTest3  ������λ��");
    		System.out.println("�磺 java ArithmeticTest3 1");
    		System.out.println("��ʾ��1λ���ĳ˷���");
    	    return;
    	}
		
		Addition questions [] = new Addition[10]; //�����Ŀ������
		int score=0; //����û��÷�
		int userAnswer; //����û���
		int numberOfDigit=Integer.parseInt(args[0]);
		
    	//ʵ��������������
    	BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(System.in));	

		//�������
		for(int i=0;i<10;i++)
		{
			questions[i]=new Addition(numberOfDigit);
			questions[i].printQuestion();
			questions[i].setUserAnswer(Integer.parseInt(keyboardIn.readLine()));
			if(questions[i].judge())
			{
				System.out.println("�ش���ȷ");
				score+=10;
			}
			else 
			{
				System.out.println("����");
				System.out.println("��ȷ���ǣ�"+questions[i].getAnswer());
			}
		}
		
		//��ӡ��Ŀ�ͽ��
		questions[0].printTitle();
		for(int i=0;i<10;i++) 
		{
			questions[i].printQuestionAnswer();
		}
		System.out.println ("��ĵ÷��ǣ�"+score+"��");
	}
}

/**
 *�ӷ���
**/
class Addition
{
	private int numberOfDigit;
	private int number1; //������1
	private int number2; //������2
	private int result;  //��ȷ��
	private int userAnswer;  //�û���
	private boolean answered=false; //�û��ѻش��־

	/**
	 *public Addition(int digit)���췽��
	 *���������Ŀ��������ȷ�𰸡�������Ϊdigitλ
	**/
    public Addition(int numberOfDigit)
    {
    	this.numberOfDigit=numberOfDigit;
    	Random numberGenerator=new Random(new Date().getTime());
	    number1=numberGenerator.nextInt((int)Math.pow(10,numberOfDigit));
	    number2=numberGenerator.nextInt((int)Math.pow(10,numberOfDigit));
	    result=number1+number2;
    }
    
    /**
     *public void setUserAnswer(int userAnswer)Ϊ�����û��𰸵ķ���
     *����û��ύ�˴𰸣����ѻش�answered��Ϊtrue��
    **/
	public void setUserAnswer(int userAnswer) 
	{
		this.userAnswer = userAnswer;
		answered=true;
	}
	
    /**
     *public boolean judge()Ϊ�ж϶Դ�ķ���
     *����û��ύ�˴�����ȷ����Ż�true,���򷵻�false��
     **/
	public boolean judge()
	{
		if(answered && userAnswer==result)
			return true;
		else
			return false;
	}

    /**
     *public int getAnswer()�����ȷ��
     **/	
	public int getAnswer()
	{
		return result;
	}

    /**
     *public void printQuestion()��ӡ��Ŀ
     **/	
	public void printQuestion() 
	{
	    String formatString="%1$"+numberOfDigit+"d + "+"%2$"+numberOfDigit+"d = ";
   		System.out.printf(formatString,number1,number2);
	}

    /**
     *public void printQuestionAnswer()��ӡ��Ŀ�ʹ�
     **/	
	public void printQuestionAnswer() 
	{
		if(answered)
		{
		    String formatString="%1$"+numberOfDigit+"d + "+"%2$"+numberOfDigit+"d =        "+"%3$"+(numberOfDigit+1)+"d        "+"%4$"+(numberOfDigit+1)+"d\n";
	   		System.out.printf(formatString,number1,number2,result,userAnswer);
		}
		else
		{
		    String formatString="%1$"+numberOfDigit+"d + "+"%2$"+numberOfDigit+"d =        "+"%3$"+(numberOfDigit+1)+"d  "+"û�д���\n";
	   		System.out.printf(formatString,number1,number2,result);
		}
	}
	
	public void printTitle()
	{
		String title="";
		for(int i=0;i<numberOfDigit;i++)
			title=title+" ";
		title=title+"��Ŀ   ";
		for(int i=0;i<numberOfDigit;i++)
			title=title+" ";
		title=title+"��ȷ��";
		for(int i=0;i<numberOfDigit;i++)
			title=title+" ";
		title=title+" ��Ĵ�";
		
   		System.out.println(title);
	}	
}
