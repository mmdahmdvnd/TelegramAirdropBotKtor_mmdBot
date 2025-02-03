package ir.androidmaterial

import org.telegram.telegrambots.meta.generics.BotOptions

class MyAirdropBot(function: () -> Unit) : AirdropBot(function) {

 override fun getOptions(): BotOptions {
  return object : BotOptions {
   override fun getBaseUrl(): String {
    return "https://api.telegram.org"  // مقدار پیش‌فرض برای API تلگرام
   }
  }
 }
}
