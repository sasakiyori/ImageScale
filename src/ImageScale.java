import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
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
					//imageMatrix[x][y] = inputImage.getRaster().getSample(x, y, 0);
					
					//imageMatrix[x][y] = inputImage.getRGB(x, y);
					
					int rgb = inputImage.getRGB(x, y);
					int r = (rgb >> 16) & 0xFF;
					int g = (rgb >> 8) & 0xFF;
					int b = rgb & 0xFF;
					imageMatrix[x][y] = (int)(0.3 * r + 0.59 * g + 0.11 * b);
				}
			return imageMatrix;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void printImage(int[][] imageData, String oper) {
		if (imageData != null) {
			int width = imageData.length;
			int height = imageData[0].length;
			
			BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
			for (int i = 0; i < height; i++)
				for (int j = 0; j < width; j++) {
					result.setRGB(j, i, new Color(imageData[j][i], imageData[j][i], imageData[j][i]).getRGB());
				}
			try {
				File resultImg = new File(oper + "-" + width + "-" + height + ".png");
				ImageIO.write((RenderedImage)result, "png", resultImg);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public int[][] scale(int[][] originImage, int outputWidth, int outputHeight) {
		int originWidth = originImage.length;
		int originHeight = originImage[0].length;
		int[][] outputImage = new int[outputWidth][outputHeight];
		
		for (int j = 0; j < outputHeight; j++)
			for (int i = 0; i < outputWidth; i++) {
				// use bilinear interpolation
				double x = ((originWidth - 2) * 1.0) / ((outputWidth - 1) * 1.0) * i + 0.5;
				double y = ((originHeight - 2) * 1.0) / ((outputHeight - 1) * 1.0) * j + 0.5;

				int a = (int)x, b = (int)y;

				// the formula from wikipedia
				// x1 = a, x2 = a + 1, y1 = b, y2 = b + 1
				int fxy = (int)((b + 1 - y) * ((a + 1 - x) * originImage[a][b] + (x - a) * originImage[a + 1][b]) + 
						(y - b) * ((a + 1 - x) * originImage[a][b + 1] + (x - a) * originImage[a + 1][b + 1]));
				outputImage[i][j]= fxy;
			}
		return outputImage;
	}
	
	public int[][] quantize(int[][] originImage, int level) {
		int width = originImage.length;
		int height = originImage[0].length;
		int[][] quantizedImage = new int[width][height];
		// the distance from each level
		int d = 255 / (level - 1);
		
		for (int j = 0; j < height; j++)
			for (int i = 0; i < width; i++) {
				int transfer = originImage[i][j] / d;
				double ratio = ((double)originImage[i][j] - transfer * d) / d;
				if (ratio > 0.4) {
					quantizedImage[i][j] = (transfer + 1) * d;
					if (quantizedImage[i][j] > 255)
						quantizedImage[i][j] = 255;
				}
				else {
					quantizedImage[i][j] = transfer * d;
				}
				
			}
		return quantizedImage;
	}

}
