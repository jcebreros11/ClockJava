import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@SuppressWarnings("serial")
public class Clock extends JFrame {
	
	//Time Display
	private String timeStr = "";
	
	//Formatter
	private SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm:ss a");
	
	//Label
	private JLabel timeLabel; 
	

	

	
		
	Clock(){
		//Create the clock frame 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Clock");
		this.setLayout(new FlowLayout());
		this.setSize(400,100);
		this.setResizable(true);
		
		
		//Initialize the time label 
		timeLabel = new JLabel(); 
		timeLabel.setForeground(new Color(0,114,0));
		timeLabel.setBackground(Color.black);
		timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));
		timeLabel.setOpaque(true);

		

		timeLabel.setText(this.timeStr);
		
		this.add(timeLabel);
		this.setVisible(true);
		setTime();
	}
	
	
	public void setTime() {
		while(true) {
			try {
				Date date = Calendar.getInstance().getTime();	
				this.timeStr = this.timeFormatter.format(date);
				this.timeLabel.setText(this.timeStr);
				
				//Want to update the clock every 1 second
				Thread.sleep(1000);
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
