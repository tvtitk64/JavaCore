package src.Training.Ex9.Model;

public class Receipt {
    private Customer customer;
    private int oldIndex;
    private int newIndex;
    private int bill;

    public Receipt(Customer customer, int oldIndex, int newIndex, int bill) {
        this.customer = customer;
        this.oldIndex = oldIndex;
        this.newIndex = newIndex;
        this.bill = bill;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getOldIndex() {
        return oldIndex;
    }

    public void setOldIndex(int oldIndex) {
        this.oldIndex = oldIndex;
    }

    public int getNewIndex() {
        return newIndex;
    }

    public void setNewIndex(int newIndex) {
        this.newIndex = newIndex;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }
}
