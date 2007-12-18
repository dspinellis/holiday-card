/*
 * $Id: MidiPlayer.java,v 1.2 2007/12/18 15:18:00 dds Exp $
 */
package gr.aueb.xmascard;

import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;

/**
 * Play the specified MIDI file
 * Note:
 * For this to work you must ensure that the computer's mixer
 * is configured to play the software synhtesizer output.
 *
 * @author Diomidis Spinellis
 */
public class MidiPlayer {
    /** The sequencer we are using to play the MIDI data. */
    static Sequencer sequencer = null;

    /** Constructor for playing the specified file. */
    MidiPlayer(String file) {
	playFile(file);
    }

    /** Play the specified file. */
    public void playFile(String file) {
        File midiFile = new File(file);
        try {
	    if (sequencer == null)
		sequencer = MidiSystem.getSequencer();
	    else
		end();
	    sequencer.setSequence(MidiSystem.getSequence(midiFile));
            sequencer.open();
            sequencer.start();
        } catch(MidiUnavailableException e) {
            System.err.println("Midi device unavailable:" + e);
        } catch(InvalidMidiDataException e) {
            System.err.println("Invalid MIDI data:" + e);
        } catch(IOException e) {
            System.err.println("I/O error:" + e);
        }
    }

    /** Return true if the music is still playing. */
    public boolean isPlaying() {
	return sequencer.isRunning();
    }

    /* Stop playing. */
    public void end() {
            sequencer.stop();
            sequencer.close();
	    sequencer = null;
    }
}
