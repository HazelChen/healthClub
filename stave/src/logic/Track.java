package logic;

import java.util.ArrayList;

public class Track {

	private boolean isTrebleClef; //�����׺�or�����׺�
	private int beatNote; //��N������Ϊһ��
	private int beatsPerBar;
	private ToneMark toneMark; //����
	private Instrument instrument;
	private int volume; //����
	
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