import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest {

    @DisplayName("1+2 = 3")
    @Test
    public void JUnitTest() {
        int n1 = 1;
        int n2 = 2;

        int sum = n1 + n2;

        Assertions.assertEquals(3 , sum);
    }

    @DisplayName("1+3 = 4")
    @Test
    public void junitFailTest() {
        int n1 = 1;
        int n2 = 3;

        int sum = n1 + n2;

        // 1+3은 4여야 합니다.
        Assertions.assertEquals(4 , sum);
    }
}
