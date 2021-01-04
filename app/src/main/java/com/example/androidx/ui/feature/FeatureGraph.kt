package com.example.androidx.ui.feature

object feature_graph {

    const val id = 1 // graph id

    object dest {
        const val feature = 2
        const val feature1 = 3
    }

    object action {
        const val to_feature1 = 4
    }

    object args {
        const val id = "id"
    }
}