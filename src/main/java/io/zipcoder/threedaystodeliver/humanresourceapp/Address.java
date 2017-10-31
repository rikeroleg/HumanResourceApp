class Address{

  String addressLine1;
  String addressLine2;
  String city;
  String state;
  String zip;//String to account for possible non-numerical postal codes
  
  public Address(){
  }
  
  public Address(  String addressLine1,
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
  
  public Address getAddress(){
    return this;
  }
  
  public changeAddress( String addressLine1,
                   String addressLine2,
                   String city,
                   String state,
                   String zip){}
}
