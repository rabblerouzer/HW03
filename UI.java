package pricewatcher;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class UI {{
	//Create the menu bar.
	JMenuBar menuBar = new JMenuBar();

	//Build the first menu.
	JMenu menu = new JMenu("MAIN");
	menu.setMnemonic(KeyEvent.VK_M);
	menu.getAccessibleContext().setAccessibleDescription("Main menu");
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("Check", KeyEvent.VK_C);
		//menuItem.setIcon()));
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("Check the price");
		//menuItem.addActionListener(…);
		menu.add(menuItem);

}}
