// basamaklarına ayırmak
public class Uygulama_06 {
    public static void main(String[] args) {
        int sayi = 956;
        int birler = sayi % 10;
        int onlar = (sayi % 100) / 10;
        int yuzler = sayi / 100;
        String sayiTurkce = "";
        if(yuzler == 9) sayiTurkce = sayiTurkce + "Dokuz ";
        if(yuzler == 8) sayiTurkce = sayiTurkce + "Sekiz ";
        if(yuzler == 7) sayiTurkce = sayiTurkce + "Yedi ";
        if(yuzler == 6) sayiTurkce = sayiTurkce + "Altı ";
        if(yuzler == 5) sayiTurkce = sayiTurkce + "Beş ";
        if(yuzler == 4) sayiTurkce = sayiTurkce + "Dört ";
        if(yuzler == 3) sayiTurkce = sayiTurkce + "Üç ";
        if(yuzler == 2) sayiTurkce = sayiTurkce + "İki ";
        if(yuzler == 1) sayiTurkce = sayiTurkce + "Bir ";
        sayiTurkce += "yüz ";
        // onlar basamağını yazdıralım
        if(onlar == 9) sayiTurkce += "Doksan ";
        if(onlar == 8) sayiTurkce += "Seksen ";
        if(onlar == 7) sayiTurkce += "Yetmiş ";
        if(onlar == 6) sayiTurkce += "Altmış ";
        if(onlar == 5) sayiTurkce += "Elli ";
        if(onlar == 4) sayiTurkce += "Kırk ";
        if(onlar == 3) sayiTurkce += "Otuz ";
        if(onlar == 2) sayiTurkce += "Yirmi ";
        if(onlar == 1) sayiTurkce += "On ";
        // birler basamağı
        if(birler == 9) sayiTurkce += "Dokuz ";
        if(birler == 8) sayiTurkce += "Sekiz ";
        if(birler == 7) sayiTurkce += "Yedi ";
        if(birler == 6) sayiTurkce += "Altı ";
        if(birler == 5) sayiTurkce += "Beş ";
        if(birler == 4) sayiTurkce += "Dört ";
        if(birler == 3) sayiTurkce += "Üç ";
        if(birler == 2) sayiTurkce += "İki ";
        if(birler == 1) sayiTurkce += "Bir ";
        
        // Ekrana yazdıralım
        System.out.println(sayi + " " + sayiTurkce);

    }
}
