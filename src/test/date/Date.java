package test.date;

public class Date {

	private int year=1900;
	private int month = 1;
	private int day = 1;
	private int[] lastOfMonth
		= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
//	public Date(int y, int m, int d) {
//		year = y;	month = m; this.day = d;
//	}
	public Date() {
		// 객체 초기화
		year=1900;   month = 1;   day = 1;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	public Date(int year, int month, int day) throws Exception {
	super();
	this.setYear(year);
	this.setMonth(month);
	this.setDay(day);
}
	@Override
	public String toString() {
		StringBuilder sb;
		
		//return getYear()+"년" + getMonth() + "월" + getDay() + "일";
		return new StringBuffer().append(year).append("년")
											.append(month).append("월")
											.append(day).append("일").toString();
	}
	public void print() { //	System.out.print("내 생일은 ");	System.out.println(toString());
		System.out.println(this);
	}
	private void setLeapYear()
	{	if((year % 4) == 0) {
			lastOfMonth[1] = 29;
			if((year % 100) == 0) {
				lastOfMonth[1] = 28;
				if((year % 400) == 0) {
					lastOfMonth[1] = 29;
				}		
			}		
		}else {
			lastOfMonth[1] = 28;
		}
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year){
		this.year = year;
		setLeapYear();
		if ((month == 2)&&(day > lastOfMonth[month-1])) {
			try {
				setDay(lastOfMonth[month-1]);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month){
		if (1>month) {
			month = 1;
		}
		if (12 < month) {
			month = 12;
		}
		this.month = month;
		try {
			setDay(day);
		} catch (Exception e) {
			//1월 -> 2월, setDay() - 2월의 마지막 날짜보다 day가 큰 경우임.
			// 월이 바뀔 경우 day과 lastOfMonth[month-1] 값을 비교해서
			// day값이 클 경우 last값으로 변경...
			if (day > lastOfMonth[month-1]) {
				try {
					setDay(lastOfMonth[month-1]);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
//			e.printStackTrace();
		}
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) throws Exception {
		if ((1>day)||(lastOfMonth[month-1] < day)) {
			throw new Exception(month + "월의 날짜는 1 이상" 
							+ lastOfMonth[month-1] +" 이하의 값만 넣을 수 있습니다.");
		}
		this.day = day;
	}
	public void setLastDay(int month) {
		try {
			setDay(lastOfMonth[month-1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}



