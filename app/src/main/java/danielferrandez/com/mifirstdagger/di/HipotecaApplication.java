package danielferrandez.com.mifirstdagger.di;

import android.app.Application;

import danielferrandez.com.mifirstdagger.di.component.HipotecaComponent;
import danielferrandez.com.mifirstdagger.di.module.HipotecaModule;

public class HipotecaApplication extends Application {
    private HipotecaComponent hipotecaComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        hipotecaComponent = DaggerHipotecaComponent.builder().hipotecaModule(new HipotecaModule()).build();
    }

    public HipotecaComponent getHipotecaComponent() {
        return hipotecaComponent;
    }
}
