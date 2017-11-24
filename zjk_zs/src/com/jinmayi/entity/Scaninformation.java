package com.jinmayi.entity;



/**
 * Scaninformation entity. @author MyEclipse Persistence Tools
 */

public class Scaninformation  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
     private String ip;
     private Long time;
     private String address;


    // Constructors

    /** default constructor */
    public Scaninformation() {
    }

    
    /** full constructor */
    public Scaninformation(String ip, Long time, String address) {
        this.ip = ip;
        this.time = time;
        this.address = address;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return this.ip;
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getTime() {
        return this.time;
    }
    
    public void setTime(Long time) {
        this.time = time;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
   








}