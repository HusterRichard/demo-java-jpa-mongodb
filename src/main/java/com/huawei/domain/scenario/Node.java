package com.huawei.domain.scenario;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * ��Ԫ<br>
 * 
 * @author zhangxincheng
 *
 */
public class Node {
	@Id
	private String id;

	// #region Fields

	@Setter
	@Getter
	private String name;

	@Setter
	@Getter
	private String vendor;

	// #endregion

	// #region Constructor

	public Node() {
	}

	public Node(String name, String vendor) {
		this.name = name;
		this.vendor = vendor;
	}

	// #endregion

}
