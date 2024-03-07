package Pro_sad;

import javax.swing.SwingUtilities;

public class MainApp {

	public static void main(String[] args) {
		 User user = new User();
		 SwingUtilities.invokeLater(() -> new Login(user.userArr));
	}
}