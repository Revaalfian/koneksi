package com.example.koneksidatabase

class ApiEndPoint {
    companion object {

        private val SERVER = "http://192.168.43.134/universitaskotlin/"
        val CREATE = SERVER + "reegister.php"
        val READ = SERVER + "read.php"
        val UPDATE = SERVER + "update.php"
        val DELETE = SERVER + "delete.php"
    }
}