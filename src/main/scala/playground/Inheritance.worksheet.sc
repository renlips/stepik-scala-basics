class Button(label: String) {
  def click(): String = s"button -$label- has been clicked"
  def this() = this("test")
}

val buttonOff = new Button("switcher")
println(buttonOff.click())


class RoundedButton(label: String) extends Button(label) {
  override def click(): String = s"rounded ${super.click()}"
}

val roundedButtonOff = new RoundedButton("switcher")
println(roundedButtonOff.click())


class TestButton(label: String) extends Button {
  override def click(): String = s"test button -test- has been clicked"
}

val roundedButtonOff = new TestButton("test")
println(roundedButtonOff.click())
