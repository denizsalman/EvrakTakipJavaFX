package application.entity;

public class Ilce {

	private Integer ilce_no;
	private Integer il_no;
	private String isim;
	
	public Ilce() {
	}
	
	public Ilce(Integer il_no, String isim) {
		this.il_no = il_no;
		this.isim = isim;
	}
	
	public Integer getIl_no() {
		return il_no;
	}
	public void setIl_no(Integer il_no) {
		this.il_no = il_no;
	}
	public String getIsim() {
		return isim;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}

	public Integer getIlce_no() {
		return ilce_no;
	}

	public void setIlce_no(Integer ilce_no) {
		this.ilce_no = ilce_no;
	}
	
	@Override
	public String toString() {
		return "Ilce [ilce_no=" + ilce_no + ", il_no=" + il_no + ", isim=" + isim + "]";
	}
}
