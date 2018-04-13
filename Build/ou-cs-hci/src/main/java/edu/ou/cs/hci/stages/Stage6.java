/* CS 3053: Human Computer Interaction
 * Team 5: Reqing Crew
 * Lilia Williams, Cody Poteet, Daniel Schon, Robert Monaco, and Daniel Chambers
 * Spring 2018
 *
 * Author: Lilia Williams
 * Individual Project 06 - Menu Design
 */

package edu.ou.cs.hci.stages;

import edu.ou.cs.hci.resources.Resources;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.util.stream.Collectors;

public final class Stage6
{
	// colors used in the UI
	private static Color menuBackgroundColor = new Color(236, 238, 243);

	// dimensions in the UI
	private static Dimension sideMenuDimension = new Dimension(125,600);
	private static int iconHeight = 21;
	private static int iconWidth = 21;

	public static Color STORMY_SKIES = new Color(0xE2EEFF);
	public static Color ROBIN_EGG = new Color(0xB1E0EF);
	public static Color GRANNY_SMITH = new Color(0xDFF8DC);
	public static Color ICEBERG = new Color(0x71A6D2);
	public static Color UCLA_GOLD = new Color(0xFFB300);

	// title of the application
	private static String title;

	/**
	 * Main method that creates and displays the frames
	 *
	 * @param args
	 */
	public static void main(String[] args)
	{
		title = "eReader";

		// creates the two frames
		JFrame	frame = new JFrame(title);

		// creates the panels to be added to the frame
		JPanel	sideMenu = new JPanel();
		JPanel	centerPanel = new BooksPanel();
		centerPanel.setBackground(ICEBERG);

		// creates the border used in our frame
		final Border loweredBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

		// creates an action listener that prints the button's name and value upon being clicked
		ActionListener buttonPressed = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String buttonName = ((AbstractButton) e.getSource()).getText();
				System.out.print(buttonName + " was pressed. ");

				if(buttonName.equals("Import Library")){
					System.out.print("This button saves a user’s library data \n(title, author, publication date, " +
							"etc. of each book) as a .csv file.\n\n");
				}
				else if(buttonName.equals("Export Library")){
					System.out.print("This button will load a .csv file and set the user’s library data.\n\n");
				}
				else if(buttonName.equals("Open")){
					System.out.print("This button will open a .epub file that the \nuser selects from the finder window.\n\n");
				}
				else if(buttonName.equals("Save")){
					System.out.print("This button will save all markup (pen, highlight,\neraser, and comment) on the " +
							"current text and will display it when the current text \nis opened again.\n\n");
				}
				else if(buttonName.equals("Print")){
					System.out.print("This button will print the current page \nof text displayed on the screen.\n\n");
				}
				else if(buttonName.equals("Zoom In")){
					System.out.print("This button will zoom in on the center\nof the home screen that displays the " +
							"book text so that text and images in a book appear larger.\n\n");
				}
				else if(buttonName.equals("Zoom Out")){
					System.out.print("This button will zoom out on the center\nof the home screen that displays the " +
							"book text so that text and images in a book appear smaller.\n\n");
				}
				else if(buttonName.equals("Zoom 100%")){
					System.out.print("This button will reset this window to its default size.\n\n");
				}
				else if(buttonName.equals("Pen")){
					System.out.print("This button will turn the user’s cursor\ninto a tool to write on and markup texts.\n\n");
				}
				else if(buttonName.equals("Highlight")){
					System.out.print("This button will will turn the cursor\ninto a highlighter to highlight text " +
							"within the book.\n\n");
				}
				else if(buttonName.equals("Eraser")){
					System.out.print("This button will turn the cursor into an\neraser to remove marks made from " +
							"Eraser and Highlight.\n\n");
				}
				else if(buttonName.equals("Comment")){
					System.out.print("This button will allow a user to type a comment on a selected block of text.\n\n");
				}
				else if(buttonName.equals("Bookmark")){
					System.out.print("This button will save which page the user is on to come back to later.\n\n");
				}
				else if(buttonName.equals("Web Help")){
					System.out.print("This button will link to a web page containing help information.\n\n");
				}
				else
					System.out.println();
			}
		};

		// creates the menu bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(ROBIN_EGG);

		// builds the file menu
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(fileMenu);
		fileMenu.addActionListener(buttonPressed);

		// creates JMenuItems for our fileMenu
		JMenuItem menuItem1 = new JMenuItem("Import Library",
				KeyEvent.VK_T);
		menuItem1.setBackground(STORMY_SKIES);
		fileMenu.add(menuItem1);
		menuItem1.addActionListener(buttonPressed);

		JMenuItem menuItem2 = new JMenuItem("Export Library",
				KeyEvent.VK_T);
		menuItem2.setBackground(STORMY_SKIES);
		fileMenu.add(menuItem2);
		menuItem2.addActionListener(buttonPressed);

		JMenuItem menuItem3 = new JMenuItem("Open",
				KeyEvent.VK_T);
		menuItem3.setBackground(STORMY_SKIES);
		fileMenu.add(menuItem3);
		menuItem3.addActionListener(buttonPressed);

		JMenuItem menuItem4 = new JMenuItem("Save",
				KeyEvent.VK_T);
		menuItem4.setBackground(STORMY_SKIES);
		fileMenu.add(menuItem4);
		menuItem4.addActionListener(buttonPressed);

		// adds a separator to the file menu
		fileMenu.addSeparator();

		JMenuItem menuItem5 = new JMenuItem("Print",
				KeyEvent.VK_T);
		menuItem5.setBackground(STORMY_SKIES);
		fileMenu.add(menuItem5);
		menuItem5.addActionListener(buttonPressed);

		JMenuItem quitMenuItem = new JMenuItem("Quit",
				KeyEvent.VK_T);
		quitMenuItem.setBackground(STORMY_SKIES);
		fileMenu.add(quitMenuItem);

		// builds the edit menu
		JMenu editMenu = new JMenu("Edit");
		editMenu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(editMenu);

		// creates JMenuItems for our edit menu
		JMenuItem menuItem6 = new JMenuItem("Cut (Ctrl+x)",
				KeyEvent.VK_T);
		menuItem6.setBackground(STORMY_SKIES);
		editMenu.add(menuItem6);
		menuItem6.addActionListener(buttonPressed);

		JMenuItem menuItem7 = new JMenuItem("Copy (Ctrl+c)",
				KeyEvent.VK_T);
		menuItem7.setBackground(STORMY_SKIES);
		editMenu.add(menuItem7);
		menuItem7.addActionListener(buttonPressed);

		JMenuItem menuItem8 = new JMenuItem("Paste (Ctrl+v)",
				KeyEvent.VK_T);
		menuItem8.setBackground(STORMY_SKIES);
		editMenu.add(menuItem8);
		menuItem8.addActionListener(buttonPressed);

		// adds a separator to the edit menu
		editMenu.addSeparator();

		JMenuItem menuItem9 = new JMenuItem("Bookmark",
				KeyEvent.VK_T);
		menuItem9.setBackground(STORMY_SKIES);
		editMenu.add(menuItem9);
		menuItem9.addActionListener(buttonPressed);

		// builds the text tools sub menu
		JMenu textToolsMenu = new JMenu("Text Tools");
		textToolsMenu.setBackground(STORMY_SKIES);

		JMenuItem menuItem10 = new JMenuItem("Pen",
				KeyEvent.VK_T);
		menuItem10.setBackground(STORMY_SKIES);
		textToolsMenu.add(menuItem10);
		menuItem10.addActionListener(buttonPressed);

		JMenuItem menuItem11 = new JMenuItem("Highlight",
				KeyEvent.VK_T);
		menuItem11.setBackground(STORMY_SKIES);
		textToolsMenu.add(menuItem11);
		menuItem11.addActionListener(buttonPressed);

		JMenuItem menuItem12 = new JMenuItem("Eraser",
				KeyEvent.VK_T);
		menuItem12.setBackground(STORMY_SKIES);
		textToolsMenu.add(menuItem12);
		menuItem12.addActionListener(buttonPressed);

		JMenuItem menuItem13 = new JMenuItem("Comment",
				KeyEvent.VK_T);
		menuItem13.setBackground(STORMY_SKIES);
		textToolsMenu.add(menuItem13);
		menuItem13.addActionListener(buttonPressed);

		editMenu.add(textToolsMenu);

		// builds the view menu
		JMenu viewMenu = new JMenu("View");
		menuBar.add(viewMenu);

		JMenuItem menuItem14 = new JMenuItem("Zoom In",
				KeyEvent.VK_T);
		menuItem14.setBackground(STORMY_SKIES);
		viewMenu.add(menuItem14);
		menuItem14.addActionListener(buttonPressed);

		JMenuItem menuItem15 = new JMenuItem("Zoom Out",
				KeyEvent.VK_T);
		menuItem15.setBackground(STORMY_SKIES);
		viewMenu.add(menuItem15);
		menuItem15.addActionListener(buttonPressed);

		JMenuItem menuItem16 = new JMenuItem("Zoom 100%",
				KeyEvent.VK_T);
		menuItem16.setBackground(STORMY_SKIES);
		viewMenu.add(menuItem16);
		menuItem16.addActionListener(buttonPressed);

		// builds the help menu
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);

		JMenuItem menuItem17 = new JMenuItem("Web Help",
				KeyEvent.VK_T);
		menuItem17.setBackground(STORMY_SKIES);
		helpMenu.add(menuItem17);
		menuItem17.addActionListener(buttonPressed);

		// creates an action listener for the Quit option under the file menu; upon clicking, triggers the 10 functions
		// our group created by using doClick() and prints the results to a file called "menu-actions.txt"
		ActionListener quitButtonPressed = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		quitMenuItem.addActionListener(quitButtonPressed);

		frame.setJMenuBar(menuBar);

		// creates the tool bar
		JToolBar toolBar = new JToolBar();

		// creates the tool bar buttons
		try {
			JButton penButton = new JButton("Pen");
			Image penImage = (Resources.getImage("icons/pen.png")).getImage();
			Image scaledPenImage = penImage.getScaledInstance(iconWidth, iconHeight, java.awt.Image.SCALE_SMOOTH);
			ImageIcon penIcon = new ImageIcon(scaledPenImage);
			penButton.setIcon(penIcon);
			penButton.setBackground(STORMY_SKIES);
			toolBar.add(penButton);

			JButton highlightButton = new JButton("Highlight");
			Image highlightImage = (Resources.getImage("icons/highlight.png")).getImage();
			Image scaledHighlightImage = highlightImage.getScaledInstance(iconWidth, iconHeight, java.awt.Image.SCALE_SMOOTH);
			ImageIcon highlightIcon = new ImageIcon(scaledHighlightImage);
			highlightButton.setIcon(highlightIcon);
			highlightButton.setBackground(STORMY_SKIES);
			toolBar.add(highlightButton);

			JButton eraserButton = new JButton("Eraser");
			Image eraserImage = (Resources.getImage("icons/eraser.png")).getImage();
			Image scaledEraserImage = eraserImage.getScaledInstance(iconWidth, iconHeight, java.awt.Image.SCALE_SMOOTH);
			ImageIcon eraserIcon = new ImageIcon(scaledEraserImage);
			eraserButton.setIcon(eraserIcon);
			eraserButton.setBackground(STORMY_SKIES);
			toolBar.add(eraserButton);

			// adds a separator to the toolbar
			toolBar.addSeparator();

			JButton commentButton = new JButton("Comment");
			Image commentImage = (Resources.getImage("icons/comment.png")).getImage();
			Image scaledCommentImage = commentImage.getScaledInstance(iconWidth, iconHeight, java.awt.Image.SCALE_SMOOTH);
			ImageIcon commentIcon = new ImageIcon(scaledCommentImage);
			commentButton.setIcon(commentIcon);
			commentButton.setBackground(STORMY_SKIES);
			toolBar.add(commentButton);

			JButton bookmarkButton = new JButton("Bookmark");
			Image bookmarkImage = (Resources.getImage("icons/bookmark.png")).getImage();
			Image scaledBookmarkImage = bookmarkImage.getScaledInstance(iconWidth, iconHeight, java.awt.Image.SCALE_SMOOTH);
			ImageIcon bookmarkIcon = new ImageIcon(scaledBookmarkImage);
			bookmarkButton.setIcon(bookmarkIcon);
			bookmarkButton.setBackground(STORMY_SKIES);
			toolBar.add(bookmarkButton);

			penButton.addActionListener(buttonPressed);
			highlightButton.addActionListener(buttonPressed);
			eraserButton.addActionListener(buttonPressed);
			bookmarkButton.addActionListener(buttonPressed);
			commentButton.addActionListener(buttonPressed);
		}
		catch(Exception e){

			System.out.println("Error creating toolbar; could not load all images.");
			toolBar.removeAll();
		}

		toolBar.setBackground(ROBIN_EGG);
		toolBar.setPreferredSize(new Dimension(750,30));

		// defines the sideMenu panel
		sideMenu.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.insets = new Insets(0, 0, 4, 0);
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.fill = GridBagConstraints.BOTH;
		sideMenu.setBackground(menuBackgroundColor);
		sideMenu.setOpaque(true);
		sideMenu.setPreferredSize(sideMenuDimension);

		// creates buttons for the sideMenu
		JButton libraryButton = new JButton("Library");
		libraryButton.setBackground(STORMY_SKIES);
		JButton browseButton = new JButton("Browse");
		browseButton.setBackground(STORMY_SKIES);
		JButton recentButton = new JButton("Recent");
		recentButton.setBackground(STORMY_SKIES);
		JButton filterButton = new JButton("Filter");
		filterButton.setBackground(STORMY_SKIES);
		JButton createNewCategoryButton = new JButton("Create Category");
		createNewCategoryButton.setBackground(STORMY_SKIES);
		JButton accountButton = new JButton("My Account");
		accountButton.setBackground(STORMY_SKIES);
		JButton settingsButton = new JButton("Settings");
		settingsButton.setBackground(STORMY_SKIES);

		// adds buttons to the sideMenu
		sideMenu.setBackground(ROBIN_EGG);
		sideMenu.add(libraryButton, constraints);
		sideMenu.add(browseButton, constraints);
		sideMenu.add(recentButton, constraints);
		sideMenu.add(filterButton, constraints);
		sideMenu.add(createNewCategoryButton, constraints);
		sideMenu.add(accountButton, constraints);
		sideMenu.add(settingsButton, constraints);

		// defines the centerPanel panel
		centerPanel.setLayout(new BorderLayout());

		// creates navigation and next buttons
		JButton prev = new JButton("Prev");
		prev.setBackground(STORMY_SKIES);

		ActionListener prevActionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				((BooksPanel) centerPanel).prevPage();
			}
		};

		prev.addActionListener(prevActionListener);

		JButton next =  new JButton("Next");
		next.setBackground(STORMY_SKIES);

		ActionListener nextActionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				((BooksPanel) centerPanel).nextPage();
			}
		};

		next.addActionListener(nextActionListener);

		// adds buttons to centerPanel
		centerPanel.add(prev, BorderLayout.WEST);
		centerPanel.add(next, BorderLayout.EAST);

		//adds a search bar to the top of centerPanel
		JTextArea searchBar = new JTextArea("Search...");
		searchBar.setForeground(Color.GRAY);
		searchBar.setBackground(GRANNY_SMITH);
		searchBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		centerPanel.add(searchBar, BorderLayout.NORTH);

		// defines original frame
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(sideMenu, BorderLayout.WEST);
		frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		frame.setPreferredSize(new Dimension(750, 700));
		frame.setVisible(true);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// exits the program upon closing the main frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				quitMenuItem.doClick(); // triggers the Quit option under the File menu
			}
		});

		// Create panel for the Search/Browse functionality and add its widgets
		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(ROBIN_EGG);
		searchPanel.setLayout(new GridLayout(0,1));
		searchPanel.setPreferredSize(new Dimension(125,600));

		final JLabel searchPanelSortByLabel = new JLabel("Search By...");
		final JRadioButton searchRadioBTitle = new JRadioButton("Title");
		searchRadioBTitle.setBackground(ROBIN_EGG);
		final JRadioButton searchRadioBAuthor = new JRadioButton("Author");
		searchRadioBAuthor.setBackground(ROBIN_EGG);
		final JRadioButton searchRadioBDate = new JRadioButton("Date Published");
		searchRadioBDate.setBackground(ROBIN_EGG);

		ButtonGroup searchPanelSortByGroup = new ButtonGroup();
		searchPanelSortByGroup.add(searchRadioBTitle);
		searchPanelSortByGroup.add(searchRadioBAuthor);
		searchPanelSortByGroup.add(searchRadioBDate);

		searchRadioBTitle.setSelected(true);
		JPanel searchSubpanelSortBy = new JPanel();
		searchSubpanelSortBy.setBackground(ROBIN_EGG);

		searchSubpanelSortBy.setLayout(new GridLayout(0,1));
		searchSubpanelSortBy.setBorder(loweredBorder);
		searchSubpanelSortBy.add(searchPanelSortByLabel);
		searchSubpanelSortBy.add(searchRadioBTitle);
		searchSubpanelSortBy.add(searchRadioBAuthor);
		searchSubpanelSortBy.add(searchRadioBDate);

		final JLabel searchPanelOrderByLabel = new JLabel("Order By...");
		final JRadioButton searchRadioBDescending = new JRadioButton("Descending");
		searchRadioBDescending.setBackground(ROBIN_EGG);
		final JRadioButton searchRadioBAscending = new JRadioButton("Ascending");
		searchRadioBAscending.setBackground(ROBIN_EGG);
		ButtonGroup searchPanelOrderByGroup = new ButtonGroup();
		searchPanelOrderByGroup.add(searchRadioBDescending);
		searchPanelOrderByGroup.add(searchRadioBAscending);
		JPanel searchSubpanelOrderBy = new JPanel();
		searchSubpanelOrderBy.setBackground(ROBIN_EGG);
		searchSubpanelOrderBy.setLayout(new GridLayout(0,1));
		searchSubpanelOrderBy.setBorder(loweredBorder);
		searchSubpanelOrderBy.add(searchPanelOrderByLabel);
		searchSubpanelOrderBy.add(searchRadioBDescending);
		searchSubpanelOrderBy.add(searchRadioBAscending);
		searchRadioBDescending.setSelected(true);

		final JButton goHomeButton = new JButton("< Go to Home");
		final JTextArea searchBarMini = new JTextArea();
		searchBarMini.setBackground(GRANNY_SMITH);
		searchBarMini.setForeground(Color.GRAY);
		searchBarMini.setText("Search...");

		goHomeButton.setBackground(STORMY_SKIES);
		searchPanel.add(goHomeButton);
		searchPanel.add(searchSubpanelSortBy);
		searchPanel.add(searchSubpanelOrderBy);
		searchPanel.add(searchBarMini);

		JPanel newCategoryPanel = new JPanel();
		newCategoryPanel.setBackground(ROBIN_EGG);
		JLabel categoryLabel = new JLabel("v/ - Include in new category");
		final JTextArea categoryName = new JTextArea();
		categoryName.setBackground(GRANNY_SMITH);
		categoryName.setForeground(Color.GRAY);
		categoryName.setText("Enter new category's name..");
		JButton categoryFinishButton = new JButton("Finish");
		categoryFinishButton.setBackground(STORMY_SKIES);
		newCategoryPanel.setLayout(new GridLayout(1,0));
		newCategoryPanel.add(categoryLabel);
		newCategoryPanel.add(categoryName);
		newCategoryPanel.add(categoryFinishButton);
		newCategoryPanel.setVisible(true);

		// creates an action listener that returns to the home screen when clicked
		ActionListener homeScreenButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.getContentPane().remove(searchPanel);
				frame.getContentPane().remove(newCategoryPanel);
				frame.getContentPane().add(sideMenu, BorderLayout.WEST);
				frame.repaint();
				frame.pack();
			}

		};

		// creates an action listener that displays the browse menu when clicked
		ActionListener browseButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().remove(sideMenu);
				frame.getContentPane().add(searchPanel, BorderLayout.WEST);
				frame.repaint();
				frame.pack();
			}
		};

		browseButton.addActionListener(browseButtonListener);
		goHomeButton.addActionListener(homeScreenButtonListener);

		// creates an action listener that displays the New Category options when clicked
		ActionListener categoryButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.getContentPane().remove(sideMenu);
				frame.getContentPane().add(searchPanel, BorderLayout.WEST);
				frame.repaint();
				frame.pack();
			}
		};

		createNewCategoryButton.addActionListener(categoryButtonListener);

		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * Class that defines the BooksPanel component of the frame
	 */
	private static final class BooksPanel extends JPanel
	{
		JPanel booksContainer;
		ArrayList<Book> bookList = new ArrayList<Book>();

		// fonts used in the BooksPanel
		Font font = new Font("TimesRoman", Font.PLAIN, 20);
		Font titleFont = new Font("TimesRoman", Font.PLAIN, 42);
		Font bookFont = new Font("TimesRoman", Font.PLAIN, 14);

		// declares values used to draw the books
		int panelWidth;
		int bookX;
		int bookY;
		final int BOOK_WIDTH = 105;
		final int BOOK_HEIGHT = 150;
		final int PANEL_PADDING = 60;	// width of the buttons on the sides of the panel
		final int BOOK_MARGIN = 10;		// space between the books

		int booksPerPage = 8;
		int pageNum = 0;
		int numPages = 0;

		public BooksPanel()
		{
			this.setBorder(BorderFactory.createLineBorder(Color.black));

			// add some example data
			bookList = new ArrayList<Book>();
			bookList.add(new Book("Pride and Prejudice", "Jane Austen", Book.Genre.ROMANCE));
			bookList.add(new Book("The Bible", "God", Book.Genre.RELIGION));
			bookList.add(new Book("1984", "George Orwell", Book.Genre.SCIENCE_FICTION));
			bookList.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", Book.Genre.FICTION));

			bookList.add(new Book("Pride and Prejudice", "Jane Austen", Book.Genre.ROMANCE));
			bookList.add(new Book("The Bible", "God", Book.Genre.RELIGION));
			bookList.add(new Book("1984", "George Orwell", Book.Genre.SCIENCE_FICTION));
			bookList.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", Book.Genre.FICTION));

			bookList.add(new Book("Pride and Prejudice", "Jane Austen", Book.Genre.ROMANCE));
			bookList.add(new Book("The Bible", "God", Book.Genre.RELIGION));
			bookList.add(new Book("1984", "George Orwell", Book.Genre.SCIENCE_FICTION));
			bookList.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", Book.Genre.FICTION));

			numPages = ((int) (bookList.size() / booksPerPage)) + 1;
		}

		public void prevPage()
		{
			if (pageNum > 0) pageNum--;
			System.out.println(pageNum);
			repaint();
		}

		public void nextPage()
		{
		    if (pageNum < numPages - 1) pageNum++;
			System.out.println(pageNum);
			repaint();
		}

		// draws a string centered in a certain width
		void drawStringCentered(Graphics g, String text, int x, int y, int width)
		{
			int textWidth = g.getFontMetrics().stringWidth(text);
			x += (width - textWidth)/2;
			g.drawString(text, x, y);
		}

		// draw the graphics of the panel
		public void	paintComponent(Graphics g)
		{
			super.paintComponent(g);

			panelWidth = getWidth();
			bookX = PANEL_PADDING + BOOK_MARGIN + 20;
			bookY = 100;

			// draws the background

			// draws the title
			g.setColor(Color.WHITE);
			g.setFont(titleFont);
			drawStringCentered(g,
					"My Books",
					0,
					70,
					panelWidth);


			// draws the books
			int booksPerRow = 0;

			int i = 0;
			for (Book book : bookList)
			{

				if (i >= pageNum*booksPerPage && i < (pageNum+1)*booksPerPage)
				{
					booksPerRow++;

					// draw the book covers
					g.drawImage(book.bookcover, bookX, bookY, null);

					// draws book info underneath
					g.setColor(Color.WHITE);
					g.setFont(bookFont);
					drawStringCentered(g,
							book.title,
							bookX,
							bookY + BOOK_HEIGHT + BOOK_MARGIN * 2,
							BOOK_WIDTH);
					drawStringCentered(g,
							book.author,
							bookX,
							bookY + BOOK_HEIGHT + BOOK_MARGIN * 2 + g.getFontMetrics().getHeight(),
							BOOK_WIDTH);
					drawStringCentered(g,
							book.genre.getName(),
							bookX,
							bookY + BOOK_HEIGHT + BOOK_MARGIN * 2 + g.getFontMetrics().getHeight() * 2,
							BOOK_WIDTH);

					// Increment x
					bookX += BOOK_WIDTH + BOOK_MARGIN;

					// Wrap around once we fill up a row
					if (bookX > panelWidth - PANEL_PADDING * 2 - BOOK_MARGIN * (booksPerRow + 2)) {
						bookX = PANEL_PADDING + BOOK_MARGIN + 20;
						bookY += BOOK_HEIGHT + BOOK_MARGIN * 3 + g.getFontMetrics().getHeight() * 3;
						booksPerRow = 0;
					}
				}
				i++;
			}
		}
	}
}