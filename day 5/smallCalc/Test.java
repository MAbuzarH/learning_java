import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


class SmallCalulator implements ActionListener{
  private JButton bPluse, bMul, bClc;
  private JFrame frame;
  private JTextField op1,op2,ans;
  private JLabel firstOpre,secOpre,answer;

  
  public SmallCalulator(){
    initGUI();
  }

  private void initGUI(){
    bPluse = new JButton("+");
    bMul = new JButton("*");
    frame = new JFrame("Mini Calculater");

    //lable :
    firstOpre = new JLabel("First number");
    secOpre = new JLabel("Sec number");
    answer = new JLabel("Result");

    op1 = new JTextField(10);
    op2 = new JTextField(10);
    ans = new JTextField(10);
    ans.setEditable(false);
    
    bPluse.addActionListener(this);
    bMul.addActionListener(this);

   frame.setLayout(new FlowLayout());
   frame.add(firstOpre);
   frame.add(op1);
   frame.add(secOpre);
   frame.add(op2);
   frame.add(bPluse);
   frame.add(bMul);
   frame.add(answer);
   frame.add(ans);

   //frame setup;
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setSize(400, 400);
   frame.setLocationRelativeTo(null);
   frame.setVisible(true);

  }


  public void actionPerformed(ActionEvent event){
    try{
    // String oper,result;
    int num1 = Integer.parseInt(op1.getText());
    int num2 = Integer.parseInt(op2.getText());
    int res =0;
    if(event.getSource() == bPluse){
      res = num1+num2;
    }else if(event.getSource() == bMul){
      res = num1*num2;
    }
    ans.setText(String.valueOf(res));
    // if(event.getSource() == bPluse){
    //   oper = op1.getText();
    //   num1 = integet.parseInt(oper);

    //   oper = op2.getText();
    //   num2 = integet.parseInt(oper);
      
    //   res = num1 + num2;
    //   result = res + " ";

    //   ans.setText(result);
    // }
    // else if(event.getSource() == bMul){
    //   oper = op1.getText();
    //   num1 = Integet.parseInt(oper);

    //   oper = op2.getText();
    //   num2 = Integet.parseInt(oper);
      
    //   res = num1 * num2;
    //   result = res + " ";

    //   ans.setText(result);
    // }
  }catch(NumberFormatException e){
  JOptionPane.showMessageDialog(frame, "Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
}
}
   
}

public class Test{
  public static void main(String[] args){
    SwingUtilities.invokeLater(SmallCalulator::new);
  }
}