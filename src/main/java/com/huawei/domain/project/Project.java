package com.huawei.domain.project;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * ��Ŀ<br>
 * 
 * @author zhangxincheng
 *
 */
public class Project {
	@Id
	private String id;

	// #region Fields

	@Setter
	@Getter
	private String name;

	@Setter
	@Getter
	private String creator;

	// #endregion

	// #region Constructor

	public Project() {
	}

	public Project(String name, String creator) {
		this.name = name;
		this.creator = creator;
	}
	// #endregion

}
