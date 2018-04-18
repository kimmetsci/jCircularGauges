package com.github.kkieffer.jcirculargauges;


import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Demo of the Gauge
 * 
 * @author kkieffer
 */
public class JArtificialHorizonDemo {
     
    public static void main(String[] args) throws InterruptedException {

	JFrame myFrame = new JFrame("Artifical Horizon Demo");
	
	Container thePane = myFrame.getContentPane();
        
        
        JArtificialHorizonGauge ah = new JArtificialHorizonGauge(1.5);  //slightly more pitch sensitivity
        ah.setColors(new Color(0, 50, 200), Color.green, null);  //try some custom colors
        
	thePane.add(ah);

	myFrame.pack();
        myFrame.setVisible(true);
        
        
        //Now, cycle the pitch and roll for the demo
        double maxRoll = 35;
        double maxPitch = 40;
        double newRoll = 0;
        double newPitch = 0;
        boolean rollRight = true;
        boolean pitchUp = true;
        while (true) {
  
            final double roll = newRoll;
            final double pitch = newPitch;
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    ah.setAttitude(roll, pitch);
                }

            });            
            Thread.sleep(100);

            if (rollRight) {
                newRoll+=1.0;
                if (newRoll > maxRoll)
                    rollRight = false;

            }   
            else {
                
                newRoll-=1.0;
                if (newRoll < - maxRoll)
                    rollRight = true;
               
            }
            
            if (pitchUp) {
                newPitch+=.1;
                if (newPitch > maxPitch)
                    pitchUp = false;

            }   
            else {
                
                newPitch -=.1;
                if (newPitch < -maxPitch)
                    pitchUp = true;
               
            }

        }
 
    }
    
 
    
}
