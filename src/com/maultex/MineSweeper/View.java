/**
 * 
 */
package com.maultex.MineSweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.Timer;
import javax.swing.border.Border;

import com.maultex.MineSweeper.BestTimesManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;


/**
 * @author Christoball
 *
 */
public class View extends JFrame implements ActionListener
{
	protected int _nWidth = 8;
	protected int _nHeight = 8;
	protected int _nFieldSize = _nWidth * _nHeight;
	protected int _nMines = 9;
	protected int _nRemainingMines = _nMines;
	
	protected int _nTimeSec = 0;
	protected int _nTime10thSec = 0;
	protected String _sFinishTime = "0";
	
	protected JPanel pnlMineField = new JPanel(new GridLayout(_nWidth, _nHeight));

	protected JMenuBar menuBarMain = new JMenuBar();
	protected JMenu menuGame = new JMenu("Game");
	protected JMenuItem menuItemNewGame = new JMenuItem("New Game");
	protected JMenuItem menuItemBeginner = new JMenuItem("Beginner");
	protected JMenuItem menuItemIntermediate = new JMenuItem("Intermediate");
	protected JMenuItem menuItemExpert = new JMenuItem("Expert");
	protected JMenuItem menuItemBestTimes = new JMenuItem("Best Times");
	protected JMenuItem menuItemExit = new JMenuItem("Exit");
	protected JMenuItem menuItemAbout = new JMenuItem("About");
	protected JMenu helpMenu = new JMenu("Help");	
	
	//MINES, FACE, CLOCK
	protected JPanel pnlInfo = new JPanel();
	protected JLabel lblMines1s = new JLabel("");
	protected JLabel lblMines10s = new JLabel("");
	protected JLabel lblMines100s = new JLabel("");
	protected JLabel lblTime1s = new JLabel("");
	protected JLabel lblTime10s = new JLabel("");
	protected JLabel lblTime100s = new JLabel("");
	protected Timer _timer;
	
	protected JButton btnFace = new JButton(Resources.iconHappyFace);
	
	protected GridSpaceButton[] _gridSpaceBtns;// = new GridSpaceButton[_nFieldSize];
	
	protected GridSpaceObserver _actionObserver = null;
	protected GameButtonObserver _gameObserver = null;
	
	/**
	 * default constructor for view with grid size
	 * @param width
	 * @param height
	 * @param gameBtnObserver TODO
	 * @param mines
	 */
	public View(int width, int height, int nMineCount, GridSpaceObserver observer, GameButtonObserver gameBtnObserver)
	{	
		this.setTitle(Resources.GAME_TITLE);
		//super(" Mine Sweeper");
		ImageIcon img = Resources.iconRedMine;
		setIconImage(img.getImage());
				
		_nWidth = width;
		_nHeight = height;
		_nFieldSize = _nWidth * _nHeight;
		_gridSpaceBtns = new GridSpaceButton[_nFieldSize];
		_nMines = nMineCount;
		
		_actionObserver = observer;
		_gameObserver = gameBtnObserver;
		
		buildLayout(width, height);	
	}

	/**
	 * Observes clicks on the New menu item
	 * @param ctrlr
	 */
	protected void addNewGameActionListener(Controller ctrlr)
	{
		menuItemNewGame.addActionListener(new MenuNewObserver(ctrlr));
	}
	
	/**
	 * Observers of gui action on menu items
	 * @param ctrlr
	 */
	protected void addBeginnerActionListener(Controller ctrlr)
	{
		menuItemBeginner.addActionListener(new MenuBeginnerObserver(ctrlr));

	}	
	
	/**
	 * Observers of gui action on menu items
	 * @param ctrlr
	 */
	protected void addIntermediateActionListener(Controller ctrlr)
	{
		MenuIntermediateObserver observerMenu = new MenuIntermediateObserver(ctrlr);
		menuItemIntermediate.addActionListener(new MenuIntermediateObserver(ctrlr));
	}
	
