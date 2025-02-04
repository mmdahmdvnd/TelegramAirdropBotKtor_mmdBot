FROM openjdk:17-jdk-slim

# کپی فایل JAR به داخل کانتینر
COPY build/libs/mmd-ktor-telegram-all.jar /app/app.jar

# دستور اجرای برنامه
CMD ["java", "-jar", "/app/app.jar"]