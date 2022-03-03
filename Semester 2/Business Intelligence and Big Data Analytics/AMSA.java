import java.util.Arrays;
import java.lang.String;

public class AMSA
{
    public static int findCharCount(String stream, char XElement, int random, int length) {
        int charCount = 0;

        for(int i = random; i < length; i++)
        {
            if(stream.charAt(i) == XElement)
            {
                charCount++;
            }
        }

        return charCount;
    }

    public static int estimateValue(int XValue, int length) {
        int expValue = length * (2 * XValue - 1);

        return expValue;
    }

    public static void main(String[] args) {
        String stream = "abcbdacdabdcaab";
        int approxSecondMoment, length = stream.length();
        int[] randomValues = {3, 8, 13};
        char[] XElement = new char[3];
        int[] XValue = new int[3];
        int[] expValue = new int[3];

        for(int i = 0; i < XElement.length; i++)
        {
            XElement[i] = stream.charAt(randomValues[i] - 1);
            XValue[i] = findCharCount(stream, XElement[i], randomValues[i] - 1, length);
            expValue[i] = estimateValue(XValue[i], length);
            
            System.out.println(XElement[i] + " : " + XValue[i]);
        }

        for (int i = 0; i < XElement.length; i++) {
            System.out.println("Expected value for " + XElement[i] + " : " + expValue[i]);
        }

        approxSecondMoment = Arrays.stream(expValue).sum() / 3;
        System.out.println("Approximate Second Moment value = " + approxSecondMoment);

    }
}