package com.ucb.data

import com.ucb.data.plans.ISubscriptionPlanDataSource
import com.ucb.domain.Plans

class SubscriptionRepository(
    private val remoteDataSource: ISubscriptionPlanDataSource
) {
    suspend fun getSubscriptionPlans(): List<Plans> {
        return remoteDataSource.getPlans()
    }
}
