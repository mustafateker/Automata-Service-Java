package Automata;
import java.util.Scanner;
import java.util.UUID;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
public class Otomat {
	private Map<Integer, Urun> urunler;
	private Map<String, admin> adminler;
	private static final String ADMIN_DOSYA = "adminler.txt";
	private static final String URUN_DOSYA = "urunler.txt";
	
	
	public Otomat() {
		adminler = new HashMap<>();
		adminYukle();
		urunler = new HashMap<>();
	}
	public void AdminEkle(admin admin) {
		adminler.put(admin.getadminName(), admin);
		adminDosyayaYaz(admin);
	}
	
	public boolean adminGiris(String kullaniciAdi, String sifre) {
		admin admin = adminler.get(kullaniciAdi);
		return admin != null && admin.getadminPassword().equals(sifre);
	}
	
	private void adminDosyayaYaz(admin admin) {
		try(FileWriter fileWriter = new FileWriter(ADMIN_DOSYA,true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
				UUID UID = UUID.randomUUID();
				bufferedWriter.write(admin.getadminName() + "," + admin.getadminId() + "," + admin.getadminPassword());
				bufferedWriter.newLine();
		} catch(IOException e) {
			System.out.println("Dosya yazılırken bir hata oluştu: " + e.getMessage());
		}
	}
	
	public void urunDosyaYaz(Urun urun) {
		try(FileWriter fileWriter = new FileWriter(URUN_DOSYA,true);
				BufferedWriter bufferWriter = new BufferedWriter(fileWriter)){
				
			bufferWriter.write(urun.getNo() + "," + urun.getAd() + "," + urun.getFiyat() + "," + urun.getStok());
			bufferWriter.newLine();
			}catch(IOException e) {
				System.out.println("Dosya yazılırken bir hata oluştur: " + e.getMessage());
			}
	}
	//Ürünleri dosyadan yükleme
	public void urunYukle() {
		try(FileReader readFile = new FileReader(URUN_DOSYA);
				BufferedReader bufferReader = new BufferedReader(readFile)){
			String satir;
			while((satir = bufferReader.readLine()) != null) {
					String[] productsInfo = satir.split(",");
					if(productsInfo.length == 4) { //4 field urunNo , urunAd ,urunFiyat, urunStok
						urunler.put(Integer.valueOf(productsInfo[0]), 
								new Urun(productsInfo[1] , Double.valueOf(productsInfo[2]) ,Integer.valueOf(productsInfo[3])));
					}
			}
		}catch(FileNotFoundException e) {
			System.out.println("Ürünler dosyası bulunamadı! Yeni dosya oluşturuluyor.");
		}catch(IOException e) {
			System.out.println("Dosya okunurken bir hata oluştu: " + e.getMessage());
		}
	}
	
	private void adminYukle() {
	    try (FileReader readFile = new FileReader(ADMIN_DOSYA);
	         BufferedReader bufferReader = new BufferedReader(readFile)) {

	        String satir;
	        while ((satir = bufferReader.readLine()) != null) {
	            String[] informations = satir.split(",");
	            if (informations.length == 3) { // 3 field: adminName, adminId, adminPassword
	                adminler.put(informations[0], new admin(informations[0], informations[1], informations[2]));
	            }
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("Admin dosyası bulunamadı! Yeni dosya oluşturuluyor.");
	    } catch (IOException e){
	        System.out.println("Dosya okunurken bir hata oluştu: " + e.getMessage());
	    }
	}
	
	public void urunEkle(int numara, Urun urun) {
		urunler.put(numara, urun);
	}
	
	public void urunListele() {
		System.out.println("Mevcut Ürünler");
		for(Map.Entry<Integer, Urun> entry : urunler.entrySet()) {
			Urun urun = entry.getValue();
			
			System.out.println(entry.getKey() + ". " + urun.getAd() + " - Fiyat: "
					+ urun.getFiyat() + " ₺ - Stok: " + urun.getStok());
		}
	}
	
	public void satinAl (int numara, double para) {
		Urun urun = urunler.get(numara);
		if(urun == null) {
			System.out.println("Geçersiz ürün numarası!");
			return;
		}
		if(urun.getStok() <= 0) {
			System.out.println("Bu üründe stok mevcut değil!");
			return;
		}
		if(para < urun.getFiyat()) {
			System.out.println("Yetersiz bakiye! Ürünün fiyatı : " + urun.getFiyat() + "₺");
			return;
		}
		double paraUstu = para - urun.getFiyat();
		urun.setStok(urun.getStok()-1);
		System.out.println(urun.getAd() + "Ürün teslim edildi, Para üstü: " + paraUstu + "₺");
	}
}
