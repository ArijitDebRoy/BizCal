package Utility;

import java.math.BigDecimal;

class DigConvert {

    static String getUnits(char t) {
        switch (t) {
            case '1':
                return " One";
            case '2':
                return " Two";
            case '3':
                return " Three";
            case '4':
                return " Four";
            case '5':
                return " Five";
            case '6':
                return " Six";
            case '7':
                return " Seven";
            case '8':
                return " Eight";
            case '9':
                return " Nine";
            default:
                return "";
        }
    }

    static String getTens(char t, char u) {
        switch (t) {
            case '1':
                switch (u) {
                    case '1':
                        return " Eleven";
                    case '2':
                        return " Twelve";
                    case '3':
                        return " Thirteen";
                    case '4':
                        return " Fourteen";
                    case '5':
                        return " Fifteen";
                    case '6':
                        return " Sixteen";
                    case '7':
                        return " Seventeen";
                    case '8':
                        return " Eighteen";
                    case '9':
                        return " Nineteen";
                    default:
                        return " Ten";
                }
            case '2':
                return " Twenty" + getUnits(u);
            case '3':
                return " Thirty" + getUnits(u);
            case '4':
                return " Forty" + getUnits(u);
            case '5':
                return " Fifty" + getUnits(u);
            case '6':
                return " Sixty" + getUnits(u);
            case '7':
                return " Seventy" + getUnits(u);
            case '8':
                return " Eighty" + getUnits(u);
            case '9':
                return " Ninety" + getUnits(u);
            case '0':
                return getUnits(u);
            default:
                return "";
        }
    }

    static String getHundreds(char t) {
        return (t != '0') ? getUnits(t) + " Hundred" : "";
    }

    static String getThousands(char u, char t) {
        return (t != '0') ? getTens(u, t) + " Thousand" : "";
    }

    static String getLakhs(char u, char t) {
        return (t != '0') ? getTens(u, t) + " Lakh" : "";
    }

    static String getCrores(char u, char t) {
        return (t != '0') ? getTens(u, t) + " Crore" : "";
    }

    private static int round(double d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(d);
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.intValue();
    }

    static String convertToText(String s, String pretext) {
        String finalText = pretext;
        s = String.valueOf(round(Double.parseDouble(s), 0));
        switch (s.length()) {
            case 1:
                finalText += getUnits(s.charAt(s.length() - 1));
                break;
            case 2:
                finalText += getTens(s.charAt(s.length() - 2), s.charAt(s.length() - 1));
                break;
            case 3:
                finalText += getHundreds(s.charAt(s.length() - 3)) + getTens(s.charAt(s.length() - 2), s.charAt(s.length() - 1));
                break;
            case 4:
                finalText += getThousands('0', s.charAt(s.length() - 4)) + getHundreds(s.charAt(s.length() - 3)) + getTens(s.charAt(s.length() - 2), s.charAt(s.length() - 1));
                break;
            case 5:
                finalText += getThousands(s.charAt(s.length() - 5), s.charAt(s.length() - 4)) + getHundreds(s.charAt(s.length() - 3)) + getTens(s.charAt(s.length() - 2), s.charAt(s.length() - 1));
                break;
            case 6:
                finalText += getLakhs('0', s.charAt(s.length() - 6)) + getThousands(s.charAt(s.length() - 5), s.charAt(s.length() - 4)) + getHundreds(s.charAt(s.length() - 3)) + getTens(s.charAt(s.length() - 2), s.charAt(s.length() - 1));
                break;
            case 7:
                finalText += getLakhs(s.charAt(s.length() - 7), s.charAt(s.length() - 6)) + getThousands(s.charAt(s.length() - 5), s.charAt(s.length() - 4)) + getHundreds(s.charAt(s.length() - 3)) + getTens(s.charAt(s.length() - 2), s.charAt(s.length() - 1));
                break;
            case 8:
                finalText += getCrores('0', s.charAt(s.length() - 8)) + getLakhs(s.charAt(s.length() - 7), s.charAt(s.length() - 6)) + getThousands(s.charAt(s.length() - 5), s.charAt(s.length() - 4)) + getHundreds(s.charAt(s.length() - 3)) + getTens(s.charAt(s.length() - 2), s.charAt(s.length() - 1));
                break;
            case 9:
                finalText += getCrores(s.charAt(s.length() - 9), s.charAt(s.length() - 8)) + getLakhs(s.charAt(s.length() - 7), s.charAt(s.length() - 6)) + getThousands(s.charAt(s.length() - 5), s.charAt(s.length() - 4)) + getHundreds(s.charAt(s.length() - 3)) + getTens(s.charAt(s.length() - 2), s.charAt(s.length() - 1));
                break;

            default:
                finalText += "Sorry, unable to convert. Only numbers upto 3 digits are supported";
                break;
        }
        return ((finalText.trim().length() == 0) ? "Zero" : finalText.trim());
    }
}
