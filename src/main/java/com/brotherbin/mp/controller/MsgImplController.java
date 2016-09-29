package com.brotherbin.mp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jfinal.kit.PropKit;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.MsgController;
import com.jfinal.weixin.sdk.msg.in.InImageMsg;
import com.jfinal.weixin.sdk.msg.in.InLinkMsg;
import com.jfinal.weixin.sdk.msg.in.InLocationMsg;
import com.jfinal.weixin.sdk.msg.in.InShortVideoMsg;
import com.jfinal.weixin.sdk.msg.in.InTextMsg;
import com.jfinal.weixin.sdk.msg.in.InVideoMsg;
import com.jfinal.weixin.sdk.msg.in.InVoiceMsg;
import com.jfinal.weixin.sdk.msg.in.event.InCustomEvent;
import com.jfinal.weixin.sdk.msg.in.event.InFollowEvent;
import com.jfinal.weixin.sdk.msg.in.event.InLocationEvent;
import com.jfinal.weixin.sdk.msg.in.event.InMassEvent;
import com.jfinal.weixin.sdk.msg.in.event.InMenuEvent;
import com.jfinal.weixin.sdk.msg.in.event.InQrCodeEvent;
import com.jfinal.weixin.sdk.msg.in.event.InTemplateMsgEvent;
import com.jfinal.weixin.sdk.msg.in.speech_recognition.InSpeechRecognitionResults;
import com.jfinal.weixin.sdk.msg.out.OutTextMsg;

public class MsgImplController extends MsgController {

	private static Log log = LogFactory.getLog(MsgImplController.class);
	
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
	 * 处理收到的文本消息
	 */
	@Override
	protected void processInTextMsg(InTextMsg inTextMsg) {
		String content = inTextMsg.getContent();
		OutTextMsg outMsg = new OutTextMsg(inTextMsg);
		outMsg.setContent("已收到您的消息：" + content);
		render(outMsg);
			
	}

	/**
	 * 处理收到的图片消息
	 */
	@Override
	protected void processInImageMsg(InImageMsg inImageMsg) {

	}

	/**
	 * 处理收到的语音消息
	 */
	@Override
	protected void processInVoiceMsg(InVoiceMsg inVoiceMsg) {

	}

	/**
	 * 处理收到的视频消息
	 */
	@Override
	protected void processInVideoMsg(InVideoMsg inVideoMsg) {

	}

	/**
	 * 处理收到的短视频消息
	 */
	@Override
	protected void processInShortVideoMsg(InShortVideoMsg inShortVideoMsg) {

	}

	/**
	 * 处理收到的位置消息
	 */
	@Override
	protected void processInLocationMsg(InLocationMsg inLocationMsg) {

	}

	/**
	 * 处理接收到的链接消息
	 */
	@Override
	protected void processInLinkMsg(InLinkMsg inLinkMsg) {

	}

	/**
	 * 处理接收到的多客服管理事件
	 */
	@Override
	protected void processInCustomEvent(InCustomEvent inCustomEvent) {

	}

	/**
	 * 处理关注/取消关注消息
	 */
	@Override
	protected void processInFollowEvent(InFollowEvent inFollowEvent) {
		// 关注
		if (InFollowEvent.EVENT_INFOLLOW_SUBSCRIBE.equals(inFollowEvent.getEvent())) {
			OutTextMsg outMsg = new OutTextMsg(inFollowEvent);
			outMsg.setContent("谢谢关注！");
			render(outMsg);
		} else { // 取消关注
			
		}
	}

	/**
	 * 处理接收到的扫描带参数二维码事件
	 */
	@Override
	protected void processInQrCodeEvent(InQrCodeEvent inQrCodeEvent) {

	}

	/**
	 * 处理接收到的上报地理位置事件
	 */
	@Override
	protected void processInLocationEvent(InLocationEvent inLocationEvent) {

	}
	
	/**
	 * 处理接收到的群发任务结束时通知事件
	 */
	@Override
	protected void processInMassEvent(InMassEvent inMassEvent) {

	}

	/**
	 * 处理接收到的自定义菜单事件
	 */
	@Override
	protected void processInMenuEvent(InMenuEvent inMenuEvent) {

	}

	/**
	 * 处理接收到的语音识别结果
	 */
	@Override
	protected void processInSpeechRecognitionResults(
			InSpeechRecognitionResults inSpeechRecognitionResults) {

	}

	/**
	 * 处理接收到的模板消息是否送达成功通知事件
	 */
	@Override
	protected void processInTemplateMsgEvent(
			InTemplateMsgEvent inTemplateMsgEvent) {

	}

}
