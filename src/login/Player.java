package login;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.URL;
 
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
 
public class Player extends JFrame{
  //��ʾ(��������)����״̬�ı�ǩ
  JLabel songNameLabel = null;
 
  //�ĸ����Ź��ܼ���ť
  JButton btnLast = null; //��һ��
  JButton btnPlay = null; //����
  JButton btnNext = null; //��һ��

  
 
  //�����б�
  JList songsList = null;
  AudioClip songs[] = null;
  AudioClip currentSong = null;
 
  int index=0; //��ǰ������JList�е�λ��(���)
  //�����ļ�������---String
  String[] strSongNames={ "�ɷ��ַ� - ���� ~happy excursion~.wav","�ɷ��ַ� - ����~Flourishing Blossoms~.wav","�ɷ��ַ� - ���� ~Seasons of Asia~.wav","�ɷ��ַ� - ͑��~transformation~.wav","�ɷ��ַ� - ���� ~GEAR UP~.wav","AdventureForBlack.wav","GoldenHours.wav","LastingMoment.wav","OtherSideBlue.wav","Sea,You&Me.wav","WhiteWithYou.wav","���륫�ƥ��� .wav" };
  final String DIR="songs\\";
 
 
//  sound.play_sound();
 
 
  //�������ֵ��߳�
  Thread playerThread=null;
  boolean isPlayOrStop = true;//true������״̬
  boolean isLoop = false; //�Ƿ�Ϊѭ��״̬
 
  public Player() {
    super("���ֲ�����");
    setBounds(300, 50,600, 800);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(null);
    //hello();
 
    //��ʾ(��������)����״̬�ı�ǩ
    songNameLabel = new JLabel();
    Font songNameFont = new Font("����",Font.ITALIC,18);
    songNameLabel.setFont(songNameFont);
    songNameLabel.setText("���ֲ�����");
    songNameLabel.setBounds(10, 10, 300, 40);
    getContentPane().add(songNameLabel);
 
    //5�����Ź��ܼ���ť
    btnLast = new JButton("<");
    btnPlay = new JButton("||");
    btnNext = new JButton(">");

    
    //λ�ô�С
    btnLast.setBounds(10, 70, 50, 40);
    btnPlay.setBounds(70, 70, 50, 40);
    btnNext.setBounds(130, 70, 50, 40);

   
    //����ͼƬ
   
    //��ӵ����
    getContentPane().add(btnLast);
    getContentPane().add(btnPlay);
    getContentPane().add(btnNext);
    
  
    //��Ӽ���
    MyMouseListener mml = new MyMouseListener();
    btnLast.addMouseListener(mml);
    btnPlay.addMouseListener(mml);
    btnNext.addMouseListener(mml);


 
 
    //�����б�ı���
    JLabel listLabel = new JLabel("�����б�");
    listLabel.setBounds(10, 120, 100, 30);
    Font listLabelFont = new Font("����",Font.BOLD,16);
    listLabel.setFont(listLabelFont);
    getContentPane().add(listLabel);
 
   
 
    DefaultListModel lm = new DefaultListModel();
    songsList = new JList(lm);
    songsList.setBounds(10, 150, 250, 300);
    songsList.setBackground(Color.CYAN);
    //�����и����������ӵ�List��
    //songsList.setListData(strSongNames);
    songs = new AudioClip[strSongNames.length];
    for(int i=0;i<strSongNames.length;i++){
      lm.add(i,strSongNames[i]);
      songs[i] = loadSound(strSongNames[i]);
    }
    
    getContentPane().add(songsList);
    //lm.remove(3);
 
    //��JList�ؼ��ļ�������ʵ��
    songsList.addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent e) {//---------------------------------------------------------------
        currentSong.stop();
        index = songsList.getSelectedIndex();
        isPlayOrStop = true;
        playerThread = new Thread( new MusicRun() );//-------------------------------
        playerThread.start();
      }
    });
    
    
    //---------------------
    System.out.println("strSongNames[index]"+strSongNames[index]);
 
    //����һ���̣߳�ר���ڲ�������
    playerThread = new Thread( new MusicRun() );//-------------------------------
    playerThread.start();
 
 
    setVisible(true);
  }
 
 
 
  private AudioClip loadSound(String fileName) {
    try {
      URL url = new URL("file:songs\\"+fileName);
      AudioClip au = Applet.newAudioClip(url);
      return au;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
 
 
  //�������ֲ��ŵĻ�������
  private void hello() {
    try {
      File f = new File("D:\\KSmusic\\�ɷ��ַ� - ����~Flourishing Blossoms~.wav");
      URL url = f.toURI().toURL();
      //URL url = new URL("file:songs\\song1.wav");
      AudioClip au = Applet.newAudioClip(url);
      au.play();
      //au.loop();
      //au.stop();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
 
  private class MyMouseListener extends MouseAdapter{
    @Override
    public void mouseClicked(MouseEvent e) {
      JButton btn = (JButton) e.getSource();
      currentSong.stop();
      if(btn==btnPlay){
        isPlayOrStop = !isPlayOrStop;
      }else if(btn==btnLast){
        index--;
        if(index<0){
          index = strSongNames.length-1;
        }
        //isPlayOrStop=true;
      }else if(btn==btnNext){
        index++;
        index = index%strSongNames.length;
 
      }
      
 
      if(isPlayOrStop){//����
    	 System.out.println("����·��D:\\KSmusic\\"+strSongNames[index] );
        playerThread = new Thread( new Sound("D:\\KSmusic\\�ɷ��ַ� - ���� ~happy excursion~.wav"));//------------------------------
        playerThread.start();
        
      }else{//ֹͣ
        songsList.setSelectedIndex(index);
        
        songNameLabel.setText("ֹͣ����:"+strSongNames[index]);
      }
    }
  }
 
  private class MusicRun  implements Runnable{//-----------------------
    @Override
    public void run() {
      currentSong = songs[index];
      if(isLoop){
        currentSong.loop();
        songNameLabel.setText("ѭ������:"+strSongNames[index]);
      }
      if (isPlayOrStop) {
        currentSong.play();
        
      }
      //�ڲ����б���ѡ����ǰ����
      songsList.setSelectedIndex(index);
    
 
      if(!isLoop){
        songNameLabel.setText("���ڲ���:"+strSongNames[index]);
      }
    }
  }
}
