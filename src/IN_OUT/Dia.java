package IN_OUT;

public class Dia {

    private int tempMax;
    private int tempMin;
    private String text;

    public Dia(int tempMax, int tempMin, String text) {
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.text = text;
    }

    public int getTempMax() {
        return tempMax;
    }

    public int getTempMin() {
        return tempMin;
    }

    public String getText() {
        return text;
    }
}
