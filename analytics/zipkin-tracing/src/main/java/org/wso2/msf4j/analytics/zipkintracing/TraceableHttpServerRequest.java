/*
*  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*/

package org.wso2.msf4j.analytics.zipkintracing;

import com.github.kristofa.brave.http.HttpServerRequest;
import org.wso2.msf4j.Request;

import java.net.URI;

/**
 * Adaptor class for server side request object tracing
 */
public class TraceableHttpServerRequest implements HttpServerRequest {

    private final Request req;

    TraceableHttpServerRequest(Request req) {
        this.req = req;
    }

    @Override
    public String getHttpHeaderValue(String headerName) {
        return req.getHeader(headerName);
    }

    @Override
    public URI getUri() {
        return URI.create(req.getUri());
    }

    @Override
    public String getHttpMethod() {
        return req.getHttpMethod();
    }
}
