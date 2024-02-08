package store;

public enum Exposure {
    SUN, PARTSUN, SHADE;

    @Override
    public String toString() {
        switch (this) {
            case SUN: return "full sun";
            case PARTSUN: return "part sun";
            case SHADE: return "full shade";
        }
        return "Error exposure invalid";
    }
}