package org.gonchar.time.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "mainBean")
@RequestScoped
public class MainBean {

	public String go() {
		return "time";
	}
}
