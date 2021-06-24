package lab4;
//продемонстрировать простое главное меню
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
		//создать новый контейнер типа JFrame
		JFrame jfrm = new JFrame("Menu Demo");
		jfrm.setTitle("DialogTest");
		//демонстрация меню
		//указать диспетчер поточной компоновки типа FlowLayout
		jfrm.setLayout(new FlowLayout());
		//задать исходные размеры фрейма
		size = 500;
		jfrm.setSize(size, size+60);
		jfrm.setResizable(false);
		//завершить прикладную программу, как только
		//пользователь закроет ее окно
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//создать метку для отображения результатов выбора из меню
		jlab = new JLabel();
		jfrm.add(new GamePanel(), BorderLayout.CENTER);
		//jfrm.setPreferredSize(new Dimension(100, 100));
		//jfrm.setBackground(Color.YELLOW);
		
		
		//создать строку меню
		JMenuBar jmb = new JMenuBar();
		//создать меню File
		JMenu jmFile = new JMenu("File"); //Файл
		//задаем мнемонику
		jmFile.setMnemonic(KeyEvent.VK_F);
		JMenuItem jmiNew = new JMenuItem("New",  KeyEvent.VK_N); //Новая игра
		//задаем акселератор
		jmiNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		JMenuItem jmiExit = new JMenuItem("Exit",  KeyEvent.VK_E); //Выход
		//задаем акселератор
		jmiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		jmFile.add(jmiNew);
		jmFile.addSeparator();
		jmFile.add(jmiExit);
		jmb.add(jmFile);

		
		
		JMenuItem aboutItem = new JMenuItem("About");
		//задать мнемонику
		aboutItem.setMnemonic(KeyEvent.VK_A);
		aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
				{
					if (dialog == null) //первый раз
					dialog = new AboutDialog(MyWindowApp.this);
					dialog.setVisible(true);
				}
			});
		jmb.add(aboutItem);
		//при активизации пункта Exit программа завершается
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event)
		{
		System.exit(0);
		}
		});

		//ввести все выбираемые меню в строку меню
		jmb.add(aboutItem);
		
		//ввести приемники действий от пунктов меню
		jmiNew.addActionListener(this);
		jmiExit.addActionListener(this);
		aboutItem.addActionListener(this);

		//ввести метку на панели содержимого
		jfrm.add(jlab);
		//ввести строку меню во фрейм
		jfrm.setJMenuBar(jmb);
		//отобразить фрейм
		jfrm.setVisible(true);

	}

//обработать события действия от пунктов меню
public void actionPerformed(ActionEvent ae) {
	//получить команду действия из выбранного меню
	String comStr = ae.getActionCommand();
	//выйти из программы, если пользователь выберет пункт меню Exit
	if(comStr.equals("Exit"))
	System.exit(0);
	//в противном случае отобразить результат выбора из меню
	jlab.setText(comStr + " Selected"); //Выбрано указанное
	
	

}

public static void main(String[] args) {
    //SwingUtilities.invokeLater(() -> {
		//создать фрейм
		
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


	
