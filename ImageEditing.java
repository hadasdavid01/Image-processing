public class ImageEditing {
    public static void main(String[] args) {
    }
     /*

		Assignment number : 6
		File Name : ImageEditing.java
		Name: Hadas David
		Student ID : 207643487
		Email : Hadasd105@gmail.com

	*/

        /**
         * Renders an image using StdDraw.
         * The input array is assumed to contain integers in the range [0,255].
         * With the third dimension being of size 3.
         *
         * @param pic - the image to show.
         */
        public static void show ( int[][][] pic){
            StdDraw.setCanvasSize(pic[0].length, pic.length);
            int height = pic.length;
            int width = pic[0].length;
            StdDraw.setXscale(0, width);
            StdDraw.setYscale(0, height);
            StdDraw.show(30);
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    StdDraw.setPenColor(pic[i][j][0], pic[i][j][1], pic[i][j][2]);
                    StdDraw.filledRectangle(j + 0.5, height - i - 0.5, 0.5, 0.5);
                }
            }
            StdDraw.show();
        }

// The function receives the name of a PPM file and returns an array containing the image data.
        public static int[][][] read (String filename){
            StdIn.setInput(filename);
            StdIn.readLine();
            int columns = StdIn.readInt();
            int rows = StdIn.readInt();
            StdIn.readLine();
            StdIn.readLine();
            int[][][] image = new int[rows][columns][3];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    image[i][j][0] = StdIn.readInt();
                    image[i][j][1] = StdIn.readInt();
                    image[i][j][2] = StdIn.readInt();
                }
            }
            return image;
        }
// The function writes to standard output the contents of the given 3 dimensional array.
        static void print ( int[][][] source){
            for (int i = 0; i < source.length; i++) {
                for (int j = 0; j < source[0].length; j++) {
                    System.out.printf("%3d ", source[i][j][0]);
                    System.out.printf("%3d ", source[i][j][1]);
                    System.out.printf("%3d   ", source[i][j][2]);
                }
                System.out.println();
            }
        }

/*  The function is designed to flip the given image, horizontally.
    The function receives an image matrix as input and returns a new image matrix as output.
 */
        public static int[][][] flipHorizontally ( int[][][] source){
            int[][][] newImage = new int[source.length][source[0].length][3];
            for (int i = 0; i < newImage.length; i++) {
                for (int j = 0; j < newImage[0].length; j++) {
                    newImage[i][j][0] = source[i][source[i].length - 1 - j][0];
                    newImage[i][j][1] = source[i][source[i].length - 1 - j][1];
                    newImage[i][j][2] = source[i][source[i].length - 1 - j][2];
                }
            }
            return newImage;

        }
/*
    The function is designed to flip the given image,  vertically.
    The function receives an image matrix as input and returns a new image matrix as output.
 */
        public static int[][][] flipVertically ( int[][][] source){
            int[][][] newImage = new int[source.length][source[0].length][3];
            for (int i = 0; i < newImage.length; i++) {
                for (int j = 0; j < newImage[0].length; j++) {
                    newImage[i][j][0] = source[source.length - 1 - i][j][0];
                    newImage[i][j][1] = source[source.length - 1 - i][j][1];
                    newImage[i][j][2] = source[source.length - 1 - i][j][2];
                }
            }
            return newImage;
        }

// The function takes a digital image and returns the average of its colors.
        public static double average ( int[][][] pixel){
            int sum = 0;
            double count = (pixel.length) * (pixel[0].length) * 3;
            double average = 0;
            for (int i = 0; i < pixel.length; i++) {
                for (int j = 0; j < pixel[0].length; j++) {
                    for (int h = 0; h < 3; h++)
                        sum += pixel[i][j][h];
                }
                StdIn.readLine();
            }
            average = sum / count;
            return average;
        }

        // This function takes an RGB image as input and returns a segmented version of this image.
        public static int[][][] segement ( int[][][] source){
            int[][][] blackWhite = new int[source.length][source[0].length][3];
            double t = average(source);
            double averageSoucre = 0;
            double sum = 0;
            for (int i = 0; i < source.length; i++) {
                for (int j = 0; j < source[0].length; j++) {
                    for (int h = 0; h < 3; h++) {
                        sum += source[i][j][h];
                    }
                    averageSoucre = sum / 3;
                    if (averageSoucre > t) {
                        blackWhite[i][j][0] = 255;
                        blackWhite[i][j][1] = 255;
                        blackWhite[i][j][2] = 255;
                    } else {
                        blackWhite[i][j][0] = 0;
                        blackWhite[i][j][1] = 0;
                        blackWhite[i][j][2] = 0;
                    }
                    sum = 0;
                    averageSoucre = 0;

                }
            }
            return blackWhite;
        }

// The function takes as input a digital image and two dimensions and returns a scaled version of the digital image according to the specified dimensions.
        public static int[][][] scale ( int[][][] source, int width, int height){
            int[][][] newImage = new int[height][width][3];
            double h0 = source.length;
            double w0 = source[0].length;
            for (int i = 0; i < newImage.length; i++) {
                for (int j = 0; j < newImage[0].length; j++) {
                    for (int r = 0; r < 3; r++) {
                        newImage[i][j][r] = source[(int) (i * (h0 / height))][(int) (j * (w0 / width))][r];
                    }
                }
            }
            return newImage;
        }

    /*the functions recieves 2 pixels and a number alpha
	returns a new pixel which represents the average of the two pixels
	*/
        public static int[] blend ( int[] pixel1, int[] pixel2, double alpha){
            int[] arr = new int[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = (int) (alpha * pixel1[i] + (1 - alpha) * pixel2[i]);
            }
            return arr;
        }

        //The function returns the alpha-blending of the two given source images.
        public static int[][][] combine ( int[][][] source1, int[][][] source2, double alpha){
            int[][][] newImage = new int[source1.length][source1[0].length][3];
            for (int i = 0; i < source1.length; i++) {
                for (int j = 0; j < source1[0].length; j++) {
                    newImage[i][j] = blend(source1[i][j], source2[i][j], alpha);
                }
            }
            return newImage;
        }

        // The function public static void morph (int[][][] source, int[][][] target, int n) morphs the source image into the target image in  steps
        public static void morph ( int[][][] source, int[][][] target, int n){
            int[][][] sourceCopie = new int[source.length][source[0].length][3];
            if (source.length != target.length || source[0].length != target[0].length) {
                sourceCopie = scale(source, target[0].length, target.length);
            } else {
                sourceCopie = source;
            }
            double alpha;
            for (int i = 0; i <= n; i++) {
                alpha = (double) (n - i) / n;
                show(combine(sourceCopie, target, alpha));
            }
        }

    }




