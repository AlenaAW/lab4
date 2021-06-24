package lab4;

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
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GamePanel extends JPanel{
	//размер поля
	private int n;
	int [] l = new int [16];
	int im;//позиция пустой клетки в массиве
	boolean right;
	
	
	public GamePanel ()
	{
		n=15;
		im=15;
		setPreferredSize(new Dimension(n*33, n*33));
		//распределяем фишки, 15 - пустота, поле имеет вид:
		// 0 | 1 | 2 | 3
		// 4 | 5 | 6 | 7
		// 8 | 9 | 10| 11
		// 12| 13| 14| 15
		for (int i=0;i<16;i++)
		{
			l[i]=i;
		}
		
		setBackground(Color.YELLOW);
		
		newGame();
		
		addMouseListener(new MouseAdapter() 
		{
			public void mousePressed(MouseEvent e) 
			{
				if (right)
				{
					newGame();
				}
				else
				{
					int num = getPos(e.getX(),e.getY());
					int xi=num%4;
					int c3;
					if ((num==im-1&&xi!=0)||
							(num==im+1&&xi!=4)||
							(num==im-4&&im>3)||
							(num==im+4&&im<12))
					{
						c3=l[im];
		    			l[im]=l[num];
		    			l[num]=c3;
		    			num=im;
					}
					right=check();
				}
				repaint();
			}
		});
		
		
	}
	
	public void newGame ()
	{
		shuffle();
		right=false;
	}
	
	//проверка решено ли
	private boolean check () {
		for (int i=0;i<15;i++)
		{
			if (l[i]!=i)
				return false;
		}
		return true;
	}
	
	
	private int getPos(int x, int y) {
		int num = x/(8*n)+4*y/(8*n);
		return num;
	}
	
	//перемешиваем
	public void shuffle()
	{
			int i, j, p;
			Random r = new Random();
			for(i = 0; i < 14; i++)			
			{
				j=r.nextInt(15);
				p=l[j];
				l[j]=l[i];
				l[i]=p;
			}						
	}
	
	
	
	private void drawDices(Graphics2D g) {
		
		int x,y;
		
		for (int i=0; i<16; i++)
		{
			if (l[i]!=15)
			{
				//угол новой кости, координаты
				x=n*(l[i]%4*8);
				y=n*(l[i]/4*8);
				
				//рисуем кость
				g.drawRect(x, y, 8*n, 8*n);
				
				//настраиваем шрифт
				Font myFont = new Font ("Courier New", 1, 5*n);
				g.setFont(myFont);
				
				//переводим номер в стринг
				String text = Integer.toString(l[i]);
				
				//определяем ширину надписи
				FontMetrics metrics = g.getFontMetrics(myFont);
				int m = metrics.stringWidth(text);
				
				//рисуем цифру
				g.drawString(text,  x+4*n-m/2, y+11*n/2);
			}
			
			
		}
	}
	
	protected void paintComponent(Graphics g) 
	{
	    super.paintComponent(g);
	    Graphics2D g2D = (Graphics2D) g;
	    g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    drawDices(g2D);
	}
	
	
	}

