package com.atguigu.mybatis.bean;

public class Employee {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_employee.id
     *
     * @mbggenerated Thu Aug 06 21:44:54 CST 2020
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_employee.last_name
     *
     * @mbggenerated Thu Aug 06 21:44:54 CST 2020
     */
    private String lastName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_employee.gender
     *
     * @mbggenerated Thu Aug 06 21:44:54 CST 2020
     */
    private String gender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_employee.email
     *
     * @mbggenerated Thu Aug 06 21:44:54 CST 2020
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_employee.d_id
     *
     * @mbggenerated Thu Aug 06 21:44:54 CST 2020
     */
    private Integer dId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_employee.id
     *
     * @return the value of tbl_employee.id
     *
     * @mbggenerated Thu Aug 06 21:44:54 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_employee.id
     *
     * @param id the value for tbl_employee.id
     *
     * @mbggenerated Thu Aug 06 21:44:54 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_employee.last_name
     *
     * @return the value of tbl_employee.last_name
     *
     * @mbggenerated Thu Aug 06 21:44:54 CST 2020
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_employee.last_name
     *
     * @param lastName the value for tbl_employee.last_name
     *
     * @mbggenerated Thu Aug 06 21:44:54 CST 2020
     */
    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_employee.gender
     *
     * @return the value of tbl_employee.gender
     *
     * @mbggenerated Thu Aug 06 21:44:54 CST 2020
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_employee.gender
     *
     * @param gender the value for tbl_employee.gender
     *
     * @mbggenerated Thu Aug 06 21:44:54 CST 2020
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_employee.email
     *
     * @return the value of tbl_employee.email
     *
     * @mbggenerated Thu Aug 06 21:44:54 CST 2020
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_employee.email
     *
     * @param email the value for tbl_employee.email
     *
     * @mbggenerated Thu Aug 06 21:44:54 CST 2020
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_employee.d_id
     *
     * @return the value of tbl_employee.d_id
     *
     * @mbggenerated Thu Aug 06 21:44:54 CST 2020
     */
    public Integer getdId() {
        return dId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_employee.d_id
     *
     * @param dId the value for tbl_employee.d_id
     *
     * @mbggenerated Thu Aug 06 21:44:54 CST 2020
     */
    public void setdId(Integer dId) {
        this.dId = dId;
    }
}