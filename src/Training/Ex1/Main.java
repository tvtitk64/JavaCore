package src.Training.Ex1;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please choose action below: ");
        System.out.println("Press 1 to add an officer: ");
        System.out.println("Press 2 to add search for name: ");
        System.out.println("Press 3 to display result: ");
        System.out.println("Press 4 to exit the prgram: ");
        Scanner sc = new Scanner(System.in);
        QLCB qlcb = new QLCB();
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Nhập thông tin cán bộ:");
                System.out.print("Họ tên: ");
                String name = sc.nextLine();
                System.out.print("Tuổi: ");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("Giới tính: ");
                String sex = sc.nextLine();
                System.out.print("Địa chỉ: ");
                String address = sc.nextLine();
                System.out.print("Chọn loại cán bộ: 1. Cong Nhan, 2. Ky Su, 3. Nhan Vien");
                int type = sc.nextInt();
                sc.nextLine();
                switch (type) {
                    case 1:
                        System.out.println("Nhap cap bac: ");
                        int rank = sc.nextInt();
                        sc.nextLine();
                        CongNhan congNhan = new CongNhan(name, age, sex, address, rank);
                        qlcb.addPeople(congNhan);
                        break;
                    case 2:
                        System.out.println("Nhap chuyen nganh: ");
                        String major = sc.nextLine();
                        KySu kySu = new KySu(name, age, sex, address, major);
                        qlcb.addPeople(kySu);
                        break;
                    case 3:
                        System.out.println("Nhap cong viec: ");
                        String job = sc.nextLine();
                        NhanVien nhanVien = new NhanVien(name, age, sex, address, job);
                        qlcb.addPeople(nhanVien);
                        break;
                    default:
                        System.out.println("Loai can bo khong hop le");
                }
                break;
            case 2:
                System.out.println("Nhap ten muon tim kiem");
                String searchForName = sc.nextLine();
                List<CanBo> findName = qlcb.searchForName(searchForName);
                if (findName.isEmpty()) {
                    System.out.println("Khong tim thay");
                } else {
                    for (CanBo canBo : findName) {
                        System.out.println("Ho ten: " + canBo.name);
                        System.out.println("Tuoi: " + canBo.age);
                        System.out.println("Gioi tinh: " + canBo.sex);
                        System.out.println("Dia chi: " + canBo.address);
                        if (canBo instanceof CongNhan) {
                            CongNhan congNhan = (CongNhan) canBo;
                            System.out.println("Cap bac: " + congNhan.getRank());
                        } else if (canBo instanceof KySu) {
                            KySu kySu = (KySu) canBo;
                            System.out.println("Chuyen nganh: " + kySu.getMajor());
                        } else if (canBo instanceof NhanVien) {
                            NhanVien nhanVien = (NhanVien) canBo;
                            System.out.println("Cong viec: " + nhanVien.getJob());
                        }

                    }
                }
                break;
            case 3:
                if (qlcb.staffList.isEmpty()) {
                    System.out.println("Danh sach can bo rong");
                } else {
                    System.out.println("Danh sach can bo: ");
                    qlcb.displayResult();
                }
                break;
            case 4:
                System.out.println("Ket thuc chuong trinh");
                qlcb.exitProgram();
                break;
        }

    }
}
