/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import Crypto.EncryptionManager;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;

public class SharedRes{
    
    protected static String EmailFrom = "bizcalteam@gmail.com";
    protected static String EmailPass = new EncryptionManager("ENQUIRYbizcal").encrypt();
    public static Image icon;

    static {
        try {
            icon = ImageIO.read(SharedRes.class.getResourceAsStream("/resources/images/icon.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final static boolean isPhoneNoValid(String phn) {
        if (phn.length() != 10 && phn.length() != 8) {
            return false;
        } else {
            for (int i = 0; i < phn.length(); i++) {
                if (!Character.isDigit(phn.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public final static String truncateChar(String s, char ch) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                s = s.substring(0, i) + s.substring(i + 1);
                i--;
            }
        }
        return s;
    }

    public final static String chopQuotes(String s) {
        s = SharedRes.truncateChar(s, '\'');
        s = SharedRes.truncateChar(s, '\"');
        return s;
    }

    public final static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public final static boolean isDateValid(String dateToValidate, String dateFromat) {

        if (dateToValidate == null) {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);

        try {
            Date date = sdf.parse(dateToValidate);

        } catch (ParseException e) {
            return false;
        }

        return true;
    }

}
