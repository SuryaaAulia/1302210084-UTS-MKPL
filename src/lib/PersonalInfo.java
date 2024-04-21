package lib;

import java.util.LinkedList;
import java.util.List;

public class PersonalInfo {

    private String idNumber;
    private boolean isForeigner;
    private String spouseIdNumber;
    private List<String> childIdNumbers;

    public PersonalInfo(String idNumber, String spouseIdNumber, boolean isForeigner) {
        this.idNumber = idNumber;
        this.isForeigner = isForeigner;
        this.spouseIdNumber = spouseIdNumber;
        childIdNumbers = new LinkedList<String>();
    }

    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouseIdNumber = idNumber;
    }

    public void addChild(String childIdNumber) {
        childIdNumbers.add(childIdNumber);
    }

    public boolean getIsForeigner() {
        return this.isForeigner;
    }

    public List<String> getChildIdNumbers() {
        return this.childIdNumbers;
    }

    public String getSpouseIdNumber() {
        return this.spouseIdNumber;
    }
}
