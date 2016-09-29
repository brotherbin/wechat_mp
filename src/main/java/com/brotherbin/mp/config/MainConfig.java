package com.brotherbin.mp.config;

import com.brotherbin.mp.controller.ApiImplController;
import com.brotherbin.mp.controller.MsgImplController;
import com.brotherbin.mp.handler.MainHandler;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.weixin.sdk.api.ApiConfigKit;

public class MainConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		PropKit.use("config.properties");
		me.setDevMode(PropKit.getBoolean("devMode", false));
		me.setBaseViewPath("view");
		
		// ApiConfigKit 设为开发模式可以在开发阶段输出请求交互的 xml 与 json 数据
		ApiConfigKit.setDevMode(PropKit.getBoolean("devMode", false));
	}

	@Override
	public void configHandler(Handlers me) {
		me.add(new MainHandler());
	}

	@Override
	public void configInterceptor(Interceptors me) {

	}

	@Override
	public void configPlugin(Plugins me) {
		
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/msg", MsgImplController.class, "/");
		me.add("/api", ApiImplController.class, "/");
	}

}
