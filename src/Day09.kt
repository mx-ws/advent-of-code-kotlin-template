fun main() {
    fun diffLine(line: List<Int>): MutableList<Int> {
        val diff: MutableList<Int> = mutableListOf()
        for (i in 0..(line.size - 2)) {
            diff.add(line[i + 1] - line[i])
        }
        println(diff)
        return diff
    }

    fun getTransformedLines(line: List<Int>): Pair<List<List<Int>>, Int> {
        val transformedLines = mutableListOf(line)
        var i = 0
        while (transformedLines[i].any { it != 0 }) {
            transformedLines.add(diffLine(transformedLines[i]))
            i += 1
        }

        return transformedLines to i
    }

    fun part1line(line: List<Int>): Int {
        val (transformedLines, k) = getTransformedLines(line)
        var i = k
        var last = 0
        while (i > 0) {
            last += transformedLines[i - 1].last()
            i -= 1
        }

        return last
    }

    fun part1(input: List<String>): Int {
        return input
            .sumOf { line -> part1line(line.split(" ").map { it.toInt() }) }
    }

    fun part2line(line: List<Int>): Int {
        val (transformedLines, k) = getTransformedLines(line)
        var i = k
        var first = 0
        while (i > 0) {
            first = transformedLines[i - 1].first() - first
            i -= 1
        }

        return first
    }

    fun part2(input: List<String>): Int {
        return input
            .sumOf { line -> part2line(line.split(" ").map { it.toInt() }) }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day09_test")
    println(part1(testInput))
    check(part1(testInput) == 114)
    println(part2(testInput))
    check(part2(testInput) == 2)

    val input = readInput("Day09")
    part1(input).println()
    part2(input).println()
}
