package com.xiayu.JavaDemo.xiayu.java.java.io.bio;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

public class IODemo {
	/**
	 * ???????????
	 * ????????
	 * @throws IOException
	 */
	@Test
	public void test1() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("D:/b.txt");
		FileOutputStream fileOutputStream = new FileOutputStream("D:/abc.txt");
		int c = 0;
		while((c = fileInputStream.read())!=-1) {
			fileOutputStream.write(c);
		}
		fileInputStream.close();
		fileOutputStream.close();
	}
	/**
	 * ???????????????
	 * @throws IOException
	 */
	@Test
	public void test2() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("D:/????? - ???????.flac");
		FileOutputStream fileOutputStream = new FileOutputStream("D:/??????.flac");
		int length = 1024;
		byte b[] = new byte[length];
		while(fileInputStream.read(b)!= -1) {
			fileOutputStream.write(b);
		}
		fileInputStream.close();
		fileOutputStream.close();
		
	}
	/**
	 * ???????
	 * @throws IOException
	 */
	@Test
	public void test3() throws IOException {
		FileInputStream fis = new FileInputStream("D:/????? - ???????.flac");
		FileOutputStream fos = new FileOutputStream("D:/fuck.flac");
		byte arr[] = new byte[1024*8];
		int len = 0;
		while((len=fis.read(arr))!=-1) {
			fos.write(arr,0,len);
		}
		fis.close();
		fos.close();
				
	}
	/**
	 * BufferedInputStream ? BufferedOutputStream ????inputstream
	 * outputstream ??????
	 * @throws IOException
	 */
	@Test
	public void test4() throws IOException {
		FileInputStream fis = new FileInputStream("D:/xxx.flac");
		FileOutputStream fos = new FileOutputStream("D:/you.flac");
		BufferedInputStream bfis = new BufferedInputStream(fis);
		BufferedOutputStream bfos = new BufferedOutputStream(fos);
		int a = 0;
		while((a=bfis.read())!=-1)
			bfos.write(a);
		bfis.close();
		bfos.close();
		
	}
	@Test
	public void test5() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("D:/b.txt");
		FileOutputStream fileOutputStream = new FileOutputStream("D:/fuckyou.txt");
		int length = 1;
		byte b[] = new byte[length];
		while(fileInputStream.read(b)!= -1) {
			fileOutputStream.write(b);
		}
		fileInputStream.close();
		fileOutputStream.close();
	}
	/**
	 * jdk1.7??????
	 * @throws Exception
	 */
	@Test
	public void test6() throws Exception {
		try(
				FileInputStream fis = new FileInputStream("D:/abc.txt");
				FileOutputStream fos = new FileOutputStream("D:/bbb.txt");
				MyClose mc = new MyClose();
			){
				int b;
				while((b = fis.read()) != -1) {
					fos.write(b);
				}
			}
	}
	class MyClose implements AutoCloseable{

		@Override
		public void close() throws Exception {
			System.out.println("close");
		}
		
	}
	/**
	 * ???????
	 * @throws IOException
	 */
	@Test
	public void test7() throws IOException {
		FileReader fileReader = new FileReader("D:/abc.txt");
		FileWriter fileWriter = new FileWriter("D:/fuckfuck.txt");
		int a = 0;
		while((a=fileReader.read())!=-1) {
			fileWriter.write(a);
		}
		fileReader.close();
		fileWriter.close();
	}
	@Test
	public void test8() throws IOException {
		FileReader fileReader = new FileReader("D:/abc.txt");
		FileWriter fileWriter = new FileWriter("D:/fuck1fuck.txt");
		int len = 0;
		char[] arr = new char[1024*8];
		while((len=fileReader.read(arr))!=-1) {
			fileWriter.write(arr,0,len);
		}
		fileReader.close();
		fileWriter.close();
	}
	@Test
	public void test9() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("D:/abc.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("D:/fuck11fuck.txt"));
		int len = 0;
		while((len=reader.read())!=-1) 
			writer.write(len);
		reader.close();
		writer.close();
	}
	@Test
	public void test10() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("D:/abc.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("D:/fuck11fuck.txt"));
		String line;
		if((line=reader.readLine())!= null) {
			writer.write(line);
		}
		reader.close();
		writer.close();
	}
	@Test
	public void test11() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("D:/abc.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("D:/fuck11fuck.txt"));
		ArrayList<String> arr = new ArrayList<>();
		String line;
		while((line=reader.readLine()) != null)  
			arr.add(line);
		int i = arr.size() - 1;
		for(;i>=0;i--) {
			writer.write(arr.get(i));
			writer.newLine();
		}
		reader.close();
		writer.close();
	}
	@Test
	public void test12() throws IOException {
		LineNumberReader lnr = new LineNumberReader(new FileReader("D:/abc.txt"));
		String line;
		lnr.setLineNumber(100);									//???????
		while((line = lnr.readLine()) != null) {
			System.out.println(lnr.getLineNumber() + ":" + line);//??????
		}
		
		lnr.close(); 
	}
	@Test
	public void test13() throws IOException, FileNotFoundException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:/abc.txt"),"UTF-8"));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:/122.txt"),"GBK"));
		int i;
		while((i=reader.read())!=-1) {
			writer.write(i);
		}
		reader.close();
		writer.close();
	}
	@Test
	public void test14() throws IOException, FileNotFoundException {
		InputStreamReader reader = new InputStreamReader(new FileInputStream("D:/abc.txt"),"UTF-8");
		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("D:/122.txt"),"GBK");
		int i;
		while((i=reader.read())!=-1) {
			writer.write(i);
		}
		reader.close();
		writer.close();
	}
}

