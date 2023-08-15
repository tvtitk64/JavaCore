package src.Exceptions;


class SoDuKhongDuException extends Exception {
    public SoDuKhongDuException(String thongDiep) {
        super(thongDiep);
    }
}

public class CustomException {
    double soDu;
    public CustomException(double soDu) {
        this.soDu = soDu;
    }

    public void RutTien(double soTien) throws SoDuKhongDuException, Exception {
        if (soTien > soDu) {
            throw new SoDuKhongDuException("So du khong du");
        }
        soDu=soDu-soTien;
    }

    public double getSoDu() {
        return soDu;
    }
    public static void main(String[] args) {
        CustomException a1 = new CustomException(1000);
        try {
            a1.RutTien(200);
            System.out.println("done");
        } catch (SoDuKhongDuException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Other exception: " + e.getMessage());
        }
        System.out.println(a1.getSoDu());
    }
}

