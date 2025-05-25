package com.ucb.framework

import com.ucb.data.plans.IPlansDataSource
import com.ucb.domain.Plans

class PlansDataSource : IPlansDataSource {

    override suspend fun getPlans(): List<Plans> {
        return listOf(
            Plans(
                id = 1,
                name = "Plan FLEX 5",
                description = "Llamadas y sms ilimitados, Comparte tus datos",
                price = "Bs 50",
                duration = "1 mes"
            ),
            Plans(
                id = 2,
                name = "Plan FLEX 8",
                description = "Redes sociales ilimitadas + Roaming",
                price = "Bs 100",
                duration = "15 dias"
            ),
            Plans(
                id = 3,
                name = "Plan FLEX 10",
                description = "Armar tu propio plan",
                price = "Bs 180",
                duration = "100 dia"
            )
        )
    }
}