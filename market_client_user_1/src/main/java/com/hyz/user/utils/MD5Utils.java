package com.hyz.user.utils;

import java.security.MessageDigest;

public class MD5Utils {

    /**
     * MD5加密字符串
     *
     * @param str
     * @return
     * @throws Exception
     */
    public static String encryptString(String str) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] md5 = digest.digest(str.getBytes("UTF-8"));
        StringBuffer md5StringBuffer = new StringBuffer();
        String part = null;
        for (int i = 0; i < md5.length; i++) {
            part = Integer.toHexString(md5[i] & 0xFF);
            if (part.length() == 1) {
                part = "0" + part;
            }
            md5StringBuffer.append(part);
        }
        return md5StringBuffer.toString().toLowerCase();
    }

    public static String encryptString16(String str) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(str.getBytes("UTF-8"));
        return getEncode16(digest);

//		StringBuffer md5StringBuffer = new StringBuffer();
//		String part = null;
//		for (int i = 0; i < md5.length; i++) {
//			part = Integer.toHexString(md5[i] & 0xFF);
//			if (part.length() == 1) {
//				part = "0" + part;
//			}
//			md5StringBuffer.append(part);
//		}
//		return md5StringBuffer.toString().toLowerCase();
    }

    /**
     *
     * 32位加密
     *
     * @param digest
     *
     * @return
     */

    private static String getEncode32(MessageDigest digest) {
        StringBuilder builder = new StringBuilder();
        for (byte b : digest.digest()) {
            builder.append(Integer.toHexString((b >> 4) & 0xf));
            builder.append(Integer.toHexString(b & 0xf));
        }
        // return builder.toString().toLowerCase(); // 小写
        // return builder.toString().toUpperCase(); // 大写
        // java.lang.String.toUpperCase(Locale locale)
        // 方法将在此字符串中的所有字符为大写的规则给定的Locale.
        // return builder.toString().toUpperCase(Locale.getDefault()); // 大写
        return builder.toString();
    }

    /**
     *
     * 16位加密
     *
     * @param digest
     *
     * @return
     */

    private static String getEncode16(MessageDigest digest) {
        StringBuilder builder = new StringBuilder();
        for (byte b : digest.digest()) {
            builder.append(Integer.toHexString((b >> 4) & 0xf));
            builder.append(Integer.toHexString(b & 0xf));
        }

        // 16位加密，从第9位到25位
        return builder.substring(8, 24).toString();
    }

}
