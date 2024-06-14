package com.sy.gsp;

import cn.hutool.json.JSONUtil;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:peiliang
 * @Description:
 * @Date: 2023/12/19 16:27
 * @Modified By:
 * @Version: 1.0
 */
public class GspTest {

    public static void main(String[] args) throws IOException {
        String bucketName = "peiliang-test";
        String key1 = "110108000011900000010220201104732550004801";

        //String bucketName2 = "peiliang-test/a";
        //创建client
        AmazonS3 s3client = getClient();

        //创建bucket
//        createBucket(s3client,bucketName);

        //delete bucket
//        deleteBucket(s3client,bucketName);

        //设置bucket的规则
//        setBucketConfig(s3client,bucketName);


        //上传文件
        uploadFile(s3client,bucketName,key1);


        // 下载文件
//        downloadFile(s3client, bucketName, key1);

        //删除文件
//        deleteObject(s3client,bucketName,key1);

        //list objects
//        listObjects(s3client,bucketName);

        //get object url
//        getUrl(s3client, bucketName, key1);

    }

    /**
     * 获取s3 client
     *
     * @return
     */
    public static AmazonS3 getClient() {
        String endpoint = "http://10.231.103.215:23471";
        String accessKey = "LeBnhmXCSrYemEjv";
        String secretKey = "CGHdmxXRjIvjaUsZ";
        ClientConfiguration config = new ClientConfiguration();
        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.
                EndpointConfiguration(endpoint, "");
        AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        AWSCredentialsProvider awsCredentialsProvider = new AWSStaticCredentialsProvider(awsCredentials);

        AmazonS3 s3client = AmazonS3Client.builder()
                .withEndpointConfiguration(endpointConfiguration)
                .withClientConfiguration(config)
                .withCredentials(awsCredentialsProvider)
                .disableChunkedEncoding()
                .withPathStyleAccessEnabled(true)
                .build();
        return s3client;
    }

    /**
     * 创建bucketName
     *
     * @param s3client
     * @param bucketName
     */
    public static void createBucket(AmazonS3 s3client, String bucketName) {
        if (!s3client.doesBucketExistV2(bucketName)) {
            s3client.createBucket(bucketName);
        } else {
            System.out.println("bucketName:" + bucketName + "，已经存在");
        }
    }

    /**
     * 给bucket 设置规则
     *
     * @param s3client
     */
    public static void setBucketConfig(AmazonS3 s3client, String bucketName) {
        BucketLifecycleConfiguration bucketLifecycleConfiguration = new BucketLifecycleConfiguration();
        List<BucketLifecycleConfiguration.Rule> rules = new ArrayList<>();

        /**
         * 这里设置TTL时，如果gsp跟core一起部署的，这里设置的时间是秒的意思
         * 在gsp_ms3 服务中，有一个参数 s3f.ttlWeight=1  表示单位是秒，如果这里设置成ttlWeight=86400 这个days 就是1天后过期
         * 如果是直接连第三方的云存储（支持S3协议）的话就不用做转换了
         */
        BucketLifecycleConfiguration.Rule rule = new BucketLifecycleConfiguration.Rule();
        rule.setExpirationInDays(30);
        rule.setStatus(BucketLifecycleConfiguration.ENABLED);

        rules.add(rule);

        bucketLifecycleConfiguration.setRules(rules);

        s3client.setBucketLifecycleConfiguration(bucketName, bucketLifecycleConfiguration);
    }

    /**
     * 删除bucket
     *
     * @param s3client
     * @param bucketName
     */
    public static void deleteBucket(AmazonS3 s3client, String bucketName) {
        s3client.deleteBucket(bucketName);
    }

    public static void createFolder(AmazonS3 s3client, String bucketName, String path) {
        // 这个版本gps暂时不能创建folder
    }

    /**
     * 遍历指定bucket 下面的objects
     *
     * @param s3client
     * @param bucketName
     */
    public static void listObjects(AmazonS3 s3client, String bucketName) {
        ListObjectsV2Result lists = s3client.listObjectsV2(bucketName);
        lists.getCommonPrefixes().stream().forEach(c -> {
            System.out.println(c);
        });

        System.out.println("###############");
        lists.getObjectSummaries().stream().forEach(c -> {
            System.out.println("key:" + c.getKey());
        });
    }

    /**
     * 上传文件
     *
     * @param s3client
     * @param bucketName
     * @param key
     */
    public static void uploadFile(AmazonS3 s3client, String bucketName, String key) {
        File file = new File("C:\\Users\\peiliang\\Desktop\\pic\\photo.jpeg");
        PutObjectResult por = s3client.putObject(new PutObjectRequest("/" + bucketName, key, file));
        System.out.println(JSONUtil.parse(por).toString());
    }

    public static void downloadFile(AmazonS3 s3client, String bucketName, String key) throws IOException {
        S3Object so1 = s3client.getObject(new GetObjectRequest("/" + bucketName, key));
        S3ObjectInputStream sis = so1.getObjectContent();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("C:\\Users\\peiliang\\Desktop\\pic\\photo2.jpeg");
            byte[] buffer = new byte[1024];
            int bufferread = 0;
            while ((bufferread = sis.read(buffer)) != -1) {
                fos.write(buffer, 0, bufferread);
            }
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) fos.close();
        }
    }

    public static void getUrl(AmazonS3 s3client, String bucketName, String key) {
        System.out.println(JSONUtil.parse(s3client.getUrl(bucketName, key)).toString());
        //能直接访问的路径，比喻上传的图片，可以直接在浏览器上面查看
        //http://10.117.58.78:23471/peiliang-test/110108000011900000010220201104732550004801

        // 如果想要直接在浏览器能下载的，需要后端代理一下，将流写到前端，类似这样的,由core 进行一层代理
        //http://10.117.58.78/core/v5/resources/data?uri=http%3A%2F%2F10.172.198.180%3A20018%2Fvehicle%2Fvehicle0006.jpeg&contentType=image/jpeg&downloadFilename=20231220163152000-FULL-%E6%96%B0%E5%8E%BF%E4%B8%AD%E5%AE%BF%E8%88%8D%E5%85%A8%E5%B1%80%E8%A5%BF%E5%90%91%E4%B8%9C.jpeg

    }

    /**
     * 删除文件
     *
     * @param s3client
     * @param bucketName
     * @param key
     */
    public static void deleteObject(AmazonS3 s3client, String bucketName, String key) {
        s3client.deleteObject(bucketName, key);
    }
}
