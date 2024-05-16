
public class Main {
    public static void main(String[] args) {
        String[][] matrix = new String[4][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = String.valueOf(i + j);
            }
        }
//        matrix[1][1] = "Hello";
        ArrayValueCalculator calc = new ArrayValueCalculator();
        try {
            System.out.println("Sum of the matrix: " + calc.doCalac(matrix));
        } catch (ArraySizeException | ArrayDataException e) {
            System.out.println(e);
        }

    }
}