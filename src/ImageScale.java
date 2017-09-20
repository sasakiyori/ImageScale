import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.Console;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageScale {
	public int[][] getImage() {
		try {
			BufferedImage inputImage = ImageIO.read(new File("05.png"));
			int width = inputImage.getWidth();
			int height = inputImage.getHeight();
			
			int[][] imageMatrix = new int[width][height];
			
			for (int y = 0; y < height; y++)
				for (int x = 0; x < width; x++) {
					imageMatrix[x][y] = inputImage.getRaster().getSample(x, y, 0);
					
					//imageMatrix[x][y] = inputImage.getRGB(x, y);
					
					/*
					int rgb = inputImage.getRGB(x, y);
					int r = (rgb >> 16) & 0xFF;
					int g = (rgb >> 8) & 0xFF;
					int b = rgb & 0xFF;
					imageMatrix[x][y] = (int)(0.3 * r + 0.59 * g + 0.11 * b);
					*/
				}
			return imageMatrix;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void printImage(int[][] imageData) {
		if (imageData != null) {
			int width = imageData.length;
			int height = imageData[0].length;
			
			BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			for (int i = 0; i < height; i++)
				for (int j = 0; j < width; j++) {
					result.setRGB(j, i, new Color(imageData[j][i], imageData[j][i], imageData[j][i]).getRGB());
					//result.getRaster().setDataElements(j, i, imageData[j][i]);
				}
			try {
				File resultImg = new File("result.png");
				ImageIO.write((RenderedImage)result, "png", resultImg);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	/*public int[][] scale(int[][] originImage) {
		
	}*/
}
