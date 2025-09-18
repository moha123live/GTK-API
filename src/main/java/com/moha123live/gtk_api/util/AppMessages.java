package com.moha123live.gtk_api.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE) // restricted to create new object
public class AppMessages {

    // Response string
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    public static final String WARNING = "warning";

    // --- Common Success Messages ---
    public static final String FETCH_SUCCESS = "Fetched successfully";
    public static final String SAVE_SUCCESS = "Saved successfully";
    public static final String UPDATE_SUCCESS = "Updated successfully";
    public static final String DELETE_SUCCESS = "Deleted successfully";

    // --- Common Error/Failure Messages ---
    public static final String FETCH_FAILED = "Failed to fetch data";
    public static final String SAVE_FAILED = "Failed to save data";
    public static final String UPDATE_FAILED = "Failed to update data";
    public static final String DELETE_FAILED = "Failed to delete data";

    // --- Validation / Generic Messages ---
    public static final String INVALID_REQUEST = "Invalid request";
    public static final String MISSING_FIELDS = "Required fields are missing";
    public static final String INVALID_INPUT = "Invalid input provided";
    public static final String OPERATION_FAILED = "Operation failed, please try again";
    public static final String UNAUTHORIZED_ACCESS = "Unauthorized access";
    public static final String FORBIDDEN = "You do not have permission to perform this action";
    public static final String NOT_FOUND = "Requested resource not found";
    public static final String INTERNAL_ERROR = "An unexpected error occurred, please contact support";
    public static final String SERVICE_UNAVAILABLE = "Service is temporarily unavailable";

    // --- Authentication / Authorization ---
    public static final String LOGIN_SUCCESS = "Login successful";
    public static final String LOGOUT_SUCCESS = "Logout successful";
    public static final String TOKEN_EXPIRED = "Session expired, please login again";

    // --- User Messages ---
    public static final String USER_REGISTER_SUCCESS = "User registered successfully";
    public static final String USER_LOGIN_SUCCESS = "User logged in successfully";
    public static final String USER_LOGOUT_SUCCESS = "User logged out successfully";
    public static final String USER_ALREADY_EXISTS = "User already exists";
    public static final String USER_NAME_ALREADY_EXISTS = "User name already exists";
    public static final String USER_EMAIL_ALREADY_EXISTS = "User email already exists";
    public static final String USER_NOT_FOUND = "User not found";
    public static final String USER_INCORRECT_PASSWORD = "Old password is incorrect";
    public static final String USER_CREATED = "User created successfully";
    public static final String USER_UPDATED = "User updated successfully";
    public static final String USER_DELETED = "User deleted successfully";
    public static final String USER_DETAILS_ADDED = "User details added successfully";
    public static final String USER_DETAILS_UPDATED = "User details updated successfully";
    public static final String USER_DETAILS_DELETED = "User details deleted successfully";
    public static final String USER_ENABLED = "User enabled successfully";
    public static final String USER_DISABLED = "User disabled successfully";
    public static final String USER_FETCHED = "Customer data fetched successfully";
    public static final String USERS_FETCHED = "Customers data fetched successfully";

    // --- Customer Messages ---
    public static final String CUSTOMER_CREATED = "Customer created successfully";
    public static final String CUSTOMER_ALL_CREATED = "All the customers are created successfully";
    public static final String CUSTOMER_UPDATED = "Customer updated successfully";
    public static final String CUSTOMER_DELETED = "Customer deleted successfully";
    public static final String CUSTOMER_ENABLED = "Customer enabled successfully";
    public static final String CUSTOMER_FETCHED = "Customer data fetched successfully";
    public static final String CUSTOMERS_FETCHED = "Customers data fetched successfully";
    public static final String CUSTOMER_DISABLED = "Customer disabled successfully";
    public static final String CUSTOMER_ALREADY_EXISTS = "Customer name already exists";
    public static final String CUSTOMER_NOT_FOUND = "Customer not found";
    public static final String CUSTOMER_ID_NOT_FOUND = "Customer not found";

