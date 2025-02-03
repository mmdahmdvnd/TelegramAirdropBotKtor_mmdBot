package ir.androidmaterial

import ir.androidmaterial.BlockchainService.sendTokens
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.generics.BotOptions
import org.telegram.telegrambots.meta.generics.BotSession
import org.telegram.telegrambots.meta.generics.LongPollingBot
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

  open class AirdropBot(function: () -> Unit) : LongPollingBot {

    private lateinit var session: BotSession
    private lateinit var botsApi: TelegramBotsApi  // اضافه کردن متغیر برای مدیریت API تلگرام

    override fun getBotUsername(): String = "mhmmdahmadvand_bot"

    override fun getBotToken(): String = "8170023792:AAG8wtXbQO7MdrDipddveiEMNetWYR-dwx0"

    fun start() {
        botsApi = TelegramBotsApi(DefaultBotSession::class.java)
        session = botsApi.registerBot(this)  // مقداردهی و راه‌اندازی بوت
    }

    fun stop() {
        session.stop()
    }

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

      override fun getOptions(): BotOptions {
          TODO("Not yet implemented")
      }

      override fun clearWebhook() {
          TODO("Not yet implemented")
      }

      private fun sendMessage(chatId: String, text: String) {
//        val message = SendMessage
    }
}