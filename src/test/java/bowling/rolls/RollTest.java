package bowling.rolls;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Random;

import static java.lang.Character.isDigit;

public class RollTest {

    @Test
    public void strike_is_a_valid_roll() {
        new Roll('X');
    }

    @Test
    public void miss_is_a_valid_roll() {
        new Roll('-');
    }

    @Test
    public void spare_is_a_valid_roll() {
        new Roll('/');
    }

    @Test
    public void digit_is_a_valid_roll() {
        new Roll('9');
    }

    @Test
    public void anything_else_is_not_a_valid_roll() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> new Roll(aCharDifferentFrom('X', '-', '/'
                        , '1', '2', '3', '4', '5', '6', '7', '8', '9'))
        );
    }

    private Character aCharDifferentFrom(char... chars) {
        char aChar = (char)new Random().nextInt(500);
        while (aChar == ('X') || aChar == ('-') || aChar == ('/') || isDigit(aChar)) {
            aChar = (char)new Random().nextInt(500);
        }
        System.out.println(aChar);
        return aChar;
    }

}