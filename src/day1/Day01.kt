package day1

import println
import readInput

fun main() {
    fun part1(input: List<String>): Long {
        val (list1, list2) = input.map {
            it.split(" ") }
            .map { it[0].toLong() to it[3].toLong()  }
            .unzip()
        val sortedList1 = list1.sorted()
        val sortedList2 = list2.sorted()
        val sumMap = sortedList1.zip(sortedList2)
        val total = sumMap.sumOf {
            if (it.first > it.second) {
                it.first - it.second
            } else if (it.second > it.first) {
                it.second - it.first
            } else {
                0
            }
        }
        return total
    }

    fun part2(input: List<String>): Long {
        val (list1, list2) = input.map {
            it.split(" ") }
            .map { it[0].toLong() to it[3].toLong()  }
            .unzip()
        val sortedList1 = list1.sorted()
        val sortedList2 = list2.sorted()
        val resultMap = sortedList1.map { number -> sortedList2.count { it == number } * number }
        return resultMap.sum()
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val input = readInput("/day1/input")

    println("Part1 answer:")
    part1(input).println()

    println("Part2 answer:")
    part2(input).println()

}
