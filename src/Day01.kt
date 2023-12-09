fun main() {
    fun part1(input: List<String>): Any {
        var sum = 0
        for (zeile in input) {
            println(zeile)
            var i = 0
            var first: Int
            while (true) {
                if (zeile[i].isDigit()) {
                    first = zeile[i].digitToInt()
                    break
                }
                i += 1
            }
            println(first)

            var last = first
            i += 1
            while (i < zeile.length) {
                if (zeile[i].isDigit()) {
                    last = zeile[i].digitToInt()
                }
                i += 1
            }
            println(last)

            val number = 10 * first + last
            sum += number

        }
        println(input)

        return sum
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    println(part1(testInput))
    check(part1(testInput) == 142)

    val input = readInput("Day01")
    part1(input).println()
//    part2(input).println()
}
