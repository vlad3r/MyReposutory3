/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jtag2;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/**
 *
 * @author Vlad
 */
public class JTag2 {
    Thread thrd;
 public static int findSpace(byte s[]){
 for (int i=0;i<s.length;i++){
     if (s[i]==0){
     if (i==0)
         return 1;
     else
         return i/4+1;
     }}
    return -1;     
 }    
    public static void shuffleArray(byte array [],String str []) {
        int N=1;// случайная растановка элементов
        while(N%2!=0){
    for (int i = array.length - 1; i >= 0; i--) {
        byte j = (byte) Math.floor(Math.random() * (i + 1));
        byte temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        //System.out.print(array[i]+" ");
        
       
       str[i]=Integer.toString(array[i]);
       
           
   
            
    }
     int k=0;
    for(int i=0;i<15;i++)
        if (Integer.parseInt(str[i])<Integer.parseInt(str[i+1]))
            k++;
    N=k+findSpace(array);
        }
    
   
}
 static JButton [] jbtn=new JButton [16];
String massiv[]=new String[16];
    JTag2(){  
    JFrame jfr=new JFrame("Tag");
    
jfr.setLayout(new GridLayout(4,4));
jfr.setSize(400,400);
jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
byte m [] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
shuffleArray(m,massiv);
for (int i=0;i<massiv.length;i++)
{jbtn[i]=new JButton(massiv[i]);
    jfr.add(jbtn[i]);
    if (jbtn[i].getText()==" ")jbtn[i].setEnabled(false);
}
jbtn[0].addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            myequals(0,1,4);
        }
    });
jbtn[1].addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
         myequals(1,0,2,5);  
        }    
    });
jbtn[2].addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        myequals(2,1,3,6);
        }
    }
);
jbtn[3].addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        myequals(3,2,7);
        }
    });
jbtn[4].addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        myequals(4,0,5,8);
        }
    });
jbtn[5].addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
           myequals(5,1,4,9,6); 
        }
    });
jbtn[6].addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        myequals(6,2,5,10,7);
        }
    });
jbtn[7].addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        myequals(7,3,6,11);
        }
    });
jbtn[7].addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        myequals(7,3,6,11);
        }
    });
jbtn[8].addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        myequals(8,4,9,12);        
        }
    });
jbtn[9].addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        myequals(9,5,8,13,10);        
        }
    });
jbtn[10].addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        myequals(10,6,9,14,11);        
        }
    });
jbtn[11].addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        myequals(11,7,10,15);        
        }
    });
jbtn[12].addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        myequals(12,8,13);        
        }
    });
jbtn[13].addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        myequals(13,9,12,14);        
        }
    });
jbtn[14].addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        myequals(14,10,13,15);        
        }
    });
jbtn[15].addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        myequals(15,11,14);        
        }
    });
jfr.setVisible(true);

}
    /*public static void vin(){
    String str []={" ","1","2","3","4","5","6","7",
             "8","9","10","11","12","13","14","15"};
    byte truecheck=0;
    for (int i=0;i<str.length;i++){
        if (str[i]==jbtn[i].getText())
            truecheck++;
            }
    if (truecheck==16) {
        System.exit(0);
    }
    
    }*/
    public static void vin2(){
    String str []={"1","2","3","4","5","6","7",
             "8","9","10","11","12","13","14","15"," "};
    byte truecheck=0;
    for (int i=0;i<str.length;i++){
        if (str[i].equals(jbtn[i].getText()))
            truecheck++;
            }
    
    if (truecheck==16) {
       
            System.exit(0);
        
           
        }
    }
    
    
    public static void swap(int in1, int in2 ){ // перестановка названий кнопок, in1-индекс нажатой, in2-индекс сравниваемой кнопки
String str=jbtn[in2].getText();
        jbtn[in2].setText(jbtn[in1].getText());
        jbtn[in1].setText(str);
        jbtn[in1].setEnabled(false);
        jbtn[in2].setEnabled(true);
}
    public static void myequals(int  in1,int in2, int in3 ){ // для 2 сравнений
    if (jbtn[in2].getText()==" "){
            swap(in1,in2);
        }
        if (jbtn[in3].getText()==" "){
        swap(in1,in3);     
        }
        //vin();
        vin2();
    }
    public static void myequals(int  in1,int in2, int in3,int in4,int in5){ // для 4 сравнений
    myequals(in1,in2,in3);
    myequals(in1,in4,in5);
    }
     public static void myequals(int  in1,int in2, int in3,int in4){ // для 3 сравнений
    myequals(in1,in2,in3);
    if (jbtn[in4].getText()==" "){
            swap(in1,in4);
            //vin();
            vin2();
        }
    }
   
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable(){
    public void run(){
        
    new JTag2();
    }
    });
        
    }
    
}
/*class WinFrame extends JFrame{
String str;
JButton restart;
JButton exit;
WinFrame( JButton res,JButton ex){
super();
restart=res;
exit=ex;
C:\Users\Vlad\Documents\NetBeansProjects1\JTag2\src\jtag2
}
}*/

