package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2017060607430990";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = 
    		"MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCjZqXN5mpDTMK3JUDN0k7P/IwRtqIY/phNfuVDmrzegIJELPCqKymYNxsNTJ/kru6LF6boKGjeT0yZz4Prbgc+4uHFr7DQ8tIKdzOXPTqBw1Udu8wxUPqUsoP2c3hi9J8B+THFNZ9NxMbqE0NiLotSVKgpeb3nHtuV/3DShvH4wSBP40X6RmKclxzzvYza1ZXTPYwtZSyLPGuWxAbZzBgbjYGsVa+6wlhTeiGI+b/RguCCLrGeovnSyd1IXAS34RMefFhKDp2KEG/osu+3F5Fo25h31Ro7CqXS3EVTYStfhfBwNWGQiWMlU2l7LyGPqDRkjt3xAETL9JAoQJVKbMm1AgMBAAECggEAaC74pLG3KzX0KMYN7a2cJqzFuj2SWRFrlm3ETDiLF+skI8frovRmTvFDxFUI1cxbuD/aYcfyJVy2YJOZbzD2Wbhbb6o3uOI53gZm1JVrinU6/fxRk1gojUrNLQQuzBlgkOeMPkuUSQegNHsXybAXkOT9W4SN+qEILTlzfCgifBHRK3f7BECzFH8eLfDLOqIpI1GTWEwGkAIg4MICyDBfuYEuq5GB/+KFlac8KepOmnwF7u29eJwY/8Up39LG+O9MziXwH11iZcliMLsGZ+ldWFhsJYsZxY6sSM2jeplLd/OrmE+6gqlC0ht2sE0mcKP0FLt9GcCDb6xCh/wPeewIuQKBgQDhyqy4+Xj80HuAvyPO3q4XI5jDEsUuaCYDxo/DjRG/GGk22xRWP4i/S8SMxp99VRZAKGc1wJT+Ko/t/lCpBuPlCaM6U2V4Pp6sBkjDkn7b77l9wTJdV3dE1j5b6ZcQgpam+K5z5FtMxYWwxMdkuk1IWZQUbBsRZ2nUFhPDFFbq9wKBgQC5QxoCw6/DDyFKmDkVgtFFxkhevL8+n7hJFv76UfcPt1PVHIL0Sc5KQU4hg3e/0PDn/NSnPZS36V+/1wW3inn3GAE7PW/BKCIC2fcMpbHOsQIF8ehZztQsVtkEoCBaTQq2Nil1TDEwyHp7j0hdmugIy9fRgz5YeyzHMfSbrHa5swKBgFzQr4eqJW3nVZ1q9RFIwE+KtnUZ9ixJa7cJnHdKOg1Pv5BpJkb9/vyD7NvhmhYvL+JXuXWDILwKSvgOHqIczvmLqKmFNqTjON6GBss+IR/Pv3ROQqHUHpcRarjloM+MntksSKojKNS6LWaovT5Oxw4CpLhwaAATfpFMMftzFPepAoGBALS0jAmIQMe92VY+dufRizlI+ExYRR7bglDgumMGUjulMYNc5StNVoe9fW1ZJBQYxPMz/WUHvylI3Nlt7iiiTOdFJeZXvcslz08CtmRCttYKeBO+a0o2YWTCbbqCSixqm3kyCWxdnlmcI0SkdQzAzXXPBztYjhaWRw4hXxv9tGzbAoGAC8rBsxoc4trnRvpgAZxlPnADlgd9UNl2wK14VWbCWrSFiuHtSe/C0YRIkG/3Wl+MmYbQT3Gk2gQdV6f1uiESKrai4P7yrXi9OkLDAMjVgZbl3Y1ljD3sZqFtMN/8SHTM9xPzmACbFgUA3YNzi+Zc6PTnodO5fCIfSIEP98Nm1Yk=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAo2alzeZqQ0zCtyVAzdJOz/yMEbaiGP6YTX7lQ5q83oCCRCzwqispmDcbDUyf5K7uixem6Cho3k9Mmc+D624HPuLhxa+w0PLSCnczlz06gcNVHbvMMVD6lLKD9nN4YvSfAfkxxTWfTcTG6hNDYi6LUlSoKXm95x7blf9w0obx+MEgT+NF+kZinJcc872M2tWV0z2MLWUsizxrlsQG2cwYG42BrFWvusJYU3ohiPm/0YLggi6xnqL50sndSFwEt+ETHnxYSg6dihBv6LLvtxeRaNuYd9UaOwql0txFU2ErX4XwcDVhkIljJVNpey8hj6g0ZI7d8QBEy/SQKECVSmzJtQIDAQAB";


	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://192.168.108.201:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://192.168.108.201:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

