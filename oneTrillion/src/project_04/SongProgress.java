package project_04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SongProgress {

	private File inFile;
	private File outFile;
	private BufferedReader br;
	private String[] progressArray;
	BufferedWriter bw;
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

	public String[] getProgressArray() {
		return progressArray;
	}

	public void setProgressArray(String[] progressArray) {
		this.progressArray = progressArray;
	}

	public File getInFile() {
		return inFile;
	}

	public void setInFile(File inFile) {
		this.inFile = inFile;
	}

	public File getOutFile() {
		return outFile;
	}

	public void setOutFile(File outFile) {
		this.outFile = outFile;
	}

	public BufferedReader getBr() {
		return br;
	}

	public void setBr(BufferedReader br) {
		this.br = br;
	}

}
