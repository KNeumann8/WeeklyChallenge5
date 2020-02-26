package edu.wctc.method.lab2;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * In this lab focus on METHOD encapsulation and fix/add code as necessary.
 * Pay special attention to the following issues:
 *
 * 1. Not all methods need to be public
 *
 * 2. When methods need to be called in a certain order you can do this
 * by creating a parent method that calls the other, helper methods.
 *
 * 3. There is some duplicate code used that violates the D.R.Y. principle.
 * Eliminate that by encapsulating the duplicate code in a new method
 * and then call that method in place of the duplicate code.
 *
 * 4. All method parameters should be validated (except booleans).
 *
 * Review the tips in the document "EncapCheckList.pdf" if needed.
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

    public Employee(String firstName, String lastName, String ssn) {
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);
    }

    public void performNewHireDuties(LocalDate orientationDate,String cubeId){
        setOrientationDate(orientationDate);
        meetWithHrForBenefitAndSalaryInfo();
        meetDepartmentStaff();
        reviewDeptPolicies();
        moveIntoCubicle(cubeId);
    }

    // Assume this must be performed first, and assume that an employee
    // would only do this once, upon being hired.
    private void meetWithHrForBenefitAndSalaryInfo() {
        setMetWithHr(true);
        String fmtDate = getFMTDate();
        System.out.println(firstName + " " + lastName + " met with HR on "
                + fmtDate);
    }

    // Assume this must be performed second, and assume that an employee
    // would only do this once, upon being hired.
    private void meetDepartmentStaff() {
        setMetDeptStaff(true);
        String fmtDate = getFMTDate();
        System.out.println(firstName + " " + lastName + " met with dept staff on "
                + fmtDate);
    }

    // Assume this must be performed third. And assume that because department
    // policies may change that this method may need to be called 
    // independently from other classes.
    public void reviewDeptPolicies() {
        setReviewedDeptPolicies(true);
        String fmtDate = getFMTDate();
        System.out.println(firstName + " " + lastName + " reviewed dept policies on "
                + fmtDate);
    }

    // Assume this must be performed fourth. And assume that because employees
    // sometimes change office locations that this method may need to be called 
    // independently from other classes.
    public void moveIntoCubicle(String cubeId) {
        setCubeId(cubeId);
        setMovedIn(true);
        String fmtDate = getFMTDate();
        System.out.println(firstName + " " + lastName + " moved into cubicle "
                + cubeId + " on " + fmtDate);
    }

    private String getFMTDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yy");
        String fmtDate = formatter.format(orientationDate);
        return  fmtDate;
    }

    public String getFirstName() {
        return firstName;
    }

    // setter methods give the developer the power to control what data is
    // allowed through validation.

    public void setFirstName(String firstName) {
        nameValidate(firstName);
        this.firstName = firstName;
    }

    private void nameValidate(String name){
        if(name == null || name.length()<=0){
            throw new IllegalArgumentException("First Name is blank. It needs a value!");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        nameValidate(lastName);
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    private void setSsn(String ssn) {
        boolean valid = true;
        char[] ssnA = ssn.toCharArray();
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
        else this.ssn = ssn;
    }

    public boolean hasMetWithHr() {
        return metWithHr;
    }

    // boolean parameters need no validation
    private void setMetWithHr(boolean metWithHr) {
        this.metWithHr = metWithHr;
    }

    public boolean hasMetDeptStaff() {
        return metDeptStaff;
    }

    private void setMetDeptStaff(boolean metDeptStaff) {
        this.metDeptStaff = metDeptStaff;
    }

    public boolean hasReviewedDeptPolicies() {
        return reviewedDeptPolicies;
    }

    private void setReviewedDeptPolicies(boolean reviewedDeptPolicies) {
        this.reviewedDeptPolicies = reviewedDeptPolicies;
    }

    public boolean hasMovedIn() {
        return movedIn;
    }

    private void setMovedIn(boolean movedIn) {
        this.movedIn = movedIn;
    }

    public String getCubeId() {
        return cubeId;
    }

    private void setCubeId(String cubeId) {
        this.cubeId = cubeId;
    }

    public LocalDate getOrientationDate() {
        return orientationDate;
    }

    private void setOrientationDate(LocalDate orientationDate) {
        if (orientationDate == null) {
            throw new IllegalArgumentException("orientation date is blank!");
        }
        this.orientationDate = orientationDate;
    }
}
