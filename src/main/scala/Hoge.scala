import scala.slick.driver.MySQLDriver.simple._
import Database.threadLocalSession

object Hoge {
    def main(args: Array[String]):Unit = {
        Database.forURL("jdbc:mysql://localhost/test", driver = "com.mysql.jdbc.Driver") withSession {
            try {
                (Hogetable.ddl).drop
            }
            try {
                (Hogetable.ddl).create
                Hogetable.createSample()
                Hogetable.findSample()
            } catch {
                case e:Exception => println(e)
            }
        }
    }
}