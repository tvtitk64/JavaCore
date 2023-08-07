package src;

import java.util.ArrayList;
import java.util.List;

public class QLCB {
    List<CanBo> staffList = new ArrayList<>();

    public void addPeople(CanBo canBo) {
        staffList.add(canBo);
    }


    public List<CanBo> searchForName(String name) {
        List<CanBo> resultList = new ArrayList<>();
        for (CanBo company : staffList) {
            if (company.getName().equalsIgnoreCase(name)) {
                resultList.add(company);
            }
        }

        return resultList;
    }

    public void displayResult() {
        for (CanBo company : staffList) {
            company.displayInformation();
        }
    }

    public void exitProgram() {
        System.exit(0);
    }
}
