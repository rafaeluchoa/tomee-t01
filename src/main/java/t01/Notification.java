package t01;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_NTFC")
public class Notification implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_NTFC")
	private String id;
	
	@Column(name = "NM_NTFC")
	private String name;
	
	@Column(name = "DS_MSG")
	private String msg;
	
	public Notification() {
	}

	public Notification(String id, String name, String msg) {
		this.id = id;
		this.name = name;
		this.msg = msg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", name=" + name + ", msg=" + msg + "]";
	}

}
