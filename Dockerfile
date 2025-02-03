# استفاده از JDK 17 به‌عنوان بیس ایمیج
FROM openjdk:17-jdk-slim

# تنظیم دایرکتوری کاری داخل کانتینر
WORKDIR /app

# کپی کردن فایل JAR به داخل کانتینر
COPY build/libs/mmd-ktor-telegram-all.jar app.jar

# اجرای برنامه Ktor
CMD ["java", "-jar", "app.jar"]
