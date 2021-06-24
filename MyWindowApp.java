package lab4;
//������������������ ������� ������� ����
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class MyWindowApp extends JFrame implements ActionListener  {
	JLabel jlab;
	int size;
	MyWindowApp() {
		//������� ����� ��������� ���� JFrame
		JFrame jfrm = new JFrame("Menu Demo");
		jfrm.setTitle("DialogTest");
		//������������ ����
		//������� ��������� �������� ���������� ���� FlowLayout
		jfrm.setLayout(new FlowLayout());
		//������ �������� ������� ������
		size = 500;
		jfrm.setSize(size, size+60);
		jfrm.setResizable(false);
		//��������� ���������� ���������, ��� ������
		//������������ ������� �� ����
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//������� ����� ��� ����������� ����������� ������ �� ����
		jlab = new JLabel();
		jfrm.add(new GamePanel(), BorderLayout.CENTER);
		//jfrm.setPreferredSize(new Dimension(100, 100));
		//jfrm.setBackground(Color.YELLOW);
		
		
		//������� ������ ����
		JMenuBar jmb = new JMenuBar();
		//������� ���� File
		JMenu jmFile = new JMenu("File"); //����
		//������ ���������
		jmFile.setMnemonic(KeyEvent.VK_F);
		JMenuItem jmiNew = new JMenuItem("New",  KeyEvent.VK_N); //����� ����
		//������ �����������
		jmiNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		JMenuItem jmiExit = new JMenuItem("Exit",  KeyEvent.VK_E); //�����
		//������ �����������
		jmiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		jmFile.add(jmiNew);
		jmFile.addSeparator();
		jmFile.add(jmiExit);
		jmb.add(jmFile);

		
		
		JMenuItem aboutItem = new JMenuItem("About");
		//������ ���������
		aboutItem.setMnemonic(KeyEvent.VK_A);
		aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
				{
					if (dialog == null) //������ ���
					dialog = new AboutDialog(MyWindowApp.this);
					dialog.setVisible(true);
				}
			});
		jmb.add(aboutItem);
		//��� ����������� ������ Exit ��������� �����������
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event)
		{
		System.exit(0);
		}
		});

		//������ ��� ���������� ���� � ������ ����
		jmb.add(aboutItem);
		
		//������ ��������� �������� �� ������� ����
		jmiNew.addActionListener(this);
		jmiExit.addActionListener(this);
		aboutItem.addActionListener(this);

		//������ ����� �� ������ �����������
		jfrm.add(jlab);
		//������ ������ ���� �� �����
		jfrm.setJMenuBar(jmb);
		//���������� �����
		jfrm.setVisible(true);

	}

//���������� ������� �������� �� ������� ����
public void actionPerformed(ActionEvent ae) {
	//�������� ������� �������� �� ���������� ����
	String comStr = ae.getActionCommand();
	//����� �� ���������, ���� ������������ ������� ����� ���� Exit
	if(comStr.equals("Exit"))
	System.exit(0);
	//� ��������� ������ ���������� ��������� ������ �� ����
	jlab.setText(comStr + " Selected"); //������� ���������
	
	

}

public static void main(String[] args) {
    //SwingUtilities.invokeLater(() -> {
		//������� �����
		
		MyWindowApp frame = new MyWindowApp();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Game of Fifteen");
		frame.add(new GamePanel(), BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
	    //frame.setVisible(true);
		
	
    //});
}



private AboutDialog dialog;
}


	
