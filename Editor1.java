public class Editor1 {
    public static void main(String[] args){
        /*

           Assignment number : 6
           File Name : Editor2 .java
           Name: Hadas David
           Student ID : 207643487
           Email : Hadasd105@gmail.com

       */

        /*  the program should read the given file ,
           call one of the three functions according to the given operation, and display the output image
        */

        String fileName = args[0];
        String function = args[1];
        int [][][] image = ImageEditing.read(fileName);

        if (function == "fh"){
            ImageEditing.show(ImageEditing.flipHorizontally(image));
        }
        if (function == "fv"){
            ImageEditing.show(ImageEditing.flipVertically(image));
        }
        if (function == "se"){
            ImageEditing.show(ImageEditing.segement(image));
        }
    }

}
