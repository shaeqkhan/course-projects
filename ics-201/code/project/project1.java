/*
 *	@author 
 			Atiq  Al-dossari	204269
 			Shaeq Pervez Khan   279245

 * @version 1.00
 */
import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.Comparator;


public class project1 implements ActionListener
{
	int l,shiftI;
	boolean oFile,aeb;
	
	Icon def = new ImageIcon("define.gif");
	Icon open = new ImageIcon("open.gif");
	Icon add = new ImageIcon("add.gif");
	Icon del = new ImageIcon("del.gif");
	Icon check = new ImageIcon("check.gif");
	Icon clearf = new ImageIcon("clearf.gif");
	Icon clear = new ImageIcon("clear.gif");
	Icon help = new ImageIcon("help.gif");
	
	JFrame frame = new JFrame("Virtual Acronym Dictionary");
	JFrame frame1 = new JFrame();
	JFrame frame2 = new JFrame();
	
	JButton defB = new JButton("Definition");
	JButton addB = new JButton("Add Word");
	JButton delB = new JButton("Delete Word");
	JButton fileB = new JButton("File");
	JButton helpB = new JButton("Print");
	JButton clearB = new JButton("Clear");
	JButton tCheckB = new JButton("Text Check");
	JButton tClearB = new JButton("Clear Text");
	JButton defB1 = new JButton(def);
	JButton addB1 = new JButton(add);
	JButton delB1 = new JButton(del);
	JButton fileB1 = new JButton(open);
	JButton helpB1 = new JButton(help);
	JButton clearB1 = new JButton(clearf);
	JButton tCheckB1 = new JButton(check);
	JButton tClearB1 = new JButton(clear);
	JButton[] b = new JButton[26];
	JButton[] c = new JButton[12];
	JButton zeroB = new JButton("0");
	JButton andB = new JButton("&  /");
	JButton endB = new JButton("-   .");
	JButton shiftB = new JButton("Shift");
	JButton spcB = new JButton("Space");
	
	String define = "<html>" + "Definition" + "</html>";
	String delete = "<html>" + "Delete Word" + "</html>";
	String addW = "<html>" + "Add Word" + "</html>";
	String file = "<html>" + "Open file" + "</html>";
	String clearTF = "<html>" + "clear the text field" + "</html>";
	String checkTA = "<html>" + "check text area" + "</html>";
	String erase = "<html>" + "clear text area" + "</html>";
	String helpT = "<html>" + "about develper" + "</html>";
	String printT = "<html>" + "Print file to the Screen" + "</html>";
	
	
	
	JTextField tField = new JTextField(null,33);
	
	JTextArea tArea = new JTextArea(null,9,18);
	JTextArea tArea1 = new JTextArea(null,9,18);
	JTextArea tArea2 = new JTextArea(null,9,18);
	
	JScrollPane scrolA = new JScrollPane(tArea);
	JScrollPane scrollPane = new JScrollPane(tArea1);
	JScrollPane scrollPane1 = new JScrollPane(tArea2);

	JPanel lPanel = new JPanel();
	JPanel cPanel = new JPanel();
	JPanel c1Panel = new JPanel();
	JPanel c2Panel = new JPanel();
	JPanel nPanel = new JPanel();
	JPanel sPanel = new JPanel();
	JPanel rPanel = new JPanel();
	JPanel r1Panel = new JPanel();
	JPanel r2Panel = new JPanel();

	
	JLabel e1Label = new JLabel(" ");
	JLabel e2Label = new JLabel(" ");
	JLabel e3Label = new JLabel(" ");
	
	JMenu option = new JMenu("File");
	JMenu process = new JMenu("Text Field");
	JMenu extra = new JMenu("Help");
	JMenu areaM = new JMenu("Text Area");
	JMenuBar bar = new JMenuBar();
	
