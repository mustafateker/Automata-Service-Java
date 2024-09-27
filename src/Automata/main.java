package Automata;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
public class main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Otomat otomat = new Otomat();
		
		//otomat.AdminEkle(new admin("admin" , "123", "1234"));
		
		
		boolean devam = true;
		
		while(devam) {
			System.out.println("-----------------HOŞGELDİNİZ-----------------");
			System.out.println("\n1. Ürün Listele");
			System.out.println("2. Admin Girişi");
			System.out.println("3. Çıkış");
			System.out.println("Seçiminiz : ");
			int secim = scanner.nextInt();
			
			switch(secim) {
			case 1:
				Scanner inputScanner = new Scanner(System.in);
				otomat.urunYukle();
				otomat.urunListele();
				System.out.println("Lütfen almak istediğiniz ürün numarasını giriniz.");
				int selectedProductNo = inputScanner.nextInt();
				System.out.println("Lütfen Para Girişi Yapınız!");
				double cash = inputScanner.nextDouble();
				otomat.satinAl(selectedProductNo, cash);
				break;
			
			case 2:
				System.out.println("Admin kullanıcı adini giriniz: ");
				String kullanıcıAdi = scanner.next();
				System.out.println("Parola giriniz: ");
				String sifre = scanner.next();
				if(otomat.adminGiris(kullanıcıAdi, sifre)) {
					boolean flag = true;
					while(flag){
						System.out.println("Admin girişi başarılı.\n");
						System.out.println("-----------------ADMIN PANEL-----------------");
						System.out.println("\n1. Ürün Ekle");
						System.out.println("2. Admin Kayıt");
						System.out.println("3. Çıkış");
						System.out.println("Seçiminiz : ");
						int adminSelection = scanner.nextInt();
						switch(adminSelection) {
						case 1:
							Scanner input = new Scanner(System.in);
							System.out.println("Lütfen ürün numarasını girinzi");
							int number = input.nextInt();
							System.out.println("Lütfen ürün adını giriniz\n");
							String productName = input.next();
							System.out.println("Lütfen ürün fiyatını giriniz:\n ");
							float fiyat = input.nextFloat();
							System.out.println("Lütfen ürün stoğunu giriniz : \n");
							int stok = input.nextInt();
							Urun urun = new Urun(productName,fiyat,stok);
							urun.setNo(number);
							otomat.urunDosyaYaz(urun);
							System.out.println("1-Ürün Ekle");
							System.out.println("2-Çıkış");
							int selection = input.nextInt();
							if(selection==1) {
								flag = true;
							}else if(selection == 2) {
								flag = false;
							}else {
								System.out.println("Geçersiz seçim. Çıkış Yapılıyor...");
								flag = false;
							}
							break;
						case 2:
							System.out.println("Admin Kullanıcı Adı Giriniz: ");
							String adminUserName = scanner.next();
							System.out.println("Admin Parola Giriniz: ");
							String adminParola = scanner.next();
							admin admin = new admin();
							admin.setAdminName(adminUserName);
							admin.setAdminPassword(adminParola);
							otomat.AdminEkle(admin);
							break;
						case 3:
							flag = false;
							System.out.println("Çıkış yapılıyor! İyi günler dileriz.");
							break;
						default:
							System.out.println("Geçersiz seçim!");
							break;	
						}
						
					}
					break;
				}else {
					System.out.println("Geçersiz kullanıcı adı veya parola");
				}
				break;
			case 3:
				devam = false;
				System.out.println("Çıkış yapılıyor! İyi günler dileriz.");
				break;
			default:
				System.out.println("Geçersiz seçim!");
				break;
		}
	}
}
}
