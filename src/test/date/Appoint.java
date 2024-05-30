package test.date;

public class Appoint extends Date {
	private String subject;

	public Appoint() {
		super();
		subject = "���³�";
	}
// �θ��� �����ڰ� throws�� �� �����̰�, �ڽñ��� �����ڰ� �θ� �����ڸ� ȣ���ؾ� ��
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
		return "���[" + subject + "]\n" +super.toString()+"--------------";
	}
}















