
package Crawler;


public class MobilePhone extends Product {
    
    private  String type; 
    private   String OS;        
    
    
    public MobilePhone()
    {
        super(); 
        type="";
        OS="";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }
  
}
