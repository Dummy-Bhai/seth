fun main() {
    println("Shaikh Nadim KSBSCIT058");
    var fruits = arrayOf("Orange", "Apple", "Mango", "Banana");
    println("Using Array");
    for (index in fruits.indices) {
       println(fruits[index]);
    }
    println("Using Indices");
    for (item in 5 downTo 1 step 2) {
        println(item)
     }
    println("Another Example");
     for (item in 1..5) {
        println(item)
     }
 }