import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class JUnitQuiz {

    @Test
    public void JunitQuizTest(){
        String name1 = "Hong";
        String name2 = "Hong";
        String name3 = "dong";

        //모든 변수가 NotNull인지 확인
        assertThat(name1).isNotNull();
        assertThat(name2).isNotNull();
        assertThat(name3).isNotNull();

        // "Hong" == "Hong" 이므로 isEqualTo로 수정하거나 값을 변경해야 합니다.
        assertThat(name1).isEqualTo(name2);

        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        // 1은 2보다 크지 않으므로 isLessThan으로 수정
        assertThat(num1).isLessThan(num2);
        assertThat(num1).isLessThan(num2);
    }

}
