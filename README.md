Otomat Java Uygulaması
Bu Java projesi, kullanıcıların ve yöneticilerin bir otomat sistemi (Otomat) ile etkileşim kurmasına olanak tanıyan bir simülasyonu içerir. Uygulama, ürün listeleme, ürün satın alma ve yönetici paneli ile ürün ve admin yönetimi gibi özellikler sunar.

Özellikler
Kullanıcı İşlevleri:
  1. Ürün Listeleme:

      • Kullanıcılar, mevcut ürünleri, ürün numaraları, adları, fiyatları ve stok miktarları ile birlikte görüntüleyebilir.
      
  2. Ürün Satın Alma:

      • Kullanıcılar bir ürün numarası seçtikten sonra para girişi yapar. Yeterli para sağlanırsa ve ürün stokta mevcutsa, ürün teslim edilir ve para üstü iade edilir.
  
  3. Çıkış:
      • Kullanıcılar uygulamadan çıkış yapabilir.

Yönetici İşlevleri:
  1. Yönetici Girişi:
      • Yöneticiler, kullanıcı adı ve parola ile giriş yapabilirler.

  2. Ürün Ekleme:
      • Yönetici girişi yaptıktan sonra, yöneticiler yeni ürünler ekleyebilir. Ürün numarası, adı, fiyatı ve stok miktarı belirlenir.

  3. Yeni Yönetici Kaydı:
      • Yöneticiler, yeni admin hesapları oluşturabilirler. Bunun için kullanıcı adı ve parola girilmelidir.

  4. Yönetici Panelinden Çıkış:
      • Yöneticiler, yönetici panelinden çıkış yapabilirler.

Proje Yapısı
    • main.java: Otomatla etkileşim için ana mantığı içerir. Ürün listeleme, satın alma ve yönetici paneli seçeneklerini yönetir.

    • Otomat.java: Otomatı temsil eder. Ürün yönetimi, admin giriş işlemleri, dosya okuma/yazma ve ürün satın alma işlemlerini içerir.

    • admin.java: Bir yönetici hesabını temsil eder. Yönetici adı, ID'si ve parolası gibi özellikleri ve bu özellikleri almak ve ayarlamak için metodları vardır.

    • Urun.java: Ürünleri temsil eder. Ürün numarası, adı, fiyatı ve stok miktarı gibi özelliklere sahiptir.

Veri Depolama
    1. Ürünler:
      • Ürünler, bir dosyada (urunler.txt) saklanır. Otomat, bu dosyayı ürünleri yüklemek veya yeni ürünler eklemek için kullanır.

    2. Yöneticiler:
      • Yönetici bilgileri (adminler.txt) dosyasında saklanır. Adminler başlangıçta bu dosyadan yüklenir ve yeni adminler kayıt edildiklerinde bu dosyaya yazılır.

Nasıl Çalışır?
    1. Uygulamayı Başlatın:
      • Kullanıcıya hoş geldiniz ekranı sunulur ve ürünleri listeleme, yönetici girişi yapma veya çıkış seçenekleri sunulur.

    2. Ürün Listeleme ve Satın Alma:
      • Ürünler listelendikten sonra kullanıcılar, ürünleri fiyat ve stok bilgisi ile görüntüleyebilir. Ürün seçtikten sonra para girilir ve yeterli para varsa ürün teslim edilir, para üstü verilir.

    3. Yönetici Paneli:
      • Yöneticiler giriş yaptıktan sonra, yeni ürün ekleyebilir veya yeni admin kaydedebilir. Yönetici paneli, çıkış seçeneği seçilene kadar aktif kalır.

Dosya Yapısı
    • main.java: Uygulamanın ana mantığını içerir.
    • Otomat.java: Ürün yönetimi ve yönetici doğrulama işlemlerini içeren sınıf.
    • admin.java: Yönetici hesapları için sınıf.
    • Urun.java: Ürün yönetimi için sınıf.
    • urunler.txt: Ürün verilerini saklar.
    • adminler.txt: Yönetici verilerini saklar.

Gelecekteki Geliştirmeler
  • Grafik kullanıcı arayüzü (GUI) eklenerek kullanıcı deneyimi iyileştirilebilir.
  • Mevcut ürünleri güncelleme veya silme özelliği eklenebilir.
  • Yönetici paneline satış raporları görüntüleme veya popüler ürün takibi özellikleri eklenebilir.

Kurulum Talimatları
  • Projeyi yerel makinenize klonlayın.
  • Java dosyalarını tercih ettiğiniz IDE veya komut satırı ile derleyin.
  • main sınıfını çalıştırarak otomat uygulamasını başlatın.
  • Yönetici bilgileri adminler.txt dosyasına aşağıdaki formatta eklenebilir: adminName,adminId,adminPassword.              
