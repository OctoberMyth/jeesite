package com.thinkgem.jeesite.common.utils.validate.rimpl;

import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.utils.validate.IRemoteVallidator;

@Component
public class RepeatCheck implements IRemoteVallidator{

	@Override
	public boolean test(Object value) {
		return false;
	}

}
