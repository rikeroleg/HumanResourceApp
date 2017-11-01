package io.zipcoder.threedaystodeliver.humanresourceapp;

public class Compensation {

    public enum compensationType {
        Monthly,
        Hourly,
        Project

    }

    private double usePTO;

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

    public void setPtoMaxPerYear(double ptoMaxPerYear) {
        PtoMaxPerYear = ptoMaxPerYear;
    }

    public double getPtoMaxPerYear() {
        return PtoMaxPerYear;
    }

    public void setUsePTO(double amount) {
        this.usePTO = amount;

    }

    public double getUsePTO() {
        return usePTO;
    }

    public void setPayrate(double payrate) {
        this.payrate = payrate;
    }

    public double getPtoRemaining() {

        PtoRemaining = PtoMaxPerYear - usePTO;

        return PtoRemaining;
    }

    public double getPTOUsedThisYear() {

        return usePTO;
    }


    public double getPayrate() {
        return payrate;
    }

    public void setCompensationType(Compensation.compensationType compensationType) {
        this.compensationType = compensationType;
    }

    public boolean getIsVision() {
        return vision;
    }

    public void setVision(boolean vision) {
        this.vision = vision;
    }

    public void setDental(boolean dental) {
        this.dental = dental;
    }

    public boolean isDental() {
        return dental;
    }

    public void setMedical(boolean medical) {
        this.medical = medical;
    }

    public boolean getIsMedical() {
        return medical;
    }

    public void setPrescription(boolean prescription) {
        this.prescription = prescription;
    }

    public boolean isPrescription() {
        return prescription;
    }

    public void setRetirement(boolean retirement) {
        this.retirement = retirement;
    }

    public boolean isRetirement() {
        return retirement;
    }

    public void setRetirementMatching(double retirementMatching) {
        this.retirementMatching = retirementMatching;
    }

    public double getRetirementMatching() {
        return retirementMatching;
    }

    public Compensation() {

    }

    public void setTypeAndAmount(compensationType compType, double payRate) {
        this.compensationType = compType;
        this.payrate = payRate;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public compensationType getCompensationType() {
        return this.compensationType;
    }


}
