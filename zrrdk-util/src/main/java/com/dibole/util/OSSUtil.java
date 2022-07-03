package com.dibole.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Tao
 * @version 1.0.0
 * @className OSSUtil.java
 * @description TODO
 * @createTime 2020年12月08日 18:15:00
 */
@Component
@Slf4j
public class OSSUtil {

    @Value("${aliYun.accessKeyId}")
    private String accessKeyId;

    @Value("${aliYun.secret}")
    private String accessKeySecret;

    @Value("${aliYun.bucketName}")
    private  String bucketName;

    @Value("${aliYun.endpoint}")
    private String endpoint;


    /**
     * 获取阿里云OSS客户端对象
     */
    public OSSClient getOSSClient() {
        return new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    /**
     * 新建Bucket  --Bucket权限:私有
     *
     * @param bucketName bucket名称
     * @return true 新建Bucket成功
     */
    public static final boolean createBucket(OSSClient client, String bucketName) {
        Bucket bucket = client.createBucket(bucketName);
        return bucketName.equals(bucket.getName());
    }

    /**
     * 删除Bucket
     * 返回错误：需查看OSS的错误码列表
     *
     * @param bucketName bucket名称
     */
    public static final void deleteBucket(OSSClient client, String bucketName) {
        client.deleteBucket(bucketName);
    }

    /**
     * 向阿里云的OSS存储中存储文件  --file也可以用InputStream替代
     *
     * @param client     OSS客户端
     * @param file       上传文件
     * @param bucketName bucket名称
     * @param diskName   上传文件的目录  --bucket下文件的路径
     * @return String 唯一MD5数字签名
     */
    public static final String uploadFiles(OSSClient client, File file, String bucketName, String diskName) {
        String resultStr = null;
        try {
            InputStream is = new FileInputStream(file);
            String fileName = file.getName();
            Long fileSize = file.length();
            //创建上传Object的Metadata
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(is.available());  //设置上传大小：必须设置
            metadata.setCacheControl("no-cache");                // 被下载时网页的缓存行为
            metadata.setHeader("Pragma", "no-cache");
            metadata.setContentEncoding("utf-8");
            metadata.setContentType(getContentType(fileName));  // 设置上传内容类型
            metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");
            //上传文件
            PutObjectResult putResult = client.putObject(bucketName, diskName + fileName, is, metadata);
            //解析结果
            resultStr = putResult.getETag();
        } catch (Exception e) {
            log.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
        }
        return resultStr;
    }

    public static final String uploadFiles(OSSClient client, InputStream in, String bucketName, String diskName,String fileName) {

        String objectUrl = "";

        try {
            //创建上传Object的Metadata
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(in.available());  //设置上传大小：必须设置
            metadata.setCacheControl("no-cache");  				// 被下载时网页的缓存行为
            metadata.setHeader("Pragma", "no-cache");
            metadata.setContentEncoding("utf-8");
            metadata.setContentType(getContentType(fileName));  // 设置上传内容类型
            metadata.setContentDisposition("filename=" + fileName);
            //上传文件
            PutObjectResult putResult = client.putObject(bucketName, diskName + fileName, in, metadata);

            objectUrl = putResult.getETag();

        } catch (Exception e) {
            log.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
            return "400";
        }

        return objectUrl;
    }

    /**
     * 根据key获取OSS服务器上的文件输入流
     *
     * @param client     OSS客户端
     * @param bucketName bucket名称
     * @param diskName   文件路径
     * @param key        Bucket下的文件的路径名+文件名
     */
    public static final InputStream getOSS2InputStream(OSSClient client, String bucketName, String diskName, String key) {
        OSSObject ossObj = client.getObject(bucketName, diskName + key);
        return ossObj.getObjectContent();
    }

    /**
     * 根据key删除OSS服务器上的文件
     *
     * @param client     OSS客户端
     * @param bucketName bucket名称
     * @param diskName   文件路径
     * @param key        Bucket下的文件的路径名+文件名
     */
    public static void deleteFile(OSSClient client, String bucketName, String diskName, String key) {
        client.deleteObject(bucketName, diskName + key);
        log.info("删除" + bucketName + "下的文件" + diskName + key + "成功");
    }

    /**
     * 根据bucketName获取所有文件包括文件目录
     *
     * @param client
     * @param bucketName
     */
    public static void getBucketFiles(OSSClient client, String bucketName) {
        // 构造ListObjectsRequest请求
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest(bucketName);
        // List Objects
        ObjectListing listing = client.listObjects(listObjectsRequest);
        // 遍历所有Object
        for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
            //TODO
            System.out.println(objectSummary.getKey());
        }
    }

    /**
     * 通过文件名判断并获取OSS服务文件上传时文件的contentType
     *
     * @param fileName 文件名
     * @return 文件的contentType
     */
    public static final String getContentType(String fileName) {
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        String strSub = fileExtension.substring(1, fileExtension.length());
        if ("bmp".equalsIgnoreCase(strSub)) return "image/bmp";
        if ("gif".equalsIgnoreCase(strSub)) return "image/gif";
        if ("jpeg".equalsIgnoreCase(strSub) || "jpg".equalsIgnoreCase(strSub) || "png".equalsIgnoreCase(strSub))
            return "image/jpeg";
        if ("html".equalsIgnoreCase(strSub)) return "text/html";
        if ("txt".equalsIgnoreCase(strSub)) return "text/plain";
        if ("vsd".equalsIgnoreCase(strSub)) return "application/vnd.visio";
        if ("ppt".equalsIgnoreCase(strSub) || "pptx".equalsIgnoreCase(strSub)) return "application/vnd.ms-powerpoint";
        if ("doc".equalsIgnoreCase(strSub) || "docx".equalsIgnoreCase(strSub)) return "application/msword";
        if ("xml".equalsIgnoreCase(strSub)) return "text/xml";
        return "text/html";
    }

    /**
     * 生成oss保存文件名称
     *
     * @param folder 文件目录 比如 "images/user/weixin/"
     * @param suffix 文件后缀
     * @return
     */
    public String genarateKeyForOss(String folder, String suffix) {
        String fileName = RandomUtil.randomLengthNum(20);
        return folder + fileName + suffix;
    }

    /**
     * 具体上传图片的实现
     *
     * @param key         包括了文件夹+文件名
     * @param inputStream 文件流
     * @return 应该就是返回key值
     */
    public String uploadFile(OSSClient ossClient, String bucketName, String key, InputStream inputStream) {
        PutObjectResult putObjectResult = ossClient.putObject(bucketName, key, inputStream);
        return putObjectResult.getETag();
    }

    /**
     * 根据地址获得数据的字节流
     *
     * @param strUrl 网络连接地址
     * @return
     */
    public InputStream getImageFromNetByUrl(String strUrl) throws Exception {
        URL url = new URL(strUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5 * 1000);
        return conn.getInputStream();//通过输入流获取图片数据
    }
}
