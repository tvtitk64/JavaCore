package src.Training.Ex11.Model;

public class SoPhuc {
    private double phanThuc;
    private double phanAo;

    public SoPhuc() {
        this.phanThuc = 0.0;
        this.phanAo = 0.0;
    }

    public SoPhuc(double phanThuc, double phanAo) {
        this.phanThuc = phanThuc;
        this.phanAo = phanAo;
    }

    public void nhapSoPhuc(double phanThuc, double phanAo) {
        this.phanThuc = phanThuc;
        this.phanAo = phanAo;
    }

    public void hienThiSoPhuc() {
        System.out.println(phanThuc + " + " + phanAo + "i");
    }

    public SoPhuc congHaiSoPhuc (SoPhuc soPhuc) {
        double tongPhanThuc = this.phanThuc + soPhuc.phanThuc;
        double tongPhanAo = this.phanAo + soPhuc.phanAo;
        return new SoPhuc(tongPhanThuc, tongPhanAo);
    }

    public SoPhuc nhanHaiSoPhuc(SoPhuc soPhuc) {
        double tichPhanThuc = this.phanThuc * soPhuc.phanThuc - this.phanAo * soPhuc.phanAo;
        double tichPhanAo = this.phanThuc * soPhuc.phanAo + this.phanAo * soPhuc.phanThuc;
        return new SoPhuc(tichPhanThuc, tichPhanAo);
    }

    public double getPhanThuc() {
        return phanThuc;
    }

    public void setPhanThuc(double phanThuc) {
        this.phanThuc = phanThuc;
    }

    public double getPhanAo() {
        return phanAo;
    }

    public void setPhanAo(double phanAo) {
        this.phanAo = phanAo;
    }
}
