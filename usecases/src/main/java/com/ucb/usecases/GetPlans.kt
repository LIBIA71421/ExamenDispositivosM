package com.ucb.usecases

import com.ucb.data.PlansRepository
import com.ucb.domain.Plans

class GetPlans(
    private val repository: PlansRepository
) {
    suspend fun invoke(): List<Plans> {
        return repository.getPlans()
    }
}