package com.basic.project03.service;

import com.basic.project03.domain.*;

public class TeamService {
    private static int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;

    public TeamService() {
    }

    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    public void addMember(Employee e) throws TeamException {

//        成员已满，无法添加
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }
//        该成员不是开发人员，无法添加
        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
//        该员工已在本开发团队中
        if (isExist(e)) {
            throw new TeamException("该员工已在本开发团队中");
        }
//        该员工已是某团队成员
//        该员正在休假，无法添加
        Programmer p = (Programmer) e;
        if (p.getStatus().equals(Status.BUSY)) {
            throw new TeamException("该员工已是某团队成员");
        } else if (p.getStatus().equals(Status.VACATION)) {
            throw new TeamException("该员正在休假，无法添加");
        }
//        团队中至多只能有一名架构师
//        团队中至多只能有两名设计师
//        团队中至多只能有三名程序员
        int numOfArchitect = 0, numOfDesigner = 0, numOfProgrammer = 0;
        for (int i = 0; i < team.length; i++) {
            if (team[i] instanceof Architect) {
                numOfArchitect++;
            } else if (team[i] instanceof Designer) {
                numOfDesigner++;
            } else if (team[i] != null){
                numOfProgrammer++;
            }
        }
        if (p instanceof Architect) {
            if (numOfArchitect >= 1) {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        } else if (p instanceof Designer) {
            if (numOfDesigner >= 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else {
            if (numOfProgrammer >= 3) {
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }

//        添加
        team[total++] = p;
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
    }

    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == e.getId()) {
                return true;
            }
//            return team[i].getId() == e.getId();
        }
        return false;
    }

    public void removeMember(int memberId) throws TeamException {
        int i = 0;
        boolean flag = false;
        for (; i < total; i++) {
            if (team[i].getMemberId() == memberId) {
                team[i].setStatus(Status.FREE);
                flag = true;
                break;
            }
        }
        if (flag) {
            for (int j = i + 1; j < total; j++) {
                team[j - 1] = team[j];
            }
            team[--total] = null;
        } else {
            throw new TeamException("找不到指定的员工，删除失败");
        }
    }
}
