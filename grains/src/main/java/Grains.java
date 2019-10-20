import java.math.BigInteger;

class Grains {

    private static final String INVALID_SQUARE_MSG = "square must be between 1 and 64";
    private static final int MIN_SQUARE_NUMBER = 1;
    private static final int MAX_SQUARE_NUMBER = 64;

    BigInteger computeNumberOfGrainsOnSquare(final int square) {
        checkSquare(square);
        BigInteger res = new BigInteger("2", 10);
        return res.pow(square-1);
    }

    void checkSquare(final int square) {
        if(square < MIN_SQUARE_NUMBER || square > MAX_SQUARE_NUMBER){
            throw new IllegalArgumentException(INVALID_SQUARE_MSG);
        }
    }

    BigInteger computeTotalNumberOfGrainsOnBoard() {

        BigInteger result = new BigInteger("0", 10);
        int squareIndex = MIN_SQUARE_NUMBER;
        while(squareIndex <= MAX_SQUARE_NUMBER){
            result = result.add(computeNumberOfGrainsOnSquare(squareIndex));
            squareIndex++;
        }
        return result;
    }

}
