package danielferrandez.com.mifirstdagger.di.component;

import dagger.Component;
import danielferrandez.com.mifirstdagger.MainActivity;
import danielferrandez.com.mifirstdagger.di.module.HipotecaModule;
import danielferrandez.com.mifirstdagger.di.scope.PerActivity;

@PerActivity
@Component(modules = HipotecaModule.class)
public interface HipotecaComponent {
    void inject(MainActivity mainActivity);
}
