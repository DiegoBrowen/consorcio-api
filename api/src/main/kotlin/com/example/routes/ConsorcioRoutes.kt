package com.example.routes

import com.example.models.ConsorcioModel
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.createConsorcioRoute() {
    post("/consorcios") {
        val request = call.receive<ConsorcioModel>()
        call.respondText("Consorcio criado", status = HttpStatusCode.Created)
    }
}

fun Application.registerConsorcioRoutes() {
    routing {
        createConsorcioRoute()
    }
}