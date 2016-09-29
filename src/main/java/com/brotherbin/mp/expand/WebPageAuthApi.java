package com.brotherbin.mp.expand;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jfinal.kit.HttpKit;
import com.jfinal.kit.PropKit;
import com.jfinal.weixin.sdk.api.ApiResult;

public class WebPageAuthApi {

	private static String OAuthUrl = "https://api.weixin.qq.com/sns/oauth2/access_token";
	
	private static Log log = LogFactory.getLog(WebPageAuthApi.class);
	
	public static ApiResult getOAuthOpenId(String code){
		Map<String, String> params = new HashMap<String, String>();
		params.put("appid", PropKit.get("appId"));
		params.put("secret", PropKit.get("appSecret"));
		params.put("code", code);
		params.put("grant_type", "authorization_code");
		
		log.info(params);
		
		String jsonRs = HttpKit.get(OAuthUrl, params);
		
		return new ApiResult(jsonRs);
	}
	
}
