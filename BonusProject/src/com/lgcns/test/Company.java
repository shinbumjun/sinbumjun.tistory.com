package com.lgcns.test;

import java.util.HashMap;

public class Company {
    
    public static void main(String[] args) {
        HashMap<Integer, Employee> map = new HashMap<>();

        // 1번의 데이터를 기반으로 객체를 생성하여 HashMap에 넣는다.
        Employee emp1 = new Secretary("Hilery", 1, "secretary", 800);
        Employee emp2 = new Sales("Clinten", 2, "sales", 1200);
        
        // HashMap에 넣을 때 키 값은 각 객체의 Number로 한다.
        map.put(emp1.getNumber(), emp1);
        map.put(emp2.getNumber(), emp2);
        
        // 모든 객체의 기본 정보를 출력한다 (for문을 이용하여 출력한다).
        System.out.println("name department salary");
        System.out.println("------------------------------------");
        for (Employee e : map.values()) {
            System.out.println(e.getName() + " " + e.getDepartment() + " " + e.getSalary());
        }
        
        System.out.println("인센티브 100 지급");

        // 모든 객체에 인센티브 100씩 지급하고 다시 HashMap에 넣는다
        for (Employee e : map.values()) {
            if (e instanceof Bonus) {
                ((Bonus) e).incentive(100);
            }
        }
        
        // 모든 객체의 정보와 세금을 출력한다 (for문을 이용하여)
        System.out.println("name department salary tax");
        System.out.println("----------------------------------------------");
        for (Employee e : map.values()) {
            System.out.println(e.getName() + " " + e.getDepartment() + " " + e.getSalary() + " " + e.tax());
        }
    }
}
