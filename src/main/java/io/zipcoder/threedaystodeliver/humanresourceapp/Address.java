package io.zipcoder.threedaystodeliver.humanresourceapp;

class StreetAddress{

  String addressLine1;
  String addressLine2;
  String city;
  String state;
  String zip;//String to account for possible non-numerical postal codes
  
  public StreetAddress(){
  }
  
  public StreetAddress(String addressLine1,
                       String addressLine2,
                       String city,
                       String state,
                       String zip){
    this.addressLine1=addressLine1;
    this.addressLine2=addressLine2;
    this.city=city;
    this.state=state;
    this.zip=zip;
  }
  
  public StreetAddress getAddress(){
    return this;
  }
  
  public StreetAddress changeStreetAddress( String addressLine1,
                   String addressLine2,
                   String city,
                   String state,
                   String zip){
    return null;
  }
}
