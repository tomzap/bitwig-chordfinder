# Chord Detector

A simple chord detector as a controller extension for [Bitwig Studio](https://www.bitwig.com). 
I have been creating chord progressions but I usually forget to write down what the progression is.
The next time I open the project I have to open track with a pregression and figure out from MIDI notes
what chords I was playing.
Well, not any more. This extension allows me to choose a track, play song and it will detect all the chords for me!
I just have to note them down, very useful.

## Install from a release

Download the latest `.bwextension` file from the [releases](https://github.com/tomzap/bitwig-chordfinder/releases)
page and copy it into the `Extensions` folder of your Bitwig Studio
installation:
* Linux: ~/Bitwig Studio/Extensions/
* Mac: ~/Documents/Bitwig Studio/Extensions/
* Windows: %USERPROFILE%\Documents\Bitwig Studio\Extensions\

For Bitwig Studio > 3.4, you can also drag the file from your downloads into the Bitwig Studio window.

## Build & install from code

I am assuming Linux here.

```shell
mvn install
```

## Activate the extension

Go to `Settings > Controller` and add a new one. Pick `TZap` as the vendor
and select `ChordDetector` as the hardware. The extension does not have any settings
(yet).

Now you'll find the extension at top-left of Bitwig Studio:

## Usage

You choose a track, open the extension and press Play. 
The extension receives MIDI notes from the selected track and 
prints the chord if it can recognize it. That's it!

## Compability

I have written this extension for Bitwig 5, it may not work for previous versions. Unfortunatelly I cannot test is for Bitwig 6 or higher. Let me know if it works!