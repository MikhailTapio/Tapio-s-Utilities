package com.plr.utilities.hammerRecipeGenerator

import java.io.{File, PrintWriter}
import java.text.MessageFormat

object HammerRecipeGenerator {
  def main(args: Array[String]): Unit = {
    generate()
  }

  def generate(): Unit = {
    val ingotList = Array(
      "iron",
      "gold",
      "diamond",
      "netherite"
    )

    for (ingot <- ingotList) {
      generateRecipe(ingot)
    }
  }

  def generateA(): Unit = {
    val ingotList = Array(
      "iron",
      "gold",
      "diamond",
      "netherite"
    )
    val hammerList = Array(
      "wooden",
      "stone",
      "iron",
      "golden",
      "diamond",
      "netherite"
    )
    for (ingot <- ingotList) {
      for (hammer <- hammerList) {
        generateRecipeA(ingot, hammer)
      }
    }
  }

  def generateRecipeA(ingot: String, hammer: String): Unit = {
    val writer = new PrintWriter(new File(ingot + (if (ingot != "diamond".intern()) "_ingot_under_" else "_under_") + hammer + "_hammer.json"))
    val actualMaterial = if (ingot == "diamond".intern()) "diamond" else ingot + "_ingot"
    val actualResult = if (ingot == "gold".intern()) "golden" else ingot
    val lines = Array(
      "{",
      "  \"type\": \"minecraft:crafting_shaped\",",
      "  \"pattern\": [",
      "    \" ##\",",
      "    \" ##\",",
      "    \"A  \"",
      "  ],",
      "  \"key\": {",
      "    \"#\": {",
      MessageFormat.format("      \"item\": \"minecraft:{0}\"", actualMaterial),
      "    },",
      "    \"A\": {",
      MessageFormat.format("      \"item\": \"awesomeplates:{0}_hammer\"", hammer),
      "    }",
      "  },",
      "  \"result\": {",
      MessageFormat.format("    \"item\": \"awesomeplates:{0}_plate\",", actualResult),
      "    \"count\": 1",
      "  }",
      "}"
    )
    for (line <- lines) {
      writer.println(line)
    }
    writer.close()
  }

  def generateRecipe(ingot: String): Unit = {
    val writer = new PrintWriter(new File(ingot + (if (ingot != "diamond".intern()) "_ingot" else "") + "_to_plate.json"))
    val actualMaterial = if (ingot == "diamond".intern()) "diamond" else ingot + "_ingot"
    val actualResult = if (ingot == "gold".intern()) "golden" else ingot
    val actualMaterialLine = MessageFormat.format("      \"item\": \"minecraft:{0}\"", actualMaterial)
    val lines = Array(
      "{",
      "  \"type\": \"minecraft:crafting_shapeless\",",
      "  \"ingredients\": [",
      "    {",
      actualMaterialLine,
      "    },",
      "    {",
      actualMaterialLine,
      "    },",
      "    {",
      "      \"tag\": \"awesomeplates:hammers\"",
      "    },",
      "    {",
      actualMaterialLine,
      "    },",
      "    {",
      actualMaterialLine,
      "    }",
      "  ],",
      "  \"result\": {",
      MessageFormat.format("    \"item\": \"awesomeplates:{0}_plate\",", actualResult),
      "    \"count\": 1",
      "  }",
      "}"
    )
    for (line <- lines) {
      writer.println(line)
    }
    writer.close()
  }
}
