package danielferrandez.com.mifirstdagger;

public class Hipoteca {
    private double capitalPendiente;
    private int mesesPendiente;
    private double diferencial;
    private double euribor = -0.191;
    private double interesCálculo;

    public double getCapitalPendiente() {
        return capitalPendiente;
    }

    public void setCapitalPendiente(double capitalPendiente) {
        this.capitalPendiente = capitalPendiente;
    }

    public int getMesesPendiente() {
        return mesesPendiente;
    }

    public void setMesesPendiente(int mesesPendiente) {
        this.mesesPendiente = mesesPendiente;
    }

    public double getDiferencial() {
        return diferencial;
    }

    public void setDiferencial(double diferencial) {
        this.diferencial = diferencial;
    }

    public double getInteresCálculo() {
        interesCálculo = ((diferencial/100)+(euribor/100))/12;
        return interesCálculo;
    }
}
