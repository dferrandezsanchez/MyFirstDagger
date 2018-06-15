package danielferrandez.com.mifirstdagger.di.module;

import dagger.Module;
import dagger.Provides;
import danielferrandez.com.mifirstdagger.Hipoteca;
import danielferrandez.com.mifirstdagger.ui.MainView;
import danielferrandez.com.mifirstdagger.ui.presenter.MainPresenter;
import danielferrandez.com.mifirstdagger.ui.presenter.MainPresenterImpl;

@Module
public class HipotecaModule {

    private final MainView mainView;

    public HipotecaModule(MainView mainView) {
        this.mainView = mainView;
    }

    @Provides
    public Hipoteca providesHipoteca() {
        return new Hipoteca();
    }

    @Provides
    public MainPresenter providesMainPresenter(){
        return new MainPresenterImpl(mainView);
    }
}
