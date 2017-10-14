package com.twistedeqations.dagger2tutorial;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Created by Elias Myronidis on 14/10/17.
 */

@Module(includes = ContextModule.class)
public class NetworkModule {

    @Provides
    @GithubApplicationScope
    public Cache provideCache(File cacheFile){
        return new Cache(cacheFile, 10 * 1000 * 1000); // 10Mb max size
    }

    @Provides
    @GithubApplicationScope
    public File provideCacheFile(@ApplicationContext Context context){
        return new File(context.getCacheDir(), "okhttp_cache");
    }

    @Provides
    @GithubApplicationScope
    public HttpLoggingInterceptor provideLoggingInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });

        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return interceptor;
    }

    @Provides
    @GithubApplicationScope
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache){
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
    }
}
