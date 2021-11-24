package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if (text == null) {
            return 0;
        }
        if (text.isEmpty()) {
            return 0;
        }

        String[] dividedNumbers = getDividedNumber(text);
        int[] intNumbers = strToInt(dividedNumbers);

        if(intNumbers.length == 1) {
            return intNumbers[0];
        }
        return calculate(intNumbers);
    }

    private static int calculate(int[] intNumbers){
        int sum = 0;
        for(int i = 0; i < intNumbers.length; i++){
            sum = Operator.PLUS.getBiFunction().apply(sum, intNumbers[i]);
        }
        return sum;
    }

    private static String[] split(String text) {
        return text.split(DEFAULT_DELIMITER);
    }

    private static String[] getDividedNumber(String text) {
        if (RegExType.validate(RegExType.DEFAULT, text)) {
            return getCustomDelimiterNumber(text);
        }
        return getDefaultDelimiterNumber(text);
    }

    private static String[] getDefaultDelimiterNumber(String text) {
        return text.split(",|:");
    }

    //커스텀 구분자인지 아닌지
    private static String[] getCustomDelimiterNumber(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return tokens;
        }
        return null;
    }

    private static int[] strToInt(String[] strNumbers) {
        int[] intNumbers = new int[strNumbers.length];

        for (int i = 0; i < strNumbers.length; i++) {
            String strNumber = strNumbers[i];
            //문자열이 숫자가 아니면 예외
            isNumberFormatAndPositive(strNumber);
            intNumbers[i] = Integer.parseInt(strNumber);
        }
        return intNumbers;
    }

    private static void isNumberFormatAndPositive(String text) {
        if (!Character.isDigit(text.charAt(0))) {
            throw new IllegalArgumentException();
        }
    }

}