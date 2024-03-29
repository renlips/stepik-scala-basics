trait Configs {
  val ACCOUNT_TYPE_DEFAULT = "free"
  val ACCOUNT_TYPE_PAID = "paid"
  val SUBSCRIPTION_STATUS = "active"
}

object Settings {
  case class AccountSettings(
                              email: String,
                              password: String,
                              picture: String)

  case class SubscriptionSettings(
                                   payment: String,
                                   notifications: String,
                                   expiration: String)
}

trait Subscriber {
  def subscribe(settings: Settings.SubscriptionSettings): Unit = println("subscribed")
}

trait Unsubscriber {
  def unsubscribe(): Unit = println("unsubscribed")
}

abstract class Account(accountID: String, settings: Settings.AccountSettings) {
  def info(): Unit
}

class FreeAccount(
                   accountID: String,
                   settings: Settings.AccountSettings) extends Account(
                                                                        accountID: String,
                                                                        settings: Settings.AccountSettings) with Subscriber with Configs {

  override def info(): Unit = println(s"Account Type: $ACCOUNT_TYPE_DEFAULT")
}

class PaidAccount(
                   accountID: String,
                   settings: Settings.AccountSettings) extends Account(
                                                                        accountID: String,
                                                                        settings: Settings.AccountSettings) with Unsubscriber with Configs {
  override def info(): Unit = {
    println(s"Account Type: $ACCOUNT_TYPE_PAID")
    println(s"Subscription Status: $SUBSCRIPTION_STATUS")
  }
}

val paidAccount = new PaidAccount(
  accountID = "1",
  settings = Settings.AccountSettings(
    email = "test@mail.com",
    password = "abr#45&",
    picture = "link/to/some/pic"))

paidAccount.info()
paidAccount.unsubscribe()