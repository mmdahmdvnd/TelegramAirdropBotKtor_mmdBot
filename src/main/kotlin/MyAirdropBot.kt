import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Update

class MyAirdropBot(botToken: String) : TelegramLongPollingBot(botToken) {

 override fun getBotUsername(): String = "YOUR_BOT_USERNAME"

 override fun onUpdateReceived(update: Update) {
  // پیاده‌سازی منطق بات
 }
}
