package Pro;
import java.util.Scanner;

public class Login {
    private User[] users;
    private User loggedInUser;

    public Login(User[] users) {
        this.users = users;
        initializeUsers(); // 사용자 정보 초기화 추가
    }

    private void initializeUsers() {
        // 사용자 정보 초기화 
        users[0] = new User("jiwon", "q12345", "서울", "이지원", "M0001", "01013571357", "2002.09.06");
        users[1] = new User("yeun11", "cutetori", "서울", "나예은", "M0002", "01024682468", "2001.12.28");
        users[2] = new User("user2ID", "user2PW", "부산", "user2Name", "M0003", "01033334444", "1995.05.15");
        users[3] = new User("user3ID", "user3PW", "대전", "user3Name", "M0004", "01055556666", "1988.11.23");
        users[4] = new User("user4ID", "user4PW", "대구", "user4Name", "M0005", "01077778888", "2000.02.08");
        users[5] = new User("user5ID", "user5PW", "울산", "user5Name", "M0006", "01099990000", "1993.07.31");
        users[6] = new User("user6ID", "user6PW", "제주", "user6Name", "M0007", "01012341234", "1998.04.19");
        users[7] = new User("user7ID", "user7PW", "세종", "user7Name", "M0008", "01056785678", "1985.09.02");
        users[8] = new User("user8ID", "user8PW", "속초", "user8Name", "M0009", "01098769876", "1991.12.10");
        users[9] = new User("user9ID", "user9PW", "서울", "user9Name", "M0010", "01011112222", "1976.03.28");

    }

    public void performLogin() {
        Scanner scanner = new Scanner(System.in);
        boolean loginSuccess = false;

        System.out.print("아이디를 입력하세요: ");
        String enteredId = scanner.next();

        System.out.print("비밀번호를 입력하세요: ");
        String enteredPwd = scanner.next();

        loginSuccess = isValidUser(enteredId, enteredPwd);

        if (loginSuccess) {
            System.out.println("로그인 성공!");
        } else {
            System.out.println("아이디 또는 비밀번호가 잘못되었습니다.");
        }
    }

    private boolean isValidUser(String enteredId, String enteredPwd) {
        for (int i = 0; i < users.length; i++) {
            User user = users[i];
            if (user != null && enteredId.equals(user.getUserID()) && enteredPwd.equals(user.getPassWord())) {
                loggedInUser = user;
                return true;
            }
        }
        return false;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
}

