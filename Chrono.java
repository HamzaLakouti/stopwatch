import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Chrono implements ActionListener{

	JFrame frame =new JFrame();
	JButton startButton = new JButton("START");
	//JButton stopButton = new JButton();
	JButton resetButton = new JButton("RESET");
	JLabel timeLabel = new JLabel();
	int elapsedTime=0;
	int seconds=0;
	int minutes=0;
	int hours=0;
	boolean started= false;
	String secondsHolder= String.format("%02d", seconds);
	String minutesHolder= String.format("%02d", minutes);
	String hoursHolder= String.format("%02d", hours);
	
	Timer timer= new Timer(1000, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			elapsedTime+=1000;
			hours=(elapsedTime/3600000);
			minutes=(elapsedTime/60000)%60;
			seconds=(elapsedTime/1000)%60;
			secondsHolder= String.format("%02d", seconds);
			minutesHolder= String.format("%02d", minutes);
			hoursHolder= String.format("%02d", hours);
			timeLabel.setText(hoursHolder+":"+minutesHolder+":"+secondsHolder);
		}
	});
	
	Chrono(){
		
		timeLabel.setText(secondsHolder+":"+minutesHolder+":"+hoursHolder);
		timeLabel.setBounds(100, 50, 250, 50);
		timeLabel.setFont(new Font("Verdana",Font.BOLD,25));
		timeLabel.setForeground(Color.blue);
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		startButton.setBounds(100, 100, 125, 25);
		startButton.setFont(new Font("MV Boli",Font.BOLD,15));
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		resetButton.setBounds(225, 100, 125, 25);
		resetButton.setFont(new Font("MV Boli",Font.BOLD,15));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		frame.add(resetButton);
		frame.add(startButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 200);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setTitle("Waaa jriiiiiiii");
		
		frame.add(timeLabel);
		
		frame.setVisible(true);		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==startButton) {
			
			if(started== false) {
				started= true;
				startButton.setText("STOP");
				start();
			}
			else {
				started= false;
				startButton.setText("START");
				stop();
			}
		}
		if(e.getSource()==resetButton) {
			started=false;
			startButton.setText("START");
			reset();
		}
	}
	
	void start() {
		timer.start();
	}
	
	void stop() {
		timer.stop();
	}
	
	void reset() {
		timer.stop();
		elapsedTime=0;hours=0;minutes=0;seconds=0;
		secondsHolder= String.format("%02d", seconds);
		minutesHolder= String.format("%02d", minutes);
		hoursHolder= String.format("%02d", hours);
		timeLabel.setText(hoursHolder+":"+minutesHolder+":"+secondsHolder);
	}

}