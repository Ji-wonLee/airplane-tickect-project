package Pro;

import java.util.Scanner;

/**
 * 추가 요금이 발생되는 서비스들 위탁수화물, 기내식, 좌석선택, 여행자보험
 * 
 * @author kitri
 *
 */
public class Service {
	public final double CABIN_BAGGAGE_COST_PER_KG = 6000;
	public final double MEAL_COST = 15000;
	public final double SEAT_SELECTION_COST = 10000;
	public final double TRAVEL_INSURANCE_COST = 30000;

	private double cabinBaggageFee;
	private double mealCost;
	private double seatSelectionCost;
	private double travelInsuranceCost;

	public void selectAdditionalServices(User user) {
		Scanner scanner = new Scanner(System.in);

		boolean isCompleted = false;

		while (!isCompleted) {
			System.out.println();
			System.out.println("<< 추가 서비스 선택 >>");
			System.out.println("1. 위탁수하물");
			System.out.println("2. 기내식");
			System.out.println("3. 좌석 선택");
			System.out.println("4. 여행자 보험");
			System.out.println("5. 완료");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				cabinBaggage(user);
				break;
			case 2:
				airplaneFood();
				break;
			case 3:
				selectSeat();
				break;
			case 4:
				travelInsurance();
				break;
			case 5:
				System.out.println("서비스 선택이 완료되었습니다.");
				isCompleted = true;
				break;
			default:
				System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
				break; // 추가된 부분
			}
		}
	}

	public void cabinBaggage(User user) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("위탁수하물 무게를 입력하세요 (kg): ");
		double weight = scanner.nextDouble();

		if (weight > 15) {
			double cabinBaggageFee = (weight - 15) * CABIN_BAGGAGE_COST_PER_KG;
			user.setCabinBaggageFee(cabinBaggageFee);
			System.out.println("추가 요금: " + cabinBaggageFee + "원");
		} else {
			System.out.println("추가 요금 없음");
		}
	}

	public void airplaneFood() {
		mealCost = MEAL_COST;
		System.out.println("기내식을 추가했습니다. 비용: " + mealCost + "원");
	}

	public void selectSeat() {
		seatSelectionCost = SEAT_SELECTION_COST;
		System.out.println("좌석을 선택했습니다. 비용: " + seatSelectionCost + "원");
	}

	private void travelInsurance() {
		travelInsuranceCost = TRAVEL_INSURANCE_COST;
		System.out.println("여행자 보험을 선택했습니다. 비용: " + travelInsuranceCost + "원");
	}
}
