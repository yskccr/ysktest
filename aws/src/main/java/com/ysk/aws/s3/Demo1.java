package com.ysk.aws.s3;


import java.util.Arrays;
import java.util.List;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.regions.ServiceAbbreviations;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

import lombok.extern.slf4j.Slf4j;

/**
 * Note：
 *
 * @author ysk42596
 * @description：
 * @date ：Created in 2021/10/28
 */
@Slf4j
public class Demo1 {

    public static final String AWS_ACCESSKEYID="AKIAREDY72BKZ4ZSNO5L";

    public static final String AWS_SECRETKEY="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";

    public static void main(String[] args) {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWS_ACCESSKEYID, AWS_SECRETKEY);
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withRegion(Regions.CN_NORTH_1)
                .build();
        List<Bucket> buckets =
                s3Client.listBuckets();
        log.info(Arrays.toString(buckets.toArray()));
    }

}