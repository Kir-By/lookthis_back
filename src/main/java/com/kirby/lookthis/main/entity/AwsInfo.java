package com.kirby.lookthis.main.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;


@DynamicUpdate
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class AwsInfo {
        @Id
        @Column(name = "aws_info_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer awsInfoId;

        @Column(name = "iam_access_key")
        private String iamAccessKey;

        @Column(name = "iam_secret_key")
        private String iamSecretKey;

        @Column(name = "region")
        private String region;
}
