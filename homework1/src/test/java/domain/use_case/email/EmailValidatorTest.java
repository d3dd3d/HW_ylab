package domain.use_case.email;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.d3d.domain.use_case.email.EmailValidator;

public class EmailValidatorTest {
    @ParameterizedTest
    @CsvSource(value = {
            "user@gmail.com, true",
            "user@gmail.com.ru, true",
            "11111, false",
            "0@gmail.com, true"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void blockUserTest(String email, boolean result) {
        EmailValidator emailValidator = new EmailValidator();
        assertEquals(emailValidator.validate(email), result);
    }

}
