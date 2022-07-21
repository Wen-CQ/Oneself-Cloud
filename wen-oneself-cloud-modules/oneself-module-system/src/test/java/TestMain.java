//import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {


        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("1");
        Boolean is = false;
        for (String s:list) {
            String ss = create(s, is);
            System.out.println(s);
            System.out.println(is);
        }
        System.out.println(list);

    }

    public static String create(String s, Boolean is){
        if (s.equals(2)){
             is=true;
             return "2";
        }
        return "1";
    }
}
