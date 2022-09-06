package jstl.product;

import helper.DataHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Product {
    private String code;
    private String name;
    private double price;
    private String des;

    private Date date;

    private DataHelper dataHelper;

    public List<String> errors;

    public Product(String code, String name, double price, String des) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.des = des;
        this.date = new Date();

        this.errors = new ArrayList<String>();
        this.dataHelper = new DataHelper();
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.des;
    }

    public String getDateTime() {
        return this.date.toString();
    }

    public boolean validate() {
        this.isCode();
        this.isName();
        this.isPrice();
        this.isDescription();

        return this.errors.size() == 0;
    }

    private boolean isCode() {
        String charPath = this.getCode().substring(0,2);
        String regexPatternChar = "^[A-Z]+$";
        String numPath = this.getCode().substring(2);
        String regexPatternNum = "^\\d{1,4}$";
        boolean res =
                this.dataHelper.regexValidate(charPath, regexPatternChar) &&
                        this.dataHelper.regexValidate(numPath, regexPatternNum);

        if (!res)
            this.errors.add("Code not valid! Please try again.");

        return res;
    }

    private boolean isName() {
        String regexPattern = "^[A-Za-z0-9\\s]{1,225}$";
        boolean res = this.dataHelper.regexValidate(this.getName(), regexPattern);

        if (!res)
            this.errors.add("Product name not valid! Please try again.");

        return res;
    }

    private boolean isPrice() {
        String regexPattern = "[0-9]{1,13}(\\.[0-9]*)?";
        boolean res = this.dataHelper.regexValidate(Double.toString(this.getPrice()), regexPattern);

        if (!res)
            this.errors.add("Product price not valid! Please try again.");

        return res;
    }

    private boolean isDescription() {
        String regexPattern = "^\\w{1,225}$";
        boolean res = this.dataHelper.regexValidate(this.getDescription(), regexPattern);

        if (!res)
            this.errors.add("Product description is not valid! Please try again.");

        return res;
    }

}
