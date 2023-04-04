public class Stock {
    String name;
    int price;
    boolean isGrowing;
    double chanceToChange;
    double incrementCTC;
    int offering;
    int owning;

    public Stock(String name,
                 int price,
                 boolean isGrowing,
                 double chanceToChange,
                 double incrementCTC,
                 int offering,
                 int owning) {
        this.name = name;
        this.price = price;
        this.isGrowing = isGrowing;
        this.chanceToChange = chanceToChange;
        this.incrementCTC = incrementCTC;
        this.offering = offering;
        this.owning = owning;
    }
}
