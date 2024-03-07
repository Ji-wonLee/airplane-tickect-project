package Pro_sad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 로그인하는 클래스
 * 
 * @author kitri
 *
 */
public class Login extends JFrame {

	private JTextField jtf1;
	private JPasswordField jtf2;
	private JButton jLogin;

	private User[] users; // 고객들 정보

	public Login(User[] users) {
		this.users = users;

		setTitle("로그인 화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		JLabel label1 = new JLabel("아이디:");
		JLabel label2 = new JLabel("비밀번호:");

		jtf1 = new JTextField(15);
		jtf2 = new JPasswordField(15);

		jLogin = new JButton("로그인");

		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(label1, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(jtf1, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(label2, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(jtf2, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(jLogin, gbc);

		jLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String enteredId = jtf1.getText();
				String enteredPwd = new String(jtf2.getPassword());

				if (isValidUser(enteredId, enteredPwd)) {
					JOptionPane.showMessageDialog(null, "로그인 성공!");
					dispose(); // 로그인 성공 시 로그인 창 닫기
					// 여기에서 메인 메뉴 창 등을 열 수 있습니다.
				} else {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 잘못되었습니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private boolean isValidUser(String enteredId, String enteredPwd) {
		for (User user : users) {
			if (user != null && user.getUserID().equals(enteredId) && user.getPassWord().equals(enteredPwd)) {
				return true;
			}
		}
		return false;
	}

}
