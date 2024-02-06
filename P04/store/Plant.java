package.store;
public class Plant extends Product(){
    public Plant(String species, double price, Exposure exposure){
        super(species, price);
        this.exposure = exposure;
    }
    public Exposure getExposure(){
        return exposure;
    }
    private Exposure exposure;   
}