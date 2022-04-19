package com.app.mykmm

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}