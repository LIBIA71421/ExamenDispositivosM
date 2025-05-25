package com.ucb.examendispositivosm.di

import com.ucb.data.PlansRepository
import com.ucb.data.plans.IPlansDataSource
import com.ucb.framework.PlansDataSource
import com.ucb.usecases.GetPlans
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSubscriptionDataSource(): IPlansDataSource {
        return PlansDataSource()
    }

    @Provides
    @Singleton
    fun provideSubscriptionRepository(
        dataSource: IPlansDataSource
    ): PlansRepository {
        return PlansRepository(dataSource)
    }

    @Provides
    @Singleton
    fun provideGetSubscriptionPlans(
        repository: PlansRepository
    ): GetPlans {
        return GetPlans(repository)
    }
}
