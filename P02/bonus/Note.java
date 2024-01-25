enum Pitch {
    // Constructor for enum is undefined
    C, Db, D, Eb, E, F, 
    Gb, G, Ab, A, Bb, B;

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

public class Note {
    public Note(Pitch pitch, int octave) {
        this.pitch = pitch;
        this.octave = octave;
    }
    public Note() {
        this.pitch = null;
    }
    @Override
    public String toString() {
        if (pitch == null) {
            return " ";
        }
        else {
            return pitch + (octave != 0 ? octave + "" : "");
        }
    }
    private Pitch pitch;
    private int octave;
}
