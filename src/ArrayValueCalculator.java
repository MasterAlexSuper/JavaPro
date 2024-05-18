import java.util.Arrays;

public class ArrayValueCalculator {


    public int doCalac(String[][] matrix) throws ArraySizeException, ArrayDataException {
        System.out.println(Arrays.deepToString(matrix));
        int sum = 0;
        if (matrix.length == 4) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i].length != 4) {
                    throw new ArraySizeException("Array size is not correct, check an array and try again");
                }
                for (int j = 0; j < matrix[i].length; j++) {
                    try {
                        sum += Integer.parseInt(matrix[i][j]);
                    } catch (NumberFormatException e) {
                        throw new ArrayDataException("Array data in row:" + ++i + " element:" + ++j + " not correct");
                    }
                }
            }
        } else {
            throw new ArraySizeException("Array size is not correct, check an array and try again");
        }
        return sum;
    }
}
