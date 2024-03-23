package main

import scala.reflect.runtime.{universe => ru}

// https://www.geeksforgeeks.org/top-10-algorithms-in-interview-questions/
object Main {

  def main(args: Array[String]): Unit = {
    args match {
      case Array(className) =>
        val mirror = ru.runtimeMirror(getClass.getClassLoader)
        val classSymbol = mirror.staticClass(className)
        val classMirror = mirror.reflectClass(classSymbol)
        val constructorSymbol = classSymbol.primaryConstructor.asMethod
        val constructorMirror =
          classMirror.reflectConstructor(constructorSymbol)
        val instance = constructorMirror()
      case _ =>
        println("Usage: run <class-name>")
    }
  }
}
