package com.QR;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Scanner;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class QRCodeGenerator {
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		String details = sc.nextLine();
		//String details = "Sahil is learning to code";
		
		ByteArrayOutputStream out = QRCode.from(details).to(ImageType.PNG).stream();
		
		File f = new File("E:\\java_projects\\QRTest.png");
		FileOutputStream fos = new FileOutputStream(f);
		
		fos.write(out.toByteArray());
		
		
		QRCodeReader.qrCodeReader();
		
		fos.flush();
		
		//2nd way to generate QRCode
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix matrix = qrCodeWriter.encode(details, BarcodeFormat.QR_CODE, 500, 500);
		MatrixToImageWriter.writeToFile(matrix, "PNG", new File("E:\\java_projects\\QRTest1.png"));
		
		//3rd way to generate byte QRCode
		QRCodeWriter qrCodeWriter1 = new QRCodeWriter();
		BitMatrix matrix1 = qrCodeWriter1.encode(details, BarcodeFormat.QR_CODE, 500, 500);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		//MatrixToImageConfig config = new MatrixToImageConfig(0xFF000000, 0xFFFFFFFF); //black & white color code
		MatrixToImageWriter.writeToStream(matrix1, "PNG", byteArrayOutputStream);
		
		
	}
	
}
