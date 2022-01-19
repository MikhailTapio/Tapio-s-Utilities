package com.plr.utilities

import com.plr.utilities.bonsaiGenerator.BonsaiGenerator

import scala.annotation.tailrec
import scala.io.StdIn


object Main {
  def main(args: Array[String]): Unit = {
    functionLoop(true)
  }

  @tailrec
  def functionLoop(continue: Boolean): Unit = {
    if (!continue) return
    printFunctionList()
    val choice = StdIn.readLine()
    choice match {
      case "1" =>
        BonsaiGenerator.generate()
        functionLoop(true)
      case "0" => functionLoop(false)
      case _ => functionLoop(true)
    }
  }

  def printFunctionList(): Unit = {
    val linesToPrint = Array(
      "欢迎使用 Tapio 的小工具",
      "输入数字以使用功能：",
      "1.盆栽矿物树 JSON 生成",
      "0.退出"
    )
    for (line <- linesToPrint) {
      println(line)
    }
  }
}
