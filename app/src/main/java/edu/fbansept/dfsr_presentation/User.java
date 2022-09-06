package edu.fbansept.dfsr_presentation;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String website;
    private String address;
    private String company;

//    public Product(Integer id, String name, String email) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//    }

    public User(JSONObject json) {

        try {
            this.id = json.getInt("id");
            this.name = "Nom : " +json.getString("name");
            this.email = "Email : " + json.getString("email");
            this.phone = "Téléphone : " + json.getString("phone");
            this.website = "Site web : " + json.getString("website");
            this.address = "Adresse : " + json.getJSONObject("address").getString("street") + ", " + json.getJSONObject("address").getString("zipcode") + " " + json.getJSONObject("address").getString("city");
            this.company = "Société : " + json.getJSONObject("company").getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
            this.id = 0;
            this.name = "";
            this.email = "";
            this.phone = "";
            this.website = "";
            this.address = "";
            this.company = "";
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
