package step1;

import java.util.Objects;

public class Operand {

    public final static int ZERO_VALUE = 0;

    private final String operand;

    private Operand(String operand) {
        this.operand = operand;
    }

    public static Operand valueOf(String operand) {
        if (!StringUtils.isNumeric(operand)) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }

        return new Operand(operand);
    }

    public int toPositiveInt() {
        int convertInt = Integer.parseInt(this.operand);

        if (convertInt < Operand.ZERO_VALUE) {
            throw new IllegalStateException("음수는 사용할 수 없습니다.");
        }

        return Integer.parseInt(this.operand);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand1 = (Operand) o;
        return Objects.equals(operand, operand1.operand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand);
    }
}
