import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CanvasJuego extends Canvas implements KeyListener, MouseMotionListener, MouseListener
{
	
	private int rutaX[] = { 210, 220, 230, 240, 250, 240, 230, 220, 210, 200, 190, 180, 170, 160, 150, 140, 130, 120, 110, 100, 90, 80,    80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210,   80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210};
	private int rutaY[] = {	  0,  10,  20,  30,  40,  40,  40,  40,  40,  40,  40,  40,  40,  40,  40,  40,  40,  40,  40,  40, 40, 40,    50, 60, 60, 60, 60, 70, 70, 70, 70, 80, 80, 80, 80, 90,  	         50, 60,  60,  60,  60,  70,  70,  70,  70,  80,  80,  80,  80,  90};


	//Un margen de error de una posicion a la izda y otra a la derecha

							//   0				  90  100	  			190 200				  290
	private int matriz[][] = {  {0,0,0,0,0,0,0,0,0,0,  0,0,0,0,0,0,0,0,0,0,  1,1,1,0,0,0,0,0,0,0},	
								{0,0,0,0,0,0,0,0,0,0,  0,0,0,0,0,0,0,0,0,0,  0,1,1,1,0,0,0,0,0,0},
								{0,0,0,0,0,0,0,0,0,0,  0,0,0,0,0,0,0,0,0,0,  0,0,1,1,1,0,0,0,0,0},
								{0,0,0,0,0,0,0,0,1,1,  1,1,1,1,1,1,1,1,1,1,  1,1,1,1,1,1,0,0,0,0},
								{0,0,0,0,0,0,0,0,1,1,  1,1,1,1,1,1,1,1,1,1,  1,1,1,1,1,1,1,0,0,0},
								{0,0,0,0,0,0,0,1,1,1,  1,1,1,1,1,1,1,1,1,1,  1,1,1,1,1,1,1,0,0,0},
							//50
								{0,0,0,0,0,0,0,0,1,1,  1,1,1,1,0,0,0,0,0,0,  0,0,0,0,0,0,0,0,0,0},
								{0,0,0,0,0,0,0,0,0,0,  0,0,1,1,1,1,1,1,0,0,  0,0,0,0,0,0,0,0,0,0},
								{0,0,0,0,0,0,0,0,0,0,  0,0,0,1,1,1,1,1,1,1,  1,1,0,0,0,0,0,0,0,0},																
								{0,0,0,0,0,0,0,0,0,0,  0,0,0,0,0,0,0,1,1,1,  1,1,1,0,0,0,0,0,0,0} };

	private int vidas = 5;

	private Image imgFondo;  
	private Image imgPersonaje;
	private Image imgPersonajeOriginal;
	private Image imgPersonajeKO;
	  
	//Desfase entre las x,y del raton y del personaje
	private Point offset = new Point();
	  
	//Posicion personaje
	private int x = 210;
	private int y = 0;
	private int salto = 10;
	  
	private boolean comienzo = false;
	private boolean finDelJuego = false;
	  
	private boolean arrastrandoRaton = false;
	  
		
	public CanvasJuego (Image _fondo, Image _personaje, Image _personajeKO) 
	{
		super();
	
	    imgFondo = _fondo;
	    imgPersonaje = _personaje;
	    imgPersonajeOriginal = _personaje;
	    imgPersonajeKO = _personajeKO;
	    
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
	    this.addKeyListener(this);
	}
	
	
	public Dimension getPreferredSize () 
	{
		return new Dimension(imgFondo.getWidth(this), imgFondo.getHeight(this));
	}
	 
	public void paint (Graphics g) 
	{
		g.drawImage(imgFondo , 0, 0, this);
		
		if(vidas!=0)
			g.drawImage(imgPersonaje , x, y, this);
		else
			g.drawImage(imgPersonajeKO , x, y, this);		
	
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 18));
		g.drawString(MiJuego.TITULO + " -  Vidas: " + vidas, 10 , imgFondo.getHeight(this)-10);	
					
		if(!comienzo)
		{
			g.setColor(Color.BLUE);
			g.setFont(new Font("Arial", Font.BOLD, 24));
			g.drawString("Pulse para empezar", imgFondo.getWidth(this)/2 - 100, imgFondo.getHeight(this)/2);
			g.setFont(new Font("Arial", Font.BOLD, 16));
			g.drawString("Teclas de cursor para bajar", imgFondo.getWidth(this)/2 - 90, imgFondo.getHeight(this)/2 + 25);
		}
		
		if(vidas==0)
		{
			g.setColor(Color.RED);
			g.setFont(new Font("Arial", Font.BOLD, 24));
			g.drawString("Game Over", imgFondo.getWidth(this)/2 - 100, imgFondo.getHeight(this)/2);			
			this.removeMouseMotionListener(this);
			this.removeMouseListener(this);
	    	this.removeKeyListener(this);
		}

		if(finDelJuego)
		{
			g.setColor(Color.GREEN);
			g.setFont(new Font("Arial", Font.BOLD, 24));
			g.drawString("Llegaste a la meta!", imgFondo.getWidth(this)/2 - 100, imgFondo.getHeight(this)/2);			
			this.removeMouseMotionListener(this);
			this.removeMouseListener(this);
	    	this.removeKeyListener(this);		
		}		


	}
	
	
	/* Por lo general limpia la pantalla nates de invocar al paint */
	public void update (Graphics g) 
	{
		paint(g);
	}
	
	public void keyPressed(KeyEvent e)
	{
		int oldX = x;
		int oldY = y;
		
		
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT)		
		{
			if(x>=salto)
				x -= salto;
				
			//this.repaint();	
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT)		
		{
			if(x<this.getWidth()-imgPersonaje.getWidth(this))
				x += salto;
			//this.repaint();	
		}		
		else if(e.getKeyCode()==KeyEvent.VK_UP)		
		{
			if(y>=salto)
				y -= salto;
			//this.repaint();	
		}				
		else if(e.getKeyCode()==KeyEvent.VK_DOWN)		
		{
			if(y<this.getHeight()-imgPersonaje.getHeight(this))
				y += salto;
			//this.repaint();	
		}	
		
		
		//[filas][cols]
		if(y/salto<matriz.length)
		{
			if(matriz[(int)y/salto][(int)x/salto]==0)
			{
				x = oldX;
				y = oldY;			
				vidas--;
				if(vidas==0)
					this.repaint();		
				else
				{
					this.repaint(210, 290, 230, 310 );		
					
					ActionListener tarea = new ActionListener() 
					{
	      				public void actionPerformed(ActionEvent evt) 
	      				{
	      					imgPersonaje = imgPersonajeOriginal;
							CanvasJuego.this.repaint(x, y, imgPersonaje.getWidth(CanvasJuego.this), imgPersonaje.getHeight(CanvasJuego.this));
	      				}
	  				};
	  				imgPersonaje = imgPersonajeKO;

	  				new Timer(350, tarea).start();				
					this.repaint(x, y, imgPersonajeKO.getWidth(this), imgPersonajeKO.getHeight(this));
				}
					
			}
			
			if(x!=oldX || y!=oldY)					
			{
			    this.repaint(oldX, oldY, imgPersonaje.getWidth(this), imgPersonaje.getHeight(this));
			    this.repaint(x, y, imgPersonaje.getWidth(this), imgPersonaje.getHeight(this));
			}
		}
		else
		{
			finDelJuego = true;	
			this.repaint();		
		}
		
	}
	
	
	public void keyTyped(KeyEvent e)
	{
			
	}
		
	public void keyReleased(KeyEvent e)
	{
			
	}
	
	//Definido en MouseMotionListner
	public void mouseDragged (MouseEvent e) 
	{
		if(arrastrandoRaton)
	 	{
		    int oldX = x;
		    int oldY = y;
		    	
		    
		    x = e.getX()-(int)offset.getX();
		    y = e.getY()-(int)offset.getY();
		    	
		    this.repaint(oldX, oldY, imgPersonaje.getWidth(this), imgPersonaje.getHeight(this));
		    this.repaint(x, y, imgPersonaje.getWidth(this), imgPersonaje.getHeight(this));
		}
	}
	
	
	//Definido en MouseMotionListner
	public void mouseMoved (MouseEvent e) 
	{
			
	}
	
	public void mousePressed (MouseEvent e) 
	{
	    if ((e.getX() > x ) && (e.getX() <= imgPersonaje.getWidth(this)+x) && (e.getY() > y) && (e.getY() <= imgPersonaje.getHeight(this)+y)) 
	    {
			arrastrandoRaton = true;
			offset.setLocation(e.getX()-x, e.getY()-y);
	    }
	}
	
	public void mouseClicked (MouseEvent e) 
	{
		comienzo = true;
		this.repaint();
	}
	
	public void mouseReleased (MouseEvent e) 
	{
	    arrastrandoRaton = false;
	}
	
	public void mouseExited (MouseEvent e) 
	{
	 	
	}
	
	public void mouseEntered (MouseEvent e) 
	{
		
	}	
}
