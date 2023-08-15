package src.Training.Ex9.Controller;

import src.Training.Ex9.Model.Customer;
import src.Training.Ex9.Model.Receipt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerManagement {
    List<Customer> customerList = new ArrayList<>();
    List<Receipt> receiptList = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public void addReceipt(Receipt receipt) {
        receiptList.add(receipt);
    }

    public void removeCustomer(String code) {
        Optional<Customer> customer = customerList.stream().filter(customer1 -> customer1.getCode().equals(code)).findFirst();
        if (customer.isPresent()) {
            customerList.remove(customer);
        }
    }

    public int calculateBill(String code) {
        Optional<Receipt> receipt = receiptList.stream().filter(receipt1 -> receipt1.getCustomer().getCode().equals(code)).findFirst();
        if (receipt.isPresent()) {
            return (receipt.get().getNewIndex() - receipt.get().getOldIndex()) * 5;
        } else {
            return 0;
        }
    }

}
