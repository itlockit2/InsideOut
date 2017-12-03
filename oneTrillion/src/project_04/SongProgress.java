package project_04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 사용자가 진행한 정도가 기록되어있는 progress.txt파일을 관리하는 클래스
 * @author Sungho Yun
 * @version 0.4
 */
public class SongProgress {
	/** 정보를 읽어올 파일 */
	private File inFile;
	/** 정보를 기록할 파일 */
	private File outFile;
	/** BufferedReader를 통해서 파일에 있는 정보를 읽어온다*/
	private BufferedReader br;
	/** 읽어온 정보들을 배열형태로 저장 */
	private String[] progressArray;
	/** BufferedWriter를 통해서 파일에 정보를 쓴다 */
	BufferedWriter bw;
	/**
	 * 생성자를 통해 만약 파일이 없으면 초기정보를 progress.txt파일로 저장한다.
	 */
	public SongProgress() {
		try {
			int index = 0;
			progressArray = new String[9];
			inFile =  new File("progress.txt");
			outFile = new File("progress.txt");
			if(!inFile.isFile()) {
				try {
				bw = new BufferedWriter(new FileWriter("progress.txt"));
				bw.write("Tobu & Itro - Sunburst_Highlight.mp3");
				bw.newLine();
				bw.write("0.0");
				bw.newLine();
				bw.write("0.0");
				bw.newLine();
				bw.write("BadNewsHighLight.mp3");
				bw.newLine();
				bw.write("0.0");
				bw.newLine();
				bw.write("0.0");
				bw.newLine();
				bw.write("HeartBeatHighLight.mp3");
				bw.newLine();
				bw.write("0.0");
				bw.newLine();
				bw.write("0.0");
				bw.newLine();
				bw.flush();
				bw.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			br = new BufferedReader(new FileReader(inFile));
			String line;
			while ((line = br.readLine()) != null) {
				progressArray[index] = line;
				index++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * progressArray 배열을 매개변수로 받아 해당 배열을 progress.txt파일에 저장한다.
	 * @param progressArray
	 */
	public void write(String[] progressArray) {
		bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("progress.txt"));
			for(int i = 0 ; i < progressArray.length ; i++) {
				bw.write(progressArray[i]);
				bw.newLine();
			}
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null)
				try {
					bw.close();
				} catch (IOException e) {
				}
		}
	}

	/** progress.txt 정보를 가지고 있는 progressArray를 리턴해주는 메소드 */
	public String[] getProgressArray() {
		return progressArray;
	}
}
