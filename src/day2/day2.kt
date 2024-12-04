package day2

import println
import readInput

fun main() {
    fun hasConsistentDirection(reports: List<Int>, maxInvalid: Int = 0): Boolean {
        val floorDifference = reports.zipWithNext { a, b -> b - a}
        val isIncreasing = floorDifference[0] > 0
        var totalInvalid = 0
        var isValid = true

        for(i in 0 until floorDifference.size) {
            if(floorDifference[i] > 0 && !isIncreasing) {
                totalInvalid ++
            } else if(floorDifference[i] < 0 && isIncreasing) {
                totalInvalid ++
            } else if(floorDifference[i] > 3 || floorDifference[i] < -3 || floorDifference[i] == 0) {
                totalInvalid ++
            }
            if(totalInvalid > maxInvalid) {
                isValid = false
                break
            }
        }
        return isValid
    }

    fun canBeMadeConsistent(reports: List<Int>): Boolean {
       if(hasConsistentDirection(reports)) return true
        for(i in reports.indices) {
            val modifiedList = reports.toMutableList().apply { removeAt(i) }
            if(hasConsistentDirection(modifiedList)) {
                return true
            }
        }
        return false
    }

    fun part1(input: List<String>): Int {
        val list = input.map {
            it.split(" ") }
        val totalSafeItems = list.map { levels ->
            hasConsistentDirection(levels.map { it.toInt() })
        }
        val totalCount = totalSafeItems.count { it }
        return totalCount
    }
    fun part2(input: List<String>): Int {
        val list = input.map {
            it.split(" ") }
        val totalSafeItems = list.map { levels ->
            canBeMadeConsistent(levels.map { it.toInt() })
        }
        val totalCount = totalSafeItems.count { it }
        return totalCount
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val input = readInput("/day2/input")

    println("Part1 answer:")
    part1(input).println()

    println("Part2 answer:")
    part2(input).println()


    fun test(): Int {
        val  list = listOf(10,14,11,9,6)
        val result = canBeMadeConsistent(list)
        if(result) {
           return 1
        }
        return 0
    }

    test().println()

}
