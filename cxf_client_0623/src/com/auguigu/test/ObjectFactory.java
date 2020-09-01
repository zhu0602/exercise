
package com.auguigu.test;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.auguigu.test package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetCity_QNAME = new QName("http://test.auguigu.com/", "getCity");
    private final static QName _GetCityResponse_QNAME = new QName("http://test.auguigu.com/", "getCityResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.auguigu.test
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCityResponse }
     * 
     */
    public GetCityResponse createGetCityResponse() {
        return new GetCityResponse();
    }

    /**
     * Create an instance of {@link GetCity }
     * 
     */
    public GetCity createGetCity() {
        return new GetCity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test.auguigu.com/", name = "getCity")
    public JAXBElement<GetCity> createGetCity(GetCity value) {
        return new JAXBElement<GetCity>(_GetCity_QNAME, GetCity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test.auguigu.com/", name = "getCityResponse")
    public JAXBElement<GetCityResponse> createGetCityResponse(GetCityResponse value) {
        return new JAXBElement<GetCityResponse>(_GetCityResponse_QNAME, GetCityResponse.class, null, value);
    }

}
