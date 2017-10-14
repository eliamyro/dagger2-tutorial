package com.twistedeqations.dagger2tutorial;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Elias Myronidis on 14/10/17.
 */

@Scope
@Retention(RetentionPolicy.CLASS)
public @interface GithubApplicationScope {
}
