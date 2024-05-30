package test.date;

public class TestDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int y = 2002;
		int m = 2;
		int d = 14;
		System.out.println("내 생일은 " + y+"년" + m + "월" + d + "일");
		
		Date myBirth = new Date();
		// myBirth.y = 2002; myBirth.d = 140;
		try {
			myBirth.setYear(2002);
			myBirth.setMonth(2);
			myBirth.setDay(14);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("내 생일은 " + myBirth.getYear()+"년"
					+ myBirth.getMonth() + "월" + myBirth.getDay() + "일");
		
		try {
			myBirth.setDay(140);
		} catch (Exception e) {
			// exception msg : 28넘는 값은 넣을 수 없습니다.
			try {
				myBirth.setDay(28);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		System.out.println(myBirth.getDay());

		try {
			myBirth.setMonth(-100);
		} catch (Exception e2) {
			try {
				myBirth.setMonth(1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			e2.printStackTrace();
		}
		try {
			myBirth.setDay(140);
		} catch (Exception e) {
			try {
				myBirth.setDay(31);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("myBirth.setDay(31)");
				e1.printStackTrace();
			}
//			System.out.println("myBirth.setDay(140)");
//			e.printStackTrace();
		}
		System.out.println(myBirth.getDay());
		
		try {
			myBirth.setMonth(2);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println(myBirth.getDay());


		try {
			myBirth.setYear(2000);
			myBirth.setDay(140);
		} catch (Exception e1) {
			try {
				myBirth.setLastDay(myBirth.getMonth());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			e1.printStackTrace();
		}
		System.out.println(myBirth.getDay());

		try {
			myBirth.setDay(140);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			myBirth.setYear(2002);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		myBirth.print();

		Date yourBirth = null;
		try {
			yourBirth = new Date(y, m, 2000);
		} catch (Exception e) {
			try {
				yourBirth = new Date(y, m, 31);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
//			e.printStackTrace();
		}
		yourBirth.print();

		if (myBirth == yourBirth) {
			System.out.println("== : same");
		}
		if (myBirth.equals(yourBirth)) {
			System.out.println("equals() : same");
		}
		
		Appoint appoint = null;
		try {
			appoint = new Appoint("내생일", 2002, 2, 14);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		appoint.print();
		System.out.println(myBirth);
		System.out.println(appoint);
		
		System.out.println("----다형성 Polymorphsm----");
		Date[] date = new Date[3];
		date[0] = new Date();
		date[1] = new Appoint();
		date[2] = new Date();

		((Appoint) date[1]).setSubject("친구1생일");
		
		for (int i = 0; i < date.length; i++) {
			if (date[i] instanceof Appoint) {
				((Appoint) date[i]).setSubject("친구2생일");
			}
			date[i].print();
		}
	}
}







