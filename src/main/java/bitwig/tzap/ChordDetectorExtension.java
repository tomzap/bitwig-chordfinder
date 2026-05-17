package bitwig.tzap;

import com.bitwig.extension.controller.api.ControllerHost;
import com.bitwig.extension.controller.api.CursorTrack;
import com.bitwig.extension.controller.api.DocumentState;
import com.bitwig.extension.controller.api.PlayingNote;
import com.bitwig.extension.controller.api.SettableStringValue;

import com.bitwig.extension.controller.ControllerExtension;

import free.tzap.Chord;

public class ChordDetectorExtension extends ControllerExtension {

   private ControllerHost host;
   private CursorTrack cursorTrack;
   private DocumentState documentState;

   private SettableStringValue chordText;

   protected ChordDetectorExtension(final ChordDetectorExtensionDefinition definition, final ControllerHost host) {
      super(definition, host);
   }

   private void log(String s) {
      host.println(s);
   }

   @Override
   public void init() {
      host = getHost();
      cursorTrack = host.createCursorTrack(0, 0);
      cursorTrack.playingNotes().addValueObserver(v -> onPlayingNotes(v));
      documentState = host.getDocumentState();

      chordText = documentState.getStringSetting("Chord", "chord", 20, "");      

     log("ChordDetector initialized");
   }


   private Object onPlayingNotes(PlayingNote[] v) {
      if (v.length < 2) {
         chordText.set("");
         return null;
      } 
      int[] midiNotes = new int[v.length];
      for (int i = 0; i < v.length; i++) {
         midiNotes[i] = v[i].pitch();
      }  
      try {
         Chord chord = Chord.fromNotes(midiNotes);
         chordText.set(chord.getName());
      } catch (Exception e) {
         chordText.set("Unknown");
      }
      return null;
   }

   @Override
   public void exit() {
      // TODO: Perform any cleanup once the driver exits
   }

   @Override
   public void flush() {
      // TODO Send any updates you need here.
   }

}
