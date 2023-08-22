package com.driver;

public class CurrentAccount extends BankAccount{
    private String tradeLicenseId; //consists of Uppercase English characters only

    //--------------Constructor-----------------
    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
    }

    public CurrentAccount() {
    }

    //------------- Getter and Setter----------------


    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    //------------ Other Dunctions----------------

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        String licenseId=getTradeLicenseId();
        char[] licenseChars = licenseId.toCharArray();

        int n = licenseChars.length;
        boolean rearranged = false;

        for (int i = 1; i < n; i++) {
            if (licenseChars[i] == licenseChars[i - 1]) {
                rearranged = true;
                break;
            }
        }

        if (!rearranged) {
            return; // The license is already valid, no need to rearrange
        }

        // Rearrange characters to create a valid license
        for (int i = 1; i < n; i += 2) {
            if (i + 1 < n && licenseChars[i] == licenseChars[i + 1]) {
                // Swap characters at i and i+1 to break consecutive pattern
                char temp = licenseChars[i];
                licenseChars[i] = licenseChars[i - 1];
                licenseChars[i - 1] = temp;
            }
        }

        // Now the license is rearranged and valid
        String rearrangedLicense = new String(licenseChars);

        if (!isValidLicense(rearrangedLicense)) {
            throw new Exception("Valid License can not be generated");
        }

        setTradeLicenseId(rearrangedLicense);
    }
    private boolean isValidLicense(String licenseId) {
        char[] licenseChars = licenseId.toCharArray();

        for (int i = 1; i < licenseChars.length; i++) {
            if (licenseChars[i] == licenseChars[i - 1]) {
                return false;
            }
        }

        return true;
    }

}
