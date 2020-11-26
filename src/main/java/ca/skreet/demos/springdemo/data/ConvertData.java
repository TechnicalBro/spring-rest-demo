package ca.skreet.demos.springdemo.data;


import ca.skreet.demos.springdemo.utils.RegexValues;
import ca.skreet.demos.springdemo.utils.RomanNumeral;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class ConvertData {

    private final String input;

    @Getter
    private final String output;

    public ConvertData(String input) {
        this.input = input;
        this.output = _internalConversion();
    }

    protected String _internalConversion() {
        RomanNumeral romans = null;

        if (StringUtils.isNumeric(input)) {
            romans = new RomanNumeral(Integer.parseInt(input));
        } else {
            romans = new RomanNumeral(input);
        }

        /* If the input isn't already roman numbers, assign output to roman numbers */
        if (!input.matches(RegexValues.ROMAN_NUMERAL_VALIDATION)) {

            /* Not valid input so return */
            if (!StringUtils.isNumeric(input)) {
                return "Invalid Input";
            }

            return romans.toString();
        } else {
            return String.valueOf(romans.toInt());
        }

    }
}
