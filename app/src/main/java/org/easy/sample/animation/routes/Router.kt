package org.easy.sample.animation.routes

data class Router(
    val route: String,
    val label: String
)

val routes = listOf(
    Router(
        "value_animation",
        "Value Animation"
    ),
    Router(
        route = "visible_animation",
        label = "Visible Animation"
    ),
    Router(
        route = "multiple_value_animation",
        label = "Multiple Value Animation"
    )
)
