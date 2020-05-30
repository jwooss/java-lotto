package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다")
    @Test
    void create_LottoNumbers_ExceptionThrown() {
        assertThatThrownBy(() -> LottoTicket.create(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
