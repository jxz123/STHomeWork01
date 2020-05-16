package StudentJavaSE;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class StudentManager {
    public static void App() {
        ArrayList<Student> list = new ArrayList<Student>();
        while (true) {
            System.out.println("--------请选择操作--------");
            System.out.println("1 插入");
            System.out.println("2 查找");
            System.out.println("3 删除");
            System.out.println("4 修改");
            System.out.println("5 输出");
            System.out.println("6 退出");
            System.out.println("-------------------------");
            Scanner sc = new Scanner(System.in);
            String choiceString = sc.nextLine();
            switch (choiceString) {
                case "1":
                    // 插入
                    addStudent(list);
                    break;
                case "2":
                    //查找
                    searchStudent(list);
                    break;
                case "3":
                    // 删除
                    deleteStudent(list);
                    break;
                case "4":
                    // 修改
                    updateStudent(list);
                    break;
                case "5":
                    // 输出
                    orderByScore(list);
                    break;
                case "6":
                     //退出
                     System.out.println("谢谢你的使用");
                     break;

                default:
                    System.out.println("按键错误，请重新输入");
                    break;
            }
        }
    }
    /*
     * 修改学生：键盘录入一个姓名，到集合中去查找，看是否有学生使用的是该姓名，如果有就修改该学生
     */
    public static void updateStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要修改的学生的姓名：");
        String name = sc.nextLine();
        // 定义一个索引
        int index = -1;
        // 遍历集合
        for (int x = 0; x < list.size(); x++) {
            // 获取每一个学生对象
            Student s = list.get(x);
            // 拿学生对象的姓名和键盘录入的姓名进行比较
            if (s.getName().equals(name)) {
                index = x;
                break;
            }
        }
        if (index == -1) {
            System.out.println("你要修改的姓名对应的学生信息不存在,请回去重新你的选择");
        }
        else {
            System.out.println("请输入学生新学号：");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println("请输入学生新出生日期：");
            String birDate = sc.nextLine();
            System.out.println("请输入学生新性别：");
            String input_gender = sc.nextLine();
            boolean gender = false;
            if(input_gender.equals("true"))
            	gender = true;
            if(input_gender.equals("false"))
            	gender = false;
            // 创建学生对象
            Student s = new Student();
            s.setName(name);
            s.setId(id);
            s.setBirDate(birDate);
            s.setGender(gender);
            // 修改集合中的学生对象
            list.set(index, s);
            // 给出提示
            System.out.println("修改学生成功");
        }
    }
    /*
     * 查找学生：键盘录入一个姓名，到集合中去查找，看是否有学生使用的是该姓名
     */
    public static void searchStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要查找的学生的姓名：");
        String name = sc.nextLine();
        // 定义一个索引
        int index = -1;
        // 遍历集合
        for (int x = 0; x < list.size(); x++) {
            // 获取每一个学生对象
            Student s = list.get(x);
            // 拿学生对象的姓名和键盘录入的姓名进行比较
            if (s.getName().equals(name)) {
                index = x;
                System.out.println(s.getId() + "\t"+ "\t"+s.getName() + "\t" +"\t"+ s.getBirDate() + "\t" +"\t"+ s.getGender() );
                break;
            }
        }
        if (index == -1) {
            System.out.println("你要查找的姓名对应的学生信息不存在,请回去重新你的选择");
        }
    }
    
    /*
     * 删除学生：键盘录入一个姓名，到集合中去查找，看是否有学生使用的是该姓名，如果有就删除该学生
     */
    public static void deleteStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除的学生的姓名：");
        String name = sc.nextLine();
        // 我们必须给出姓名不存在的时候的提示
        // 定义一个索引
        int index = -1;
        // 遍历集合
        for (int x = 0; x < list.size(); x++) {
            // 获取到每一个学生对象
            Student s = list.get(x);
            // 拿这个学生对象的姓名和键盘录入的姓名进行比较
            if (s.getName().equals(name)) {
                index = x;
                break;
            }
        }
        if (index == -1) {
            System.out.println("不好意思,你要删除的姓名对应的学生信息不存在,请回去重新你的选择");
        } else {
            list.remove(index);
            System.out.println("删除学生成功");
        }
    }
    /*
     * 添加学生的方法
     */
    public static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        String name;
        while (true) {
            System.out.println("请输入学生姓名：");
            // String name = sc.nextLine();
            name = sc.nextLine();
            // 判断姓名有没有被人占用
            boolean flag = false;
            // 遍历集合，得到每一个学生
            for (int x = 0; x < list.size(); x++) {
                Student s = list.get(x);
                // 获取该学生的姓名，和键盘录入的姓名进行比较
                if (s.getName().equals(name)) {
                    flag = true; // 说明姓名被占用了
                    break;
                }
            }
            if (flag) {
                System.out.println("你输入的姓名已经被占用,请重新输入");
            }
            else {
                break; // 结束循环
            }
        }
        System.out.println("请输入学生学号：");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("请输入学生出生日期：");
        String birDate = sc.nextLine();
        System.out.println("请输入学生性别：");
        String input_gender = sc.nextLine();
        boolean gender = false;
        if(input_gender.equals("true"))
        	gender = true;
        if(input_gender.equals("false"))
        	gender = false;
        // 创建学生对象
        Student s = new Student();
        s.setName(name);
        s.setId(id);
        s.setBirDate(birDate);
        s.setGender(gender);
        list.add(s);
        System.out.println("添加学生成功");
    }
    /*
     * 根据学号排序
     */
    private static void orderByScore(ArrayList<Student> list ) {
        if (list.size() <= 0) {
            System.out.println("数据库为空!!");
            return;
        }

        // 克隆副本进行排序，避免对原始数据更改
        ArrayList<Student> cList = (ArrayList<Student>) list.clone();

        // 排序按照学号
        Collections.sort(cList, new Comparator<Student>() {

            public int compare(Student s1, Student s2) {
                Double id1 = new Double(s1.getId());
                Double id2 = new Double(s2.getId());
                Integer result = id1 < id2 ? 1 : id1 < id2 ? -1 : 0;
                return result;
            }
        });

        // 打印输出学号
        System.out.println("学号\t\t姓名\t\t出生日期\t\t性别");
        for (int i = 0; i < cList.size(); i++) {
            Student s = cList.get(i);
            System.out.println(s.getId() + "\t"+ "\t"+s.getName() + "\t" +"\t"+ s.getBirDate() + "\t" +"\t"+ s.getGender() );
        }
    }}