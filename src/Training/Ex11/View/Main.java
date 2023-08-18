package src.Training.Ex11.View;

import src.Training.Ex11.Model.SoPhuc;

public class Main {
    public static void main(String[] args) {
        SoPhuc sp1 = new SoPhuc();
        SoPhuc sp2 = new SoPhuc();
        sp1.nhapSoPhuc(1.5, 2.5);
        sp2.nhapSoPhuc(3.5, 4.5);
        sp1.hienThiSoPhuc();
        sp2.hienThiSoPhuc();
        SoPhuc tong = sp1.congHaiSoPhuc(sp2);
        SoPhuc tich = sp1.nhanHaiSoPhuc(sp2);
        tong.hienThiSoPhuc();
        tich.hienThiSoPhuc();
    }
}
