package Pro;



import java.util.List;
import java.util.Scanner;

public class ReservationMenu {
	private User user;
	private Scanner scanner;
	private final double MEAL_COST = 15000;
	private final double SEAT_SELECTION_COST = 10000;
	private final double TRAVEL_INSURANCE_COST = 30000;

	public ReservationMenu(User user) {
		this.user = user;
		this.scanner = new Scanner(System.in);
	}

	public void mainMenu() {
		System.out.println("<< 출발지 선택 >>");
		System.out.println("1. 서울/인천(ICH)");
		System.out.println("2. 서울/김포(GMP)");

		int departureChoice = getUserChoice("출발지 선택");
		String departureAirport = getAirport(departureChoice);

		System.out.println("<< 도착지 선택 >>");
		System.out.println("1. 일본 - 오사카/간사이(KIX)");
		System.out.println("2. 일본 - 삿포로(CTS)");
		System.out.println("3. 대만 - 타이베이/송산(TPE)");
		System.out.println("4. 싱가포르/창이(WSSS)");
		System.out.println("5. 일본 - 도쿄");
		System.out.println();
		int destinationChoice = getUserChoice("도착지 선택");
		String destinationAirport = getAirport(destinationChoice);

		// 여행 날짜, 인원수 등의 정보 입력
		inputTravelDetails();

		// 선택한 출발지, 도착지에 맞는 항공편 검색 및 출력
		searchFlights(departureAirport, destinationAirport, user.getTravelDate());

		// 항공편 선택
		int selectedFlight = getUserChoice("항공편 선택");

		// 선택한 항공편의 추가 서비스 선택
		selectAdditionalServices(selectedFlight);
	}

	public void inputTravelDetails() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("여행 날짜를 입력하세요 (예: 2024-01-20): ");
		String travelDate = scanner.nextLine();
		user.setTravelDate(travelDate);

		System.out.print("여행 인원 수를 입력하세요: ");

		// nextInt() 사용 후 nextLine()으로 개행 문자 소비
		int numberOfPassengers = 0;
		if (scanner.hasNextInt()) {
			numberOfPassengers = scanner.nextInt();
			scanner.nextLine(); // 개행 문자 소비
			user.setNumberOfPassengers(numberOfPassengers);
		} else {
			System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
		}
	}

	public void searchFlights(String departure, String destination, String travelDate) {
		List<Airplane> availableFlights = Airplane.getAvailableFlights(departure, destination, travelDate);

		if (!availableFlights.isEmpty()) {
			System.out.println("예매 가능한 항공편이 없습니다.");
		} else {
			System.out.println("<< 예매 가능한 항공편 목록 >>");

			for (int i = 0; i < availableFlights.size(); i++) {
				System.out.print((i + 1) + ". ");
				availableFlights.get(i).displayInfo();
			}
		}
	}

	public void selectAdditionalServices(int selectedFlight) {
		Airplane selectedAirplane = Airplane.getAirplaneList().get(selectedFlight - 1);

		Service service = new Service();
		service.selectAdditionalServices(user);

		System.out.println("예약이 완료되었습니다. 감사합니다!");
	}

	public int getUserChoice(String message) {
		System.out.print(message + ": ");
		return scanner.nextInt();
	}

	private String getAirport(int choice) {
		switch (choice) {
		case 1:
			return "서울/인천(ICH)";
		case 2:
			return "서울/김포(GMP)";
		default:
			return "";
		}
	}
}

