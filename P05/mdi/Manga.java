package mdi;
public class Manga{
    public static void main(String args[]){
        // if(args[0] != ""){
        //     Controller controller = new Controller(args[0]);
        //     controller.mdi();
        // }
        // else{
        //     Controller controller = new Controller("Generic Store");
        //     controller.mdi();
        // }
        Controller controller = new Controller("Generic Store");
        controller.mdi();
    }
}