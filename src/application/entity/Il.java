package application.entity;

public class Il {

	private Integer il_no;
	private String isim;
	
	public Il() {
	}
	
	public Il(Integer il_no, String isim) {
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

	@Override
	public String toString() {
		return "Il [il_no=" + il_no + ", isim=" + isim + "]";
	}
}
