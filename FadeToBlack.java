public class FadeToBlack {
        /*

            Assignment number : 6
            File Name : FadeToBlack.java
            Name: Hadas David
            Student ID : 207643487
            Email : Hadasd105@gmail.com

        */
        /*
        The program produces a segmented version of the image and then displays an animated step-wise
        view of how the given colorful image fades into a black and white segmented image.
         */

    public static void main(String[] args){
        String image = args[0];
        int n = Integer.parseInt(args[1]);
        ImageEditing.morph(ImageEditing.read(image),(ImageEditing.segement(ImageEditing.read(image))),n);

    }
}
