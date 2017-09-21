
public class ImageScaleRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImageScale imageScale = new ImageScale();
		// first problem
		//imageScale.printImage(imageScale.scale(imageScale.getImage(), 192, 128));
		//imageScale.printImage(imageScale.scale(imageScale.getImage(), 96, 64));
		//imageScale.printImage(imageScale.scale(imageScale.getImage(), 48, 32));
		//imageScale.printImage(imageScale.scale(imageScale.getImage(), 24, 16));
		imageScale.printImage(imageScale.scale(imageScale.getImage(), 400, 300));
	}
}
