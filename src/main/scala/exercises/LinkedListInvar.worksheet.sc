import scala.annotation.tailrec

abstract class LogList[+A] {
  def last: A
  def previous: LogList[A]
  def isEmpty: Boolean
  def all: String
  def add[B >: A](msg: B): LogList[B]
}

class Log[+A](val head: A, val tail: LogList[A]) extends LogList[A] {
  def last: A = head
  def previous: LogList[A] = tail
  def isEmpty: Boolean = false
  def all: String = {
    @tailrec
    def getAll(logList: LogList[A], acc: String): String = {
      if (logList.isEmpty) {
        acc
      } else {
        val currentLog = logList.asInstanceOf[Log[A]]
        val newAcc = {
          if (acc.isEmpty) {
            currentLog.head.toString
          } else {
            acc + " " + currentLog.head.toString
          }
        }
        getAll(logList.previous, newAcc)
      }
    }
    getAll(this, "")
  }
  def add[B >: A](msg: B): LogList[B] = new Log(msg, this)
}

object Empty extends LogList[Nothing] {
  def last: Nothing = throw new NoSuchElementException("Empty list has no last elements")
  def previous: LogList[Nothing] = throw new NoSuchElementException("Empty list has no previous elements")
  def isEmpty: Boolean = true
  def all: String = ""
  def add[B](msg: B): LogList[B] = new Log(msg, Empty)
}

val list = new Log("m1", new Log("m2", new Log("m3", new Log("m4", new Log("m5", Empty)))))
val list = new Log("m1", Empty)

println(list.last)
//println(list.previous)
//println(list.isEmpty)
//println(list.all)
//println(list.add("m55").last)