package com.twistedeqations.dagger2tutorial;

import com.squareup.picasso.Picasso;
import com.twistedeqations.dagger2tutorial.network.GithubService;


import dagger.Component;

/**
 * Created by Elias Myronidis on 14/10/17.
 */

@GithubApplicationScope
@Component(modules = {GithubServiceModule.class, PicassoModule.class})
public interface GithubApplicationComponent {

    Picasso getPicasso();

    GithubService getGithubService();
}
