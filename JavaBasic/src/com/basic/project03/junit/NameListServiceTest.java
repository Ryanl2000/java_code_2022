package com.basic.project03.junit;

import com.basic.project03.domain.Employee;
import com.basic.project03.service.NameListService;
import com.basic.project03.service.TeamException;
import org.junit.Test;

public class NameListServiceTest {

    @Test
    public void testGetAllEmployees() {
        NameListService nameListService = new NameListService();
        Employee[] employees = nameListService.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployee() {
        NameListService nameListService = new NameListService();
        int id = 100;
        try {
            Employee employee = nameListService.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());;
        }

    }
}
