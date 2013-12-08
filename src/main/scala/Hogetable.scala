import scala.slick.driver.MySQLDriver.simple._
import Database.threadLocalSession

object Hogetable extends Table[(Int, String, String)]("User") {
      def id = column[Int]("id", O.PrimaryKey)
      def name = column[String]("name")
      def email = column[String]("email")
      def * = id ~ name ~ email

      def createSample():Unit = {
        this.insert(1, "hogehoge","hogehoge@example.com")
        this.insert(50, "fugafuga","fugafuga@example.com")
        this.insert(101, "piyopiyo","piyopiyo@example.com")
      }

      def findSample():Unit = {
        Query(this) foreach { case (id:Int, name, email) =>
            println(id + " : " + name + " → "+ email)
        }
      }
}