package com.example.practica6popcorn

data class Pelicula(var titulo:String,
    var image: Int,
    var header: Int,
    var sinopsis:String,
    var seats: ArrayList<Cliente>)
