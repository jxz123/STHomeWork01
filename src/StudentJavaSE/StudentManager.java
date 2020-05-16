package StudentJavaSE;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class StudentManager {
    public static void App() {
        ArrayList<Student> list = new ArrayList<Student>();
        while (true) {
            System.out.println("--------��ѡ�����--------");
            System.out.println("1 ����");
            System.out.println("2 ����");
            System.out.println("3 ɾ��");
            System.out.println("4 �޸�");
            System.out.println("5 ���");
            System.out.println("6 �˳�");
            System.out.println("-------------------------");
            Scanner sc = new Scanner(System.in);
            String choiceString = sc.nextLine();
            switch (choiceString) {
                case "1":
                    // ����
                    addStudent(list);
                    break;
                case "2":
                    //����
                    searchStudent(list);
                    break;
                case "3":
                    // ɾ��
                    deleteStudent(list);
                    break;
                case "4":
                    // �޸�
                    updateStudent(list);
                    break;
                case "5":
                    // ���
                    orderByScore(list);
                    break;
                case "6":
                     //�˳�
                     System.out.println("лл���ʹ��");
                     break;

                default:
                    System.out.println("������������������");
                    break;
            }
        }
    }
    /*
     * �޸�ѧ��������¼��һ����������������ȥ���ң����Ƿ���ѧ��ʹ�õ��Ǹ�����������о��޸ĸ�ѧ��
     */
    public static void updateStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("��������Ҫ�޸ĵ�ѧ����������");
        String name = sc.nextLine();
        // ����һ������
        int index = -1;
        // ��������
        for (int x = 0; x < list.size(); x++) {
            // ��ȡÿһ��ѧ������
            Student s = list.get(x);
            // ��ѧ������������ͼ���¼����������бȽ�
            if (s.getName().equals(name)) {
                index = x;
                break;
            }
        }
        if (index == -1) {
            System.out.println("��Ҫ�޸ĵ�������Ӧ��ѧ����Ϣ������,���ȥ�������ѡ��");
        }
        else {
            System.out.println("������ѧ����ѧ�ţ�");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println("������ѧ���³������ڣ�");
            String birDate = sc.nextLine();
            System.out.println("������ѧ�����Ա�");
            String input_gender = sc.nextLine();
            boolean gender = false;
            if(input_gender.equals("true"))
            	gender = true;
            if(input_gender.equals("false"))
            	gender = false;
            // ����ѧ������
            Student s = new Student();
            s.setName(name);
            s.setId(id);
            s.setBirDate(birDate);
            s.setGender(gender);
            // �޸ļ����е�ѧ������
            list.set(index, s);
            // ������ʾ
            System.out.println("�޸�ѧ���ɹ�");
        }
    }
    /*
     * ����ѧ��������¼��һ����������������ȥ���ң����Ƿ���ѧ��ʹ�õ��Ǹ�����
     */
    public static void searchStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("��������Ҫ���ҵ�ѧ����������");
        String name = sc.nextLine();
        // ����һ������
        int index = -1;
        // ��������
        for (int x = 0; x < list.size(); x++) {
            // ��ȡÿһ��ѧ������
            Student s = list.get(x);
            // ��ѧ������������ͼ���¼����������бȽ�
            if (s.getName().equals(name)) {
                index = x;
                System.out.println(s.getId() + "\t"+ "\t"+s.getName() + "\t" +"\t"+ s.getBirDate() + "\t" +"\t"+ s.getGender() );
                break;
            }
        }
        if (index == -1) {
            System.out.println("��Ҫ���ҵ�������Ӧ��ѧ����Ϣ������,���ȥ�������ѡ��");
        }
    }
    
    /*
     * ɾ��ѧ��������¼��һ����������������ȥ���ң����Ƿ���ѧ��ʹ�õ��Ǹ�����������о�ɾ����ѧ��
     */
    public static void deleteStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("��������Ҫɾ����ѧ����������");
        String name = sc.nextLine();
        // ���Ǳ���������������ڵ�ʱ�����ʾ
        // ����һ������
        int index = -1;
        // ��������
        for (int x = 0; x < list.size(); x++) {
            // ��ȡ��ÿһ��ѧ������
            Student s = list.get(x);
            // �����ѧ������������ͼ���¼����������бȽ�
            if (s.getName().equals(name)) {
                index = x;
                break;
            }
        }
        if (index == -1) {
            System.out.println("������˼,��Ҫɾ����������Ӧ��ѧ����Ϣ������,���ȥ�������ѡ��");
        } else {
            list.remove(index);
            System.out.println("ɾ��ѧ���ɹ�");
        }
    }
    /*
     * ���ѧ���ķ���
     */
    public static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        String name;
        while (true) {
            System.out.println("������ѧ��������");
            // String name = sc.nextLine();
            name = sc.nextLine();
            // �ж�������û�б���ռ��
            boolean flag = false;
            // �������ϣ��õ�ÿһ��ѧ��
            for (int x = 0; x < list.size(); x++) {
                Student s = list.get(x);
                // ��ȡ��ѧ�����������ͼ���¼����������бȽ�
                if (s.getName().equals(name)) {
                    flag = true; // ˵��������ռ����
                    break;
                }
            }
            if (flag) {
                System.out.println("������������Ѿ���ռ��,����������");
            }
            else {
                break; // ����ѭ��
            }
        }
        System.out.println("������ѧ��ѧ�ţ�");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("������ѧ���������ڣ�");
        String birDate = sc.nextLine();
        System.out.println("������ѧ���Ա�");
        String input_gender = sc.nextLine();
        boolean gender = false;
        if(input_gender.equals("true"))
        	gender = true;
        if(input_gender.equals("false"))
        	gender = false;
        // ����ѧ������
        Student s = new Student();
        s.setName(name);
        s.setId(id);
        s.setBirDate(birDate);
        s.setGender(gender);
        list.add(s);
        System.out.println("���ѧ���ɹ�");
    }
    /*
     * ����ѧ������
     */
    private static void orderByScore(ArrayList<Student> list ) {
        if (list.size() <= 0) {
            System.out.println("���ݿ�Ϊ��!!");
            return;
        }

        // ��¡�����������򣬱����ԭʼ���ݸ���
        ArrayList<Student> cList = (ArrayList<Student>) list.clone();

        // ������ѧ��
        Collections.sort(cList, new Comparator<Student>() {

            public int compare(Student s1, Student s2) {
                Double id1 = new Double(s1.getId());
                Double id2 = new Double(s2.getId());
                Integer result = id1 < id2 ? 1 : id1 < id2 ? -1 : 0;
                return result;
            }
        });

        // ��ӡ���ѧ��
        System.out.println("ѧ��\t\t����\t\t��������\t\t�Ա�");
        for (int i = 0; i < cList.size(); i++) {
            Student s = cList.get(i);
            System.out.println(s.getId() + "\t"+ "\t"+s.getName() + "\t" +"\t"+ s.getBirDate() + "\t" +"\t"+ s.getGender() );
        }
    }}