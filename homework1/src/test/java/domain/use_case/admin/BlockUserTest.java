package domain.use_case.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.d3d.domain.db.Data;
import com.d3d.domain.model.User;
import com.d3d.domain.use_case.admin.BlockUser;

public class BlockUserTest {
    @ParameterizedTest
    @CsvSource(value = {
        "User1, user1@gmail.com, 1",
        "User2, user2@gmail.com, 2"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void blockUserTest(String name, String email, String password){
        User user = new User(name, password, email, false);
        Data.getUserList().add(user);
        try{
            BlockUser.block(user);
            assertEquals(user.isBlocked(),true);
        }
        catch(Exception ex){
            assertEquals(false, true);
        }
    }
}
