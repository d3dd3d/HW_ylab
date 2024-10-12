package domain.use_case.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.d3d.domain.db.Data;
import com.d3d.domain.model.User;
import com.d3d.domain.use_case.admin.AdminListUser;

public class AdminListUserTest {
    @ParameterizedTest
    @CsvSource(value = {
        "User1, user1@gmail.com, 1",
        "User2, user2@gmail.com, 2"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void getListTest(String name, String email, String password){
        Data.getUserList().add(new User(name, password, email, false));
        assertEquals(AdminListUser.getList(), Data.getUserList().getList().values().stream().collect(Collectors.toList()));
    }
}
