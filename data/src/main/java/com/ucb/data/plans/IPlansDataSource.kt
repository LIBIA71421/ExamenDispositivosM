package com.ucb.data.plans

import com.ucb.domain.Plans

interface IPlansDataSource {
    suspend fun getPlans(): List<Plans>
}