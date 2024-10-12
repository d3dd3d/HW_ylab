package domain.use_case.habit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.d3d.domain.db.Data;
import com.d3d.domain.model.User;
import com.d3d.domain.use_case.habit.HabitManage;

public class HabitManageTest {
    @ParameterizedTest
    @CsvSource(value = {
            "user@gmail.com, true",
            "user@gmail.com.ru, true",
            "11111, false",
            "0@gmail.com, true"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void add(){
        User user = new User("User", "1", "user@gmail.com", false);
        Data.getUserList().add(user);
        try{
            HabitManage.add(null, null);
        }
        catch(Exception ex){
            assertEquals(true, false);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {
            "user@gmail.com, true",
            "user@gmail.com.ru, true",
            "11111, false",
            "0@gmail.com, true"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void updateName(){

    }

    @ParameterizedTest
    @CsvSource(value = {
            "user@gmail.com, true",
            "user@gmail.com.ru, true",
            "11111, false",
            "0@gmail.com, true"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void updateDescription(){

    }

    @ParameterizedTest
    @CsvSource(value = {
            "user@gmail.com, true",
            "user@gmail.com.ru, true",
            "11111, false",
            "0@gmail.com, true"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void updateStatus(){

    }

    @ParameterizedTest
    @CsvSource(value = {
            "user@gmail.com, true",
            "user@gmail.com.ru, true",
            "11111, false",
            "0@gmail.com, true"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void updateRegularity(){

    }

    @ParameterizedTest
    @CsvSource(value = {
            "user@gmail.com, true",
            "user@gmail.com.ru, true",
            "11111, false",
            "0@gmail.com, true"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void delete(){

    }

    @ParameterizedTest
    @CsvSource(value = {
            "user@gmail.com, true",
            "user@gmail.com.ru, true",
            "11111, false",
            "0@gmail.com, true"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void read(){

    }
}
