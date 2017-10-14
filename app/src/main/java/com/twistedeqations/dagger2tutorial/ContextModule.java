package com.twistedeqations.dagger2tutorial;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Elias Myronidis on 14/10/17.
 */

@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @GithubApplicationScope
    public Context provideContext(){
        return context;
    }
}
