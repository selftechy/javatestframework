package nl.prowareness.automation.selenium.objectparser;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import nl.prowareness.automation.selenium.utilities.FindBy;



/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "page"
})
@XmlRootElement(name = "objectRepository")
public class ObjectRepository {

    protected List<ObjectRepository.Page> page;

    /**
     * Gets the value of the page property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the page property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObjectRepository.Page }
     * 
     * 
     */
    public List<ObjectRepository.Page> getPage() {
        if (page == null) {
            page = new ArrayList<ObjectRepository.Page>();
        }
        return this.page;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "field"
    })
    static class Page {

        protected List<ObjectRepository.Field> field;
        @XmlAttribute(name = "name")
        protected String name;

        /**
         * Gets the value of the field property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the field property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getField().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ObjectRepository.Page.Field }
         * 
         * 
         */
        public List<ObjectRepository.Field> getField() {
            if (field == null) {
                field = new ArrayList<ObjectRepository.Field>();
            }
            return this.field;
        }

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }




    }
    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="findByValue" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="findBy" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    public static class Field {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "name")
        protected String name;
        @XmlAttribute(name = "findByValue")
        protected String findByValue;
        @XmlAttribute(name = "findBy")
        protected String findBy;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the findByValue property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFindByValue() {
            return findByValue;
        }

        /**
         * Sets the value of the findByValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        void setFindByValue(String value) {
            this.findByValue = value;
        }

        /**
         * Gets the value of the findBy property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         *
        public String getFindBy() {
            return findBy;
        }
         */

        public FindBy getFindBy() {

            return FindBy.valueOf(findBy.toUpperCase());



        }
        /**
         * Sets the value of the findBy property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFindBy(String value) {
            this.findBy = value;
        }



    }

}
