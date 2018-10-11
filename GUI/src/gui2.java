/*
                                           ,....,.
                                          ..''   .'
                                       .'"       |
                                    .''          \
                                 .''              \.
                               .'                  .".,
                             ,:'             ..,'"'   '...,..::/"".....
                           /'"          .,'"'  .,',:,'""'         .,''
                         ,'.'      .,'"' ..,''' ""         .'   ."'
                       ,'  \, ..,''  .,''. ..,'""        ./   ."
                     ."     .,"  .,'".,"'./           ..''   /
                    ,'    .'  ./'.,"'  .'  "'     ." '.     /
                  .'   ./' ./"."\,..,''     '" ../,     ,  |
                 ,   ./' .'./'|/     ............        ',|
                /   /' ,'.".,'""\..... '""""""""'  .::/'.., |
               /  ." ,' ':\ """  |  ,      ''          '""   \
              /  /'.''. |:::::::""' ,' ' ''. ".,.,  """'    .""
             | ." /.,":. ""..,   "\'.."'..  ;"'  '\.'"""  ."
             | \.:\.    '""./\ \  | ' '" .,"".           /
             / \'   '"..     ", \  \,',     "'..  .,     '
            /.'",''..,  '\,   '\ ". '\'.,     , "'. "'.,|
           .,'        '". ',    \ '.".. ''../'      "" __\
           '             \,',    \  '.'\..,  ","'  .'"
                         |  |    '| ,\""'\/.  |  ."
            ."          .|  .    / / ./'. '.".' /'
            /'        ..|':"""\././  /   "  '/\.'
           //  ./  .'"    /' ./'.' .'  | ..,  ':|
         ./:  ,/   |",   ' ."'  :  '   |    .../:,
        .'.'.\/   /.'           ''  .,   ..\'
      .,\.\".'   /"    ,"' \...,      "\.\| ",
     /    ./""""'   ..:    ',|  "".,     '\  ',
  .,' "'   \|     "".'".    '/  .| '\.     ", '\
 /          \.    ../,   "./ '\ |'  \/"" '".'\  \
/   '\\:.   \,"\::'  ./""'    ./|  .'     .'"/| '|
' ,"\:"/"""  /'  ."\'  .., |:| .| |'    .'' .\|  ',
|/  / /'    .'| /  |. \,    /'"/. |  |:\..," .||  \
'' /.'      //\|'  '\/\:.   :,/"'::.  ,   ..::'|  |
            ||'/,    '\\/"\ '/|    '\ '"::::"| || .
            || \\       "".   ...,  '.  \\...| |' |
            ||  "\,         .".\, ". ', | \  '||  |
             '              |\|'|\/.''\ | |\  ||  |
                            ||\/"/| '\, ., / / /  ,
                             ' \  "   '"  / / .' /
                                '      .'".' .' /
                                  ..'"'.." ." ."
                              .,"":.'""..'" ."
                         .,:'"'"'  .'"  ..'"
                       ." ."'..'""...,"'
                    .." "    , ""'
                   /  . :/"'
                 .'  :/'
                /  /'
               / .'
              / '
             /.'
             '


 -_. -.\  \ .-.----..-----. .----. .---. .-.----:
  | | | |  | | .-. ||._-  || .-. || .-. | | .-. ||
 .| |/__/  / | |  - .'.-. || '_' || | | | | | | ||
|       ._- .| |.   | '-' |'___. || '_' |.| |.| |.
 -------    '---'    '----:--._| | '---' '---'---'
                          '______'.----_
                                  | ._.-_'-_
                                   -_. -.\  \ .-----. ----..---------.-.----.
                                    | | | |  ||._-  |  \  \'/ \'\  /  | .-. |
                                   .| |/__/  /.'.-. |   \  ' . '' /   | | | |
                                  |       ._- | '-' |    \  / \  /   .| |.| |.
                                   -------     '----'     ''   ''    '---'---
*/
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends Applet {
// all the variables used as well as queues stacks and textfields.
	private static final long serialVersionUID = 1L;
	private JButton one, two , three, four, five, six, seven, eight, nine, zero, add, subtract, multiply, div, equals, clear;
	private String expression;
	private String stemp2;
	private JPanel contentpanel;
	private boolean opChosen = false;
	public queue postQ = new queue();
	public queue inQ = new queue();
	public stack opS = new stack();
	public stack calculate = new stack();
	public JTextField textfield = new JTextField(null, 20);
	public JTextField answerfield = new JTextField(null, 20);
	
	// initialization runs the function setDisplay() which does pretty much everything visually for the user.
	public void init (){ 
		setDisplay();
	}
	// function: setDisplay()
	// the function makes the buttons on the screen plus their listeners and other functions and panels
		public void setDisplay(){
		// makes textfields uneditable
		textfield.setEditable(false);
		answerfield.setEditable(false);
		// creates the buttons used to make the GUI
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five= new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		zero = new JButton("0");
		add = new JButton("+");
		multiply = new JButton("x");
		subtract = new JButton("-");
		div = new JButton("/");
		equals = new JButton("=");
		clear = new JButton ("C");
		// makes a standard dimension dim  for almost all the buttons
		Dimension dim = new Dimension(75,25);
		// makes a standard size for all the buttons
		//except equals zero and the operation buttons
		one.setPreferredSize(dim);
		two.setPreferredSize(dim);
		three.setPreferredSize(dim);
		four.setPreferredSize(dim);
		five.setPreferredSize(dim);
		six.setPreferredSize(dim);
		seven.setPreferredSize(dim);
		eight.setPreferredSize(dim);
		nine.setPreferredSize(dim);
		zero.setPreferredSize(new Dimension (225,25));
		multiply.setPreferredSize(new Dimension (113,25));
		equals.setPreferredSize(new Dimension (225,25));
		subtract.setPreferredSize(new Dimension (113,25));
		div.setPreferredSize(new Dimension (113,25));
		add.setPreferredSize(new Dimension (113,25));
		// makes an instance of the listeners
		Numbers n = new Numbers();
		calc c = new calc();
		// adds the listeners to each button respectively
		one.addActionListener(n);
		two.addActionListener(n);
		three.addActionListener(n);
		four.addActionListener(n);
		five.addActionListener(n);
		six.addActionListener(n);
		seven.addActionListener(n);
		eight.addActionListener(n);
		nine.addActionListener(n);
		zero.addActionListener(n);
		
		add.addActionListener(c);
		subtract.addActionListener(c);
		div.addActionListener(c);
		multiply.addActionListener(c);
		equals.addActionListener(c);
		clear.addActionListener(c);
		// creates the content panels and 
		//sets color background and layout
		contentpanel = new JPanel();
		contentpanel.setBackground(Color.BLUE);
		contentpanel.setLayout(new BoxLayout(contentpanel, BoxLayout.PAGE_AXIS));
		contentpanel.setSize(new Dimension(500, 500));
		contentpanel.add(textfield, BorderLayout.NORTH);
		
		// adds everything to the content panel
		
		contentpanel.add(one);contentpanel.add(two);contentpanel.add(three);
		contentpanel.add(four);contentpanel.add(five);contentpanel.add(six);
		contentpanel.add(seven);contentpanel.add(eight);contentpanel.add(nine);
		contentpanel.add(zero);contentpanel.add(add);contentpanel.add(subtract);
		contentpanel.add(multiply);contentpanel.add(div);contentpanel.add(equals);
		contentpanel.add(clear);
		
		// adds the textfields to the applet of java
		add (textfield);
		textfield.setLocation(getHeight(), getWidth());
		textfield.setSize(200,200);
		add (answerfield);
		textfield.setLocation(getHeight(), getWidth());
		textfield.setSize(200,200);
		
		add (one);
		add (two);
		add (three);
		add (four);
		add (five);
		add (six);
		add (seven);
		add (eight);
		add (nine);
		add (zero);
		add (div);
		add (multiply);
		add (subtract);
		add (add);
		add (equals);
		add (clear);
		setLayout(getLayout());
}
		// FUNCTION: parse()
		// the function enqueues whatever is in the textfield 
		// onto the inQ queue
	public void parse(String arg){
		int i, j, p; // variables used 
		char[] operators;// char array for the operators
		operators = new char[4];
		operators[0] = '+';
		operators[1] = '-';
		operators[2] = 'x';
		operators[3] = '/';
		
		p=0;
		for (i=0; i< arg.length(); i++){
			for (j=0; j<operators.length; j++){
				if (arg.charAt(i) == operators[j]){// finding out which operator it is using the char array
					inQ.enqueue(arg.substring(p,i));// enqueues when the operators are equal to the of the entered text
					inQ.enqueue(arg.substring(i,i+1));
					p=i+1;
				}
			}
			}
		inQ.enqueue(arg.substring(p));
	}
	// FUNCTION:doExpression
	// the function is basically the calculator class of the last assignment
	// function that is the inside of the calculator changes from infix to postfix then concludes the operation.
public  double doExpression(queue args) {
	// declaring temp and dequeueing the first input in it
	String temp;
	{while ( args.top != null){
		temp = inQ.dequeue();

		// checking if the item is an operator or an operand
		switch (temp){
				case "+":
				case "-":
				case "x":
				case "/":
			if (opS.top == null ){
					opS.push(temp);
				}
			// if it is an operator it is pushed onto the stack on it if it is empty
			else{
			switch (temp){// otherwise the switch statement handles it, ( this is where the shunting yard algorithm actually starts
				case "+":
					while ((opS.top.payload) .equals("+") || (opS.top.payload) .equals("-")
							|| (opS.top.payload) .equals("x") || (opS.top.payload) .equals("/"))// declaring precedence if the + is the operator already in the stack
					{
						postQ.enqueue(opS.pop());
						if (opS.top ==null )
							break;
					}
					opS.push(temp);
					
					break;
				case "-":
					while ((opS.top.payload) .equals("+") || (opS.top.payload) .equals("-")
							|| (opS.top.payload) .equals("x") || (opS.top.payload) .equals("/"))// basically the same thing for -
					{
						postQ.enqueue(opS.pop());
						if (opS.top ==null )
							break;
					}
						opS.push(temp);
					
					break;
				case "x":
					while ((opS.top.payload) .equals("x") || (opS.top.payload).equals("/"))// if "x" is in the function it is queued above it only if it is "x" or "/"
					{
						postQ.enqueue(opS.pop());	// the same stands for if "/" is already in the operator stack
						if (opS.top ==null )
							break;
					}
					opS.push(temp);
				
					break;
				case "/":
					while ((opS.top.payload) .equals("x") || (opS.top.payload).equals("/"))
					{
						postQ.enqueue(opS.pop());
						if (opS.top ==null )
							break;
					}
					opS.push(temp);
					
					break;
				}
			}
				break;
				default:{ // if the input is an operand it is directly enqueued in the final queue
			postQ.enqueue(temp);
		}	
	}	
}}
	// enqueues everything into postQ
while (opS.top != null)
		postQ.enqueue(opS.pop());		

//	These two lines input the first two numbers from the postfix queue into the calculator stack.
	calculate.push(postQ.dequeue());			
	calculate.push(postQ.dequeue());
	
//	dequeueing the payload of postQ		
	while (postQ.top != null){		
	temp=postQ.dequeue();
//	Checks to see if temp is an operator or an operand.		
	if (temp.equals("+") || temp.equals("-") || temp.equals("x") || temp.equals("/")){
//	check which operator is taken out of the queue and   
//	perform the correct operation on the top two elements of the calculator stack.	
		switch (temp) {
//	The values are converted back into strings from floats when pushed into Calculator stack.
		case "+" : calculate.push(String.valueOf(calculate.add()));
		break;
		case "-" : calculate.push(String.valueOf(calculate.subtract()));
		break;
		case "x" : calculate.push(String.valueOf(calculate.multiply()));
		break;
		case "/" : calculate.push(String.valueOf(calculate.divide()));
		break;
		}
		}else {
//		else statement not an operator then push into Calculator stack without 
//	passing through the operator checks.					
			calculate.push(temp);
			}
	
	}
//		Print out the last answer.
	System.out.print(" = ");			// Print onto command line.
	System.out.print(calculate.top.payload);
				
 
	double x = Double.parseDouble(calculate.top.payload);
		return x;

}



	// the function is what the listeners do which is concatenate the button(equivalent value)
	// to the expression string
	private class Numbers implements ActionListener{
		public void actionPerformed (ActionEvent event){
			JButton src =  (JButton) event.getSource();
			if (src.equals(one)){// if the button (one) is pressed
				
					if (expression == null){// and the expression is empty
						expression = "1";// then on is equal to the expression
					}else 
						expression = expression + "1";// otherwise the string is concatenated to the button
				
					if (stemp2 == null){// the main reason behind this string is to make it easier to clear the claculator later on
						stemp2 = "1";
					}else 
						stemp2 = stemp2 + "1";// everything is the same for the rest  of the buttons
			}
			if (src.equals(two)){
				
					if (expression == null){
						expression = "2";
					}else 
						expression = expression + "2";
				
					if (stemp2 == null){
						stemp2 = "2";
					}else 
						stemp2 = stemp2 + "2";
			}			
			if (src.equals(three)){
				
					if (expression == null){
						expression = "3";
					}else 
						expression = expression + "3";
				
					if (stemp2 == null){
						stemp2 = "3";
					}else 
						stemp2 = stemp2 + "3";
			}			
			if (src.equals(four)){
					if (expression == null){
						expression = "4";
					}else {
						expression = expression + "4";}
				
					if (stemp2 == null){
						stemp2 = "4";
					}else 
						stemp2 = stemp2 + "4";}
						
			if (src.equals(five)){
					if (expression == null){
						expression = "5";
					}else 
						expression = expression + "5";
				
					if (stemp2 == null){
						stemp2 = "5";
					}else 
						stemp2 = stemp2 + "5";
			}		
			if (src.equals(six)){
				
					if (expression == null){
						expression = "6";
					}else 
						expression = expression + "6";
				
					if (stemp2 == null){
						stemp2 = "6";
					}else 
						stemp2 = stemp2 + "6";
			}			
			if (src.equals(seven)){
			
					if (expression == null){
						expression = "7";
					}else 
						expression = expression + "7";
				
					if (stemp2 == null){
						stemp2 = "7";
					}else 
						stemp2 = stemp2 + "7";
			}			
			if (src.equals(eight)){
				
					if (expression == null){
						expression = "8";
					}else 
						expression = expression + "8";
				
					if (stemp2 == null){
						stemp2 = "8";
					}else 
						stemp2 = stemp2 + "8";
			}			
			if (src.equals(nine)){
			
					if (expression == null){
						expression = "9";
					}else 
						expression = expression + "9";
				
					if (stemp2 == null){
						stemp2 = "9";
					}else 
						stemp2 = stemp2 + "9";
			}			
			if (src.equals(zero)){
				
					if (expression == null){
						expression = "0";
					}else 
						expression = expression + "0";
				
					if (stemp2 == null){
						stemp2 = "0";
					}else 
						stemp2 = stemp2 + "0";
			}
			if (opChosen==false) {
			textfield.setText(expression);}
			else{
				textfield.setText(stemp2);}
		}
	}
	private class calc implements ActionListener{
		public void actionPerformed (ActionEvent event){
			JButton src =  (JButton) event.getSource();
			if (src.equals(add)){ // concatenates the operator to the calculator same goes for the restof the operators
				if (expression == null){
					System.out.println("error");
				}else{
				expression = expression + "+";}}
			if (src.equals(multiply)){ 
				if (expression == null){
					System.out.println("error");
				}else{
				expression = expression + "x";}}
			if (src.equals(div)){ 				
				if (expression == null){
			
				System.out.println("error");
			}else{
				expression = expression + "/";}}
			if (src.equals(subtract)){ 
				if (expression == null){
					System.out.println("error");
				}else{
				expression = expression + "-";}}
			if (src.equals(equals)){
				if (expression == null){
					System.out.println("error");
				}else{
				textfield.setText(expression);
				parse(expression);// calls  the parse function to enqueue the expression into the inQ queue.
				answerfield.setText(String.valueOf(doExpression(inQ)));}// calls the doexpression onto the inQ queue and then finds the 
				//value of it and finally sets it in the answerfield
				
				
			}
			if (src.equals(clear)){// neutralizes all the variables in order to clear the calculator
				expression= null;
				stemp2= null;
				opChosen = false;
				textfield.setText(null);
				answerfield.setText(null);
			}
			}
		
			}
	
		}
	

	
