package login;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound implements Runnable{
	
	String path="";
	String audiofile_path="";
	AudioFormat audioformat;
	TargetDataLine tdl;
	public Sound(String audiofile_path) {
		this.audiofile_path=audiofile_path;
	}
	public AudioFormat setAudioFormas() {
		float sampleRate=8000F;
		int sampleSizeInBits=16;
		int channels=2;
		boolean signed=true;
		boolean bigEndian=false;
		
		return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
	}
	
	public void start_sound(String filename) throws LineUnavailableException {
		this.path=filename;
		audioformat=setAudioFormas();
		DataLine.Info dif=new DataLine.Info(TargetDataLine.class,audioformat);
		tdl=(TargetDataLine) AudioSystem.getLine(dif);
		new save_sound().start();
	}
	
	public void end_sound() {//��ͣ
		tdl.stop();
		tdl.close();
	}
	
	public void play_sound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
System.out.println("����·��"+audiofile_path);
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(audiofile_path));
		AudioFormat audioFormat=audioInputStream.getFormat();
		DataLine.Info dataLineInfo=new DataLine.Info(SourceDataLine.class,audioFormat,AudioSystem.NOT_SPECIFIED);
		SourceDataLine sourceDataLine=(SourceDataLine)AudioSystem.getLine(dataLineInfo);
		sourceDataLine.open(audioFormat);
		sourceDataLine.start();
		
		int len;
		byte by[]=new byte[1024];
		while((len=audioInputStream.read(by, 0, by.length))!=-1) {
			if(len>0) {
				sourceDataLine.write(by, 0, len);
			}
		}
	}
	
	class save_sound extends Thread{
		@Override
		public void run() {
			super.run();
			AudioFileFormat.Type filetype=null;
			File audiofile=null;
			filetype=AudioFileFormat.Type.WAVE;
			audiofile=new File(path);
			try {
				tdl.open(audioformat);
				tdl.start();
				AudioSystem.write(new AudioInputStream(tdl), filetype, audiofile);
			} catch (LineUnavailableException | IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Sound sound=new Sound("D:\\KSmusic\\���륫�ƥ��� .wav");
		sound.play_sound();
		sound.end_sound();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			this.play_sound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}