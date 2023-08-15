package src.Exceptions;

class Parent {
    void foo() throws Exception {
        // Một phương thức có khả năng gây ra ngoại lệ
        throw new Exception("Lỗi xảy ra trong phương thức foo()");
    }
}

class Child extends Parent {
    @Override
    void foo() {
        try {
            // Gọi phương thức từ lớp cha và xử lí ngoại lệ
            super.foo();
        } catch (Exception e) {
            // Xử lí ngoại lệ theo cách riêng của lớp con
            System.out.println("Đã xảy ra lỗi trong phương thức foo() của lớp con");
            System.out.println("Thông điệp lỗi: " + e.getMessage());
        }
    }
}
public class ExceptionWithOverride {
    public static void main(String[] args) {
        Child child = new Child();
        child.foo();
    }
}
