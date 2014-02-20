package logic;

public class Note {

	private int pitch; //0 代表中央do，上下加减1
	private NoteType type;
	private boolean isRising; //升半音
	private boolean isFalling; //降半音
	private boolean hasDot;
	
	private boolean isAccent; //重音
	private boolean isLegato; //连音
	private boolean isSnap; //促音
	private boolean isTercet; //三连音
	
	public Note(NoteSimplified note) {
		
		this.pitch = note.getPitch();
		this.type = note.getType();
		this.isRising = note.isRising();
		this.isFalling = note.isFalling();
		this.hasDot = note.hasDot();
		isAccent = isLegato = isSnap = isTercet = false;
	}
}