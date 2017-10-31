package io.zipcoder.threedaystodeliver.humanresourceapp;

class HrContactInfo {

  String name;
  StreetAddress streetAddress;
  String phone;
  String email;

  public HrContactInfo() {

  }

  public HrContactInfo(String name,
                       StreetAddress streetAddress,
                       String phone,
                       String email){
    this.name=name;
    this.streetAddress = streetAddress;
    this.phone=phone;
    this.email=email;
  }
  
  public void setName(String name){
      this.name = name;
  }
  public String getName(){
    return name;
  }

  public void setStreetAddress(StreetAddress streetAddress) {
      this.streetAddress = streetAddress;
  }

    public StreetAddress getStreetAddress() {
        return streetAddress;
    }

    public void setPhone(String phone){

    }

  public String getPhone(){
    return null;
  }
  
  public void setEmail(String email){}

  public String getEmail(){
    return null;
  }
  
}
