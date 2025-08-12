package model;

public enum DifficultyLevel {
    EASY(4),
    MEDIUM(6),
    HARD(8);

    private final int codeLength;

    // the enum constructor and retrieves the value and assigns it to the codeLength field
    private DifficultyLevel(int codeLength) {
        this.codeLength = codeLength;
    }

    public int getCodeLength() {
        return codeLength;
    }
}
