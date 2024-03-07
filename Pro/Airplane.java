package Pro;

import java.time.LocalDateTime;

/**
 * 항공편 정보가 담긴 클래스
 * 
 * ZoneId vs ZoneOffset
 * 
 * ZoneId : 타임존
 * 
 * - 시간차이를 타임존 코드로 표현
 * 
 * ZoneOffset : 시차
 * 
 * - UTC를 기준으로 조정된 시간차이를 양수나 음수로 표현
 * 
 * @author kitri
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Airplane {		
	private String flightNum;		// 항공편명
	private String departure; 		// 출발지
	private String destination; 	// 목적지
	private String departureTime; 	// 출발현지시간
	private String arrivalTime; 	// 도착현지시간
	private String duration; 		// 소요시간
	private int availableSeats; 	// 남은 좌석 수
	public double cabinBaggageFee; 
	private String travelDate;
	private int numberOfPassengers;

	public static List<Airplane> airplaneList = new ArrayList<>();

	public Airplane(String flightNum, String departure, String destination, String departureTime,
			String arrivalTime, String duration, int availableSeats, String travelDate) {
		this.flightNum = flightNum;
		this.departure = departure;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.duration = duration;
		this.availableSeats = availableSeats;
		this.travelDate = travelDate;
	}
	// 여행 날짜 getter
	public String getTravelDate() {
		return travelDate;
	}

	public String getFlightNum() {
		return flightNum;
	}

	public String getDeparture() {
		return departure;
	}

	public String getDestination() {
		return destination;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public String getDuration() {
		return duration;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}
	public double getCabinBaggageFee() {
		return cabinBaggageFee;
	}

	public void setCabinBaggageFee(double cabinBaggageFee) {
		this.cabinBaggageFee = cabinBaggageFee;
	}

	public static List<Airplane> getAirplaneList() {
		return airplaneList;
	}

	// 항공편 리스트 초기화 메서드
	public static void initializeAirplaneList() {
		// 리스트 초기화
		airplaneList = new ArrayList<>();

		// 일본 지역 항공편 추가
		airplaneList.add(new Airplane("KR101", "서울/인천(ICH)", "오사카/간사이(KIX)", "2024-01-20 08:00", "2024-01-20 09:45", "1h45m", 50,"2024-01-20"));
		airplaneList.add(new Airplane("KR102", "서울/인천(ICH)", "오사카/간사이(KIX)", "2024-01-21 08:55", "2024-01-21 10:50", "1h55m", 30,"2024-01-21"));
		airplaneList.add(new Airplane("KR201", "서울/김포(GMP)", "도쿄/하네다(HND)", "2024-01-22 10:00", "2024-01-22 13:30", "2h30m", 40,"2024-01-22"));
		airplaneList.add(new Airplane("KR1101", "서울/인천(ICH)", "도쿄/하네다(HND)", "2024-02-02 11:30", "2024-02-02 14:00", "2h30m", 25,"2024-02-02"));

		// 대만 지역 항공편 추가
		airplaneList.add(new Airplane("KR501", "서울/김포(GMP)", "타이베이/송산(TPE)", "2024-01-25 09:30", "2024-01-25 12:15", "2h45m", 20,"2024-01-25"));
		airplaneList.add(new Airplane("KR1301", "서울/인천(ICH)", "타이베이/송산(TPE)", "2024-02-04 10:45", "2024-02-04 13:30", "3h45m", 15,"2024-02-04"));

		// 싱가포르 지역 항공편 추가
		airplaneList.add(new Airplane("KR801", "서울/인천(ICH)", "싱가포르/창이(WSSS)", "2024-01-28 13:45", "2024-01-28 17:15", "3h30m", 50, "2024-01-28"));
		airplaneList.add(new Airplane("KR1001", "서울/김포(GMP)", "싱가포르/창이(WSSS)", "2024-02-01 09:00", "2024-02-01 12:30", "4h30m", 40, "2024-02-01"));
	}


	// 남은 좌석 업데이트 메서드
	public void updateAvailableSeats(int bookedSeats) {
		availableSeats -= bookedSeats;
	}

	public void displayInfo() {
		System.out.println("항공편 정보 출력 로직"); 
	}

	/**
	 * 항공편 검색
	 * @param departure
	 * @param destination
	 * @param travelDate
	 * @return
	 */
	public static List<Airplane> getAvailableFlights(String departure, String destination, String travelDate) {
		List<Airplane> availableFlights = new ArrayList<>();

		for (Airplane airplane : airplaneList) {
			if (airplane.getDeparture().equals(departure)
					&& airplane.getDestination().equals(destination)
					&& airplane.getTravelDate().equals(travelDate)) {
				availableFlights.add(airplane);
				System.out.println(availableFlights);
			}
		}
		return availableFlights;
	}

	public double getCABIN_BAGGAGE_COST_PER_KG(double weight) {
		// 1kg당 비용
		double costPerKg = 6000.0;

		// 추가 비용 계산 (무게가 15kg를 초과하는 경우에만)
		if (weight > 15) {
			double additionalWeight = weight - 15;
			return 15 * costPerKg + additionalWeight * costPerKg * 1.5;  // 15kg까지는 기본 비용, 그 이후는 추가 비용 적용
		} else {
			return weight * costPerKg;  // 15kg 이하인 경우에는 무게에 따른 기본 비용만 적용
		}
	}
	//	// 여행 날짜, 인원수 등 입력 메서드
	//	public static void inputTravelDetails() {
	//		Scanner scanner = new Scanner(System.in);
	//
	//		System.out.print("여행 날짜를 입력하세요: ");
	//		this.travelDate = scanner.nextLine();
	//
	//		System.out.print("여행 인원 수를 입력하세요: ");
	//		this.numberOfPassengers = scanner.nextInt();
	//	}
}
