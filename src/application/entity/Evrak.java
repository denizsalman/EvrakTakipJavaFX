package application.entity;

public class Evrak {
	
	private int id;
	private String idariBirimKodu;
	private String il;
	private String ilce;
	private String kurumKisi;
	private String kayitTarih;
	private String ek;
	private String evrakTarihi;
	private String aciklama;
	private String konu;
	
	public Evrak() {
	}
	

	public Evrak(String idariBirimKodu, String il, String ilce, String kurumKisi, String kayitTarih, String ek,
			String evrakTarihi, String aciklama, String konu) {
		this.idariBirimKodu = idariBirimKodu;
		this.il = il;
		this.ilce = ilce;
		this.kurumKisi = kurumKisi;
		this.kayitTarih = kayitTarih;
		this.ek = ek;
		this.evrakTarihi = evrakTarihi;
		this.aciklama = aciklama;
		this.konu = konu;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdariBirimKodu() {
		return idariBirimKodu;
	}
	public void setIdariBirimKodu(String idariBirimKodu) {
		this.idariBirimKodu = idariBirimKodu;
	}
	public String getIl() {
		return il;
	}
	public void setIl(String il) {
		this.il = il;
	}
	public String getIlce() {
		return ilce;
	}
	public void setIlce(String ilce) {
		this.ilce = ilce;
	}
	public String getKurumKisi() {
		return kurumKisi;
	}
	public void setKurumKisi(String kurumKisi) {
		this.kurumKisi = kurumKisi;
	}
	public String getKayitTarih() {
		return kayitTarih;
	}
	public void setKayitTarih(String kayitTarih) {
		this.kayitTarih = kayitTarih;
	}
	public String getEk() {
		return ek;
	}
	public void setEk(String ek) {
		this.ek = ek;
	}
	public String getEvrakTarihi() {
		return evrakTarihi;
	}
	public void setEvrakTarihi(String evrakTarihi) {
		this.evrakTarihi = evrakTarihi;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public String getKonu() {
		return konu;
	}

	public void setKonu(String konu) {
		this.konu = konu;
	}
	
	
}
