package Practice8.Memento;

public class WordOriginator {
    private StringBuilder word;
    public WordOriginator() {
        word = new StringBuilder();
    }
    public void addToWord(String addition) {
        word.append(addition);
    }


    public WordMemento saveChanges() {
        return new WordMemento(word.toString());
    }

    public void rollbackChanges(WordMemento memento) {
        word = new StringBuilder(memento.getWord());
    }
}
