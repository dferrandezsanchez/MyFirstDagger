package danielferrandez.com.mifirstdagger.ui.presenter;

import danielferrandez.com.mifirstdagger.Hipoteca;
import danielferrandez.com.mifirstdagger.ui.MainView;

public class MainPresenterImpl implements MainPresenter{

    private final MainView mainView;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void calcularCuota(Hipoteca hipoteca) {
        double potencia = Math.pow((1 + hipoteca.getInteresCálculo()), -hipoteca.getMesesPendiente());
        double cuota = hipoteca.getCapitalPendiente() / ((1 - potencia) / hipoteca.getInteresCálculo());
        String resultado = String.format("La nueva cuota es de: %1$s", cuota);
        mainView.showResult(resultado);
    }
}
