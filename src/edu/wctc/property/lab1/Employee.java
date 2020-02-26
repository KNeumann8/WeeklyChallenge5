package edu.wctc.property.lab1;

import java.time.LocalDate;

/**
 * Fix the code in this class to do PROPERTY encapsulation correctly. Also
 * consider if any of the properties should be mandatory and use a constructor
 * to enforce that. Review the tips in the document "EncapCheckList.pdf" if
 * needed.
 *
 * @author Jim Lombardo
 * @version 1.02
 */
public class Employee {

    private String firstName;
    private String lastName;
    private String ssn;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    private String cubeId;
    private LocalDate orientationDate;

    public Employee(String firstName, String lastName, String socialSecurityNumber){
        this.firstName = firstName;
        this.lastName = lastName;

        boolean valid = true;
        char[] ssnA = socialSecurityNumber.toCharArray();
        if((ssnA[3]!='-'||ssnA[6]!='-')&&ssnA.length==11){
            ssnA[3] = 0;
            ssnA[6] = 0;
            for(char c : ssnA){
                if(!Character.isDigit(c)) valid = false;
            }
        }
        else if(ssnA.length==9){
            for(char c : ssnA){
                if(!Character.isDigit(c)) valid = false;
            }
        }
        else valid = false;

        if(valid = false) throw new IllegalArgumentException("Invalid Social Security Number!");
        else this.ssn = socialSecurityNumber;

    }

    public void setFirstName(String name){
        firstName = name;
    }
    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String name){
        lastName = name;
    }
    public String getLastName(){
        return lastName;
    }

    public String getSSN(){
        return ssn;
    }

    public boolean hasMetWithHr() {
        return metWithHr;
    }
    public void setMetWithHr(boolean metWithHr) {
        this.metWithHr = metWithHr;
    }

    public boolean hasMetDeptStaff() {
        return metDeptStaff;
    }
    public void setMetDeptStaff(boolean metDeptStaff) {
        this.metDeptStaff = metDeptStaff;
    }

    public boolean hasReviewedDeptPolicies() {
        return reviewedDeptPolicies;
    }
    public void setReviewedDeptPolicies(boolean reviewedDeptPolicies) {
        this.reviewedDeptPolicies = reviewedDeptPolicies;
    }

    public boolean isMovedIn() {
        return movedIn;
    }
    public void setMovedIn(boolean movedIn) {
        this.movedIn = movedIn;
    }

    public String getCubeId() {
        return cubeId;
    }
    public void setCubeId(String cubeId) {
        this.cubeId = cubeId;
    }

    public LocalDate getOrientationDate() {
        return orientationDate;
    }
    public void setOrientationDate(LocalDate orientationDate) {
        this.orientationDate = orientationDate;
    }
}
