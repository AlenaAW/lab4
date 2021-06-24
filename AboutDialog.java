package lab4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AboutDialog extends JDialog {
	public AboutDialog(JFrame owner) {
		super(owner, "About DialogTest", true);
		//метка, содержащая HTML-форматирование, выравнивается по центру
		add(new JLabel("<html><hl><i>Сидоренко Алёна P3170 2021</i></hl></html>"), BorderLayout.CENTER);
		//при активизации кнопки OK диалоговое окно закрывается
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event)
			{
				setVisible(false);
			}
		});
		JPanel panel = new JPanel();
		panel.add(ok);
		add(panel, BorderLayout.SOUTH);
		setSize (250, 150);
}
}
