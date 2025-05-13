# Selenium Login Test

Bu proje, Java ve Selenium WebDriver kullanılarak hazırlanan basit bir login otomasyon testidir. Proje Maven tabanlıdır ve gerekli bağımlılıkları `pom.xml` üzerinden yönetir.

## 📁 Proje Yapısı

```
LoginTest/
├── src/
│   ├── main/
│   └── test/
│       └── java/
│           └── LoginTest.java
├── screenshots/
├── pom.xml
└── README.md
````
## ⚙️ Gereksinimler

- Java 17+ (veya uyumlu sürüm)
- Maven 3.6+
- Bir IDE (Örn: IntelliJ IDEA)
- Chrome tarayıcısı ve `chromedriver` (PATH'e eklenmiş)

## 🧪 Kullanılan Teknolojiler

- **Selenium WebDriver**
- **JUnit/TestNG** (test çalıştırma)
- **Apache Commons IO** (screenshot kaydetme işlemleri için)
- **Maven** (bağımlılık yönetimi)

## 🛠 Kurulum

1. **Projeyi klonla**:
   ```bash
   git clone https://github.com/kullaniciadi/LoginTest.git
   cd LoginTest
Bağımlılıkları indir:

 - mvn clean install
Eğer aşağıdaki gibi bir hata alırsanız:

org.apache.commons:commons-io:jar:2.11.0 not found

pom.xml içindeki sürüm numarasını 2.8.0 gibi mevcut bir sürümle değiştirin.

IDE'de projeyi açın ve Maven ile senkronize edin.

▶️ Testi Çalıştırma
Aşağıdaki komutla testleri çalıştırabilirsiniz:

 - mvn test

Başarılı bir test sonunda ekran görüntüsü screenshots/ klasörüne kaydedilir.

📸 Screenshot Alımı
Test tamamlandığında, TakesScreenshot arayüzü ile ekran görüntüsü alınır ve screenshots/ klasörüne .png formatında kaydedilir.

Eğer görüntü alınmazsa, aşağıdakileri kontrol edin:

- Headless modda çalışmıyor olmalı

- screenshots klasörü mevcut olmalı (kod içinde otomatik oluşturuluyor)

- Dosya yazma yetkisi olan bir dizine kayıt yapılmalı

🧹 Sorunlar ve Çözümleri
🔧 org.apache.commons:commons-io:2.11.0 bulunamadı

Hata:
Could not find artifact org.apache.commons:commons-io:jar:2.11.0
Çözüm:
pom.xml dosyasında commons-io sürümünü 2.8.0 gibi stabil bir sürümle değiştirin.

<dependency>
<groupId>org.apache.commons</groupId>
<artifactId>commons-io</artifactId>
<version>2.8.0</version>
</dependency>


✍️ Katkıda Bulunma
Pull request'ler ve katkılar memnuniyetle kabul edilir. Daha fazla test senaryosu, farklı tarayıcı destekleri veya hata yönetimi geliştirmeleri önerilebilir.

🧑‍💻 Hazırlayan : 

Serpil Çobanlar

Email: serpil.cobanlar0@gmail.com

LinkedIn: https://www.linkedin.com/in/serpil-%C3%A7obanlar-52a21b253/