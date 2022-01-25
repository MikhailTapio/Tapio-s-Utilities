package com.plr.utilities.date

import java.text.MessageFormat
import java.util.{Calendar, GregorianCalendar}

object DateTest {
  def main(args: Array[String]): Unit = {
    test()
  }

  def test(): Unit = {
    val CALENDAR = new GregorianCalendar
    val YEAR = CALENDAR.get(Calendar.YEAR)
    val MONTH = CALENDAR.get(Calendar.MONTH)
    val DAY = CALENDAR.get(Calendar.DATE)
    println(MessageFormat.format("{0},{1},{2}", YEAR, MONTH, DAY))
  }
}
