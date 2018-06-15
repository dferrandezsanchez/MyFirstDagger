package danielferrandez.com.mifirstdagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import danielferrandez.com.mifirstdagger.di.module.HipotecaModule;
import danielferrandez.com.mifirstdagger.ui.MainView;
import danielferrandez.com.mifirstdagger.ui.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainView{

    @Inject
    Hipoteca hipoteca;

    @Inject
    MainPresenter mainPresenter;

    @BindView(R.id.tv_capitalPendiente)
    EditText tvCapitalPendiente;
    @BindView(R.id.mesesPendiente)
    EditText tvMesesPendiente;
    @BindView(R.id.tv_diferencial)
    EditText tvDiferencial;
    @BindView(R.id.btn_hipoteca)
    Button btnHipoteca;
    @BindView(R.id.tv_resultado)
    TextView tvResultado;
    @BindView(R.id.card_resultado)
    CardView cardResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        DaggerHipotecaComponent.builder().hipotecaModule(new HipotecaModule(this)).build().inject(this);

    }

    @OnClick(R.id.btn_hipoteca)
    public void onViewClicked() {
        hipoteca.setCapitalPendiente(Double.parseDouble(tvCapitalPendiente.getText().toString()));
        hipoteca.setMesesPendiente(Integer.parseInt(tvMesesPendiente.getText().toString()));
        hipoteca.setDiferencial(Double.parseDouble(tvDiferencial.getText().toString()));
        getCuota(hipoteca);
    }

    @Override
    public void showResult(String resultado) {
        tvResultado.setText(resultado);
        cardResultado.setVisibility(View.VISIBLE);
    }

    @Override
    public void getCuota(Hipoteca hipoteca) {
        mainPresenter.calcularCuota(hipoteca);
    }
}
