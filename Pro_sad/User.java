package Pro_sad;

/**
 * 회원들 정보가 있는 클래스
 * 
 * @author kitri
 *
 */
public class User {

	private String userID; // 아이디
	private String passWord; // 비번
	private String address; // 주소
	private String name; // 이름
	private String passPortNumber; // 여권번호
	private String phoneNumber; // 전화번호
	private String birth;   // 생년월일
	public User[] userArr = new User[10]; // 실제 고객들 수는 많겠지만....
											// 구현하기 힘드므로 10명의 고객이 있다고 가정

	/**
	 * 유저들 정보를 여기에 저장. 추후 로그인할 때 여기에 없는 회원이거나 ID or passWord가 다르다면 로그인이 안되게 할 것
	 */
	public User() {
		userArr[0] = new User("jiwon11", "q12345", "서울", "이지원", "M0001", "01013571357", "2002.09.06");
		userArr[1] = new User("yeun11", "cutetori", "서울", "나예은", "M0002", "01024682468", "2001.12.28");
		userArr[2] = new User("user2ID", "user2PW", "부산", "user2Name", "M0003", "01033334444", "1995.05.15");
		userArr[3] = new User("user3ID", "user3PW", "대전", "user3Name", "M0004", "01055556666", "1988.11.23");
		userArr[4] = new User("user4ID", "user4PW", "대구", "user4Name", "M0005", "01077778888", "2000.02.08");
		userArr[5] = new User("user5ID", "user5PW", "울산", "user5Name", "M0006", "01099990000", "1993.07.31");
		userArr[6] = new User("user6ID", "user6PW", "제주", "user6Name", "M0007", "01012341234", "1998.04.19");
		userArr[7] = new User("user7ID", "user7PW", "세종", "user7Name", "M0008", "01056785678", "1985.09.02");
		userArr[8] = new User("user8ID", "user8PW", "속초", "user8Name", "M0009", "01098769876", "1991.12.10");
		userArr[9] = new User("user9ID", "user9PW", "서울", "user9Name", "M0010", "01011112222", "1976.03.28");
	}

	public User(String userID, String passWord, String address, String name, String passPortNumber, String phoneNumber,
			String birth) {
		this.userID = userID;
		this.passWord = passWord;
		this.address = address;
		this.name = name;
		this.passPortNumber = passPortNumber;
		this.phoneNumber = phoneNumber;
		this.birth = birth;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassPortNumber() {
		return passPortNumber;
	}

	public void setPassPortNumber(String passPortNumber) {
		this.passPortNumber = passPortNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirthday(String birthday) {
		this.birth = birthday;
	}

}
