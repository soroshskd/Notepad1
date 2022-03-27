import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;
public class NotepadFrame extends JFrame {
JPanel panel = new JPanel();
JMenuBar menuOne = new JMenuBar();
JTextPane text1 = new JTextPane();
JScrollPane scrollB = new JScrollPane();
File fileOpen;
File fileSave;
StyledDocument styleText = text1.getStyledDocument(); ;
Style styleT;
public NotepadFrame() {
this.setJMenuBar(menuOne);
Color colorMenu = new Color(167, 107, 150);
colorMenu.getRGB();
Color colorTextMenu = new Color(199, 193, 117);
colorTextMenu.getRGB();
Color colorBG = new Color(240,230,140);
colorBG.getRGB();
menuOne.setBackground(colorMenu);
// menu bar
JMenu file = new JMenu("File");
file.setForeground(colorTextMenu);
JMenuItem newFile = new JMenuItem("New");
file.add(newFile);
ImageIcon newIcon = new ImageIcon(getClass().getResource("icons8-new-16.png"));
newFile.setIcon(newIcon);
JMenuItem openFile = new JMenuItem("Open");
file.add(openFile);
ImageIcon openIcon = new ImageIcon(getClass().getResource("icons8-opened-folder-16.png"));
openFile.setIcon(openIcon);
JMenuItem saveFile = new JMenuItem("Save");
file.add(saveFile);
ImageIcon saveIcon = new ImageIcon(getClass().getResource("icons8-save-16.png"));
saveFile.setIcon(saveIcon);
JMenuItem saveAsFile = new JMenuItem("Save as");
file.add(saveAsFile);
ImageIcon saveAsIcon = new ImageIcon(getClass().getResource("icons8-save-as-16.png"));
saveAsFile.setIcon(saveAsIcon);
JMenuItem closeFile = new JMenuItem("Close");
file.add(closeFile);
ImageIcon closeIcon = new ImageIcon(getClass().getResource("icons8-close-16.png"));
closeFile.setIcon(closeIcon);
JMenu edit = new JMenu("Edit");
edit.setForeground(colorTextMenu);
JMenuItem colorBEdit = new JMenuItem("Writing background color");
edit.add(colorBEdit);
ImageIcon colorBIcon = new ImageIcon(getClass().getResource("icons8-window-color-16.png"));
colorBEdit.setIcon(colorBIcon);
JMenu languageEdit = new JMenu("Language");
ImageIcon languageIcon = new ImageIcon(getClass().getResource("icons8-language-skill-16.png"));
languageEdit.setIcon(languageIcon);
JMenuItem languageOne = new JMenuItem("English");
languageEdit.add(languageOne);
ImageIcon languageOneIcon = new ImageIcon(getClass().getResource("icons8-united-kingdom-16.png"));
languageOne.setIcon(languageOneIcon);
JMenuItem languageTwo = new JMenuItem("فارسی");
languageEdit.add(languageTwo);
ImageIcon languageTwoIcon = new ImageIcon(getClass().getResource("icons8-iran-16.png"));
languageTwo.setIcon(languageTwoIcon);
JMenuItem languageThree = new JMenuItem("עִברִית");
languageEdit.add(languageThree);
ImageIcon languageThreeIcon = new ImageIcon(getClass().getResource("icons8-israel-16.png"));
languageThree.setIcon(languageThreeIcon);
edit.add(languageEdit);
JMenu about = new JMenu("About-us");
about.setForeground(colorTextMenu);
JMenuItem aboutItem = new JMenuItem("?");
about.add(aboutItem);
ImageIcon aboutIcon = new ImageIcon(getClass().getResource("icons8-programmer-32.png"));
aboutItem.setIcon(aboutIcon);
menuOne.add(file);
menuOne.add(edit);
menuOne.add(about);
//panel & constractor    
Toolkit tool = this.getToolkit();
Dimension screenSize = tool.getScreenSize();
int x = screenSize.width/2+133;
int y = screenSize.height - screenSize.height/6;
this.setSize(x,y);
panel.setBackground(colorBG);
panel.setLayout(new BorderLayout());
this.setTitle("Notepad Plus+");
this.add(panel);
text1.setBackground(Color.WHITE);
text1.setBorder(BorderFactory.createEmptyBorder(13, 13, 13, 13));
panel.setBorder(BorderFactory.createMatteBorder(13, 13, 13, 13,colorBG));
panel.add(text1);
scrollB.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scrollB.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
scrollB.getViewport().add(text1);
panel.add(scrollB);
//ToolBar
JToolBar toolBar = new JToolBar();
toolBar.setBackground(colorBG);
panel.add(toolBar,BorderLayout.NORTH);

JButton boldText = new JButton();
ImageIcon boldIcon = new ImageIcon(getClass().getResource("icons8-bold-50.png"));
boldText.setIcon(boldIcon);
boldText.setBackground(colorMenu);
boldText.setToolTipText("Make your text bold.");
toolBar.add(boldText);

JTextPane space1 = new JTextPane();
space1.setBackground(colorBG);
space1.setEditable(false);
toolBar.add(space1);

JButton underLineText = new JButton();
ImageIcon underLineIcon = new ImageIcon(getClass().getResource("icons8-underline-50.png"));
underLineText.setIcon(underLineIcon);
underLineText.setBackground(colorMenu);
underLineText.setToolTipText("Underline your text.");
toolBar.add(underLineText);

JTextPane space2 = new JTextPane();
space2.setBackground(colorBG);
space2.setEditable(false);
toolBar.add(space2);

JButton italicText = new JButton();
ImageIcon italicIcon = new ImageIcon(getClass().getResource("icons8-italic-50.png"));
italicText.setIcon(italicIcon);
italicText.setBackground(colorMenu);
italicText.setToolTipText("Italicize your text.");
toolBar.add(italicText);

JTextPane space3 = new JTextPane();
space3.setBackground(colorBG);
space3.setEditable(false);
toolBar.add(space3);

JButton strikeText = new JButton();
ImageIcon strikeIcon = new ImageIcon(getClass().getResource("icons8-strikethrough-text-feature-in-word-processing-application-48.png"));
strikeText.setIcon(strikeIcon);
strikeText.setBackground(colorMenu);
strikeText.setToolTipText("Cross something out by drawing a line through it.");
toolBar.add(strikeText);

JTextPane space4 = new JTextPane();
space4.setBackground(colorBG);
space4.setEditable(false);
toolBar.add(space4);

JButton fontColorText = new JButton();
ImageIcon fontColorIcon = new ImageIcon(getClass().getResource("icons8-pencil-cup-48.png"));
fontColorText.setIcon(fontColorIcon);
fontColorText.setBackground(colorMenu);
fontColorText.setToolTipText("Change the color of your text.");
toolBar.add(fontColorText);

JTextPane space5 = new JTextPane();
space5.setBackground(colorBG);
space5.setEditable(false);
toolBar.add(space5);

JComboBox fontSizeText = new JComboBox();
for (int i =13; i <99; i+=5) {
fontSizeText.addItem(i);    
}
fontSizeText.setBackground(colorMenu);
fontSizeText.setToolTipText("Change the size of your text.");
toolBar.add(fontSizeText);
// action events
newFile.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
    text1.setText("");
    }
});
openFile.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
    JFileChooser chooseOpen = new JFileChooser();
    chooseOpen.setCurrentDirectory(new File("C:\\Users\\sorosh\\Desktop"));
    int getChooseOpen = chooseOpen.showDialog(panel,"Select");
        if (getChooseOpen==JFileChooser.APPROVE_OPTION) {
            fileOpen = chooseOpen.getSelectedFile();
            String fileGet = readFile(fileOpen);
            text1.setText(fileGet);
        }
    }
});
saveFile.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) { 
        String getAddressFile = fileOpen.getAbsolutePath();
            try {    
            File saveAddress = new File(getAddressFile);
            FileWriter writeSave = new FileWriter(fileOpen);
            BufferedWriter write = new BufferedWriter(writeSave);
            String getTxt = text1.getText();
            write.write(getTxt);
            write.close();
            } catch (Exception e1) {         
            }                  
    }
});
closeFile.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {    
    System.exit(0);
    }
});
colorBEdit.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
    Color colorGet=JColorChooser.showDialog(panel,"Select a color",colorMenu);
    text1.setBackground(colorGet);
    
    }
});
languageOne.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
    file.setText("File");
    newFile.setText("New");
    openFile.setText("Open");
    saveFile.setText("Save");
    saveAsFile.setText("Save as");
    closeFile.setText("Close");
    edit.setText("Edit");
    colorBEdit.setText("Writing background color");
    languageEdit.setText("Language");
    about.setText("About-us");
    boldText.setToolTipText("Make your text bold.");
    underLineText.setToolTipText("Underline your text.");
    italicText.setToolTipText("Italicize your text.");
    strikeText.setToolTipText("Cross something out by drawing a line through it.");
    fontColorText.setToolTipText("Change the color of your text.");
    fontSizeText.setToolTipText("Change the size of your text.");
    }
});
languageTwo.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
    file.setText("فایل");
    newFile.setText("ایجاد فایل جدید");
    openFile.setText("باز کردن فایل");
    saveFile.setText("ذخیره فایل");
    saveAsFile.setText("ذخیره به عنوان");
    closeFile.setText("بستن برنامه");
    edit.setText("ویرایش");
    colorBEdit.setText("رنگ پس زمینه نوشتن");
    languageEdit.setText("تغییر زبان");
    about.setText("درباره ما");
    boldText.setToolTipText("متن خود را پررنگ کنید");
    underLineText.setToolTipText("زیر متن خود خط بکشید");
    italicText.setToolTipText("متن خود را مورب بنویسید");
    strikeText.setToolTipText("چیزی را با کشیدن خطی از آن عبور دهید.");
    fontColorText.setToolTipText("رنگ متن خود را تغییر دهید.");
    fontSizeText.setToolTipText("اندازه متن خود را تغییر دهید.");
    }
});
languageThree.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
    file.setText("קוֹבֶץ");
    newFile.setText("קובץ חדש");
    openFile.setText("קובץ פתוח");
    saveFile.setText("שמור את הקובץ");
    saveAsFile.setText("שמור כ");
    closeFile.setText("סגור");
    edit.setText("לַעֲרוֹך");
    colorBEdit.setText("צבע רקע כתיבה");
    languageEdit.setText("שפה");
    about.setText("עלינו");
    boldText.setToolTipText("הפוך את הטקסט שלך למודגש.");
    underLineText.setToolTipText("הדגש את הטקסט שלך.");
    italicText.setToolTipText("נטה את הטקסט שלך.");
    strikeText.setToolTipText("חוצים משהו על ידי ציור קו דרכו.");
    fontColorText.setToolTipText("שנה את צבע הטקסט שלך.");
    fontSizeText.setToolTipText("שנה את גודל הטקסט שלך.");
    }
});
aboutItem.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
     String getNew = newFile.getText();
        JOptionPane.showMessageDialog(null,"Sorosh Moradi","SoRoSh App",JOptionPane.INFORMATION_MESSAGE,aboutIcon);
    }
});
boldText.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
    styleT = text1.addStyle("Bold",null);
    StyleConstants.setBold(styleT,true);
    styleText.setCharacterAttributes(text1.getSelectionStart(),text1.getSelectionEnd()-text1.getSelectionStart(),
    text1.getStyle("Bold"),true);
    }
});
underLineText.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
    styleT = text1.addStyle("UnderLine",null);
    StyleConstants.setUnderline(styleT,true);
    styleText.setCharacterAttributes(text1.getSelectionStart(),text1.getSelectionEnd()-text1.getSelectionStart(),
    text1.getStyle("UnderLine"),true);
    }
});
italicText.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
    styleT = text1.addStyle("Italic",null);
    StyleConstants.setItalic(styleT,true);    
    styleText.setCharacterAttributes(text1.getSelectionStart(),text1.getSelectionEnd()-text1.getSelectionStart(),
    text1.getStyle("Italic"),true);
    }
});
strikeText.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
    styleT = text1.addStyle("Strike",null);
    StyleConstants.setStrikeThrough(styleT,true);
    styleText.setCharacterAttributes(text1.getSelectionStart(),text1.getSelectionEnd()-text1.getSelectionStart(),
    text1.getStyle("Strike"),true);
    }
});
fontColorText.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {   
    Color colorGet=JColorChooser.showDialog(panel,"Select a color",colorMenu);
    styleT = text1.addStyle("Color",null);
    StyleConstants.setForeground(styleT, colorGet);
    styleText.setCharacterAttributes(text1.getSelectionStart(),text1.getSelectionEnd()-text1.getSelectionStart(),
    text1.getStyle("Color"),true);
    }
});
fontSizeText.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
    int fontSize = (int) fontSizeText.getSelectedIndex()+13;
    styleT = text1.addStyle("Size",null);
    StyleConstants.setFontSize(styleT,fontSize);
    styleText.setCharacterAttributes(text1.getSelectionStart(),text1.getSelectionEnd()-text1.getSelectionStart(),
    text1.getStyle("Size"),true);
    }
});
//this.setResizable(false);
this.setLocation(screenSize.width/8, screenSize.height/15);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setVisible(true);
}
    

public String readFile (File fileT){
String fileString = null;
StringBuffer fileBuffer = null;
String line = null;
    try {
        FileReader read = new FileReader(fileT);
        BufferedReader txt = new BufferedReader(read);
        fileBuffer = new StringBuffer();
        while((line = txt.readLine()) !=null){
            fileBuffer.append(line);
            fileBuffer.append("\n");
        }      
        read.close();
        fileString = fileBuffer.toString();
    } catch (Exception e) {
    }

return fileString;
}

}
