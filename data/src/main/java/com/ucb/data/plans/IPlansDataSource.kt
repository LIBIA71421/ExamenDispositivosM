package com.ucb.data.plans

import com.ucb.domain.Plans

interface ISubscriptionPlanDataSource {
    suspend fun getPlans(): List<Plans>
}