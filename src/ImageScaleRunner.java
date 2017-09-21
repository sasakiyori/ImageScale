
public class ImageScaleRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImageScale imageScale = new ImageScale();
		// 2.2 first problem
		imageScale.printImage(imageScale.scale(imageScale.getImage(), 192, 128), "scale");
		imageScale.printImage(imageScale.scale(imageScale.getImage(), 96, 64), "scale");
		imageScale.printImage(imageScale.scale(imageScale.getImage(), 48, 32), "scale");
		imageScale.printImage(imageScale.scale(imageScale.getImage(), 24, 16), "scale");
		imageScale.printImage(imageScale.scale(imageScale.getImage(), 12, 8), "scale");
		// 2.2 second problem
		imageScale.printImage(imageScale.scale(imageScale.getImage(), 300, 200), "scale");
		// 2.2 third problem
		imageScale.printImage(imageScale.scale(imageScale.getImage(), 450, 300), "scale");
		// 2.2 fourth problem
		imageScale.printImage(imageScale.scale(imageScale.getImage(), 500, 200), "scale");
		
		// 2.3
		imageScale.printImage(imageScale.quantize(imageScale.getImage(), 128), "quantize128");
		imageScale.printImage(imageScale.quantize(imageScale.getImage(), 32), "quantize32");
		imageScale.printImage(imageScale.quantize(imageScale.getImage(), 8), "quantize8");
		imageScale.printImage(imageScale.quantize(imageScale.getImage(), 4), "quantize4");
		imageScale.printImage(imageScale.quantize(imageScale.getImage(), 2), "quantize2");
	}
}
