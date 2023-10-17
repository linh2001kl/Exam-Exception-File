package ra.studentImp;


import ra.entity.Student;

import java.util.*;

public class StudentImp {
    static List<Student> studentList= new ArrayList<>();
    static Student student = new Student();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        //1. Khởi tạo đối tượng file
//        File file = new File("students.txt");
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
//        try {
//            //2. Khởi tạo đôi tượng FileInputStream
//            fis = new FileInputStream(file);
//            //3. Khởi tạo đối tượng ObjectInputStream để đọc object
//            ois = new ObjectInputStream(fis);
//            //4. Đọc dữ liệu với phương thức readObject()
//            List<Student> listStudentRead = (List<Student>) ois.readObject();
//            //In ra kết quả
//            for (Student student : listStudentRead) {
//                System.out.println(student.toString());
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }finally {
//            try {
//                ois.close();
//                fis.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
        do {
            System.out.println("*****************************MENU************************\n" +
                    "1. Nhập thông tin các sinh viên\n" +
                    "2.Hien thi bang\n"+
                    "3. Tính tuổi các sinh viên\n" +
                    "4. Tính điểm trung bình và xếp loại sinh viên\n" +
                    "5. Sắp xếp sinh viên theo tuổi tăng dần\n" +
                    "6. Thống kê sinh viên theo xếp loại sinh viên\n" +
                    "7. Cập nhật thông tin sinh viên theo mã sinh viên\n" +
                    "8. Tìm kiếm sinh viên theo tên sinh viên\n" +
                    "9. Thoát\n");
            System.out.println("Nhap lua chon :");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    StudentImp.inputData(scanner,studentList);
                    break;
                case 2:
                    StudentImp.displayData();
                    break;
                case 3:
                    StudentImp.calAge();
                    break;
                case 4:
                    StudentImp.calAvgMark();
                    break;
                case 5:
                    StudentImp.sortByAge();
                    break;
                case 6:
                    StudentImp.sortByRank();
                    break;
                case 7:
                    StudentImp.updateById(scanner,studentList);
                    break;
                case 8:
                    StudentImp.searchByName(scanner,studentList);
                    break;
                case 9 :
                    System.exit(0);
            }
        }while(true);

//        //1. Khởi tạo file
//        //Nếu file students.txt chưa tồn tại thì tạo mới
//        //Nếu file students.txt đã tồn tại, ghi đè toàn bộ
//
//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        try {
//            //2. Khởi tạo đối tượng FileOutputStream
//            fos = new FileOutputStream(file);
//            //3. Khởi tạo đối tượng ObjectOutputStream
//            oos = new ObjectOutputStream(fos);
//            //4. Ghi dữ liệu ra file với phương thức writeObject
//            oos.writeObject(studentList);
//            //5. Đẩy dữ liệu từ stream xuống file
//            oos.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                oos.close();
//                fos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
  }

    public static void inputData(Scanner scanner,List<Student>studentList){
        System.out.println("1. Nhập n thông tin các sinh viên :");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            student.inputData(scanner,studentList);
            studentList.add(student);
        }
    }

    public static void displayData(){
        for (Student student:studentList) {
            student.displayData();
        }
    }

    public static void calAge(){
        for (int i = 0; i < studentList.size(); i++) {
            student.calAge();
        }
    }

    public static void calAvgMark(){
        for (int i = 0; i < studentList.size(); i++) {
            student.calAvgMark_Rank();
        }
    }

    public static void sortByAge(){
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge()- o2.getAge();
            }
        });
    }

    public static void sortByRank(){
        for (int i = 0; i < 6; i++) {

        }
        for (Student student:studentList) {
            if (student.getRank().equals("Xuat sac")){
                student.displayData();
            }
        }
        for (Student student:studentList) {
            if (student.getRank().equals("Gioi")){
                student.displayData();
            }
        }
        for (Student student:studentList) {
            if (student.getRank().equals("Kha")){
                student.displayData();
            }
        }
        for (Student student:studentList) {
            if (student.getRank().equals("Trung Binh")){
                student.displayData();
            }
        }
        for (Student student:studentList) {
            if (student.getRank().equals("Yeu")){
                student.displayData();
            }
        }
    }

    public static void updateById(Scanner scanner,List<Student>studentList){
        System.out.println("Nhap Ma SV muon cap nhat thong tin :");
        String updateId = scanner.nextLine();
        boolean isId = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentId().equalsIgnoreCase(updateId)){
                studentList.get(i).inputData(scanner,studentList);
                isId = true;
                break;
            }
        }
        if (!isId){
            System.err.println("Ma sinh vien chua dung hay nhap lai!");
        }
    }

    public static void searchByName(Scanner scanner, List<Student>studentList){
        System.out.println("Nhap ten sinh vien muon tim kiem :");
        String searchName = scanner.nextLine();
        boolean isName = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentName().equalsIgnoreCase(searchName)){
              studentList.get(i).displayData();
              isName = true;
              break;
            }
        }
        if (!isName){
            System.err.println("Ten sinh vien khong the tim thay vui long nhap lai!");
        }
    }
}
