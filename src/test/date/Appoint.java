package test.date;

public class Appoint extends Date {
	private String subject;

	public Appoint() {
		super();
		subject = "쉬는날";
	}
// 부모의 생성자가 throws를 한 상태이고, 자시그이 생성자가 부모 생성자를 호출해야 함
	public Appoint(String subject, int year, int month, int day) throws Exception {
		super(year, month, day);
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String toString() {
		return "약속[" + subject + "]\n" +super.toString()+"--------------";
	}
}















