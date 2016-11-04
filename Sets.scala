// Sets.scala

import com.atomicscala.AtomicTest._

// 1.
val fruits = Set("apple", "orange", "banana", "kiwi")
val vegetables = Set("beans", "peas",
  "carrots", "sweet potatoes",
  "asparagus", "spinach")
val meats = Set("beef", "chicken")
val groceryCart = Set("apple",
  "pretzels", "bread", "orange", "beef",
  "beans", "asparagus", "sweet potatoes",
  "spinach", "carrots")

def percentMeat(groceryCart: Set[String]) = {
  if (groceryCart.size == 0) {
    0
  } else {
    //meats.count(meat => groceryCart.contains(meat)) * 100.0 / groceryCart.size
    100.0 * (groceryCart & meats).size / groceryCart.size
  }
}

def percentFruit(groceryCart: Set[String]) = {
  if (groceryCart.size == 0) {
    0
  } else {
    //fruits.count(fruit => groceryCart.contains(fruit)) * 100.0 / groceryCart.size
    100.0 * (groceryCart & fruits).size / groceryCart.size
  }
}

def percentVeggies(groceryCart: Set[String]) = {
  if (groceryCart.size == 0) {
    0
  } else {
    //vegetables.count(vegetable => groceryCart.contains(vegetable)) * 100.0 / groceryCart.size
    100.0 * (groceryCart & vegetables).size / groceryCart.size
  }
}

def percentOther(groceryCart: Set[String]) = {
  if (groceryCart.size == 0) {
    0
  } else {
    // (100.0 - percentMeat(groceryCart)
    // - percentFruit(groceryCart)
    // - percentVeggies(groceryCart))
    100.0 * (groceryCart -- (meats | fruits | vegetables)).size / groceryCart.size
  }
}

percentMeat(groceryCart) is 10.0
percentFruit(groceryCart) is 20.0
percentVeggies(groceryCart) is 50.0
percentOther(groceryCart) is 20.0

// 2.
val vegetarian = Set("kidney beans", "black beans", "tofu")
val groceryCart2 = Set("apple", "pretzels",
  "bread", "orange", "beef",
  "beans", "asparagus", "sweet potatoes",
  "kidney beans", "black beans")

def percentVegetarian(groceryCart: Set[String]) = {
  if (groceryCart.size == 0) {
    0
  } else {
    100.0 * (groceryCart & vegetarian).size / groceryCart.size
  }
}

def percentProtein(groceryCart: Set[String]) = {
  if (groceryCart.size == 0) {
    0
  } else {
    100.0 * (groceryCart & (meats | vegetarian)).size / groceryCart.size
  }
}

percentMeat(groceryCart2) is 10.0
percentVegetarian(groceryCart2) is 20.0
percentProtein(groceryCart2) is 30.0

// 3.
val box1 = Set("shoes", "clothes")
val box2 = Set("toys", "dishes")
val box3 = Set("toys", "games", "books")
val attic = Set(box1, box2) // 2 level set
val basement = Set(box3) // 2 level set
val house = Set(attic, basement) // 3 level set
Set("shoes", "clothes", "toys", "dishes") is attic.flatten
Set("toys", "games", "books") is basement.flatten
Set("shoes", "clothes", "toys",
  "dishes", "games", "books") is house.flatten.flatten
