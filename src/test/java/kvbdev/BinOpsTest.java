package kvbdev;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class BinOpsTest {

    BinOps sut;

    @BeforeEach
    void setUp() {
        sut = new BinOps();
    }

    @AfterEach
    void tearDown() {
        sut = null;
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"randomString", "0123"})
    void sum_number_format_failure(String arg) {
        assertThrowsExactly(NumberFormatException.class, () -> sut.sum(arg, arg));
    }

    @ParameterizedTest
    @MethodSource("sumSource")
    void sum_success(Integer ia, Integer ib, Integer resultInt, String binArg0, String binArg1, String binResult) {
        System.out.printf("%d + %d = %d (%s)%n", ia, ib, resultInt, binResult);
        assertThat(sut.sum(binArg0, binArg1), equalTo(binResult));
    }

    public static Stream<Arguments> sumSource() {
        return Arrays.stream(new int[][]{
                {2, 3, 5}, {4, 5, 9}, {6, 7, 13}, {8, 9, 17}
        }).map(three -> Arguments.of(
                three[0],
                three[1],
                three[2],
                Integer.toBinaryString(three[0]),
                Integer.toBinaryString(three[1]),
                Integer.toBinaryString(three[2])
        ));
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"randomString", "0123"})
    void mult_number_format_failure(String arg) {
        assertThrowsExactly(NumberFormatException.class, () -> sut.sum(arg, arg));
    }


    @ParameterizedTest
    @MethodSource("multSource")
    void mult_success(Integer ia, Integer ib, Integer resultInt, String binArg0, String binArg1, String binResult) {
        System.out.printf("%d * %d = %d (%s)%n", ia, ib, resultInt, binResult);
        assertThat(sut.mult(binArg0, binArg1), equalTo(binResult));
    }

    public static Stream<Arguments> multSource() {
        return Arrays.stream(new int[][]{
                {2, 3, 6}, {4, 5, 20}, {6, 7, 42}, {8, 9, 72}
        }).map(three -> Arguments.of(
                three[0],
                three[1],
                three[2],
                Integer.toBinaryString(three[0]),
                Integer.toBinaryString(three[1]),
                Integer.toBinaryString(three[2])
        ));
    }

}