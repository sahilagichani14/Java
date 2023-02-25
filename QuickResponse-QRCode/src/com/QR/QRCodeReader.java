package com.QR;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Reader;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class QRCodeReader {
	
	public static void qrCodeReader() throws Exception {
		
		InputStream barcodeInputStream = new FileInputStream("E:\\java_projects\\QRTest.png");
		
		BufferedImage barcodeBufferedImage = ImageIO.read(barcodeInputStream);
		
		LuminanceSource src = new BufferedImageLuminanceSource(barcodeBufferedImage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(src));
		MultiFormatReader reader = new MultiFormatReader();
		Result result = reader.decode(bitmap);
		
		System.out.println(result.getText());
	}

}
