enum Pitch {
    C, Db, D, Eb, E, F,
    Gb, G, Ab, A, Bb, B;
}

public class Note {
    public Note(Pitch pitch, int octave) {
        this.pitch = pitch;
        if (octave < -5) {
            this.octave = -5;
        }
        else if (octave > 4) {
            this.octave = 4;
        }
        else {
            this.octave = octave;
        }
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
