package src.Training.Ex9.Model;

public class Customer {
    private String name;
    private int homeAddress;
    private String code;

    public Customer(String name, int homeAddress, String code) {
        this.name = name;
        this.homeAddress = homeAddress;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(int homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
