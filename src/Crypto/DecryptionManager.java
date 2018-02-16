package Crypto;

public class DecryptionManager {
    protected static int q=2;
    String cryptedData;

    public DecryptionManager(String s) 
    {
        cryptedData=s;
    }
    public final String decrypt()
    {
        int que[]=new int[cryptedData.length()];
        int remain[]=new int[cryptedData.length()];
        int offset=40,mod=5; String alt="";
        int truncate=Integer.parseInt(""+cryptedData.charAt(cryptedData.length()-1)) + 1;
        cryptedData=cryptedData.substring(0,cryptedData.length() - truncate );
        
        for (int i=0;i<cryptedData.length();i++)
        {
            char ch=cryptedData.charAt(i);
            if (i%2==0)
                que[i]=(int)ch - offset;
            else
            {
                remain[i]=(int)ch - offset;
                remain[i]=(int)Math.ceil( Math.pow(remain[i], (double)1/(q+EncryptionManager.p)) );
                alt=alt+(char)(que[i-1]*mod+remain[i]);
            }
        }
        return alt;
    }
}
