public class Preference {
    public String size;
    public String zoom;

    public Preference(String size, String zoom) {
        this.size = size;
        this.zoom = zoom;
    }
    public Preference()
    {

    }


    @Override
    public String toString() {
        return "Preference{" +
                "size='" + size + '\'' +
                ", zoom='" + zoom + '\'' +
                '}';
    }
}
