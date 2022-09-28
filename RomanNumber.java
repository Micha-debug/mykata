public enum RomanNumber {
    I(1), V(5), X(10), L(50), C(100), D(500), M(1000);

    private int num;
    RomanNumber(int num){
        this.num = num;
    }

    public int getNumber() {
        return num;
    }
}
