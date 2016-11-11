package com.liutf.mvc.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.Security;

public class EncryptUtil {
	private static String Algorithm = "DES"; // 定义 加密算法,可用 DES,DESede,Blowfish
	private static String mykey = "EF6167D986E3B529";// 私钥 EF6167D986E3B529
														// D90F4ABE1C63F233

	static {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
	}

	// 生成密钥, 注意此步骤时间比较长
	@SuppressWarnings("unused")
	private static byte[] getKey() throws Exception {
		KeyGenerator keygen = KeyGenerator.getInstance(Algorithm);
		SecretKey deskey = keygen.generateKey();
		return deskey.getEncoded();
	}

	// 加密
	public static String encode(String password) throws Exception {
		byte[] key = hex2byte(mykey);
		SecretKey deskey = new javax.crypto.spec.SecretKeySpec(key, Algorithm);
		Cipher c1 = Cipher.getInstance(Algorithm);
		c1.init(Cipher.ENCRYPT_MODE, deskey);
		byte[] cipherByte = c1.doFinal(password.getBytes());
		return byte2hex(cipherByte);
	}

	// 解密
	public static String decode(String password) throws Exception {
		byte[] key = hex2byte(mykey);
		SecretKey deskey = new javax.crypto.spec.SecretKeySpec(key, Algorithm);
		Cipher c1 = Cipher.getInstance(Algorithm);
		c1.init(Cipher.DECRYPT_MODE, deskey);
		byte[] clearByte = c1.doFinal(hex2byte(password.toUpperCase()));
		return new String(clearByte);
	}

	// 字节码转换成16进制字符串
	private static String byte2hex(byte bytes[]) {
		StringBuffer retString = new StringBuffer();
		for (int i = 0; i < bytes.length; ++i) {
			retString.append(Integer.toHexString(0x0100 + (bytes[i] & 0x00FF))
					.substring(1).toUpperCase());
		}
		return retString.toString();
	}

	// 将16进制字符串转换成字节码
	private static byte[] hex2byte(String hex) {
		byte[] bts = new byte[hex.length() / 2];
		for (int i = 0; i < bts.length; i++) {
			bts[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2),
					16);
		}
		return bts;
	}

	public static void main(String[] args) {
		String action = "";
		String input = null;

		try {
			System.out.println("-= 科研项目数据库密码加密/解密程序 =- ");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in), 1);
			while (action.equals("")) {
				System.out.print("请选择：[0]加密 [1]解密：");
				input = br.readLine();
				if (input.trim().equals("0")) {
					action = "0";
				} else if (input.trim().equals("1")) {
					action = "1";
				}
			}

			if (action.equals("0")) {
				System.out.print("请选择输入要加密的密码：");
			} else {
				System.out.print("请选择输入加密后的密码：");
			}

			input = br.readLine();
			String password = input.trim();

			// byte[] key = hex2byte(mykey);
			if (action.equals("0")) {
				String afterEncode = encode(password);
				System.out.println("加密后的字符串为：" + afterEncode);
			} else {
				String afterDecode = decode(password);
				System.out.println("解密后的密码为：" + afterDecode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
