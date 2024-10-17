import kotlin.math.abs

data class Point(val x: Double, val y: Double)

class Triangle(val p1: Point, val p2: Point, val p3: Point) {

    private fun area(p1: Point, p2: Point, p3: Point): Double {
        return 0.5 * abs(
            p1.x * (p2.y - p3.y) +
                    p2.x * (p3.y - p1.y) +
                    p3.x * (p1.y - p2.y)
        )
    }

    fun isPointInside(point: Point): Boolean {
        val totalArea = area(p1, p2, p3)
        val area1 = area(point, p2, p3)
        val area2 = area(p1, point, p3)
        val area3 = area(p1, p2, point)

        return totalArea == area1 + area2 + area3
    }
}

fun readPointCoordinate(prompt: String): Double {
    while (true) {
        try {
            print(prompt)
            return readLine()?.toDouble() ?: throw NumberFormatException()
        } catch (e: NumberFormatException) {
            println("Ошибка: введите корректное число.")
        }
    }
}

fun main() {
    println("Введите координаты треугольника:")
    val x1 = readPointCoordinate("Точка 1 (x1): ")
    val y1 = readPointCoordinate("Точка 1 (y1): ")
    val x2 = readPointCoordinate("Точка 2 (x2): ")
    val y2 = readPointCoordinate("Точка 2 (y2): ")
    val x3 = readPointCoordinate("Точка 3 (x3): ")
    val y3 = readPointCoordinate("Точка 3 (y3): ")

    val triangle = Triangle(Point(x1, y1), Point(x2, y2), Point(x3, y3))

    println("Введите координаты проверяемой точки:")
    val px = readPointCoordinate("Точка P (x): ")
    val py = readPointCoordinate("Точка P (y): ")

    val point = Point(px, py)

    if (triangle.isPointInside(point)) {
        println("Точка находится внутри треугольника.")
    } else {
        println("Точка находится вне треугольника.")
    }
}