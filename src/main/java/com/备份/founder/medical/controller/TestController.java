/**
 * Copyright (C) 2014 	北京方正阿帕比技术有限公司	开发一部
 * 
 * 后台管理
 * 
 * 2014年12月1日
 * 
 * liutf 
 */
package com.founder.medical.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.founder.medical.utils.MD5Util;
import com.founder.medical.utils.ToJson;

/**
 * @author liutf
 * 
 */
@RequestMapping("/test")
public class TestController {
	public Logger log = Logger.getLogger(TestController.class);

	@RequestMapping(value = "/importXml.html")
	@ResponseBody
	public ToJson importXml(
			@RequestParam(value = "xmlFile", required = false) MultipartFile file) {

		ToJson json = new ToJson();
		try {
			if (file != null) {
				String fileName = file.getOriginalFilename();
				System.out.println("文件名称-->" + fileName);

				String id = ("id_" + fileName).replace(".xml", "");

				json.setRtCode("0");
				json.setRtMsg("成功");
				json.setRtData(id);
			} else {
				json.setRtCode("0");
				json.setRtMsg("file为空");
			}
		} catch (Exception ex) {
			System.out.println("后台管理，用户导入操作后台出错!");
			ex.printStackTrace();
			json.setRtCode("99");
			json.setRtMsg("导入失败，请检查表格格式是否正确!");
		}
		return json;
	}

	@RequestMapping(value = "/importFiles.html")
	@ResponseBody
	public ToJson importFiles(
			@RequestParam(value = "xmlFile", required = false) MultipartFile fileXml,
			@RequestParam(value = "cebxFile", required = false) MultipartFile fileCebx,
			@RequestParam(value = "jpgFile", required = false) MultipartFile fileJpg) {

		ToJson json = new ToJson();
		try {
			if (fileXml != null) {
				System.out.println(fileXml.getName());
			}
			if (fileCebx != null) {
				System.out.println(fileCebx.getName());
			}
			if (fileJpg != null) {
				System.out.println(fileJpg.getName());
			}

			json.setRtCode("0");
			json.setRtMsg("批量上传成功!");
		} catch (Exception ex) {
			System.out.println("后台管理，用户导入操作后台出错!");
			ex.printStackTrace();
			json.setRtCode("99");
			json.setRtMsg("导入失败，请检查表格格式是否正确!");
		}
		return json;
	}

	@RequestMapping(value = "/notifyInfo.html")
	@ResponseBody
	public ToJson notifyInfo(String id, String result) {

		ToJson json = new ToJson();
		try {
			System.out.println("id-->" + id + "==result-->" + result);
			json.setRtCode("0");
			json.setRtMsg("成功!");
		} catch (Exception ex) {
			ex.printStackTrace();
			json.setRtCode("99");
			json.setRtMsg("导入失败，请检查表格格式是否正确!");
		}
		return json;
	}

	@RequestMapping(value = "/getSecretKey.html")
	@ResponseBody
	public ToJson getSecretKey(String id) {

		ToJson json = new ToJson();
		try {
			System.out.println("id-->" + id);
			json.setRtCode("0");
			json.setRtMsg("获取秘钥成功!");
			json.setRtData(MD5Util.md5(id));
		} catch (Exception ex) {
			System.out.println("后台管理，用户导入操作后台出错!");
			ex.printStackTrace();
			json.setRtCode("99");
			json.setRtMsg("导入失败，请检查表格格式是否正确!");
		}
		return json;
	}

}
