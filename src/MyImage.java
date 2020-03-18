import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MyImage {
    private BufferedImage source;
    private int[][][] matrix;

    private BufferedImage result;

    public MyImage(String path, String imageName) {
        try {
            File image = new File(path, imageName);
            source = ImageIO.read(image);
            result = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
        } catch (IOException e) {
            System.out.println("Wrong path to image");
        }
    }

    public void pixelMatrix() {
        this.matrix = new int[source.getWidth()][source.getHeight()][3];
        for (int y = 0; y < source.getHeight(); y++) {
            for (int x = 0; x < source.getWidth(); x++) {
                // Получаем цвет текущего пикселя
                Color color = new Color(source.getRGB(x, y));
                // Получаем каналы этого цвета
                int blue = color.getBlue();

                int red = color.getRed();
                int green = color.getGreen();
                matrix[x][y][0] = red;
                matrix[x][y][1] = blue;
                matrix[x][y][2] = green;
            }
        }
    }

    public void showMatrix() {
        for (int y = 0; y < source.getHeight(); y++) {
            for (int x = 0; x < source.getWidth(); x++) {
                for (int i = 0; i < 3; i++) {
                    System.out.print(matrix[x][y][i]);
                    System.out.print(" ");
                }
                System.out.print("||");
            }
            System.out.println();
        }
    }

    public void noize() {
        Random random = new Random();
        int noize;
        int[][][] newMatrix = matrix.clone();
        for (int y = 0; y < source.getHeight(); y++) {
            for (int x = 0; x < source.getWidth(); x++) {
                for (int i = 0; i < 3; i++) {
                    noize = random.nextInt(256 - 0);
                    newMatrix[x][y][i] = noize;
                    /* 1 вариант заменить метод на домнажение на случайное число
                     * */
                }
            }
        }


    }

    public void noize1() {

        int[][][] newMatrix = matrix.clone();
        for (int y = 0; y < source.getHeight(); y++) {
            for (int x = 0; x < source.getWidth(); x++) {
                for (int i = 0; i < 3; i++) {

                    newMatrix[x][y][i] =(int) (newMatrix[x][y][i] * Math.random());
                    /* 1 вариант заменить метод на домнажение на случайное число
                    1) дискретное фурье преобразование от картинки (понять частотность вектора) ( пробежать по цветам пикселей и посторить график изменения значения пикселя от частоты)
                    2) на графике определить область значения амплитуды которой меньше чем какое то значение. Добавить туда константу и выравнить график. Посмотреть что будет. Потом вычесть константу и посмотреть отфильтруется ли картинка
                     * */
                }
            }
        }


    }

    public void createNoizeImage() {
        int[][][] newMatrix = matrix.clone();
        for (int y = 0; y < source.getHeight(); y++) {
            for (int x = 0; x < source.getWidth(); x++) {
                int newRed = newMatrix[x][y][0];
                int newGreen = newMatrix[x][y][1];
                int newBlue = newMatrix[x][y][2];
                Color newColor = new Color(newRed, newGreen, newBlue);
                result.setRGB(x, y, newColor.getRGB());
            }
        }
        try {
            File output = new File("D:\\kursach","newPepe.jpg");
            ImageIO.write(result, "jpg", output);
        } catch (IOException e) {
            System.out.println("Something wrong during output");
        }

    }
}