package src.String;

public class StringPool {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";

        String str3 = new String("abc");
        String str4 = new String("abc");
        String str5 = str1;
        String str6 = str3;
        String str7 = str4;

        System.out.println(str1 == str2);
        System.out.println(str3 == str4);
        System.out.println(str1 == str3);
        System.out.println(str1 == str5);
        System.out.println(str5 == str6);
        System.out.println(str7 == str6);
        System.out.println("----------------");
        System.out.println(str1.equals(str2));
        System.out.println(str3.equals(str4));
        System.out.println(str1.equals(str3));
        System.out.println(str1.equals(str5));
        System.out.println(str5.equals(str6));
        System.out.println(str7.equals(str6));
    }
}
