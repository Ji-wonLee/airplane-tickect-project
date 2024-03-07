package Pro_sad;

import java.util.Scanner;

/**
 * 본격적인 예매 창
 * 
 * 
 * @author kitri
 */
public class ReservationMenu {

	private User user = new User();
	private Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		System.out.println("<< 출발지 >>");
		System.out.print("1. 인천공항\n2. 김포공항");

		System.out.println("<< 도착지 >>");
		System.out.print("1. 일본		2.미국");

		System.out.println("<< 예매 날짜 >>");
		System.out.println("");

		System.out.println(" << 인원수 >> ");
		System.out.print("인원수 입력 : ");

	}

	/**
	 * 항공권 검색
	 */
	public void searchFlights() {

	}

	/**
	 * 전체 금액
	 */
	public void displayReceipt() {

	}

	/**
	 * 기내식 고르기
	 */
	public void airplaneFood() {

	}

	/**
	 * 좌석 고르기
	 */
	public void selectSeat() {

	}

	/**
	 * 위탁수하물
	 */
	public void cabbinBaggage() {

	}

	/**
	 * 여행자보험
	 */
	public void travelInsurance() {

	}
}
