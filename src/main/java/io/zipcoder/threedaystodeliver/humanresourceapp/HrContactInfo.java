package io.zipcoder.threedaystodeliver.humanresourceapp;

class HrContactInfo {

  String name;
  StreetAddress streetAddress;
  String phone;
  String email;

  public HrContactInfo(String name,
                       StreetAddress streetAaddress,
                       String phone,
                       String email){
    this.name=name;
    this.streetAddress = streetAddress;
    this.phone=phone;
    this.email=email;
  }
  
  public void setName(String name){}
  public String getName(){
    return null;
  }
  
  public void setPhone(String phone){}

  public String getPhone(){
    return null;
  }
  
  public void setEmail(String email){}

  public String getEmail(){
    return null;
  }
  
}
