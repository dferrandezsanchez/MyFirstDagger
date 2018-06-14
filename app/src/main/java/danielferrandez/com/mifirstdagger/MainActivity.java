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
import danielferrandez.com.mifirstdagger.di.HipotecaApplication;

public class MainActivity extends AppCompatActivity {

    @Inject
    Hipoteca hipoteca;
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

        ((HipotecaApplication) getApplication()).getHipotecaComponent().inject(this);

    }

    @OnClick(R.id.btn_hipoteca)
    public void onViewClicked() {
        hipoteca.setCapitalPendiente(Double.parseDouble(tvCapitalPendiente.getText().toString()));
        hipoteca.setMesesPendiente(Integer.parseInt(tvMesesPendiente.getText().toString()));
        hipoteca.setDiferencial(Double.parseDouble(tvDiferencial.getText().toString()));
        String resultado = String.format("La nueva cuota es de: %1$s", nuevaCuota(hipoteca));
        tvResultado.setText(resultado);
        cardResultado.setVisibility(View.VISIBLE);
    }

    private double nuevaCuota(Hipoteca hipoteca) {
        //(C3)/((1-((1+C6)^(-C4)))/C6)
        double potencia = Math.pow((1 + hipoteca.getInteresCálculo()), -hipoteca.getMesesPendiente());
        return hipoteca.getCapitalPendiente() / ((1-potencia)/hipoteca.getInteresCálculo());
    }
}
