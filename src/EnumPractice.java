enum Color 
{ 
    RED, GREEN, BLUE; 
  
    // enum constructor called separately for each 
    // constant 
    private Color() 
    { 
        System.out.println("Constructor called for : " + 
        this.toString()); 
    } 
  
    // Only concrete (not abstract) methods allowed 
    public void colorInfo() 
    { 
        System.out.println("Universal Color"); 
    } 
} 
public class EnumPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Color c1 = Color.RED; 
        System.out.println(c1); 
        c1.colorInfo(); 

	}

}
