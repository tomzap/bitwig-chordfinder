package bitwig.tzap;

import java.util.UUID;

import com.bitwig.extension.api.PlatformType;
import com.bitwig.extension.controller.AutoDetectionMidiPortNamesList;
import com.bitwig.extension.controller.ControllerExtensionDefinition;
import com.bitwig.extension.controller.api.ControllerHost;

public class ChordDetectorExtensionDefinition extends ControllerExtensionDefinition {
   private static final UUID DRIVER_ID = UUID.fromString("957fc108-4ca8-4980-8c0c-90bd2e292f91");

   public ChordDetectorExtensionDefinition() {
   }

   @Override
   public String getName() {
      return "Chord Detector";
   }

   @Override
   public String getAuthor() {
      return "Tomasz Zapalski";
   }

   @Override
   public String getVersion() {
      return "0.1";
   }

   @Override
   public UUID getId() {
      return DRIVER_ID;
   }

   @Override
   public String getHardwareVendor() {
      return "TZap";
   }

   @Override
   public String getHardwareModel() {
      return "Chord Detector";
   }

   @Override
   public int getRequiredAPIVersion() {
      return 18;
   }

   @Override
   public int getNumMidiInPorts() {
      return 0;
   }

   @Override
   public int getNumMidiOutPorts() {
      return 0;
   }

   @Override
   public void listAutoDetectionMidiPortNames(final AutoDetectionMidiPortNamesList list,
         final PlatformType platformType) {
   }

   @Override
   public String getHelpFilePath() {
      // TODO: where is this used?
      return "https://github.com/tomzap/bitwig-timecalc/blob/main/README.md#timecalc";
   }

   @Override
   public ChordDetectorExtension createInstance(final ControllerHost host) {
      return new ChordDetectorExtension(this, host);
   }
}