	/**
	 * Observers of gui action on menu items
	 * @param ctrlr
	 */
	protected void addExpertActionListener(Controller ctrlr)
	{
		menuItemExpert.addActionListener(new MenuExpertObserver(ctrlr));
	}
	
	/**
	 * build the game with mines and buttons
	 * @param width
	 * @param height
	 */
	protected void buildLayout(int width, int height)
	{
		super.setLocationByPlatform(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//super.setDefaultLookAndFeelDecorated(true);		
		
		//MENU BAR
		menuGame.add(menuItemNewGame);
		menuGame.addSeparator(); //add menu divider
		menuGame.add(menuItemBeginner);
		//menuGame.addActionListener(new ActionList)
		menuGame.add(menuItemIntermediate);
		
		menuGame.add(menuItemExpert);
		menuGame.addSeparator(); //add menu divider
		menuGame.add(menuItemBestTimes);
		menuItemBestTimes.addActionListener(new ActionListener() 
		{
	        public void actionPerformed(ActionEvent actionEvent) 
	        {
	        	BestTimes times = BestTimesManager.getBestTimes();
	        	
	        	JOptionPane.showMessageDialog(null,"Beginner: " + times.getBeginnerName() + " = " + times.getBeginnerTime() + "\n\nIntermediate: \n\nExpert: \n\n");	             
	        }
	    });
		menuGame.addSeparator();
		menuGame.add(menuItemExit);
		menuItemExit.addActionListener(new ActionListener() 
		{
	        public void actionPerformed(ActionEvent actionEvent) 
	        {
	            System.exit(0);
	        }
	    });		
		menuBarMain.add(menuGame);
		
		helpMenu.add(menuItemAbout);
		menuItemAbout.addActionListener(new ActionListener() 
		{
	        public void actionPerformed(ActionEvent actionEvent) 
	        {
	            JOptionPane.showMessageDialog(null,"Chris Mauldin \n\nMine Sweeper Clone in Java\n\nchris.mauldin@gmail.com\n\n2015");
	            //Enable fileitem1 & 2 here ?? 
	        }
	    });
		
		menuBarMain.add(helpMenu);
		
		
		
		
		javax.swing.GroupLayout layoutInfoPnl = new javax.swing.GroupLayout(pnlInfo);
        pnlInfo.setLayout(layoutInfoPnl);
		btnFace.setIcon(Resources.iconHappyFace);
		//btnFace.setPressedIcon(Resources.iconHappyFace);
		btnFace.setMaximumSize(new Dimension(26,26));
		btnFace.setBorderPainted(false);
		btnFace.setContentAreaFilled(false);	//need this to prevent extra button space beyond the image borders
		btnFace.addMouseListener(_gameObserver);
		btnFace.setFocusable(false);
		//btnFace.requestFocus();
		//btnFace.setSize(25,25);
		
		setMineCount(_nMines);
		//pnlInfo.add(lblMines100s);
		//pnlInfo.add(lblMines10s);
		//pnlInfo.add(lblMines1s);
		//pnlInfo.add(btnFace);
		
		lblTime1s.setIcon(Resources.icon0);
		lblTime10s.setIcon(Resources.icon0);
		lblTime100s.setIcon(Resources.icon0);
		
		//pnlInfo.add(lblTime100s);
		//pnlInfo.add(lblTime10s);
		//pnlInfo.add(lblTime1s);
		layoutInfoPnl.setHorizontalGroup(
	            layoutInfoPnl.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
	            .addGroup(layoutInfoPnl.createSequentialGroup()
	                .addGap(18, 18, 18)
	                .addComponent(lblMines100s)
	                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(lblMines10s)
	                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
	                 .addComponent(lblMines1s)
	                .addComponent(btnFace) //, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
	                //.addGap(145, 145, 145)
	                .addComponent(lblTime100s)
	                //.addGap(18, 18, 18)
	                .addComponent(lblTime10s)
	                //.addGap(2, 2, 2)
	                .addComponent(lblTime1s)
	                //.addGap(24, 24, 24))
	        ));	
		
		layoutInfoPnl.setVerticalGroup(
				layoutInfoPnl.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
		            .addGroup(layoutInfoPnl.createSequentialGroup()
		                .addContainerGap()
		                .addGroup(layoutInfoPnl.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                    .addComponent(lblMines1s)//, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(lblMines10s)
		                    .addComponent(lblMines100s)
		                    .addComponent(btnFace, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(lblTime100s)
		                    .addComponent(lblTime10s)
		                    .addComponent(lblTime1s))
		                //.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		                .addContainerGap())    
		        );
		
		//Border brdrInfoPnl = BorderFactory.createCompoundBorder(BorderFactory.createRaisedSoftBevelBorder(), BorderFactory.createLoweredSoftBevelBorder());
		//pnlInfo.setBorder(brdrInfoPnl);
		
		pnlInfo.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		//brdrInfoPnl = new RaisedSoftBevelBorder();
		
		this.add(menuBarMain, BorderLayout.NORTH);
		this.add(pnlInfo, BorderLayout.CENTER);
		
		//pnlMineField.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		
		//this.setSize(500, 500);		
		
		//this.pack();
		
		createNewGameView();
		//this.setSize(16 * width + 25, 16 * height + 50);
		
		
		
		//com.sun.java.swing.plaf.windows.WindowsLookAndFeel
		try 
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //try to look like the Windows old MineSweeper game
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(this);	//update all components that are part of this Class so the LookAndFeel shows correctly
	}
	
	

	/**
	 * set out buttons on mine grid
	 */
	public void createNewGameView()
	{
		//MINE FIELD
		GridLayout layoutMineGrid = new GridLayout(this._nWidth, this._nHeight);
		pnlMineField.setLayout(layoutMineGrid);	
		
		//btnUntouched.setContentAreaFilled(false);	//need this to prevent extra button space beyond the image borders
	    setMineCount(_nMines);
	    
		for (int i = 0; i < _nFieldSize; i++)
		{
			
		    GridSpaceButton btnUntouched = new GridSpaceButton(Resources.iconUntouched);
		    btnUntouched.setSize(16, 16);
			
			
		    //frame.add(button);
			//mineButton.setSize(50,50);
			pnlMineField.add(btnUntouched);
			btnUntouched.setFocusable(false);
			
			this._gridSpaceBtns[i] = btnUntouched;
			
			btnUntouched.addMouseListener(_actionObserver);
			
		}
		pnlMineField.setBorder( BorderFactory.createCompoundBorder(BorderFactory.createRaisedSoftBevelBorder(), BorderFactory.createLoweredSoftBevelBorder()));
		_gridSpaceBtns[0].requestFocus();
		this.add(pnlMineField, BorderLayout.SOUTH);
		//this.setMinimumSize(new Dimension(16 * width + 25, 16 * height + 60));
		this.setMinimumSize(new Dimension(200, 305));
		//this.setResizable(false);
		this.setResizable(true);
		//pack();
	}
	
	/**
	 * Starts Timer that keeps track of amount of seconds elapse during a game
	 */
	public void startTimer()
	{
		_timer = new Timer(100, this);
		_timer.start(); 	
	}
	
	/**
	 * sets the clock back to 0
	 */
	public void clearTimer()
	{
		//lblTimeOnes.setText("" + 0);
		lblTime1s.setIcon(Resources.icon0);
		repaint();
	}
	
	
	/**
	 * Sets the display of number of hidden mines to param
	 * @param _nMines
	 */
	public void setMineCount(int nMinesRemaining)
	{
		this._nRemainingMines = nMinesRemaining;
		
		int n100s = _nRemainingMines / 100;
		lblMines100s.setIcon(new ImageIcon(Resources.IMG_DIRECTORY + n100s + Resources.IMG_TYPE));
		
		int n10s = (_nRemainingMines / 10) % 10;
		lblMines10s.setIcon(new ImageIcon(Resources.IMG_DIRECTORY + n10s + Resources.IMG_TYPE));
		
		int n1s = _nRemainingMines % 10;
		lblMines1s.setIcon(new ImageIcon(Resources.IMG_DIRECTORY + n1s + ".png"));
		repaint();
	}
	
	/**
	 * Decrease Mines Digital Display by 1
	 */
	public void decreaseMineCount()
	{
		_nRemainingMines--;
		setMineCount(_nRemainingMines);
	}
	
	/**
	 * Increase Mines Digital Display by 1
	 */
	public void increaseMineCount()
	{
		_nRemainingMines++;
		setMineCount(_nRemainingMines);
	}	

	/**
	 * @param _actionObserver
	 */
	public void setActionObserver(GridSpaceObserver observer) 
	{
		this._actionObserver = observer;
		
	}

	/**
	 * @return
	 */
	public GridSpaceButton[] getGridSpaceBtns() 
	{
		return this._gridSpaceBtns;
	}

	/**
	 * Update the seconds that have elapsed
	 */
	protected void updateTime()
	{
		if ((_nTimeSec >= 999) && (_nTimeSec != -1)) //stop at 999 secs like Windows Game
		{
			_nTimeSec++;
			return;
		}
		else
		{
			_nTime10thSec = _nTime10thSec + 1;
			if (_nTime10thSec % 10 == 0)
			{
				_nTimeSec = _nTimeSec + 1;
				int n100s = (int) _nTimeSec / 100;
				int n10s = (int) (_nTimeSec / 10) % 10;
				int n1s = (int) _nTimeSec % 10;
				
				lblTime100s.setIcon(new ImageIcon("res/" + n100s + ".png"));
				lblTime10s.setIcon(new ImageIcon("res/" + n10s + ".png"));
				lblTime1s.setIcon(new ImageIcon("res/" + n1s + ".png"));
				repaint();
			}
		}
		
	}	
	
	
	/**
	 * User's click may trip a mine
	 */
	public void showUncertainFace()
	{
		//iconUncertainFace = new ImageIcon("res/UncertainFace.png");
		btnFace.setIcon(Resources.iconUncertainFace);
		repaint();
	}
	
	/**
	 * Waiting to start new game or a game is in progress
	 */
	public void showHappyFace()
	{
		btnFace.setIcon(Resources.iconHappyFace);
		repaint();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource().equals(_timer))
		{
			updateTime();
		}				
	}
	

	/**
	 * Start a New Game
	 */
	public void showHappyFacePressed() 
	{
		btnFace.setIcon(Resources.iconHappyPressedFace);
		repaint();	
	}

	/**
	 * Shows the face with Sun Glasses
	 */
	public void showCoolFace() 
	{
		btnFace.setIcon(Resources.iconCoolFace);
		repaint();		
		
	}	
	
	/**
	 * Game Over - Lost game!
	 */
	public void showYuckFace() 
	{
		btnFace.setIcon(Resources.iconYuckFace);
		repaint();		
	}

	/**
	 * Effectively stops the timer and saves the current time elapsed
	 */
	public void stopTimer() 
	{
		_sFinishTime = _nTimeSec + "." +_nTime10thSec;
		_nTimeSec = -1;
		_timer.stop();
	}

	/**
	 * 
	 * @return The amount of time that elapsed during the game
	 */
	protected String getFinishTime()
	{
		return _sFinishTime;
	}

	/**
	 * @param finishTime
	 */
	public void showWinningTime(String sTime) 
	{
		String sName = JOptionPane.showInputDialog(Resources.WINNING_MESSAGE + sTime);
		// TODO: store names and times
	}
	
	
}
