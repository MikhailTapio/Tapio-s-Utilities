package com.plr.utilities.bonsaiGenerator

import java.io.{File, PrintWriter}
import java.text.MessageFormat
import scala.io.StdIn

object BonsaiGenerator {
  def main(args: Array[String]): Unit = {
    generate()
  }

  def generate(): Unit = {
    println("请输入所要生成盆栽对应的矿物名称，如：coal")
    val oreName = StdIn.readLine()
    val writer1 = new PrintWriter(new File(oreName + ".json"))
    generateSoil(oreName, writer1)
    val writer2 = new PrintWriter(new File(oreName + "_d.json"))
    generateSoilDeepslate(oreName, writer2)
    val writer3 = new PrintWriter(new File(oreName + "_s.json"))
    generateSapling(oreName, writer3)
  }

  def generateSoil(oreName: String, writer: PrintWriter): Unit = {
    val linesToPrint =
      Array(
        "{",
        "  \"type\": \"bonsaitrees3:soil\",",
        "  \"mod\": \"ore_tree\",",
        "  \"tickModifier\": 1.0,",
        "  \"soil\": {",
        MessageFormat.format("    \"item\": \"minecraft:{0}_ore\"", oreName),
        "  },",
        "  \"compatibleSoilTags\": [",
        MessageFormat.format("    \"{0}_tree\"", oreName),
        "  ],",
        "  \"display\": {",
        MessageFormat.format("    \"block\": \"minecraft:{0}_ore\"", oreName),
        "  }",
        "}")
    for (line <- linesToPrint) {
      writer.println(line)
    }
    writer.close()
    println("已生成表层矿石 Soil 文件")
  }

  def generateSoilDeepslate(oreName: String, writer: PrintWriter): Unit = {
    val linesToPrint =
      Array(
        "{",
        "  \"type\": \"bonsaitrees3:soil\",",
        "  \"mod\": \"ore_tree\",",
        "  \"tickModifier\": 1.0,",
        "  \"soil\": {",
        MessageFormat.format("    \"item\": \"minecraft:deepslate_{0}_ore\"", oreName),
        "  },",
        "  \"compatibleSoilTags\": [",
        MessageFormat.format("    \"{0}_tree\"", oreName),
        "  ],",
        "  \"display\": {",
        MessageFormat.format("    \"block\": \"minecraft:deepslate_{0}_ore\"", oreName),
        "  }",
        "}")
    for (line <- linesToPrint) {
      writer.println(line)
    }
    writer.close()
    println("已生成深层矿石 Soil 文件")
  }

  def generateSapling(oreName: String, writer: PrintWriter): Unit = {
    val linesToPrint =
      Array(
        "{",
        "  \"type\": \"bonsaitrees3:sapling\",",
        "  \"mod\": \"ore_tree\",",
        "  \"sapling\":",
        "  {",
        MessageFormat.format("    \"item\": \"ore_tree:{0}_tree_sapling\"", oreName),
        "  },",
        "  \"drops\": [",
        "    {",
        "      \"rolls\": 5, \"chance\": 1,",
        "      \"result\":",
        "      {",
        MessageFormat.format("        \"item\": \"ore_tree:{0}_tree_log\"", oreName),
        "      }",
        "    },",
        "    {",
        "      \"rolls\": 2, \"chance\": 0.3,",
        "      \"result\": { \"item\": \"minecraft:oak_leaves\" },",
        "      \"requiresSilkTouch\": true",
        "    }",
        "],",
        MessageFormat.format("  \"compatibleSoilTags\": [\"{0}_tree\"]", oreName),
        "}"
      )
    for (line <- linesToPrint) {
      writer.println(line)
    }
    writer.close()
    println("已生成矿物树 Sapling 文件")
  }
}
