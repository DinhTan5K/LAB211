/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week2.Matrix;


/**
 *
 * @author LENOVO
 */
public class Matrix {
    private int[][] matrix;
    private int rows;
    private int cols;
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new int[rows][cols];
    }

    public Matrix(int[][] matrix) {
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.matrix = matrix;
    }


    public Matrix additionMatrix(Matrix matrix2) {
        if (this.rows != matrix2.rows || this.cols != matrix2.cols) {
            throw new IllegalArgumentException("Matrix dimensions must match for addition");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.matrix[i][j] = this.matrix[i][j] + matrix2.matrix[i][j];
            }
        }
        return result;
    }

    public Matrix subtractionMatrix(Matrix matrix2) {
        if (this.rows != matrix2.rows || this.cols != matrix2.cols) {
            throw new IllegalArgumentException("Matrix dimensions must match for subtraction");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.matrix[i][j] = this.matrix[i][j] - matrix2.matrix[i][j];
            }
        }
        return result;
    }

    public Matrix multiplicationMatrix(Matrix matrix2) {
        if (this.cols != matrix2.rows) {
            throw new IllegalArgumentException("Matrix dimensions are incompatible for multiplication");
        }
        Matrix result = new Matrix(this.rows, matrix2.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < matrix2.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result.matrix[i][j] += this.matrix[i][k] * matrix2.matrix[k][j];
                }
            }
        }
        return result;
    }


    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("["+matrix[i][j] + "]");
            }
            System.out.println();
        }
    }
}
