package Pro;

public class MainApp {
	public static void main(String[] args) {
		// 사용자 정보 초기화
		User[] users = new User[10];
		Login loginSystem = new Login(users);



		while(true) {
			// 로그인 시도
			loginSystem.performLogin();

			// 로그인한 사용자 정보 가져오기
			User loggedInUser = loginSystem.getLoggedInUser();

			// 로그인 후 메뉴 또는 다른 동작 수행
			if (loggedInUser != null) {
				System.out.println("로그인된 사용자: " + loggedInUser.getUserID());

				// 항공편 초기화
				Airplane.initializeAirplaneList();

				// 예약 메뉴 실행
				ReservationMenu reservationMenu = new ReservationMenu(loggedInUser);
				reservationMenu.mainMenu();
				return;
			} else {
				System.out.println("로그인에 실패하였습니다.");
			}
		}
	}
}