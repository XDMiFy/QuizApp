package com.MiFy.Buzz.Modules

import com.MiFy.Buzz.Helpers.DataManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)

class HiltModule {

    @Provides
    @ActivityScoped
    fun CreateDataStorage(): DataManager {
        return DataManager()
    }
}