	JFileChooser chooser = new JFileChooser();
	JToolBar toolBar = new JToolBar();
	ArrayList<acronym> list = new ArrayList<acronym>();
	
	
		public project1()
	{
		
		defB.setBackground(new Color(255,255,204));
		addB.setBackground(new Color(153,255,102));
		delB.setBackground(new Color(255,153,102));
		fileB.setBackground(new Color(255,255,204));
		helpB.setBackground(new Color(255,255,204));
		clearB.setBackground(new Color(255,255,204));
		tCheckB.setBackground(new Color(153,255,102));
		tClearB.setBackground(new Color(255,153,102));
				
		InnerListener listener = new InnerListener();
		
		defB.addActionListener(listener);
		addB.addActionListener(listener);
		delB.addActionListener(listener);
		fileB.addActionListener(listener);
		helpB.addActionListener(listener);
		clearB.addActionListener(listener);
		tCheckB.addActionListener(listener);
		tClearB.addActionListener(listener);
		defB1.addActionListener(listener);
		addB1.addActionListener(listener);
		delB1.addActionListener(listener);
		fileB1.addActionListener(listener);
		helpB1.addActionListener(listener);
		clearB1.addActionListener(listener);
		tCheckB1.addActionListener(listener);
		tClearB1.addActionListener(listener);
		
		InnerListener1 listener1 = new InnerListener1();
		
		endB.addActionListener(listener1);
		andB.addActionListener(listener1);
		shiftB.addActionListener(listener1);
		spcB.addActionListener(listener1);
		zeroB.addActionListener(listener1);
		
		StringBuffer text = new StringBuffer();
		text.append("\n\t\tVirtual Acronym Dictionary\n\n");
		text.append("Developer:	    NAME \t\t\t   ID#\n\n");
		text.append("\tAtiq Al-Dossari\t\t[ 204269 ]\n");
		text.append("\tShaeq Pervez Khan\t\t[ 279245 ]\n");
		text.append("\nVersion:	1.0");
		
		StringBuffer text1 = new StringBuffer();
		text1.append("\n\t\tVirtual Acronym Dictionary\n");
		text1.append("\n");
		text1.append("\nPress [ Definition ]      \tfor the definition of word entered. ");
		text1.append("\n");
		text1.append("\nPress [ Add Word ]     \tto add a word to the dictionary");
		text1.append("\n");
		text1.append("\nPress [ Delete Word ] \tto delete a word from the dictionary");
		text1.append("\n");
		text1.append("\nPress [ File ]                \tto open a Dictionary text file . " );
		text1.append("\n");
		text1.append("\nPress [ Clear ]             \tto clear the text field above the screen keyboard");
		text1.append("\n");
		text1.append("\nPress [ Print ]             \tto Print the Dictionary to the Screen .");
		text1.append("\n");
		text1.append("\nPress [ Text Check ]   \tto get the full form of the acronym in a sentence .");
		text1.append("\n");
		text1.append("\nPress [ Clear Text ]     \tto clear the text area .");
		text1.append("\n\n\n\t\t\t\t\t\tVersion:1.0");
	
		tArea1.setLineWrap(true);
	    tArea1.setWrapStyleWord(true);
		tArea1.setForeground(Color.blue);
		tArea2.setLineWrap(true);
	    tArea2.setWrapStyleWord(true);
		tArea2.setForeground(Color.blue);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setDefaultCloseOperation(2);
		frame1.setSize(600,400);
		frame1.setLocation(200,200);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setSize(600,430);
		frame2.setLocation(200,200);
		tArea1.setText(text.toString());
		tArea1.setFont(new Font("Times New Roman",Font.BOLD, 16));
		tArea1.setEditable(false);
		frame1.add(scrollPane);
		tArea2.setText(text1.toString());
		tArea2.setFont(new Font("Times New Roman",Font.ITALIC, 14));
		tArea2.setEditable(false);
		frame2.add(scrollPane1);
		frame.setLocation(150,125);
		frame.setLayout(new BorderLayout());
		frame.add(nPanel, BorderLayout.NORTH);
		frame.add(sPanel, BorderLayout.SOUTH);
		nPanel.add(tField);
		tField.setEditable(false);
		tField.setForeground(Color.blue);
		sPanel.add(toolBar);
		sPanel.setBackground(Color.LIGHT_GRAY);
		frame.add(lPanel, BorderLayout.WEST);
		frame.add(cPanel, BorderLayout.CENTER);
		frame.add(rPanel, BorderLayout.EAST);
		lPanel.setLayout(new GridLayout(10,2));
		lPanel.add(e1Label);
		lPanel.add(new JLabel());
		lPanel.add(defB);
		lPanel.add(new JLabel());
		lPanel.add(addB);
		lPanel.add(new JLabel());
		lPanel.add(delB);
		lPanel.add(new JLabel());
		lPanel.add(fileB);
		lPanel.add(new JLabel());
		lPanel.add(clearB);
		lPanel.add(new JLabel());
		lPanel.add(helpB);
		JLabel[] elabel = new JLabel[10];
					
		cPanel.setLayout(new GridLayout(8,5,2,2));
	
		for(int i=0;i<26;i++){
			b[i]=new JButton(""+((char)(i+65)));
			cPanel.add(b[i]);
			b[i].addActionListener(listener1);
		}
		cPanel.add(endB);
		cPanel.add(andB);
		cPanel.add(shiftB);
		cPanel.add(spcB);
		for(int j=1;j<10;j++){
			c[j]=new JButton(""+j);
			cPanel.add(c[j]);
			c[j].addActionListener(listener1);
		}
		
		cPanel.add(zeroB);
		cPanel.setBackground(Color.LIGHT_GRAY);
		rPanel.setLayout(new GridLayout(2,1));
		rPanel.add(r1Panel);
		tArea.setLineWrap(true);
		tArea.setWrapStyleWord(true);
		tArea.setForeground(Color.red);
		r1Panel.add(scrolA);
		rPanel.add(r2Panel);
		r2Panel.setLayout(new GridLayout(5,2));
		r2Panel.add(tCheckB);
		r2Panel.add(tClearB);
		for(int j=1;j<5;j++){
			r2Panel.add(new JLabel());
		}
	
		JMenuItem defI = new JMenuItem("Definition");
		defI.addActionListener(this);
		defI.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_F,ActionEvent.CTRL_MASK));
		defI.setMnemonic(KeyEvent.VK_F);
		JMenuItem addI = new JMenuItem("Add Word");
		addI.addActionListener(this);
		addI.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		addI.setMnemonic(KeyEvent.VK_A);
		JMenuItem delI = new JMenuItem("Delete Word");
		delI.addActionListener(this);
		delI.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		delI.setMnemonic(KeyEvent.VK_D);
		JMenuItem fileI = new JMenuItem("Open File");
		fileI.addActionListener(this);
		fileI.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		fileI.setMnemonic(KeyEvent.VK_O);
		JMenuItem clearI = new JMenuItem("Clear");
		clearI.addActionListener(this);
		clearI.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		clearI.setMnemonic(KeyEvent.VK_C);
		JMenuItem helpI = new JMenuItem("About Developers");
		helpI.addActionListener(this);
		helpI.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_R,ActionEvent.CTRL_MASK));	
		helpI.setMnemonic(KeyEvent.VK_R);											
		JMenuItem exitI = new JMenuItem("Exit");
		exitI.addActionListener(this);
		exitI.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		exitI.setMnemonic(KeyEvent.VK_X);
		JMenuItem checkAI = new JMenuItem("Text Check");
		checkAI.addActionListener(this);
		checkAI.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		checkAI.setMnemonic(KeyEvent.VK_A);
		JMenuItem clearAI = new JMenuItem("Clear Text");
		clearAI.addActionListener(this);
		clearAI.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		clearAI.setMnemonic(KeyEvent.VK_E);
		
		
		
		option.add(fileI);
		option.add(addI);
		option.add(delI);
		option.add(exitI);
		
		process.add(defI);
		process.add(clearI);
		
		
		areaM.add(checkAI);
		areaM.add(clearAI);
		
		extra.add(helpI);
		
		bar.add(option);
		bar.add(process);
		bar.add(areaM);
		bar.add(extra);
		
		toolBar.add(defB1);
		toolBar.add(addB1);
		toolBar.add(delB1);
		toolBar.add(fileB1);
		toolBar.add(clearB1);
		toolBar.add(helpB1);
		toolBar.add(tCheckB1);
		toolBar.add(tClearB1);
		toolBar.setBackground(Color.white);
		helpB.setToolTipText(printT);
		defB1.setForeground(new Color(153,0,0));
		defB1.setBackground(new Color(153,0,0));
    	defB1.setToolTipText(define);
    	delB1.setToolTipText(delete);
    	addB1.setToolTipText(addW);
    	clearB1.setToolTipText(clearTF);
    	helpB1.setToolTipText(helpT);
    	fileB1.setToolTipText(file);
    	tCheckB1.setToolTipText(checkTA);
    	tClearB1.setToolTipText(erase);
		defB1.setSize(10,10);	
		addB1.setForeground(new Color(153,0,0));
		addB1.setBackground(new Color(153,0,0));
		delB1.setForeground(new Color(153,0,0));
		delB1.setBackground(new Color(153,0,0));
		clearB1.setForeground(new Color(153,0,0));
		clearB1.setBackground(new Color(153,0,0));
		helpB1.setForeground(new Color(153,0,0));
		helpB1.setBackground(new Color(153,0,0));
		fileB1.setForeground(new Color(153,0,0));
		fileB1.setBackground(new Color(153,0,0));
		tCheckB1.setForeground(new Color(153,0,0));
		tCheckB1.setBackground(new Color(153,0,0));		
		tClearB1.setForeground(new Color(153,0,0));
		tClearB1.setBackground(new Color(153,0,0));

		frame.setJMenuBar(bar);
		lPanel.setBackground(Color.LIGHT_GRAY);
		c1Panel.setBackground(Color.LIGHT_GRAY);
		c2Panel.setBackground(Color.LIGHT_GRAY);
		nPanel.setBackground(Color.LIGHT_GRAY);
		r1Panel.setBackground(Color.LIGHT_GRAY);
		r2Panel.setBackground(Color.LIGHT_GRAY);
		frame.setResizable(false);
		frame.setSize(800,500);
		frame.setVisible(true);
	}
	
		class InnerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{	boolean defin = true,define = true,define1 = true;
			String s = tField.getText();
			String addWord,addAcronym,delWord;
			if(ae.getSource() == defB || ae.getSource() == defB1){
				if(oFile){
					if(tField.getText().equals(""))
						JOptionPane.showMessageDialog(frame,"Please enter a word","Error",JOptionPane.ERROR_MESSAGE);
					else{			
				String te = tField.getText().toUpperCase();
				tField.setText("");
				tArea.setText("");
    			int andW = te.indexOf("&");
    			if(andW>0){
    			String firstW = te.substring(0,andW).trim();
    			String secondW = te.substring(andW+1).trim();
				Iterator<acronym> i2 = list.iterator();
				Iterator<acronym> i1 = list.iterator();
				
				while(i2.hasNext()){
					acronym l = i2.next();				
	        		if(firstW.equals(l.getWord())){	
				        String ta = ""+l.getMeaning();
		        			tArea.append(ta+"\n");
	        				defin = false;
        				}
				}
        	if(defin)
        			JOptionPane.showMessageDialog(frame,"Sorry\n" + firstW + " is not in the Dictionary","Error",JOptionPane.ERROR_MESSAGE);
        	while(i1.hasNext()){
					acronym l = i1.next();				
        		if(secondW.equals(l.getWord())){	
			        String ta = ""+l.getMeaning();
	        			tArea.append(ta+"\n");
        				define = false;
        			}
			}
        	if(define)
        			JOptionPane.showMessageDialog(frame,"Sorry\n"+ secondW + " is not in the Dictionary","Error",JOptionPane.ERROR_MESSAGE);	
				}
				else
				{
				Iterator<acronym> i2 = list.iterator();
				while(i2.hasNext()){
					acronym l1 = i2.next();				
	        		if(te.equals(l1.getWord())){
	        			String ta = ""+l1.getMeaning();
	        			tArea.setText(ta);
	        			define1 = false;
        			}
				}
        	if(define1)
        		JOptionPane.showMessageDialog(frame,"Sorry\n"+ te + " is not in the Dictionary","Error",JOptionPane.ERROR_MESSAGE);
				}
			}	
        }		
			else
			JOptionPane.showMessageDialog(frame,"Please specify a file using the 'File' option","Error",JOptionPane.ERROR_MESSAGE);		
			}	
			else if(ae.getSource() == addB || ae.getSource() == addB1){
				if(oFile){
				addWord = JOptionPane.showInputDialog("Enter an acronym to add in the Dictionary","Acronym").toUpperCase();
				Iterator<acronym> i4 = list.iterator();
				boolean checkA = false;
				while(i4.hasNext()){
					acronym a5 = i4.next();
					if(addWord.equals(a5.getWord())){
						checkA = true;
					}
					
				}
			//	i2=null;
				if(addWord.equals("")){
					JOptionPane.showMessageDialog(frame,"Error. Nothing entered.","Error",JOptionPane.ERROR_MESSAGE);
				}
				else if(checkA)
					JOptionPane.showMessageDialog(frame,"Sorry. The word " + addWord + " already exits in the Dictionary .","Error",JOptionPane.ERROR_MESSAGE);
				else if(!addWord.equals("") && !checkA){
					addAcronym = JOptionPane.showInputDialog(null,"Enter the full form");
					list.add(new acronym(addWord,addAcronym));
					JOptionPane.showMessageDialog(null,addWord + " - " + addAcronym +" successfully added to dictionary.");
				}
					
			//	for(acronym e1 : list)
			  //  	System.out.println(e1);
				
				}
			else
				JOptionPane.showMessageDialog(frame,"Please specify a file using the 'File' option","Error",JOptionPane.ERROR_MESSAGE);	
			}
			else if(ae.getSource() == delB || ae.getSource() == delB1){
				if(oFile){
				delWord = JOptionPane.showInputDialog(null,"Enter the acronym you want to delete").toUpperCase();
				System.out.println(delWord);
				Iterator<acronym> i1 = list.iterator();
	        	boolean ans=false;
		        	while(i1.hasNext()){
		        		if(delWord.equals((i1.next()).getWord())){
		        			i1.remove();
		        			ans=true;
		        		}
        	}
        	if(ans){
        		JOptionPane.showMessageDialog(null,"' " + delWord + " '" + " found and deleted successfully. ");
        	}
        	if(ans==false)
	        	JOptionPane.showMessageDialog(frame,"" + delWord + " Not Found. ","Error !",JOptionPane.ERROR_MESSAGE);
	        //	for(acronym e : list)
	    	//	System.out.println(e);
	         }
			else
			JOptionPane.showMessageDialog(frame,"Please specify a file using the 'File' option","Error",JOptionPane.ERROR_MESSAGE);	
			}
			else if(ae.getSource() == fileB || ae.getSource() == fileB1)
				{
					Scanner input = null;
					Scanner k = new Scanner(System.in);
					chooser.setCurrentDirectory(new File("."));
   					chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
   					public boolean accept(File f) {
   					     return f.getName().toLowerCase().endsWith(".txt")|| f.isDirectory();
  					    }

   				    public String getDescription() {
  					      return "Text Documents(.txt)";
  						    }
 						   });

 			  int r = chooser.showOpenDialog(new JFrame());
				  if (r == JFileChooser.APPROVE_OPTION) {
		 			  String name = chooser.getSelectedFile().getName();
		 			  System.out.println("The Acronym file is "+name);
		 		   try{
					 			 input = new Scanner(new File(name));
					 			 System.out.println("File opening successful.");	   
					 			 oFile = true;		   
					 		 }
	       		   catch(FileNotFoundException at){
						 JOptionPane.showMessageDialog(frame,"Problem opening specified file.","Warning",JOptionPane.WARNING_MESSAGE);
   	 				}
   		 	while(input.hasNext()){
	    		String line = input.nextLine();
	    		int doubleDash = line.indexOf("--");
	    		String word = line.substring(0,doubleDash-1);
	    		String meaning = line.substring(doubleDash+2);
    	    	list.add(new acronym(word,meaning));
    	    	
        	}
  				  }
  			input.close();
  				  for(acronym e : list){
    					System.out.println(e);
    				}
 			 }
			else if(ae.getSource() == helpB1)
				frame2.setVisible(true);
			else if(ae.getSource() == helpB){
				if(oFile){
				for(acronym e : list)
	    		System.out.println(e);
			}
			else
			JOptionPane.showMessageDialog(frame,"Please specify a file using the 'File' option","Error",JOptionPane.ERROR_MESSAGE);		
			}
			else if(ae.getSource() == clearB || ae.getSource() == clearB1)
				tField.setText("");			
			else if(ae.getSource() == tCheckB || ae.getSource() == tCheckB1){
					// To Do !!
					int choice = 0;
					String s1 = null;
					boolean checB = true,checB2 = true;
					String ta = null;
					String sen = tArea.getText();
					tArea.setText("");
					String word,lword;
					int count =1;
					for(int i=0;i<sen.length();i++){
						if((sen.charAt(i)) == (' '))
							count++;
					}
					
				
					for(int j =0;j < count;j++){
						int space = sen.indexOf(" ");
					
					
						if(j == count-1){
							word = sen.substring(0);
							lword = word.toUpperCase();
						}
						else{
							word = sen.substring(0,space);
							lword = word.toUpperCase();
						}
						
							
							checB = true;
							Iterator<acronym> i2 = list.iterator();
							while(i2.hasNext()){
								acronym l = i2.next();				
				        		if(lword.equals(l.getWord())){	
							        ta = ""+l.getMeaning();
					       			checB = false;
					       			tArea.append(ta+" ");
				        	
				        		}
							}
							if(checB)
							tArea.append(word+" ");
							System.out.println(word);
							sen = sen.substring(space+1);		
						}
					
					
			}	
			else if(ae.getSource() == tClearB || ae.getSource() == tClearB1)
				tArea.setText("");	
		}
	}
	class InnerListener1 implements ActionListener
	{
		public void actionPerformed(ActionEvent t)
		{
		
			String s = new String("");
			if(t.getSource() == andB){
				if(aeb)
					tField.setText(tField.getText() + "/");
				else
						tField.setText(tField.getText() + "&");
			}
			
			else if(t.getSource() == endB){
				if(aeb)
					tField.setText(tField.getText() + ".");
				else
					tField.setText(tField.getText() + "-");
			}
			
			else if(t.getSource() == shiftB){
				
				shiftI++;
				if(shiftI%2 != 0){
					l = 32;
					aeb = true;
				}
				else if(shiftI%2 == 0){
					l = 0;
					shiftI--;
					shiftI--;
					aeb = false;
				}	
			}	
			else if(t.getSource() == spcB)
				tField.setText(tField.getText() + " ");	
			else if(t.getSource() == zeroB)
				tField.setText(tField.getText() + "0");
			else if(t.getSource() == c[1])
				tField.setText(tField.getText() + "1");
			else if(t.getSource() == c[2])
				tField.setText(tField.getText() + "2");	
			else if(t.getSource() == c[3])
				tField.setText(tField.getText() + "3");	
			else if(t.getSource() == c[4])
				tField.setText(tField.getText() + "4");		
			else if(t.getSource() == c[5])
				tField.setText(tField.getText() + "5");	
			else if(t.getSource() == c[6])
				tField.setText(tField.getText() + "6");
			else if(t.getSource() == c[7])
				tField.setText(tField.getText() + "7");
			else if(t.getSource() == c[8])
				tField.setText(tField.getText() + "8");
			else if(t.getSource() == c[9])
				tField.setText(tField.getText() + "9");																					
			else if(t.getSource() != endB)	
				for(int q=0;q<26;q++)
					if(t.getSource() == b[q])
						tField.setText(tField.getText()+((char)(q+65+l)));
		}
		
	}
		public void actionPerformed(ActionEvent e)
		{
			boolean defin1 = true,defin2 = true,defin3 = true;
			String s1 = tField.getText().trim();
			String addWord1,addAcronym1,delWord1,d;
			String bs = e.getActionCommand();
			if(bs.equals("Definition")){
				if(oFile){
					if(tField.getText().equals(""))
							JOptionPane.showMessageDialog(frame,"Please enter a word","Error",JOptionPane.ERROR_MESSAGE);
						else{		
			
				String te = tField.getText().toUpperCase();
				tField.setText("");
				tArea.setText("");
    			int andW = te.indexOf("&");
	    			if(andW>0){
	    			String firstW = te.substring(0,andW).trim();
	    			String secondW = te.substring(andW+1).trim();
					Iterator<acronym> i2 = list.iterator();
					Iterator<acronym> i1 = list.iterator();
						while(i2.hasNext()){
							acronym l = i2.next();				
			        		if(firstW.equals(l.getWord())){	
						        String ta = ""+l.getMeaning();
						        String ta1 = ""+l.getWord();
				        			tArea.append(ta1 + " is : " + ta + "\n");
			        				defin1 = false;
			        		}
				}
        	if(defin1)
        			JOptionPane.showMessageDialog(frame,"Sorry\n" + "' " + firstW + " ' is not in the dictionary","Error",JOptionPane.ERROR_MESSAGE);
        		while(i1.hasNext()){
					acronym l = i1.next();				
        			if(secondW.equals(l.getWord())){	
			       		 String ta = ""+l.getMeaning();
			       		 String ta1 = ""+l.getWord();
			   			 tArea.append(ta1 + " is : " + ta + "\n");
        					defin2 = false;
        		}
				}
        	if(defin2)
        			JOptionPane.showMessageDialog(frame,"Sorry\n" + "' " + secondW + " ' is not in the dictionary","Error",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
				Iterator<acronym> i2 = list.iterator();
				while(i2.hasNext()){
					acronym l1 = i2.next();				
	        		if(te.equals(l1.getWord())){
	        			String ta = ""+l1.getMeaning();
	        			tArea.setText(ta);
	        			defin3 = false;
        			}
				}
        	if(defin3)
        			JOptionPane.showMessageDialog(frame,"Sorry\n" + "' " + te +  " ' is not in the dictionary","Error",JOptionPane.ERROR_MESSAGE);
  					}
			}	
       	}		
			else
			JOptionPane.showMessageDialog(frame,"Please specify a file using the 'File' option.","Error",JOptionPane.ERROR_MESSAGE);	
			}
			else if(bs.equals("Add Word")){if(oFile){
				addWord1 = JOptionPane.showInputDialog("Enter an acronym to add in the Dictionary","Acronym").toUpperCase();
				Iterator<acronym> i4 = list.iterator();
				boolean checkA = false;
				while(i4.hasNext()){
					acronym a5 = i4.next();
					if(addWord1.equals(a5.getWord())){
						checkA = true;
					}
				}
				if(addWord1.equals("")){
					JOptionPane.showMessageDialog(frame,"Error. Nothing entered.","Error",JOptionPane.ERROR_MESSAGE);
				}
				else if(checkA)
					JOptionPane.showMessageDialog(frame,"Error. Word already exits in the Dictionary .","Error",JOptionPane.ERROR_MESSAGE);
				else if(!addWord1.equals("") && !checkA){
					addAcronym1 = JOptionPane.showInputDialog(null,"Enter the full form");
					list.add(new acronym(addWord1,addAcronym1));
					JOptionPane.showMessageDialog(null,addWord1 + " - " + addAcronym1 + " successfully added to dictionary.");
				}
					
				}
			else
				JOptionPane.showMessageDialog(frame,"Please specify a file using the 'File' option","Error",JOptionPane.ERROR_MESSAGE);	
				}
			else if(bs.equals("Delete Word")){
				if(oFile){
				delWord1 = JOptionPane.showInputDialog(null,"Enter an acronym you want to delete").toUpperCase();
				Iterator<acronym> i1 = list.iterator();
	        	boolean ans=false;
		        	while(i1.hasNext()){
		        		if(delWord1.equals((i1.next()).getWord())){
		        			i1.remove();
		        			ans=true;
		        		}		
        	}
        	if(ans==false)
        	JOptionPane.showMessageDialog(frame,"" + "' "+ delWord1 + " ' was not found in the dictionary.","Error !!",JOptionPane.ERROR_MESSAGE);
	        	for(acronym e1 : list)
	    			System.out.println(e1);
				}
			else
			JOptionPane.showMessageDialog(frame,"Please specify a file using the 'File' option.","Error",JOptionPane.ERROR_MESSAGE);	
			}
			else if(bs.equals("Open File"))
				{	
					Scanner input = null;
					Scanner k = new Scanner(System.in);
					chooser.setCurrentDirectory(new File("."));
   			chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {	
   				public boolean accept(File f) {
   			   		 return f.getName().toLowerCase().endsWith(".txt")|| f.isDirectory();
  		  				}
   		   		 public String getDescription() {
  					      return "Text Documents(.txt)";
  						    }
 						   });

 				   int r = chooser.showOpenDialog(new JFrame());
				   if (r == JFileChooser.APPROVE_OPTION) {
 				   String name = chooser.getSelectedFile().getName();
 				   System.out.println("The Acronym file is "+name);
 		  try{
		 			 input = new Scanner(new File(name));
		 			 System.out.println("File openening successful.");
		 			 oFile = true;	   	   
		 		 }
         catch(FileNotFoundException at){
   			 JOptionPane.showMessageDialog(frame,"Problem opening files.","Warning",JOptionPane.WARNING_MESSAGE);
    }
   		 	while(input.hasNext()){
		    		String line = input.nextLine();
		    		int doubleDash = line.indexOf("--");
		    		String word = line.substring(0,doubleDash-1);
		    		String meaning = line.substring(doubleDash+2);
	    		list.add(new acronym(word,meaning));
    	} 
  				  }
  		 input.close();
  				  for(acronym e1 : list){
    				System.out.println(e1);
    			}
 			
 			 }
			else if(bs.equals("About Developers"))
				frame1.setVisible(true);
			else if(bs.equals("Clear"))
				tField.setText("");
			else if(bs.equals("Text Check"))
				JOptionPane.showMessageDialog(frame,"Text Area Checked.");
			else if(bs.equals("Clear Text"))
				tArea.setText("");		
			else if(bs.equals("Exit"))
				{
			String name1=null;	
			JOptionPane pane = new JOptionPane("You have unsaved changes. \nDo you want to save before you quit?");
		    Object[] options = new String[] { "Yes", "No", "Cancel" };
		    pane.setOptions(options);
		    JDialog dialog = pane.createDialog(new JFrame(), "Exit");
		    dialog.show();
		    Object obj = pane.getValue(); 
		    int result = -1;
			    for (int k = 0; k < options.length; k++)
			      if (options[k].equals(obj))
			        result = k;
			        if(result == 0){
				        PrintWriter	output = null;
				        name1 = JOptionPane.showInputDialog(null,"Type a new name for the file to be saved.");
		    try{
		       	output = new PrintWriter(new File(name1+".txt"));
		        }
		    catch(FileNotFoundException ex){
				   System.out.println("Problem opening files.");
				   System.exit(0);
			   }
			 
		        	for(acronym e2 : list)
    				output.println(e2.getWord() + " -- " + e2.getMeaning());	
		output.close();
		        System.exit(0); 		
		        }	
				else if(result == 1)
					System.exit(0);
			}		
		}
	public static void main(String[] args)
	{
		new project1();
	}
}
