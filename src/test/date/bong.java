package test.date;

import java.util.Random;

public class bong {

	public static void main(String[] args) {

	    // int[][] data;
	    // 2차 베열, 중괄호 사용
	    int [][] data = 
	    	{
	    			{5, 3, 7, 2, 3},
	    			{3, 7, 1, 6, 1},
	    			{7, 2, 5, 3, 4},
	    			{4, 3, 6, 4, 1},
	    			{8, 7, 3, 5, 2}
	    	};
	    
	    int up, down, left, right;
//	    boolean dUp, dDown, dLeft, dRight;
	    
	    outer:
	    for(int i = 0; i<data.length; i++) {
	    	for(int j = 0; j<data.length; j++) {
	    		if(data[i][j] == 2) {
	    			System.out.println("2 => " + "("+ i + "," + j + ")");

	    			// 모든 데이터의 특성을 파악(비교)
	    		    up = (i-1 > 0) ? data[i-1][j] : 0;
	    		    down = (i+1 > 0) ? data[i+1][j] : 0;
	    		    left = (j-1 > 0)?data[i][j-1] : 0;
	    		    right = (j+1 > 0)?data[i][j+1] : 0;
	    			
	    		    System.out.println("상 => " + up);
	    		    System.out.println("하 => " + down);
	    		    System.out.println("좌 => " + left);
	    		    System.out.println("우 => " + right);
	    			
//	    		    dUp = (data[i][j] > up) ? true : false;
	    		    
	    			// exception 처리 사용시
//	    			int up, down, left, right;
//	    			up = data[i-1][j];
//	    			down = data[i+1][j];
	    			
	    			// 2를 찾아라 몇 번째 행의 몇 번째 열에 있는지 
	    		    // 예) 2 => (0, 3)
//	    			System.out.println("상 => " + "("+ (i-1) + "," + j + ")");
//	    			System.out.println("하 => " + "("+ (i+1) + "," + j + ")");
//	    			System.out.println("좌 => " + "("+ i + "," + (j-1) + ")");
//	    			System.out.println("우 => " + "("+ i + "," + (j+1) + ")");
	    			
	    			break outer; // 하나만 찾기
	    		}
	    	}
	    }
	    
	    // ***봉오리 알고리즘
	    System.out.println();
	    Random rand = new Random(); // 랜덤한 값을 주기 위해서
	    int size = 7; // 행과 열의 크기
	    
	    int[][] grid = new int[size][size];
	    
	    for (int i = 0; i < size; i++) {
	        for (int j = 0; j < size; j++) {
	        	
	        	// 외곽 0으로 채우기
	        	if(i == 0 || i == size-1 || j == 0 || j == size-1) {
	        		grid[i][j] = 0;
	        	}else {
	        	
	        	int value = rand.nextInt(9) + 1; // 1~9 사이의 랜덤 값
        		boolean isValid = true;
        		
				// 상하좌우 값이 같은지 확인
    			if (i > 0 && grid[i - 1][j] == value) 
    				isValid = false; // 위
		      	if (i < size-1 && grid[i + 1][j] == value) 
		      		isValid = false; // 아래
		      	if (j > 0 && grid[i][j - 1] == value) 
		      		isValid = false; // 왼쪽
		      	if (j < size-1 && grid[i][j + 1] == value) 
		      		isValid = false; // 오른쪽
	        	
	    		    // 값이 연달아 올때는 새롭게 값을 채워 넣어야 한다
			      	while(!isValid) {  	
		        		value = rand.nextInt(9) + 1; // 1~9 사이의 랜덤 값
		        		isValid = true;
		        		// 상하좌우 값이 같은지 확인
		    			if (i > 0 && grid[i - 1][j] == value) 
		    				isValid = false; // 위
				      	if (i < size-1 && grid[i + 1][j] == value) 
				      		isValid = false; // 아래
				      	if (j > 0 && grid[i][j - 1] == value) 
				      		isValid = false; // 왼쪽
				      	if (j < size-1 && grid[i][j + 1] == value) 
				      		isValid = false; // 오른쪽
			      	}
		      	grid[i][j] = value;
	        	}
	        }
	    }
	    
	    // 출력하기
	    for (int i = 0; i < size; i++) {
	        for (int j = 0; j < size; j++) {
	        	System.out.print(grid[i][j]);
	        }System.out.println();
	    }
	    
	    // 상하좌우에서 제일 큰 봉오리 찾기
	    int bong = 0;
	    for (int i = 0; i < size; i++) {
	        for (int j = 0; j < size; j++) {
	        	bong = grid[i][j];
	        	if(!(i == 0 || i == size-1 || j == 0 || j == size-1)) {
	        		if(bong > grid[i - 1][j] && bong > grid[i + 1][j] && bong > grid[i][j - 1] && bong > grid[i][j + 1]) {
	        			System.out.println("봉오리는 위치" + "[" + i + "]" + "[" + j + "]" + " 숫자는 " + bong + "입니다" );
	        		}
	        	}
	        }
	    }
	}
}
	    