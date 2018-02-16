package Crypto;

public class EncryptionManager {
   protected static int p=1;
   String data;

    public EncryptionManager(String s) 
    {
        data=s;
    }
    public final String encrypt()
    {
        int offset=40,mod=5,SecurityFactor=10;
        String alt="";
        int truncate=(int)(Math.random()*SecurityFactor);
        for (int i=0;i<data.length();i++)
        {
            int no=(int)data.charAt(i);
            int que=(no/mod)+offset;
            int remain=no%mod;
            alt=alt+(char)que+(char)((int)Math.pow(remain, p+DecryptionManager.q) + offset);
        }
        for (int i=0;i<truncate;i++)
        {
            alt=alt+(char)(Math.random()*10+offset);
        }
        alt=alt+truncate;
        return alt;
    }   
}
