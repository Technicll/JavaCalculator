
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons;
    JButton[] functionButtons;
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, clrButton, delButton;
    JButton negButton;
    JPanel panel;
    Font myFont1 = new Font("Impact", Font.BOLD, 30), myFont2 =  new Font("Impact", Font.BOLD, 20);
//creates a font object that sets the style and the size of the text.
    double num1 = 0, num2 = 0, result = 0;
//values which represent the numbers that the user will enter in the calculations.
    char operator;
//constant which will be used to determine the operator used witin the calculations.
/**
 * field variables of the Calculator class which represent the variables that are to be used in the method. 
*/
    Calculator() {
        frame = new JFrame("Calculator");
        //sets the title and adds a new UI frame to calculator.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame disappears when it is closed.
        frame.setSize(420, 550);
        //sets the size of the title window.
        frame.setLayout(null);
        //frame does not use layout manager.
        textfield = new JTextField();
        //creates a new textbox object called "textfield".
        textfield.setBounds(50, 25, 300, 50);
        //sets the size of the textbox "textfield".
        textfield.setFont(myFont1);
        //sets the font type of the textbox "textfield".
        textfield.setEditable(false);
        //sets the editable property of the textbox "textfield" to false.
        numberButtons = new JButton[10];
        //initialized the number of buttons to 10.
        functionButtons = new JButton[9];
        //initialized the number of function buttons to 9.
        addButton = new JButton("+");
        subButton = new JButton("-");
        divButton = new JButton("/");
        mulButton = new JButton("*");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");
        //insantiates all the new button objects
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = divButton;
        functionButtons[3] = mulButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        //adds all the button objects and assigns them an index in the button array.
        for (JButton o : functionButtons) {
            o.addActionListener(this);
            //adds an object listener to the JButton.
            o.setFont(myFont1);
            //sets the font of the JButton.
            o.setFocusable(false);
            //allows the user to focus on the JButton.
        }
        //enhanced for loop which assigns JButton objects of functionButtons their features.
        functionButtons[6].setFont(myFont2);
        functionButtons[7].setFont(myFont2);
        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            //creates the digits.
            numberButtons[i].setFont(myFont1);
            //sets the font of the digits.
            numberButtons[i].setFocusable(false);
            //allows the user to focus on the JButton.
            numberButtons[i].addActionListener(this);
            //adds an object listener to the JButton.
        }
        //normal for loop which creates and assigns JButton objects of numberButtons their features.
        negButton.setBounds(50,430,100,50);
        //sets the position and size of the negButton.
        delButton.setBounds(150, 430, 100, 50);
        //sets the position and size of the delButton.
        clrButton.setBounds(250, 430, 100, 50);
        //sets the position and size of the clrButton.
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.setBackground(Color.GRAY);
        //sets the background of the panel to a color encoded in the color class.
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        //adds all the object(s) to the frame component.
        frame.setVisible(true);
        //makes the frame visible in the program, can cause graphical issues if it is done more than once.
    }

    public static void main(String args[]) {
        Calculator calc = new Calculator();
    }

    @Override
    /**
     *
     * @param e the action performed
     */
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < numberButtons.length; i++) {
            if (e.getSource() == numberButtons[i]) 
            //event handler to determine the number button that was clicked.
            {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
                //changes the value of the textfield to the value of the number button based on the index of the event handler.
            }

        }
        //iterates through the index of each button.
        if(e.getSource() == decButton)
        //checks if the source of the event was the decButton.
        {
        textfield.setText(textfield.getText().concat("."));
        //inserts "concatenates" a period in the string to create a decimal point.
        }
        if(e.getSource() == addButton)
         //checks if the source of the event was the addButton.
        {
          num1 = Double.parseDouble(textfield.getText());
          //gets the current value displayed in "textfield".
          operator = '+';
          //sets the operator being used to addition.
          textfield.setText("");
          //clears "textfield", preparing it for the next input.
        }
        if(e.getSource() == subButton)
         //checks if the source of the event was the subButton.
        {
          num1 = Double.parseDouble(textfield.getText());
          //gets the current value displayed in "textfield".
          operator = '-';
          //sets the operator being used to subtraction.
          textfield.setText("");
          //clears "textfield", preparing it for the next input.
        }
        if(e.getSource() == divButton)
         //checks if the source of the event was the divButton.
        {
          num1 = Double.parseDouble(textfield.getText());
          //gets the current value displayed in "textfield".
          operator = '/';
          //sets the operator being used to division.
          textfield.setText("");
          //clears "textfield", preparing it for the next input.
        }
        if(e.getSource() == mulButton)
         //checks if the source of the event was the mulButton.
        {
          num1 = Double.parseDouble(textfield.getText());
          //gets the current value displayed in "textfield".
          operator = '*';
          //sets the operator being used to multiplication.
          textfield.setText("");
          //clears "textfield", preparing it for the next input.
        }
        if(e.getSource() == equButton)
         //checks if the source of the event was the decButton.
        {
          num2 = Double.parseDouble(textfield.getText());
          switch(operator)
          {
            case '+':
              result = num1+num2; 
              break;
            case '-':
              result = num1-num2; 
              break;
            case '*':
              result = num1*num2; 
              break;
            case '/':
              result = num1/num2; 
              break;
          }
          textfield.setText(String.valueOf(result));
          num1 = result;
        }
        if(e.getSource() == clrButton)
        {
          textfield.setText("");
        }
        if(e.getSource() == delButton)
        {
          String string = textfield.getText();
          textfield.setText("");
          for(int i = 0; i < string.length() - 1; i++)
          {
            textfield.setText(textfield.getText() + string.charAt(i));
          }

        }
        if(e.getSource() == negButton)
        {
          double temp = Double.parseDouble(textfield.getText());
          temp *=-1;
          textfield.setText(String.valueOf(temp));
        }
    }

}
