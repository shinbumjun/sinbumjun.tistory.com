package test.date;

import java.util.Random;

public class bong {

	public static void main(String[] args) {

	    // int[][] data;
	    // 2�� ����, �߰�ȣ ���
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

	    			// ��� �������� Ư���� �ľ�(��)
	    		    up = (i-1 > 0) ? data[i-1][j] : 0;
	    		    down = (i+1 > 0) ? data[i+1][j] : 0;
	    		    left = (j-1 > 0)?data[i][j-1] : 0;
	    		    right = (j+1 > 0)?data[i][j+1] : 0;
	    			
	    		    System.out.println("�� => " + up);
	    		    System.out.println("�� => " + down);
	    		    System.out.println("�� => " + left);
	    		    System.out.println("�� => " + right);
	    			
//	    		    dUp = (data[i][j] > up) ? true : false;
	    		    
	    			// exception ó�� ����
//	    			int up, down, left, right;
//	    			up = data[i-1][j];
//	    			down = data[i+1][j];
	    			
	    			// 2�� ã�ƶ� �� ��° ���� �� ��° ���� �ִ��� 
	    		    // ��) 2 => (0, 3)
//	    			System.out.println("�� => " + "("+ (i-1) + "," + j + ")");
//	    			System.out.println("�� => " + "("+ (i+1) + "," + j + ")");
//	    			System.out.println("�� => " + "("+ i + "," + (j-1) + ")");
//	    			System.out.println("�� => " + "("+ i + "," + (j+1) + ")");
	    			
	    			break outer; // �ϳ��� ã��
	    		}
	    	}
	    }
	    
	    // ***������ �˰���
	    System.out.println();
	    Random rand = new Random(); // ������ ���� �ֱ� ���ؼ�
	    int size = 7; // ��� ���� ũ��
	    
	    int[][] grid = new int[size][size];
	    
	    for (int i = 0; i < size; i++) {
	        for (int j = 0; j < size; j++) {
	        	
	        	// �ܰ� 0���� ä���
	        	if(i == 0 || i == size-1 || j == 0 || j == size-1) {
	        		grid[i][j] = 0;
	        	}else {
	        	
	        	int value = rand.nextInt(9) + 1; // 1~9 ������ ���� ��
        		boolean isValid = true;
        		
				// �����¿� ���� ������ Ȯ��
    			if (i > 0 && grid[i - 1][j] == value) 
    				isValid = false; // ��
		      	if (i < size-1 && grid[i + 1][j] == value) 
		      		isValid = false; // �Ʒ�
		      	if (j > 0 && grid[i][j - 1] == value) 
		      		isValid = false; // ����
		      	if (j < size-1 && grid[i][j + 1] == value) 
		      		isValid = false; // ������
	        	
	    		    // ���� ���޾� �ö��� ���Ӱ� ���� ä�� �־�� �Ѵ�
			      	while(!isValid) {  	
		        		value = rand.nextInt(9) + 1; // 1~9 ������ ���� ��
		        		isValid = true;
		        		// �����¿� ���� ������ Ȯ��
		    			if (i > 0 && grid[i - 1][j] == value) 
		    				isValid = false; // ��
				      	if (i < size-1 && grid[i + 1][j] == value) 
				      		isValid = false; // �Ʒ�
				      	if (j > 0 && grid[i][j - 1] == value) 
				      		isValid = false; // ����
				      	if (j < size-1 && grid[i][j + 1] == value) 
				      		isValid = false; // ������
			      	}
		      	grid[i][j] = value;
	        	}
	        }
	    }
	    
	    // ����ϱ�
	    for (int i = 0; i < size; i++) {
	        for (int j = 0; j < size; j++) {
	        	System.out.print(grid[i][j]);
	        }System.out.println();
	    }
	    
	    // �����¿쿡�� ���� ū ������ ã��
	    int bong = 0;
	    for (int i = 0; i < size; i++) {
	        for (int j = 0; j < size; j++) {
	        	bong = grid[i][j];
	        	if(!(i == 0 || i == size-1 || j == 0 || j == size-1)) {
	        		if(bong > grid[i - 1][j] && bong > grid[i + 1][j] && bong > grid[i][j - 1] && bong > grid[i][j + 1]) {
	        			System.out.println("�������� ��ġ" + "[" + i + "]" + "[" + j + "]" + " ���ڴ� " + bong + "�Դϴ�" );
	        		}
	        	}
	        }
	    }
	}
}
	    