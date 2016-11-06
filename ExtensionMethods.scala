// ExtensionMethods.scala

import com.atomicscala.AtomicTest._

// 1. 2.
case class Book(title: String)

object BookExtension {
  implicit class Ops(book: Book) {
    def categorize(category: String) =
      s"$book, category: $category"
    def detail(category: String, author: String) =
      s"$book, category: $category, author: $author"
  }
}
import BookExtension._

Book("Dracula") categorize "Vampire" is
"Book(Dracula), category: Vampire"

def categorize(book: Book, category: String) =
  s"$book, category: $category"

categorize(Book("Dracula"), "Vampire") is
"Book(Dracula), category: Vampire"

Book("Bridge").detail("fiction", "Xiao Hong") is
"Book(Bridge), category: fiction, author: Xiao Hong"

// 3.
