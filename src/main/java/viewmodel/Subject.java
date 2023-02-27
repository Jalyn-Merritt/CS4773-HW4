package viewmodel;

public interface Subject {
	
	public void registerObserver(EditorViewer editor);
	public void notifyObservers();
}