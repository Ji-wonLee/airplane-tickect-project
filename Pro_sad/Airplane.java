package Pro_sad;

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
public class Airplane {
	String flightNum; // 항공편명
	String departure; // 출발지
	String destination; // 목적지
	String departureTime;// 출발현지시간
	String arrivalTime; // 도착현지시간
	String duration; // 소요시간
	private Airplane[] airArr = new Airplane[10];

	public Airplane() {
		airArr[0] = new Airplane("KR101", "서울/인천(ICH)","오사카/간사이(KIX)", "8:00", "9:45", "1h45m" );
		airArr[1] = new Airplane("KR102", "서울/인천(ICH)","오사카/간사이(KIX)", "8:55", "10:50", "1h55m" );
		airArr[2] = new Airplane("KR103", "서울/인천(ICH)","오사카/간사이(KIX)", "14:05", "16:00", "1h55m" );
		airArr[3] = new Airplane("KR104", "서울/인천(ICH)","삿포로(CTS)", "8:35", "11:15", "2h40m" );
		airArr[4] = new Airplane("KR105", "서울/인천(ICH)","삿포로(CTS)", "12:45", "15:40", "2h55m" );
		airArr[5] = new Airplane("KR106", "서울/인천(ICH)","후쿠오카(FUK)", "06:50", "08:10", "1h20m" );
		airArr[6] = new Airplane("KR107", "서울/인천(ICH)","후쿠오카(FUK)", "12:00", "13:20", "2h55m" );
		airArr[7] = new Airplane("KR108", "서울/인천(ICH)","후쿠오카(FUK)", "12:45", "15:40", "2h55m" );
		airArr[8] = new Airplane("KR109", "서울/인천(ICH)","삿포로(CTS)", "12:45", "15:40", "2h55m" );
		
		
		
	}

	/**
	 * 비행기 항공편 정보
	 * 
	 * @param flightNum
	 * @param departure
	 * @param destination
	 * @param departureTime
	 * @param arrivalTime
	 */
	public Airplane(String flightNum, String departure, String destination, String departureTime,
			String arrivalTime, String duration) {
		this.flightNum = flightNum;
		this.departure = departure;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

}
