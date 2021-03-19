package application.evrak;

public class GelenEvrak {

	private String id;
	private String sira;
	private String idariBirimKodu;
	private String il;
	private String ilce;
	private String kurumKisi;
	private String tarih;
	private String ek;
	private String kayitTarihi;
	private String aciklama;
	
	public GelenEvrak(String id, String sira, String idariBirimKodu, String il, String ilce, String kurumKisi,
			String tarih, String ek, String kayitTarihi, String aciklama) {
		this.id = id;
		this.sira = sira;
		this.idariBirimKodu = idariBirimKodu;
		this.il = il;
		this.ilce = ilce;
		this.kurumKisi = kurumKisi;
		this.tarih = tarih;
		this.ek = ek;
		this.kayitTarihi = kayitTarihi;
		this.aciklama = aciklama;
	}

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

	public String getSira() {
		return sira;
	}

	public void setSira(String sira) {
		this.sira = sira;
	}

	public String getIdariBirimKodu() {
		return idariBirimKodu;
	}

	public void setIdariBirimKodu(String idariBirimKodu) {
		this.idariBirimKodu = idariBirimKodu;
	}

	public String getKurumKisi() {
		return kurumKisi;
	}

	public void setKurumKisi(String kurumKisi) {
		this.kurumKisi = kurumKisi;
	}

	public String getEk() {
		return ek;
	}

	public void setEk(String ek) {
		this.ek = ek;
	}

	public String getKayitTarihi() {
		return kayitTarihi;
	}

	public void setKayitTarihi(String kayitTarihi) {
		this.kayitTarihi = kayitTarihi;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	
	
}
