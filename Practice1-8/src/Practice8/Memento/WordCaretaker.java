package Practice8.Memento;

public class WordCaretaker {
    private WordMemento wordMemento;
    private final WordOriginator wordOriginator;

    public WordCaretaker(WordOriginator wordOriginator) {
        this.wordOriginator = wordOriginator;
    }

    public void saveWord() {
        wordMemento = wordOriginator.saveChanges();
    }

    public void rollbackWord() {
        wordOriginator.rollbackChanges(wordMemento);
    }


}
