package com.example.exercise2.demo_exercise2.infra;

import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

public class UrlBuilder {

  public static String get(Protocol protocol, String domain, String endpoint) {
    return UriComponentsBuilder.newInstance().scheme(protocol.getProtocal())
        .host(domain).path(endpoint).toUriString();
  }

  // sample: http://example.com/segment1/segment2/endpoint
  public static String get(Protocol protocol, String domain, String endpoint,
      String... pathSegments) {
    return UriComponentsBuilder.newInstance().scheme(protocol.getProtocal())
        .host(domain).pathSegment(pathSegments).toUriString();
  }

  // sample: https://example.com/segment1/segment2/endpoint?param=value
  public static String get(Protocol protocol, String domain, String endpoint,
      String queryParam, String queryValue, String... pathSegments) {
    return UriComponentsBuilder.newInstance().scheme(protocol.getProtocal())
        .host(domain).pathSegment(pathSegments)
        .queryParam(queryParam, queryValue).toUriString();
  }

  // sample: http://example.com/segment1/segment2/endpoint?param1=value1&param2=value2
  public static String get(Protocol protocol, String domain, String endpoint,
      MultiValueMap<String, String> params, String... pathSegments) {
    return UriComponentsBuilder.newInstance().scheme(protocol.getProtocal())
        .host(domain).pathSegment(pathSegments).queryParams(params)
        .toUriString();
  }
}
