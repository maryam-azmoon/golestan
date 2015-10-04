import javax.swing.SwingUtilities;
import adminview.MainAdminFrame;

public class GolestanMain {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new MainAdminFrame();
				
			}
			
		});
		
	}

}
