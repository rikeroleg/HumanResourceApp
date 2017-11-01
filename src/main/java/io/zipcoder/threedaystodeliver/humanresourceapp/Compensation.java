package io.zipcoder.threedaystodeliver.humanresourceapp;

public class Compensation {

    //Hi, I'm Tim and I like money.
    //Newdiff
    //JK, old Tim doesn't like money.

    private enum compensationType{
        Monthly,
        Hourly,
        Project
    }

    private double payrate;
    private double bonus;
    private compensationType compensationType;
    private double PtoMaxPerYear;
    private double PtoUsedThisYear;
    private boolean vision;
    private boolean dental;
    private boolean medical;
    private boolean prescription;
    private boolean retirement;
    private double retirementMatching;


    public Compensation (){

    }

    public void setTypeAndAmount(compensationType compType, double payRate){

    }

    public void setBonus(double bonus){

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
