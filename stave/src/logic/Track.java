package logic;

import java.util.ArrayList;

public class Track {

	private boolean isTrebleClef; //高音谱号or低音谱号
	private int beatNote; //以N分音符为一拍
	private int beatsPerBar;
	private ToneMark toneMark; //调号
	private Instrument instrument;
	private int volume; //音量
	
	private ArrayList<Note> notes;

	public Track(boolean isTrebleClef, int beatNote, int beatsPerBar,
			ToneMark toneMark, Instrument instrument, int volume) {
		
		this.isTrebleClef = isTrebleClef;
		this.beatNote = beatNote;
		this.beatsPerBar = beatsPerBar;
		this.toneMark = toneMark;
		this.instrument = instrument;
		this.volume = volume;
	}
}