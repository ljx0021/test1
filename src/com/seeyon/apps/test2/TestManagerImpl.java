package com.seeyon.apps.test2;

import java.util.ArrayList;
import java.util.List;

import org.mvel2.optimizers.impl.refl.nodes.ArrayLength;

import com.alibaba.fastjson.JSONObject;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.organization.bo.V3xOrgMember;
import com.seeyon.ctp.organization.dao.OrgHelper;
import com.seeyon.v3x.common.web.login.CurrentUser;

public class TestManagerImpl implements TestManager {

	@Override
	public String getName() {
		if(CurrentUser.get()!=null){
			return CurrentUser.get().getName();
		}
		return null;
	}

	@Override
	public String showListMember() {
		List<V3xOrgMember> list = new ArrayList<>();
		try {
			list = OrgHelper.getOrgManager().getAllMembersByAccountId(OrgHelper.getOrgManager().getRootAccount().getId(), 1, null, null, null, null, null);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return JSONObject.toJSONString(list);
	}

}
