public class User {


    // data-fields 
    private String userName; 
    private String password; 
    private String phoneNumber; 
    private String address; 



    // constructors 
    public User(String userName, String password, String phoneNumber, String address) {
        this.setUserName(userName); 
        this.setPassword(password); 
        this.setPhoneNumber(phoneNumber); 
        this.setAddress(address);  
    } 
 

     
    // getters 
    public String getUserName() {
        return this.userName; 
    } 
    public String getPassword() {
        return this.password; 
    } 
    public String getPhoneNumber() {
        return this.phoneNumber; 
    } 
    public String getAddress() {
        return this.address; 
    } 


    // setters 
    public void setUserName(String userName) {
        this.userName = userName; 
    } 
    public void setPassword(String password) {
        this.password = password; 
    } 
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber; 
    } 
    public void setAddress(String address) {
        this.address = address; 
    } 

}
