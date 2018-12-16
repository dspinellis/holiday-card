/*-
 * Copyright 2005-2018 Diomidis Spinellis
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package gr.aueb.xmascard;

import javax.sound.midi.*;
import java.io.InputStream;
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
        InputStream midiFile = getClass().getResourceAsStream(file);
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
