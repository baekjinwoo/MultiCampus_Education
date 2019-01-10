package basic14;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class WindowsBuilder01 extends JFrame {
	JLabel lblNewLabel;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowsBuilder01 frame = new WindowsBuilder01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowsBuilder01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); //absolute layout //내맘대로 디자인이 가능
		
		JButton btnDddd = new JButton("\uB20C\uB7EC\uBD10"); //눌러봐 한글코드
		btnDddd.setForeground(Color.RED);
		btnDddd.setFont(new Font("궁서체", Font.ITALIC, 12));
		btnDddd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//객체.속성=값
				//lblNewLabel을 쓰고싶으면 저 위에 전역변수로서 선언해라.
				lblNewLabel.setText("안녕하세요"); //버튼누르면 안녕~
				
			}
		});
		btnDddd.setBackground(Color.GREEN);
		btnDddd.setBounds(12, 208, 410, 44);
		contentPane.add(btnDddd);
		
		//JLabel lblNewLabel = new JLabel(""); 
		lblNewLabel=new JLabel("");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(12, 166, 410, 32);
		contentPane.add(lblNewLabel);
	}
}
