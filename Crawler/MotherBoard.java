
package Crawler;


public class MotherBoard extends Product {
   
    private  String SocketType;
    private  String Chipset;
    private  String FormFactor;
   
    
    
    
    public MotherBoard()
    {
        super();  
        SocketType="";
        Chipset="";
        FormFactor="";
    }

    public String getSocketType() {
        return SocketType;
    }

    public void setSocketType(String SocketType) {
        this.SocketType = SocketType;
    }

    public String getChipset() {
        return Chipset;
    }

    public void setChipset(String Chipset) {
        this.Chipset = Chipset;
    }

    public String getFormFactor() {
        return FormFactor;
    }

    public void setFormFactor(String FormFactor) {
        this.FormFactor = FormFactor;
    }

    
}
