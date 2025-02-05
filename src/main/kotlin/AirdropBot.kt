package ir.androidmaterial

import ir.androidmaterial.BlockchainService.sendTokens
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

class AirdropBot(botToken: String) : TelegramLongPollingBot(botToken) {

    override fun getBotUsername(): String = "mhmmdahmadvand_bot"

    override fun onUpdateReceived(update: Update) {
        if (update.hasMessage() && update.message.hasText()) {
            val chatId = update.message.chatId.toString()
            val text = update.message.text

            when {
                text == "/start" -> sendMessage(chatId, "👋 سلام! لطفاً وظایف را انجام دهید تا ایردراپ دریافت کنید.")
                text.startsWith("/wallet ") -> {
                    val walletAddress = text.removePrefix("/wallet ").trim()
                    sendMessage(chatId, "✅ آدرس کیف پول شما: $walletAddress ثبت شد.")
                    sendTokens(walletAddress, chatId)
                }
                else -> sendMessage(chatId, "⚠ دستور نامعتبر! لطفاً از `/start` استفاده کنید.")
            }
        }
    }

    private fun sendMessage(chatId: String, text: String) {
        val message = SendMessage(chatId, text)
        try {
            execute(message)
        } catch (e: TelegramApiException) {
            println("Failed to send message: ${e.message}")
        }
    }
}
