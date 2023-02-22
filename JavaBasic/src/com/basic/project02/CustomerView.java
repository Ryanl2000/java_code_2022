package com.basic.project02;

public class CustomerView {

    private final CustomerList customerList = new CustomerList(10);

    public static void main(String[] args) {
        CustomerView cv = new CustomerView();
        cv.enterMainMenu();
    }

    public void enterMainMenu() {
        boolean loopFlag = true;
        while (loopFlag) {
            System.out
                    .println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");

            char key = CustomerUtility.readMenuSelection();
            System.out.println();
            switch (key) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
                    System.out.println("确认是否退出（Y/N）");
                    char isExit = CustomerUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        loopFlag = false;
                    }
                    break;
            }
        }
    }

    private void addNewCustomer() {
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名：");
        String name = CustomerUtility.readString(4);
        System.out.print("性别：");
        char gender = CustomerUtility.readChar();
        System.out.print("年龄：");
        int age = CustomerUtility.readInt();
        System.out.print("电话：");
        String phone = CustomerUtility.readString(15);
        System.out.print("邮箱：");
        String email = CustomerUtility.readString(15);

        Customer cust = new Customer(name, gender, age, phone, email);
        boolean flag = customerList.addCustomer(cust);
        if (flag) {
            System.out
                    .println("---------------------添加完成---------------------");
        } else {
            System.out.println("----------------记录已满,无法添加-----------------");
        }
    }

    private void modifyCustomer() {
        System.out.println("---------------------修改客户---------------------");
        int index;
        Customer cust = null;

        while (true) {
            System.out.print("请选择待修改客户编号(-1退出)：");
            index = CustomerUtility.readInt();
            if (index == -1) {
                return;
            }
            cust = customerList.getCustomer(index - 1);
            if (cust == null) {
                System.out.println("未找到该客户");
            } else {
                break;
            }
        }

        System.out.print("姓名(" + cust.getName() + ")：");
        String name = CustomerUtility.readString(4, cust.getName());

        System.out.print("性别(" + cust.getGender() + ")：");
        char gender = CustomerUtility.readChar(cust.getGender());

        System.out.print("年龄(" + cust.getAge() + ")：");
        int age = CustomerUtility.readInt(cust.getAge());

        System.out.print("电话(" + cust.getPhone() + ")：");
        String phone = CustomerUtility.readString(15, cust.getPhone());

        System.out.print("邮箱(" + cust.getEmail() + ")：");
        String email = CustomerUtility.readString(15, cust.getEmail());

        cust = new Customer(name, gender, age, phone, email);
        boolean flag = customerList.replaceCustomer(index - 1, cust);
        if (flag) {
            System.out
                    .println("---------------------修改完成---------------------");
        } else {
            System.out.println("----------无法找到指定客户,修改失败--------------");
        }
    }

    private void deleteCustomer() {
        System.out.println("---------------------删除客户---------------------");

        int index;
        Customer cust;
        while (true) {

            System.out.print("请选择待修改客户编号(-1退出)：");
            index = CustomerUtility.readInt();
            if (index == -1) {
                return;
            }

            cust = customerList.getCustomer(index - 1);
            if (cust == null) {
                System.out.println("未找到该客户！");
            } else {
                break;
            }
        }
        System.out.print("确认是否删除(Y/N)：");
        char yn = CustomerUtility.readConfirmSelection();
        if (yn == 'N')
            return;

        boolean flag = customerList.deleteCustomer(index - 1);
        if (flag) {
            System.out
                    .println("---------------------删除完成---------------------");
        } else {
            System.out.println("----------无法找到指定客户,删除失败--------------");
        }
    }

    private void listAllCustomer() {
        System.out.println("---------------------------客户列表---------------------------");
        Customer[] custs = customerList.getAllCustomers();
        if (custs.length == 0) {
            System.out.println("没有客户记录！");
        } else {
            System.out.println("编号\t\t姓名\t\t性别\t年龄\t\t电话\t\t邮箱");
            for (int i = 0; i < custs.length; i++) {
//            System.out.println(i + 1 + "\t" + custs[i].getName() + "\t" + custs[i].getGender() + "\t" + custs[i].getAge() + "\t\t" + custs[i].getPhone() + "\t" + custs[i].getEmail());
                System.out.println((i+1) + "\t" + custs[i].getDetails());
            }
        }

        System.out.println("-------------------------客户列表完成-------------------------");
    }

}
