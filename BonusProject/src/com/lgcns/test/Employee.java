package com.lgcns.test;

public abstract class Employee {
    private String name;
    private int number;
    private String department; // 부서
    private int salary; // 월급

    public Employee() {} // 기본 생성자

    public Employee(String name, int number, String department, int salary) {
        super();
        this.name = name;
        this.number = number;
        this.department = department;
        this.salary = salary;
    }

    public abstract double tax(); // 세금

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((department == null) ? 0 : department.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + number;
        result = prime * result + salary;
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
        Employee other = (Employee) obj;
        if (department == null) {
            if (other.department != null)
                return false;
        } else if (!department.equals(other.department))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (number != other.number)
            return false;
        if (salary != other.salary)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "name=" + name + ", number=" + number + ", department=" + department + ", salary=" + salary;
    }
}
