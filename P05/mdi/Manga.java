package store;
public class Manga{
    public static void main(String args[]){
        if(args[0] != ""){
            Controller controller = new Controller(args[0]);
        }
        else{
            Controller controller = new Controller("Generic Store");
        }
        controller.mdi();
    }
}