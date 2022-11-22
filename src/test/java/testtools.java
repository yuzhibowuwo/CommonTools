import com.common.ListTools.ListBaseTools;
import com.common.data.IDCard;

import java.text.ParseException;

/**
 * CommonTools
 * PACKAGE_NAME
 * 2022/11/20
 **/
public class testtools {
    static ListBaseTools testTools=new ListBaseTools();

    public static void main(String[] args) {
    /*    List<String> test=new ArrayList<>();
        List<String> test1=new ArrayList<>();
            test.add("test1");
            test.add("test2");
            test1.add("test1");
        //test1.removeAll(test);
        test.removeAll(test1);
       //     System.out.println(test1);
        System.out.println(testTools.DeleteSameItem(test,test1));*/
        for(int i=0;i<10;i++) {
            IDCard test = new IDCard();
            String testString = null;
            try {
                testString = test.getProviceCode().get("西城区") + test.RandomBirthData("19910102", "20221128") + test.getPoliceCode() + test.GetGenderCode(1);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            testString = testString + test.CaluCrc(testString);
            System.out.println(testString);
        }




    }
}
