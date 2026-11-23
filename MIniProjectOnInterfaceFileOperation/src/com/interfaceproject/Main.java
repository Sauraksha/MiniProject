package com.interfaceproject;

public class Main {

	public static void main(String[] args) {
		
		FileOperation fo;
		System.out.println("---TXT FILE---");
		fo=new TxtFile();
		fo.readFile();
		fo.writeFile();
		fo.deleteFile();
		
		System.out.println("--------------------");
		System.out.println("---PDF FILE---");
		fo=new PdfFile();
		fo.readFile();
		fo.writeFile();
		fo.deleteFile();
		
		System.out.println("--------------------");
		System.out.println("---CSV FILE---");
		fo=new CSVFile();
		fo.readFile();
		fo.writeFile();
		fo.deleteFile();
	}
}
