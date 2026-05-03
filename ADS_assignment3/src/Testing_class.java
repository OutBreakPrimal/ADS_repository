public class Testing_class {
    private String id;
    private int salt;

    public Testing_class(String id, int salt) {
        this.id = id;
        this.salt = salt;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        for (int i = 0; i < id.length(); i++) {
            hash = 31 * hash + id.charAt(i);
        }
        hash = hash ^ salt;
        return Math.abs(hash);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Testing_class that = (Testing_class) o;
        return salt == that.salt && id.equals(that.id);
    }
}
