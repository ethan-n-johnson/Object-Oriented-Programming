package.store;
public enum Exposure(){
    SHADE{
        @Override
        public String toString(){
            return "full shade";
        }
    };
    PARTSUN{
        @Override
        public String toString(){
            return "part sun";
        }
    };
    SUN{
        @Override
        public String toString(){
            return "full sun";
        }
    };
}