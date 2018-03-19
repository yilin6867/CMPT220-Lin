
class Marist {
	private int tuition;
	private int roomAndBoard;
	private int bookAndSupplies;
	private int personalMiscellaneous;
	public Marist(int tuition, int roomAndBoard, int bookAndSupplies,
			int personalMiscellaneous) {
		this.tuition = tuition;
		this.roomAndBoard = roomAndBoard;
		this.bookAndSupplies = bookAndSupplies;
		this.personalMiscellaneous = personalMiscellaneous;
	}
	Marist() {
	}
	public int getTuition() {
		return tuition;
	}
	public void setTuition(int tuition) {
		this.tuition = tuition;
	}
	public int getRoomAndBoard() {
		return roomAndBoard;
	}
	public void setRoomAndBoard(int roomAndBoard) {
		this.roomAndBoard = roomAndBoard;
	}
	public int getBookAndSupplies() {
		return bookAndSupplies;
	}
	public void setBookAndSupplies(int bookAndSupplies) {
		this.bookAndSupplies = bookAndSupplies;
	}
	public int getPersonalMiscellaneous() {
		return personalMiscellaneous;
	}
	public void setPersonalMiscellaneous(int personalMiscellaneous) {
		this.personalMiscellaneous = personalMiscellaneous;
	}
	public int costOfAttendent() {
		return tuition + roomAndBoard + bookAndSupplies + personalMiscellaneous;
	}
	public double requireGPAMeritScholarship() {
		return 2.85;
	}
}