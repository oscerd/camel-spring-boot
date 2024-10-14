package org.apache.camel.component.aws.secretsmanager.springboot;

import org.apache.camel.spring.boot.CamelAutoConfiguration;
import org.apache.camel.test.infra.aws.common.services.AWSService;
import org.apache.camel.test.infra.aws2.clients.AWSSDKClientUtils;
import org.apache.camel.test.infra.aws2.services.AWSServiceFactory;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperties;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClientBuilder;
import software.amazon.awssdk.services.secretsmanager.model.CreateSecretRequest;
import org.assertj.core.api.Assertions;
import software.amazon.awssdk.services.secretsmanager.model.DeleteSecretRequest;

@CamelSpringBootTest
@DirtiesContext
@SpringBootApplication
@SpringBootTest(
        classes = { EarlyResolvedPropertiesTest.TestConfiguration.class },
        properties = {
                "camel.component.aws-secrets-manager.early-resolve-properties=true",
                "early.resolved.property.simple={{aws:testSecret/password}}"
        })

// Must be manually tested. Provide your own accessKey and secretKey using -Dcamel.vault.aws.accessKey, -Dcamel.vault.aws.secretKey and -Dcamel.vault.aws.region
@EnabledIfSystemProperties({
        @EnabledIfSystemProperty(named = "camel.vault.test.aws.accessKey", matches = ".*",
                disabledReason = "Access key not provided"),
        @EnabledIfSystemProperty(named = "camel.vault.test.aws.secretKey", matches = ".*",
                disabledReason = "Secret key not provided"),
        @EnabledIfSystemProperty(named = "camel.vault.test.aws.region", matches = ".*", disabledReason = "Region not provided"),
})
public class EarlyResolvedPropertiesTest {

    @BeforeAll
    public static void setup() {
        String accessKey = System.getProperty("camel.vault.test.aws.accessKey");
        String secretKey = System.getProperty("camel.vault.test.aws.secretKey");
        String region = System.getProperty("camel.vault.test.aws.region");
        System.setProperty("camel.vault.aws.accessKey", accessKey);
        System.setProperty("camel.vault.aws.secretKey", secretKey);
        System.setProperty("camel.vault.aws.region", region);

        /*SecretsManagerClientBuilder clientBuilder = SecretsManagerClient.builder();
        AwsBasicCredentials cred = AwsBasicCredentials.create(accessKey, secretKey);
        clientBuilder = clientBuilder.credentialsProvider(StaticCredentialsProvider.create(cred));
        clientBuilder.region(Region.of(region));
        SecretsManagerClient client = clientBuilder.build();
        CreateSecretRequest req = CreateSecretRequest.builder().name("testSecretSuper/password").secretString("string").build();
        client.createSecret(req);*/
    }

    @AfterAll
    public static void teardown() {
        String accessKey = System.getProperty("camel.vault.test.aws.accessKey");
        String secretKey = System.getProperty("camel.vault.test.aws.secretKey");
        String region = System.getProperty("camel.vault.test.aws.region");

        /*SecretsManagerClientBuilder clientBuilder = SecretsManagerClient.builder();
        AwsBasicCredentials cred = AwsBasicCredentials.create(accessKey, secretKey);
        clientBuilder = clientBuilder.credentialsProvider(StaticCredentialsProvider.create(cred));
        clientBuilder.region(Region.of(region));
        SecretsManagerClient client = clientBuilder.build();
        DeleteSecretRequest req = DeleteSecretRequest.builder().secretId("testSecret/password").forceDeleteWithoutRecovery(true).build();
        client.deleteSecret(req);*/
    }

    @Value("${early.resolved.property}")
    private String earlyResolvedProperty;

    @Value("${early.resolved.property.simple}")
    private String earlyResolvedPropertySimple;

    @Test
    public void testEarlyResolvedProperties() {
        //Assertions.assertThat(earlyResolvedProperty).isEqualTo("string");
        Assertions.assertThat(earlyResolvedPropertySimple).isEqualTo("string");
    }

    @Configuration
    @AutoConfigureBefore(CamelAutoConfiguration.class)
    public static class TestConfiguration {
    }
}