    // --- Supplier Messages ---
    public static final String SUPPLIER_CREATED = "Supplier created successfully";
    public static final String SUPPLIER_ALL_CREATED = "All the suppliers are created successfully";
    public static final String SUPPLIER_UPDATED = "Supplier updated successfully";
    public static final String SUPPLIER_DELETED = "Supplier deleted successfully";
    public static final String SUPPLIER_ENABLED = "Supplier enabled successfully";
    public static final String SUPPLIER_FETCHED = "Supplier data fetched successfully";
    public static final String SUPPLIERS_FETCHED = "Suppliers data fetched successfully";
    public static final String SUPPLIER_DISABLED = "Supplier disabled successfully";
    public static final String SUPPLIER_ALREADY_EXISTS = "Supplier name already exists";
    public static final String SUPPLIER_NOT_FOUND = "Supplier not found";
    public static final String SUPPLIER_ID_NOT_FOUND = "Supplier id not found";

    // --- Product Messages ---
    public static final String PRODUCT_CREATED = "Product created successfully";
    public static final String PRODUCT_ALL_CREATED = "All the products are created successfully";
    public static final String PRODUCT_UPDATED = "Product updated successfully";
    public static final String PRODUCT_DELETED = "Product deleted successfully";
    public static final String PRODUCT_ENABLED = "Product enabled successfully";
    public static final String PRODUCT_FETCHED = "Product data fetched successfully";
    public static final String PRODUCTS_FETCHED = "Products data fetched successfully";
    public static final String PRODUCT_DISABLED = "Product disabled successfully";
    public static final String PRODUCT_ALREADY_EXISTS = "Product name already exists";
    public static final String PRODUCT_NOT_FOUND = "Product not found";
    public static final String PRODUCT_ID_NOT_FOUND = "Product id not found";

    // --- Billing Messages ---
    public static final String BILL_ADDED = "Bill saved successfully";
    public static final String BILL_UPDATED = "Bill updated successfully";
    public static final String BILL_DELETED = "Bill deleted successfully";
    public static final String BILL_NOT_FOUND = "Bill not found";

    // --- Purchase Validation Message ---
    public static final String PURCHASE_REQUIRED = "Purchase is required";
    public static final String PURCHASE_BILL_LENGTH = "Purchase bill number must not exceed 10 characters";
    public static final String PURCHASE_DATE_REQUIRED = "Date is required";
    public static final String PURCHASE_RATE_REQUIRED = "Purchase Rate is required";
    public static final String PURCHASE_RATE_LENGTH = "Purchase rate must be greater than 0";
    public static final String PURCHASE_QUANTITY_REQUIRED = "Purchase quantity is required";
    public static final String PURCHASE_ATLEAST_QUANITY = "Purchase quantity must be at least 1";
    public static final String PURCHASE_WEIGHT = "Purchase weight is required";
    public static final String PURCHASE_AMOUNT = "Purchase amount is required";

    // --- Sales Validation Message ---
    public static final String SALE_DATE_REQUIRED = "Date is required";;
    public static final String SALE_RATE_REQUIRED = "Sale Rate is required";;
    public static final String SALE_RATE_LENGTH = "Sale rate must be greater than 0";;
    public static final String SALE_BAG_RATE = "Sale bag rate must be greater than 0";;
    public static final String SALE_QUANTITY_REQUIRED = "Sale quantity is required";;
    public static final String SALE_WEIGHT = "Sale weight is required";;
    public static final String SALE_AMOUNT_REQUIRED = "Sale amount is required";
    public static final String SALE_AMOUNT_LENGTH = "Sale amount must be greater than 0";
    public static final String SALE_NETAMOUNT_REQUIRED = "Sale netamount is required";
    public static final String SALE_NETAMOUNT_LENGTH = "Sale netamount must be greater than 0";
    public static final String SALE_COMMISSION_NONNEGATIVE = "Commission cannot be negative";

