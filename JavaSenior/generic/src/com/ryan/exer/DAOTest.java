package com.ryan.exer;

import java.util.List;

/**
 * @author RyanL
 * @description
 * @create 2022/7/24
 */
public class DAOTest {

    public static void main(String[] args) {

        DAO<User> dao = new DAO<>();

        dao.save("1001", new User(1001, 18, "Tom"));
        dao.save("1002", new User(1002, 18, "Tina"));
        dao.save("1003", new User(1003, 18, "Bob"));

        System.out.println(dao.get("1001"));

        dao.update("1001", new User(1001, 19, "Tom"));

        dao.delete("1003");

        List<User> list = dao.list();
        System.out.println(list);

    }

}
