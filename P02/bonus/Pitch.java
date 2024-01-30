enum Pitch {
    C("C"), Db("D♭"), D("D"), Eb("E♭"), E("E"), F("F"), 
    Gb("G♭"), G("G"), Ab("A♭"), A("A"), Bb("B♭"), B("B");

    private Pitch(String flat) {
        this.flat = flat;
    }
    private String flat;

    @Override
    public String toString()
    {
        return flat;
    }
}