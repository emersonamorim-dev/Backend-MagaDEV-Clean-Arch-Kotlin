package org.ecommerce.lojavirtual.rabbitmq

class Logger {
    companion object {
        private fun color(vararg ts: String): String = "\u001B[34m" + ts.joinToString(separator = " ") + "\u001B[39m"
        fun <T> log(callerClass: Class<T>, s: String) {
            println(color(callerClass.simpleName) + "\t| $s")
        }
    }
}