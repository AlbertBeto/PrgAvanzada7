package IN_OUT;

public class Dia {
private String dia;
    private int tempMax;
    private int tempMin;
    private String text;

    public Dia(String dia, int tempMax, int tempMin, String text) {
        this.dia = dia;
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

    public String getDia() {
        return dia;
    }
}
