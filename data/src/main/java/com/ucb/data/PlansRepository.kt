package com.ucb.data

import com.ucb.data.plans.IPlansDataSource
import com.ucb.domain.Plans

class PlansRepository(
    private val remoteDataSource: IPlansDataSource
) {
    suspend fun getPlans(): List<Plans> {
        return remoteDataSource.getPlans()
    }
}
