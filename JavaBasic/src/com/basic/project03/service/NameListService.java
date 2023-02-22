package com.basic.project03.service;

import com.basic.project03.domain.*;

import static com.basic.project03.service.Data.*;

public class NameListService {

    private final Employee[] employees;

    public NameListService() {
    /*
        根据项目提供的Data类构建相应大小的employees数组
        再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
        将对象存于数组中
        Data类位于service包中
     */
        employees = new Employee[EMPLOYEES.length];
        for (int i = 0; i < employees.length; i++) {
            // 获取员工类型
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            // 获取基本数据
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Integer.parseInt(EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;
            int stock;
            switch (type) {
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    equipment = creatEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case DESIGNER:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case ARCHITECT:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;
            }
        }
    }

    // 获取指定index的员工的设备
    private Equipment creatEquipment(int index) {
        int type = Integer.parseInt(EQUIPMENTS[index][0]);
        switch (type) {
            case PC:
                return new PC(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
            case NOTEBOOK:
                return new NoteBook(EQUIPMENTS[index][1], Double.parseDouble(EQUIPMENTS[index][2]));
            case PRINTER:
                return new Printer(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
        }
        return null;
    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException {
        /*
            参数：指定员工的ID
            返回：指定员工对象
            异常：找不到指定的员工
         */
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        throw new TeamException("找不到指定的员工");
    }
}
