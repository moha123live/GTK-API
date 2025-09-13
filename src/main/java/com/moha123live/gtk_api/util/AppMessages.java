package com.moha123live.gtk_api.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE) // restricted to create new object
public class AppMessages {

    //Response string
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
    public static final String USER_NOT_FOUND = "User not found";
    public static final String USER_CREATED = "User created successfully";
    public static final String USER_UPDATED = "User updated successfully";
    public static final String USER_DELETED = "User deleted successfully";
    public static final String USER_DETAILS_ADDED = "User details added successfully";
    public static final String USER_DETAILS_UPDATED = "User details updated successfully";
    public static final String USER_DETAILS_DELETED = "User details deleted successfully";
    public static final String USER_ENABLED = "User enabled successfully";
    public static final String USER_DISABLED = "User disabled successfully";

    // --- Product Messages ---
    public static final String PRODUCT_SAVED = "Product saved successfully";
    public static final String PRODUCT_UPDATED = "Product updated successfully";
    public static final String PRODUCT_DELETED = "Product deleted successfully";
    public static final String PRODUCT_FETCHED = "Product fetched successfully";
    public static final String PRODUCT_NOT_FOUND = "Product not found";
    public static final String PRODUCT_OUT_OF_STOCK = "Product is out of stock";
    public static final String PRODUCT_ALREADY_EXISTS = "Product already exists";

    // --- Billing Messages ---
    public static final String BILLING_ADDED = "Billing saved successfully";
    public static final String BILLING_UPDATED = "Billing updated successfully";
    public static final String BILLING_DELETED = "Billing deleted successfully";
    public static final String BILLING_NOT_FOUND = "Billing not found";

    // --- Validation Messages ---
    public static final String CUSTOMER_NAME_REQUIRED = "Customer name is required";
    public static final String CUSTOMER_NAME_LENGTH = "Name must not exceed 100 character";
    public static final String CUSTOMER_TAMIL_NAME_LENGTH = "Tamil name must not exceed 100 character";
    public static final String CUSTOMER_ADDRESS_LENGTH = "Address must not exceed 255 character";
    public static final String CUSTOMER_CITY_LENGTH = "City must not exceed 100 character";
    public static final String CUSTOMER_PHONE_PATTERN = "Phone number must be 10 digit numeric value";
    public static final String CUSTOMER_OLDBALANCE_GREATER_THAN_ZERO = "Old balance must be greater than or equal to 0.00";
    public static final String CUSTOMER_CURRBALANCE_GREATER_THAN_ZERO = "Current balance must be greater than or equal to 0.00";
    public static final String CUSTOMER_COMMISSION_GREATER_THAN_ZERO = "Commission 1 must be greater than or equal to 0.00";

    // public static final String

}
