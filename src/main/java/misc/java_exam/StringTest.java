package misc.java_exam;

/**
 *
 */
public class StringTest {
    public static void main(String[] args) {
        String s1="A", s2="a", s3="b";
        s1.toLowerCase();
        s3.replace("b","a");
        System.out.println(s1.equals(s2) + "," + s2.equals(s3));
    }
}
