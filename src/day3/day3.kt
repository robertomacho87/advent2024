package day3

import println
import readInput
import readInputNoLines

fun main() {
    val regex = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")

    val testText = """
        mul(123,456) is valid, don't() mul(789,101) invalid do() mul(1,2)
        mul(3,4) valid after don't() mul(5,6) do() mul(7,8) don't() mul(1,3) do() mul(1,1)
    """.trimIndent()

    fun part1(input: String): Int {
        val matches = regex.findAll(input)
        val listOfMultiplications = matches.map {
            match ->
                match.groupValues[1].toInt() * match.groupValues[2].toInt()
        }.toList()
        return listOfMultiplications.reduce { acc, i -> acc + i }
    }
    fun part2(input: String): Int {
        val filteredInput = input.replace(Regex("""don't\(\).*?do\(\)""", RegexOption.DOT_MATCHES_ALL), "")
        val matches = regex.findAll(filteredInput)
        val listOfMultiplications = matches.map {
                match ->
            match.groupValues[1].toInt() * match.groupValues[2].toInt()
        }.toList()
        return listOfMultiplications.reduce { acc, i -> acc + i }
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val input = readInputNoLines("/day3/input")

    println("Part1 answer:")
    part1(input).println()

    println("Part2 answer:")
    part2(input).println()


//    fun test(): Int {
//       val matches = regex.findAll(textText)
//
//        val a = matches.map {
//            match ->
//                match.groupValues[1].toInt() * match.groupValues[2].toInt()
//        }.toList()
//        return 1
//    }
//
//    test().println()

}
