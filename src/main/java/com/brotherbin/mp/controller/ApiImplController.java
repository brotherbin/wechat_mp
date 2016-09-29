package com.brotherbin.mp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jfinal.kit.PropKit;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.api.ApiResult;
import com.jfinal.weixin.sdk.api.MenuApi;
import com.jfinal.weixin.sdk.api.UserApi;
import com.jfinal.weixin.sdk.jfinal.ApiController;

public class ApiImplController extends ApiController {

	private static Log log = LogFactory.getLog(ApiImplController.class);
	
	@Override
	public ApiConfig getApiConfig() {
		ApiConfig ac = new ApiConfig();

		// 配置微信 API 相关常量
		ac.setToken(PropKit.get("token"));
		ac.setAppId(PropKit.get("appId"));
		ac.setAppSecret(PropKit.get("appSecret"));

		/**
		 * 是否对消息进行加密，对应于微信平台的消息加解密方式： 1：true进行加密且必须配置 encodingAesKey
		 * 2：false采用明文模式，同时也支持混合模式
		 */
		ac.setEncryptMessage(PropKit.getBoolean("encryptMessage", false));
		ac.setEncodingAesKey(PropKit.get("encodingAesKey",
				"setting it in config file"));
		return ac;
	}

	/**
	 * 获取公众号菜单
	 */
	public void getMenu() {
		ApiResult apiResult = MenuApi.getMenu();
		if (apiResult.isSucceed())
			renderJson(apiResult.getJson());
		else
			renderJson(apiResult.getErrorMsg());
	}
	
	/**
	 * 创建菜单
	 */
	public void createMenu() {
		String name = getPara("menuName");
		String url = getPara("menuUrl");
		
		String menuJson = 
			"{"
			+	"\"button\":[{"
				+ 	"\"type\":\"view\","
				+ 	"\"name\":\"" + name + "\","
				+ 	"\"url\":\"" + url + "\""
			+ 	"}]"
			+"}";
		
		ApiResult ar = MenuApi.createMenu(menuJson);
		renderJson(ar.getJson());
	}

	/**
	 * 获取公众号关注用户
	 */
	public void getFollowers() {
		log.info("get followers");
		ApiResult apiResult = UserApi.getFollows();
		renderJson(apiResult.getJson());
	}
	
	/**
	 * 发送模板消息
	 */
	public void sendTmplMsg() {
		
	}
	
	public void sendTmplMsgToAll() {
		
	}
	
	public void sendCustomTextMsg() {
		
	}

}
