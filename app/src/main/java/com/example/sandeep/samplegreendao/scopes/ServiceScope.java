package com.example.sandeep.samplegreendao.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Jay Rambhia on 6/28/16.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ServiceScope {
}
