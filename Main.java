package pricewatcher;

/*

Created by Edgar Escobedo and Jorge Quinonez
HW2 2-D Graphics
Advanced Objects 3331
Dr. Cheon
03/06/2019


 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


import pricewatcher.ConsoleUI;
import pricewatcher.Item;
/**
* A dialog for tracking the price of an item.
*
* @author Yoonsik Cheon
*/
@SuppressWarnings("serial")
public class Main extends JFrame {

    /** Default dimension of the dialog. */
    private final static Dimension DEFAULT_SIZE = new Dimension(600, 350);
      
    /** Special panel to display the watched item. */
    private ItemView itemView;
      
    /** Message bar to display various messages. */
    private JLabel msgBar = new JLabel(" ");

    /** Create a new dialog. */
    public Main() {
    	this(DEFAULT_SIZE);
    }
    
    /** Create a new dialog of the given screen dimension. */
    public Main(Dimension dim) {
        super("Price Watcher");
        setSize(dim);    
        configureUI();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        showMessage("Welcome to Price Watcher!");
        
    }
    public URL getCodeBase() {
        return getClass().getResource("/");
    }
    public void play(URL url) {
        try {
            Clip clip;
            (clip = AudioSystem.getClip()).open(AudioSystem.getAudioInputStream(this.getClass().getResource("/sound/yes-2.wav")));
            clip.start();
    	} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
    		e.printStackTrace();
    	}
    }
    /** Callback to be invoked when the refresh button is clicked. 
     * Find the current price of the watched item and display it 
     * along with a percentage price change. */
    private void refreshButtonClicked(ActionEvent event) {
    	 
    	ItemView item = new ItemView();
    	PriceFinder find = new PriceFinder();
    	item.item.setCurrPrice(find);
    	configureUI();
    	if(item.item.currPrice < item.item.initPrice) {
    		play(getCodeBase(), "sound/yes-2.wav");
    	}
    	showMessage("Refresh clicked!");
    }
    public void play(URL url, String name) {
    	try {
            play(new URL(url, name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void viewPageClicked(ActionEvent event) {    	
    	Item item = new Item();
        String URL = item.url;
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(new java.net.URI(URL));
        } catch (IOException | URISyntaxException e) {
            System.out.println("The URL for the item does not work");
        }
        showMessage("View URL clicked!");
    }    
    /** Configure UI. */
    private void configureUI() {
        setLayout(new BorderLayout());
        JPanel control = makeControlPanel();
        control.setBorder(BorderFactory.createEmptyBorder(10,16,0,16)); 
        add(control, BorderLayout.NORTH);
        JPanel board = new JPanel();
        board.setBorder(BorderFactory.createCompoundBorder(
        		BorderFactory.createEmptyBorder(10,16,0,16),
        		BorderFactory.createLineBorder(Color.magenta)));
        board.setLayout(new GridLayout(1,1));
        itemView = new ItemView();
        board.add(itemView);
        add(board, BorderLayout.CENTER);
        msgBar.setBorder(BorderFactory.createEmptyBorder(10,16,10,0));
        add(msgBar, BorderLayout.SOUTH);
    }
      
    /** Create a control panel consisting of a refresh button. */
    private JPanel makeControlPanel() {
    	JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
    	JButton refreshButton = new JButton("Refresh");
    	JButton webButton = new JButton("Web");
    	refreshButton.setFocusPainted(false);
    	webButton.setFocusPainted(false);
        refreshButton.addActionListener(this::refreshButtonClicked);
        webButton.addActionListener(this::viewPageClicked);
        panel.add(refreshButton);
        panel.add(webButton);
        return panel;
    }

    /** Show briefly the given string in the message bar. */
    private void showMessage(String msg) {
        msgBar.setText(msg);
        new Thread(() -> {
        	try {
				Thread.sleep(5 * 1000); // 5 seconds
			} catch (InterruptedException e) {
			}
        	if (msg.equals(msgBar.getText())) {
        		SwingUtilities.invokeLater(() -> msgBar.setText(" "));
        	}
        }).start();
    }
    public static void main(String[] args) {
        new Main();
    }

}
