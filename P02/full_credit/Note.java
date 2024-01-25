enum Pitch {
    C, Db, D, Eb, E, F, 
    Gb, G, Ab, A, Bb, B
}

public class Note {
    public Note(Pitch pitch, int octave) {
        this.pitch = pitch;
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
