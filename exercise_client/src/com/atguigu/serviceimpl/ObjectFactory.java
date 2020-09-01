
package com.atguigu.serviceimpl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.atguigu.serviceimpl package. 
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

    private final static QName _GetRegionByParentId_QNAME = new QName("http://serviceimpl.atguigu.com/", "getRegionByParentId");
    private final static QName _GetRegionByParentIdResponse_QNAME = new QName("http://serviceimpl.atguigu.com/", "getRegionByParentIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.atguigu.serviceimpl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetRegionByParentId }
     * 
     */
    public GetRegionByParentId createGetRegionByParentId() {
        return new GetRegionByParentId();
    }

    /**
     * Create an instance of {@link GetRegionByParentIdResponse }
     * 
     */
    public GetRegionByParentIdResponse createGetRegionByParentIdResponse() {
        return new GetRegionByParentIdResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRegionByParentId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceimpl.atguigu.com/", name = "getRegionByParentId")
    public JAXBElement<GetRegionByParentId> createGetRegionByParentId(GetRegionByParentId value) {
        return new JAXBElement<GetRegionByParentId>(_GetRegionByParentId_QNAME, GetRegionByParentId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRegionByParentIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviceimpl.atguigu.com/", name = "getRegionByParentIdResponse")
    public JAXBElement<GetRegionByParentIdResponse> createGetRegionByParentIdResponse(GetRegionByParentIdResponse value) {
        return new JAXBElement<GetRegionByParentIdResponse>(_GetRegionByParentIdResponse_QNAME, GetRegionByParentIdResponse.class, null, value);
    }

}
