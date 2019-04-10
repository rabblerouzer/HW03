package pricewatcher;

/*

Created by Edgar Escobedo and Jorge Quinonez
HW2 2-D Graphics
Advanced Objects 3331
Dr. Cheon
03/06/2019


 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/** A special panel to display the detail of an item. */

@SuppressWarnings("serial")
public class ItemView extends JPanel {
    
	public static Item item = new Item();
	/** Interface to notify a click on the view page icon. */
	public interface ClickListener {
		
		/** Callback to be invoked when the view page icon is clicked. */
		void clicked();
	}
	
	/** Directory for image files: src/image in Eclipse. */
	private final static String IMAGE_DIR = "/EdgarEscobedo/rabbit.jpg";
        
	/** View-page clicking listener. */
    private ClickListener listener;
    
    /** Create a new instance. */
    public ItemView() {
    	setPreferredSize(new Dimension(100, 160));
        setBackground(Color.BLACK);
        addMouseListener(new MouseAdapter() { 
            public void mouseClicked(MouseEvent e) {
            	if (isViewPageClicked(e.getX(), e.getY()) && listener != null) {
            		listener.clicked();
            	}
            }
        });
    }
        
    /** Set the view-page click listener. */
    public void setClickListener(ClickListener listener) {
    	this.listener = listener;
    }
    
    /** Overridden here to display the details of the item. */
    @Override
	public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        g.setColor(Color.WHITE);
        int x = 20, y = 30;
        
        g.setColor(Color.WHITE);
        y += 20;
        g.drawString("Name: ", x, y);
        paint(g, item.name, 100, 50);
        
        y += 20;
        g.drawString("URL: ", x, y);
        paint(g, item.url, 100, 70);
        
        y += 20;
        g.drawString("Price: ", x, y);
        g.setColor(decideColorPrice(item));
        paint(g, "$"+item.currentPrice, 100, 90);
        y += 20;
        g.setColor(Color.WHITE);
        g.drawString("Change: ", x, y);
        g.setColor(decideColorChange(item));
        //String change = item.change + "%";
        paint(g, item.change+"%" , 100, 110);
        g.setColor(Color.WHITE);
        y += 20;
        g.drawString("Date: ", x, y);
        paint(g, item.date+" ($"+item.initialPrice+")", 100, 130);
    }
    public void paint(Graphics g, String words, int x, int y) {
    	g.drawString(words, x, y);
    	
    }
    
    //If the current price is greater than the initial, the color will be shown Red,
    //if the current price is lower it will be blue, if neither, it will be white
    public Color decideColorPrice(Item item) {
    	Color color = Color.WHITE;
    	if(item.currPrice == item.initPrice) {
    		color = Color.WHITE;
    	}else if(item.currPrice > item.initPrice) {
    		color = Color.RED;
    	}else {
    		color = Color.BLUE;
    	}
		return color;
    }
    public Color decideColorChange(Item item) {
    	Color color = Color.WHITE;
    	if(item.currPrice == item.initPrice) {
    		color = Color.WHITE;
    	}else if(item.currPrice > item.initPrice) {
    		color = Color.RED;
    	}else {
    		color = Color.GREEN;
    	}
		return color;
    }
    
    private boolean isViewPageClicked(int x, int y) {
    	return new Rectangle(20, 20, 40, 20).contains(x,  y);
    }
    
        
    /** Return the image stored in the given file. */
    public Image getImage(String file) {
        try {
        	URL url = new URL(getClass().getResource(IMAGE_DIR), file);
            return ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
