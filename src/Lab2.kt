// esto es para guardar datos de una persona
data class Persona(val nombre: String, val edad: Int, val genero: String)

// esto es como la versión estudiante, con un carnet
data class Estudiante(val nombre: String, val edad: Int, val genero: String, val carnet: String)

// creo que esto saca el promedio de una lista
fun promedio(lista: List<Int>): Double {
    var suma = lista.reduce { total, actual -> total + actual }
    return suma.toDouble() / lista.size
}

// aquí saco solo los números impares de una lista
fun impares(lista: List<Int>): List<Int> {
    return lista.filter { it % 2 != 0 }
}

// esto revisa si una palabra es palíndromo
fun esPalindromo(palabra: String): Boolean {
    return palabra == palabra.reversed()
}

// le pone hola a cada nombre
fun saludar(nombres: List<String>): List<String> {
    return nombres.map { "¡Hola, $it!" }
}

// aplica una operación como suma o resta
fun operar(a: Int, b: Int, operacion: (Int, Int) -> Int): Int {
    return operacion(a, b)
}

// esto convierte personas normales a estudiantes
fun convertir(personas: List<Persona>): List<Estudiante> {
    val listaEstudiantes = mutableListOf<Estudiante>()
    var i = 1
    for (p in personas) {
        val estudiante = Estudiante(p.nombre, p.edad, p.genero, "ID$i")
        listaEstudiantes.add(estudiante)
        i++
    }
    return listaEstudiantes
}

// esto solo imprime a los estudiantes
fun mostrar(estudiantes: List<Estudiante>) {
    for (e in estudiantes) {
        println("El estudiante ${e.nombre} tiene ${e.edad} años")
    }
}

fun main() {
    // promedio de números
    val numeros = listOf(10, 20, 30)
    println("Promedio: ${promedio(numeros)}")

    // impares de la lista
    val listaImpares = impares(numeros)
    println("Números impares: $listaImpares")

    // palíndromos
    val palabra1 = "oso"
    val palabra2 = "sol"
    println("$palabra1 es palíndromo? ${esPalindromo(palabra1)}")
    println("$palabra2 es palíndromo? ${esPalindromo(palabra2)}")

    // saludos
    val nombres = listOf("Ana", "Luis", "Diana")
    val saludos = saludar(nombres)
    for (s in saludos) {
        println(s)
    }

    // operaciones matemáticas
    val suma = operar(3, 4) { x, y -> x + y }
    val multi = operar(3, 4) { x, y -> x * y }
    println("Suma: $suma")
    println("Multiplicación: $multi")

    // pasar personas a estudiantes
    val personas = listOf(
        Persona("Carlos", 20, "Masculino"),
        Persona("Andrea", 21, "Femenino")
    )

    val estudiantes = convertir(personas)
    mostrar(estudiantes)
}

// Dally Ramirez - 241035
