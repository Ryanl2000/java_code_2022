package com.basic.project03.view;

import com.basic.project03.domain.*;
import com.basic.project03.service.*;

public class TeamView {

    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public void enterMainMenu() {

        boolean loopFlag = true;
        char menu = 0;
        while (loopFlag) {
            if (menu != '1') {
                listAllEmployees();
            }
            System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4)：");
            menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("是否确认退出(Y/N)：");
                    char exit = TSUtility.readConfirmSelection();
                    if (exit == 'Y') {
                        loopFlag = false;
                    }
                    break;
            }
        }
    }

    // 显示所有员工信息
    private void listAllEmployees() {
        System.out.println("****************************开发团队调度软件****************************");
        System.out.println();
        System.out.println("ID\t姓名\t年龄  工资\t职位\t状态\t奖金\t股票\t领用设备");

        Employee[] employees = listSvc.getAllEmployees();
        if (employees == null || employees.length == 0) {
            System.out.println("公司中没有任何员工信息");
        } else {
            for (int i = 0; i < employees.length; i++) {
                System.out.println(employees[i]);
            }
        }
        System.out.println("**********************************************************************");
    }

    private void getTeam() {
        System.out.println("******************************团队成员列表******************************");
        Programmer[] team = teamSvc.getTeam();
        if (team == null || team.length == 0) {
            System.out.println("没有团队成员");
        } else {
            System.out.println("TID/ID\t姓名\t年龄  工资\t职位\t奖金\t股票");
            for (int i = 0; i < team.length; i++) {
                System.out.println(team[i].getDetailsForTeam());
            }
        }
        System.out.println("**********************************************************************");
    }

    private void addMember() {
        System.out.println("********************************添加成员*******************************");
        System.out.println("请输入要添加成员的ID：");
        int add = TSUtility.readInt();
        try {
            Employee employee = listSvc.getEmployee(add);
            teamSvc.addMember(employee);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        } finally {
            TSUtility.readReturn();
        }
    }

    private void deleteMember() {
        System.out.println("********************************删除成员*******************************");
        System.out.println("请输入要删除成员的TID：");
        int del = TSUtility.readInt();
        try {
            System.out.println("是否确认删除(Y/N)：");
            char isDel = TSUtility.readConfirmSelection();
            if (isDel == 'Y') {
                teamSvc.removeMember(del);
                System.out.println("删除成功");
            }
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        } finally {
            TSUtility.readReturn();
        }

    }

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }

}
