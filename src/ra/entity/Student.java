package ra.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Student implements Serializable,IEntity{
    private String studentId ;
    private String studentName;
    private Date birthday;
    private int age;
    private boolean sex;
    private float mark_html;
    private float mark_css;
    private float mark_javascript;
    private float mark_avgMark;
    private String rank;

    public Student() {
    }

    public Student(String studentId, String studentName, Date birthday, int age, boolean sex, float mark_html, float mark_css, float mark_javascript, float mark_avgMark,String rank) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.birthday = birthday;
        this.age = age;
        this.sex = sex;
        this.mark_html = mark_html;
        this.mark_css = mark_css;
        this.mark_javascript = mark_javascript;
        this.mark_avgMark = mark_avgMark;
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public float getMark_html() {
        return mark_html;
    }

    public void setMark_html(float mark_html) {
        this.mark_html = mark_html;
    }

    public float getMark_css() {
        return mark_css;
    }

    public void setMark_css(float mark_css) {
        this.mark_css = mark_css;
    }

    public float getMark_javascript() {
        return mark_javascript;
    }

    public void setMark_javascript(float mark_javascript) {
        this.mark_javascript = mark_javascript;
    }

    public float getMark_avgMark() {
        return mark_avgMark;
    }

    public void setMark_avgMark(float mark_avgMark) {
        this.mark_avgMark = mark_avgMark;
    }

    @Override
    public <T> void inputData(Scanner scanner, List<T> studentList) {
        boolean isExit = true;
//        do {
//            System.out.println("Nhap ma sinh vien :");
//            this.studentId = scanner.nextLine();
//            for (T st:listStudent) {
//                if (st instanceof Student){
//                    if (((Student) st).getStudentId().equals(this.studentId)) {
//                        System.err.println("Ma sinh vien da ton tai!");
//                        break;
//                    }
//                    isExit = false;
//                }
//            }
//        }while(isExit);

        do{
            System.out.println("Hãy nhập mã sinh viên");
            String inputData = scanner.nextLine();
            if(!checkStudentId(inputData)){
                System.out.println("\u001B[31m"+"Mã sinh viên không hợp lệ hãy nhập lại"+"\u001B[0m");
            }
            else {
                boolean isCheck = true;
                for (T st: studentList) {
                    if(((Student) st).getStudentId().equals(inputData)){
                        System.out.println("\u001B[31m"+"Mã sinh viên đã tồn tại! Hãy nhập lại"+"\u001B[0m");
                        isCheck = false;
                        break;
                    }
                }
                if(isCheck){
                    this.studentId = inputData;
                    break;
                }
            }
        }while (isExit);
        //studentName validate
        do {
            System.out.println("Nhap ten sinh vien :");
            this.studentName = scanner.nextLine();
            if (this.studentName.length()>=10&&this.studentName.length()<=50){
                break;
            }else {
                System.err.println("Ten sinh vien phai tu 10-50 ki tu.Vui long nhap lai!");
            }
        }while(isExit);
        //birthday validate
        do {
            System.out.println("Nhap ngay thang nam sinh :");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
            try {
                this.birthday = sdf.parse(scanner.nextLine());
                break;
            } catch (ParseException e) {
                System.err.println("Vui long nhap lai theo dang dd/MM/yyyy!");
            }

        }while(isExit);
        System.out.println("Nhap gioi tinh sinh vien");
        this.sex = Boolean.parseBoolean(scanner.nextLine());
        do {
            System.out.println("Nhap diem HTML:");
            this.mark_html=Float.parseFloat(scanner.nextLine());
            if (this.mark_html>=0&&this.mark_html<=10){
                break;
            }else {
                System.err.println("Diem nam trong khoang tu 0-10.Vui long nhap lai");
            }
        }while(isExit);
        do {
            System.out.println("Nhap diem CSS:");
            this.mark_css=Float.parseFloat(scanner.nextLine());
            if (this.mark_css>=0&&this.mark_css<=10){
                break;
            }else {
                System.err.println("Diem nam trong khoang tu 0-10.Vui long nhap lai");
            }
        }while(isExit);
        do {
            System.out.println("Nhap diem JavaScrip:");
            this.mark_javascript=Float.parseFloat(scanner.nextLine());
            if (this.mark_javascript>=0&&this.mark_javascript<=10){
                break;
            }else {
                System.err.println("Diem nam trong khoang tu 0-10.Vui long nhap lai");
            }
        }while(isExit);
    }

    @Override
    public void displayData() {
        System.out.printf("Ma SV : %s - Ten SV : %s - Birthday : %s - Tuoi : %d\n",this.studentId,this.studentName,this.birthday.toString(),this.age);
        System.out.printf("Sex : %s - Diem HTML : %f - Diem CSS : %f - Diem JavaScrip :%f - Diem TB : %f - Rank : %s\n",(this.sex?"Nam":"Nu"),this.mark_html,this.mark_css,this.mark_javascript,this.mark_avgMark,this.rank);
    }

    @Override
    public void calAge() {
        this.age = 2023-(1900+this.birthday.getYear());
    }

    @Override
    public void calAvgMark_Rank() {
        this.mark_avgMark = (this.mark_html+this.mark_css+this.mark_javascript)/3;
        if (this.mark_avgMark<5){
            rank = "Yeu";
        } else if (this.mark_avgMark>=5&&this.mark_avgMark<7) {
            rank = "Trung Binh";
        } else if (this.mark_avgMark>=7&&this.mark_avgMark<8) {
            rank = "Kha";
        }else if (this.mark_avgMark>=8&&this.mark_avgMark<9){
            rank = "Gioi";
        }else {
            rank="Xuat sac";
        }
    }

    public boolean checkStudentId(String text){
        if(text.length()!=4||text.contains(" ")||!text.startsWith("S")){
            return false;
        }
        else {
            return true;
        }
    }
}
