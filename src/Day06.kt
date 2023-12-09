fun main() {
    fun part1line(time: ULong, distance: ULong): ULong{
        return (0uL..time)
            .map { it * (time - it) }
            .filter { it > distance }
            .size
            .toULong()
    }

    fun part1(input: List<String>): ULong {
        return input
            .map { line ->
                line.dropWhile { !it.isDigit() }
                    .split(" ")
                    .mapNotNull { it.toULongOrNull() }
            }
            .let { it[0].zip(it[1]) }
            .fold(1uL) { acc, (time, distance) ->
                part1line(time, distance) * acc
            }
    }

    fun part2(input: List<String>): ULong {
        return input
            .map { line -> line.filter { it.isDigit() }.toULong() }
            .let { (time, distance) -> part1line(time, distance) }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    println(part1(testInput))
    check(part1(testInput) == 288uL)
    println(part2(testInput))
    check(part2(testInput) == 71503uL)

    val input = readInput("Day06")
    part1(input).println()
    part2(input).println()
}

