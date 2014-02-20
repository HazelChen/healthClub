package logic;

public class Note {

	private int pitch; //0 ��������do�����¼Ӽ�1
	private NoteType type;
	private boolean isRising; //������
	private boolean isFalling; //������
	private boolean hasDot;
	
	private boolean isAccent; //����
	private boolean isLegato; //����
	private boolean isSnap; //����
	private boolean isTercet; //������
	
	public Note(NoteSimplified note) {
		
		this.pitch = note.getPitch();
		this.type = note.getType();
		this.isRising = note.isRising();
		this.isFalling = note.isFalling();
		this.hasDot = note.hasDot();
		isAccent = isLegato = isSnap = isTercet = false;
	}
}