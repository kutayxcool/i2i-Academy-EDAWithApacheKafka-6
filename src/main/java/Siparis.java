public class Siparis {
    private int id;
    private String urun;
    private double fiyat;

    public Siparis(int id, String urun, double fiyat) {
        this.id = id;
        this.urun = urun;
        this.fiyat = fiyat;
    }

    public String toJson() {
        return "{\"id\":" + id + ", \"urun\":\"" + urun + "\", \"fiyat\":" + fiyat + "}";
    }

    @Override
    public String toString() {
        return "Siparis #" + id + " - " + urun + " - " + fiyat + " TL";
    }
}