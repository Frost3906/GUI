package menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.undo.UndoManager;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JMenuTest extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextArea textArea;
	private JMenuItem mnNew, mnOpen, mnSave, mnExit, mnCancel, mnCut, mnCopy, mnPaste, mnAll, mnDate;
	private UndoManager undo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					JMenuTest frame = new JMenuTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JMenuTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("파일(F)");
		mnNewMenu.setMnemonic('F');
		menuBar.add(mnNewMenu);
		
		mnNew = new JMenuItem("새로 만들기(N)");
		mnNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnNewMenu.add(mnNew);
		
		mnOpen = new JMenuItem("열기(O)");
		mnOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnNewMenu.add(mnOpen);
		
		mnSave = new JMenuItem("저장(S)");
		mnSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnNewMenu.add(mnSave);
		
		JSeparator separator_2 = new JSeparator();
		mnNewMenu.add(separator_2);
		
		mnExit = new JMenuItem("끝내기(X)");
		mnNewMenu.add(mnExit);
		
		JMenu mnNewMenu_1 = new JMenu("편집(E)");
		mnNewMenu_1.setMnemonic('E');
		menuBar.add(mnNewMenu_1);
		
		mnCancel = new JMenuItem("실행취소");
		mnCancel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mnCancel);
		
		JSeparator separator = new JSeparator();
		mnNewMenu_1.add(separator);
		
		mnCut = new JMenuItem("잘라내기");
		mnCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mnCut);
		
		mnCopy = new JMenuItem("복사");
		mnCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mnCopy);
		
		mnPaste = new JMenuItem("붙여넣기");
		mnPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mnPaste);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu_1.add(separator_1);
		
		mnAll = new JMenuItem("모두선택");
		mnAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mnAll);
		
		mnDate = new JMenuItem("시간/날짜");
		mnDate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		mnNewMenu_1.add(mnDate);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		undo = new UndoManager();
		textArea.getDocument().addUndoableEditListener(undo);
		
		
		
		mnNew.addActionListener(this);
		mnOpen.addActionListener(this);
		mnSave.addActionListener(this);
		mnExit.addActionListener(this);
		mnCancel.addActionListener(this);
		mnCut.addActionListener(this);
		mnCopy.addActionListener(this);
		mnPaste.addActionListener(this);
		mnAll.addActionListener(this);
		mnDate.addActionListener(this);
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 JMenuItem menu = (JMenuItem) e.getSource();
		 
		 if(menu==mnNew) {
			 //textArea에 내용이 있다면 현재 내용에 대한 변경여부를 묻는 창을 하나 띄운 후 
			 if(textArea.getText().length()>0) {
			 //사용자의 선택 여부에 따라 일을 수행한 후 새창 보여주기
				 
				 String options[] = {"저장", "저장안함", "취소"};
				 int retVal = JOptionPane.showOptionDialog(this, "변경 내용을 제목없음에 저장하시겠습니까?", "메모장", JOptionPane.DEFAULT_OPTION, -1, null, options, options[0]);
			 
				 if(retVal==0) { //저장
					 save();
					 textArea.setText("");
				 }else if(retVal==1) { //저장안함
					 textArea.setText("");
				 
				 }else if(retVal==2) { //취소
					 return;
				 }
			 }
		 }else if(menu==mnOpen) {
			 textArea.setText("");
			 JFileChooser choo = getChooser();
			 
			 int retVal = choo.showOpenDialog(this);
			 
			 if(retVal==0) {//열기 버튼 클릭한 경우
				 File file = choo.getSelectedFile();
				 //Reader이용해서 읽어온 후
				 //textArea 보여주기
				try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getPath()),"euc-kr"))) {
					String msg;
					 while ((msg = reader.readLine()) != null) {
							
						 textArea.append(msg+"\n");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				 
				 
			 }else {//취소 버튼 클릭한 경우
				 return;
			 }
		 }else if(menu==mnSave) {
			save();
		 }else if(menu==mnExit) {
			 System.exit(0);
		 }else if(menu==mnCancel) {
			 if(undo.canUndo()==false){
				 return;
			 }
			 else{
				 undo.undo();
			 }
		 }else if(menu==mnCut) {
			 textArea.cut();
		 }else if(menu==mnCopy) {
			 textArea.copy();
		 }else if(menu==mnPaste) {
			 textArea.paste();
		 }else if(menu==mnAll) {
			 textArea.selectAll();
		 }else if(menu==mnDate) {
			 SimpleDateFormat date = new SimpleDateFormat(" a  h:mm  yyyy-MM-dd");
			// textArea.replaceSelection(date.format(new Date()));
			 textArea.insert(date.format(new Date()), textArea.getCaretPosition());
		 }
		
		}
	private JFileChooser getChooser() {
		JFileChooser chooser = new JFileChooser();
		chooser.setAcceptAllFileFilterUsed(false);
		
		chooser.addChoosableFileFilter(new FileNameExtensionFilter("텍스트 파일(*.txt)","txt"));
		
		chooser.setSelectedFile(new File("*.txt"));
		
		
		return chooser;
	}
	private void save() {
		JFileChooser chooser = getChooser();
		
		int retVal = chooser.showSaveDialog(this);
		
		if(retVal==0) {//저장
			//사용자가 입력한 파일명을 가져와서 해당 경로에 현재 textArea값을 파일로 저장한다.
			File file = chooser.getSelectedFile();
			if(file.getPath().lastIndexOf(".")<0) {
				file = new File(file.getPath()+".txt");
			}
			
			try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getPath()),"euc-kr"))){
				String msg = textArea.getText();
				msg = msg.replaceAll("\n", "\r\n");
				
				writer.write(msg);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			return;
		}
		
		
		
		
	}

}
