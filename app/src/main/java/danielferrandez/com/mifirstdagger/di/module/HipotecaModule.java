package danielferrandez.com.mifirstdagger.di.module;

import dagger.Module;
import dagger.Provides;
import danielferrandez.com.mifirstdagger.Hipoteca;

@Module
public class HipotecaModule {


    @Provides
    public Hipoteca providesHipoteca(){
        return new Hipoteca();
    }
}
