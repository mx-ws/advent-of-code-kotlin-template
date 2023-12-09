fun main() {
    fun part1line(time: Int, distance: Int): Int {
        return (0..time)
            .map { it * (time - it) }
            .filter { it > distance }
            .size
    }

    fun part1(input: List<String>): Int {
        return input
            .map { line ->
                line.dropWhile { !it.isDigit() }
                    .split(" ")
                    .mapNotNull { it.toIntOrNull() }
            }
            .let { it[0].zip(it[1]) }
            .fold(1) { acc, (time, distance) ->
                part1line(time, distance) * acc
            }
    }

    fun part2(input: List<String>): Int {
        return 5
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    println(part1(testInput))
    check(part1(testInput) == 288)
    println(part2(testInput))
    // check(part2(testInput) == 2)

    val input = readInput("Day06")
    part1(input).println()
    // part2(input).println()
}

