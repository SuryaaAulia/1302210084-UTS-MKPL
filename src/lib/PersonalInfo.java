package lib;

import java.util.LinkedList;
import java.util.List;

public class PersonalInfo {

    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;

    private boolean isForeigner;
    private boolean gender; // true = Laki-laki, false = Perempuan

    private String spouseName;
    private String spouseIdNumber;

    private List<String> childNames;
    private List<String> childIdNumbers;

    public PersonalInfo(String firstName, String lastName, String idNumber, String address, String spouseName,
            String spouseIdNumber, boolean isForeigner, boolean gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.isForeigner = isForeigner;
        this.gender = gender;
        this.spouseIdNumber = spouseIdNumber;
        this.spouseName = spouseName;
        childNames = new LinkedList<String>();
        childIdNumbers = new LinkedList<String>();
    }

    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouseName = spouseName;
        this.spouseIdNumber = idNumber;
    }

    public void addChild(String childName, String childIdNumber) {
        childNames.add(childName);
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
