package xbin.sys.entity;

import org.codehaus.jackson.annotate.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class SysUser implements Serializable{

    @NotNull
    private String id;

    @JsonProperty("name")
    @XmlElement(name = "name")
    @NotNull
    @Size(min = 6, max = 50)
    private String name;
    
	public SysUser() {
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
	
}
