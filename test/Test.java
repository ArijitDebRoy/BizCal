
import java.io.UnsupportedEncodingException;
public class Test {
    
    public static void main(String[] args) throws UnsupportedEncodingException {
//        EncryptionManager en=new EncryptionManager("qwerty~{}");
//    DecryptionManager de=new DecryptionManager(en.encrypt());
//        System.out.println(de.decrypt());
//String string = "\u20B9";
    byte[] utf8 = "\u20B9".getBytes("UTF-8");
        System.out.println(utf8.length);
for (int i=0;i<utf8.length;i++)
            System.out.print(utf8[i]);
   String string = new String("\u20B9".getBytes("UTF-8"), "UTF-8");
    System.out.println("\n"+Character.getName('\u20B9'));
    
//String s="₹";
//
//if(s.equalsIgnoreCase("₹")) {
//  System.out.println("if condition"+s);
//}
    }
}
