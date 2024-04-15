import scala.annotation.tailrec

abstract class LogList {
  def last: String
  def previous: LogList
  def isEmpty: Boolean
  def all: String
  def add(msg: String): LogList
}

class Log(val head: String, val tail: LogList) extends LogList {
  def last: String = head
  def previous: LogList = tail
  def isEmpty: Boolean = false
  def all: String = {
    @tailrec
    def getAll(logList: LogList, acc: String): String = {
      if (logList.isEmpty) {
        acc
      } else {
        val currentLog = logList.asInstanceOf[Log]
        val newAcc = {
          if (acc.isEmpty) {
            currentLog.head
          } else {
            acc + " " + currentLog.head
          }
        }
        getAll(logList.previous, newAcc)
      }
    }
    getAll(this, "")
  }
  def add(msg: String): LogList = new Log(msg, this)
}

object Empty extends LogList {
  def last: String = throw new NoSuchElementException("Empty list has no last elements")
  def previous: LogList = throw new NoSuchElementException("Empty list has no previous elements")
  def isEmpty: Boolean = true
  def all: String = ""
  def add(msg: String): LogList = new Log(msg, Empty)
}

//val list = new Log("m1", new Log("m2", new Log("m3", new Log("m4", new Log("m5", Empty)))))
val list = new Log("m1", Empty)

println(list.last)
println(list.previous)
println(list.isEmpty)
println(list.all)
println(list.add("m55").last)