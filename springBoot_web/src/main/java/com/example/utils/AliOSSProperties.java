package com.example.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName: AliOSSProperties
 * Description:
 *
 * @Author snuonuo
 * @Create 2023/11/14 15:28
 * @Version 1.0
 */

@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOSSProperties {
    private String endpoint;
    private String accessKeyId;

    private String accessKeySecret;

    private String bucketName;
}
