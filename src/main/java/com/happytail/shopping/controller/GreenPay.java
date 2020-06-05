package com.happytail.shopping.controller;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutCVS;
import ecpay.payment.integration.domain.AioCheckOutDevide;
import ecpay.payment.integration.domain.InvoiceObj;
@Controller
public class GreenPay {
	//開啟綠界交易
	public static AllInOne all;
	private static void initial(){
		all = new AllInOne("");
	}
//	@GetMapping("/getGreen.do")
//	public String getGreen(Model m) {
//		initial();
//		AioCheckOutCVS obj = new AioCheckOutCVS();
//		InvoiceObj invoice = new InvoiceObj();
//		UUID uid = UUID.randomUUID();
//		obj.setMerchantTradeNo(uid.toString().replaceAll("-", "").substring(0, 20));
//		DateFormat  day = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		String strBeginDate =day.format(new Date() );
//
//		obj.setMerchantTradeDate(strBeginDate); //設定MerchantTradeDate 合作特店交易時間，請以 yyyy/MM/dd HH:mm:ss格式帶入
//
//		obj.setTotalAmount("50");
//		obj.setTradeDesc("test Description");//交易描述
//		obj.setItemName("寵毛網商城");//商品名稱
//		obj.setReturnURL("http://211.23.128.214:5000"); //設定ReturnURL 付款完成通知回傳網址
//		obj.setNeedExtraPaidInfo("N");//設定NeedExtraPaidInfo 是否需要額外的付款資訊
//		obj.setStoreExpireDate("3"); //設定StoreExpireDate 超商繳費截止時間
//		obj.setInvoiceMark("Y"); //設定InvoiceMark 電子發票開立註記
//		invoice.setRelateNumber("test201217test");
//		invoice.setCustomerID("123456");
//		invoice.setCarruerType("1");
//		invoice.setTaxType("1");
//		invoice.setCarruerNum("");
//		invoice.setDonation("2");
//		invoice.setLoveCode("X123456");
//		invoice.setPrint("0");
//		invoice.setCustomerName("Mark");
//		invoice.setCustomerAddr("台北市南港區三重路");
//		invoice.setCustomerPhone("0911429215");
//		invoice.setDelayDay("1");
//		invoice.setInvType("07");
//		invoice.setInvoiceItemName("測試");
//		invoice.setInvoiceItemCount("1");
//		invoice.setInvoiceItemWord("個");
//		invoice.setInvoiceItemPrice("50");
//		invoice.setInvoiceItemTaxType("1");
//		String form = all.aioCheckOut(obj, invoice);
//		System.out.println(form);
//		return null;
//	}
	
//	public static void main(String[] args) {
//		initial();
//		System.out.println("aioCheckOutCVS: " + genAioCheckOutCVS());
//	}
	
//	public static String genAioCheckOutCVS(){
//		AioCheckOutCVS obj = new AioCheckOutCVS();
//		InvoiceObj invoice = new InvoiceObj();
//		UUID uid = UUID.randomUUID();
//		obj.setMerchantTradeNo(uid.toString().replaceAll("-", "").substring(0, 20));
//		DateFormat  day = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		String strBeginDate =day.format(new Date() );
//		//2017/01/01 08:05:23
//		
//		System.out.println(strBeginDate);
//		obj.setMerchantTradeDate(strBeginDate); //設定MerchantTradeDate 合作特店交易時間，請以 yyyy/MM/dd HH:mm:ss格式帶入
//		obj.setTotalAmount("10000");
//		obj.setTradeDesc("商品");//交易描述
//		obj.setItemName("寵毛往商品");	
//		obj.setReturnURL("http://211.23.128.214:5000");
//		obj.setNeedExtraPaidInfo("N");
//		obj.setStoreExpireDate("3");
//		obj.setInvoiceMark("Y");
//		invoice.setRelateNumber("test201217test");
//		invoice.setCustomerID("123");
//		invoice.setCarruerType("1");
//		invoice.setTaxType("1");
//		invoice.setCarruerNum("");
//		invoice.setDonation("2");
//		invoice.setLoveCode("X123456"); //愛心碼
//		invoice.setPrint("0");
//		invoice.setCustomerName("資策會");
//		invoice.setCustomerAddr("客戶家的地址");
//		invoice.setCustomerPhone("0912345678");
//		invoice.setDelayDay("1");
//		invoice.setInvType("07");
//		invoice.setInvoiceItemName("測試");
//		invoice.setInvoiceItemCount("10");
//		invoice.setInvoiceItemWord("個");
//		invoice.setInvoiceItemPrice("30");
//		invoice.setInvoiceItemTaxType("1");
//		String form = all.aioCheckOut(obj, invoice);
//		return form;
//	}
	
//	public static String genAioCheckOutDevide(){
//		AioCheckOutDevide obj = new AioCheckOutDevide();
//		obj.setMerchantTradeNo("testCompany0007");
//		obj.setMerchantTradeDate("2017/01/01 08:05:23");
//		obj.setTotalAmount("50");
//		obj.setTradeDesc("test Description");
//		obj.setItemName("TestItem");
//		obj.setReturnURL("http://211.23.128.214:5000");
//		obj.setNeedExtraPaidInfo("N");
//		obj.setCreditInstallment("3,6");
//		obj.setInstallmentAmount("10");
//		String form = all.aioCheckOut(obj, null);
//		return form;
//	}
	
	@GetMapping("/getGreen.do")
	public String getGreen(Model m) {
		initial();
		AioCheckOutCVS obj = new AioCheckOutCVS();
		InvoiceObj invoice = new InvoiceObj();
		UUID uid = UUID.randomUUID();
		obj.setMerchantTradeNo(uid.toString().replaceAll("-", "").substring(0, 20));
		DateFormat  day = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String strBeginDate =day.format(new Date() );
		//2017/01/01 08:05:23
		
		System.out.println(strBeginDate);
		obj.setMerchantTradeDate(strBeginDate); //設定MerchantTradeDate 合作特店交易時間，請以 yyyy/MM/dd HH:mm:ss格式帶入
		obj.setTotalAmount("10000");
		obj.setTradeDesc("商品");//交易描述
		obj.setItemName("寵毛往商品");	
		obj.setReturnURL("http://211.23.128.214:5000");
		obj.setNeedExtraPaidInfo("N");
		obj.setStoreExpireDate("3");
		obj.setInvoiceMark("Y");
		invoice.setRelateNumber("test201217test");
		invoice.setCustomerID("123");
		invoice.setCarruerType("1");
		invoice.setTaxType("1");
		invoice.setCarruerNum("");
		invoice.setDonation("2");
		invoice.setLoveCode("X123456"); //愛心碼
		invoice.setPrint("0");
		invoice.setCustomerName("資策會");
		invoice.setCustomerAddr("客戶家的地址");
		invoice.setCustomerPhone("0912345678");
		invoice.setDelayDay("1");
		invoice.setInvType("07");
		invoice.setInvoiceItemName("測試");
		invoice.setInvoiceItemCount("10");
		invoice.setInvoiceItemWord("個");
		invoice.setInvoiceItemPrice("30");
		invoice.setInvoiceItemTaxType("1");
		String form = all.aioCheckOut(obj, invoice);
		return form;
	}
	
	
	
}
