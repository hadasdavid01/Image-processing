public class Editor2 {
      /*

           Assignment number : 6
           File Name : Editor2 .java
           Name: Hadas David
           Student ID : 207643487
           Email : Hadasd105@gmail.com

       */

      /*
      the program call one of the three functions in ImageEditing according to the given operation,
       and display the output image using the show function
       */

    public static void main(String[] args){
        String fileName = args[0];
        int width = Integer.parseInt(args[1]);
        int height = Integer.parseInt(args[2]);
        ImageEditing.show(ImageEditing.scale(ImageEditing.read(fileName),width,height));
    }
}