    // --- Customer Validation Messages ---
    public static final String CUSTOMER_NAME_REQUIRED = "Customer name is mandatory";
    public static final String CUSTOMER_NAME_LENGTH = "Customer name must not exceed 100 characters";
    public static final String CUSTOMER_TAMIL_NAME_LENGTH = "Tamil name must not exceed 100 characters";
    public static final String CUSTOMER_ADDRESS_LENGTH = "Address must not exceed 255 characters";
    public static final String CUSTOMER_CITY_LENGTH = "City name must not exceed 100 characters";
    public static final String CUSTOMER_PHONE_PATTERN = "Phone number must consist of exactly 10 numeric digits";
    public static final String CUSTOMER_OLDBALANCE_GREATER_THAN_ZERO = "Old balance must be greater than or equal to 0.00";
    public static final String CUSTOMER_CURRBALANCE_GREATER_THAN_ZERO = "Current balance must be greater than or equal to 0.00";
    public static final String CUSTOMER_COMMISSION_GREATER_THAN_ZERO = "Commission value must be greater than or equal to 0.00";

    // --- Supplier Validation Messages ---
    public static final String SUPPLIER_NAME_REQUIRED = "Supplier name is mandatory";
    public static final String SUPPLIER_NAME_LENGTH = "Supplier name must not exceed 100 characters";
    public static final String SUPPLIER_ADDRESS_LENGTH = "Address must not exceed 255 characters";
    public static final String SUPPLIER_CITY_LENGTH = "City name must not exceed 100 characters";
    public static final String SUPPLIER_PHONE_PATTERN = "Phone number must consist of exactly 10 numeric digits";
    public static final String SUPPLIER_BALANCE_DUE_GREATER_THAN_ZERO = "Old balance must be greater than or equal to 0.00";

    // --- Product Validation Messages ---
    public static final String PRODUCT_NAME_REQUIRED = "Product name is mandatory";
    public static final String PRODUCT_NAME_LENGTH = "Product name must not exceed 100 characters";
    public static final String PRODUCT_TAMIL_NAME_LENGTH = "Product tamil name must not exceed 100 characters";
    public static final String PRODUCT_UNIT_REQUIRED = "Unit is required";
    public static final String PRODUCT_COMMISSION_GREATER_THAN_ZERO = "Commission value must be greater than or equal to 0.00";

    // --- User Validation Messages ---
    public static final String USER_USERNAME_REQUIRED = "Username is required";
    public static final String USER_USERNAME_LENGTH = "Username must be between 3 and 50 characters";
    public static final String USER_PASSWORD_REQUIRED = "Password is required";
    public static final String USER_OLDPASSWORD_REQUIRED = "Old password is required";
    public static final String USER_NEWPASSWORD_REQUIRED = "New password is required";
    public static final String USER_EMAIL_REQUIRED = "Email is required";
    public static final String USER_EMAIL_INVALID = "Please provide a valid email address";
    public static final String USER_EMAIL_LENGTH = "Email must not exceed 100 characters";

    // --- Bill Summary Validation Messages ---
    public static final String BillSUMMARY_REQUIRED = "Bill summary is required";
    public static final String BillSUMMARY_QUANTITY_REQUIRED = "Total quantity is required";
    public static final String BillSUMMARY_QUANTITY_GREATER_THAN_ZERO = "Total quantity must be greater than 0";
    public static final String BillSUMMARY_BAGWEIGHT_REQUIRED = "Total bag weight is required";
    public static final String BillSUMMARY_BAGWEIGHT_GREATER_THAN_ZERO = "Total bag weight must be greater than 0";
    public static final String BillSUMMARY_WEIGHT_REQUIRED = "Total weight is required";
    public static final String BillSUMMARY_WEIGHT_GREATER_THAN_ZERO = "Total weight must be greater than 0";
    public static final String BillSUMMARY_AMOUNT_REQUIRED = "Total amount is required";
    public static final String BillSUMMARY_AMOUNT_GREATER_THAN_ZERO = "Total amount must be greater than 0";
    public static final String BillSUMMARY_NETAMOUNT_REQUIRED = "Total net amount is required";
    public static final String BillSUMMARY_NETAMOUNT_GREATER_THAN_ZERO = "Total net amount must be greater than 0";

    // --- Bill Summary Validation Messages ---
    public static final String LEDGER_ENTITY_TYPE_REQUIRED = "Entity type is required";
    public static final String LEDGER_ENTITY_ID_REQUIRED = "Entity ID is required";
    public static final String LEDGER_REFERENCE_TYPE_REQUIRED = "Reference type is required";

    // public static final String

}
