package src.String;

public class StringBufferAndBuilder {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("string");
        stringBuffer.append("buffer");
        System.out.println(stringBuffer);

        StringBuilder stringBuilder = new StringBuilder("string");
        stringBuilder.append("builder");
        System.out.println(stringBuilder);

        String s = "Hello";
        String a = new String("abc");
        s.concat("Java");
        System.out.println(s);
        s = s.concat("java");
        System.out.println(s);

    }
}
