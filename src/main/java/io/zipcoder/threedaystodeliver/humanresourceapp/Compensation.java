package io.zipcoder.threedaystodeliver.humanresourceapp;

public class Compensation {

    public enum compensationType{
        Monthly,
        Hourly,
        Project
    }

    private double payrate;
    private double bonus;
    private compensationType compensationType;
    private double PtoMaxPerYear;
    private double PtoRemaining;
    private boolean vision;
    private boolean dental;
    private boolean medical;
    private boolean prescription;
    private boolean retirement;
    private double retirementMatching;

    public double getPtoRemaining() {
        return PtoRemaining;
    }

    public void setPtoRemaining(double ptoRemaining) {
        PtoRemaining = ptoRemaining;
    }





    public void setPayrate(double payrate) {
        this.payrate = payrate;
    }

    public void usePTO(double amount){
        //decrement PTO left by amount
    }

    public double ptoUsedThisYear(){
        //pto max - pto remaining

        return 0;
    }

    public void setCompensationType(Compensation.compensationType compensationType) {
        this.compensationType = compensationType;
    }

    public double getPtoMaxPerYear() {
        return PtoMaxPerYear;
    }

    public void setPtoMaxPerYear(double ptoMaxPerYear) {
        PtoMaxPerYear = ptoMaxPerYear;
    }

    public boolean isVision() {
        return vision;
    }

    public void setVision(boolean vision) {
        this.vision = vision;
    }

    public boolean isDental() {
        return dental;
    }

    public void setDental(boolean dental) {
        this.dental = dental;
    }

    public boolean isMedical() {
        return medical;
    }

    public void setMedical(boolean medical) {
        this.medical = medical;
    }

    public boolean isPrescription() {
        return prescription;
    }

    public void setPrescription(boolean prescription) {
        this.prescription = prescription;
    }

    public boolean isRetirement() {
        return retirement;
    }

    public void setRetirement(boolean retirement) {
        this.retirement = retirement;
    }

    public double getRetirementMatching() {
        return retirementMatching;
    }

    public void setRetirementMatching(double retirementMatching) {
        this.retirementMatching = retirementMatching;
    }



    public Compensation (){

    }

    public void setTypeAndAmount(compensationType compType, double payRate){
        this.compensationType = compType;
        this.payrate = payRate;
    }

    public void setBonus(double bonus){
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public double getPayrate() {
        return payrate;
    }

    public compensationType getCompensationType(){
        return this.compensationType;
    }






}
