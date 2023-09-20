/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.rest.openapi.springboot;

import java.net.URI;
import org.apache.camel.component.rest.openapi.validator.RequestValidationCustomizer;
import org.apache.camel.spring.boot.ComponentConfigurationPropertiesCommon;
import org.apache.camel.support.jsse.SSLContextParameters;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configure REST producers based on an OpenAPI specification document
 * delegating to a component implementing the RestProducerFactory interface.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@ConfigurationProperties(prefix = "camel.component.rest-openapi")
public class RestOpenApiComponentConfiguration
        extends
            ComponentConfigurationPropertiesCommon {

    /**
     * Whether to enable auto configuration of the rest-openapi component. This
     * is enabled by default.
     */
    private Boolean enabled;
    /**
     * API basePath, for example /v2. Default is unset, if set overrides the
     * value present in OpenApi specification.
     */
    private String basePath;
    /**
     * Name of the Camel component that will perform the requests. The component
     * must be present in Camel registry and it must implement
     * RestProducerFactory service provider interface. If not set CLASSPATH is
     * searched for single component that implements RestProducerFactory SPI.
     * Can be overridden in endpoint configuration.
     */
    private String componentName;
    /**
     * What payload type this component capable of consuming. Could be one type,
     * like application/json or multiple types as application/json,
     * application/xml; q=0.5 according to the RFC7231. This equates to the
     * value of Accept HTTP header. If set overrides any value found in the
     * OpenApi specification. Can be overridden in endpoint configuration
     */
    private String consumes;
    /**
     * Scheme hostname and port to direct the HTTP requests to in the form of
     * https://hostname:port. Can be configured at the endpoint, component or in
     * the corresponding REST configuration in the Camel Context. If you give
     * this component a name (e.g. petstore) that REST configuration is
     * consulted first, rest-openapi next, and global configuration last. If set
     * overrides any value found in the OpenApi specification,
     * RestConfiguration. Can be overridden in endpoint configuration.
     */
    private String host;
    /**
     * Whether the producer should be started lazy (on the first message). By
     * starting lazy you can use this to allow CamelContext and routes to
     * startup in situations where a producer may otherwise fail during starting
     * and cause the route to fail being started. By deferring this startup to
     * be lazy then the startup failure can be handled during routing messages
     * via Camel's routing error handlers. Beware that when the first message is
     * processed then creating and starting the producer may take a little time
     * and prolong the total processing time of the processing.
     */
    private Boolean lazyStartProducer = false;
    /**
     * What payload type this component is producing. For example
     * application/json according to the RFC7231. This equates to the value of
     * Content-Type HTTP header. If set overrides any value present in the
     * OpenApi specification. Can be overridden in endpoint configuration.
     */
    private String produces;
    /**
     * If request validation is enabled, this option provides the capability to
     * customize the creation of OpenApiInteractionValidator used to validate
     * requests. The option is a
     * org.apache.camel.component.rest.openapi.validator.RequestValidationCustomizer type.
     */
    private RequestValidationCustomizer requestValidationCustomizer;
    /**
     * Enable validation of requests against the configured OpenAPI
     * specification
     */
    private Boolean requestValidationEnabled = false;
    /**
     * Path to the OpenApi specification file. The scheme, host base path are
     * taken from this specification, but these can be overridden with
     * properties on the component or endpoint level. If not given the component
     * tries to load openapi.json resource. Note that the host defined on the
     * component and endpoint of this Component should contain the scheme,
     * hostname and optionally the port in the URI syntax (i.e.
     * https://api.example.com:8080). Can be overridden in endpoint
     * configuration.
     */
    private URI specificationUri;
    /**
     * Whether autowiring is enabled. This is used for automatic autowiring
     * options (the option must be marked as autowired) by looking up in the
     * registry to find if there is a single instance of matching type, which
     * then gets configured on the component. This can be used for automatic
     * configuring JDBC data sources, JMS connection factories, AWS Clients,
     * etc.
     */
    private Boolean autowiredEnabled = true;
    /**
     * Customize TLS parameters used by the component. If not set defaults to
     * the TLS parameters set in the Camel context. The option is a
     * org.apache.camel.support.jsse.SSLContextParameters type.
     */
    private SSLContextParameters sslContextParameters;
    /**
     * Enable usage of global SSL context parameters.
     */
    private Boolean useGlobalSslContextParameters = false;

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getConsumes() {
        return consumes;
    }

    public void setConsumes(String consumes) {
        this.consumes = consumes;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Boolean getLazyStartProducer() {
        return lazyStartProducer;
    }

    public void setLazyStartProducer(Boolean lazyStartProducer) {
        this.lazyStartProducer = lazyStartProducer;
    }

    public String getProduces() {
        return produces;
    }

    public void setProduces(String produces) {
        this.produces = produces;
    }

    public RequestValidationCustomizer getRequestValidationCustomizer() {
        return requestValidationCustomizer;
    }

    public void setRequestValidationCustomizer(
            RequestValidationCustomizer requestValidationCustomizer) {
        this.requestValidationCustomizer = requestValidationCustomizer;
    }

    public Boolean getRequestValidationEnabled() {
        return requestValidationEnabled;
    }

    public void setRequestValidationEnabled(Boolean requestValidationEnabled) {
        this.requestValidationEnabled = requestValidationEnabled;
    }

    public URI getSpecificationUri() {
        return specificationUri;
    }

    public void setSpecificationUri(URI specificationUri) {
        this.specificationUri = specificationUri;
    }

    public Boolean getAutowiredEnabled() {
        return autowiredEnabled;
    }

    public void setAutowiredEnabled(Boolean autowiredEnabled) {
        this.autowiredEnabled = autowiredEnabled;
    }

    public SSLContextParameters getSslContextParameters() {
        return sslContextParameters;
    }

    public void setSslContextParameters(
            SSLContextParameters sslContextParameters) {
        this.sslContextParameters = sslContextParameters;
    }

    public Boolean getUseGlobalSslContextParameters() {
        return useGlobalSslContextParameters;
    }

    public void setUseGlobalSslContextParameters(
            Boolean useGlobalSslContextParameters) {
        this.useGlobalSslContextParameters = useGlobalSslContextParameters;
    }
}