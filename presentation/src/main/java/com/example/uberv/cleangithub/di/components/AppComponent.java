package com.example.uberv.cleangithub.di.components;

import com.example.uberv.cleangithub.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
}