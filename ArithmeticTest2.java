import java.util.Random;
import java.util.Date;
import java.io.*;

public class ArithmeticTest2 
{
	public static void main(String[] args) throws Exception 
	{
		System.out.println ("加法运算练习软件");
    	//使用方法提示
    	if (args.length<1)
    	{
    		System.out.println("使用方法 java ArithmeticTest3  操作数位数");
    		System.out.println("如： java ArithmeticTest3 1");
    		System.out.println("表示做1位数的乘法。");
    	    return;
    	}
		
		Addition questions [] = new Addition[10]; //存放题目的数组
		int score=0; //存放用户得分
		int userAnswer; //存放用户答案
		int numberOfDigit=Integer.parseInt(args[0]);
		
    	//实例化键盘输入流
    	BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(System.in));	

		//出题答题
		for(int i=0;i<10;i++)
		{
			questions[i]=new Addition(numberOfDigit);
			questions[i].printQuestion();
			questions[i].setUserAnswer(Integer.parseInt(keyboardIn.readLine()));
			if(questions[i].judge())
			{
				System.out.println("回答正确");
				score+=10;
			}
			else 
			{
				System.out.println("错误");
				System.out.println("正确答案是："+questions[i].getAnswer());
			}
		}
		
		//打印题目和结果
		questions[0].printTitle();
		for(int i=0;i<10;i++) 
		{
			questions[i].printQuestionAnswer();
		}
		System.out.println ("你的得分是："+score+"分");
	}
}

/**
 *加法类
**/
class Addition
{
	private int numberOfDigit;
	private int number1; //操作数1
	private int number2; //操作数2
	private int result;  //正确答案
	private int userAnswer;  //用户答案
	private boolean answered=false; //用户已回答标志

	/**
	 *public Addition(int digit)构造方法
	 *随机生成题目并设置正确答案。操作数为digit位
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
     *public void setUserAnswer(int userAnswer)为设置用户答案的方法
     *如果用户提交了答案，则将已回答answered设为true。
    **/
	public void setUserAnswer(int userAnswer) 
	{
		this.userAnswer = userAnswer;
		answered=true;
	}
	
    /**
     *public boolean judge()为判断对错的方法
     *如果用户提交了答案且正确，则放回true,否则返回false。
     **/
	public boolean judge()
	{
		if(answered && userAnswer==result)
			return true;
		else
			return false;
	}

    /**
     *public int getAnswer()获得正确答案
     **/	
	public int getAnswer()
	{
		return result;
	}

    /**
     *public void printQuestion()打印题目
     **/	
	public void printQuestion() 
	{
	    String formatString="%1$"+numberOfDigit+"d + "+"%2$"+numberOfDigit+"d = ";
   		System.out.printf(formatString,number1,number2);
	}

    /**
     *public void printQuestionAnswer()打印题目和答案
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
		    String formatString="%1$"+numberOfDigit+"d + "+"%2$"+numberOfDigit+"d =        "+"%3$"+(numberOfDigit+1)+"d  "+"没有答题\n";
	   		System.out.printf(formatString,number1,number2,result);
		}
	}
	
	public void printTitle()
	{
		String title="";
		for(int i=0;i<numberOfDigit;i++)
			title=title+" ";
		title=title+"题目   ";
		for(int i=0;i<numberOfDigit;i++)
			title=title+" ";
		title=title+"正确答案";
		for(int i=0;i<numberOfDigit;i++)
			title=title+" ";
		title=title+" 你的答案";
		
   		System.out.println(title);
	}	
}
