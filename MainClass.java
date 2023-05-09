package oop;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import uk.ac.leedsbeckett.oop.LBUGraphics;

public class MainClass
{
		GraphicsSystem graphicsSystem = new GraphicsSystem();
				
        public static void main(String[] args)
        {
                new MainClass(); 
        }

        public MainClass()
        {
                JFrame MainFrame = new JFrame();                
                MainFrame.setLayout(new FlowLayout());  
                MainFrame.add(graphicsSystem);                                   
                MainFrame.pack();                                               
                MainFrame.setVisible(true);    
                
               // graphicsSystem.about();
                graphicsSystem.penDown();
                graphicsSystem.clear();

        }        
       
}
